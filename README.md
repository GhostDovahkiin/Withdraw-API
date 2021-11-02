# Exercício Caixa Eletrônico

Fazer um programa que simule saque de um caixa eletrônico e sempre retorne o menor numero de notas possível


## Especificações Funcionais

- As notas válidas são pode ser 100, 50, 20, 10, 5
- As notas são infinitas
- Todos os saques devem ser guardados em uma lista de Saques
- O Saque deve conter a data e hora de quando foi realizado e o valor
- Caso o saque não seja possível não registrar e informar a mensagem: “valor inválido”
- No programa principal deve ser possível sacar de qualquer caixa eletrônico
- DEVE-SE aplicar todos os conceitos passados em aula.

### Se for feito com uma aplicação do tipo console
-  Deve pedir no terminal qual o valor do saque e devolver a resposta abaixo
###  Se for feito com API
- Em caso de saque com valores 0,1, negativo, quebrado (centavos) o sistema deve retornar a mensagem de erro “Valor de saque inválido” com o status http 400-bad request
### Se for com notas finitas
- Em caso de não ter mais notas disponíveis para o saque o sistema deve retornar a mensagem Caixa temporariamente indisponível” com status http 406-Not-Acceptable
### Se for feito com Base de Dados
- As notas tem que ser cadastradas na base de dados quando o programa inicia
- A quantidade de notas inicial é de 5 para cada
- Criar um controller que representa o path “/current-account”
- Criar um endpoint que irá realizar a operação de saque com o path “/current-account/{id}/withdraw”

## Formas de Entrega
- URL do repositório no Github no Slack
- Se caso não funcionar enviar um .zip pelo chat com o nome respectivo: NomeDoAluno.zip