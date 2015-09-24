import java.util.HashMap;
public class ExercitoElfos
{
    HashMap<String,Elfo> exercito;
    public ExercitoElfos(){
        this.exercito=new HashMap<>();
    }
    public HashMap getHashMap(){
        return exercito;
    }
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercito.put(elfo.getNome(),elfo);
        }
    }
    public Elfo buscarElfo(Elfo elfo){
        return exercito.get(elfo.getNome());
    }
}
