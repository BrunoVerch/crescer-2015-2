using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace Locadora.Web.MVC.Models
{
    public class JogoEditarCriarModel
    {
        public int Id { get; set; }
        [Required]     
        public string Nome { get; set; }
        [Required]
        public decimal Preco { get; set; }
        [Required]
        public string Categoria { get; set; }
        [Required]
        public string Descricao { get; set; }
        [Required]
        public string Selo { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }
    }
}