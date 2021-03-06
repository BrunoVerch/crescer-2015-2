﻿using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios
        {
            get; private set;
        }

        public BaseDeDados()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }
        /*Questão A*/
        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(f => f.Cargo.Titulo).ToList();
        }
        /*Questão B*/
        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.Where(f => f.Nome.Contains(nome)).OrderBy(f=>f.Nome).ToList();
        }
        /*Questão C*/
        public IList<dynamic> BuscaRapida(string nome)
        {
            IEnumerable<dynamic> query = from Funcionario in Funcionarios
                                         where Funcionario.Nome == nome
                                         select new
                                         {
                                             Nome = Funcionario.Nome,
                                             Titulo = Funcionario.Cargo.Titulo
                                         };
            return query.ToList();                    
        }
        /*Questão D
        Generally, you can use params when the number of arguments can vary from 0 to infinity,
        and use an array when numbers of arguments vary from 1 to infinity.
        http://stackoverflow.com/questions/7580277/why-use-the-params-keyword
        */
        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turno)
        {
            return Funcionarios.Where(f => turno.Contains(f.TurnoTrabalho)).ToList();
        }
        /*Questão E*/
        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            IEnumerable<dynamic> query = from Funcionario in Funcionarios
                                         group Funcionario by Funcionario.TurnoTrabalho into f
                                         select new
                                         {
                                             Turno = f.Key,
                                             Contagem = f.Count()
                                         };
            return query.ToList();
        }
        /*Questão F*/
        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(f=>f.Cargo.Titulo==cargo.Titulo).ToList();
        }
        /*Questão G*/
        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            DateTime dataAtual = DateTime.Now;
            return Funcionarios.Where(f=>(dataAtual.Year - f.DataNascimento.Year) > idade - 5 && (dataAtual.Year - f.DataNascimento.Year) < idade + 5).ToList();
        }
        /*Questão H*/
        public double SalarioMedio(params TurnoTrabalho[] turno)
        {            
            var funcionariosTurno = BuscarPorTurno(turno);
            return funcionariosTurno.Average(f=>f.Cargo.Salario);
        }
        //criado outro salario medio sem parametros para calcular a media de todos funcionarios
        public double SalarioMedio()
        {
            return Funcionarios.Average(f => f.Cargo.Salario);
        }
        /*Questão I*/
        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.Where(f => f.DataNascimento.Month == DateTime.Now.Month).ToList();
        }
        /*Questão J*/
        public dynamic FuncionarioMaisComplexo()
        {
            string listaConsoantes = "[b,c,d,f,g,h,j,k,l,m,n,p,q,r,s,t,v,x,y,z]";
            int maior = Funcionarios.Max(f => Regex.Matches(f.Nome, listaConsoantes).Count);
            Funcionario funcComplexo= Funcionarios.First(f => Regex.Matches(f.Nome, listaConsoantes).Count == maior);
            return new
            {
                Nome = funcComplexo.Nome,
                SalarioBR=funcComplexo.Cargo.Salario.ToString("C",new CultureInfo("pt-BR")),
                SalarioUSA="U$"+funcComplexo.Cargo.Salario.ToString("C", new CultureInfo("en-US"))
            };
        }

    }
}
