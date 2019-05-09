package math;

import java.util.ArrayList;
import java.util.Random;

import math.Atom;
import math.Neutron;


public class Methods {// klasa zawieraj�ca wszystkie metody u�ywane w "cz�s�i matematycznej" programu oraz listy klas 
					  //Neutron i Atom

	int x =0;
	int y= 0;
	int z= 0;
	
	public Methods(int X, int Y, int Z) {//konstrutkor
		x = X;
		y = Y;
		z = Z;
	}
	
	public ArrayList<Atom> atoms = new ArrayList<Atom>(); //lista obiekt�w klasy Atom
	public ArrayList<Neutron> neutrons = new ArrayList<Neutron>(); //lista obiekt�w klasy Neutron
	
	//tworzenie "atom�w"
	public void AtomArrayAdd() {// funkcja zape�niajaca list� obiekatmi klasy Atom
		for(int i =0; i<x; i++) {
			for(int j =0; j<y; j++) {
				for(int k =0; k<z; k++) {
					Atom atom = new Atom(i,j,k,false);	
					atoms.add(atom);
				}
			}
		}
		
	}
	//koniec tworzenia atom�w
	
	//losowanie wsp�rz�dnych atm�w, kt�re ulegn� rozpadowi
	public int[] RDAs() { //RadnomlyDecayedAtoms
		Random r = new Random();
		
		int c = 0;
		int[] coo = new int[15];
		for(int i =0; i<15; i++) {
				c = r.nextInt((x-1)+1)+1;
				coo[i]=c;	
				//System.out.println(c);
		}
		return coo;	
	}
	//koniec losowania 
	
	
		void NC(int a) {// Neutron Creation funkcja tworz�ca Neutrony na podstawie koordynat�w samoistnie 
			            //rozpadaja�ych si� jader atom�w
		int[] co = RDAs();
		for(int i =0; i<atoms.size(); i++) {
			//System.out.println(i);
			if(atoms.get(i).x == co[0 +a ] & atoms.get(i).y == co[1 +a] & atoms.get(i).z == co[2+a] &
					atoms.get(i).decay == false) {
				atoms.get(i).decay = true;
				neutrons.add(new Neutron(co[0], co[1],co[2], false));
				neutrons.add(new Neutron(co[0], co[1],co[2], false));
				neutrons.add(new Neutron(co[0], co[1],co[2], false));
				atoms.remove(i);
				
			}
		}
	}
	
	public void Choice() {// funkcja losuj�ca liczb� j�der atomowych, kt�e samoistnie si� rozpadn�
		Random rand = new Random();
		 int r = rand.nextInt((5-1)+1)+1;
		 if(r==1) {
			 NC(0);
		 }
		 if(r==2) {
			 NC(0);
			 NC(3);
		 }
		 if(r==3) {
			 NC(0);
			 NC(3);
			 NC(6);
		 }
		 if(r==4) {
			 NC(0);
			 NC(3);
			 NC(6);
			 NC(9);
		 }
		 if(r==5) {
			 NC(0);
			 NC(3);
			 NC(6);
			 NC(9);
			 NC(12);
		 }
	}
	
	
	//funkcja losuj�ca kierunek neutron�w z listy;
	public void ND() { // ND - neutrons direction
		int i =0;
		for(i =0; i<neutrons.size(); i++) {
			Random rand = new Random();
			 int r = rand.nextInt((6-1)+1)+1;
			 if(r == 1 &&  neutrons.get(i).outside == false ) {
				 neutrons.get(i).x+=1;
			 }
			 if(r == 2 &&  neutrons.get(i).outside == false ) {
				 neutrons.get(i).x+=(-1);
			 }
			 if(r == 3 &&  neutrons.get(i).outside == false ) {
				 neutrons.get(i).y+=1;
			 }
			 if(r == 4 &&  neutrons.get(i).outside == false ) {
				 neutrons.get(i).y+=(-1);
			 }
			 if(r == 5 &&  neutrons.get(i).outside == false ) {
				 neutrons.get(i).z+=1;
			 }
			 if(r == 6 &&  neutrons.get(i).outside == false ) {
				 neutrons.get(i).z+=(-1);
			 }
			 }
		
		}
	
	
	
	public void OutN() {//Outside Neutrons funkcja wyszukujaca neutrony, kt�e znalz�y si� poza obr�bem 
						//pr�bki i usuwaj�ca je z pamie�i
		for(int i =0; i<neutrons.size(); i++) {
			if(neutrons.get(i).x < 0 | neutrons.get(i).x>x |neutrons.get(i).y < 0 | neutrons.get(i).y>y | 
					neutrons.get(i).z < 0 | neutrons.get(i).z>z) {
				neutrons.get(i).outside = true;	
				neutrons.remove(i);
				
			}
		}
	}
	
	public int AND() {//Atoms Neutron Decay funkcja "rozpadaj�ca" ja�dra atom�w trafione przez 
					  //neutrony, dodatkowo zlicza liczb� rozpad�w
		int suma = 0;
		for(int i =0; i<neutrons.size(); i++) {
			 Random rand = new Random();
			 int r = rand.nextInt((100-1)+1)+1; // losowy int kt�rego warto�� decyduje o tym czy jadro
			 									//ulegnie rozpadowi po zderzeniu z j�drem 
			if(neutrons.get(i).outside == false && r<=25) {
				for(int j =0; j<atoms.size(); j++) {// ta cz�� metody znajduje odpowiednie j�dra i usuwa je z pami�ci
					if(atoms.get(j).decay == false && atoms.get(j).x == neutrons.get(i).x 
							&& atoms.get(j).y == neutrons.get(i).y && atoms.get(j).z == neutrons.get(i).z) {
						atoms.get(j).decay = true;
						atoms.remove(j);
						suma++;
					}
				}
			}
		}
		return suma;
	}
	

}
