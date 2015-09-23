
public class Elfo extends Personagem{
    protected int flechas;
    
    // Type initializer
     
    public Elfo(String nome, int flechas) {
        super(nome);
        this.flechas = flechas;
    }
    
    public Elfo(String nome) {
        super(nome);
        this.flechas=42;
        this.vida=100;
    }
    
    public String toString(){
        String textoNivel="niveis";
        String textoFlecha="flechas";
        boolean nivelNoSingular=Math.abs(this.experiencia) == 1;
        boolean flechaNoSingular=Math.abs(this.flechas) == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência",this.nome,this.flechas,textoFlecha=flechaNoSingular ? "flecha" : "flechas",this.experiencia,textoNivel=nivelNoSingular ? "nivel" : "niveis");
    }
    public void atacarOrc(Orc orc){
        orc.levarAtaque();
    }
   
    public void atirarFlecha(Dwarf dwarf) {
        flechas--;
        experiencia++;
        dwarf.perderVida();
    }
    /*
    public void atirarFlechaRefactory(){
        boolean acertar = true;
        if (acertar) {
            experiencia++;
        }
        flechas--;
    }
    */

    
    public int getFlechas() {
        return this.flechas;
    }

}
