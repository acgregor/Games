package contents;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * 
 * @author Austen Gregor
 * 
 * Created 09/4/2015
 */

public class FractalView
{
	//first settings frame components
	private JFrame settings,canvas;
	
	private JPanel settingsPane;
	private JPanel bgColorOuterPane,bgCustomColorCardPanel,bgCustomColorSubPane1,bgCustomColorSubPane2;
	private JPanel fractNumOuterPane,fractNumBlankPane;
	private JPanel lineOuterPane,lineBlankPane;
	private JPanel bgSeparator, fractNumberSeparator, lineLengthSeparator;
	private JPanel proceedingPanel;
	private JPanel back;
	
	private CardLayout bgCustomColorCardLayout;
	
	private JLabel bgColorLabel;
	private JLabel fractalNumberLabel;
	private JLabel lineLengthLabel1,lineLengthLabel2,lineLengthLabel3;
	
	private JComboBox bgColorOptions, fractalNumberOptions;
	
	private JTextField bgColorTextField, lineLengthTextField;
	
	private Button next;
	
	//fractal settings components 1,2,3,4
	private JFrame fractSettings1,fractSettings2,fractSettings3,fractSettings4;
	
	private JPanel fractSettingsPanel1,fractSettingsPanel2,fractSettingsPanel3,fractSettingsPanel4;
	private JPanel fractColorOuterPanel1,fractColorOuterPanel2,fractColorOuterPanel3,fractColorOuterPanel4;
	
	private JPanel fractCustomColorCardPanel1,fractCustomColorSubPanel1_1,fractCustomColorSubPanel1_2;
	private JPanel fractCustomColorCardPanel2,fractCustomColorSubPanel2_1,fractCustomColorSubPanel2_2;
	private JPanel fractCustomColorCardPanel3,fractCustomColorSubPanel3_1,fractCustomColorSubPanel3_2;
	private JPanel fractCustomColorCardPanel4,fractCustomColorSubPanel4_1,fractCustomColorSubPanel4_2;
	
	private JPanel fractAnimationOuterPanel1,animationBlankPane1;
	private JPanel fractAnimationOuterPanel2,animationBlankPane2;
	private JPanel fractAnimationOuterPanel3,animationBlankPane3;
	private JPanel fractAnimationOuterPanel4,animationBlankPane4;
	
	private JPanel blankSeparatorPanel1_1,blankSeparatorPanel1_2;
	private JPanel blankSeparatorPanel2_1,blankSeparatorPanel2_2;
	private JPanel blankSeparatorPanel3_1,blankSeparatorPanel3_2;
	private JPanel blankSeparatorPanel4_1,blankSeparatorPanel4_2;
	
	private JPanel proceedingPanel1,proceedingPanel2,proceedingPanel3,proceedingPanel4;
	
	private CardLayout fractCustomColorCardLayout1,fractCustomColorCardLayout2,fractCustomColorCardLayout3,fractCustomColorCardLayout4;
	
	private JLabel fractColorLabel1,fractColorLabel2,fractColorLabel3,fractColorLabel4;
	private JLabel fractAnimationLabel1,fractAnimationLabel2,fractAnimationLabel3,fractAnimationLabel4;
	
	private JTextField fractCustomColorTextField1,fractCustomColorTextField2,fractCustomColorTextField3,fractCustomColorTextField4;
	
	private JComboBox fractColorOptions1,fractColorOptions2,fractColorOptions3,fractColorOptions4;
	private JComboBox animationOptions1,animationOptions2,animationOptions3,animationOptions4;
	
	private Button next1,next2,next3,next4;
	private Button back1,back2,back3,back4;
	
	//Graphic components
	private GUIPanel drawing;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width=screenSize.width;
	private int height=screenSize.height;
	
	private static ArrayList<Integer> fractArray1,fractArray2,fractArray3,fractArray4;
	
	private Color bgColor;

	private static Color fractColor1,fractColor2,fractColor3,fractColor4;
	
	private static Color[] RainbowArray;
	
	private Font font=new Font("Arial", Font.PLAIN, 30);
	
	//useful booleans and integers to help draw
	private static boolean isAnimation1,isAnimation2,isAnimation3,isAnimation4;
	private static boolean isRainbowFract1,isRainbowFract2,isRainbowFract3,isRainbowFract4;
	private static boolean isDrawn1,isDrawn2,isDrawn3,isDrawn4;
	
	private static int rainbowIndex1=0;
	private static int rainbowIndex2=0;
	private static int rainbowIndex3=0;
	private static int rainbowIndex4=0;
	private static int numColors=1;
	
	FractalView()
	{
		//first frame will ask for a background color, the number of fractals to draw, and a line length
		
		//Create the first frame and call it settings
		settings=new JFrame("Dragon Curve Settings");
		
		//Create the settings panel to hold all features
		settingsPane=new JPanel(new GridLayout(0,1));
		settingsPane.setBackground(Color.LIGHT_GRAY);
		
		//create a label asking the user to choose a background color for the fractal drawing
		bgColorLabel=new JLabel("Choose a background color");
		bgColorLabel.setFont(font);
		
		//add the label to the panel
		settingsPane.add(bgColorLabel);
		
		//create another panel to hold the user's background options
		bgColorOuterPane=new JPanel(new GridLayout(1,2));
		
		//create a drop-down box for users to choose a background color
		String [] bgString=new String[]{"Black","White","Custom"};
		bgColorOptions=new JComboBox(bgString);
		bgColorOptions.setFont(font);		
		
		//initialize values to match first menu item
		bgColor=Color.BLACK;
		
		//add the drop-down box to the panel
		bgColorOuterPane.add(bgColorOptions);
		
		//create a cardpanel to show a textfield if the user chooses 'Custom' from the drop-down menu
		bgCustomColorCardLayout=new CardLayout();
		bgCustomColorCardPanel=new JPanel(bgCustomColorCardLayout);
		
		//bgSubPane1 is a blank panel
		bgCustomColorSubPane1=new JPanel();
		bgCustomColorSubPane1.setBackground(Color.LIGHT_GRAY);
		
		//bgSubPane2 is a panel that holds a textfield for the user to input his/her own custom color value for the background
		bgCustomColorSubPane2=new JPanel(new GridLayout(1,1));
		bgColorTextField=new JTextField("000000");
		bgColorTextField.setFont(font);
		bgCustomColorSubPane2.add(bgColorTextField);
		
		//add both the blank panel and textfield to the card panel
		bgCustomColorCardPanel.add(bgCustomColorSubPane1,"1");
		bgCustomColorCardPanel.add(bgCustomColorSubPane2,"2");
		bgCustomColorCardLayout.show(bgCustomColorCardPanel, "1");
		
		//add the card panel to the outer panel
		bgColorOuterPane.add(bgCustomColorCardPanel);
		
		//finally add the outer panel to the setting panel of the main frame
		settingsPane.add(bgColorOuterPane);
		
		//create and add separation panel
		bgSeparator=new JPanel();
		bgSeparator.setBackground(Color.LIGHT_GRAY);
		settingsPane.add(bgSeparator);
		
		//create a label asking the user for the number of fractals to generate
		fractalNumberLabel=new JLabel("How many fractals do you want to generate?");
		fractalNumberLabel.setFont(font);
		
		//add the label to the main settings panel
		settingsPane.add(fractalNumberLabel);
		
		//create another panel to hold the number of fractals option
		fractNumOuterPane=new JPanel(new GridLayout(1,2));
		
		//create the number of fractals option drop-down menu
		String [] fractNumber=new String[]{"1","2","3","4"};
		fractalNumberOptions=new JComboBox(fractNumber);
		fractalNumberOptions.setSelectedItem("1");
		fractalNumberOptions.setFont(font);
		
		//add the options to the outer fractal number panel
		fractNumOuterPane.add(fractalNumberOptions);
		
		//create a blank panel to keep the formatting for the fractal number options
		fractNumBlankPane=new JPanel();
		fractNumBlankPane.setBackground(Color.LIGHT_GRAY);
		
		//add the blank panel
		fractNumOuterPane.add(fractNumBlankPane);
		
		//add the outer panel to the main settings panel
		settingsPane.add(fractNumOuterPane);
		
		//create a blank panel to separate user settings
		fractNumberSeparator=new JPanel();
		fractNumberSeparator.setBackground(Color.LIGHT_GRAY);
		
		//add the separator panel to the main settings panel
		settingsPane.add(fractNumberSeparator);		
		
		//create a line length label that briefly explains how the design is made and what to input
		lineLengthLabel1=new JLabel("The fractal is made with lines.");
		lineLengthLabel2=new JLabel("Smaller lenghts will appear more 'filled in'.");
		lineLengthLabel3=new JLabel("Choose a line length integer of '1' or higher.");
		lineLengthLabel1.setFont(font);
		lineLengthLabel2.setFont(font);
		lineLengthLabel3.setFont(font);
		
		//add the label to the main settings panel
		settingsPane.add(lineLengthLabel1);
		settingsPane.add(lineLengthLabel2);
		settingsPane.add(lineLengthLabel3);
		
		//to keep the same format as the above panels an outer line panel is created
		lineOuterPane=new JPanel(new GridLayout(1,2));
		
		//creates a text field for user's to input a line length
		lineLengthTextField=new JTextField("1");
		lineLengthTextField.setFont(font);
		
		//add the text field to the outer line panel
		lineOuterPane.add(lineLengthTextField);
		
		//this is a blank panel
		lineBlankPane=new JPanel();
		lineBlankPane.setBackground(Color.LIGHT_GRAY);
		
		//add blank panel to the outer line panel
		lineOuterPane.add(lineBlankPane);
		
		//add the outer panel to the main settings panel
		settingsPane.add(lineOuterPane);
		
		//create and add line length blank panel
		lineLengthSeparator=new JPanel();
		lineLengthSeparator.setBackground(Color.LIGHT_GRAY);
		
		settingsPane.add(lineLengthSeparator);
		
		//create a panel to hold next and back buttons. Because this is the first frame the back button will be a blank panel
		proceedingPanel=new JPanel(new GridLayout(1,2));
		
		back=new JPanel();
		back.setBackground(Color.LIGHT_GRAY);
		
		//create a next button to check the user's settings and continue to the next frame
		next=new Button("Next");
		next.setFont(font);

		//add back and next to the proceeding panel
		proceedingPanel.add(back);
		proceedingPanel.add(next);
		
		//adds the button to the settings panel
		settingsPane.add(proceedingPanel);
		
		//the main frame now adds the complete settings panel
		settings.add(settingsPane);
		settings.pack();
		settings.setVisible(true);
		settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void showSettings()
	{
		settings.setVisible(true);
	}

	public void createFractalSettings1() 
	{
		//creates a frame to ask for a fractal color and whether or not to animate the drawing process
		
		//create new JFrame
		fractSettings1=new JFrame("First Fractal Settings");
		
		//creates a settings panel for the first fractal to edit color, etc.
		fractSettingsPanel1=new JPanel(new GridLayout(0,1));
		fractSettingsPanel1.setBackground(Color.LIGHT_GRAY);
		
		//create a label asking for a color of the first fractal
		fractColorLabel1=new JLabel("Choose a fractal color");
		fractColorLabel1.setFont(font);
		
		//add the fractal label to the main panel
		fractSettingsPanel1.add(fractColorLabel1);
		
		//create another panel to hold the user's fractal color options
		fractColorOuterPanel1=new JPanel(new GridLayout(1,2));
		
		//create a drop-down menu for the user's fractal color options
		String [] fractColorString1=new String[]{"Red","Orange","Yellow","Green","Blue","Purple","Rainbow","Custom"};
		fractColorOptions1=new JComboBox(fractColorString1);
		fractColorOptions1.setFont(font);
		
		//initialize colors to match initial settings
		fractColor1=Color.RED;
		isRainbowFract1=false;
		
		//add the drop-down menu to the outer fractal panel 
		fractColorOuterPanel1.add(fractColorOptions1);
		
		//add the outer panel to the first fractal settings panel
		fractSettingsPanel1.add(fractColorOuterPanel1);
		
		//create a blank panel to separate the color option from the animation option
		blankSeparatorPanel1_1=new JPanel();
		blankSeparatorPanel1_1.setBackground(Color.LIGHT_GRAY);
		
		//add the blank panel
		fractSettingsPanel1.add(blankSeparatorPanel1_1);
		
		//create a card panel like that of the background card panel
		fractCustomColorCardLayout1=new CardLayout();
		fractCustomColorCardPanel1=new JPanel(fractCustomColorCardLayout1);
		
		//this is a blank panel
		fractCustomColorSubPanel1_1=new JPanel();
		fractCustomColorSubPanel1_1.setBackground(Color.LIGHT_GRAY);
		
		//this is a textfield that appears if the user chooses 'Custom' from the drop-down menu
		fractCustomColorSubPanel1_2=new JPanel(new GridLayout(1,1));
		fractCustomColorTextField1=new JTextField("ffffff");
		fractCustomColorTextField1.setFont(font);
		fractCustomColorSubPanel1_2.add(fractCustomColorTextField1);
		
		//adds both the blank panel and the textfield to the card panel
		fractCustomColorCardPanel1.add(fractCustomColorSubPanel1_1,"1");
		fractCustomColorCardPanel1.add(fractCustomColorSubPanel1_2,"2");
		fractCustomColorCardLayout1.show(fractCustomColorCardPanel1, "1");
		
		//add the card panel to the outer panel
		fractColorOuterPanel1.add(fractCustomColorCardPanel1);
		
		//create a label asking if the fractal should be drawn in real time or drawn instantly
		fractAnimationLabel1=new JLabel("Do you want to see the fractal's drawing animation?");
		fractAnimationLabel1.setFont(font);
		
		//add the label to the fractal settings panel
		fractSettingsPanel1.add(fractAnimationLabel1);
		
		fractAnimationOuterPanel1=new JPanel(new GridLayout(1,2));
		
		//create animation option menu
		String[] animationString1=new String[]{"NO","YES"};
		animationOptions1=new JComboBox(animationString1);
		animationOptions1.setFont(font);
		
		//initialize option to match first menu item
		isAnimation1=false;
		
		//add animation option menu to outer animation panel
		fractAnimationOuterPanel1.add(animationOptions1);
		
		//create a blank panel to add in line with the options menu to keep formatting
		animationBlankPane1=new JPanel();
		animationBlankPane1.setBackground(Color.LIGHT_GRAY);
		
		//add blank panel to the outer animation panel
		fractAnimationOuterPanel1.add(animationBlankPane1);
		
		//add outer animation panel to fractal settings panel
		fractSettingsPanel1.add(fractAnimationOuterPanel1);
		
		//create a blank panel to separate the animation panel from the proceeding panel
		blankSeparatorPanel1_2=new JPanel();
		blankSeparatorPanel1_2.setBackground(Color.LIGHT_GRAY);
		
		//add the blank panel
		fractSettingsPanel1.add(blankSeparatorPanel1_2);
		
		//create a panel to hold next and back buttons.
		proceedingPanel1=new JPanel(new GridLayout(1,2));
		
		back1=new Button("Back");
		back1.setFont(font);
		
		//create a next button to check the user's settings and continue to the next frame
		next1=new Button("Next");
		next1.setFont(font);

		//add back and next to the proceeding panel
		proceedingPanel1.add(back1);
		proceedingPanel1.add(next1);
		
		//add the proceeding panel to the
		fractSettingsPanel1.add(proceedingPanel1);
		
		//add fractSettingsPane1 to the settings frame
		fractSettings1.add(fractSettingsPanel1);
		
		//set the frame to be visible
		fractSettings1.setVisible(true);
		fractSettings1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fractSettings1.pack();
		
		//hide the first settings frame
		settings.setVisible(false);
	}
	
	//methods that the controller uses to help add functionality to the background options
	public CardLayout getBG_Layout()
	{
		return bgCustomColorCardLayout;
	}
	public JPanel getBG_CardPanel()
	{
		return bgCustomColorCardPanel;
	}
	public void addBG_Color_Listener(ActionListener al)
	{
		bgColorOptions.addActionListener(al);
	}
	
	//getter and setter methods for background options
	public String getBG_Text()
	{
		return bgColorTextField.getText();
	}
	public Color getBG_Color()
	{
		return bgColor;
	}
	public void setBG_Color(String s)
	{
		int r,g,b;
		r=Integer.decode("0x"+s.charAt(0)+""+s.charAt(1));
		g=Integer.decode("0x"+s.charAt(2)+""+s.charAt(3));
		b=Integer.decode("0x"+s.charAt(4)+""+s.charAt(5));
		
		bgColor=new Color(r,g,b);
	}
	
	//add action listener to number options
	public void addFractNumberListener(ActionListener al) 
	{
		fractalNumberOptions.addActionListener(al);
	}

	//getter methods for line length options
	public String getLineLengthText()
	{
		return lineLengthTextField.getText();
	}
	
	//adds an action listener to the next button
	public void addNextButtonListener(ActionListener al)
	{
		next.addActionListener(al);
	}
	
	//methods that display warnings if the user does not correctly fill out the settings frame
	public void displayBGWarning() 
	{
		JOptionPane.showMessageDialog(null,"Please input a 6 character long string of an RGB value for the custom background color. (E.G. '00CCFF')");
	}
	public void displayFractWarning() 
	{
		JOptionPane.showMessageDialog(null,"Please input a 6 character long string of an RGB value for the custom fractal color. (E.G. '00CCFF')");
	}
	public void displayLineWarning() 
	{
		JOptionPane.showMessageDialog(null,"Please input an integer of '1' or higher. (E.G. '3')");
	}
	
	//methods that help change the panel look depending on if the user wants a custom fractal color
	public CardLayout getFract_Layout1()
	{
		return fractCustomColorCardLayout1;
	}
	public JPanel getFract_CardPanel1()
	{
		return fractCustomColorCardPanel1;
	}
	public void addFract_Color_Listener1(ActionListener al)
	{
		fractColorOptions1.addActionListener(al);
	}
	
	//getter and setter methods for fractal color options
	public String getFract1Color_Text()
	{
		return fractCustomColorTextField1.getText();
	}
	
	public void setFract1_Color(String s)
	{
		int r,g,b;
		r=Integer.decode("0x"+s.charAt(0)+""+s.charAt(1));
		g=Integer.decode("0x"+s.charAt(2)+""+s.charAt(3));
		b=Integer.decode("0x"+s.charAt(4)+""+s.charAt(5));
		
		fractColor1=new Color(r,g,b);
	}
	
	public void setAnimationOption1(boolean b)
	{
		isAnimation1=b;
	}
	
	public void addAnimationOptionListener1(ActionListener al)
	{
		animationOptions1.addActionListener(al);
	}
	
	public void addBack1Listener(ActionListener al)
	{
		back1.addActionListener(al);
	}
	public void disposeFract1()
	{
		fractSettings1.dispose();
	}

	public void addNext1Listener(ActionListener al)
	{
		next1.addActionListener(al);
	}
	
	
	public void createFractalSettings2() 
	{
		//a replica of the first fractal settings
		//user will choose a color and animation option for the second fractal to be drawn
		
		//create new JFrame
		fractSettings2=new JFrame("Second Fractal Settings");
		
		//creates a settings panel for the first fractal to edit color, etc.
		fractSettingsPanel2=new JPanel(new GridLayout(0,1));
		fractSettingsPanel2.setBackground(Color.LIGHT_GRAY);
		
		//create a label asking for a color of the first fractal
		fractColorLabel2=new JLabel("Choose a fractal color");
		fractColorLabel2.setFont(font);
		
		//add the fractal label to the main panel
		fractSettingsPanel2.add(fractColorLabel2);
		
		//create another panel to hold the user's fractal color options
		fractColorOuterPanel2=new JPanel(new GridLayout(1,2));
		
		//create a drop-down menu for the user's fractal color options
		String [] fractColorString2=new String[]{"Red","Orange","Yellow","Green","Blue","Purple","Rainbow","Custom"};
		fractColorOptions2=new JComboBox(fractColorString2);
		fractColorOptions2.setFont(font);
		
		//initialize colors to match initial settings
		fractColor2=Color.RED;
		isRainbowFract2=false;
		
		//add the drop-down menu to the outer fractal panel 
		fractColorOuterPanel2.add(fractColorOptions2);
		
		//add the outer panel to the first fractal settings panel
		fractSettingsPanel2.add(fractColorOuterPanel2);
		
		//create a blank panel to separate the color option from the animation option
		blankSeparatorPanel2_1=new JPanel();
		blankSeparatorPanel2_1.setBackground(Color.LIGHT_GRAY);
		
		//add the blank panel
		fractSettingsPanel2.add(blankSeparatorPanel2_1);
		
		//create a card panel like that of the background card panel
		fractCustomColorCardLayout2=new CardLayout();
		fractCustomColorCardPanel2=new JPanel(fractCustomColorCardLayout2);
		
		//this is a blank panel
		fractCustomColorSubPanel2_1=new JPanel();
		fractCustomColorSubPanel2_1.setBackground(Color.LIGHT_GRAY);
		
		//this is a textfield that appears if the user chooses 'Custom' from the drop-down menu
		fractCustomColorSubPanel2_2=new JPanel(new GridLayout(1,1));
		fractCustomColorTextField2=new JTextField("ffffff");
		fractCustomColorTextField2.setFont(font);
		fractCustomColorSubPanel2_2.add(fractCustomColorTextField2);
		
		//adds both the blank panel and the textfield to the card panel
		fractCustomColorCardPanel2.add(fractCustomColorSubPanel2_1,"1");
		fractCustomColorCardPanel2.add(fractCustomColorSubPanel2_2,"2");
		fractCustomColorCardLayout2.show(fractCustomColorCardPanel2, "1");
		
		//add the card panel to the outer panel
		fractColorOuterPanel2.add(fractCustomColorCardPanel2);
		
		//create a label asking if the fractal should be drawn in real time or drawn instantly
		fractAnimationLabel2=new JLabel("Do you want to see the fractal's drawing animation?");
		fractAnimationLabel2.setFont(font);
		
		//add the label to the fractal settings panel
		fractSettingsPanel2.add(fractAnimationLabel2);
		
		fractAnimationOuterPanel2=new JPanel(new GridLayout(1,2));
		
		//create animation option menu
		String[] animationString2=new String[]{"NO","YES"};
		animationOptions2=new JComboBox(animationString2);
		animationOptions2.setFont(font);
		
		//initialize option to match first menu item
		isAnimation2=false;
		
		//add animation option menu to outer animation panel
		fractAnimationOuterPanel2.add(animationOptions2);
		
		//create a blank panel to add in line with the options menu to keep formatting
		animationBlankPane2=new JPanel();
		animationBlankPane2.setBackground(Color.LIGHT_GRAY);
		
		//add blank panel to the outer animation panel
		fractAnimationOuterPanel2.add(animationBlankPane2);
		
		//add outer animation panel to fractal settings panel
		fractSettingsPanel2.add(fractAnimationOuterPanel2);
		
		//create a blank panel to separate the animation panel from the proceeding panel
		blankSeparatorPanel2_2=new JPanel();
		blankSeparatorPanel2_2.setBackground(Color.LIGHT_GRAY);
		
		//add the blank panel
		fractSettingsPanel2.add(blankSeparatorPanel2_2);
		
		//create a panel to hold next and back buttons.
		proceedingPanel2=new JPanel(new GridLayout(1,2));
		
		back2=new Button("Back");
		back2.setFont(font);
		
		//create a next button to check the user's settings and continue to the next frame
		next2=new Button("Next");
		next2.setFont(font);

		//add back and next to the proceeding panel
		proceedingPanel2.add(back2);
		proceedingPanel2.add(next2);
		
		//add the proceeding panel to the
		fractSettingsPanel2.add(proceedingPanel2);
		
		//add fractSettingsPane1 to the settings frame
		fractSettings2.add(fractSettingsPanel2);
		
		//set the frame to be visible
		fractSettings2.setVisible(true);
		fractSettings2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fractSettings2.pack();
		
		fractSettings1.setVisible(false);
	}
	
	public CardLayout getFract_Layout2()
	{
		return fractCustomColorCardLayout2;
	}
	public JPanel getFract_CardPanel2()
	{
		return fractCustomColorCardPanel2;
	}
	public void addFract_Color_Listener2(ActionListener al)
	{
		fractColorOptions2.addActionListener(al);
	}
	
	//getter and setter methods for fractal color options
	public String getFract2Color_Text()
	{
		return fractCustomColorTextField2.getText();
	}
	
	public void setFract2_Color(String s)
	{
		int r,g,b;
		r=Integer.decode("0x"+s.charAt(0)+""+s.charAt(1));
		g=Integer.decode("0x"+s.charAt(2)+""+s.charAt(3));
		b=Integer.decode("0x"+s.charAt(4)+""+s.charAt(5));
		
		fractColor2=new Color(r,g,b);
	}
	
	public void setAnimationOption2(boolean b)
	{
		isAnimation2=b;
	}
	
	public void addAnimationOptionListener2(ActionListener al)
	{
		animationOptions2.addActionListener(al);
	}
	
	public void addBack2Listener(ActionListener al)
	{
		back2.addActionListener(al);
	}
	
	public void addNext2Listener(ActionListener al)
	{
		next2.addActionListener(al);
	}
	
	public void disposeFract2()
	{
		fractSettings2.dispose();
	}
	
	public void createFractalSettings3() 
	{
		//create new JFrame
		fractSettings3=new JFrame("Third Fractal Settings");
		
		//creates a settings panel for the first fractal to edit color, etc.
		fractSettingsPanel3=new JPanel(new GridLayout(0,1));
		fractSettingsPanel3.setBackground(Color.LIGHT_GRAY);
		
		//create a label asking for a color of the first fractal
		fractColorLabel3=new JLabel("Choose a fractal color");
		fractColorLabel3.setFont(font);
		
		//add the fractal label to the main panel
		fractSettingsPanel3.add(fractColorLabel3);
		
		//create another panel to hold the user's fractal color options
		fractColorOuterPanel3=new JPanel(new GridLayout(1,2));
		
		//create a drop-down menu for the user's fractal color options
		String [] fractColorString3=new String[]{"Red","Orange","Yellow","Green","Blue","Purple","Rainbow","Custom"};
		fractColorOptions3=new JComboBox(fractColorString3);
		fractColorOptions3.setFont(font);
		
		//initialize colors to match initial settings
		fractColor3=Color.RED;
		isRainbowFract3=false;
		
		//add the drop-down menu to the outer fractal panel 
		fractColorOuterPanel3.add(fractColorOptions3);
		
		//add the outer panel to the first fractal settings panel
		fractSettingsPanel3.add(fractColorOuterPanel3);
		
		//create a blank panel to separate the color option from the animation option
		blankSeparatorPanel3_1=new JPanel();
		blankSeparatorPanel3_1.setBackground(Color.LIGHT_GRAY);
		
		//add the blank panel
		fractSettingsPanel3.add(blankSeparatorPanel3_1);
		
		//create a card panel like that of the background card panel
		fractCustomColorCardLayout3=new CardLayout();
		fractCustomColorCardPanel3=new JPanel(fractCustomColorCardLayout3);
		
		//this is a blank panel
		fractCustomColorSubPanel3_1=new JPanel();
		fractCustomColorSubPanel3_1.setBackground(Color.LIGHT_GRAY);
		
		//this is a textfield that appears if the user chooses 'Custom' from the drop-down menu
		fractCustomColorSubPanel3_2=new JPanel(new GridLayout(1,1));
		fractCustomColorTextField3=new JTextField("ffffff");
		fractCustomColorTextField3.setFont(font);
		fractCustomColorSubPanel3_2.add(fractCustomColorTextField3);
		
		//adds both the blank panel and the textfield to the card panel
		fractCustomColorCardPanel3.add(fractCustomColorSubPanel3_1,"1");
		fractCustomColorCardPanel3.add(fractCustomColorSubPanel3_2,"2");
		fractCustomColorCardLayout3.show(fractCustomColorCardPanel3, "1");
		
		//add the card panel to the outer panel
		fractColorOuterPanel3.add(fractCustomColorCardPanel3);
		
		//create a label asking if the fractal should be drawn in real time or drawn instantly
		fractAnimationLabel3=new JLabel("Do you want to see the fractal's drawing animation?");
		fractAnimationLabel3.setFont(font);
		
		//add the label to the fractal settings panel
		fractSettingsPanel3.add(fractAnimationLabel3);
		
		fractAnimationOuterPanel3=new JPanel(new GridLayout(1,2));
		
		//create animation option menu
		String[] animationString3=new String[]{"NO","YES"};
		animationOptions3=new JComboBox(animationString3);
		animationOptions3.setFont(font);
		
		//initialize option to match first menu item
		isAnimation3=false;
		
		//add animation option menu to outer animation panel
		fractAnimationOuterPanel3.add(animationOptions3);
		
		//create a blank panel to add in line with the options menu to keep formatting
		animationBlankPane3=new JPanel();
		animationBlankPane3.setBackground(Color.LIGHT_GRAY);
		
		//add blank panel to the outer animation panel
		fractAnimationOuterPanel3.add(animationBlankPane3);
		
		//add outer animation panel to fractal settings panel
		fractSettingsPanel3.add(fractAnimationOuterPanel3);
		
		//create a blank panel to separate the animation panel from the proceeding panel
		blankSeparatorPanel3_2=new JPanel();
		blankSeparatorPanel3_2.setBackground(Color.LIGHT_GRAY);
		
		//add the blank panel
		fractSettingsPanel3.add(blankSeparatorPanel3_2);
		
		//create a panel to hold next and back buttons.
		proceedingPanel3=new JPanel(new GridLayout(1,2));
		
		back3=new Button("Back");
		back3.setFont(font);
		
		//create a next button to check the user's settings and continue to the next frame
		next3=new Button("Next");
		next3.setFont(font);

		//add back and next to the proceeding panel
		proceedingPanel3.add(back3);
		proceedingPanel3.add(next3);
		
		//add the proceeding panel to the
		fractSettingsPanel3.add(proceedingPanel3);
		
		//add fractSettingsPane1 to the settings frame
		fractSettings3.add(fractSettingsPanel3);
		
		//set the frame to be visible
		fractSettings3.setVisible(true);
		fractSettings3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fractSettings3.pack();
		
		fractSettings2.setVisible(false);
	}
	
	public CardLayout getFract_Layout3()
	{
		return fractCustomColorCardLayout3;
	}
	public JPanel getFract_CardPanel3()
	{
		return fractCustomColorCardPanel3;
	}
	public void addFract_Color_Listener3(ActionListener al)
	{
		fractColorOptions3.addActionListener(al);
	}
	
	//getter and setter methods for fractal color options
	public String getFract3Color_Text()
	{
		return fractCustomColorTextField3.getText();
	}
	
	public void setFract3_Color(String s)
	{
		int r,g,b;
		r=Integer.decode("0x"+s.charAt(0)+""+s.charAt(1));
		g=Integer.decode("0x"+s.charAt(2)+""+s.charAt(3));
		b=Integer.decode("0x"+s.charAt(4)+""+s.charAt(5));
		
		fractColor3=new Color(r,g,b);
	}
	
	public void setAnimationOption3(boolean b)
	{
		isAnimation3=b;
	}
	
	public void addAnimationOptionListener3(ActionListener al)
	{
		animationOptions3.addActionListener(al);
	}
	
	public void addBack3Listener(ActionListener al)
	{
		back3.addActionListener(al);
	}
	
	public void addNext3Listener(ActionListener al)
	{
		next3.addActionListener(al);
	}
	
	public void disposeFract3()
	{
		fractSettings3.dispose();
	}
	
	public void createFractalSettings4() 
	{
		//create new JFrame
		fractSettings4=new JFrame("Fourth Fractal Settings");
		
		//creates a settings panel for the first fractal to edit color, etc.
		fractSettingsPanel4=new JPanel(new GridLayout(0,1));
		fractSettingsPanel4.setBackground(Color.LIGHT_GRAY);
		
		//create a label asking for a color of the first fractal
		fractColorLabel4=new JLabel("Choose a fractal color");
		fractColorLabel4.setFont(font);
		
		//add the fractal label to the main panel
		fractSettingsPanel4.add(fractColorLabel4);
		
		//create another panel to hold the user's fractal color options
		fractColorOuterPanel4=new JPanel(new GridLayout(1,2));
		
		//create a drop-down menu for the user's fractal color options
		String [] fractColorString4=new String[]{"Red","Orange","Yellow","Green","Blue","Purple","Rainbow","Custom"};
		fractColorOptions4=new JComboBox(fractColorString4);
		fractColorOptions4.setFont(font);
		
		//initialize colors to match initial settings
		fractColor4=Color.RED;
		isRainbowFract4=false;
		
		//add the drop-down menu to the outer fractal panel 
		fractColorOuterPanel4.add(fractColorOptions4);
		
		//add the outer panel to the first fractal settings panel
		fractSettingsPanel4.add(fractColorOuterPanel4);
		
		//create a blank panel to separate the color option from the animation option
		blankSeparatorPanel4_1=new JPanel();
		blankSeparatorPanel4_1.setBackground(Color.LIGHT_GRAY);
		
		//add the blank panel
		fractSettingsPanel4.add(blankSeparatorPanel4_1);
		
		//create a card panel like that of the background card panel
		fractCustomColorCardLayout4=new CardLayout();
		fractCustomColorCardPanel4=new JPanel(fractCustomColorCardLayout4);
		
		//this is a blank panel
		fractCustomColorSubPanel4_1=new JPanel();
		fractCustomColorSubPanel4_1.setBackground(Color.LIGHT_GRAY);
		
		//this is a textfield that appears if the user chooses 'Custom' from the drop-down menu
		fractCustomColorSubPanel4_2=new JPanel(new GridLayout(1,1));
		fractCustomColorTextField4=new JTextField("ffffff");
		fractCustomColorTextField4.setFont(font);
		fractCustomColorSubPanel4_2.add(fractCustomColorTextField4);
		
		//adds both the blank panel and the textfield to the card panel
		fractCustomColorCardPanel4.add(fractCustomColorSubPanel4_1,"1");
		fractCustomColorCardPanel4.add(fractCustomColorSubPanel4_2,"2");
		fractCustomColorCardLayout4.show(fractCustomColorCardPanel4, "1");
		
		//add the card panel to the outer panel
		fractColorOuterPanel4.add(fractCustomColorCardPanel4);
		
		//create a label asking if the fractal should be drawn in real time or drawn instantly
		fractAnimationLabel4=new JLabel("Do you want to see the fractal's drawing animation?");
		fractAnimationLabel4.setFont(font);
		
		//add the label to the fractal settings panel
		fractSettingsPanel4.add(fractAnimationLabel3);
		
		fractAnimationOuterPanel4=new JPanel(new GridLayout(1,2));
		
		//create animation option menu
		String[] animationString4=new String[]{"NO","YES"};
		animationOptions4=new JComboBox(animationString4);
		animationOptions4.setFont(font);
		
		//initialize option to match first menu item
		isAnimation4=false;
		
		//add animation option menu to outer animation panel
		fractAnimationOuterPanel4.add(animationOptions4);
		
		//create a blank panel to add in line with the options menu to keep formatting
		animationBlankPane4=new JPanel();
		animationBlankPane4.setBackground(Color.LIGHT_GRAY);
		
		//add blank panel to the outer animation panel
		fractAnimationOuterPanel4.add(animationBlankPane4);
		
		//add outer animation panel to fractal settings panel
		fractSettingsPanel4.add(fractAnimationOuterPanel4);
		
		//create a blank panel to separate the animation panel from the proceeding panel
		blankSeparatorPanel4_2=new JPanel();
		blankSeparatorPanel4_2.setBackground(Color.LIGHT_GRAY);
		
		//add the blank panel
		fractSettingsPanel4.add(blankSeparatorPanel4_2);
		
		//create a panel to hold next and back buttons.
		proceedingPanel4=new JPanel(new GridLayout(1,2));
		
		back4=new Button("Back");
		back4.setFont(font);
		
		//create a next button to check the user's settings and continue to the next frame
		next4=new Button("Next");
		next4.setFont(font);

		//add back and next to the proceeding panel
		proceedingPanel4.add(back4);
		proceedingPanel4.add(next4);
		
		//add the proceeding panel to the
		fractSettingsPanel4.add(proceedingPanel4);
		
		//add fractSettingsPane1 to the settings frame
		fractSettings4.add(fractSettingsPanel4);
		
		//set the frame to be visible
		fractSettings4.setVisible(true);
		fractSettings4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fractSettings4.pack();
		
		fractSettings3.setVisible(false);
	}
	
	public CardLayout getFract_Layout4()
	{
		return fractCustomColorCardLayout4;
	}
	public JPanel getFract_CardPanel4()
	{
		return fractCustomColorCardPanel4;
	}
	public void addFract_Color_Listener4(ActionListener al)
	{
		fractColorOptions4.addActionListener(al);
	}
	
	//getter and setter methods for fractal color options
	public String getFract4Color_Text()
	{
		return fractCustomColorTextField4.getText();
	}
	
	public void setFract4_Color(String s)
	{
		int r,g,b;
		r=Integer.decode("0x"+s.charAt(0)+""+s.charAt(1));
		g=Integer.decode("0x"+s.charAt(2)+""+s.charAt(3));
		b=Integer.decode("0x"+s.charAt(4)+""+s.charAt(5));
		
		fractColor4=new Color(r,g,b);
	}
	
	public void setAnimationOption4(boolean b)
	{
		isAnimation4=b;
	}
	
	public void addAnimationOptionListener4(ActionListener al)
	{
		animationOptions4.addActionListener(al);
	}
	
	public void addBack4Listener(ActionListener al)
	{
		back4.addActionListener(al);
	}
	
	public void addNext4Listener(ActionListener al)
	{
		next4.addActionListener(al);
	}
	
	public void disposeFract4()
	{
		fractSettings4.dispose();
	}
	
	

	//creates the graphics panel for drawing the fractal
	public void createDrawingPanel()
	{
		canvas=new JFrame("Drawing");
		canvas.setSize(width, height);
		drawing=new GUIPanel(getBG_Color());
		canvas.add(drawing);
		canvas.setVisible(true);
	}
	
	//add a window listener to the canvas to help close the window while graphics are still working
	public void addDrawingWindowListener(WindowListener wl)
	{
		canvas.addWindowListener(wl);
	}
	//sets the fractal array so the paint method has all the points to draw from
	public void setFractArray1(ArrayList<Integer> arr)
	{
		fractArray1=arr;
	}
	public void setFractArray2(ArrayList<Integer> arr2) 
	{
		fractArray2=arr2;
	}
	public void setFractArray3(ArrayList<Integer> arr3) 
	{
		fractArray3=arr3;
	}
	public void setFractArray4(ArrayList<Integer> arr4) 
	{
		fractArray4=arr4;
	}
	
	
	//class that creates a custom panel with graphics
	static class GUIPanel extends JPanel implements ActionListener
	{
		private Color bg,fract1,fract2,fract3,fract4;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		BufferedImage buffer;
		Timer t=new Timer(0, this);
		int index1,index2,index3,index4;
		boolean isStarted;
		Graphics g;
		private GUIPanel(Color bgColor)
		{
			isStarted=false;
			isDrawn1=false;
			isDrawn2=false;
			isDrawn3=false;
			isDrawn4=false;
			index1=0;
			index2=0;
			index3=0;
			index4=0;
			bg=bgColor;
			setBackground(bg);
			
			fract1=fractColor1;
			if(numColors>=2)
			{
				fract2=fractColor2;
			}
			if(numColors>=3)
			{
				fract3=fractColor3;
			}
			if(numColors==4)
			{
				fract4=fractColor4;
			}
			buffer=new BufferedImage(screenSize.width, screenSize.height, BufferedImage.TYPE_INT_ARGB);
			g=buffer.getGraphics();
		}
		
		@Override
		public void paint(Graphics g2)
		{
			super.paint(g2);
			
			if(!isAnimation1 && !isDrawn1)
			{
				if(isRainbowFract1)
				{
					for(int i=0;i<fractArray1.size()-2;i+=2)
					{
						g.setColor(RainbowArray[rainbowIndex1]);
						g.drawLine(fractArray1.get(i), fractArray1.get(i+1), fractArray1.get(i+2), fractArray1.get(i+3));
						//4 is a color modifier to make it more or less random 
						if(rainbowIndex1<359 && i%4==0)
						{
							rainbowIndex1++;
						}
						else if(rainbowIndex1>=359)
						{
							rainbowIndex1=0;
						}
					}
				}
				else
				{
					g.setColor(fract1);
					for(int i=0;i<fractArray1.size()-2;i+=2)
					{
						g.drawLine(fractArray1.get(i), fractArray1.get(i+1), fractArray1.get(i+2), fractArray1.get(i+3));
					}
				}
				isDrawn1=true;
			}
			
			if(!isAnimation2 && numColors>=2 && !isDrawn2)
			{
				if(isRainbowFract2)
				{
					for(int i=0;i<fractArray2.size()-2;i+=2)
					{
						g.setColor(RainbowArray[rainbowIndex2]);
						g.drawLine(fractArray2.get(i), fractArray2.get(i+1), fractArray2.get(i+2), fractArray2.get(i+3));
						//4 is a color modifier to make it more or less random 
						if(rainbowIndex2<359 && i%4==0)
						{
							rainbowIndex2++;
						}
						else if(rainbowIndex2>=359)
						{
							rainbowIndex2=0;
						}
					}
				}
				else
				{
					g.setColor(fract2);
					for(int i=0;i<fractArray2.size()-2;i+=2)
					{
						g.drawLine(fractArray2.get(i), fractArray2.get(i+1), fractArray2.get(i+2), fractArray2.get(i+3));
					}
				}
				isDrawn2=true;
			}
			
			if(!isAnimation3 && numColors>=3 && !isDrawn3)
			{
				if(isRainbowFract3)
				{
					for(int i=0;i<fractArray3.size()-2;i+=2)
					{
						g.setColor(RainbowArray[rainbowIndex3]);
						g.drawLine(fractArray3.get(i), fractArray3.get(i+1), fractArray3.get(i+2), fractArray3.get(i+3));
						//4 is a color modifier to make it more or less random 
						if(rainbowIndex3<359 && i%4==0)
						{
							rainbowIndex3++;
						}
						else if(rainbowIndex3>=359)
						{
							rainbowIndex3=0;
						}
					}
				}
				else
				{
					g.setColor(fract3);
					for(int i=0;i<fractArray3.size()-2;i+=2)
					{
						g.drawLine(fractArray3.get(i), fractArray3.get(i+1), fractArray3.get(i+2), fractArray3.get(i+3));
					}
				}
				isDrawn3=true;
			}
			
			if(!isAnimation4 && numColors==4 && !isDrawn4)
			{
				if(isRainbowFract4)
				{
					for(int i=0;i<fractArray4.size()-2;i+=2)
					{
						g.setColor(RainbowArray[rainbowIndex4]);
						g.drawLine(fractArray4.get(i), fractArray4.get(i+1), fractArray4.get(i+2), fractArray4.get(i+3));
						//4 is a color modifier to make it more or less random 
						if(rainbowIndex4<359 && i%4==0)
						{
							rainbowIndex4++;
						}
						else if(rainbowIndex4>=359)
						{
							rainbowIndex4=0;
						}
					}
				}
				else
				{
					g.setColor(fract4);
					for(int i=0;i<fractArray4.size()-2;i+=2)
					{
						g.drawLine(fractArray4.get(i), fractArray4.get(i+1), fractArray4.get(i+2), fractArray4.get(i+3));
					}
				}
				isDrawn4=true;
			}
			
			//etc etc etc add others
			if(!isStarted)
			{
				t.start();	
			}
			g2.drawImage(buffer,0,0,this);
		}	

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			nextLine(buffer.getGraphics());
		}

		private void nextLine(Graphics g) 
		{
			
			if(isAnimation1)
			{
				if(index1<fractArray1.size()-2)
				{
					if(isRainbowFract1)
					{
						g.setColor(RainbowArray[rainbowIndex1]);
						g.drawLine(fractArray1.get(index1), fractArray1.get(index1+1), fractArray1.get(index1+2), fractArray1.get(index1+3));
						index1+=2;
						if(rainbowIndex1<359 && index1%12==0)
						{
							rainbowIndex1++;
						}
						else if(rainbowIndex1>=359)
						{
							rainbowIndex1=0;
						}
					}
					else
					{
						g.setColor(fractColor1);
						g.drawLine(fractArray1.get(index1), fractArray1.get(index1+1), fractArray1.get(index1+2), fractArray1.get(index1+3));
						index1+=2;
					}
				}
				else
				{
					t.stop();
					index1=0;
				}
			}
			
			if(isAnimation2 && numColors>=2)
			{
				if(index2<fractArray2.size()-2)
				{
					if(isRainbowFract2)
					{
						g.setColor(RainbowArray[rainbowIndex2]);
						g.drawLine(fractArray2.get(index2), fractArray2.get(index2+1), fractArray2.get(index2+2), fractArray2.get(index2+3));
						index2+=2;
						if(rainbowIndex2<359 && index2%12==0)
						{
							rainbowIndex2++;
						}
						else if(rainbowIndex2>=359)
						{
							rainbowIndex2=0;
						}
					}
					else
					{
						g.setColor(fractColor2);
						g.drawLine(fractArray2.get(index2), fractArray2.get(index2+1), fractArray2.get(index2+2), fractArray2.get(index2+3));
						index2+=2;
					}
					
				}
				else
				{
					t.stop();
					index2=0;
				}
			}
			
			if(isAnimation3 && numColors>=3)
			{
				if(index3<fractArray3.size()-2)
				{
					if(isRainbowFract3)
					{
						g.setColor(RainbowArray[rainbowIndex3]);
						g.drawLine(fractArray3.get(index3), fractArray3.get(index3+1), fractArray3.get(index3+2), fractArray3.get(index3+3));
						index3+=2;
						if(rainbowIndex3<359 && index3%12==0)
						{
							rainbowIndex3++;
						}
						else if(rainbowIndex3>=359)
						{
							rainbowIndex3=0;
						}
					}
					else
					{
						g.setColor(fractColor3);
						g.drawLine(fractArray3.get(index3), fractArray3.get(index3+1), fractArray3.get(index3+2), fractArray3.get(index3+3));
						index3+=2;
					}
					
				}
				else
				{
					t.stop();
					index3=0;
				}
			}
			
			if(isAnimation4 && numColors==4)
			{
				if(index4<fractArray4.size()-2)
				{
					if(isRainbowFract4)
					{
						g.setColor(RainbowArray[rainbowIndex4]);
						g.drawLine(fractArray4.get(index4), fractArray4.get(index4+1), fractArray4.get(index4+2), fractArray4.get(index4+3));
						index4+=2;
						if(rainbowIndex4<359 && index4%12==0)
						{
							rainbowIndex4++;
						}
						else if(rainbowIndex4>=359)
						{
							rainbowIndex4=0;
						}
					}
					else
					{
						g.setColor(fract4);
						g.drawLine(fractArray4.get(index4), fractArray4.get(index4+1), fractArray4.get(index4+2), fractArray4.get(index4+3));
						index4+=2;
					}
					
				}
				else
				{
					t.stop();
					index4=0;
				}
			}
			
			repaint();
		}
	}
	
	public void disposeDrawing() 
	{
		canvas.dispose();
		settings.setVisible(true);
	}

	public void setFractColorArray(Color[] rainbow) 
	{
		RainbowArray=rainbow;
	}

	public void setRainbowBool1(boolean b) 
	{
		isRainbowFract1=b;
	}

	public void setRainbowBool2(boolean b) 
	{
		isRainbowFract2=b;
	}
	public void setRainbowBool3(boolean b) 
	{
		isRainbowFract3=b;
	}
	public void setRainbowBool4(boolean b) 
	{
		isRainbowFract4=b;
	}
	public void setNumColors(int i) 
	{
		numColors=i;
	}

	

	

	

	

	

	
	
}
