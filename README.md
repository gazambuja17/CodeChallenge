# Code Challenge
Aplicação web para controlar o catálogo de peças de uma empresa. Desenvolvido com as tecnologias: JavaEE, JSF, PrimeFaces e JPA. Os dados dessa aplicação são persistido no banco de dados MySQL. 
Dentre as funcionalidades, estão a de permitir Cadastrar, Listar e Apagar peças do catálogo. 

# Detalhes da implementação
Foram desenvolvidas duas páginas web, usando JSF 2.1 e o framework UI PrimeFace 5.3 para as funcionalidades exigidas.
A página inicial é a listPecas.xhtml, na qual mostra através de uma dataTable todas as peças do catálogo, com opção de Apagar, caso necessário. Na mesma página, tem um botão de Cadastrar uma Peça, que vai chamar a página createPeca.xhtml, na qual fazemos o cadastro de uma nova peça no catálogo.

Esse projeto foi feito no padrão MVC (model, view, controller) e seguindo boas práticas de programação.
Para a persistência dos dados no banco de dados foi utilizado o JPA e Hibernate.

# Pré-requisitos
- JDK - versão 1.8 do Java; 
- Eclipse IDE - versõo 2019-03 (4.11.0);
- Maven para o controle de depedências - versão 3.6.0;
- Tomcat - versão 7.0
- MySQL - versão 8.0

# Estrutura do Projeto no Eclipse

Estrutura do projeto

![image](https://user-images.githubusercontent.com/16178085/61174659-b5216000-a579-11e9-8497-eddcbc8ca35d.png)


# Exemplo da aplicação
Tela Inicial (http://localhost:8080/codeChallenge/faces/listPecas.xhtml)

![telaInicial](https://user-images.githubusercontent.com/16178085/61174595-d170cd00-a578-11e9-93a7-adae4650765a.JPG)


Tela Cadastro de uma Peça (http://localhost:8080/codeChallenge/faces/createPeca.xhtml)

![telaCadatro](https://user-images.githubusercontent.com/16178085/61174634-68d62000-a579-11e9-801b-8fe01989db3c.JPG)

# Observações
- Dentro do projeto, existe um script SQL para criação do database e da tabela utilizada, no caminho: /src/main/resources/META-INF/Scripts-DB/;
- Alterar os arquivos hibernate.cfg.xml e persistence.xml (/src/main/resources/) com a string de conexão do seu banco de dados;
- Na pasta target tem o WAR da aplicação web, caso queiram subir direto em algum servidor de sua escolha.
