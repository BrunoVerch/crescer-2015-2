import java.util.ArrayList;
public class EstrategiaNoturnosUltimos implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ordemDoUltimoAtaque=new ArrayList<>();
    
    public ArrayList<Elfo> ordemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
     public void atacar(ExercitoElfos exercitoElfos,ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque.clear();
        exercitoElfos.agruparPorStatus();
        ArrayList<Elfo> exercito=exercitoElfos.buscar(Status.VIVO);
        ArrayList<Elfo> exercitoOrdenado=new ArrayList<>();
        for(Elfo elfo : exercito){
            if(elfo instanceof ElfoVerde){
                exercitoOrdenado.add(elfo);
            }
        }
        for(Elfo elfo : exercito){
            if(elfo instanceof ElfoNoturno){
                exercitoOrdenado.add(elfo);
            }
        }
        for(Elfo elfo : exercitoOrdenado){
            ordemDoUltimoAtaque.add(elfo);
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);
            }
        }
    }
}
