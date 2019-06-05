package GUI;

import java.util.ArrayList;

import math.Atom;

public class UnitsForAnimation 
{
	private ArrayList<Atom> atomsForAnimation = new ArrayList<Atom>();
	static boolean czynny=true;
	public ArrayList<Atom> getAtomsForAnimation() 
	{
		return atomsForAnimation;
	}
	public void setAtomsForAnimation(ArrayList<Atom> atomsForAnimation) 
	{
		this.atomsForAnimation = atomsForAnimation;
	}
}
