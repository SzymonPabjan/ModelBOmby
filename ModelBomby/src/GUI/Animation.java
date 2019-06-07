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
import math.Methods;

public class Animation extends JPanel 
{
	private static final long serialVersionUID = 1L;
	//static List<int[]> pC=new ArrayList<int[]>();
	//ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
	//Methods methods=new Methods(1,1,1);
	UnitsForAnimation units=new UnitsForAnimation();
	static List<int[]> pC;
	public Animation() 
	{
		defaultValue();
	}
	
	/*public void defaultValue()
	{
		pC=new ArrayList<int[]>();
		for(int i=0;i<4;i++)
		{
			int[] a=new int[4];
			a[0]=10+20*i;
			a[1]=10;
			a[2]=0;
			a[3]=0;
			pC.add(i,a);
		}
	}*/
	public void defaultValue()
	{
		pC=new ArrayList<int[]>();
		for(int i=0;i<1;i++)
		{
			//units.decayedAtoms.get(i);
			int[] a=new int[4];
			a[0]=10;
			a[1]=10;
			a[2]=10;
			a[3]=0;
			pC.add(i,a);
		}
	}
	public void startValue()
	{
		for(int i=0;i<units.decayedAtoms.size();i++)
		{
			units.decayedAtoms.get(i);
			int[] a=new int[4];
			a[0]=10+20*units.decayedAtoms.get(i).getxPosition();
			a[1]=10+20*units.decayedAtoms.get(i).getyPosition();
			a[2]=10+20*units.decayedAtoms.get(i).getzPosition();
			a[3]=units.decayedAtoms.get(i).getIterator();
			pC.add(i,a);
		}
	}
	public void stopValue()
	{
		pC=null;
	}
	public void value(int aa)
	{
		for(int i=0;i<4;i++)
		{
			int[] a=new int[4];
			a[0]=10+20*i;
			a[1]=10;
			a[2]=0;
			a[3]=i+aa+1;
			pC.add(i,a);
		}
	}
	void rozpocznijRuch()
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
					//System.out.println(iteracja);
					try 
					{
						Thread.sleep(1000);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
						Thread.currentThread().interrupt();
						return;
					}
				}
			}
		}),  1, 1, TimeUnit.SECONDS); 	
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
/*
	public static void interrupt() 
	{
		Thread.currentThread().interrupt();
	}

	public static void stop() 
	{
		Thread.currentThread().stop();
	}*/
}
