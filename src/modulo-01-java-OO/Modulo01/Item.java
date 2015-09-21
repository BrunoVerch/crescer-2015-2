

public class Item
{
    private String descricao;
    private int quantidade;
    
    public Item(String descricao,int quantidade){
        this.descricao=descricao;
        this.quantidade=quantidade;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public int getQuantidade(){
        return this.quantidade;
    }
    public void acrescenta1000(){
        this.quantidade+=1000;
    }
    public void acrescenta1000MaisQuantidade(){
        int soma=(this.quantidade*(this.quantidade+1))/2;
        this.quantidade+=soma;
        this.quantidade+=soma*1000;
    }
    /*
     * Exercicio de refatoraçao
    public void shimbalaie(){
        int pa = (this.quantidade * (this.quantidade+1)) / 2;
        this.quantidade += ((1000 * this.quantidade) + pa);
    }
    */
}
