namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class precoalterado : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Jogo", "Preco");
            Sql("insert into dbo.Usuario(Email,NomeCompleto,Senha) values ('admin@admin','Administrador','efae6035d9fc579f70e8653e4635197e');");
            Sql("insert into dbo.Permissao values ('ADMIN');");
            Sql("insert into dbo.Usuario_Permissao values (1,1);");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "Preco", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            Sql("delete from dbo.Usuario where Email = 'admin@admin'");
            Sql("delete from dbo.Permissao where Nome = 'ADMIN'");
            Sql("delete from dbo.Usuario_Permissao where IdUsuario = 1");
        }
    }
}
