// klasa Neutron przechowuje po�o�enie neutronu oraz jego stan (czy jest rozpadniety czy nie)
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.math;

public class Neutron {

		int xPosition = 0;
		int yPosition = 0;
		int zPosition = 0;
		boolean outside = false;
		public Neutron(int X, int Y, int Z, boolean Outside) {
			xPosition = X;
			yPosition = Y;
			zPosition = Z;
			outside = Outside;
		}
}
