import java.util.*;
public class EstrategiaNormal implements EstrategiaDeAtaque
{
    private static int count;
    public static int getCount(){
        return count;
    }
    public static void resetaCount(){
        count=0;
    }
    public void atacar(ExercitoElfos exercitoElfos,ArrayList<Dwarf> dwarves){
        exercitoElfos.agruparPorStatus();
        ArrayList<Elfo> exercito=exercitoElfos.buscar(Status.VIVO);
        double intencoesDeAtaque=exercito.size()*dwarves.size();
        for(Elfo elfo : exercito){
            for(Dwarf dwarf : dwarves){
                if(elfo instanceof ElfoNoturno){
                    count++;
                    if(count <= (intencoesDeAtaque*0.3)){
                        elfo.atirarFlecha(dwarf);
                    }else{
                        return;
                    }
                } else{
                    elfo.atirarFlecha(dwarf);
                }
            }
        }
    }
}
