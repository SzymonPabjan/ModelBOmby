package math;

import java.util.ArrayList;

public class SymulationThread extends Thread{

	int xPosition;
	int yPosition;
	int zPosition;
	
	public SymulationThread(int X, int Y, int Z) {
		xPosition = X;
		yPosition = Y;
		zPosition = Z;

	}
	
	long pauza = 1;
	public boolean active = true;
	
	public ArrayList<ArrayList<Atom>> ListOfListsOfDecayedAtoms = new ArrayList<ArrayList<Atom>>();
	public void run() {
		Methods met = new Methods(xPosition, yPosition, zPosition);
		
		met.AtomListAdd();
		int suma =0;
		int i = 0;
		while (active) {
			met.Choice();
			met.NeutronsDirection();
			suma +=met.AtomsDecayedByNeutrons();
			ListOfListsOfDecayedAtoms.add(met.decayedAtoms);
			i++;
			System.out.print(i); //podaje nuemr iteracji
			System.out.print("   ");
			System.out.print(suma); //podaje liczbê jader, które rozpad³y siê pod wp³ywem uderzenia neutronu
			System.out.print("   ");
			System.out.print(met.atoms.size());//podaje liczbê pozosta³ych j¹der 
			System.out.println();
//			System.out.println(ListOfListsOfDecayedAtoms.size());
			if(met.atoms.size()>= (0.1*(xPosition*yPosition*zPosition)) && !Thread.currentThread().isInterrupted()) {
				active = true;
			}
			else{
				active=false;
				System.out.println("Koniec obliczeñ");
			}
		
			try {
				Thread.sleep(pauza);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				Thread.currentThread().interrupt();
				return;
			}
		}
		
	}

}


//for(int a = 0; a <ListOfListsOfDecayedAtoms.size(); a++) {
//System.out.println("   ");
//System.out.println("Indeks g³ówny");
//System.out.println(a);
//System.out.println("   ");
//for(int b = 0; b <met.decayedatoms.size(); b++) {
//	System.out.println(met.decayedatoms.get(b).xPosition);
//}
//
