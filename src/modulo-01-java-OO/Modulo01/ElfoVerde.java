

public class ElfoVerde extends Elfo
{
    public ElfoVerde(String nome, int flechas) {
        super(nome, flechas);
    }
    public ElfoVerde(String nome) {
        super(nome);
    }
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia++;
    }
    public void adicionarItem(Item item) {
        boolean podeAdicionar = item != null && item.getDescricao() != null && (item.getDescricao().equals("Espada de aço valiriano") || 
                                 item.getDescricao().equals("Arco e flecha de vidro"));
        if (podeAdicionar) {
            super.adicionarItem(item);
        }
    }
}
