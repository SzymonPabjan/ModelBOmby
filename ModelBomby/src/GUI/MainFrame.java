//klasa do inicjalizacji i wyswietlania wszystkiego
//TO DO: watki dla obliczen i moze dla grafiki
package GUI;

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
				}
				);}
}
