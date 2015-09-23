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
    public void aumentar1000UnidadesEmCadaItem() {
        for (Item item : this.listaItens) {
            item.acrescenta1000();
        }
    }
    public void aumentarUnidadesComSomatorio() {
        for (Item item : this.listaItens) {
            item.acrescenta1000MaisQuantidade();
        }
    }
    public Item getItemPorDescricao(String descricao){
        for(Item item : this.listaItens){
            if(item.getDescricao().equals(descricao)) {
                return item;
            }
        }
        return null;
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
    /*
    public Item getItemComMaiorQuantidade() {
        int indice = 0, maiorQtd = 0;
        
        for (Item item : this.itens) {
            int qtdAtual = item.getQuantidade();
            if (qtdAtual > maiorQtd) {
                indice = this.itens.indexOf(item);
                maiorQtd = qtdAtual;
            }
        }
        return this.itens.get(indice);
    }
    */
    public void ordenarItens(){
        Item aux;  
        for(int x=0;x<getListaItens().size();x++){
             for (int i = 0; i < getListaItens().size(); i++) { 
                 if (getListaItens().get(i).getQuantidade() > getListaItens().get(x).getQuantidade()) {
                    aux = getListaItens().get(i);
                    this.getListaItens().set(i, this.getListaItens().get(x));
                    this.getListaItens().set(x, aux);
                 } 
             } 
        }
    }
    }

