//klasa tworzaca GUI potrzebne do okreslenia masy probki
package GUI;

import java.awt.LayoutManager;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiveMass extends JPanel
{
	private static final long serialVersionUID = 1L;
	public GiveMass() 
	{
		JFrame frame=new JFrame();
		JLabel title = new JLabel("Podaj masê:");
		JTextField mass = new JTextField(10);
		JLabel unit = new JLabel("pg");
		IsDouble isDouble=new IsDouble();
		this.add(title);
		this.add(mass);
		this.add(unit);
		class MassWindowListener implements MouseListener
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				mass.setText("");	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		}
		class MassListener implements FocusListener
		{
			String massValue;
			@Override
			public void focusGained(FocusEvent arg0) {}
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				int massCalculate;
				massValue=mass.getText();	
				try
				{
					if (isDouble.plusDouble(massValue,isDouble.isDouble(massValue))) throw new Exception();
					else
					{
						massCalculate= Integer.parseInt(massValue);
					}
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Niezgodny typ danych", "Warning", JOptionPane.WARNING_MESSAGE);
					massCalculate=1;
				}
			}
		}
		mass.addFocusListener(new MassListener());
		mass.addMouseListener(new MassWindowListener());
	}
	public GiveMass(LayoutManager layout) 
	{
		super(layout);
	}
	public GiveMass(boolean isDoubleBuffered) 
	{
		super(isDoubleBuffered);
	}
	public GiveMass(LayoutManager layout, boolean isDoubleBuffered) 
	{
		super(layout, isDoubleBuffered);
	}
}
