import java.util.ArrayList;
public class EstrategiaAtaqueIntercalado implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ordemDoUltimoAtaque=new ArrayList<>();
    
    public ArrayList<Elfo> ordemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
     public void atacar(ExercitoElfos exercitoElfos,ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque.clear();
        exercitoElfos.agruparPorStatus();
        ArrayList<Elfo> exercito=exercitoElfos.buscar(Status.VIVO);
        if(exercito.size()%2 == 0){
            ArrayList<Elfo> exercitoElfosVerdes=new ArrayList<>();
            for(Elfo elfo : exercito){
                if(elfo instanceof ElfoVerde){
                    exercitoElfosVerdes.add(elfo);
                }
            }
            ArrayList<Elfo> exercitoElfosNoturnos=new ArrayList<>();
            for(Elfo elfo : exercito){
                if(elfo instanceof ElfoNoturno){
                    exercitoElfosNoturnos.add(elfo);
                }
            }
            if(exercitoElfosNoturnos.size()==exercitoElfosVerdes.size()){
                exercito.clear();
                for (int i = 0; i < exercitoElfosNoturnos.size(); i++) {   
                        exercito.add(exercitoElfosVerdes.get(i));  
                        exercito.add(exercitoElfosNoturnos.get(i));
                }
                for(Elfo elfo : exercito){
                    ordemDoUltimoAtaque.add(elfo);
                    for(Dwarf dwarf : dwarves){
                        elfo.atirarFlecha(dwarf);
                    }
                }
            }
        }
    }
}
