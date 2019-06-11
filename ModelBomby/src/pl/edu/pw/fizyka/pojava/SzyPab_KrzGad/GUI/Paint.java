package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Paint extends JPanel 
{
	BufferedImage image=new BufferedImage(700,700,BufferedImage.TYPE_INT_RGB);
	private static final long serialVersionUID = 1L;
	public Paint() 
	{
		setPreferredSize(new Dimension(700,700));
	}
	public void paint(Graphics g)
	{
	      super.paint(g);
	      
	      Graphics2D g2 = (Graphics2D)g;
	      Graphics2D g2im = image.createGraphics();
	      Color c=Color.white;
	      Color c0=Color.black;
	      Color c1=Color.red;
	      Color c2=Color.blue;
	      Color c3=Color.green;
	      Color c4=Color.yellow;
	      Color c5=Color.orange;
	      Rectangle2D tlo=new Rectangle2D.Double(0,0,700,700);
	      g2im.setPaint(Color.white);
	      g2im.fill(tlo);
	      List<int[]> pointsCoordinate=Animation.pointsCoordinate;
	      {
	    	  for(int j=0;j<20000;j++)
	    	  {
	    	  	int[] circleCoordinate=new int[4];
	    	  	try
	    	  	{
	    	  		circleCoordinate=pointsCoordinate.get(j);
	    	  		Ellipse2D circle=new Ellipse2D.Double(circleCoordinate[0], circleCoordinate[1], 10, 10);
	    	  		if(circleCoordinate[3]==0)
	    	  			g2im.setPaint(c);
	    	  		if(circleCoordinate[3]%6==0&&circleCoordinate[3]>1)
	    	  			g2im.setPaint(c0);
	    	  		else if(circleCoordinate[3]%6==1&&circleCoordinate[3]>1)
	    	  			g2im.setPaint(c1);
	    	  		else if(circleCoordinate[3]%6==2&&circleCoordinate[3]>1)
	    	  			g2im.setPaint(c2);
	    	  		else if(circleCoordinate[3]%6==3&&circleCoordinate[3]>1)
	    	  		g2im.setPaint(c3);
	    	  		else if(circleCoordinate[3]%6==4&&circleCoordinate[3]>1)
	    	  			g2im.setPaint(c4);
	    	  		else if(circleCoordinate[3]%6==5&&circleCoordinate[3]>1)
	    	  			g2im.setPaint(c5);
	    	  		g2im.fill(circle);
	    	  		repaint();
	    	  	}
	    	  	catch(Exception e)
	    	  	{
	    	  		
	    	  	}
	    	  }
	      g2.drawImage(image, null, 0, 0);
	      }
	}
	
	public Paint(LayoutManager layout) 
	{
		super(layout);
	}

	public Paint(boolean isDoubleBuffered) 
	{
		super(isDoubleBuffered);
	}

	public Paint(LayoutManager layout, boolean isDoubleBuffered) 
	{
		super(layout, isDoubleBuffered);
	}
}
