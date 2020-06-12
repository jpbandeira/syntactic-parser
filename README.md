# Syntactic-Parser
Codes to compilers discipline. The intuit is create a  syntactic parser.

# Link vídeo apresentação
https://web.microsoftstream.com/video/4311f543-3955-44e2-a6ac-472688bf2af8

# Gramáticas utilizadas

- S -> AB;A -> a | 0;B -> b | c;
- S -> A | B;A -> a;B -> b;
- S -> Bb | Cd;B -> aB|0;C -> cC|0;

# Algoritmos implementados

~~~~
public char[] first(String variable);
public char[] folow(String variable);
public void generatePredictiveTable(Grammar grammar)
~~~~

# Especificações para execução

- Ter o java instalado na maquina.
- Ter qualquer IDE para java instalada.

- Abrir o projeto na IDE e executar a classe Main, que contém as chamadas de metodos.
A mesma realiza o pedido de entrada da gramática e variável para testar os metodos First e Folow.

### Exemplo de entrada

~~~~
(AQUI VOCÊ ENTRA COM A GRAMÁTICA PARA A MESA SER GERADA E ARMAZENADA)
Digite a gramatica: 
S -> A | B;A -> a;B -> b;

**** Gramática Gerada ****

Variavel | 	Derivações
S		 |		A|B
---------|-------------------
Variavel | 	Derivações
A		 |		a
---------|-------------------
Variavel | 	Derivações
B		 |		b
---------|-------------------

**** Tabela Preditiva ****

Variavel | 	Simbolo Terminal | 	Produção
S		 |		a			 |		A|B
---------|-------------------|--------------
Variavel | 	Simbolo Terminal | 	Produção
S		 |		b			 |		A|B
---------|-------------------|--------------
Variavel | 	Simbolo Terminal | 	Produção
A		 |		a			 |		a
---------|-------------------|--------------
Variavel | 	Simbolo Terminal | 	Produção
B		 |		b			 |		b
---------|-------------------|--------------
(AQUI VOCÊ ENTRA COM A VARIAVEL PARA TER O RETORNO DE FIRST E FOLOW)
Digite a variavel para testar FIRST e FOLOW: 
S

Primeiro de S = [a, b]

Folow de S = [$]
~~~~

- Para testar o First e Folow separados, entre com a variavel requerida e o
programa retorna o resulta para os algoritmos. 
Para testar mais de uma vez na mesma gramática, é necessário que execute o 
código novamente passando uma variavel diferente.