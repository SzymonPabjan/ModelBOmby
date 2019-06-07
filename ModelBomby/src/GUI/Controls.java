//klasa do guziczkow akcyjnych
//TO DO: guzik stop musi zabijac watek
package GUI;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import math.SymulationThread;

public class Controls extends JPanel 
{
	private static final long serialVersionUID = 1L;
	int radius=0,side=0,height=0;
	//boolean startActivaction=false,stopActivaction=false,restartActivaction=false;
	//UnitsForCalculation unitsForCalculation;
	//SymulationThread ST = new SymulationThread(20, 20, 20);//tu wczytywane sa dane do obliczen
	//SymulationThread ST = new SymulationThread(side, side, side);//tu wczytywane sa dane do obliczen dla szescianu
	SymulationThread ST;
	Animation animation=new Animation();
	ExecutorService exec = Executors.newFixedThreadPool(2);
	Thread my = new Thread();
	
	void StartSymualtionThread() 
	{
		exec.execute(ST);
	//tutaj trzeba poczkeaæ a¿ sie skoñczy watek obliczeñ by wypluæ Listê zawierjac¹ rozpadniete atomy do animacji
	}

	public Controls() 
	{
		//inicjalizacja wszystkiego
		JPanel ControlsJPanel=new JPanel();
		JPanel ControlsJPanel2=new JPanel();
		JPanel ControlsJPanel3=new JPanel(new GridLayout(2,1));
		JButton start = new JButton("START");
		JButton stop = new JButton("STOP");
		JButton restart = new JButton("RESTART");
		JLabel text = new JLabel("symulacja");
		//Animation.defaultValue();
		//listenery
		ActionListener startListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(radius!=0&&side==0&&height==0)
				ST = new SymulationThread(radius, radius, radius);//tu wczytywane sa dane do obliczen dla kuli//DO POPRAWY!!!!!!!!!!!!!!!!!!!!!!!
				if(radius==0&&side!=0&&height==0)
				ST = new SymulationThread(side, side, side);//tu wczytywane sa dane do obliczen dla szescianu
				if(radius!=0&&side!=0&&height!=0)
				ST = new SymulationThread(radius, side, height);//tu wczytywane sa dane do obliczen dla prostopadloscianu
				
//				Thread thread=new Thread();
//				thread.run();
//				ST.active=true;
				animation.defaultValue();
				//animation.startValue();
				//animation.rozpocznijRuch();
				System.out.println(radius);
				System.out.println(side);
				System.out.println(height);
				StartSymualtionThread();
				JOptionPane.showMessageDialog(ControlsJPanel3, "Przetwarzanie danych, prosze nie gasic programu", "Inforamtion", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		ActionListener stopListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent arg1)
			{
				UnitsForAnimation.czynny=false;
				//Animation.startValue();
				//animation.stopValue();
				//Animation.interrupt();
				//Animation.stop();
				ST.active=false;
				ST.interrupt();
				
			}
		};
		ActionListener restartListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent arg2)
			{
				animation.defaultValue();
				UnitsForAnimation.czynny=true;
				animation.startValue();
				animation.rozpocznijRuch();
				
				ST.active=false;
				ST.interrupt();
				ST.active=true;
				StartSymualtionThread();
				
			}
		};
		//dodanie listenerow do guziczkow
		start.addActionListener(startListener);
		stop.addActionListener(stopListener);
		restart.addActionListener(restartListener);
		//dodanie reszty do siebie
		ControlsJPanel3.add(ControlsJPanel);
		ControlsJPanel3.add(ControlsJPanel2);
		this.add(ControlsJPanel3);
		ControlsJPanel.add(text);
		ControlsJPanel2.add(start);
		ControlsJPanel2.add(stop);
		ControlsJPanel2.add(restart);
		
	}
	public Controls(LayoutManager layout) 
	{
		super(layout);
	}
	public Controls(boolean isDoubleBuffered)
	{
		super(isDoubleBuffered);
	}
	public Controls(LayoutManager layout, boolean isDoubleBuffered) 
	{
		super(layout, isDoubleBuffered);
	}
}
