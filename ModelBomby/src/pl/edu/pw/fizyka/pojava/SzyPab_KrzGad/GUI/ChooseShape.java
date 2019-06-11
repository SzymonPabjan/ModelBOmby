//klasa definiujaca GUI potrzebne do opcji zwiazanych z ksztaltem probki.
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	public ChooseShape(GiveSize giveSize, Controls controls) 
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
		UnitsForGUI unitsForGUI=new UnitsForGUI();
		UnitsForCalculation unitsForCalculation=new UnitsForCalculation();
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
				unitsForCalculation.radiusIsEditable=1;
				unitsForCalculation.sideIsEditable=0;
				unitsForCalculation.heightIsEditable=0;
				editUnits.EditableUnits(unitsForGUI,1);
				controls.radius=0;
				controls.side=0;
				controls.height=0;
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
				unitsForCalculation.radiusIsEditable=0;
				unitsForCalculation.sideIsEditable=1;
				unitsForCalculation.heightIsEditable=0;
				editUnits.EditableUnits(unitsForGUI,2);
				controls.radius=0;
				controls.side=0;
				controls.height=0;
			}
		}
		class CuboidListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				radius.setText("bok");
				side.setText("bok");
				height.setText("wysokosc");
				radius.setEditable(true);
				side.setEditable(true);
				height.setEditable(true);
				unitsForCalculation.radiusIsEditable=1;
				unitsForCalculation.sideIsEditable=1;
				unitsForCalculation.heightIsEditable=1;
				editUnits.EditableUnits(unitsForGUI,3);
				controls.radius=0;
				controls.side=0;
				controls.height=0;
			}
		}
		//listenery do czyszczenia okienek
		class RadiusWindowListener implements MouseListener
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(Editable(unitsForGUI.getRadiusIsEditable())==1)
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
				if(Editable(unitsForGUI.getSideIsEditable())==1)
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
				if(Editable(unitsForGUI.getHeightIsEditable())==1)
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
			public void focusGained(FocusEvent arg0) 
			{}
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
						if(radiusCalculate>20)
						{
							radiusCalculate=20;
							radius.setText(Integer.toString(radiusCalculate));
							if(unitsForGUI.getRadiusIsEditable()==1&&unitsForGUI.getHeightIsEditable()==0&&unitsForGUI.getSideIsEditable()==0)
							giveSize.size.setText(Integer.toString(32000));
							unitsForGUI.setRadiusValue(radiusCalculate);
							controls.radius=radiusCalculate;
						}
						else if(radiusCalculate<12)
						{
							radiusCalculate=12;
							radius.setText(Integer.toString(radiusCalculate));
							if(unitsForGUI.getRadiusIsEditable()==1&&unitsForGUI.getHeightIsEditable()==0&&unitsForGUI.getSideIsEditable()==0)
							giveSize.size.setText(Integer.toString(6912));
							unitsForGUI.setRadiusValue(radiusCalculate);
							controls.radius=radiusCalculate;
						}
						else
						{
							unitsForGUI.setRadiusValue(radiusCalculate);
							controls.radius=radiusCalculate;
							int giveSizeText=unitsForGUI.getRadiusValue()*unitsForGUI.getRadiusValue()*unitsForGUI.getRadiusValue()*4;
							if(unitsForGUI.getRadiusIsEditable()==1&&unitsForGUI.getHeightIsEditable()==0&&unitsForGUI.getSideIsEditable()==0)
							giveSize.size.setText(Integer.toString(giveSizeText));
						}
					}
				}
				catch (Exception e)
				{
					if(unitsForGUI.getRadiusIsEditable()==1)
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
			public void focusGained(FocusEvent arg0) 
			{}
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
						if(sideCalculate>40)
						{
							sideCalculate=40;
							side.setText(Integer.toString(sideCalculate));
							if(unitsForGUI.getRadiusIsEditable()==0&&unitsForGUI.getHeightIsEditable()==0&&unitsForGUI.getSideIsEditable()==1)
							giveSize.size.setText(Integer.toString(64000));
							unitsForGUI.setSideValue(sideCalculate);
							controls.side=sideCalculate;
						}
						else if(sideCalculate<12)
						{
							sideCalculate=12;
							side.setText(Integer.toString(sideCalculate));
							if(unitsForGUI.getRadiusIsEditable()==0&&unitsForGUI.getHeightIsEditable()==0&&unitsForGUI.getSideIsEditable()==1)
							giveSize.size.setText(Integer.toString(1728));
							unitsForGUI.setSideValue(sideCalculate);
							controls.side=sideCalculate;
						}
						else
						{
							unitsForGUI.setSideValue(sideCalculate);
							controls.side=sideCalculate;
							int giveSizeText=unitsForGUI.getSideValue()*unitsForGUI.getSideValue()*unitsForGUI.getSideValue();
							if(unitsForGUI.getRadiusIsEditable()==0&&unitsForGUI.getHeightIsEditable()==0&&unitsForGUI.getSideIsEditable()==1)
							giveSize.size.setText(Integer.toString(giveSizeText));
						}
					}
				}
				catch (Exception e)
				{
					if(unitsForGUI.getSideIsEditable()==1)
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
			public void focusGained(FocusEvent arg0) 
			{}
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				int heightCalculate;
				heightValue=height.getText();
				try
				{
					if (isDouble.plusDouble(heightValue,isDouble.isDouble(heightValue))) throw new Exception();
					else
					{
						heightCalculate=Integer.parseInt(heightValue);
						if(heightCalculate>40)
						{
							heightCalculate=40;
							height.setText(Integer.toString(heightCalculate));
							if(unitsForGUI.getRadiusIsEditable()==1&&unitsForGUI.getHeightIsEditable()==1&&unitsForGUI.getSideIsEditable()==1)
							giveSize.size.setText(Integer.toString(unitsForGUI.getHeightValue()*unitsForGUI.getSideValue()*unitsForGUI.getRadiusValue()));
							unitsForGUI.setHeightValue(heightCalculate);
							controls.height=heightCalculate;
						}
						else if(heightCalculate<12)
						{
							heightCalculate=12;
							height.setText(Integer.toString(heightCalculate));
							if(unitsForGUI.getRadiusIsEditable()==1&&unitsForGUI.getHeightIsEditable()==1&&unitsForGUI.getSideIsEditable()==1)
							giveSize.size.setText(Integer.toString(unitsForGUI.getHeightValue()*unitsForGUI.getSideValue()*unitsForGUI.getRadiusValue()));
							unitsForGUI.setHeightValue(heightCalculate);
							controls.height=heightCalculate;
						}
						else
						{
							unitsForGUI.setHeightValue(heightCalculate);
							controls.height=heightCalculate;
							int giveSizeText=unitsForGUI.getHeightValue()*unitsForGUI.getSideValue()*unitsForGUI.getRadiusValue();
							if(unitsForGUI.getRadiusIsEditable()==1&&unitsForGUI.getHeightIsEditable()==1&&unitsForGUI.getSideIsEditable()==1)
							giveSize.size.setText(Integer.toString(giveSizeText));		
						}
					}
				}
				catch (Exception e)
				{
					if(unitsForGUI.getRadiusIsEditable()==1 && unitsForGUI.getSideIsEditable()==1 && unitsForGUI.getHeightIsEditable()==1) 
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
