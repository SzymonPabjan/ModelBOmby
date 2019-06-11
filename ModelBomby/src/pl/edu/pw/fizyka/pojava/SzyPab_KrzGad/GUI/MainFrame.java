//klasa do inicjalizacji i wyswietlania wszystkiego.
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;
	public MainFrame() throws HeadlessException 
	{
		this.setSize(1080, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		Controls controls = new Controls();
		JPanel screen = new Paint();
		JPanel menu = new JPanel();
		GiveSize size = new GiveSize();
		ChooseShape shape = new ChooseShape(size,controls);
		GiveMass masa = new GiveMass(size,controls);
		ChooseSpeed speed = new ChooseSpeed();
		
		
		add(BorderLayout.CENTER, screen);
		screen.setBackground(Color.WHITE);
		add(BorderLayout.EAST, menu);
		menu.setLayout(new GridLayout(5,1));
		menu.add(shape);
		menu.add(masa);
		menu.add(size);
		menu.add(speed);
		menu.add(controls);
	}

	public MainFrame(GraphicsConfiguration arg0) 
	{
		super(arg0);
	}
	public MainFrame(String arg0) throws HeadlessException 
	{
		super(arg0);
	}
	public MainFrame(String arg0, GraphicsConfiguration arg1) 
	{
		super(arg0, arg1);
	}

	public static void main(String[] args)
	{
		//watek GUI
		SwingUtilities.invokeLater(
				new Runnable() 
				{
					public void run() 
					{
						MainFrame MF = new MainFrame();
						MF.setTitle("Model bomby atomowej-wersja beta");
						MF.setSize(1080, 720); 
						MF.setVisible(true);
					}
				});
		
	}
}
