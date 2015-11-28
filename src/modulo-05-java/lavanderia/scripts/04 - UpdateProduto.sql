UPDATE Produto SET Prazo = 3;
COMMIT;
ALTER TABLE Produto MODIFY Prazo number(3) NOT NULL;

UPDATE Produto SET Situacao = 0;
COMMIT;
ALTER TABLE Produto MODIFY Situacao varchar2(1) NOT NULL;