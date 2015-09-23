

public class ElfoNoturno extends Elfo
{
    private double vidaDouble=(double)vida;
    public ElfoNoturno(String nome){
        super(nome);
    }
    public void atirarFlecha(Dwarf dwarf) {
        flechas--;
        experiencia+=3;
        dwarf.perderVida();
        this.perde5PorCentoVida();
    }
    public double getVidaDouble(){
        return vidaDouble;
    }
    private void perde5PorCentoVida(){
        vidaDouble-=(vidaDouble/100)*5;
    }
}
