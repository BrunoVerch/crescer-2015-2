namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Jogo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 250),
                    Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    Categoria = c.Int(nullable: false),
                    Descricao = c.String(nullable: false, maxLength: 255),
                    Selo = c.Int(nullable: false),
                    Imagem = c.String(maxLength: 255),
                    Video = c.String(maxLength: 255),
                    IdClienteLocacao = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdClienteLocacao)
                .ForeignKey("dbo.Selo", t => t.Selo)
                .ForeignKey("dbo.Categoria", t => t.Categoria)
                .Index(t => t.IdClienteLocacao)
                .Index(t => t.Selo)
                .Index(t => t.Categoria);
            
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                    })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false, maxLength: 25),
                })
                .PrimaryKey(t => t.Id);

            InserirSelo();

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false, maxLength: 25),
                })
                .PrimaryKey(t => t.Id);

            InserirCategoria();

        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropForeignKey("dbo.Jogo", "Selo", "dbo.Selo");
            DropForeignKey("dbo.Jogo", "Categoria", "dbo.Categoria");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" , "Selo" , "Categoria" });
            DropTable("dbo.Cliente");
            DropTable("dbo.Jogo");
            DropTable("dbo.Selo");
            DropTable("dbo.Categoria");
        }

        private void InserirCategoria()
        {
            Sql("insert into dbo.Categoria values (1,'RPG')");
            Sql("insert into dbo.Categoria values (2,'CORRIDA')");
            Sql("insert into dbo.Categoria values (3,'AVENTURA')");
            Sql("insert into dbo.Categoria values (4,'LUTA')");
            Sql("insert into dbo.Categoria values (5,'ESPORTE')");
        }

        private void InserirSelo()
        {
            Sql("insert into dbo.Selo values (1,'OURO')");
            Sql("insert into dbo.Selo values (2,'PRATA')");
            Sql("insert into dbo.Selo values (3,'BRONZE')");
        }
    }
}
