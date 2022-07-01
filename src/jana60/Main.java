package jana60;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		
		Scanner scan = new Scanner(System.in);
		String confermaPren;
		String confermaDis;
		String confermaConf;
		boolean flag = false;
		boolean flagConf = false;
		int posti = 0;
		int giorno = 0;
		int mese= 0;
		int anno = 0;
		
		
		
		//richiesta dati
		System.out.println("inserisci il titolo dell'evento: ");
		String titolo = scan.nextLine();
		try {
		System.out.println("inserisci il numero di posti disponibili: ");
		 posti = Integer.parseInt(scan.nextLine());
		
		System.out.println("inserisci il giorno: ");
		 giorno = Integer.parseInt(scan.nextLine());
		
		System.out.println("inserisci il mese: ");
		 mese = Integer.parseInt(scan.nextLine());
		
		
		System.out.println("inserisci l'anno: ");
		 anno = Integer.parseInt(scan.nextLine());
	
	} catch (DateTimeException e) {
		System.out.println("I valori devono essere numeri.");
	} catch (NumberFormatException ny) {
		System.out.println("I valori devono essere numeri.");
	} catch (Exception dwa) {
		System.out.println(" riscontrato un errore, riprova.");
		
	} 
	
	//domanda se si sta organizando una conferenza
			do {
				
				System.out.print("E' una conferenza quella che stai organizzando? rispondi si o no: ");
				confermaConf = scan.nextLine();
			
				if(!confermaConf.equalsIgnoreCase("si") && !confermaConf.equalsIgnoreCase("no"))
				System.out.println("Rispondi solo Si o No.");
			
			}while(!confermaConf.equalsIgnoreCase("no") && !confermaConf.equalsIgnoreCase("si"));
			
			
			if(confermaConf.equalsIgnoreCase("si")) {
				System.out.println("Qual'è l'argomento della conferenza?");
				 String argomento = scan.nextLine();
				
				System.out.println("chi è l'oratore?");
				 String oratore = scan.nextLine();
				
				 System.out.println("qual'è il nome dell'oratore");
				 String nome = scan.nextLine();
			
				 System.out.println("qual'è il cognome dell'oratore");
				 String cognome = scan.nextLine();
				 
				 System.out.println("qual'è il titolo dell'oratore");
				 String titoloOratore = scan.nextLine();
			
				 try {
					 LocalDate data = LocalDate.of(anno, mese, giorno);
					Conferenza conf = new Conferenza(titolo, data, posti, argomento, titoloOratore);
					System.out.println(conf.toString() + " il cui nome è "+nome + " e il suo cognome è " + cognome );
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
			
				 
				 
				 
				 
			}else if(confermaConf.equalsIgnoreCase("no")) {
				flagConf = true;
			
		}
	
		// fine domanda se  è conferenza
			
	
	
		
	    
		//salvataggio dati
		try {
		
		LocalDate data = LocalDate.of(anno, mese, giorno);
		
		Evento evento = new Evento(titolo, data, posti);
		System.out.println(evento.toString());
		
		
		
		//cicolo per richiesta prenotazioni
		do 
		{
			
			System.out.print("Vuoi inserire delle prenotazioni? ");
			confermaPren = scan.nextLine();
		
			if(!confermaPren.equalsIgnoreCase("si") && !confermaPren.equalsIgnoreCase("no"))
			System.out.println("Rispondi solo Si o No.");
		
		}while(!confermaPren.equalsIgnoreCase("no") && !confermaPren.equalsIgnoreCase("si"));
		
		if(confermaPren.equalsIgnoreCase("si")) {
			System.out.println("quante prenotazioni vuoi effettuare? ");
		int prenotazioni = Integer.parseInt(scan.nextLine());
		
		evento.numeroPrenotazioni(prenotazioni);
		
	
		
		System.out.println(evento.toString() + "prenotazione effettuate " +  evento.getPostiPrenotati() + " Totale posti disponibili " + (evento.getPostiTotali()- prenotazioni));
	
		//ciclo per richiesta disdire
		int postiRimasti = evento.getPostiTotali()- prenotazioni;
		do 
		{
			
			System.out.print("Vuoi per caso disdire delle prenotazioni prima di uscire ? ");
			confermaDis = scan.nextLine();
		
			if(!confermaDis.equalsIgnoreCase("si") && !confermaDis.equalsIgnoreCase("no"))
			System.out.println("Rispondi solo Si o No.");
		
		}while(!confermaDis.equalsIgnoreCase("no") && !confermaDis.equalsIgnoreCase("si"));
	
		if(confermaDis.equalsIgnoreCase("si")) {
			System.out.println("quante disdette vuoi effettuare? ");
			int disdetta = Integer.parseInt(scan.nextLine());
			evento.numeroDisdette(disdetta);
			
			if(disdetta > evento.getPostiPrenotati()) {
				System.out.println("non puoi disdire, dei posti oltre il tuo numero massimo");
			}
			
			System.out.println(evento.toString() + "disdetta effettuate " +  disdetta + " Totale posti rimasti " + (postiRimasti + disdetta) );
		
		
			
		}else if (confermaPren.equalsIgnoreCase("no"))
		
			flag = true;
		
		
		}
			if(flagConf = true) {
				
			}
	
		
		
		
		
		} catch (Exception e) 
		{
			  System.out.println(e.getMessage());
			
		} 
		
	
	}
}
