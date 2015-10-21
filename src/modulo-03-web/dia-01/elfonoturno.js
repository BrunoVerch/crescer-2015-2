function ElfoNoturno() {
  //super(nome,flechas)
  //Elfo.call(this,nome,flechas);
  Elfo.apply(this,arguments);
}

// extends
ElfoNoturno.prototype=Object.create(Elfo.prototype);

//override

//static
ElfoNoturno.alturaMedia=function () {
  return 2.15;
}
