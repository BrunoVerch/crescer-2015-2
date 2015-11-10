using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    class CodeFirst : DbContext
    {
        public CodeFirst() : base("LOCADORACODE")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");

            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired().HasColumnName("Nome").HasMaxLength(250);
            Property(p => p.Preco).IsRequired().HasColumnName("Preco");
            Property(p => p.Descricao).IsRequired().HasColumnName("Descricao").HasMaxLength(255);
            Property(p => p.Imagem).IsOptional().HasColumnName("Imagem").HasMaxLength(255);
            Property(p => p.Video).IsOptional().HasColumnName("Video").HasMaxLength(255);

            HasOptional(p => p.ClienteLocacao).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");

            HasKey(p => p.Id);
            Property(p => p.Nome).IsRequired().HasColumnName("Nome").HasMaxLength(250);
        }
    }

    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(p => p.Id);

            Property(p => p.NomeCompleto).IsRequired().HasMaxLength(200);
            Property(p => p.Email).IsRequired().HasMaxLength(200);
            Property(p => p.Senha).IsRequired().HasMaxLength(256);

            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios).Map(m => { m.ToTable("Usuario_Permissao");
                m.MapLeftKey("IdUsuario");
                m.MapRightKey("IdPermissao");
            });
        }
    }

    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");

            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(200);
        }
    }
}

