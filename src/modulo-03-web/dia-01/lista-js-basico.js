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

