//klasa do guziczkow akcyjnych
package pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.GUI;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import pl.edu.pw.fizyka.pojava.SzyPab_KrzGad.math.SymulationThread;

public class Controls extends JPanel 
{
	private static final long serialVersionUID = 1L;
	int radius=0,side=0,height=0;
	SymulationThread symulationThread;
	Animation animation=new Animation();
	ExecutorService executorService = Executors.newFixedThreadPool(2);
	Thread thread = new Thread();
	
	
	
	void StartSymualtionThread() 
	{
		
		start.setEnabled(false);
		SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				symulationThread.start();
				symulationThread.join();
				start.setEnabled(true);
				
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Desktop"));
				chooser.showSaveDialog(null);
				FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
	            fw.write(symulationThread.symOutput.toString());
				
				return null;
			}
			
		};
		
		worker.execute();
	}
	
	//inicjalizacja wszystkiego
	JPanel ControlsJPanel=new JPanel();
	JPanel ControlsJPanel2=new JPanel();
	JPanel ControlsJPanel3=new JPanel(new GridLayout(2,1));
	JButton start = new JButton("START");
	JButton stop = new JButton("STOP");
	JButton restart = new JButton("RESTART");
	JLabel text = new JLabel("symulacja");
	//animation.defaultValue();
	//listenery
	ActionListener startListener=new ActionListener()
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if(radius!=0&&side==0&&height==0)
				symulationThread = new SymulationThread(radius, radius, radius);//tu wczytywane sa dane do obliczen dla kuli
			if(radius==0&&side!=0&&height==0)
				symulationThread = new SymulationThread(side, side, side);//tu wczytywane sa dane do obliczen dla szescianu
			if(radius!=0&&side!=0&&height!=0)
				symulationThread = new SymulationThread(radius, side, height);//tu wczytywane sa dane do obliczen dla prostopadloscianu
			StartSymualtionThread();
			JOptionPane.showMessageDialog(ControlsJPanel3, "Przetwarzanie danych, prosze nie gasic programu", "Inforamtion", JOptionPane.INFORMATION_MESSAGE);
		}
	};
	ActionListener stopListener=new ActionListener()
	{
		public void actionPerformed(ActionEvent arg1)
		{
			UnitsForAnimation.czynny=false;
			symulationThread.interrupt();
			
		}
	};
	ActionListener restartListener=new ActionListener()
	{
		public void actionPerformed(ActionEvent arg2)
		{
			UnitsForAnimation.czynny=true;
			//SymulationThread.active=false;
			symulationThread.interrupt();
			if(radius!=0&&side==0&&height==0)
				symulationThread = new SymulationThread(radius, radius, radius);//tu wczytywane sa dane do obliczen dla kuli
			if(radius==0&&side!=0&&height==0)
				symulationThread = new SymulationThread(side, side, side);//tu wczytywane sa dane do obliczen dla szescianu
			if(radius!=0&&side!=0&&height!=0)
				symulationThread = new SymulationThread(radius, side, height);//tu wczytywane sa dane do obliczen dla prostopadloscianu
			SymulationThread.active=true;
			StartSymualtionThread();
		}
	};

	public Controls() 
	{
	
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
