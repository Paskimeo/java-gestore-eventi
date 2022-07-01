package jana60;

public class Oratore {

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Oratore(String nome, String cognome, String titolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.titolo = titolo;
	}

	private String nome,cognome,titolo;
}
