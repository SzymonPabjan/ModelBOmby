//klasa wykonujaca symulacje
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.math;

import java.util.ArrayList;

import pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI.Animation;

public class SymulationThread extends Thread{

	int xPosition;
	int yPosition;
	int zPosition;
	
	public SymulationThread(int X, int Y, int Z) {
		xPosition = X;
		yPosition = Y;
		zPosition = Z;
	}
	
	long pause = 1;
	public static boolean active = true;
	public ArrayList<ArrayList<Atom>> ListOfListsOfDecayedAtoms = new ArrayList<ArrayList<Atom>>();
	public String symOutput = ("");
	public void run() {
		Methods methods = new Methods(xPosition, yPosition, zPosition);
		Animation animation=new Animation();

		methods.AtomListAdd();
		int sum =0;
		int iterator = 0;
		
		symOutput+="i - Numer iteracji" + "\n";
		symOutput+="d - Liczba jader uleglych rozpadowi" + "\n";
		symOutput+="r - Liczba pozosta³ych j¹der" + "\n";
		symOutput+="\n";
		symOutput+="i"+ "		" +"d"+ "		" + "r" + "\n";
		symOutput+="\n";
		
		while (active  && !Thread.currentThread().isInterrupted()) {
			methods.Choice();
			methods.NeutronsDirection();
			sum +=methods.AtomsDecayedByNeutrons();
			ListOfListsOfDecayedAtoms.add(iterator,Methods.decayedAtoms);
			iterator++;
			System.out.print(iterator); //podaje nuemr iteracji
			System.out.print("   ");
			System.out.print(sum); //podaje liczbê jader, które rozpad³y siê pod wp³ywem uderzenia neutronu
			System.out.print("   ");
			System.out.print(methods.atoms.size());//podaje liczbê pozosta³ych j¹der 
			System.out.println();
			
			String iAsString = Integer.toString(iterator);
			String sumAsString = Integer.toString(sum);
			String atomsSizeAsString = Integer.toString(methods.atoms.size());
	
			
			
			String stringsToString = iAsString + "		" + sumAsString +"		"+ atomsSizeAsString;
			symOutput+=stringsToString + "\n";
			//symulationOutput.add(stringsToList);
			
			
			if(methods.atoms.size()>= (0.1*(xPosition*yPosition*zPosition)) && !Thread.currentThread().isInterrupted()) {
				active = true;
			}
			else{
				active=false;
				{//wywolanie animacji
					System.out.println("Koniec obliczeñ");
					animation.rozpocznijRuch(ListOfListsOfDecayedAtoms);
				}
			}
		
			try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				active = false;
				System.out.println("Przerwyanie w¹tku");
				return;
			}
		}
	}
}
