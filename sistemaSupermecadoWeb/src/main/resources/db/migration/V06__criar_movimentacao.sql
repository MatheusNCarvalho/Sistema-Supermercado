CREATE TABLE movimentos
(
  pk_movimento bigint(20) NOT NULL AUTO_INCREMENT,
  fk_abertura bigint(20)DEFAULT NULL,
  tipo varchar(8) NOT NULL,
  valor decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (pk_movimento),
  CONSTRAINT movimentos_aberturas FOREIGN KEY (fk_abertura)
      REFERENCES aberturas (pk_abertura) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;