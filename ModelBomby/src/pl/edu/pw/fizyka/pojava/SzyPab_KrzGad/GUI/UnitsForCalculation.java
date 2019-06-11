//klasa przechowujaca dane do obliczen
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI;

public class UnitsForCalculation 
{
	private int radiusValue=1, sideValue=1, heightValue=1;
	public int radiusIsEditable=0, sideIsEditable=0, heightIsEditable=0;
	
	public int getRadiusValue() 
	{
		return radiusValue;
	}
	public void setRadiusValue(int radiusValue) 
	{
		this.radiusValue = radiusValue;
	}
	public int getSideValue() 
	{
		return sideValue;
	}
	public void setSideValue(int sideValue) 
	{
		this.sideValue = sideValue;
	}
	public int getHeightValue() 
	{
		return heightValue;
	}
	public void setHeightValue(int heightValue) 
	{
		this.heightValue = heightValue;
	}
}
