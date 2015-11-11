using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Models
{
    public class JogoEditarCriarModel
    {
        public int? Id { get; set; }
        [Required]
        [StringLength(255, MinimumLength = 3, ErrorMessage = "O nome deve ter entre 3 e 255 caracteres")]
        public string Nome { get; set; }

        [Required]
        public Categoria Categoria { get; set; }

        [Required]
        public string Descricao { get; set; }

        [Required]
        public Selo Selo { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }
    }
}