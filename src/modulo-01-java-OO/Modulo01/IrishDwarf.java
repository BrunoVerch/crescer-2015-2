public class IrishDwarf extends Dwarf{

    public IrishDwarf(String nome) {
        super(nome);
    }
    public IrishDwarf(){
        //chama o super() implicitamente
    }
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        super(nome,dataNascimento);
    }
    public void tentarSorte(){
        if(this.getNumeroSorte()==(-3333.0)){
            for(int i=0;i<getInventario().getListaItens().size();i++){
                this.getInventario().getListaItens().get(i).acrescenta1000MaisQuantidade();
            }
        }
    } 
}
