namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Data : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Jogo", "DataDevolucao", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Jogo", "DataDevolucao", c => c.DateTime(nullable: false));
        }
    }
}
