using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public List<JogoModel> Jogos { get; set; }
        public int QuantidadeDeJogos { get; set; }

        public RelatorioModel()
        {
            Jogos = new List<JogoModel>();
        }
    }
}
