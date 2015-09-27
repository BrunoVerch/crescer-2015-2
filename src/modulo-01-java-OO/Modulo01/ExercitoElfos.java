import java.util.*;
public class ExercitoElfos
{
    HashMap<String, Elfo> exercito;
    HashMap<Status, ArrayList<Elfo>> grupoStatus;
    private EstrategiaDeAtaque estrategia=new EstrategiaNormal();
    public ExercitoElfos(){
        this.exercito=new HashMap<>();
    }
    public HashMap<String,Elfo> getExercito(){
        return exercito;
    }
    public HashMap<Status,ArrayList<Elfo>> getGrupoStatus(){
        return grupoStatus;
    }
    public EstrategiaDeAtaque getEstrategia(){
        return estrategia;
    }
    public void mudarEstrategia(EstrategiaDeAtaque estrategia){
        this.estrategia=estrategia;
    }
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercito.put(elfo.getNome(),elfo);
        }
    }
    public Elfo buscarElfo(Elfo elfo){
        return exercito.get(elfo.getNome());
    }
    public void agruparPorStatus(){
        grupoStatus=new HashMap<>();
        //for each _____values retorna coleção de valores
        for(Elfo elfo : exercito.values()){
            if(!grupoStatus.containsKey(elfo.getStatus())){
                grupoStatus.put(elfo.getStatus(),new ArrayList<Elfo>());
            }
            grupoStatus.get(elfo.getStatus()).add(elfo);
        }
    }
    public ArrayList<Elfo> buscar(Status status){
        return grupoStatus.get(status);
    }
    public boolean equals(Object obj) {
        ExercitoElfos outro = (ExercitoElfos)obj;
        return this.exercito.equals(outro.getExercito());
    }
}
