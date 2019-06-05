

package math;

public class Atom {// klasa Atom, przechowuje po³o¿enie j¹dra oraz jego stan (czy jest rozpadniety czy nie)
	int xPosition = 0;
	int yPosition = 0;
	int zPosition = 0;
	boolean decay = false;
	public Atom(int X, int Y, int Z, boolean Decay) {
		xPosition = X;
		yPosition = Y;
		zPosition = Z;
		decay = Decay;
	}

}

