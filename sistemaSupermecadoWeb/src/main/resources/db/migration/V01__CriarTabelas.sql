CREATE TABLE aberturas (
  pk_abertura bigint(20) NOT NULL AUTO_INCREMENT,
  data_hora varchar(255) DEFAULT NULL,
  funcionario varchar(255) DEFAULT NULL,
  saldo decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (pk_abertura)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE categorias (
  pk_categoria bigint(20) NOT NULL AUTO_INCREMENT,
  descricao varchar(255) DEFAULT NULL,
  nome varchar(255) NOT NULL,
  PRIMARY KEY (pk_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE clientes (
  pk_cliente bigint(20) NOT NULL AUTO_INCREMENT,
  bairro varchar(255) NOT NULL,
  cep varchar(255) NOT NULL,
  cidade varchar(255) NOT NULL,
  cpf varchar(255) NOT NULL,
  estado varchar(255) NOT NULL,
  logadouro varchar(255) NOT NULL,
  nome varchar(255) NOT NULL,
  pais varchar(255) NOT NULL,
  telefone varchar(255) NOT NULL,
  PRIMARY KEY (pk_cliente),
  UNIQUE KEY UK_7wflw78ibh162cmq12ii6ffly (cpf)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE compras (
  pk_compra bigint(20) NOT NULL AUTO_INCREMENT,
  data_hora datetime DEFAULT NULL,
  fk_fornecedor int(11) DEFAULT NULL,
  usuario varchar(255) DEFAULT NULL,
  PRIMARY KEY (pk_compra)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE compras_itens (
  pk_item bigint(20) NOT NULL AUTO_INCREMENT,
  fk_compra bigint(20) DEFAULT NULL,
  fk_produto int(11) DEFAULT NULL,
  qtd int(11) DEFAULT NULL,
  valor_unitario decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (pk_item),
  KEY FK7a5gnpw9eqfggeijx62cmh7c5 (fk_compra),
  CONSTRAINT FK7a5gnpw9eqfggeijx62cmh7c5 FOREIGN KEY (fk_compra) REFERENCES compras (pk_compra)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE fechamentos (
  pk_fechamento bigint(20) NOT NULL AUTO_INCREMENT,
  funcionario varchar(255) DEFAULT NULL,
  data_fechamento tinyblob,
  fk_abertura int(11) NOT NULL,
  saldo_final decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (pk_fechamento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE fornecedores (
  pk_fornecedor bigint(20) NOT NULL AUTO_INCREMENT,
  bairro varchar(255) DEFAULT NULL,
  cep varchar(255) NOT NULL,
  cidade varchar(255) NOT NULL,
  cnpj varchar(255) NOT NULL,
  estado varchar(255) NOT NULL,
  logadouro varchar(255) DEFAULT NULL,
  nome varchar(255) NOT NULL,
  pais varchar(255) DEFAULT NULL,
  telefone varchar(255) NOT NULL,
  PRIMARY KEY (pk_fornecedor),
  UNIQUE KEY UK_tflo0rfxyagqf5aq6rvjt5ofh (cnpj)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE produtos (
  pk_produtos bigint(20) NOT NULL AUTO_INCREMENT,
  codigo_barras varchar(255) NOT NULL,
  fk_categoria int(11) DEFAULT NULL,
  nome varchar(255) NOT NULL,
  qtd_estoque int(10) DEFAULT NULL,
  qtd_maxima int(10) NOT NULL,
  qtd_medida decimal(19,2) NOT NULL,
  qtd_minimo int(10) NOT NULL,
  tipo_medida varchar(255) NOT NULL,
  valor_unitario decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (pk_produtos)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE vendas (
  pk_venda bigint(20) NOT NULL AUTO_INCREMENT,
  data_hora varchar(255) DEFAULT NULL,
  fk_abertura int(11) DEFAULT NULL,
  fk_cliente int(11) DEFAULT NULL,
  usuario varchar(255) DEFAULT NULL,
  PRIMARY KEY (pk_venda)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE vendas_itens (
  pk_item bigint(20) NOT NULL AUTO_INCREMENT,
  fk_produto int(11) DEFAULT NULL,
  fk_venda bigint(20) DEFAULT NULL,
  qtd int(11) DEFAULT NULL,
  valor_unitario decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (pk_item),
  KEY FKsdet4289yb0b6crlm7xpcygq7 (fk_venda),
  CONSTRAINT FKsdet4289yb0b6crlm7xpcygq7 FOREIGN KEY (fk_venda) REFERENCES vendas (pk_venda)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
