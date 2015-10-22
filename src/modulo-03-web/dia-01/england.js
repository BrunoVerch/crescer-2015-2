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
function ordenaPorIndice(indice, times) {
  var clubes = [];
  times.sort(function(elemEsq, elemDir, clubes) {
    return elemEsq.titulos[indice].qtd < elemDir.titulos[indice].qtd;
  });
  return clubes;
};
//exercicio 1
function ordenaPorNacionais(array){
  return ordenaPorIndice(0, times);
};
function ordenaPorContinentais(array){
  return ordenaPorIndice(1, times);
};
function ordenaPorMundiais(array){
  return ordenaPorIndice(2, times);
};
//exercicio 2
//reduce (function)
function somarPorNacionais(array){
  return array.reduce(function(valor,elem) {
    return valor + elem.titulos[0].qtd;
  },0);
};
function somarPorContinentais(array){
  return array.reduce(function(valor,elem) {
    return valor + elem.titulos[1].qtd;
  },0);
};
function somarPorMundiais(array){
  return array.reduce(function(valor,elem) {
    return valor + elem.titulos[2].qtd;
  },0);
};
//exercicio 3
function apenasOsMelhores(array){
  return array.filter(function(elem) {
    return elem.titulos[0].qtd > 18;
  });
};
function calcularIdadeMedia(array){
  var soma= array
  .map(function (elem) { return new Date().getFullYear() - elem.fundacao.getFullYear();})
  .reduce(function (val,elem){
    return val + elem;
  },0);
  return soma/array.length;
}
