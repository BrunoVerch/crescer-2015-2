namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class insertJogo : DbMigration
    {
        public override void Up()
        {
            Sql("INSERT INTO dbo.Jogo VALUES ('Chrono Trigger',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Top Gear',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Megaman X',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Super Metroid',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Donkey Kong Country',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Super Mario Kart',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Super Street Fighter',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Mortal Kombat 2',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Killer Instinct',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Final Fight',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Super Mario 1',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Aladdin',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Rock ''n Roll Racing',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Zelda: A link to the past',1,'Sem descricao',1,null,null,null,null);" +
               "INSERT INTO dbo.Jogo VALUES('Final Fantasy VI',1,'Sem descricao',1,null,null,null,null);");
        }
        
        public override void Down()
        {
        }
    }
}
