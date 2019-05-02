//klasa tworzaca GUI dla szybkosci animacji
package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChooseSpeed extends JPanel 
{
	private static final long serialVersionUID = 1L;
	public ChooseSpeed() 
	{
		JPanel SliderJPanel=new JPanel();
		JPanel SliderJPanel2=new JPanel();
		JPanel SliderJPanel3=new JPanel(new GridLayout(2,1));
		JLabel showTime = new JLabel();
		JLabel text = new JLabel("szybkoœæ symulacji:");
		JSlider time = new JSlider(JSlider.HORIZONTAL, 0 , 100, 1);
		
		this.setLayout(new BorderLayout());
		time.setMajorTickSpacing(20);
		time.setMinorTickSpacing(10);
		time.setPaintLabels(true);
		time.setPaintTicks(true);
		
		class SliderChangeListener implements ChangeListener
		{
			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				String value = String.format("%d", time.getValue());
				showTime.setText(value);
				int value1 = time.getValue();
			}	
		}
		
		showTime.setText("1");
		time.addChangeListener(new SliderChangeListener());
		SliderJPanel3.add(SliderJPanel);
		SliderJPanel3.add(SliderJPanel2);
		this.add(SliderJPanel3);
		SliderJPanel.add(BorderLayout.CENTER, time);
		SliderJPanel2.add(BorderLayout.PAGE_START, text);
		SliderJPanel2.add(BorderLayout.PAGE_START, showTime);
	}

	public ChooseSpeed(LayoutManager layout) 
	{
		super(layout);
	}

	public ChooseSpeed(boolean isDoubleBuffered) 
	{
		super(isDoubleBuffered);
	}

	public ChooseSpeed(LayoutManager layout, boolean isDoubleBuffered) 
	{
		super(layout, isDoubleBuffered);
	}
}
