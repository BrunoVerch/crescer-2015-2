using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using DbFuncionarios;

namespace UnitTestDbFuncionarios
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void FuncionariosOrdenadosPorCargo()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var ordenados = baseDeDados.OrdenadosPorCargo();

            Assert.AreNotEqual(funcionarios, ordenados);
        }

        [TestMethod]
        public void BuscaFuncionarioPorNome()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var carlos = funcionarios.Find(f => f.Nome == "Carlos Henrique");

            var realizado = baseDeDados.BuscarPorNome("Carlos Henrique");

            Assert.IsTrue(realizado.Contains(carlos));
        }
        [TestMethod]
        public void BuscaRapidaPorNome()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            dynamic carlos = new { Nome = "Carlos Henrique", Titulo = "Analista" };

            IList<dynamic> realizado = baseDeDados.BuscaRapida("Carlos Henrique");

            Assert.IsTrue(realizado.Contains(carlos));
        }

        //[TestMethod]
        //public void BuscaFuncionarioDoTurnoManha()
        //{
        //    var baseDeDados = new BaseDeDados();
        //    List<Funcionario> funcionarios = baseDeDados.Funcionarios;

        //    List<Funcionario> manha = new List<Funcionario>();
        //    var funcionariosTurnoManha = baseDeDados.BuscarPorTurno(TurnoTrabalho.Manha);

        //    Assert.IsTrue(funcionariosTurnoManha);
        //}
        [TestMethod]
        public void QtdFuncionariosPorTurno()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var qtd = baseDeDados.QtdFuncionariosPorTurno();

            Assert.AreEqual(3,qtd.Count);
        }
    }
}
