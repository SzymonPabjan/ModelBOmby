//klasa do guziczkow akcyjnych
//TO DO: guzik stop musi zabijac watek
package GUI;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Controls extends JPanel 
{
	private static final long serialVersionUID = 1L;
	boolean startActivaction=false,stopActivaction=false,restartActivaction=false;
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
		Animation.defaultValue();
		//listenery
		ActionListener startListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				UnitsForAnimation.czynny=true;
				Animation.startValue();
				Animation.rozpocznijRuch();
			}
		};
		ActionListener stopListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent arg1)
			{
				UnitsForAnimation.czynny=false;
			}
		};
		ActionListener restartListener=new ActionListener()
		{
			public void actionPerformed(ActionEvent arg2)
			{
				Animation.defaultValue();
				Animation.startValue();
				UnitsForAnimation.czynny=true;
				Animation.rozpocznijRuch();
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
