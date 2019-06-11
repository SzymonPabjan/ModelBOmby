// klasa Atom, przechowuje po³o¿enie j¹dra oraz jego stan (czy jest rozpadniety czy nie)
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.math;

public class Atom {
	private int xPosition = 0;
	private int yPosition = 0;
	private int zPosition = 0;
	private boolean decay = false;
	public Atom(int X, int Y, int Z, boolean Decay) {
		setxPosition(X);
		yPosition = Y;
		zPosition = Z;
		setDecay(Decay);
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
	public boolean isDecay() {
		return decay;
	}
	public void setDecay(boolean decay) {
		this.decay = decay;
	}
}