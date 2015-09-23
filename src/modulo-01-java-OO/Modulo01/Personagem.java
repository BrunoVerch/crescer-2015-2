

public class Personagem
{
    protected String nome;
    protected int experiencia;
    protected Status status;
    protected Inventario inventario;
    protected int vida;
    
    public Personagem(String nome){
        this();
        this.nome=nome;
    }
    public Personagem(){
        this.inventario=new Inventario();
        this.status=Status.VIVO;
    }
    public int getVida(){
        return this.vida;
    }
    public String getNome(){
        return this.nome;
    }
    public int getExperiencia(){
        return this.experiencia;
    }
    public Status getStatus(){
        return this.status;
    }
    public Inventario getInventario(){
        return this.inventario;
    }
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    public void perderItem(Item item) {
        this.inventario.perderItem(item);
    }
    public void recebeAtaqueDoOrc(Orc orc){
        if(this.vida > 0){
            vida -= orc.getDanoDeAtaque();
        }
        if(this.vida == 0){
            this.status=Status.MORTO;
        }
    }
}
