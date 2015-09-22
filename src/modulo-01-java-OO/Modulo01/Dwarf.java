public class Dwarf extends Personagens{
    protected int vida;
    protected Status status;
    protected String nome;
    protected int experiencia;
    protected DataTerceiraEra dataNascimento;
    protected Inventario inventario;
    
    public Dwarf() {
        super();
        this.vida = 110;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    public Dwarf(String nome) {
        super(nome);
        this.vida = 110;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        super(nome);
        this.dataNascimento = dataNascimento;
    }
    public Inventario getInventario(){
        return this.inventario;
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
    public int getExperiencia(){
        return this.experiencia;
    }
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    public void perderItem(Item item) {
        this.inventario.perderItem(item);
    }
    public Double getNumeroSorte(){
        double valorInicial=101.0;
        if(this.dataNascimento.ehBissexto() && (this.vida >= 80 && this.vida <=90)){
                return valorInicial*(-33);
        }
        if(!dataNascimento.ehBissexto() && this.nome != null && this.nome=="Seixas" || this.nome=="Meireles"){
            int valorA=100;
            double valorB=(double) valorA;
            return (valorInicial*33)%valorB;
        }
        
        return valorInicial;
    }
    public void receberFlechada() {
            if(this.status==Status.VIVO){
                if(this.getNumeroSorte() < 0){
                    this.experiencia += 2;
                } else if(this.getNumeroSorte()>100){
                     this.perderVida();  
                }
            }
    }
    public void perderVida(){
        if(this.status==Status.VIVO){
            if(this.vida >= 10){
                this.vida -= 10;
            }
            if(this.vida == 0){
                this.status=Status.MORTO;
            }
        }
    }
    public void tentarSorte() {
        double numero = getNumeroSorte();
        
        if (numero == -3333.0) {
            this.inventario.aumentar1000UnidadesEmCadaItem();
        }
    }
        
    
}