using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.MVC.Models
{
    public class JogoDevolucaoModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public DateTime DataLocacao { get; set; }
        public decimal ValorTotal { get; set; }
    }
}
