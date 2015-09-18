
public class DataTerceiraEra
{
    private int dia,mes,ano;
    
    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAno(){
        return this.ano;
    }
    public boolean ehBissexto(){
        if(((this.ano % 4 == 0) && (this.ano % 100 != 0)) || (this.ano % 400 == 0)){
            return true;
        } else {
            return false;
        }
    }
    public DataTerceiraEra(int dia,int mes,int ano){
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }
}
