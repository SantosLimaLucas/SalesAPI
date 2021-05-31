# SalesAPI
API capaz de gerar uma venda e retornar a lista de vendedores com os campos: idVendedor, nomeVendedor e vendasRealizadas.

# Requisições da classe VendedorController

## *cadastrar vendedor
    Esta requisição é capaz de cadastrar um vendedor.
    É executada na URL: http://localhost:8080/vendedores
    
    É necessário passar no JSON de uma requisição POST o parâmetro nome-vendedor.
    Segue exemplo de um Json para executar esta requisição:
    
        {
        	"nomeVendedor":"Lucas"        	
        }
    obs.: nomeVendedor não pode ser nulo.
## *vendedores cadastrados
    Esta requisição retorna a lista de todos os vendedores cadastrados.
    É executada com a URL: http://localhost:8080/vendedores
    Não é necessário passar parâmetros com JSON. A requisição é to tipo GET.
    
## *selecionar vendedor pelo ID
    Esta requisição GET retorna o vendedor correspondente ao id passado no JSON.
    É executada através da URL: http://localhost:8080/selecionar-vendedor-pelo-id
    Para executá-la, basta informar um id correspondente a um 
    vendedor criado anteriormente.
    Segue exemplo de JSON para esta requisição:
        1
        
    Este JSON retorna o vendedor cujo o id é igual a 1.
    
## *realizar venda
    Esta requisição POST recebe como parâmetro um objeto venda.
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
