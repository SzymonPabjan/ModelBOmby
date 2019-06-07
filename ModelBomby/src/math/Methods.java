package math;

import java.util.ArrayList;
import java.util.Random;

import GUI.UnitsForAnimation;
import math.Atom;
import math.Neutron;


public class Methods {// klasa zawieraj¹ca wszystkie metody u¿ywane w "czêsæi matematycznej" programu oraz listy klas Neutron i Atom

	int xPosition = 0;
	int yPosition = 0;
	int zPosition = 0;
	
	public Methods(int X, int Y, int Z) {//konstrutkor
		xPosition = X;
		yPosition = Y;
		zPosition = Z;
	}
	
	public ArrayList<Atom> atoms = new ArrayList<Atom>(); //lista obiektów klasy Atom
	public ArrayList<Neutron> neutrons = new ArrayList<Neutron>(); //lista obiektów klasy Neutron
	public ArrayList<Atom> decayedAtoms = new ArrayList<Atom>();//lista rozpadnietych atomów przkazywana do w¹tku animacji
	UnitsForAnimation units=new UnitsForAnimation();
	int iterator=1;
	
	//tworzenie "atomów"
	public void AtomListAdd() {// funkcja zape³niajaca listê obiekatmi klasy Atom
		for(int ii =0; ii<xPosition; ii++) {
			for(int jj =0; jj<yPosition; jj++) {
				for(int kk =0; kk<zPosition; kk++) {
					Atom atom = new Atom(ii,jj,kk,false,0);	
					atoms.add(atom);
					//units.decayedAtoms.add(atom);
				}
			}
		}
		
	}
	//koniec tworzenia atomów
	
	//losowanie wspó³rzêdnych atmów, które ulegn¹ rozpadowi
	public int[] RadnomlyDecayedAtoms() { //RadnomlyDecayedAtoms
		Random random = new Random();
		
		int c = 0;
		int[] coo = new int[15];
		for(int ii =0; ii<15; ii++) {
				c = random.nextInt((xPosition-1)+1)+1;
				coo[ii]=c;	
				
		}
		return coo;	
	}
	//koniec losowania 
	
	
		void NeutronCreation(int a) {// Neutron Creation funkcja tworz¹ca Neutrony na podstawie koordynatów samoistnie rozpadajaæych siê jader atomów
		int[] co = RadnomlyDecayedAtoms();
		for(int ii =0; ii<atoms.size(); ii++) {
			//System.out.println(i);
			if(atoms.get(ii).getxPosition() == co[0 +a ] & atoms.get(ii).yPosition == co[1 +a] & atoms.get(ii).zPosition == co[2+a] &
					atoms.get(ii).decay == false) {
				atoms.get(ii).decay = true;
				//units.decayedatoms.add(atoms.get(ii));
				atoms.remove(ii);
				neutrons.add(new Neutron(co[0], co[1],co[2], false));
				neutrons.add(new Neutron(co[0], co[1],co[2], false));
				neutrons.add(new Neutron(co[0], co[1],co[2], false));
				
			}
		}
	}
	
	public void Choice() {// funkcja losuj¹ca liczbê j¹der atomowych, któe samoistnie siê rozpadn¹
		Random rand = new Random();
		 int random = rand.nextInt((5-1)+1)+1;
		 if(random==1) {
			 NeutronCreation(0);
		 }
		 if(random==2) {
			 NeutronCreation(0);
			 NeutronCreation(3);
		 }
		 if(random==3) {
			 NeutronCreation(0);
			 NeutronCreation(3);
			 NeutronCreation(6);
		 }
		 if(random==4) {
			 NeutronCreation(0);
			 NeutronCreation(3);
			 NeutronCreation(6);
			 NeutronCreation(9);
		 }
		 if(random==5) {
			 NeutronCreation(0);
			 NeutronCreation(3);
			 NeutronCreation(6);
			 NeutronCreation(9);
			 NeutronCreation(12);
		 }
	}
	
	//funkcja losuj¹ca kierunek neutronów z listy;
	public void NeutronsDirection() { // ND - neutrons direction
		int ii =0;
		for(ii=0; ii<neutrons.size(); ii++) {
			Random rand = new Random();
			 int random = rand.nextInt((6-1)+1)+1;
			 if(random == 1 &&  neutrons.get(ii).outside == false ) {
				 neutrons.get(ii).xPosition+=1;
			 }
			 if(random == 2 &&  neutrons.get(ii).outside == false ) {
				 neutrons.get(ii).xPosition+=(-1);
			 }
			 if(random == 3 &&  neutrons.get(ii).outside == false ) {
				 neutrons.get(ii).yPosition+=1;
			 }
			 if(random == 4 &&  neutrons.get(ii).outside == false ) {
				 neutrons.get(ii).yPosition+=(-1);
			 }
			 if(random == 5 &&  neutrons.get(ii).outside == false ) {
				 neutrons.get(ii).zPosition+=1;
			 }
			 if(random == 6 &&  neutrons.get(ii).outside == false ) {
				 neutrons.get(ii).zPosition+=(-1);
			 }
			 if(neutrons.get(ii).xPosition < 0 | neutrons.get(ii).xPosition>xPosition |neutrons.get(ii).yPosition < 0 | neutrons.get(ii).yPosition>yPosition | 
						neutrons.get(ii).zPosition < 0 | neutrons.get(ii).zPosition>zPosition) {
					neutrons.get(ii).outside = true;	
				}
			 
			 }
		
		}
	
	public int AtomsDecayedByNeutrons() {//Atoms Neutron Decay funkcja "rozpadaj¹ca" ja¹dra atomów trafione przez neutrony, dodatkowo zlicza liczbê rozpadów
		int suma = 0;
		for(int ii =0; ii<neutrons.size(); ii++) {
			 Random rand = new Random();
			 int random = rand.nextInt((100-1)+1)+1; // losowy int którego wartoœæ decyduje o tym czy jadro uelgnie rozpadowi po zderzeniu z j¹drem 
			if(neutrons.get(ii).outside == false && random<=25) {
				for(int jj =0; jj<atoms.size(); jj++) {// ta czêœæ metody znajduje odpowiednie j¹dra i usuwa je z pamiêci
					if(atoms.get(jj).decay == false && atoms.get(jj).getxPosition() == neutrons.get(ii).xPosition && atoms.get(jj).yPosition == neutrons.get(ii).yPosition && 
							atoms.get(jj).zPosition == neutrons.get(ii).zPosition) {
						atoms.get(jj).decay = true;
						atoms.get(jj).iterator = iterator;
						decayedAtoms.add(atoms.get(jj));//??????????????
						units.decayedAtoms.add(atoms.get(jj));
						atoms.remove(jj);
						suma++;
					}
				}
			}
		}
		iterator++;
		return suma;
	}
	
}
