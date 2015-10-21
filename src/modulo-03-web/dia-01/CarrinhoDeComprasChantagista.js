CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

function CarrinhoDeComprasChantagista () {
	CarrinhoDeCompras.apply(this, arguments);
};

CarrinhoDeComprasChantagista.prototype.forcarCompra = function () {
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

CarrinhoDeComprasChantagista.prototype.concluirPedido = function () {
  clearInterval(this.intervalo);
  delete this.intervalo;
};

