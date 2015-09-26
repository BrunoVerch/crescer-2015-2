import java.util.*;
public class EstrategiaNormal implements EstrategiaDeAtaque
{
    private static int count;
    private ArrayList<Elfo> ordemDoUltimoAtaque=new ArrayList<>();
    public static int getCount(){
        return count;
    }
    public static void resetaCount(){
        count=0;
    }
    public ArrayList<Elfo> ordemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
    public void atacar(ExercitoElfos exercitoElfos,ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque.clear();
        exercitoElfos.agruparPorStatus();
        ArrayList<Elfo> exercito=exercitoElfos.buscar(Status.VIVO);
        int intencoesDeAtaque=exercito.size()*dwarves.size();
        double porcentagemElfosNoturnos=intencoesDeAtaque*0.3;
        for(Elfo elfo : exercito){
            if((elfo instanceof ElfoNoturno && count < (int)porcentagemElfosNoturnos) || elfo instanceof ElfoVerde){  
                   ordemDoUltimoAtaque.add(elfo);
             }
            for(Dwarf dwarf : dwarves){
                if(elfo instanceof ElfoNoturno){
                    count++;
                    if(count <= ((int)porcentagemElfosNoturnos)){
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
