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
                .Index(t => t.IdClienteLocacao);
            
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
                    Id = c.Int(nullable: false, identity: true),
                    Descricao = c.String(nullable: false, maxLength: 25),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Descricao = c.String(nullable: false, maxLength: 25),
                })
                .PrimaryKey(t => t.Id);

        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" });
            DropTable("dbo.Cliente");
            DropTable("dbo.Jogo");
        }
    }
}
