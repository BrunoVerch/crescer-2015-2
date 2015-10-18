/*exercicio 1*/
function daisyGame(numPetalas){
	if(numPetalas % 2 ===0){
		console.log('love me not');
	} else {
		console.log('love me');
	}
}
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
}
/*exercicio 3*/
function imprime(array,func){
	if (typeof func === 'function') {
		for (var i = 0; i < array.length; i++) {
			console.log(func(array[i]));
		}
	} else{
		console.log('The second parameter needs to be function');
	}
}
/*exercicio 4*/
function fiboSum(num) {  
	var primeiro = 1, segundo = 1, count = 0, soma=0;  
	while (count < num) {
		soma+=primeiro;
		var aux = primeiro;	
		primeiro = segundo;	
		segundo += aux;	
		count++;  
	}
	console.log(soma);
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
}