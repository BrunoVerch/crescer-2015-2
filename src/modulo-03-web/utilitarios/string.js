String.prototype.ehPalindromo = function() {
	return (this.toLowerCase().split('').reverse().join('')) === this.toLowerCase();
};