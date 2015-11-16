using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Infraestrutura.Servicos;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class UsuarioController : Controller
    {
        public ActionResult CadastroUsuario()
        {
            return View();
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(UsuarioModel usuario)
        {            
            if (ModelState.IsValid)
            {
                if (!usuario.Senha.Equals(usuario.ConfirmarSenha))
                {
                    TempData["SenhaInvalida"] = "As senhas são diferentes!";
                    return View("CadastroUsuario", usuario);
                }
                IUsuarioRepositorio repositorio = new UsuarioRepositorio();
                IServicoCriptografia servico = new ServicoCriptografia();
                Usuario user = new Usuario()
                {
                    NomeCompleto = usuario.NomeCompleto,
                    Email = usuario.Email,
                    Senha = servico.CriptografarSenha(usuario.Senha)
                };
                repositorio.Criar(user);
                TempData["Mensagem"] = "Usuario salvo com sucesso!";
                return RedirectToAction("Index", "Home");
            }
            else
            {
                TempData["Mensagem"] = "Não foi possivel cadastrar!";
            }
            return View("CadastroUsuario", usuario);
        }
    }
}