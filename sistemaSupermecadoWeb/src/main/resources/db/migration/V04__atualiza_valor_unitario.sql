DELIMITER $$

CREATE TRIGGER Tgr_atualiza_valor_unitario_Insert AFTER INSERT
ON compras_itens
FOR EACH ROW
BEGIN
    UPDATE produtos SET valor_unitario = NEW.valor_unitario
WHERE pk_produtos = NEW.fk_produto;
END$$
 
DELIMITER ;