# Desafio Prático: Sistema de E-Commerce

## Descrição:
Este projeto é uma API RESTful desenvolvida em Java com Spring Boot que implementa um Sistema de e-Commerce para gerenciar clientes, produtos e compras. Ele foi desenvolvido para facilitar operações como adicionar, visualizar e excluir produtos, além de criar, listar e atualizar clientes e buscar cliente pelo CPF. O sistema também permite realizar compras.

## Pré-requisitos

Antes de começar, certifique-se de ter os seguintes itens instalados em sua máquina:

- [Java 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- Uma IDE como [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [Eclipse](https://www.eclipse.org/ide/).


## Funcionamento:
Para utilizar o Sistema de e-Commerce devemos usar o EndPoint em algum APIRest como o Thunder Client, o Postman ou outro de sua preferência.

## Estrutura do Código:
* **DesafioSistemaECommerceApplication():** Classe responsável por rodar o servidor h2 data base.
* **ClienteController:** Classe que controla as Rotas dos EndPoints referentes ao Cliente.
* **CompraController:** Classe que controla as Rotas dos EndPoints referentes a Compra.
* **ProdutoController():** Classe que controla as Rotas dos EndPoints referentes a Produtos.
* **ClienteDTO():** Classe que cuida da transferência dos dados do cliente.
* **CompraDTO():** Classe que cuida da transferência dos dados da realização da compra.
* **ErrorDTO():** Classe que cuida da transferência dos dados dos erros.
* **ProdutoCompraDTO():** Classe que cuida da transferência dos dados da lista de produtos da compra.
* **ProdutoDTO():** Classe que cuida da transferência dos dados do produto.
* **Cliente():** Classe que determina entidade Cliente.
* **Produto():** Classe que determina entidade Produto.
* **ClienteRepository():** Classe que extends o JPA para Cliente.
* **ProdutoRepository():** Classe que extends o JPA para Produto.
* **ClienteService():** Classe que contem os métodos referentes a Cliente(cadastrarCliente, listarClientes, ClientePorCPF e atualizaCliente).
* **CompraService():** Classe que contem o método referentes a Compra(realizarCompra).
* **ProdutoService():** Classe que contem o método referentes a Produto(cadastrarProduto, listarProdutos, produtoExiste, excluirProduto).
* **CPFValidator():** Classe que contem a formula para validar o CPF.
* **GlobalExceptionHandler** Classe quem contém métodos para personalizações de exceções (MethodArgumentNotValidException.class, ResourceNotFoundException.class, ProdutosEmFaltaException.class, IllegalArgumentException.class e Exception.class).
* **ProdutosEmFaltaException** Classe que extende a excessão RuntimeException.
* **ResourceNotFoundException** Classe que extende a excessão RuntimeException.

## Como Executar o Código

Para executar o código, siga os passos abaixo:

### 1. Clonar o Repositório
Clone o repositório para o seu ambiente local:

```bash
git clone git@github.com:ericamoraesabdao/desafioSistemaECommerce.git
```

### 2. Navegar até o Diretório do Projeto
Entre na pasta do repositório clonado:

```bash
cd desafioSistemaECommerce
```

### 3. Abra sua IDE de preferência e execute o código no botão RUN na IDE.

## EndPoints

### cadastrarCliente

**URL:** /clientes

**Método:** POST

**Descrição:** Cadastra um novo Cliente.

**Body (JSON):**

    {
        "nome": "João Silva",
        "email": "joao.silva@email.com",
        "cpf": "12345678909"
    }

**Exemplo de Resposta:**

    {
        "idCliente": 1,
        "nomeCliente": "João Silva",
        "emailCliente": "joao.silva@email.com",
        "cpfCliente": "12345678909"
    }


### ClientePorCPF

**URL:** /clientes{cpf}

**Método:** GET

**Descrição:** Retorna o Cliente do CPF determinado.

**Exemplo de Resposta:**

    {
        "idCliente": 1,
        "nomeCliente": "João Silva",
        "emailCliente": "joao.silva@email.com",
        "cpfCliente": "12345678909"
    }


### listarClientes

**URL:** /clientes

**Método:** GET

**Descrição:** Retorna todos os Clientes cadastrados.

**Exemplo de Resposta:**

    [
        {
            "idCliente": 1,
            "nomeCliente": "João Silva",
            "emailCliente": "joao.silva@email.com",
            "cpfCliente": "12345678909"
        },
        {
            "idCliente": 2,
            "nomeCliente": "João Silva",
            "emailCliente": "joao.silva2@email.com",
            "cpfCliente": "95877657100"
        }
    ]


### atualizaCliente

**URL:** /clientes{cpf}

**Método:** PUT

**Descrição:** Atualiza o cliente do CPF espeficicado.

**Exemplo de Resposta:**

    {
        "idCliente": 1,
        "nomeCliente": "João Silva Silva",
        "emailCliente": "joao.silva3@email.com",
        "cpfCliente": "12345678989"
    }

### realizarCompra

**URL:** /compras

**Método:** POST

**Descrição:** Realiza a compra, retirando a quantidade em estoque da entidade Produto.

**Body (JSON):**

    {
        "cpf": "12345678909",
        "produto": [
            { "nome": "Produto3" },
            { "nome": "Produto1" },
            { "nome": "Produto2" }
        ]
    }

**Exemplo de Resposta:**

    {
        "cpf": "12345678989",
        "nomeCliente": "João Silva Silva",
            "produto": [
                {
                "nome": "Produto3"
                },
                {
                "nome": "Produto1"
                },
                {
                "nome": "Produto2"
                }
            ]
    }

### cadastrarProduto

**URL:** /produtos

**Método:** POST

**Descrição:** Cadastra um produto.

**Body (JSON):**

    {
        "nome": "Produto1",
        "preco": 9.0,
        "quantidade": 1
    }

**Exemplo de Resposta:**

    {
        "idProduto": 3,
        "nomeProduto": "Produto1",
        "precoProduto": 9.0,
        "quantidadeProduto": 1
    }


### listarProdutos

**URL:** /produtos

**Método:** GET

**Descrição:** Lista todos os produtos cadastrados.

**Exemplo de Resposta:**

    [
        {
            "idProduto": 1,
            "nomeProduto": "Produto3",
            "precoProduto": 9.0,
            "quantidadeProduto": 1
        },
        {
            "idProduto": 2,
            "nomeProduto": "Produto2",
            "precoProduto": 9.0,
            "quantidadeProduto": 1
        },
        {
            "idProduto": 3,
            "nomeProduto": "Produto1",
            "precoProduto": 9.0,
            "quantidadeProduto": 1
        }
    ]


### excluirProduto

**URL:** /produtos/{id}

**Método:** DELETE

**Descrição:** Exclui o produto selecionado pelo ID.


## Tecnologias Utilizadas
- **Java 17:** Linguagem de programação.
- **Spring Boot:** Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA:** Para persistência de dados.
- **H2 Database:** Banco de dados em memória para desenvolvimento e testes.
- **Maven:** Gerenciador de dependências e automação de build.
- **Validation** Verifica validações como @NotNull

## Autora

- **Erica Moraes Abdao**
