public class Elfo{

	private String nome;
	private int flechas;
	private static final boolean orelhasgrandes=true;
	private int experiencia=0;

	//gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFlechas() {
		return flechas;
	}

	public void setFlechas(int flechas) {
		this.flechas = flechas;
	}

	public int getExperiencia() {
		return experiencia;
	}

	//metodos
	public void atirarFlecha(){
		experiencia++;
		flechas--;
	}

	//construtores
	public Elfo(String nome){
		this.nome=nome;
                this.flechas=42;
	}

	public Elfo(String nome, int flechas){
		this.nome=nome;
		this.flechas=flechas;
	}


}
