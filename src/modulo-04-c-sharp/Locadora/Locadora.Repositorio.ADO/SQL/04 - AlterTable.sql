ALTER TABLE dbo.Jogo ADD Descricao varchar(255) NOT NULL DEFAULT 'Sem Descricao';
ALTER TABLE dbo.Jogo ADD IdSelo int NOT NULL DEFAULT 3;/*Foreign key*/
ALTER TABLE dbo.Jogo ADD CONSTRAINT FK_Jogo_Selo FOREIGN KEY (IdSelo) 
    REFERENCES dbo.Selo(Id);
ALTER TABLE dbo.Jogo ADD Imagem varchar(255) NULL;
ALTER TABLE dbo.Jogo ADD Video varchar(255) NULL;

