using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.MVC.Models
{
    public class ListaJogosModel
    {
        public int IdCliente { get; set; }
        public List<JogoDevolucaoModel> Jogos { get; set; }

        public ListaJogosModel()
        {
            Jogos = new List<JogoDevolucaoModel>();
        }
    }
}
