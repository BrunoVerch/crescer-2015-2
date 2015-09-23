
public class UrukHai extends Orc
{
    public UrukHai(){
        super();
        this.vida=150;
        inventario.adicionarItem(new Item("Espada",1));
        inventario.adicionarItem(new Item("Escudo Uruk-Hai",1));
    }
}
