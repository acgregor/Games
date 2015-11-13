package contents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Control 
{
	private Model model;
	private View view;
	
	public Control(Model m, View v)
	{
		model=m;
		view=v;
		
		view.addL(new buttonListener());
		view.setNumber(model.getX());
	}
	class buttonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="Custom")
			{
				view.getCardLayout().show(view.getCardPanel(), "2");
			}
			else
			{
				view.getCardLayout().show(view.getCardPanel(), "1");
			}
			
		}
		
	}
}
