
public class Elfo extends Personagem{
    private int flechas;
    private static int count;
    // Type initializer     
    public Elfo(String nome, int flechas) {
        super(nome);
        this.flechas = flechas;
    }
    
    public Elfo(String nome) {
        super(nome);
        this.flechas=42;
        this.vida=100;
        count++;
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
        if(this.flechas >=1){
            flechas--;
            experiencia++;
            dwarf.perderVida();
        }
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
    public static int getCount(){
        return count;
    }
    public static void resetaCount(){
        count=0;
    }

}
