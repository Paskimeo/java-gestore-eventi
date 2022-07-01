package jana60;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	//attributi
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	private LocalDate oggi = LocalDate.now();
	private DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	
	//costruttori
	public Evento(String titolo, LocalDate data, int postiTotali, int postiPrenotati)throws Exception {
		super();
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
		
		controlloData();
		controlloPosti();
		prenotazioni();
		disdetta();
	}

	//get e set
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public int getPostiTotali() {
		return postiTotali;
	}


	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}

	//controlli
	//controllo data
	public void controlloData() throws Exception
	{
		if(oggi.isAfter(data)) {
			throw new Exception ("Data errata, non puo essere fatta pria della data odierna");
		}
	}
	
	//controllo posti
	public void controlloPosti() throws Exception
	{
		if(postiTotali<0) {
			throw new Exception ("deve esserci almeno 1 persona a presenziare");
		}
	}
	
	
	//controllo  prenotazioni
	public int prenotazioni() throws Exception
	{
		if( postiTotali <= 0) {
			throw new Exception ("senza prenotazioni non si fa nulla");
		}
		return postiPrenotati += 1;
	}
	
	
	//controllo  Disdetta
		public int disdetta() throws Exception
		{
			if(oggi.isAfter(data) || postiPrenotati <= 0) {
				throw new Exception ("L'evento è passato o non ci sono piu  posti");
			}
			return postiPrenotati -= 1;
		}
		
		// metordi
		public int numeroPrenotazioni() {
			return postiTotali - postiPrenotati;
		}
		
		
	
	  @Override
	  public String toString() {
		  return "in data " + data +" l'evento " + titolo + " è stato creato ";
	  }
	
	
}
