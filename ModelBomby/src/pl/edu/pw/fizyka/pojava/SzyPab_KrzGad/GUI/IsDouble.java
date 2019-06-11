//Klasa do sprawdzania czy string jest dodatnim intem.
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI;

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
				double stringToDouble=Double.parseDouble(string);
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
			double stringToDouble=Double.parseDouble(string);
			if(stringToDouble>0)
				result=false;
			else
				result=true;
			return result;
		}
		else
		return true;
	}
}
