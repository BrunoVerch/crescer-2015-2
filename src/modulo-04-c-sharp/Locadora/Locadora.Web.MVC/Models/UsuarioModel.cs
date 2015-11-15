using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.MVC.Models
{
    public class UsuarioModel
    {
        [Required]
        [StringLength(200)]
        public string NomeCompleto { get; set; }

        [Required]
        [StringLength(200)]
        [EmailAddress(ErrorMessage = "Email invalido")]
        public string Email { get; set; }

        [Required]
        [StringLength(20)]
        public string Senha { get; set; }

        [Required]
        [StringLength(20)]
        public string ConfirmarSenha { get; set; }
    }
}
