
public class Snaga extends Orc
{
    public Snaga(){
        super();
        this.vida=70;
        inventario.adicionarItem(new Item("Arco",1));
        inventario.adicionarItem(new Item("Flecha",5));
    }
}
