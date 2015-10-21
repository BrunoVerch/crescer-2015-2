function CarrinhoDeCompras(){
  this.carrinho=[];
};
CarrinhoDeCompras.prototype.adicionarItem = function (itens) {
  this.carrinho.push(itens);
};

CarrinhoDeCompras.prototype.removerItem = function (sku) {
  this.carrinho.splice(this.index(sku),1);
};
CarrinhoDeCompras.prototype.index = function(sku){
  return this.carrinho.map(function(elem) { 
    return elem.sku; 
   }).indexOf(sku);
};