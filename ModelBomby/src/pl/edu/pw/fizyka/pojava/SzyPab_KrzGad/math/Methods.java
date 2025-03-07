// klasa zawieraj�ca wszystkie metody u�ywane w "cz�s�i matematycznej" programu oraz listy klas Neutron i Atom
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.math;

import java.util.ArrayList;
import java.util.Random;

import pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI.UnitsForAnimation;
import pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.math.Atom;
import pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.math.Neutron;

public class Methods {

	int xPosition = 0;
	int yPosition = 0;
	int zPosition = 0;
	
	public Methods(int X, int Y, int Z) {//konstrutkor
		xPosition = X;
		yPosition = Y;
		zPosition = Z;
	}
	
	public ArrayList<Atom> atoms = new ArrayList<Atom>(); //lista obiekt�w klasy Atom
	public ArrayList<Neutron> neutrons = new ArrayList<Neutron>(); //lista obiekt�w klasy Neutron
	public static ArrayList<Atom> decayedAtoms;// = new ArrayList<Atom>();//lista rozpadnietych atom�w przkazywana do w�tku animacji
	UnitsForAnimation units=new UnitsForAnimation();
	
	//tworzenie "atom�w"
	public void AtomListAdd() {// funkcja zape�niajaca list� obiekatmi klasy Atom
		for(int ii =0; ii<xPosition; ii++) {
			for(int jj =0; jj<yPosition; jj++) {
				for(int kk =0; kk<zPosition; kk++) {
					Atom atom = new Atom(ii,jj,kk,false);	
					atoms.add(atom);
				}
			}
		}
	}
	public void BallAtomListAdd() 
	{// funkcja zape�niajaca list� obiekatmi klasy Atom dla kuli
		for(int ii =0; ii<40; ii++) 
		{
			for(int jj =0; jj<40; jj++) 
			{
				for(int kk =0; kk<40; kk++) 
				{
					if(((ii-360)^2+(jj-360)^2+(kk-360)^2)<(xPosition^2))
					{
						Atom atom = new Atom(ii,jj,kk,false);	
						atoms.add(atom);
					}
				}
			}
		}
	}
	//koniec tworzenia atom�w
	
	//losowanie wsp�rz�dnych atm�w, kt�re ulegn� rozpadowi
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
		
		void NeutronCreation(int a) {// Neutron Creation funkcja tworz�ca Neutrony na podstawie koordynat�w samoistnie rozpadaja�ych si� jader atom�w
		int[] co = RadnomlyDecayedAtoms();
		for(int ii =0; ii<atoms.size(); ii++) {
			if(atoms.get(ii).getxPosition() == co[0 +a ] & atoms.get(ii).getyPosition() == co[1 +a] & atoms.get(ii).getzPosition() == co[2+a] &
					atoms.get(ii).isDecay() == false) {
				atoms.get(ii).setDecay(true);
				atoms.remove(ii);
				neutrons.add(new Neutron(co[0], co[1],co[2], false));
				neutrons.add(new Neutron(co[0], co[1],co[2], false));
				neutrons.add(new Neutron(co[0], co[1],co[2], false));
			}
		}
	}
	
	public void Choice() {// funkcja losuj�ca liczb� j�der atomowych, kt�e samoistnie si� rozpadn�
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
	
	//funkcja losuj�ca kierunek neutron�w z listy;
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
	
	public int AtomsDecayedByNeutrons() {//Atoms Neutron Decay funkcja "rozpadaj�ca" ja�dra atom�w trafione przez neutrony, dodatkowo zlicza liczb� rozpad�w
		decayedAtoms=new ArrayList<Atom>();
		int suma = 0;
		for(int ii =0; ii<neutrons.size(); ii++) {
			 Random rand = new Random();
			 int random = rand.nextInt((100-1)+1)+1; // losowy int kt�rego warto�� decyduje o tym czy jadro uelgnie rozpadowi po zderzeniu z j�drem 
			if(neutrons.get(ii).outside == false && random<=25) {
				for(int jj =0; jj<atoms.size(); jj++) {// ta cz�� metody znajduje odpowiednie j�dra i usuwa je z pami�ci
					if(atoms.get(jj).isDecay() == false && atoms.get(jj).getxPosition() == neutrons.get(ii).xPosition && atoms.get(jj).getyPosition() == neutrons.get(ii).yPosition && 
							atoms.get(jj).getzPosition() == neutrons.get(ii).zPosition) {
						atoms.get(jj).setDecay(true);
						decayedAtoms.add(atoms.get(jj));
						units.decayedAtoms.add(atoms.get(jj));
						atoms.remove(jj);
						suma++;
					}
				}
			}
		}
		//iterator++;
		return suma;
	}
}
