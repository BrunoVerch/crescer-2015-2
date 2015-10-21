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

CarrinhoDeCompras.prototype.atualizarQuantidade = function(sku,quantidade){
  this.carrinho[this.index(sku)].quantidade = quantidade;
};

CarrinhoDeCompras.prototype.valorTotal = function () {
  var total = this.carrinho.reduce(function (value,elem) {
    return value + elem.subTotal();
  },0);
  return this.sortear(40) ? Math.floor(total*0.9) : total;
};

CarrinhoDeCompras.prototype.sortear = function(chance){
  if(Math.random()*100 < chance ){
    return true;
  } else {
    return false;
  }
};

CarrinhoDeCompras.prototype.forcarCompra = function () {
  if(!this.intervalo){
    var self=this;
    //guarda o id em uma propriedade do objeto
    this.intervalo = setInterval(function () {
      self.carrinho.forEach(function (elem) {
        elem.valorUnitario=elem.valorUnitario*1.1;
      })
    },5000);
  };
}

CarrinhoDeCompras.prototype.concluirPedido = function () {
  clearInterval(this.intervalo);
  delete this.intervalo;
};
