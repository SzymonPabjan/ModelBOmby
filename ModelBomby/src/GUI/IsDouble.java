//Klasa do sprawdzania czy string jest dodatnim doublem; narazie dziala dla dodatnich intow.
//TO DO: sprawic aby dzialalo dla doubli (moze bedzie to potrzebne; przemyslec).
package GUI;

public class IsDouble 
{
	public IsDouble() {}
	public boolean isDouble(Object object)
	{
		String string=object.toString();
		if(object instanceof Double)
		{
			return false;
		}
		else
		{
			try
			{
				double a=Double.parseDouble(string);
			}
			catch(Exception e)
			{
				return true;
			}
		}
		return false;
	}
	public boolean plusDouble(Object object, boolean isDoubleFunction)
	{
		if(isDoubleFunction==false)
		{
			boolean result;
			String string=object.toString();
			double a=Double.parseDouble(string);
			if(a>0)
				result=false;
			else
				result=true;
			return result;
		}
		else
		return true;
	}
}
