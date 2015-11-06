﻿using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        private IJogoRepositorio repositorio = new Locadora.Repositorio.ADO.JogoRepositorio();

        public ActionResult JogoDetalhes(int id)
        {
            var jogo=repositorio.BuscarPorId(id);            
            var jogoModel = new JogoDetalheModel() { Nome = jogo.Nome, Preco = jogo.Preco, Categoria = jogo.Categoria.ToString(), Descricao = jogo.Descricao, Selo=jogo.Selo.ToString(), Imagem=jogo.Imagem, Video=jogo.Video };
            
            return View(jogoModel);
        }

        public ActionResult ManterJogo(int? id)
        {
            if (id.HasValue)
            {               
                var jogo = repositorio.BuscarPorId((int)id);
                var model = new JogoEditarCriarModel() { Id = jogo.Id, Nome = jogo.Nome, Preco = jogo.Preco, Categoria = jogo.Categoria.ToString(), Descricao = jogo.Descricao, Selo = jogo.Selo.ToString(), Imagem = jogo.Imagem, Video = jogo.Video };
                return View(model);
            }
            else
            {
                return View();
            }
        }

        public ActionResult Salvar(JogoEditarCriarModel model)
        {

            if (ModelState.IsValid)
            {
                TempData["Mensagem"] = "Cliente salvo com sucesso!";

                return RedirectToAction("Index", "Cliente");
            }
            else
            {
                return View("Manter", model);
            }
        }
    }
}