using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Mapping
{
    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");

            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired().HasColumnName("Nome").HasMaxLength(250);
            Property(p => p.Descricao).IsRequired().HasColumnName("Descricao").HasMaxLength(255);
            Property(p => p.Imagem).IsOptional().HasColumnName("Imagem").HasMaxLength(255);
            Property(p => p.Video).IsOptional().HasColumnName("Video").HasMaxLength(255);
            Property(p => p.DataLocacao).IsOptional().HasColumnName("DataDevolucao");
            Property(p => p.Categoria).IsRequired().HasColumnName("Categoria");
            Property(p => p.Selo).IsRequired().HasColumnName("Selo");

            HasOptional(p => p.ClienteLocacao).WithMany().HasForeignKey(x => x.IdCliente);
        }
    }
}
