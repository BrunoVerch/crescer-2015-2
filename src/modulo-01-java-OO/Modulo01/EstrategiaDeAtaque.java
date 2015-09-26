import java.util.ArrayList;
public interface EstrategiaDeAtaque
{
    ArrayList<Elfo> ordemDoUltimoAtaque();
    void atacar(ExercitoElfos exercito, ArrayList<Dwarf> dwarves);
}
