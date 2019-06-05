//klasa majaca za zadanie wygenerowac animacje.
//UWAGA: wypelnianie listy i mapy losowymi liczbami jest tymczasowe i ma za zadanie umozliwienie testowania rozwiazan.
//TO DO: dorobic wyswietlanie
package GUI;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import edu.princeton.cs.introcs.StdDraw;

public class Animation extends JPanel 
{
	private static final long serialVersionUID = 1L;
	static List<int[]> pC=new ArrayList<int[]>();
	public Animation() 
	{
		defaultValue();
	}
	
	public static void defaultValue()
	{
		for(int i=0;i<4;i++)
		{
			int[] a=new int[3];
			a[0]=10+20*i;
			a[1]=10;
			a[2]=0;
			pC.add(i,a);
		}
	}
	public static void startValue()
	{
		for(int i=0;i<4;i++)
		{
			int[] a=new int[3];
			a[0]=10+20*i;
			a[1]=10;
			a[2]=1;
			pC.add(i,a);
		}
	}
	public static void value(int aa)
	{
		for(int i=0;i<4;i++)
		{
			int[] a=new int[3];
			a[0]=10+20*i;
			a[1]=10;
			a[2]=i+aa+1;
			pC.add(i,a);
		}
	}
	static void rozpocznijRuch()
	{  
	    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate( (new Runnable() 
		{	
			@Override
			public void run() 
			{
				int iteracja=1;
				while(UnitsForAnimation.czynny)
				{
					value(iteracja);
					iteracja+=1;
					try 
					{
						Thread.sleep(1000);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}),  1, 10, TimeUnit.SECONDS); 	
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
