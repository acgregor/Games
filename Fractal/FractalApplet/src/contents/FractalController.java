package contents;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
/**
 * 
 * @author Austen Gregor
 * 
 * Created 09/4/2015
 */
public class FractalController
{
	private FractalModel model;
	private FractalView view;
	private boolean customBG;
	private boolean customFract1,customFract2,customFract3,customFract4;
	private boolean next1Continues,next2Continues,next3Continues;
	
	public FractalController(FractalModel m, FractalView v)
	{
		model=m;
		view=v;
		
		//first frame listeners and variables
		customBG=false;
		view.addBG_Color_Listener((ActionListener)new bgColorOptionListener());
		view.addFractNumberListener(new fractNumberListener());
		view.addNextButtonListener(new nextListener());
		
		customFract1=false;
		customFract2=false;
		customFract3=false;
		customFract4=false;
		next1Continues=false;
		next2Continues=false;
		next3Continues=false;
		
	}
	
	//used to detect what option the user has selected for the background color
	class bgColorOptionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="Custom")
			{
				view.getBG_Layout().show(view.getBG_CardPanel(), "2");
				customBG=true;
			}
			else
			{
				view.getBG_Layout().show(view.getBG_CardPanel(), "1");
				customBG=false;
				if(((JComboBox)e.getSource()).getSelectedItem()=="Black")
				{
					view.setBG_Color("000000");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="White")
				{
					view.setBG_Color("ffffff");
				}
			}
			
		}
	}
	
	//used to detect the number of fractals the user has selected
	class fractNumberListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="1")
			{
				next1Continues=false;
				next2Continues=false;
				next3Continues=false;
				view.setNumColors(1);
			}				
			else if(((JComboBox)e.getSource()).getSelectedItem()=="2")
			{
				next1Continues=true;
				next2Continues=false;
				next3Continues=false;
				view.setNumColors(2);
			}	
			else if(((JComboBox)e.getSource()).getSelectedItem()=="3")
			{
				next1Continues=true;
				next2Continues=true;
				next3Continues=false;
				view.setNumColors(3);
			}
			else
			{
				next1Continues=true;
				next2Continues=true;
				next3Continues=true;
				view.setNumColors(4);
			}
		}		
	}
	
	//used to detect if the user has pushed the next button and checks that all input is valid
	class nextListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(customBG)
			{
				model.checkBackgroundOptions(view.getBG_Text());
				
				if(model.isBackgroundWarnings())
				{
					view.displayBGWarning();
				}
				else
				{
					view.setBG_Color(view.getBG_Text());
				}
			}
			
			model.checkLineLengthOptions(view.getLineLengthText());
			if(model.isLineLengthWarnings())
			{
				view.displayLineWarning();
			}
			else
			{
				model.setLineLength(Integer.parseInt(view.getLineLengthText()));
			}
			
			if(!model.isBackgroundWarnings() && !model.isLineLengthWarnings())
			{
				view.createFractalSettings1();
				view.addFract_Color_Listener1(new fract1ColorOptionListener());
				view.addAnimationOptionListener1(new animationListener1());
				view.addBack1Listener(new back1Listener());
				view.addNext1Listener(new next1Listener());
			}
			else
			{
				model.resetWarnings();
			}
		}
	}

	//used to detect what color the user has selected for the first fractal
	class fract1ColorOptionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="Custom")
			{
				customFract1=true;
				view.getFract_Layout1().show(view.getFract_CardPanel1(), "2");
			}
			else
			{
				view.getFract_Layout1().show(view.getFract_CardPanel1(), "1");
				customFract1=false;
				if(((JComboBox)e.getSource()).getSelectedItem()=="Red")
				{
					view.setFract1_Color("ff0000");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Orange")
				{
					view.setFract1_Color("ff7700");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Yellow")
				{
					view.setFract1_Color("ffff00");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Green")
				{
					view.setFract1_Color("00ff00");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Blue")
				{
					view.setFract1_Color("0000ff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Purple")
				{
					view.setFract1_Color("ff00ff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="White")
				{
					view.setFract1_Color("ffffff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Rainbow")
				{					
					model.createRainbow();
					view.setFractColorArray(model.getRainbow());
					view.setRainbowBool1(true);
				}
			}
			
		}
	}
	
	//used to detect if the user wants the first fractal to be animated
	class animationListener1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="NO")
			{
				view.setAnimationOption1(false);
			}
			else
			{
				view.setAnimationOption1(true);
			}
		}	
	}
	
	//back button detection proceeds back to the first settings frame
	class back1Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			view.disposeFract1();
			view.showSettings();
		}
	}
	
	//if there is only one fractal to create the next button will create a drawing frame
	//otherwise it will proceed to the next fractal settings frame
	class next1Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(customFract1)
			{
				model.checkFractalOptions(view.getFract1Color_Text());
			}
			if(model.isFractalWarnings())
			{
				view.displayFractWarning();
			}
			else
			{
				if(customFract1)
				{
					view.setFract1_Color(view.getFract1Color_Text());
				}
				model.setupArray1();
				model.CalculateArray1();
				view.setFractArray1(model.getArray1());
				if(next1Continues)
				{
					view.createFractalSettings2();
					view.addFract_Color_Listener2(new fract2ColorOptionListener());
					view.addAnimationOptionListener2(new animationListener2());
					view.addNext2Listener(new next2Listener());
					view.addBack2Listener(new back2Listener());
				}
				else
				{
					view.disposeFract1();
					view.createDrawingPanel();
					view.addDrawingWindowListener(new WindowListener());
				}
			}
			model.resetWarnings();
		}
	}
	
	class fract2ColorOptionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="Custom")
			{
				customFract2=true;
				view.getFract_Layout2().show(view.getFract_CardPanel2(), "2");
			}
			else
			{
				view.getFract_Layout2().show(view.getFract_CardPanel2(), "1");
				customFract2=false;
				if(((JComboBox)e.getSource()).getSelectedItem()=="Red")
				{
					view.setFract2_Color("ff0000");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Orange")
				{
					view.setFract2_Color("ff7700");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Yellow")
				{
					view.setFract2_Color("ffff00");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Green")
				{
					view.setFract2_Color("00ff00");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Blue")
				{
					view.setFract2_Color("0000ff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Purple")
				{
					view.setFract2_Color("ff00ff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="White")
				{
					view.setFract2_Color("ffffff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Rainbow")
				{					
					model.createRainbow();
					view.setFractColorArray(model.getRainbow());
					view.setRainbowBool2(true);
				}
			}
			
		}
	}
	class animationListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="NO")
			{
				view.setAnimationOption2(false);
			}
			else
			{
				view.setAnimationOption2(true);
			}
		}	
	}
	class back2Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			view.disposeFract2();
			view.createFractalSettings1();
			view.addFract_Color_Listener1(new fract1ColorOptionListener());
			view.addAnimationOptionListener1(new animationListener1());
			view.addBack1Listener(new back1Listener());
			view.addNext1Listener(new next1Listener());
		}
	}
	
	class next2Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(customFract2)
			{
				model.checkFractalOptions(view.getFract2Color_Text());
			}
			if(model.isFractalWarnings())
			{
				view.displayFractWarning();
			}
			else
			{
				if(customFract2)
				{
					view.setFract2_Color(view.getFract2Color_Text());
				}
				model.setupArray2();
				model.CalculateArray2();
				view.setFractArray2(model.getArray2());
				if(next2Continues)
				{
					view.createFractalSettings3();
					view.addFract_Color_Listener3(new fract3ColorOptionListener());
					view.addAnimationOptionListener3(new animationListener3());
					view.addNext3Listener(new next3Listener());
					view.addBack3Listener(new back3Listener());
				}
				else
				{
					view.disposeFract2();
					view.createDrawingPanel();
					view.addDrawingWindowListener(new WindowListener());
				}
			}
			model.resetWarnings();
		}
	}
	
	class fract3ColorOptionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="Custom")
			{
				customFract3=true;
				view.getFract_Layout3().show(view.getFract_CardPanel3(), "2");
			}
			else
			{
				view.getFract_Layout3().show(view.getFract_CardPanel3(), "1");
				customFract3=false;
				if(((JComboBox)e.getSource()).getSelectedItem()=="Red")
				{
					view.setFract3_Color("ff0000");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Orange")
				{
					view.setFract3_Color("ff7700");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Yellow")
				{
					view.setFract3_Color("ffff00");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Green")
				{
					view.setFract3_Color("00ff00");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Blue")
				{
					view.setFract3_Color("0000ff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Purple")
				{
					view.setFract3_Color("ff00ff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="White")
				{
					view.setFract3_Color("ffffff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Rainbow")
				{					
					model.createRainbow();
					view.setFractColorArray(model.getRainbow());
					view.setRainbowBool3(true);
				}
			}
			
		}
	}
	class animationListener3 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="NO")
			{
				view.setAnimationOption3(false);
			}
			else
			{
				view.setAnimationOption3(true);
			}
		}	
	}
	class back3Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			view.disposeFract3();
			view.createFractalSettings2();
			view.addFract_Color_Listener2(new fract2ColorOptionListener());
			view.addAnimationOptionListener2(new animationListener2());
			view.addBack2Listener(new back2Listener());
			view.addNext2Listener(new next2Listener());
		}
	}
	
	class next3Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(customFract3)
			{
				model.checkFractalOptions(view.getFract3Color_Text());
			}
			if(model.isFractalWarnings())
			{
				view.displayFractWarning();
			}
			else
			{
				if(customFract3)
				{
					view.setFract3_Color(view.getFract3Color_Text());
				}
				model.setupArray3();
				model.CalculateArray3();
				view.setFractArray3(model.getArray3());
				if(next3Continues)
				{
					view.createFractalSettings4();
					view.addFract_Color_Listener4(new fract4ColorOptionListener());
					view.addAnimationOptionListener4(new animationListener4());
					view.addNext4Listener(new next4Listener());
					view.addBack4Listener(new back4Listener());
				}
				else
				{
					view.disposeFract3();
					view.createDrawingPanel();
					view.addDrawingWindowListener(new WindowListener());
				}
			}
			model.resetWarnings();
		}
	}
	
	class fract4ColorOptionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="Custom")
			{
				customFract4=true;
				view.getFract_Layout4().show(view.getFract_CardPanel4(), "2");
			}
			else
			{
				view.getFract_Layout4().show(view.getFract_CardPanel4(), "1");
				customFract4=false;
				if(((JComboBox)e.getSource()).getSelectedItem()=="Red")
				{
					view.setFract4_Color("ff0000");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Orange")
				{
					view.setFract4_Color("ff7700");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Yellow")
				{
					view.setFract4_Color("ffff00");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Green")
				{
					view.setFract4_Color("00ff00");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Blue")
				{
					view.setFract4_Color("0000ff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Purple")
				{
					view.setFract4_Color("ff00ff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="White")
				{
					view.setFract4_Color("ffffff");
				}
				else if(((JComboBox)e.getSource()).getSelectedItem()=="Rainbow")
				{					
					model.createRainbow();
					view.setFractColorArray(model.getRainbow());
					view.setRainbowBool4(true);
				}
			}
			
		}
	}
	class animationListener4 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(((JComboBox)e.getSource()).getSelectedItem()=="NO")
			{
				view.setAnimationOption4(false);
			}
			else
			{
				view.setAnimationOption4(true);
			}
		}	
	}
	class back4Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			view.disposeFract4();
			view.createFractalSettings3();
			view.addFract_Color_Listener3(new fract2ColorOptionListener());
			view.addAnimationOptionListener3(new animationListener3());
			view.addBack3Listener(new back3Listener());
			view.addNext3Listener(new next3Listener());
		}
	}
	
	class next4Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(customFract4)
			{
				model.checkFractalOptions(view.getFract4Color_Text());
			}
			if(model.isFractalWarnings())
			{
				view.displayFractWarning();
			}
			else
			{
				if(customFract4)
				{
					view.setFract4_Color(view.getFract4Color_Text());
				}
				model.setupArray4();
				model.CalculateArray4();
				view.setFractArray4(model.getArray4());
				view.disposeFract4();
				view.createDrawingPanel();
				view.addDrawingWindowListener(new WindowListener());
			}
			model.resetWarnings();
		}
	}
	
	//used to reset the program upon closing the drawing frame
	class WindowListener implements java.awt.event.WindowListener
	{

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowClosed(WindowEvent e) {}

		@Override
		public void windowClosing(WindowEvent e) 
		{
			view.showSettings();
		}

		@Override
		public void windowDeactivated(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowOpened(WindowEvent e) {}
		
	}
}