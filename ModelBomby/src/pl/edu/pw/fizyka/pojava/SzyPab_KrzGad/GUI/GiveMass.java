//klasa tworzaca GUI potrzebne do okreslenia masy probki
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI;

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
	int avogadro=600;
	public GiveMass(GiveSize giveSize, Controls controls) 
	{
		JFrame frame=new JFrame();
		JLabel title = new JLabel("Podaj masê:");
		JTextField mass = new JTextField(10);
		JLabel unit = new JLabel("zg");//zg(zeptogram)=10^-21g
		IsDouble isDouble=new IsDouble();
		UnitsForGUI unitsForGUI=new UnitsForGUI();
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
				int massGiveByUser;
				massValue=mass.getText();	
				try
				{
					if (isDouble.plusDouble(massValue,isDouble.isDouble(massValue))) throw new Exception();
					else
					{
						massGiveByUser= Integer.parseInt(massValue);
						if(massGiveByUser/235*avogadro>64000)
						{
							massGiveByUser=64000;
							mass.setText(Integer.toString((int)64000*235/avogadro));
							giveSize.size.setText(Integer.toString(massGiveByUser));
						}
						else
						{
							double massCalculate=massGiveByUser/235*avogadro;
							unitsForGUI.setSideValue((int)Math.cbrt(massCalculate));
							controls.side=(int)Math.cbrt(massCalculate);
							giveSize.size.setText(Integer.toString((int)massCalculate));
						}
					}
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Niezgodny typ danych", "Warning", JOptionPane.WARNING_MESSAGE);
					massGiveByUser=1;
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
