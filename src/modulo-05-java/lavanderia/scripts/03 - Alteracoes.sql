ALTER TABLE Produto ADD Situacao VARCHAR2(1);
ALTER TABLE Item DROP COLUMN ValorDesconto;
ALTER TABLE Pedido RENAME COLUMN Valor to ValorBruto;
ALTER TABLE Pedido ADD ValorDesconto number(12,2);
ALTER TABLE Pedido ADD ValorFinal number(12,2);
ALTER TABLE Produto ADD Prazo number(3);