# SalesAPI
API capaz de gerar uma venda e retornar a lista de vendedores com os campos: nome, total de vendas do vendedor e média de vendas diária, conforme o período informado por parâmetro.

# Requisições da classe VendedorController

## *cadastrar vendedor
    Esta requisição é capaz de cadastrar um vendedor.
    É executada na URL: http://localhost:8080/cadastrar-vendedor
    
    É necessário passar no JSON o parâmetro nome-vendedor.
    Segue exemplo de um Json para executar esta requisição:
    
        {
        	"nomeVendedor":"Lucas"        	
        }
    obs.: nomeVendedor não pode ser nulo.
## *vendedores cadastrados
    Esta requisição retorna a lista de todos os vendedores cadastrados.
    É executada com a URL: http://localhost:8080/vendedores-cadastrados
    Não é necessário passar parâmetros com JSON.
    
## *selecionar vendedor pelo ID
    Esta requisição retorna o vendedor correspondente ao id passado no JSON.
    É executada através da URL: http://localhost:8080/selecionar-vendedor-pelo-id
    Para executá-la, basta informar um id correspondente a um 
    vendedor criado anteriormente.
    Segue exemplo de JSON para esta requisição:
        1
        
    Este JSON retorna o vendedor cujo o id é igual a 1.
    
## *realizar venda
    Esta requisição recebe como parâmetro um objeto venda.
    Um objeto venda é composto por:
        idVenda (Automaticamente atribuido)
        idVendedor;
        dataDeVenda (Automaticamente atribuido)
        valorVenda;
     
    É executada na URL: http://localhost:8080/realizar-venda
    Segue exemplo de JSON para executar a requisição:
         {
            "idVendedor": 1,
            "valorVenda":1200
         }
       
    Obs.: O valorVenda não pode ser nulo. 