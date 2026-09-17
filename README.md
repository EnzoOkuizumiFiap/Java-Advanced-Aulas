# ☕ Java Advanced — Aulas & Projetos (3º / 4º Semestre - FIAP)

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17" />
  <img src="https://img.shields.io/badge/Spring_Boot-3.x_/_4.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/Spring_Cloud-Netflix_Eureka-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Cloud" />
  <img src="https://img.shields.io/badge/Build-Maven_%7C_Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white" alt="Build Tools" />
  <img src="https://img.shields.io/badge/Database-PostgreSQL_%7C_H2_%7C_Flyway-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" alt="Databases" />
  <img src="https://img.shields.io/badge/Security-OAuth2_%7C_JWT_RSA_%7C_BCrypt-black?style=for-the-badge&logo=jsonwebtokens&logoColor=white" alt="Security" />
  <img src="https://img.shields.io/badge/Testing-k6_Load_Testing-7D64FF?style=for-the-badge&logo=k6&logoColor=white" alt="k6 Testing" />
  <img src="https://img.shields.io/badge/Institution-FIAP-ED145B?style=for-the-badge" alt="FIAP" />
</p>

Repositório central de estudos, exercícios, checkpoints e arquiteturas desenvolvidas ao longo da disciplina de **Java Advanced** nos **3º e 4º semestres da FIAP**.

A trilha cobre uma jornada de amadurecimento técnico completa:
- **3º Semestre (Aulas 01 a 25):** Consolidação de **POO com JavaFX desktop**, transição para **APIs RESTful com Spring Boot**, **Mapeamento Objeto-Relacional (JPA/Hibernate)**, **DTOs & Injeção por Construtor**, **Validações customizadas complexas com Bean Validation**, **Arquitetura Orientada a Domínio (Package by Feature)**, **HATEOAS (Nível 3 de Richardson)**, **Cache com Spring Cache** e **Documentação/Observabilidade (Swagger OpenAPI & Actuator)**, integrando os **Checkpoints 01, 02 e 03 do Projeto Animes**.

- **4º Semestre (Aulas 26 a 36):** Migração para **Gradle (Groovy DSL)** e **Spring Boot 4.x**, **Segurança corporativa Stateless com Spring Security e JWT assinado por chaves assimétricas RSA**, **Controle de Acesso RBAC (Role-Based Access Control) & Hash com BCrypt**, **Migrações de banco em produção com Flyway e Docker (PostgreSQL)**, **Clientes HTTP declarativos modernos (`@HttpExchange`)**, culminando em uma **Arquitetura de Microsserviços Distribuídos com Service Discovery (Eureka), Balanceamento de Carga Client-Side, Prevenção de Race Conditions com Locks Pessimistas no Banco de Dados e Resiliência com Retry, Exponential Backoff e Jitter**.

---

## 🗺️ Trilha Evolutiva dos Semestres

```
========================================================================================
📅 4º SEMESTRE (Ago/2026 – Set/2026): SEGURANÇA STATELESS, DEVOPS & MICROSSERVIÇOS
========================================================================================
[Aula 35-36] MICROSSERVIÇOS & RESILIÊNCIA CRÍTICA (Ticket System):
              Eureka Service Discovery, RestTemplate @LoadBalanced, Testes de Concorrência com k6,
              Locks Pessimistas contra Race Conditions, Retry com Exponential Backoff & Jitter
     ▲
     │
[Aula 32-34] Persistência Corporativa & Cloud Ready: Flyway Migrations, PostgreSQL via Docker & HTTP Interfaces
     │        (Weather Planner, Cripto Planner, Board Vault)
     ▲
     │
[Aula 26-31] Spring Security 6+ & Gradle: Chain of Responsibility, JWT Assimétrico RSA, RBAC & BCrypt
              (Spy Agency, MyPass, FIAP Movies Auth, Car Sale)

========================================================================================
📅 3º SEMESTRE (Fev/2026 – Jun/2026): FUNDAMENTOS, REST, ARQUITETURA & ALTA MATURIDADE
========================================================================================
[Aula 25]    PROJETO ANIMES (3 de 3 - Checkpoint 03): Síntese com HATEOAS, Cache, Actuator & OpenAPI
     ▲
     │
[Aula 21-24] Alta Maturidade REST: Spring Cache, Documentação OpenAPI/Swagger, Actuator & HATEOAS Nível 3 Manual
     │        (Termo, Cervejaria, Services, Game Finder)
     ▲
     │
[Aula 19-20] PROJETO ANIMES (2 de 3 - Checkpoint 02): Multi-domínio & 5 Validadores Customizados
     ▲
     │
[Aula 14-17] Engenharia de Software: DTOs, @RequiredArgsConstructor, Validações Customizadas (CPF/CNPJ, @Adult),
     │        Arquitetura por Domínio (Package by Feature) e Spring Data REST (E-Commerce, Character, Music)
     ▲
     │
[Aula 12-13] PROJETO ANIMES (1 de 3 - Checkpoint 01): Relacionamentos 1:N & Enums
     ▲
     │
[Aula 04-11] Introdução Spring Boot REST, Status Semânticos & JPA/H2 (Movies, Heroes, Dragons, Expenses)
     ▲
     │
[Aula 01-03] JavaFX Desktop & POO Avançada (Vinte e Um)
```

---

## 📋 Índice Geral dos Projetos (Do Mais Recente ao Inicial)

### 📅 4º Semestre — Segurança, DevOps & Microsserviços (Aulas 26 a 36)

| # | Projeto | Aulas | Foco Principal | Build | Pasta |
|:---:|---|:---:|---|:---:|:---:|
| **23** | [Ticket System (Microsserviços)](#projeto-23) | Aulas 35-36 | Eureka, Load Balancing, Pessimistic Lock, Resiliência & k6 | Gradle | [`/ticket-system`](./ticket-system) |
| **22** | [Board Vault](#projeto-22) | Aula 34 | Catálogo de jogos de tabuleiro, versionamento DDL com Flyway | Gradle | [`/board-vault`](./board-vault) |
| **21** | [Cripto Planner](#projeto-21) *(Evolução)* | Aula 33 | Consumo declarativo de APIs Cripto com REST Client *(Evolução do Proj 20)* | Gradle | [`/cripto-planner`](./cripto-planner) |
| **20** | [Weather Planner](#projeto-20) *(Base)* | Aula 32 | Flyway Migrations, Docker (Postgres real) & `@HttpExchange` *(Origem do Proj 21)* | Gradle | [`/weather-planner`](./weather-planner) |
| **19** | [Car Sale](#projeto-19) | Aulas 31-32 | Venda de veículos, comentários moderados & Lição do hashing | Gradle | [`/car-sale`](./car-sale) |
| **18** | [FIAP Movies Auth](#projeto-18) *(Evolução)* | Aula 30 | RBAC (Role-Based Access Control), BCrypt & Claims no JWT *(Evolução do Proj 02)* | Gradle | [`/fiap-movies`](./fiap-movies) |
| **17** | [MyPass](#projeto-17) | Aula 29 | Cofre de senhas com autenticação Bearer Token JWT | Gradle | [`/mypass`](./mypass) |
| **16** | [Spy Agency](#projeto-16) | Aulas 26-28 | Migração Gradle, Spring Security, JWT com Chaves Assimétricas RSA | Gradle | [`/spy`](./spy) |

---

### 📅 3º Semestre — Fundamentos, REST & Alta Maturidade (Aulas 01 a 25)

| # | Projeto | Aulas | Foco Principal | Build | Pasta |
|:---:|---|:---:|---|:---:|:---:|
| **15** | [Projeto Animes `[3 de 3]`](#projeto-15) | Aula 25 | **Checkpoint 03**: Síntese com Domínio, HATEOAS, Cache, OpenAPI & Actuator | Maven | [`/projeto-anime 3`](./projeto-anime%203) |
| **14** | [Game Finder](#projeto-14) | Aula 24 | Catálogo de Jogos com links navegáveis HATEOAS & Domínio | Maven | [`/game-finder`](./game-finder) |
| **13** | [Services](#projeto-13) | Aula 23 | Spring HATEOAS Manual (Maturidade Richardson Nível 3) | Maven | [`/services`](./services) |
| **12** | [Cervejaria API](#projeto-12) | Aula 22 | Cache-Aside, Documentação OpenAPI viva & Observabilidade | Maven | [`/cervejaria`](./cervejaria) |
| **11** | [Termo API](#projeto-11) | Aula 21 | Clone do Termo/Wordle, Spring Cache, Swagger UI & Actuator | Maven | [`/termo`](./termo) |
| **10** | [Projeto Animes `[2 de 3]`](#projeto-10) | Aulas 19-20 | **Checkpoint 02**: Multi-domínio, 35 classes, 5 Validadores customizados | Maven | [`/projeto-anime 2`](./projeto-anime%202) |
| **09** | [Music Catalog](#projeto-09) | Aula 17 | Spring Data REST, HATEOAS automático, DataLoader & Projections | Maven | [`/music`](./music) |
| **08** | [Character](#projeto-08) | Aulas 16-17 | Refatoração para Arquitetura por Domínio (Package by Feature) | Maven | [`/character`](./character) |
| **07** | [E-Commerce](#projeto-07) | Aulas 14-15 | DTOs, `@RequiredArgsConstructor`, Anotações customizadas & CPF/CNPJ | Maven | [`/e-commerce`](./e-commerce) |
| **06** | [Projeto Animes `[1 de 3]`](#projeto-06) | Aulas 12-13 | **Checkpoint 01**: Relacionamentos `@OneToMany` e regras de negócio | Maven | [`/projeto-anime 1`](./projeto-anime%201) |
| **05** | [Expense Tracker](#projeto-05) | Aula 11 | Gestão de despesas com Spring Data JPA & JpaRepository | Maven | [`/expense-tracker`](./expense-tracker) |
| **04** | [Dragons API](#projeto-04) | Aula 09 | Exercício de CRUD, Delete idempotente e boas práticas HTTP | Maven | [`/dragons`](./dragons) |
| **03** | [Heroes API](#projeto-03) | Aula 06 | Endpoints REST, Coleções em memória & CORS | Maven | [`/heroes`](./heroes) |
| **02** | [Movies API](#projeto-02) *(Base)* | Aulas 04-10 | Introdução ao Spring Boot, REST, ResponseEntity, JPA & H2 *(Evolui no Proj 18)* | Maven | [`/movies`](./movies) |
| **01** | [Jogo 21 (Vinte e Um)](#projeto-01) | Aulas 01-03 | JavaFX Desktop, FXML, POO e Regras de Cartas | Maven | [`/vinteeum`](./vinteeum) |

---

## 🔍 Detalhamento dos Projetos (Ordem Decrescente)

---

<a id="projeto-23"></a>
### Projeto 23 — Ticket System (Microsserviços & Resiliência)
> **Aulas:** Aula 35 e 36 (4º Semestre) | **Pasta:** [`/ticket-system`](./ticket-system) | **Build:** Gradle Multi-Project

#### 📖 O que foi feito
**O auge da complexidade técnica e arquitetural da disciplina!** Um ecossistema completo de **Microsserviços Distribuídos** voltado para venda de ingressos sob altíssima concorrência.
O projeto resolve na prática problemas clássicos de sistemas distribuídos: descoberta dinâmica de serviços com **Eureka Server**, balanceamento de carga client-side via **RestTemplate com `@LoadBalanced`**, e prevenção absoluta de **Race Conditions (Condições de Corrida)** na compra de ingressos através de **Locks Pessimistas no Banco de Dados** (`@Lock(LockModeType.PESSIMISTIC_WRITE)`) e transações atômicas com **Dirty Checking do Hibernate**, contando com resiliência distribuída via **Retry, Exponential Backoff e Jitter**!

O ecossistema é composto por 3 microsserviços + suíte de teste de corrida com **k6**:
1. **`service-descover`**: Servidor de Descoberta Netflix Eureka Server (`@EnableEurekaServer`, porta `8761`).
2. **`ticket-service`**: Microsserviço de gestão e compra de ingressos (`Eureka Client`), protegido contra concorrência com `@Lock(LockModeType.PESSIMISTIC_WRITE)` na query `findByIdForUpdate` e `@Transactional`. Inclui simulação de concorrência com `Thread.sleep(500)`.
3. **`payment-service`**: Microsserviço distribuído para validação e processamento de pagamentos.
4. **`purchase-race-test.js`**: Script de teste de estresse e concorrência executado via **k6**, simulando 50 usuários simultâneos disparando requisições no mesmo segundo.

#### 💬 Bastidores dos Commits
- `e6014e1`: *Aula 35 - Projeto Ticket / Tópicos de Resiliência, Race Condition (Que foi resolvido com Transaction (Service) e Lock (Repository), Retryable com Delay, Jitter, Exponential Backoff, Escalabilidade com Instâncias, Service Discovery, Load Balance, MICROSERVIÇO!!!* — O commit mais épico do semestre, resumindo a vitória sobre condições de corrida e a montagem da arquitetura distribuída!
- `96da5d2`: *Aula 36 - CampusGIGS (Repo do Barros) Apenas arrumei algumas coisas do meu Repo!! E não teve aula de Java...* — Alinhamentos e manutenção do repositório.

#### 📚 Assuntos e Conceitos
- Arquitetura de Microsserviços com Spring Cloud Netflix Eureka
- Service Discovery & Registration (instâncias registrando-se dinamicamente no catálogo)
- Client-Side Load Balancing na comunicação entre microsserviços via `RestTemplate` com `@LoadBalanced`
- **Race Condition & Concurrency Control**: Como resolver o problema de duas pessoas comprarem o último ingresso disponível
- **Pessimistic Locking**: Bloqueio de linha no banco (`SELECT ... FOR UPDATE` via `@Lock(LockModeType.PESSIMISTIC_WRITE)`) garantindo acesso serializado ao estoque
- Transações atômicas com `@Transactional` aproveitando o Dirty Checking do Hibernate (o estado é persistido automaticamente ao fechar a transação sem necessidade de `.save()`)
- Janela de teste de concorrência com `Thread.sleep(500)`
- **Padrões de Resiliência**:
  - **Retry**: Novas tentativas automáticas em caso de falha transitória
  - **Exponential Backoff**: Aumento exponencial no tempo de espera entre tentativas
  - **Jitter**: Variação aleatória no tempo de espera para evitar o "efeito manada" (Thundering Herd Problem)
- Testes de concorrência e carga de alta precisão com **k6**

#### 🛠️ Tecnologias
- Spring Cloud Netflix Eureka Server (`spring-cloud-starter-netflix-eureka-server`)
- Spring Cloud Netflix Eureka Client (`spring-cloud-starter-netflix-eureka-client`)
- Spring Boot 4.1.1 & Gradle Multi-project
- Spring Data JPA & H2 Database
- Spring Web (RestTemplate `@LoadBalanced`)
- **k6** (ferramenta de teste de carga e concorrência)

#### 📐 Padrões de Projeto
- **Microservices Architecture**: Separação em serviços autônomos com responsabilidades delimitadas.
- **Service Registry / Discovery Pattern**: Registro dinâmico de instâncias com Eureka.
- **Client-Side Load Balancing**: Escolha inteligente da instância de destino pelo cliente.
- **Pessimistic Lock Pattern**: Garantia de consistência estrita em dados concorrentes.
- **Retry Pattern with Exponential Backoff & Jitter**: Tolerância a falhas distribuídas sem colapso dos nós.

---

<a id="projeto-22"></a>
### Projeto 22 — Board Vault
> **Aulas:** Aula 34 (4º Semestre) | **Pasta:** [`/board-vault`](./board-vault) | **Build:** Gradle

#### 📖 O que foi feito
Cofre e catálogo para amantes de Jogos de Tabuleiro (Board Games). Foco total na excelência de versionamento de banco de dados corporativo com Flyway no PostgreSQL real, garantindo que todas as tabelas, índices e dados iniciais sejam aplicados através de migrações DDL versionadas (`V1__create_table_boardgames.sql` e `V2__create_games.sql`).

#### 💬 Bastidores dos Commits
- `815299a`: *Aula 34 - Projeto Board Vault (Flyway, postgres, migrations)*

#### 📚 Assuntos e Conceitos
- Flyway Migrations aplicado em projetos corporativos
- PostgreSQL real como repositório de produção
- Configuração de profiles e validação de migrações na inicialização da aplicação
- CRUD completo de jogos de tabuleiro com RestClient

#### 🛠️ Tecnologias
- Spring Boot 4.1.1 & Gradle
- Flyway Database Migration
- PostgreSQL (`flyway-database-postgresql`)
- Spring Data JPA & RestClient

#### 📐 Padrões de Projeto
- **Database Migration Pattern**.
- **Repository Pattern**.

---

<a id="projeto-21"></a>
### Projeto 21 — Cripto Planner
> **Aulas:** Aula 33 (4º Semestre) | **Pasta:** [`/cripto-planner`](./cripto-planner) | **Build:** Gradle  
> 🔗 *Conexão de Continuidade: Aplicação prática do padrão `@HttpExchange` introduzido no [Projeto 20 (Weather Planner)](#projeto-20), migrando do domínio meteorológico para cotações de criptoativos.*

#### 📖 O que foi feito
Exercício prático de consolidação de clientes HTTP declarativos. Integra com o serviço externo da **CoinGecko API** (`https://api.coingecko.com/api/v3/coins/{id}`) utilizando `@HttpExchange`, converte os dados recebidos via DTOs tipados e implementa regras de negócio para recomendação de aportes financeiros em Bitcoin, Ethereum e Dogecoin com base na variação de preço nas últimas 24h.

#### 💬 Bastidores dos Commits
- `a1c21e0`: *Aula 33 - Exercício cripto-planner*

#### 📚 Assuntos e Conceitos
- Consumo de serviços financeiros e cotações de criptoativos via CoinGecko
- Interface declarativa `CoinService`: `@HttpExchange` e `@GetExchange("/{id}")`
- Lógica de avaliação com `switch` expressions:
  - `"Comprar Bitcoin"`: Avalia variação percentual de preço das últimas 24h
  - `"Vender Ethereum"`: Avalia oportunidade de realização de lucros
  - `"Investir em Dogecoin"`: Alerta sobre volatilidade e ativos de risco
- Desacoplamento de dados externos com DTOs (`CoinResponse`, `PlannerResponse`)

#### 🛠️ Tecnologias
- Spring Boot 4.1.1 & Gradle
- Spring Data JPA & Spring Web MVC
- Spring RestClient (`@HttpExchange`)

#### 📐 Padrões de Projeto
- **Declarative REST Client Pattern**.
- **DTO Pattern & Separation of Concerns**.

---

<a id="projeto-20"></a>
### Projeto 20 — Weather Planner
> **Aulas:** Aula 32 (4º Semestre) | **Pasta:** [`/weather-planner`](./weather-planner) | **Build:** Gradle  
> 🔗 *Conexão de Continuidade: Introduz o padrão de clientes declarativos `@HttpExchange`, que é aprofundado no [Projeto 21 (Cripto Planner)](#projeto-21).*

#### 📖 O que foi feito
Planejador de atividades com base na previsão meteorológica. Marca a transição para **ambientes de produção reais**: abandono do banco H2 em favor de um **PostgreSQL real em container Docker**, versionamento formal do esquema com **Flyway Database Migrations** (`V1__create_table_log.sql`, `V2_alter_table_log_add_location_column.sql`) e consumo de APIs externas utilizando a nova feature declarativa do Spring: **HTTP Interfaces (`@HttpExchange`)**.

#### 💬 Bastidores dos Commits
- `575d339`: *Aula 32 - Flyway, Docker, HttpExchange / E também criação de log e switch case no PlannerService* — Configuração do Flyway, criação de migrações SQL versionadas e implementação do cliente declarativo de tempo.

#### 📚 Assuntos e Conceitos
- Versionamento de banco corporativo com Flyway (`V1`, `V2`)
- Containerização e execução de PostgreSQL via Docker
- Modern Spring HTTP Interfaces: consumo da API da Open-Meteo com interfaces anotadas com `@HttpExchange` e `@GetExchange`
- Lógica de decisão com `switch` expressions do Java 17 no `PlannerService` (`"Viajar de Balão"`, `"Ver as estrelas"`, `"Ir a praia"`)
- Registro e auditoria de consultas meteorológicas no banco de dados (`LogService`)

#### 🛠️ Tecnologias
- Spring Boot 4.1.1 & Gradle
- Flyway Database Migration (`flyway-database-postgresql`)
- PostgreSQL (Docker)
- Spring RestClient & HTTP Interfaces (`@HttpExchange`)
- Spring Data JPA

#### 📐 Padrões de Projeto
- **Database Migration Pattern**: Controle de evolução de banco de dados sem perdas ou scripts manuais soltos.
- **Declarative HTTP Client Pattern**: Geração automática de clientes de API a partir de interfaces tipadas.
- **Audit Logging Pattern**.

---

<a id="projeto-19"></a>
### Projeto 19 — Car Sale
> **Aulas:** Aula 31 e 32 (4º Semestre) | **Pasta:** [`/car-sale`](./car-sale) | **Build:** Gradle

#### 📖 O que foi feito
Plataforma de venda de automóveis com sistema de comentários e moderação. Projeto que consolidou a autenticação RBAC, separação por domínios (`car`, `comments`, `user`), tratamento de exceções com DTOs de erro e uma das lições práticas mais marcantes do semestre sobre fluxo de autenticação e hashing de senhas.

#### 💬 Bastidores dos Commits & Código
- `a02d976`: *Aula 31 - Exercício Car Sale (QUEBREI A CABEÇA POR MAIS DE 1H30, pois estava colocando a senha encriptada no web)* — Um registro sincero e valioso: o desenvolvedor aprendeu na prática que **a senha em texto puro deve ser enviada pelo cliente via HTTPS para que o `PasswordEncoder.matches(...)` do Spring Security compare com o hash do banco**; jamais envie a senha já com hash na requisição de login!
- **Comentário literal deixado na classe `SecurityConfig.java` (linha 53):**
  > `// ERA SÓ ADICIONAR ESSA LINHA`  
  > `@Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }`

#### 📚 Assuntos e Conceitos
- Fluxo correto de validação de senhas com `BCrypt`: como o `PasswordEncoder` gera e compara hashes
- Sistema de comentários moderados vinculados a anúncios de veículos
- Tratamento de exceções personalizadas (`CarNotFoundException`, `CommentNotFoundException`)
- Respostas de erro padronizadas com `ErrorHandler`

#### 🛠️ Tecnologias
- Spring Boot 4.1.0 & Gradle
- Spring Security OAuth2 Resource Server & BCrypt
- Spring Data JPA & Bean Validation
- H2 Database

#### 📐 Padrões de Projeto
- **Domain-Driven Packaging (`car`, `comments`, `user`)**.
- **Centralized Exception Handling (`ErrorHandler`)**.
- **RBAC com Claims no JWT**.

---

<a id="projeto-18"></a>
### Projeto 18 — FIAP Movies Auth
> **Aulas:** Aula 30 (4º Semestre) | **Pasta:** [`/fiap-movies`](./fiap-movies) | **Build:** Gradle  
> 🔗 *Conexão de Continuidade: Evolução direta do [Projeto 02 (Movies API)](#projeto-02), integrando autenticação avançada, controle de acesso RBAC e gerenciamento de Watchlist por usuário.*

#### 📖 O que foi feito
A releitura madura do domínio de filmes. O projeto integra autenticação e autorização robusta com **RBAC (Role-Based Access Control)**. As senhas passaram a ser protegidas com hash matemático irreversível utilizando **BCrypt**, e as permissões de acesso foram configuradas com anotações `@PreAuthorize` e conversores de claims customizados no token JWT.

#### 💬 Bastidores dos Commits
- `d051c9a`: *Aula 30 - PasswordEncoder (BCrypt), jwtAuthenticationConverter (+ oauth2ResourceServer), requestMatchers OU PreAuthorize para acessar por Role, AuthService com UserDetailsService e loadUserByUsername retornando username, password e roles, TokenService -> JwtClaimsSet com subject (getUsername) / claim (getRole)*
- *(Ajustes adicionais sincronizados em conjunto com o Car Sale em `a02d976`).*

#### 📚 Assuntos e Conceitos
- Hash seguro de senhas com `BCryptPasswordEncoder` (salgamento e fator de custo computacional)
- Criação e personalização de Claims de roles no payload do JWT
- Implementação de `JwtAuthenticationConverter` para transformar claims do JWT em `GrantedAuthority` do Spring Security (prefixo `ROLE_`)
- Implementação de `UserDetailsService` customizado para buscar usuários do banco de dados
- Autorização granular nos métodos com `@PreAuthorize` e nas URLs com `requestMatchers`
- Gestão de Watchlist vinculada ao usuário autenticado (`WatchlistEntry`, `WatchlistStatus`)

#### 🛠️ Tecnologias
- Spring Boot 4.1.0 & Gradle
- Spring Security & OAuth2 Resource Server
- BCrypt
- Spring Data JPA & H2 Database

#### 📐 Padrões de Projeto
- **RBAC (Role-Based Access Control)**.
- **Converter Pattern**: `JwtAuthenticationConverter` adaptando os claims do token para a infraestrutura do Spring.
- **Adapter Pattern**: Implementação de `UserDetails` sobre a entidade `User`.

---

<a id="projeto-17"></a>
### Projeto 17 — MyPass
> **Aulas:** Aula 29 (4º Semestre) | **Pasta:** [`/mypass`](./mypass) | **Build:** Gradle

#### 📖 O que foi feito
Cofre virtual seguro para gerenciamento de credenciais e senhas (MyPass). Aplica a autenticação JWT em um caso de uso de alta sensibilidade, onde endpoints públicos (como login) são explicitamente liberados enquanto os endpoints do cofre exigem Bearer Token válido.

#### 💬 Bastidores dos Commits
- `15674e5`: *Aula 29 - Projeto MyPass (ERA MAIS FÁCIL DO QUE EU PENSAVA, compliquei à toa)* — O momento clássico de iluminação do desenvolvedor ao perceber a elegância do Spring Security quando configurado da maneira correta!

#### 📚 Assuntos e Conceitos
- Proteção de endpoints de alta criticidade (cofre de senhas)
- Roteamento seguro: liberação granular de rotas públicas (`/login`) e fechamento das demais com `authenticated()`
- Configuração de CORS integrada com as regras do `SecurityFilterChain`
- `AuthenticationManager` e gerenciamento de usuários em memória com `InMemoryUserDetailsManager`

#### 🛠️ Tecnologias
- Spring Boot 4.1.0 & Gradle
- Spring Security & OAuth2 Resource Server
- Spring Data JPA & H2 Database

#### 📐 Padrões de Projeto
- **Bearer Token Pattern**.
- **Least Privilege Access**: Proteção padrão estrita para todas as rotas do cofre.

---

<a id="projeto-16"></a>
### Projeto 16 — Spy Agency
> **Aulas:** Aula 26 a 28 (4º Semestre) | **Pasta:** [`/spy`](./spy) | **Build:** Gradle

#### 📖 O que foi feito
Início do módulo intensivo de **Segurança da Informação e Arquitetura Moderna** no 4º Semestre. Marca a transição para **Gradle (Groovy DSL)** e para o **Spring Boot 4.x**. O projeto começou com segurança básica (HTTP Basic) e evoluiu rapidamente para uma arquitetura **Stateless com OAuth2 Resource Server e autenticação JWT assinada por par de chaves criptográficas assimétricas RSA**!

#### 💬 Bastidores dos Commits & Código
- `b5ddc22`: *Aula 26 - Tipo Projeto Gradle - Groovy, Básico de Spring Security, Configurando Credenciais Básicas Spring Security, Fazendo GET/POST simples com Auth*
- `5c09baf`: *Aula 27 - SecurityFilterChain, Chain of Responsibility, AuthController (com endpoint para login)*
- `a8eb55a`: *Aula 28 - JWT, JWT Decoder/Encoder, NimbusJwtDecoder/Encoder, RSAKey, JWKSet, TokenService para gerar um Token com as infos do usuário, Usando credenciais do Authorization (api.http) para logar*
- **Anotação literal presente no código do desenvolvedor (`SecurityConfig.java`):**
  > *"SecurityFilterChain: Segue o padrão Chain of Responsibility: em vez de concentrar muitas verificações em vários ifs, cada filtro possui uma responsabilidade, como autenticação, autorização e validação de tokens... Chain of Responsibility (Cadeia de Responsabilidade): box -> box -> box -> box. E ele é um design pattern ^^"*

#### 📚 Assuntos e Conceitos
- Migração de ferramenta de build: do Maven para o Gradle (Groovy DSL)
- Arquitetura do Spring Security 6+: configuração baseada em componentes com `SecurityFilterChain`
- Padrão Chain of Responsibility nos filtros de requisição HTTP
- Criptografia Assimétrica: geração de chave pública e privada RSA (`RSAKey`, `JWKSet`, `JWKSource`)
- Geração de tokens JWT assinados com a chave privada (`JwtEncoder`)
- Validação automática de tokens recebidos na requisição usando a chave pública (`NimbusJwtDecoder`)
- Testes automatizados de autenticação com arquivos `api.http`

#### 🛠️ Tecnologias
- Spring Boot 4.1.0 & Gradle
- Spring Security
- Spring Security OAuth2 Resource Server
- Nimbus JOSE + JWT
- H2 Database

#### 📐 Padrões de Projeto
- **Chain of Responsibility**: A essência dos filtros do Spring Security processando cada requisição em cadeia.
- **Stateless Authentication Pattern**: Nenhum estado ou sessão é mantido no servidor; toda a confiança é criptograficamente garantida pelo JWT.
- **Asymmetric Key Pair Generation**: Separação criptográfica entre quem assina o token (chave privada) e quem valida (chave pública).

---

<a id="projeto-15"></a>
### Projeto 15 — Projeto Animes `[3 de 3 — Checkpoint 03]`
> **Aulas:** Aula 25 (3º Semestre) | **Pasta:** [`/projeto-anime 3`](./projeto-anime%203) | **Build:** Maven  
> 🔗 *Conexão de Continuidade: O clímax e versão definitiva da trilha iniciada no [Projeto Animes 1 de 3 (Projeto 06)](#projeto-06) e refinada no [Projeto Animes 2 de 3 (Projeto 10)](#projeto-10).*

#### 📖 O que foi feito
O grande encerramento e síntese do 3º Semestre! O **Checkpoint 03** do Projeto Animes consolida tudo o que foi desenvolvido ao longo do primeiro ciclo da disciplina em uma arquitetura corporativa completa: arquitetura orientada a domínio, validações personalizadas completas, documentação Swagger OpenAPI rica, paginação com HATEOAS (`PagedResourcesAssembler`), caching avançado com chaves compostas e observabilidade com Actuator.

#### 💬 Bastidores dos Commits
- `497b91c`: *Aula 25 - Projeto Anime 3* — O projeto corresponde ao Checkpoint 03 realizado no final do 3º Semestre. O commit foi sincronizado no Git no início de agosto consolidando a entrega final da trilha de animes.

#### 📚 Assuntos e Conceitos
- Síntese arquitetural corporativa: integração harmônica de múltiplos starters Spring
- Spring HATEOAS avançado: `PagedResourcesAssembler<T>` gerando `PagedModel<EntityModel<T>>`
- Paginação e consultas avançadas: `by-title`, `by-category`, `by-date`, `by-year-range`
- Caching de consultas complexas com chaves dinâmicas: `@Cacheable(value = "animes", key = "'by-year-range/' + #from + '/' + #to")`
- Invalidação seletiva de cache com `@CacheEvict(value = "animes", allEntries = true)` em operações de escrita
- Documentação OpenAPI detalhada com configurações personalizadas (`SwaggerConfig`)
- Telemetria e métricas ativas com Spring Boot Actuator

#### 🛠️ Tecnologias
- Spring Boot Starter Web & Data JPA
- Spring Boot Starter HATEOAS & Cache
- Spring Boot Starter Actuator
- SpringDoc OpenAPI Starter WebMVC UI
- Jakarta Bean Validation & H2 Database

#### 📐 Padrões de Projeto
- **Enterprise Architecture Synthesis**: A união de DDD, Caching, HATEOAS, Global Error Handling e OpenAPI em harmonia.

---

<a id="projeto-14"></a>
### Projeto 14 — Game Finder
> **Aulas:** Aula 24 (3º Semestre) | **Pasta:** [`/game-finder`](./game-finder) | **Build:** Maven

#### 📖 O que foi feito
Catálogo de jogos eletrônicos estruturado por domínios (`game`, `genre`, `plataform`). Encerra a sequência de exercícios do 3º semestre unindo a navegação hipermídia HATEOAS com documentação visual Swagger e relacionamentos entre entidades JPA (plataformas e gêneros de cada jogo).

#### 💬 Bastidores dos Commits
- `4a2b1df`: *Aula 24 - Projeto Game Finder utilizando HATEOAS*

#### 📚 Assuntos e Conceitos
- Relacionamentos relacionais no contexto HATEOAS
- Links de referência entre o jogo e sua respectiva plataforma/gênero
- Integração harmônica entre Swagger UI e payloads hipermídia

#### 🛠️ Tecnologias
- Spring Boot Starter HATEOAS & Web
- SpringDoc OpenAPI UI
- Spring Data JPA & H2 Database

#### 📐 Padrões de Projeto
- **Domain-Driven Packaging & HATEOAS Pattern**.

---

<a id="projeto-13"></a>
### Projeto 13 — Services
> **Aulas:** Aula 23 (3º Semestre) | **Pasta:** [`/services`](./services) | **Build:** Maven

#### 📖 O que foi feito
Projeto dedicado ao aprendizado do **Nível 3 do Modelo de Maturidade de Richardson: HATEOAS (Hypermedia As The Engine Of Application State)**. Diferente do Spring Data REST que faz isso de forma automática, aqui os links navegáveis foram construídos **manualmente** através do `spring-boot-starter-hateoas` para prestadores de serviços profissionais, categorias e localizações.

#### 💬 Bastidores dos Commits
- `9cd8941`: *Aula 23 - HATEOAS* — Implementação artesanal de links em prestadores de serviços, categorias e localizações.

#### 📚 Assuntos e Conceitos
- Os 4 Níveis do Modelo de Maturidade de Richardson (Nível 0 ao Nível 3)
- Spring HATEOAS: `EntityModel<T>`, `CollectionModel<T>`
- Criação de links dinâmicos e sem acoplamento de URL com `WebMvcLinkBuilder.linkTo(...)` e `methodOn(...)`
- Método `toEntityModel()` gerando links dinâmicos para `all-professionals`, `self` e `nearby-locations`
- Relacionamentos JPA `@ManyToMany` (`categories`) e `@ManyToOne` (`location`)

#### 🛠️ Tecnologias
- Spring Boot Starter HATEOAS
- Spring Data JPA & H2 Database
- Maven

#### 📐 Padrões de Projeto
- **HATEOAS / Hypermedia Driven REST**: Respostas que ensinam o cliente como interagir com os próximos estados do recurso.

---

<a id="projeto-12"></a>
### Projeto 12 — Cervejaria API
> **Aulas:** Aula 22 (3º Semestre) | **Pasta:** [`/cervejaria`](./cervejaria) | **Build:** Maven

#### 📖 O que foi feito
API para catálogo de cervejarias e rótulos de cerveja, aplicando as técnicas de Caching e Observabilidade da aula anterior em um cenário de comércio/catálogo com Mock Data inicial.

#### 💬 Bastidores dos Commits
- `6fd2961`: *Aula 22 - Projeto Cervejaria (Utilizando Swagger, Doc Swagger, Cache, Observabilidade e afins)*

#### 📚 Assuntos e Conceitos
- Cache de consultas de alto tráfego (listagem de rótulos por cervejaria)
- Documentação rica com anotações do Swagger/OpenAPI (`@Operation`, `@ApiResponse`, `@Tag`)
- Health checks customizados e telemetria operacional com Actuator

#### 🛠️ Tecnologias
- Spring Boot Starter Cache & Web
- Spring Boot Starter Actuator & Admin Client
- SpringDoc OpenAPI UI
- Spring Data JPA & H2 Database

#### 📐 Padrões de Projeto
- **Cache-Aside Pattern**.
- **Mock Data Loader**: Povoamento de dados no startup para testes imediatos no Swagger.

---

<a id="projeto-11"></a>
### Projeto 11 — Termo API
> **Aulas:** Aula 21 (3º Semestre) | **Pasta:** [`/termo`](./termo) | **Build:** Maven

#### 📖 O que foi feito
Implementação do backend para o jogo "Termo" (versão brasileira do Wordle). Este projeto introduziu conceitos fundamentais de **performance com Caching em memória**, **documentação interativa via Swagger OpenAPI** e **observabilidade de microsserviços via Spring Boot Actuator e Admin Client**.

#### 💬 Bastidores dos Commits
- `e995915`: *Aula 21 - Projeto Termo, Swagger, Doc Swagger, Cache, Observabilidade* — Configuração do SpringDoc, anotações de cache e métricas do Actuator.
- `b898895`: *Aula 21 - Projeto Termo, ajustando alguns arquivos e add comentários* — Documentação interna dos métodos e refinamento do swagger.

#### 📚 Assuntos e Conceitos
- Lógica de validação de palavras e tentativas no estilo Wordle/Termo
- Caching de consultas frequentes (`@EnableCaching`, `@Cacheable`)
- Documentação interativa de APIs com Swagger UI e OpenAPI 3 (`springdoc-openapi`)
- Observabilidade, saúde da aplicação e métricas operacionais com Spring Boot Actuator
- Integração com Spring Boot Admin Client para monitoramento centralizado

#### 🛠️ Tecnologias
- Spring Boot Starter Cache
- Spring Boot Starter Actuator & Spring Boot Admin Starter Client
- SpringDoc OpenAPI Starter WebMVC UI
- Spring Data JPA & H2 Database

#### 📐 Padrões de Projeto
- **Cache-Aside Pattern**: Armazenamento de resultados de queries em memória para evitar hits repetitivos no banco.
- **Documentation as Code**: Especificação OpenAPI gerada dinamicamente a partir das anotações do código.

---

<a id="projeto-10"></a>
### Projeto 10 — Projeto Animes `[2 de 3 — Checkpoint 02]`
> **Aulas:** Aula 19 e 20 (3º Semestre) | **Pasta:** [`/projeto-anime 2`](./projeto-anime%202) | **Build:** Maven  
> 🔗 *Conexão de Continuidade: Evolução direta do [Projeto Animes 1 de 3 (Projeto 06)](#projeto-06). Prepara o terreno para o [Projeto Animes 3 de 3 (Projeto 15)](#projeto-15).*

#### 📖 O que foi feito
**Segundo grande Checkpoint da FIAP.** Expansão massiva da Fase 1, totalizando 35 arquivos Java organizados em uma estrutura enterprise. O projeto refatora o sistema para múltiplos domínios independentes (`Anime`, `Personagem` e `Temporada`), apoiado por um conjunto rigoroso de 5 validadores customizados exclusivos com regex, unicidade de temporadas e tratamento de exceções robusto.

#### 💬 Bastidores dos Commits
- `bccce80`: *Aula 19 / Aula 20 - Checkpoint 2 Projeto Anime Avançado* — Implementação completa com múltiplos domínios, DTOs e bateria de validações customizadas.

#### 📚 Assuntos e Conceitos
- Avaliação semestral com critérios rigorosos de engenharia de software
- Mapeamento relacional em cadeia (Anime ➔ Temporadas ➔ Personagens)
- Validações customizadas de alta complexidade:
  - `@Titulo`: Validação de regras de título de obras
  - `@NomePersonagem`: Validação de nomenclatura de personagens
  - `@SemCaractereEspecial`: Validação com Expressões Regulares (Regex)
  - `@CategoriaValidation`: Validação semântica de gênero
  - `@UnicaTemporadaPorAnime`: Validação de consistência relacional para impedir temporadas duplicadas no mesmo anime
- Tratamento global de erros com `ValidationUtils` e `ValidationHandler`

#### 🛠️ Tecnologias
- Spring Boot Starter Data JPA & Web
- Jakarta Bean Validation
- H2 Database & Lombok

#### 📐 Padrões de Projeto
- **Domain-Driven Packaging**: Subpacotes isolados por domínio contendo seus próprios DTOs, Repositories e Services.
- **Composite Custom Validators**: Anotações combinadas para validação granular.

---

<a id="projeto-09"></a>
### Projeto 09 — Music Catalog
> **Aulas:** Aula 17 (3º Semestre) | **Pasta:** [`/music`](./music) | **Build:** Maven

#### 📖 O que foi feito
Catálogo musical gerenciando Álbuns, Artistas, Gêneros e Músicas. O projeto explorou os recursos do **Spring Data REST** para geração automática e padronizada de endpoints RESTful com links hipermídia nativos, carga inicial de dados via `CommandLineRunner` e projeções de dados (`Projections`).

#### 💬 Bastidores dos Commits
- `6590b69`: *Aula 17 - Vendo sobre Hateoas, usando organização baseada em domínio (colocamos o model, repository, controller e services dentro dele) e um sample data loader*

#### 📚 Assuntos e Conceitos
- Spring Data REST e exposição direta de repositórios JPA com HATEOAS
- Data Seeding: inicialização de dados na subida da aplicação com `DataLoader` (`CommandLineRunner`)
- Projections & Summaries (`MusicSummary`): customização de payloads para retornar apenas campos necessários, otimizando a banda de rede
- Organização em múltiplos domínios (`album`, `artist`, `genre`, `music`)

#### 🛠️ Tecnologias
- Spring Data REST (`spring-boot-starter-data-rest`)
- Spring Data JPA & H2 Database
- Lombok

#### 📐 Padrões de Projeto
- **Data Seeder / Fixture Pattern**: Carga inicial padronizada de banco.
- **Projection Pattern**: Redução de overhead de dados através de interfaces de projeção.

---

<a id="projeto-08"></a>
### Projeto 08 — Character
> **Aulas:** Aula 16 e 17 (3º Semestre) | **Pasta:** [`/character`](./character) | **Build:** Maven

#### 📖 O que foi feito
Projeto dedicado à refatoração estrutural de pacotes. O objetivo central foi abandonar a organização de pacotes técnica tradicional (*package by layer*) e migrar para uma **Arquitetura Orientada a Domínio (*package by feature*)**, agregando entidades, controllers, DTOs e validadores dentro do contexto específico do personagem.

#### 💬 Bastidores dos Commits
- `b59d28d`: *Aula 16 - Exercício Character*
- `6590b69`: *Aula 17 - Vendo sobre Hateoas, usando organização baseada em domínio...*
- `b5b50c4`: *fix: Arrumando projeto para Arq de Domínio*
- `d5d336c`: *feat: Atualizando Personagem*

#### 📚 Assuntos e Conceitos
- Package by Feature vs Package by Layer: alta coesão e baixo acoplamento
- Validações personalizadas de personagens (`CharacterValidation` e `CharacterValidator`)
- DTOs dedicados para entrada e saída

#### 🛠️ Tecnologias
- Spring Boot Starter Data JPA & Web
- Spring Boot Validation
- H2 Database & Lombok

#### 📐 Padrões de Projeto
- **Package by Feature (Domain-Driven Packaging)**.
- **DTO Pattern & Custom Validators**.

---

<a id="projeto-07"></a>
### Projeto 07 — E-Commerce
> **Aulas:** Aula 14 e 15 (3º Semestre) | **Pasta:** [`/e-commerce`](./e-commerce) | **Build:** Maven

#### 📖 O que foi feito
Um salto enorme na maturidade do código! Refatoração para remover injeções mágicas com `@Autowired` adotando injeção via construtor com Lombok (`@RequiredArgsConstructor`). Introdução do padrão **DTO** e implementação de **validações customizadas complexas**, incluindo validação algorítmica de CPF/CNPJ com cálculo de dígitos e validações condicionais baseadas no papel (Role) do usuário.

#### 💬 Bastidores dos Commits
- `f7be5bd`: *Aula 14 - Projeto e-commerce, construindo um DTO, retirando o @Autowired e usando o @RequiredArgsConstructor para o userRepository em Service, refatorando o UserController e UserService para se adequar ao DTO e usando No/AllArgsConstructor e Builder no User, além de colocar @Table para nomear a nossa tabela*
- `902d347`: *Aula 15 - Validação mais avançada! Validation para Idade e Role do User, além de validar seu CPF ou CNPJ (Lógica no UserRoleValidator), também criamos mensagens personalizadas e Annotations (Usamos no DTO)!*

#### 📚 Assuntos e Conceitos
- Boas práticas de Injeção de Dependências: abandono de `@Autowired` em campos privados em favor de imutabilidade (`final`) com injeção por construtor
- Padrão DTO (`UserRequest`, `UserResponse`) para blindar as entidades JPA da camada web
- Jakarta Bean Validation: criação de anotações personalizadas (`@Adult`, `@UserRoleValidation`)
- Implementação de validadores customizados (`ConstraintValidator<A, T>`)
- Validação matemática completa com cálculo de dígitos verificadores de CPF e CNPJ
- Tratamento global de erros de validação com `@RestControllerAdvice` (`ValidationHandler`)

#### 🛠️ Tecnologias
- Spring Boot Starter Data JPA & Web
- Jakarta Bean Validation (`spring-boot-starter-validation`)
- Lombok (`@Builder`, `@RequiredArgsConstructor`, etc.)
- H2 Database

#### 📐 Padrões de Projeto
- **DTO Pattern (Data Transfer Object)**: Desacoplamento entre domínio de persistência e payloads da API.
- **Builder Pattern**: Criação de objetos fluente e expressiva com `@Builder`.
- **Strategy / Validator Pattern**: Validadores modulares encapsulando regras de negócio.
- **Global Exception Handler**: Interceptação centralizada de erros com `@RestControllerAdvice`.

---

<a id="projeto-06"></a>
### Projeto 06 — Projeto Animes `[1 de 3 — Checkpoint 01]`
> **Aulas:** Aula 12 e 13 (3º Semestre) | **Pasta:** [`/projeto-anime 1`](./projeto-anime%201) | **Build:** Maven  
> 🔗 *Conexão de Continuidade: Primeira fase da espinha dorsal do curso. Evolui para o [Projeto Animes 2 de 3 (Projeto 10)](#projeto-10) e para o [Projeto Animes 3 de 3 (Projeto 15)](#projeto-15).*

#### 📖 O que foi feito
**Primeiro Checkpoint avaliativo oficial da disciplina na FIAP.** Construção da versão inicial da solução para catalogação de animes e personagens, estabelecendo relações relacionais entre tabelas no banco de dados e regras de negócio para cadastro e consulta.

#### 💬 Bastidores dos Commits
- `15b8f81`: *Aula 12 / Aula 13 - Checkpoint 01 Projeto Diamante Animes* — Entrega consolidada com relacionamentos, validações básicas e endpoints REST completos.
- *(Posteriormente sincronizado com ajustes de manutenção no repositório em `96da5d2`).*

#### 📚 Assuntos e Conceitos
- Avaliação prática semestral de arquitetura Spring
- Relacionamentos relacionais JPA: um Anime possui muitos Personagens (`@OneToMany`) e cada Personagem referencia seu Anime (`@ManyToOne`)
- Uso de `Enum` para Categorias de Animes (`Categoria.java`)
- Regras de integridade referencial e persistência em cascata

#### 🛠️ Tecnologias
- Spring Boot Starter Data JPA & Web
- H2 Database
- Lombok

#### 📐 Padrões de Projeto
- **Domain Relational Mapping Pattern**: Mapeamento bidirecional consistente de entidades relacionais.
- **Layered Architecture**.

---

<a id="projeto-05"></a>
### Projeto 05 — Expense Tracker
> **Aulas:** Aula 11 (3º Semestre) | **Pasta:** [`/expense-tracker`](./expense-tracker) | **Build:** Maven

#### 📖 O que foi feito
Sistema de controle de despesas financeiras com cadastro de valores, descrições, categorias e datas, focado na utilização extensiva de interfaces do Spring Data JPA (`ExpenseRepository extends JpaRepository<Expense, Long>`).

#### 💬 Bastidores dos Commits
- `f3531a8`: *Aula 11 - Projeto Expense (Exercício) e também useInterface com JPA e afins* — Exploração prática do mecanismo de interfaces dinâmicas do Spring Data.

#### 📚 Assuntos e Conceitos
- Mapeamento de entidades JPA (`@Entity`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`)
- Utilização e comportamento interno das interfaces do Spring Data
- Persistência e consultas em banco H2 relacional

#### 🛠️ Tecnologias
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- H2 Database & H2 Console
- Lombok (`@Data`)

#### 📐 Padrões de Projeto
- **Repository Pattern**: Interface limpa que elimina a necessidade de DAOs tradicionais.

---

<a id="projeto-04"></a>
### Projeto 04 — Dragons API
> **Aulas:** Aula 09 (3º Semestre) | **Pasta:** [`/dragons`](./dragons) | **Build:** Maven

#### 📖 O que foi feito
Exercício de CRUD completo de dragões, focado na semântica correta das operações HTTP, com ênfase especial na idempotência do verbo `DELETE` e no tratamento elegante de recursos inexistentes usando `Optional` e `ResponseStatusException`.

#### 💬 Bastidores dos Commits
- `c9f9078`: *Aula 09 - Projeto Dragons (Exercício)*
- `efcea35`: *Corrigindo erro no Delete Dragão* — Correção de retorno quando o ID do dragão solicitado para exclusão não era encontrado.
- `d32a2f1`: *Ajuste de arquivos perdidos no Git*.

#### 📚 Assuntos e Conceitos
- Idempotência no protocolo HTTP (comportamento correto do verbo DELETE)
- Tratamento de exceções com `Optional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))`
- Status HTTP adequados (`204 No Content` vs `404 Not Found`)
- Configuração de CORS

#### 🛠️ Tecnologias
- Spring Boot Starter Web
- Lombok
- Maven

#### 📐 Padrões de Projeto
- **Layered Architecture & REST Resource Pattern**.

---

<a id="projeto-03"></a>
### Projeto 03 — Heroes API
> **Aulas:** Aula 06 (3º Semestre) | **Pasta:** [`/heroes`](./heroes) | **Build:** Maven

#### 📖 O que foi feito
API RESTful criada como exercício de fixação para consolidação de Controllers e Services no Spring Boot, gerenciando heróis e configurando políticas de CORS para permitir requisições seguras de front-ends externos.

#### 💬 Bastidores dos Commits
- `9ad7f8b`: *Aula 06 - Projeto Heroes* — Criação completa do Controller, Service, Model e configuração de CORS.

#### 📚 Assuntos e Conceitos
- Roteamento e criação de endpoints REST com `@RestController`
- Injeção de dependências e regras de negócio no `HeroService`
- Políticas de CORS (Cross-Origin Resource Sharing) via `WebMvcConfigurer`

#### 🛠️ Tecnologias
- Spring Boot Starter Web
- Lombok
- Maven

#### 📐 Padrões de Projeto
- **Layered Architecture**: Controller e Service desacoplados.
- **Configuration Pattern**: Configuração centralizada com `CorsConfig`.

---

<a id="projeto-02"></a>
### Projeto 02 — Movies API
> **Aulas:** Aula 04 a 10 (3º Semestre) | **Pasta:** [`/movies`](./movies) | **Build:** Maven  
> 🔗 *Conexão de Continuidade: O domínio de filmes explorado aqui serve como base e evolui no [Projeto 18 (FIAP Movies Auth)](#projeto-18) com segurança JWT, BCrypt e RBAC.*

#### 📖 O que foi feito
O pontapé inicial no universo Spring Boot! A API começou gerenciando uma lista de filmes estática na memória e foi gradualmente refatorada ao longo de várias aulas até se tornar uma API RESTful completa com injeção de dependências, respostas padronizadas com `ResponseEntity` e persistência relacional com Spring Data JPA e banco H2.

#### 💬 Bastidores dos Commits
- `fbd5291`: *Iniciando com Spring Boot* — Primeiro controller REST.
- `e4a0905`: *Vendo sobre GET, POST, geração dos Getters e Setters / Construtores de forma mais rápida...* — Adoção de anotações do Lombok.
- `f616497`: *MovieService, reestruturando Controller e adicionando id* — Desacoplamento da regra de negócio para a camada Service.
- `11ad728`: *Refatorando MovieController e MovieService para usar ResponseEntity...* — Uso de status HTTP semânticos (200, 201, 404, 204), eliminando magic numbers (`//.status(201) - Magic Number (RUIM)`).
- `d4fa0c3`: *Adicionando JPA, H2 Database e H2 Console...* — Migração definitiva de coleções Java para banco relacional em memória.

#### 📚 Assuntos e Conceitos
- Introdução ao ecossistema Spring Boot
- Métodos HTTP semânticos (GET, POST, PUT, DELETE)
- Inversão de Controle (IoC) e Injeção de Dependências (`@Autowired` / `@Service`)
- Status codes com `ResponseEntity` e registros imutáveis com `record` (`HealthStatus`)
- Persistência relacional com Spring Data JPA e console web do H2

#### 🛠️ Tecnologias
- Spring Boot Starter Web
- Spring Data JPA & H2 In-Memory Database
- Project Lombok (`@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@Slf4j`)
- Spring Boot DevTools

#### 📐 Padrões de Projeto
- **Layered Architecture**: Separação clara em Camadas (Controller ➔ Service ➔ Repository ➔ Model).
- **Repository Pattern**: Abstração do acesso a dados via `JpaRepository`.

---

<a id="projeto-01"></a>
### Projeto 01 — Jogo 21 (Vinte e Um)
> **Aulas:** Aula 01 a 03 (3º Semestre) | **Pasta:** [`/vinteeum`](./vinteeum) | **Build:** Maven

#### 📖 O que foi feito
Aplicação Desktop desenvolvida em JavaFX recriando o clássico jogo de cartas Blackjack (21). O projeto possui interface gráfica interativa com carregamento dinâmico de sprites de baralho (`classic-cards`), controle de fluxo de rodadas, regras de pontuação dinâmica do Ás (valendo 1 ou 11) e tomada de decisões automatizada da mesa/computador.

#### 💬 Bastidores dos Commits
- `f470b1b`: *aula 1 - Jogo 21 Baralho* — Configuração do projeto com JavaFX, montagem dos modelos de `Carta`, `Naipe` e `Monte`.
- `64216a1`: *Aula 03 - Finalizando Jogo 21* — Implementação da lógica de pontuação, verificação de estouro da mão e condições de vitória.
- *(Posteriormente, em `96da5d2` [Aula 36], foram realizados ajustes de alinhamento e organização do repositório).*

#### 📚 Assuntos e Conceitos
- Orientação a Objetos clássica (Encapsulamento, Coesão e Polimorfismo)
- JavaFX 17 (`module-info.java`, `javafx-controls`, `javafx-fxml`) com interface FXML (`primary.fxml`)
- Event-Driven Architecture (manipulação de cliques de botões e listeners visuais)
- Lógica de estados de jogo e IA básica para as decisões da mesa do computador

#### 🛠️ Tecnologias
- Java 17 (bytecode release 11 no plugin do Maven)
- JavaFX Controls & JavaFX FXML 13
- Maven (`javafx-maven-plugin`)

#### 📐 Padrões de Projeto
- **MVC (Model-View-Controller)**: Separação estrita entre o FXML (View), `PrimaryController` (Controller) e entidades de cartas/jogadores (Model).

---

## 🚀 Como Executar os Projetos

### Pré-requisitos
- **Java JDK 17** ou superior instalado e configurado no `PATH`.
- **Docker & Docker Compose** (necessário para os projetos com PostgreSQL: `weather-planner` e `board-vault`).
- **k6** (necessário para executar o teste de corrida do `ticket-system` — instalar via `winget install k6` no Windows ou `brew install k6` no macOS).

---

### 1. Projetos com Gradle (`build.gradle`) — Padrão do 4º Semestre
Para executar qualquer projeto baseado em Gradle (ex: `ticket-system`, `board-vault`, `cripto-planner`, `weather-planner`, `car-sale`, `fiap-movies`, `mypass`, `spy`):
```bash
cd "nome-do-projeto"

# No Windows (PowerShell / CMD)
./gradlew bootRun
```

---

### 2. Projetos com Maven (`pom.xml`) — Padrão do 3º Semestre
Para executar qualquer projeto baseado em Maven (ex: `projeto-anime 3`, `game-finder`, `services`, `cervejaria`, `termo`, `projeto-anime 2`, `e-commerce`, `movies`):
```bash
cd "nome-do-projeto"

# No Windows (PowerShell / CMD)
./mvnw spring-boot:run

# Ou se tiver o Maven instalado globalmente
mvn spring-boot:run
```

Para o **Projeto 01 — Jogo 21 (JavaFX Desktop)**:
```bash
cd vinteeum
./mvnw javafx:run
```

---

### 3. Projetos com Banco PostgreSQL e Flyway (`weather-planner` / `board-vault`)
Suba o banco PostgreSQL via Docker antes de rodar a aplicação para que as migrações do Flyway sejam executadas automaticamente:
```bash
# Subir PostgreSQL via Docker na porta padrão 5432
docker run --name postgres-fiap -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=fiap_db -p 5432:5432 -d postgres:latest

# Em seguida, execute a aplicação desejada
cd weather-planner
./gradlew bootRun
```

---

### 4. Executando o Ecossistema de Microsserviços (`ticket-system`)
Abra 3 terminais separados e inicie os serviços na seguinte ordem:

```bash
# Terminal 1 — Inicie o Eureka Service Discovery (Porta 8761)
cd ticket-system/service-descover
./gradlew bootRun

# Terminal 2 — Inicie o Serviço de Ingressos (Porta 8080)
cd ticket-system/ticket-service
./gradlew bootRun

# Terminal 3 — Inicie o Serviço de Pagamentos (Porta dinâmica)
cd ticket-system/payment-service
./gradlew bootRun
```

Para executar o **teste de concorrência e comprovar o bloqueio contra Race Conditions**:
```bash
cd ticket-system
k6 run purchase-race-test.js
```

---

## 👨‍💻 Autor
Desenvolvido por **Enzo Okuizumi** durante as aulas de **Java Advanced** nos **3º e 4º semestres da FIAP**.  
Repositório mantido com compromisso com as melhores práticas de Engenharia de Software, Arquitetura Corporativa e Microsserviços!
