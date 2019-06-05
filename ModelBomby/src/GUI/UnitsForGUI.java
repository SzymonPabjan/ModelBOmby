//Klasa pomagajaca przy czyszczeniu jTextField-ow. Przechowoje zmienne "przypisane" do jTextField-ow (0=false, 1=true).
//TO DO: mozna przerobic *IsEditable na booleany
package GUI;

public class UnitsForGUI
{
	private int radiusIsEditable=0, sideIsEditable=0, heightIsEditable=0;
	private int radiusValue=1, sideValue=1, heightValue=1;
	
	public int getRadiusIsEditable() 
	{
		return radiusIsEditable;
	}
	public void setRadiusIsEditable(int radiusIsEditable) 
	{
		this.radiusIsEditable = radiusIsEditable;
	}
	public int getSideIsEditable() 
	{
		return sideIsEditable;
	}
	public void setSideIsEditable(int sideIsEditable) 
	{
		this.sideIsEditable = sideIsEditable;
	}
	public int getHeightIsEditable() 
	{
		return heightIsEditable;
	}
	public void setHeightIsEditable(int heightIsEditable) 
	{
		this.heightIsEditable = heightIsEditable;
	}
	
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
