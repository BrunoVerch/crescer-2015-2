public class Dwarf extends Personagem{
    protected DataTerceiraEra dataNascimento;
    
    public Dwarf() {
        super();
        this.vida = 110;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    public Dwarf(String nome) {
        this();
        this.nome=nome;
    }
    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this(nome);
        this.dataNascimento = dataNascimento;
    }
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
    /*
    public void atacarOrc(Orc orc){
        orc.levarAtaqueDeAnao();
    }
    */
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
        if(this.getNumeroSorte() < 0){
            this.experiencia += 2;
        } else if(this.getNumeroSorte()>100){
                
            if(this.vida >= 10){
                this.vida -= 10;
            }
            if(this.vida == 0){
                this.status=Status.MORTO;
            }
        }
            
    }
    public void perderVida(){
        if(this.vida >= 10){
            this.vida -= 10;
        }
        if(this.vida == 0){
            this.status=Status.MORTO;
        }
    }
    public void tentarSorte() {
        double numero = getNumeroSorte();
        
        if (numero == -3333.0) {
            this.inventario.aumentar1000UnidadesEmCadaItem();
        }
    }
        
    
}