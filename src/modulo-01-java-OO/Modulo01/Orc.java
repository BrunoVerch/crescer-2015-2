

public class Orc
{
   private int vida;
    private Inventario inventario;
    private Status status;

    public Orc()
    {
        this.inventario = new Inventario();
        this.status = Status.VIVO;
    }
    
    public void levarAtaqueDeAnao() {
        
        if(getItem("Escudo Uruk-Hai") == null){
            perderVida(10);
        }
        else {
            perderVida(5);
        }
    }
    
    public void levarAtaqueDeElfo() {
        perderVida(8);
    }
    
    public void atacarAnao(Dwarf anao){
        if(podeAtacarComEspada()){
            anao.recebeAtaqueDoOrc(this);
        }
        else if(podeAtacarComArco()) {
            anao.recebeAtaqueDoOrc(this);
            debitarFlecha();
        }
        else {
            this.status = Status.FUGINDO;
        }
    }
    
    public void atacarElfo(Elfo elfo){
        if(podeAtacarComEspada()){
            elfo.recebeAtaqueDoOrc(this);
        }
        else if(podeAtacarComArco()) {
            elfo.recebeAtaqueDoOrc(this);
            debitarFlecha();
        }
        else {
            this.status = Status.FUGINDO;
        }
    }
    public void recebeAtaqueDeElfo(Elfo elfo) {
        if(this.vida > 0){
            this.vida -= 8;
        }
        if(this.vida == 0){
            this.status=Status.MORTO;
        }
    }

    public void recebeAtaqueDeDwarf(Dwarf dwarf) {
        if(this.vida > 0){ 
            this.vida -= 10;
        }
        if(this.vida == 0){
            this.status=Status.MORTO;
        }
    }
    public int getDanoDeAtaque(){
        if(podeAtacarComEspada()){
            return 12;
        }
        
        if(podeAtacarComArco()){
            return 8;
        }
        
        return 0;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    private void debitarFlecha() {
        Item flecha = getItem("Flecha");
        
        if(flecha.getQuantidade() == 1){
            this.inventario.perderItem(flecha);
        }
        else {
            flecha.retirarUmaUnidade();
        }
    }
    
    private boolean podeAtacarComEspada() {
        return getItem("Espada") != null;
    }
    
    private boolean podeAtacarComArco(){
        boolean temArco = getItem("Arco") != null;
        Item flecha = getItem("Flecha");
        boolean temFlechaProArco = flecha != null && flecha.getQuantidade() > 0;
        
        return temArco && temFlechaProArco;
    }
    
    private void perderVida(int qtdVidaPerdida) {
        this.vida -= qtdVidaPerdida;
        
        if(vida <= 0){
            vida = 0;
            this.status = Status.MORTO;
        }
        else {
            this.status = Status.FERIDO;
        }
    }
    
    private Item getItem(String descricao){
        return this.inventario.getItemPorDescricao(descricao);
    }
}
