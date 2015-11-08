ALTER TABLE dbo.Jogo ADD Descricao varchar(255);
ALTER TABLE dbo.Jogo ADD IdSelo int constraint FK_IdSelo FOREIGN KEY REFERENCES Selo(Id);
ALTER TABLE dbo.Jogo ADD Imagem varchar(255) NULL;
ALTER TABLE dbo.Jogo ADD Video varchar(255) NULL;

update dbo.Jogo set IdSelo=3;
alter table dbo.Jogo alter column idSelo int not null;

update dbo.Jogo SET Descricao ='Sem descricao' where ID = 1;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 2;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 3;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 4;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 5;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 6;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 7;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 8;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 9;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 10;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 11;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 12;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 13;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 14;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 15;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 16;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 17;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 18;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 19;
update dbo.Jogo SET Descricao ='Sem descricao' where ID = 20;

alter table dbo.Jogo alter column Descricao varchar(255) not null;

