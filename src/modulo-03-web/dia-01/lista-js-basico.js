/*exercicio 1*/
function daisyGame(numPetalas){
	if(numPetalas % 2 ===0){
		console.log('love me not');
	} else {
		console.log('love me');
	}
};
/*exercicio 2*/
function maiorTexto(arrayStrings){
	var maior=arrayStrings[0].length;
	var palavra=arrayStrings[0];
	for (var i = 0; i < arrayStrings.length; i++) {
		if(arrayStrings[i].length > maior){
			maior=arrayStrings[i].length;
			var palavra=arrayStrings[i];
		}
	}
	return palavra;
};
/*exercicio 3*/
function imprime(array,func){
	if (typeof func === 'function') {
		array.forEach(func);
	}
};
/*exercicio 4*/
function fiboSum(num) {
	var primeiro = 1, segundo = 1, count = 0, soma=0;
	while (count < num) {
		soma=primeiro+segundo;
		primeiro = segundo;
		segundo += soma;
		count++;
	};
	return soma;
/*exercicio 5*/
function excelis(letras) {
	if(letras.search(/[^a-zA-Z]+/) === -1){
	    letras = letras.toUpperCase();
	    var sum = 0;
	    for (var i = 0; i < letras.length; i++) {
	        sum = sum * 26 + letras.charCodeAt(i) - 64; //returns 1 for 'a' and 2 for 'b' so on and so forth.
	    }
	    return sum;
	} else {return 'Expressão inválida'}
};
/*exercicio 6*/
function queroCafe(mascada,precos){
	precos.sort(function(a, b){ return a > b});
	resposta=[];
	for (i=0;i<precos.length;i++) {
		if(precos[i] <= mascada){
			resposta.push(precos[i]);
		}
	} return resposta.join(',');
};
