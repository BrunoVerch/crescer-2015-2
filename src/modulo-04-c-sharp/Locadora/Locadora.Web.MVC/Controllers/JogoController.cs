using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : BaseController
    {
        private IJogoRepositorio repositorio = null;

        [Autorizador]
        public ActionResult JogoDetalhes(int id)
        {
            repositorio = CriarJogoRepositorio();
            var jogo=repositorio.BuscarPorId(id);            
            var jogoModel = new JogoDetalheModel() { Nome = jogo.Nome, Preco = jogo.Preco, Categoria = jogo.Categoria.ToString(), Descricao = jogo.Descricao, Selo=jogo.Selo.ToString(), Imagem=jogo.Imagem, Video=jogo.Video };
            
            return View(jogoModel);
        }

        [HttpGet]
        [Autorizador(Roles = "ADMIN")]
        public ActionResult ManterJogo(int? id)
        {
            if (id.HasValue)
            {
                repositorio = CriarJogoRepositorio();
                var jogo = repositorio.BuscarPorId((int)id);
                var model = new JogoEditarCriarModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria,
                    Descricao = jogo.Descricao,
                    Selo = jogo.Selo,
                    Imagem = jogo.Imagem,
                    Video = jogo.Video
                };
                return View(model);
            }
            else
            {
                return View();
            }
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        [Autorizador(Roles ="ADMIN")]
        public ActionResult Salvar(JogoEditarCriarModel model)
        {
            if (ModelState.IsValid)
            {
                repositorio = CriarJogoRepositorio();
                bool ehParaCriar = model.Id == null;
                if (ehParaCriar)
                {
                    Jogo jogo = new Jogo()
                    {
                        Nome = model.Nome,
                        Categoria = model.Categoria,
                        Descricao = model.Descricao,
                        Preco = model.Preco,
                        Selo = model.Selo,
                        Imagem = model.Imagem,
                        Video = model.Video
                    };
                    repositorio.Criar(jogo);
                    TempData["Mensagem"] = "Jogo criado com sucesso!";
                }
                else
                {
                    Jogo jogo = new Jogo((int)model.Id)
                    {
                        Nome = model.Nome,
                        Categoria = model.Categoria,
                        Descricao = model.Descricao,
                        Preco = model.Preco,
                        Selo = model.Selo,
                        Imagem = model.Imagem,
                        Video = model.Video
                    };
                    repositorio.Atualizar(jogo);
                    TempData["Mensagem"] = "Jogo editado com sucesso!";
                }                         

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                return View("ManterJogo", model);
            }
        }
    }
}