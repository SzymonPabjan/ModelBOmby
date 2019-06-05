//klasa do guziczkow akcyjnych
//TO DO: sprawic aby guziczki dzialaly
package GUI;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import math.Atom;
import math.SymulationThread;

public class Controls extends JPanel 
{
	private static final long serialVersionUID = 1L;
	boolean startActivaction=false,stopActivaction=false,restartActivaction=false;
	
	SymulationThread ST = new SymulationThread(20, 20, 20);
	ExecutorService exec = Executors.newFixedThreadPool(2);
	Thread my = new Thread();
	
	void StartSymualtionThread() {
		exec.execute(ST);
	//tutaj trzeba poczkeaæ a¿ sie skoñczy watek obliczeñ by wypluæ Listê zawierjac¹ rozpadniete atomy do animacji
	}
	
	public Controls() 
	{
		JPanel ControlsJPanel=new JPanel();
		JPanel ControlsJPanel2=new JPanel();
		JPanel ControlsJPanel3=new JPanel(new GridLayout(2,1));
		JButton start = new JButton("START");
		JButton stop = new JButton("STOP");
		JButton restart = new JButton("RESTART");
		JLabel text = new JLabel("symulacja");
		//ControlsStatusActivaction activactionStatus=new ControlsStatusActivaction();
		
		
		
		ActionListener startListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				/*activactionStatus.*/startActivaction=true;
				/*activactionStatus.*/stopActivaction=false;
				/*activactionStatus.*/restartActivaction=false;
//				Thread thread=new Thread();
//				thread.run();
//				ST.active=true;
				StartSymualtionThread();
			}
		};
		ActionListener stopListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent arg1)
			{
				startActivaction=false;
				stopActivaction=true;
				restartActivaction=false;
				
//			ST.active=false;
			ST.interrupt();
			}
		};
		ActionListener restartListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent arg2)
			{
				startActivaction=false;
				stopActivaction=false;
				restartActivaction=true;
	
				ST.active=false;
				ST.interrupt();
				ST.active=true;
				StartSymualtionThread();
			}
		};
		start.addActionListener(startListener);
		stop.addActionListener(stopListener);
		restart.addActionListener(restartListener);
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
