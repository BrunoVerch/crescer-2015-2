var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }, 
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];
function orderDESC(array){ return array.sort(function(a, b){ return a < b})};
//exercicio 1
function ordenaPorNacionais(array){
  var resposta=[];
   array.forEach(function(elem) {
      resposta.push(elem.titulos[0].qtd);
    })
   orderDESC(resposta);
   return resposta;
};
function ordenaPorContinentais(array){
  var resposta=[];
   array.forEach(function(elem) {
      resposta.push(elem.titulos[1].qtd);
    })
   orderDESC(resposta);
   return resposta;
};
function ordenaPorMundiais(array){
  var resposta=[];
   array.forEach(function(elem) {
      resposta.push(elem.titulos[2].qtd);
    })
   orderDESC(resposta);
   return resposta;
};
