
public class Elfo {
    private String nome;
    private int flechas, experiencia;
    private Status status;
    
    // Type initializer
     
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
        this.status=Status.VIVO;
    }
    
    public Elfo(String nome) {
        this(nome, 42);
    }
    
    public String toString(){
        String textoNivel="niveis";
        String textoFlecha="flechas";
        boolean nivelNoSingular=Math.abs(this.experiencia) == 1;
        boolean flechaNoSingular=Math.abs(this.flechas) == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência",this.nome,this.flechas,textoFlecha=flechaNoSingular ? "flecha" : "flechas",this.experiencia,textoNivel=nivelNoSingular ? "nivel" : "niveis");
    }
   
    public void atirarFlecha(Dwarf dwarf) {
        flechas--;
        experiencia++;
        dwarf.receberFlechada();
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
    public String getNome() {
        return this.nome;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
}
