# Projeto de Microsserviços com API Gateway, Eureka Server e Spring Cloud

## Descrição

Este projeto demonstra uma arquitetura de microsserviços utilizando Spring Boot, Spring Cloud, Eureka Server para descoberta de serviços, e um API Gateway para roteamento de requisições. O projeto inclui dois microsserviços: `user-api` e `payment-api`.

## Estrutura do Projeto

- **eureka-server**: Servidor de descoberta que mantém o registro de todos os serviços.
- **api-gateway**: Gateway que atua como ponto de entrada único para os clientes, roteando requisições para os microsserviços apropriados.
- **user-api**: Serviço que gerencia usuários.
- **payment-api**: Serviço que gerencia pagamentos, interagindo com o serviço de usuários.

## Pré-requisitos

- Java 17 ou superior
- Maven
- IDE de sua escolha (IntelliJ, Eclipse, VSCode, etc.)

## Configuração e Execução

### 1. Clonar o Repositório

```bash
git clone https://github.com/gsouza590/sistemaRh.git
cd seu-repositorio 
```

## Configurar Variáveis de Ambiente

Certifique-se de configurar as seguintes variáveis de ambiente conforme necessário:

PORT: Porta para os serviços (api-gateway, user-api, payment-api).
EUREKA_URL: URL do Eureka Server.

##Endpoints

API Gateway:

- **Base URL**: http://localhost:8765
   - Exemplos:
   - /api/users/{id}: Obtém informações de um usuário específico.
   - /api/payments/{id}: Calcula o pagamento para um usuário específico.
  
User API:

- **Base URL**: http://localhost:8000/api/users
   - Exemplos:
   - GET /{id}: Obtém informações de um usuário específico.
   - GET /: Obtém uma lista de todos os usuários.
  
Payment API:

- **Base URL**: http://localhost:8100/api/payments
    - Exemplos:
    - GET /{id}: Calcula o pagamento para um usuário específico.

## Endpoints
Construir e Executar os Serviços com Docker
Navegue até o diretório de cada serviço e construa as imagens Docker.

### Eureka Server
```bash
cd eureka-server
mvn clean package
docker build -t gsouza590/eureka-server:1.0.0 .
```
### API Gateway
```bash
cd ../api-gateway
mvn clean package
docker build -t gsouza590/api-gateway:1.0.0 .
```
### User API
```bash
cd ../user-api
mvn clean package
docker build -t gsouza590/user-api:1.0.0 .
```
### Payment Api
```bash
cd ../payment-api
mvn clean package
docker build -t gsouza590/payment-api:1.0.0 .
```
### Executar com Docker Compose
```bash
docker-compose up
```
