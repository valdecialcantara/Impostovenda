# Impostovenda
Calcula o imposto sobre vendas básicas e importados.

Os Requisitos de Casos de Teste de Negócio serviram de base para escrever a aplicação a partir do TDD (Test Driven Development):

1. Importar dados de dos produtos para venda;
2. Carregar janela para seleção dos produtos de entrada (selecionar check-box do produto, editar quantidade e preço de venda e calcular valor, impostos de venda e de importação);
3. Preencher a janela de saida do produtos para venda (somar total de venda e taxas);
4. Imprimir saída dos produtos vendidos (Botão Vender – Imprime a Venda);
5. Criar grupo de produtos de venda (1- Livros, 2- Alimentos, 3- Médicos);
6. Controlar saldo de estoque para venda.

# Processo para recarga do esoque e reprocessamento da venda de produtos

Executar os comandos sql:

//Limpar os registros de venda de produtos
DELETE from sellProduct where id < 100;

//Atualizar o saldo de estoque dos produtos para venda
UPDATE material SET stockQuantity = 1 WHERE id < 10;
