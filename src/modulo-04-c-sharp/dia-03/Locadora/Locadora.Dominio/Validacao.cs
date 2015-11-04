using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Validacao
    {
        public bool ValidaString(string palavra)
        {
            string alfabeto = "[a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,x,y,z]";
            if (string.IsNullOrWhiteSpace(palavra) || Regex.Matches(palavra, alfabeto).Count == 0)
            {
                Console.Write("Palavra invalida");
                Thread.Sleep(2000);
                return false;
            }
            else
                return true;
        }
        public bool VerificaSeENumero(string palavra)
        {
            if(!palavra.All(c=> char.IsDigit(c)))
            {
                Console.Write("Numero invalido");
                Thread.Sleep(2000);
                return false;
            }
            else
                return true;
        }
    }
}
