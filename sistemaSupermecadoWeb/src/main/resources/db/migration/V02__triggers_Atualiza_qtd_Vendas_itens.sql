DELIMITER $$
 
CREATE TRIGGER Tgr_vendas_itens_Insert AFTER INSERT
ON vendas_itens
FOR EACH ROW
BEGIN
    UPDATE produtos SET qtd_estoque = qtd_estoque - NEW.qtd
WHERE pk_produtos = NEW.fk_produto;
END$$
 
CREATE TRIGGER Tgr_vendas_itens_Delete AFTER DELETE
ON vendas_itens
FOR EACH ROW
BEGIN
    UPDATE produtos SET qtd_estoque = qtd_estoque + OLD.qtd
WHERE pk_produtos = OLD.fk_produto;
END$$
 
DELIMITER ;