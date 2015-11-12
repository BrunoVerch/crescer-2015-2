namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ValorData : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Jogo", "DataDevolucao", c => c.DateTime(nullable: true));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Jogo", "DataDevolucao");
        }
    }
}
