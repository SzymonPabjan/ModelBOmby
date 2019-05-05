package math;

import java.util.ArrayList;
import java.util.Random;

import math.Atom;
import math.Neutron;

public class Methods {

	int x =0;
	int y= 0;
	int z= 0;
	
	public Methods(int X, int Y, int Z) {
		x = X;
		y = Y;
		z = Z;
	}
	
	ArrayList<Atom> atoms = new ArrayList<Atom>();
	Atom atomfill = new Atom(0,0,0, false);
	ArrayList<Neutron> neutrons = new ArrayList<Neutron>();
	
	//tworzenie "atomów"
	public void AtomArrayAdd() {
		for(int i =0; i<x; i++) {
			for(int j =0; j<y; j++) {
				for(int k =0; k<z; k++) {
					Atom atom = new Atom(i,j,k,false);	
					atoms.add(atom);
				}
			}
		}
		
	}
	//koniec tworzenia atomów
	
	//losowanie wspó³rzêdnych atmów, które ulegn¹ rozpadowi
	public int[] RDAs() { //RadnomlyDecayedAtoms
		Random r = new Random();
		int c = 0;
		//int suma = 0;
		int[] coo = new int[15];
		for(int i =0; i<15; i++) {
				c = r.nextInt((x-1)+1)+1;
				coo[i]=c;	
		}
		return coo;	
	}
	//koniec losowania 
	
	void NC(int a) {// Neutron Creation
		int[] co = RDAs();
		for(int i =0; i<atoms.size(); i++) {
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
	
	public void Choice() {
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
	
	
	//funkcja losuj¹ca kierunek neutronów z listy;
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
	
	public void OutN() {//Outside Neutrons
		for(int j =0; j<neutrons.size(); j++) {
			if(neutrons.get(j).x < 0 | neutrons.get(j).x>x |neutrons.get(j).y < 0 | neutrons.get(j).y>y | 
					neutrons.get(j).z < 0 | neutrons.get(j).z>z) {
				neutrons.get(j).outside = true;	
				neutrons.remove(j);
			}
		}
	}
	
	int AND() {//Atoms Neutron Decay
		int suma = 0;
		for(int i =0; i<neutrons.size(); i++) {
			 Random rand = new Random();
			 int r = rand.nextInt((100-1)+1)+1;
			
			if(neutrons.get(i).outside == false && r<=25) {
				for(int j =0; j<atoms.size(); j++) {
					if(atoms.get(j).decay == false && atoms.get(j).x == neutrons.get(i).x && atoms.get(j).y == neutrons.get(i).y && 
							atoms.get(j).z == neutrons.get(i).z) {
						atoms.get(j).decay = true;
						atoms.remove(j);
						//System.out.println(atoms.get(j).z);
						suma++;
					}
				}
			}
		}
		return suma;
	}
	

}
