//klasa majaca za zadanie wygenerowac animacje.
//UWAGA: wypelnianie listy i mapy losowymi liczbami jest tymczasowe i ma za zadanie umozliwienie testowania rozwiazan.
//TO DO: dorobic wyswietlanie
package GUI;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;


public class Animation extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private double PointRadius;
	public Animation() 
	{
		List<double[]> pointsCoordinate=new ArrayList<double[]>();
		Map<List<double[]>, Integer> ActivePoints=new HashMap<List<double[]>, Integer>();
		double [] XYValue=new double[2];
		Random random=new Random();
		//wypelnianie danymi
		for(int jj=0;jj<2;jj++)
		{
			double randomDouble=random.nextInt();
			XYValue[jj]=randomDouble;
		}
		pointsCoordinate.add(XYValue);
		//dodawanie danych do mapy
		for(int jj=0;jj<2;jj++)
		{
			int randomInt=random.nextInt();
			ActivePoints.put(pointsCoordinate, randomInt);
		}
		//System.out.println(ActivePoints);
		//rysowanie
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
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(
				new Runnable() 
				{
					public void run() 
					{
						Animation ani=new Animation();
						StdDraw.setXscale(-10.0,+10.0);
						StdDraw.setYscale(-10.0,+10.0);
						StdDraw.enableDoubleBuffering();
						StdDraw.clear(StdDraw.BLUE);
						StdDraw.setPenColor(StdDraw.BLACK);
						ani.drawPoint(2);
						ani.setVisible(true);
					}
				});
	}
}
