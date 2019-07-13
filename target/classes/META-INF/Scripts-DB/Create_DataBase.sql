-- CREATE DATABASE --
CREATE DATABASE zen_schema;

-- CREATE TABLE TB_PECAS --
CREATE TABLE tb_pecas (
  ID_PECA INT NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(200) NOT NULL,
  VEICULO_APLICACAO VARCHAR(200) NULL,
  PESO_LIQUIDO DECIMAL(10,2) NOT NULL,
  PESO_BRUTO DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (ID_PECA))
COMMENT = 'tabela que guarda valores das pecas do catalogo';