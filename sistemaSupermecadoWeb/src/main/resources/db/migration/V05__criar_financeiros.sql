CREATE TABLE financeiros_entradas
(
  pk_financeiro bigint(20) NOT NULL AUTO_INCREMENT,
  fk_venda bigint(20)DEFAULT NULL,
  data_emissao datetime DEFAULT NULL,
  data_vencimento datetime DEFAULT NULL,
  data_baixa datetime DEFAULT NULL,
  valor decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (pk_financeiro),
  CONSTRAINT finacei_entradas_vendas FOREIGN KEY (fk_venda)
      REFERENCES vendas (pk_venda) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;