//klasa do inicjalizacji i wyswietlania wszystkiego.
//TO DO:
package GUI;
import math.Atom;
import math.Neutron;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import math.Methods;
public class MainFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;
	public MainFrame() throws HeadlessException 
	{
		this.setSize(1080, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		JPanel screen = new JPanel();
		JPanel menu = new JPanel();
		ChooseShape shape = new ChooseShape();
		GiveMass masa = new GiveMass();
		GiveSize size = new GiveSize();
		ChooseSpeed speed = new ChooseSpeed();
		Controls contr = new Controls();
		
		add(BorderLayout.CENTER, screen);
		screen.setBackground(Color.WHITE);
		add(BorderLayout.EAST, menu);
		menu.setLayout(new GridLayout(5,1));
		menu.add(shape);
		menu.add(masa);
		menu.add(size);
		menu.add(speed);
		menu.add(contr);
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
						MF.setTitle("Model bomby atomowej-wersja pre-alpha");
						MF.setSize(1080, 720); 
						MF.setVisible(true);
						
					}
				});
		//watek symulacji
		SwingUtilities.invokeLater(
				new Runnable() {
//					int pauza = 10;
//					boolean p =true;
					int a = 11;
					public void run() 
					
					{
						int suma =0;
						Methods met = new Methods(a,a,a);
						
						met.AtomArrayAdd();
						
					while(met.atoms.size()>=(0.1*(a*a*a)) ) {
							met.Choice();
							met.ND();
							met.OutN();
							suma +=met.AND();
							System.out.println(suma);
						}
					}
					
				});
		//watek animacji
		SwingUtilities.invokeLater(
				new Runnable() 
				{
					public void run() 
					{
						
					}
				});
	}
}
