use Locadora;
CREATE TABLE Selo (
	Id int NOT NULL CONSTRAINT PK_IDSelo PRIMARY KEY,
	Descricao varchar(10) NOT NULL
);

INSERT INTO dbo.Selo(Id,Descricao) VALUES (1,'OURO');
INSERT INTO dbo.Selo(Id,Descricao) VALUES (2,'PRATA');
INSERT INTO dbo.Selo(Id,Descricao) VALUES (3,'BRONZE');
