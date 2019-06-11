//klasa majaca za zadanie wygenerowac animacje.
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import edu.princeton.cs.introcs.StdDraw;
import pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.math.Atom;

public class Animation extends JPanel 
{
	private static final long serialVersionUID = 1L;
	static List<int[]> pointsCoordinate;
	int iteratorForRun=1;
	public static int time;
	public Animation() 
	{
		defaultValue();
	}
	public void defaultValue()
	{
		pointsCoordinate=new ArrayList<int[]>();
		for(int ii=0;ii<1;ii++)
		{
			int[] coordinatesAndColor=new int[4];
			coordinatesAndColor[0]=10;//polozenie x
			coordinatesAndColor[1]=10;//polozenie y
			coordinatesAndColor[2]=10;//polozenie z
			coordinatesAndColor[3]=0;//kolor
			pointsCoordinate.add(ii,coordinatesAndColor);
		}
	}
	public void stopValue()
	{
		pointsCoordinate=null;
	}
	public void value(ArrayList<ArrayList<Atom>> decayedAtoms, int ii)
	{
			for(int jj=0;jj<decayedAtoms.get(ii).size();jj++)
			{
				int[] coordinatesAndColor=new int[4];
				try
				{
					if(decayedAtoms.get(ii).get(jj).isDecay()==true)
					{
						coordinatesAndColor[0]=10+15*decayedAtoms.get(ii).get(jj).getxPosition();
						coordinatesAndColor[1]=10+15*decayedAtoms.get(ii).get(jj).getyPosition();
						coordinatesAndColor[2]=10+15*decayedAtoms.get(ii).get(jj).getzPosition();
						coordinatesAndColor[3]=ii+1;
						pointsCoordinate.add(ii,coordinatesAndColor);
					}
				}
				catch (Exception e)
				{}
		}
	}
	public void rozpocznijRuch(ArrayList<ArrayList<Atom>> decayedAtoms)
	{  
	    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.schedule( (new Runnable() 
		{	
			@Override
			public void run() 
			{
				while(UnitsForAnimation.czynny)
				{
					value(decayedAtoms,iteratorForRun);
					try 
					{
						Thread.sleep(1000);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
						Thread.currentThread().interrupt();
						return;
					}
					iteratorForRun++;
					try 
					{
						TimeUnit.SECONDS.sleep(time);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}),  time, TimeUnit.SECONDS); 	
	}
	
	public void drawPoint(int PointRadius)
	{
		StdDraw.filledCircle(1,1,PointRadius);
	}
	public Animation(LayoutManager arg0) 
	{
		super(arg0);
	}
	public Animation(boolean arg0) 
	{
		super(arg0);
	}
	public Animation(LayoutManager arg0, boolean arg1) 
	{
		super(arg0, arg1);
	}
}
