const API_URL = 'http://localhost:8080';
let currentGameId = null;
let currentPlayerId = null;
let currentPlayerName = '';
let gameEnded = false;

// Elementos do DOM
const loginScreen = document.getElementById('loginScreen');
const gameScreen = document.getElementById('gameScreen');
const playerNameInput = document.getElementById('playerName');
const playerNameDisplay = document.getElementById('playerNameDisplay');
const guessInputs = Array.from(document.querySelectorAll('.guess-box'));
const attemptsHistory = document.getElementById('attemptsHistory');
const attemptsDisplay = document.getElementById('attempts');
const messageDiv = document.getElementById('message');
const endGameScreen = document.getElementById('endGameScreen');
const endGameMessage = document.getElementById('endGameMessage');

// Função auxiliar para extrair mensagem de erro da resposta
async function getErrorMessage(response) {
    const fallback = `Erro ${response.status}${response.statusText ? ` - ${response.statusText}` : ''}`;

    try {
        const contentType = response.headers.get('content-type') || '';

        if (contentType.includes('application/json')) {
            const errorData = await response.json();
            return (
                errorData.message ||
                errorData.detail ||
                errorData.error ||
                errorData.title ||
                fallback
            );
        }

        const text = (await response.text()).trim();
        if (!text) return fallback;

        // Tenta extrair um texto útil caso a API devolva HTML ou uma string simples
        const stripped = text
            .replace(/<[^>]*>/g, ' ')
            .replace(/\s+/g, ' ')
            .trim();

        return stripped || fallback;
    } catch (e) {
        return fallback;
    }
}

// Permitir submit com Enter
playerNameInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') startGame();
});

function getGuessFromInputs() {
    return guessInputs.map((input) => input.value.trim().toUpperCase()).join('');
}

function clearGuessInputs() {
    guessInputs.forEach((input) => (input.value = ''));
}

function focusGuessInput(index = 0) {
    const input = guessInputs[index];
    if (input) input.focus();
}

function setGuessInputsDisabled(disabled) {
    guessInputs.forEach((input) => {
        input.disabled = disabled;
    });
}

function bindGuessInputs() {
    guessInputs.forEach((input, index) => {
        input.addEventListener('keydown', (e) => {
            if (gameEnded) return;

            if (e.key === 'Backspace') {
                if (!input.value && index > 0) {
                    guessInputs[index - 1].focus();
                    guessInputs[index - 1].value = '';
                    e.preventDefault();
                }
                return;
            }

            if (e.key === 'Enter') {
                e.preventDefault();
                makeGuess();
                return;
            }
        });

        input.addEventListener('input', (e) => {
            if (gameEnded) return;

            const value = e.target.value.toUpperCase().replace(/[^A-ZÀ-ÿ]/g, '').slice(-1);
            e.target.value = value;

            if (value && index < guessInputs.length - 1) {
                guessInputs[index + 1].focus();
            }
        });

        input.addEventListener('paste', (e) => {
            if (gameEnded) return;

            e.preventDefault();
            const text = (e.clipboardData || window.clipboardData).getData('text')
                .toUpperCase()
                .replace(/[^A-ZÀ-ÿ]/g, '')
                .slice(0, guessInputs.length);

            text.split('').forEach((char, i) => {
                if (guessInputs[i]) guessInputs[i].value = char;
            });

            const nextIndex = Math.min(text.length, guessInputs.length - 1);
            focusGuessInput(nextIndex);
        });
    });
}

bindGuessInputs();

function resetGuessState() {
    clearGuessInputs();
    setGuessInputsDisabled(false);
    focusGuessInput(0);
}

async function startGame() {
    const name = playerNameInput.value.trim();

    if (!name) {
        showMessage('Por favor, digite seu nome', 'error');
        return;
    }

    showMessage('Criando jogador...', 'info');

    try {
        // Criar jogador
        const playerResponse = await fetch(`${API_URL}/players`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name })
        });

        if (!playerResponse.ok) {
            const errorMessage = await getErrorMessage(playerResponse);
            throw new Error(errorMessage);
        }

        const player = await playerResponse.json();
        currentPlayerId = player.id;
        currentPlayerName = player.name;

        // Iniciar jogo
        const gameResponse = await fetch(`${API_URL}/games/start`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ playerId: player.id })
        });

        if (!gameResponse.ok) {
            const errorMessage = await getErrorMessage(gameResponse);
            throw new Error(errorMessage);
        }

        const game = await gameResponse.json();
        currentGameId = game.id;
        gameEnded = false;

        // Mostrar tela do jogo
        playerNameDisplay.textContent = currentPlayerName;
        loginScreen.classList.add('hidden');
        gameScreen.classList.remove('hidden');
        attemptsHistory.innerHTML = '';
        attemptsDisplay.textContent = '0';
        messageDiv.classList.add('hidden');
        endGameScreen.classList.add('hidden');
        resetGuessState();

        showMessage('Jogo iniciado! Boa sorte!', 'success');
    } catch (error) {
        console.error('Erro:', error);
        showMessage(`Erro: ${error.message}`, 'error');
    }
}

async function makeGuess() {
    const guess = getGuessFromInputs();

    if (guess.length !== 5) {
        showMessage('Preencha as 5 letras!', 'error');
        return;
    }

    if (guessInputs.some((input) => !input.value.trim())) {
        showMessage('Preencha as 5 letras!', 'error');
        return;
    }

    if (gameEnded) {
        showMessage('Jogo terminado! Clique em "Jogar Novamente"', 'error');
        return;
    }

    try {
        const response = await fetch(`${API_URL}/games/${currentGameId}/guess`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ word: guess })
        });

        if (!response.ok) {
            const errorMessage = await getErrorMessage(response);
            throw new Error(errorMessage);
        }

        const result = await response.json();
        const attempts = result.attempts;
        const won = result.won;
        const feedback = result.feedback;

        // Adicionar tentativa ao histórico
        addAttemptToHistory(guess, feedback);
        attemptsDisplay.textContent = attempts;
        clearGuessInputs();
        focusGuessInput(0);

        if (won) {
            showEndGame(true, attempts);
        } else if (attempts >= 6) {
            showEndGame(false, attempts);
        } else {
            showMessage('Tente novamente!', 'info');
            focusGuessInput(0);
        }

    } catch (error) {
        console.error('Erro:', error);
        showMessage(`Erro: ${error.message}`, 'error');
    }
}

function addAttemptToHistory(word, feedback) {
    const attemptDiv = document.createElement('div');
    attemptDiv.className = 'bg-gray-700 p-3 rounded text-center';

    let html = "";
    html += '<div class="flex justify-center gap-1 text-2xl">';

    for (let i = 0; i < feedback.length; i++) {
        const letter = word[i];
        const code = feedback[i];

        let bgColor = '';
        if (code === 'V') {
            // Verde - correto na posição
            bgColor = 'bg-green-500';
        } else if (code === 'A') {
            // Amarelo - letra correta mas posição errada
            bgColor = 'bg-yellow-500';
        } else if (code === 'C') {
            // Cinza - letra não existe
            bgColor = 'bg-gray-500';
        }

        html += `<div class="${bgColor} w-10 h-10 flex items-center justify-center rounded font-bold text-white">${letter}</div>`;
    }

    html += '</div>';

    attemptDiv.innerHTML = html;
    attemptsHistory.appendChild(attemptDiv);
}

function showMessage(text, type) {
    messageDiv.textContent = text;
    messageDiv.classList.remove('hidden');
    messageDiv.className = `text-center text-lg font-semibold mt-4 p-3 rounded ${
        type === 'success' ? 'text-green-400 bg-green-900 bg-opacity-30' :
            type === 'error' ? 'text-red-400 bg-red-900 bg-opacity-30' :
                'text-blue-400 bg-blue-900 bg-opacity-30'
    }`;
}

function showEndGame(won, attempts) {
    gameEnded = true;
    setGuessInputsDisabled(true);

    if (won) {
        endGameMessage.textContent = `🎉 Você venceu em ${attempts} tentativa${attempts > 1 ? 's' : ''}!`;
        endGameMessage.className = 'text-3xl font-bold mb-4 text-green-400';
    } else {
        endGameMessage.textContent = '😢 Você perdeu! Máximo de tentativas atingido.';
        endGameMessage.className = 'text-3xl font-bold mb-4 text-red-400';
    }

    endGameScreen.classList.remove('hidden');
}

function restartGame() {
    startGame();
}

function goToLogin() {
    loginScreen.classList.remove('hidden');
    gameScreen.classList.add('hidden');
    playerNameInput.value = '';
    playerNameInput.focus();
    currentGameId = null;
    currentPlayerId = null;
}

// Focus no input ao carregar
playerNameInput.focus();

