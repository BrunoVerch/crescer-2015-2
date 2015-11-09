using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.DbFirst
{
    class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");

            HasKey(p=>p.Id);

            Property(p => p.Nome).IsRequired().HasColumnName("Nome").HasMaxLength(250);
            Property(p => p.Preco).IsRequired().HasColumnName("Preco");
            Property(p => p.Descricao).IsRequired().HasColumnName("Descricao");
            Property(p => p.Imagem).IsOptional().HasColumnName("Imagem").HasMaxLength(255);
            Property(p => p.Video).IsOptional().HasColumnName("Video").HasMaxLength(255);

            HasOptional(p => p.ClienteLocacao).WithOptionalDependent().Map(m=>m.MapKey("IdClienteLocacao"));
        }
    }
}
