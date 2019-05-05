//klasa obslugujaca element size
//TO DO:
package GUI;

import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiveSize extends JPanel 
{
	private static final long serialVersionUID = 1L;
	public GiveSize() 
	{
		JPanel GiveSizePanel=new JPanel();
		JTextField size = new JTextField("rozmiar próbki");
		size.setEditable(false);
		this.add(GiveSizePanel);
		GiveSizePanel.add(size);
	}

	public GiveSize(LayoutManager layout) 
	{
		super(layout);
	}

	public GiveSize(boolean isDoubleBuffered) 
	{
		super(isDoubleBuffered);
	}

	public GiveSize(LayoutManager layout, boolean isDoubleBuffered) 
	{
		super(layout, isDoubleBuffered);
	}
}
