using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.Models
{
    public class RelatorioModel
    {
        public List<Jogo> Relatorio { get; }
        public int QuantidadeTotalJogos { get; }
        public double ValorMedioJogo { get; }
        public string JogoMaisCaro { get; }
        public string JogoMaisBarato { get; }

        public RelatorioModel()
        {
            BibliotecaDeJogos banco = new BibliotecaDeJogos();
            this.Relatorio = banco.GetJogos();
            this.QuantidadeTotalJogos = Relatorio.Count;
            this.ValorMedioJogo = banco.ValorMedioJogo(Relatorio);
            this.JogoMaisCaro = banco.JogoMaisCaro(Relatorio);
            this.JogoMaisBarato = banco.JogoMaisBarato(Relatorio);
        }
    }
}
