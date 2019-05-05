//Klasa pomagajaca przy czyszczeniu jTextField-ow. Zmienia wartosci odpowiednich parametrow przy wyborze ksztaltu.
//TO DO:
package GUI;

public class EditUnits 
{
	public void EditableUnits(Units object, int condition)//przez referencje
	{
		if(condition==1)
		{
			object.radiusIsEditable=1;
			object.sideIsEditable=0;
			object.heightIsEditable=0;		
		}
		else if(condition==2)
		{
			object.radiusIsEditable=0;
			object.sideIsEditable=1;
			object.heightIsEditable=0;	
		}
		else
		{
			object.radiusIsEditable=1;
			object.sideIsEditable=1;
			object.heightIsEditable=1;		
		}
	}
}
