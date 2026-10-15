package br.com.fiap.recipeplan.service;

import br.com.fiap.recipeplan.model.Recipe;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecipeService {

    private final ChatClient chatClient;

    public RecipeService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public Recipe getRecipe(String dishName) {
        String systemPrompt = """
            Você é um chef de cozinha experiente.
            Sua função é fornecer receitas apenas para alimentos, pratos e preparações culinárias reais e comestíveis.

            Diretrizes:
            1. Se o termo solicitado for um nome de pessoa, objeto, palavra aleatória ou qualquer coisa que NÃO seja comida:
               - name: "Prato não encontrado"
               - description: "O termo informado ('" + dishName + "') não corresponde a um alimento ou prato culinário."
               - ingredients: lista vazia []
               - instructions: "Por favor, digite o nome de uma comida ou receita válida (ex.: 'Lasanha', 'Ovo frito', 'Bolo de cenoura')."
            
            2. Se o termo solicitado for um prato ou alimento válido:
               - name: nome da receita
               - description: breve descrição convidativa do prato
               - ingredients: lista estruturada de ingredientes com:
                 * name: nome do ingrediente
                 * quantity: quantidade numérica ou fracionada (ex: "1", "200", "1/2")
                 * unit: unidade de medida (ex: "unidade", "colher de sopa", "gramas", "xícara")
               - instructions: passo a passo detalhado do modo de preparo em texto corrido.

            3. Não gere campos de identificador ou 'id'.
            
            Responda sempre em português.
            """;

        Recipe recipe = chatClient.prompt()
                .system(systemPrompt)
                .user(dishName)
                .call()
                .entity(Recipe.class);

        // Garante que a lista de ingredientes nunca seja nula para a View não falhar
        if (recipe != null && recipe.getIngredients() == null) {
            recipe.setIngredients(new ArrayList<>());
        }

        return recipe;
    }
}