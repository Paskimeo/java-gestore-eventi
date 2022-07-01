package jana60;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		String confermaPren;
		String confermaDis;
		boolean flag = false;
		
	
		//richiesta dati
		System.out.println("inserisci il titolo dell'evento: ");
		String titolo = scan.nextLine();
		
		System.out.println("inserisci il numero di posti disponibili: ");
		int posti = Integer.parseInt(scan.nextLine());
		
		System.out.println("inserisci il giorno: ");
		int giorno = Integer.parseInt(scan.nextLine());
		
		System.out.println("inserisci il mese: ");
		int mese = Integer.parseInt(scan.nextLine());
		
		
		System.out.println("inserisci l'anno: ");
		int anno = Integer.parseInt(scan.nextLine());
		
		//salvataggio dati
		LocalDate data = LocalDate.of(anno, mese, giorno);
		
		Evento evento = new Evento(titolo, data, posti,posti);
	
		
		
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
		
		evento.setPostiPrenotati(prenotazioni);
		
		System.out.println("prenotazione effettuate " + evento.getPostiPrenotati()+ " Totale posti disponibili " + evento.numeroPrenotazioni() );
		
		
		
		}else if(confermaPren.equalsIgnoreCase("no"))
			System.out.println(evento.toString());
			flag = true;
			
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
				
				System.out.println("disdetta effettuate " + (evento.getPostiPrenotati() - disdetta) + " Totale posti disponibili " + (evento.numeroPrenotazioni() + disdetta) );

			}
	}
	

}
