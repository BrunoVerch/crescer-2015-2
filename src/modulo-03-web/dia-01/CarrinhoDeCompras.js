function CarrinhoDeCompras(){
  this.carrinho=new array();
};

CarrinhoDeCompras.prototype.adicionarItem = function (itens) {
  this.carrinho.push(itens);
};
CarrinhoDeCompras.prototype.removerItem = function (sku1) {
  this.carrinho.forEach(function (elem,index) {
    if (elem.sku === sku1) {
      carrinho.splice(index,1);
    }
  });
};



function Itens(sku,descricao, quantidade, valorUnitario){
  this.sku=sku;
  this.descricao=descricao;
  this.quantidade=quantidade;
  this.valorUnitario=valorUnitario;
};
