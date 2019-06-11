//Klasa pomagajaca przy czyszczeniu jTextField-ow. Zmienia wartosci odpowiednich parametrow przy wyborze ksztaltu.
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI;

public class EditUnits 
{
	public void EditableUnits(UnitsForGUI object, int condition)
	{
		if(condition==1)
		{
			object.setRadiusIsEditable(1);
			object.setSideIsEditable(0);
			object.setHeightIsEditable(0);		
		}
		else if(condition==2)
		{
			object.setRadiusIsEditable(0);
			object.setSideIsEditable(1);
			object.setHeightIsEditable(0);	
		}
		else
		{
			object.setRadiusIsEditable(1);
			object.setSideIsEditable(1);
			object.setHeightIsEditable(1);		
		}
	}
}
