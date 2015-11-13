namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class id : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.Jogo", name: "IdClienteLocacao", newName: "IdCliente");
            RenameIndex(table: "dbo.Jogo", name: "IX_IdClienteLocacao", newName: "IX_IdCliente");
        }
        
        public override void Down()
        {
            RenameIndex(table: "dbo.Jogo", name: "IX_IdCliente", newName: "IX_IdClienteLocacao");
            RenameColumn(table: "dbo.Jogo", name: "IdCliente", newName: "IdClienteLocacao");
        }
    }
}
