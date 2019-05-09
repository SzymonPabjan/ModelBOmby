package math;

public class Atom {// klasa Atom, przechowuje po³o¿enie j¹dra 
					//oraz jego stan (czy jest rozpadniety czy nie)
	int x = 0;
	int y = 0;
	int z = 0;
	boolean decay = false;
	public Atom(int X, int Y, int Z, boolean Decay) {
		x = X;
		y = Y;
		z = Z;
		decay = Decay;
	}

}


