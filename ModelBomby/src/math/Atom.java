package math;

public class Atom {// klasa Atom, przechowuje po³o¿enie j¹dra oraz jego stan (czy jest rozpadniety czy nie)
	private int xPosition = 0;
	int yPosition = 0;
	int zPosition = 0;
	boolean decay = false;
	int iterator=0;
	public Atom(int X, int Y, int Z, boolean Decay, int ii) {
		setxPosition(X);
		yPosition = Y;
		zPosition = Z;
		decay = Decay;
		iterator=ii;
	}
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	public int getzPosition() {
		return zPosition;
	}
	public void setzPosition(int zPosition) {
		this.zPosition = zPosition;
	}
	public int getIterator() {
		return iterator;
	}
	public void setIterator(int iterator) {
		this.iterator = iterator;
	}
}