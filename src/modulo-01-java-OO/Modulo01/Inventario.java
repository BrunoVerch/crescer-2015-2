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
        StringBuilder strBuilder = new StringBuilder();
        for(int x=0;x<getListaItens().size();x++){
            strBuilder.append(getListaItens().get(x).getDescricao());
            if(x<(getListaItens().size()-1)){
                strBuilder.append(",");
            }
        }
        return strBuilder.toString();
    }
    public Item getItemComMaiorQuantidade(){
        int itemMaiorQuantidade=getListaItens().get(0).getQuantidade();
        Item itemMaior=getListaItens().get(0);
        for(int i=1;i<getListaItens().size();i++){
            if(getListaItens().get(i).getQuantidade()>itemMaiorQuantidade){
                itemMaiorQuantidade=getListaItens().get(i).getQuantidade();
                itemMaior=getListaItens().get(i);
            }
        }
        return itemMaior;
    }
}
