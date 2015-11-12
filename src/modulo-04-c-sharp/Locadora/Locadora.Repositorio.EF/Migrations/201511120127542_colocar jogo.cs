namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class colocarjogo : DbMigration
    {
        public override void Up()
        {
            Sql("insert into dbo.Jogo(Nome,Categoria,Descricao,Selo) values ('Chrono Trigger',1,'Sem descricao',1);");
        }
        
        public override void Down()
        {
            Sql("delete from dbo.Jogo where Id=1;");
        }
    }
}
