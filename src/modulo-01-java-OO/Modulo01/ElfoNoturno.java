

public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String nome){
        super(nome);
    }
    public ElfoNoturno(String nome,int flechas){
        super(nome,flechas);
    }
    public void atirarFlecha(Dwarf dwarf) {
        if(super.getFlechas()!=0){
            super.atirarFlecha(dwarf);
            experiencia+=2;
            vida-=(vida/100)*5;
            if(super.vida < 1){
                super.vida=0;
                super.status=Status.MORTO;
            }
        }
    }
}
