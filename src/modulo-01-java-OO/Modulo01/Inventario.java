import java.util.ArrayList;
public class Inventario
{
    private ArrayList<Item> listaItens;
    
    public Inventario(){
        this.listaItens=new ArrayList<Item>();
    }
    public ArrayList<Item> getListaItens(){
        return listaItens;
    }
    public void adicionarItem(Item item){
        listaItens.add(item);
    }
    public void perderItem(Item item){
        listaItens.remove(item);
    }
    public String getDescricoesItens(){
        int tamanho=getListaItens().size();
        StringBuilder strBuilder = new StringBuilder();
        for(int x=0;x<tamanho;x++){
            if(x<(tamanho-1)){
                strBuilder.append(getListaItens().get(x).getDescricao()).append(",");
            }else{
                strBuilder.append(getListaItens().get(x).getDescricao());
            }
        }
        return strBuilder.toString();
    }
}
