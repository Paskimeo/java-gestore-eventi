package jana60;

import java.time.LocalDate;

public class Conferenza extends Evento {
	private String argomento;
	private String oratore;

	public Conferenza(String titolo, LocalDate data, int postiTotali,String argomento,String oratore) throws Exception {
		super(titolo, data, postiTotali);
		this.argomento = argomento;
		this.oratore = oratore;
	}

	public String getArgomento() {
		return argomento;
		
	}

	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}

	public String getOratore() {
		return oratore;
	}

	public void setOratore(String oratore) {
		this.oratore = oratore;
	}

	@Override
	public String toString() {
		return super.toString()+ " questa è una conferenza riguardante: " + argomento + " esposto dalla persona col titolo di:  " + oratore;
	}
}
