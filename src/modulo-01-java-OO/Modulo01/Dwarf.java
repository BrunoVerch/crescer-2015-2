public class Dwarf {
    private int vida;
    private Status status;
    private String nome;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    
    public void receberFlechada() {
            if(this.vida >=10){
                this.vida -= 10;
            }
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
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
    public String getNome(){
        return this.nome;
    }
    public Dwarf(String nome){
        this.nome=nome;
        this.status=Status.VIVO;
        this.vida=110;
        this.dataNascimento= new DataTerceiraEra(1,1,1);
    }
    public Dwarf(String nome,DataTerceiraEra dataNascimento){
        this(nome);
        this.dataNascimento=dataNascimento;
    }
}