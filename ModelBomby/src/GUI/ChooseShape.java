//klasa definiujaca GUI potrzebne do opcji zwiazanych z ksztaltem probki.
//TO DO: double jako dane.
package GUI;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChooseShape extends JPanel 
{
	private static final long serialVersionUID = 1L;
	public ChooseShape() 
	{
		//inicjalizacja obiektow
		JPanel ChooseShapePanel=new JPanel(new GridLayout(7,1));
		JFrame frame=new JFrame();
		JMenuBar shapes = new JMenuBar();
		JMenu choose = new JMenu("Wybie¿ kszta³t próbki");
		JMenuItem ball = new JMenuItem("Kula");
		JMenuItem cube = new JMenuItem("Szescian");
		JMenuItem cuboid = new JMenuItem("Prostopad³oœcian");
		JTextField radius = new JTextField("promien");
		JTextField side= new JTextField("bok");
		JTextField height = new JTextField("wysokosc");
		Units units=new Units();
		EditUnits editUnits=new EditUnits();
		IsDouble isDouble=new IsDouble();
		radius.setEditable(false);
		side.setEditable(false);
		height.setEditable(false);
		//listenery do wyboru ksztaltu
		class BallListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				radius.setText("promien");
				side.setText("bok");
				height.setText("wysokosc");
				radius.setEditable(true);
				side.setEditable(false);
				height.setEditable(false);
				editUnits.EditableUnits(units,1);
			}
		}
		class CubeListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				radius.setText("promien");
				side.setText("bok");
				height.setText("wysokosc");
				radius.setEditable(false);
				side.setEditable(true);
				height.setEditable(false);
				editUnits.EditableUnits(units,2);
			}
		}
		class CuboidListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				radius.setText("promien");
				side.setText("bok");
				height.setText("wysokosc");
				radius.setEditable(true);
				side.setEditable(true);
				height.setEditable(true);
				editUnits.EditableUnits(units,3);
			}
		}
		//listenery do czyszczenia okienek
		class RadiusWindowListener implements MouseListener
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(Editable(units.radiusIsEditable)==1)
				radius.setText("");	
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
		class SideWindowListener implements MouseListener
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(Editable(units.sideIsEditable)==1)
				side.setText("");	
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
		class HeightWindowListener implements MouseListener
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(Editable(units.heightIsEditable)==1)
				height.setText("");	
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
		//listenery do wpisania i sprawdzania poprawnosci dnaych
		class RadiusListener implements FocusListener
		{
			String radiusValue;
			@Override
			public void focusGained(FocusEvent arg0) {}
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				int radiusCalculate;
				radiusValue=radius.getText();	
				try
				{
					if (isDouble.plusDouble(radiusValue,isDouble.isDouble(radiusValue))) throw new Exception();
					else
					{
						radiusCalculate= Integer.parseInt(radiusValue);
						units.radiusValue=radiusCalculate;
					}
				}
				catch (Exception e)
				{
					if(units.radiusIsEditable==1)
					{
						JOptionPane.showMessageDialog(frame, "Niezgodny typ danych", "Warning", JOptionPane.WARNING_MESSAGE);
						radiusCalculate=1;
					}
					else;
					
				}
			}
		}
		class SideListener implements FocusListener
		{
			String sideValue;
			@Override
			public void focusGained(FocusEvent arg0) {}
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				int sideCalculate;
				sideValue=side.getText();
				try
				{
					if (isDouble.plusDouble(sideValue,isDouble.isDouble(sideValue))) throw new Exception();
					else
					{
						sideCalculate= Integer.parseInt(sideValue);
					}
				}
				catch (Exception e)
				{
					if(units.sideIsEditable==1)
					{
						JOptionPane.showMessageDialog(frame, "Niezgodny typ danych", "Warning", JOptionPane.WARNING_MESSAGE);
						sideCalculate=1;
					}
					else;
				}
			}
		}
		class HeightListener implements FocusListener
		{
			String heightValue;
			@Override
			public void focusGained(FocusEvent arg0) {}
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				double heightCalculate;
				heightValue=height.getText();
				try
				{
					if (isDouble.plusDouble(heightValue,isDouble.isDouble(heightValue))) throw new Exception();
					else
					{
						heightCalculate=Double.parseDouble(heightValue);
					}
				}
				catch (Exception e)
				{
					if(units.radiusIsEditable==1 && units.sideIsEditable==1 && units.heightIsEditable==1) 
					{
						JOptionPane.showMessageDialog(frame, "Niezgodny typ danych", "Warning", JOptionPane.WARNING_MESSAGE);
						heightCalculate=1;
					}
				}
			}
		}
		//przypisanie wszystkiego do siebie
		ball.addActionListener(new BallListener());
		cube.addActionListener(new CubeListener());
		cuboid.addActionListener(new CuboidListener());
		radius.addMouseListener(new RadiusWindowListener());
		side.addMouseListener(new SideWindowListener());
		height.addMouseListener(new HeightWindowListener());
		radius.addFocusListener(new RadiusListener());
		side.addFocusListener(new SideListener());
		height.addFocusListener(new HeightListener());
		
		this.add(ChooseShapePanel);
		ChooseShapePanel.add(shapes);
		shapes.add(choose);
		choose.add(ball);
		choose.add(cube);
		choose.add(cuboid);
		ChooseShapePanel.add(radius);
		ChooseShapePanel.add(side);
		ChooseShapePanel.add(height);
	}
	//funkcje
	
	public int Editable(int object)
	{
		int a=0;
		if(object==1)
		{
			a=1;
			return a;
		}
		else
		return a;
	}
	//reszta
	public ChooseShape(LayoutManager layout)
	{
		super(layout);
	}
	public ChooseShape(boolean isDoubleBuffered) 
	{
		super(isDoubleBuffered);
	}
	public ChooseShape(LayoutManager layout, boolean isDoubleBuffered) 
	{
		super(layout, isDoubleBuffered);
	}
}
