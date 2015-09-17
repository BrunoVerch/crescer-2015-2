public class Dwarf {
    private int vida;
    private Status status;
    
    public void receberFlechada() {
            this.vida -= 10;
            if(this.vida == 0){
                this.status=Status.MORTO;
            }
    }
    
    public int getVida() {
        return this.vida;
    }
    public Status getStatus(){
        return this.status;
    }
    public Dwarf(){
        this.status=Status.VIVO;
        this.vida=110;
    }
}