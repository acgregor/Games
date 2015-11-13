package contents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
/**
 * 
 * @author Austen Gregor
 * 
 * Created 09/4/2015
 */
public class FractalModel
{
	private boolean bgWarning,fractWarning,lineWarning;
	private ArrayList<Integer> arr1,arr2,arr3,arr4;
	private int lineLength;
	private Color[] spectrum;
	private final int numLines=2000000;
	
	public FractalModel()
	{
		//all warnings are initialized to false and will be set to true if the user inputs invalid values
		bgWarning=false;
		fractWarning=false;
		lineWarning=false;		
	}
	
	//creates an array with an initial line starting from the center and proceeding right
	public void setupArray1() 
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		arr1=new ArrayList<Integer>();
		arr1.add(screenSize.width/2);
		arr1.add(screenSize.height/2);
		arr1.add(arr1.get(0)+lineLength);
		arr1.add(arr1.get(1));		
	}
	
	//creates an array with an initial line starting from the center and proceeding left
	public void setupArray2() 
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		arr2=new ArrayList<Integer>();
		arr2.add(screenSize.width/2);
		arr2.add(screenSize.height/2);
		arr2.add(arr2.get(0)-lineLength);
		arr2.add(arr2.get(1));		
	}
	
	//creates an array with an initial line starting from the center and proceeding up
	public void setupArray3() 
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		arr3=new ArrayList<Integer>();
		arr3.add(screenSize.width/2);
		arr3.add(screenSize.height/2);
		arr3.add(arr3.get(0));
		arr3.add(arr3.get(1)-lineLength);		
	}
	
	//creates an array with an initial line starting from the center and proceeding down
	public void setupArray4() 
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		arr4=new ArrayList<Integer>();
		arr4.add(screenSize.width/2);
		arr4.add(screenSize.height/2);
		arr4.add(arr4.get(0));
		arr4.add(arr4.get(1)+lineLength);		
	}
	
	//calculates the coordinates for the entire fractal for array 1
	public void CalculateArray1() 
	{
		while(arr1.size()<numLines)
		{
			int size=arr1.size();
			int pivotX1=arr1.get(arr1.size()-2);
			int pivotY1=arr1.get(arr1.size()-1);
			for(int i=size-3;i>=0;i-=2)
			{
				int y1=arr1.get(i);
				int x1=arr1.get(i-1);
				x1=x1-pivotX1;
				y1=y1-pivotY1;
				int temp=x1;
				x1=y1;
				y1=-temp;
				x1=x1+pivotX1;
				y1=y1+pivotY1;
				arr1.add(x1);
				arr1.add(y1);
			}
		}
	}
	
	//calculates the coordinates for the entire fractal for array 2
	public void CalculateArray2() 
	{
		while(arr2.size()<numLines)
		{
			int size=arr2.size();
			int pivotX1=arr2.get(arr2.size()-2);
			int pivotY1=arr2.get(arr2.size()-1);
			for(int i=size-3;i>=0;i-=2)
			{
				int y1=arr2.get(i);
				int x1=arr2.get(i-1);
				x1=x1-pivotX1;
				y1=y1-pivotY1;
				int temp=x1;
				x1=y1;
				y1=-temp;
				x1=x1+pivotX1;
				y1=y1+pivotY1;
				arr2.add(x1);
				arr2.add(y1);
			}
		}
	}
	
	//calculates the coordinates for the entire fractal for array 3
	public void CalculateArray3() 
	{
		while(arr3.size()<numLines)
		{
			int size=arr3.size();
			int pivotX1=arr3.get(arr3.size()-2);
			int pivotY1=arr3.get(arr3.size()-1);
			for(int i=size-3;i>=0;i-=2)
			{
				int y1=arr3.get(i);
				int x1=arr3.get(i-1);
				x1=x1-pivotX1;
				y1=y1-pivotY1;
				int temp=x1;
				x1=y1;
				y1=-temp;
				x1=x1+pivotX1;
				y1=y1+pivotY1;
				arr3.add(x1);
				arr3.add(y1);
			}
		}
	}
	
	//calculates the coordinates for the entire fractal for array 4
	public void CalculateArray4() 
	{
		while(arr4.size()<numLines)
		{
			int size=arr4.size();
			int pivotX1=arr4.get(arr4.size()-2);
			int pivotY1=arr4.get(arr4.size()-1);
			for(int i=size-3;i>=0;i-=2)
			{
				int y1=arr4.get(i);
				int x1=arr4.get(i-1);
				x1=x1-pivotX1;
				y1=y1-pivotY1;
				int temp=x1;
				x1=y1;
				y1=-temp;
				x1=x1+pivotX1;
				y1=y1+pivotY1;
				arr4.add(x1);
				arr4.add(y1);
			}
		}
	}
	
	//getter methods to return the complete calculated arrays
	public ArrayList<Integer> getArray1()
	{
		return arr1;
	}
	public ArrayList<Integer> getArray2()
	{
		return arr2;
	}
	public ArrayList<Integer> getArray3()
	{
		return arr3;
	}
	public ArrayList<Integer> getArray4()
	{
		return arr4;
	}
	
	//sets the line length for each line in the fractal based on user input
	public void setLineLength(int length)
	{
		lineLength=length;
	}

	//checks for valid input if the user chooses a custom background color
	//a custom color must be 6 characters long and must be a hex character
	public void checkBackgroundOptions(String bgText) 
	{
		if(bgText.length()==6)
		{
			for(int i=0;i<6;i++)
			{
				if(bgText.charAt(i)!='0' &&
					bgText.charAt(i)!='1' &&
					bgText.charAt(i)!='2' &&
					bgText.charAt(i)!='3' &&
					bgText.charAt(i)!='4' &&
					bgText.charAt(i)!='5' &&
					bgText.charAt(i)!='6' &&
					bgText.charAt(i)!='7' &&
					bgText.charAt(i)!='8' &&
					bgText.charAt(i)!='9' &&
					bgText.charAt(i)!='a' &&
					bgText.charAt(i)!='b' &&
					bgText.charAt(i)!='c' &&
					bgText.charAt(i)!='d' &&
					bgText.charAt(i)!='e' &&
					bgText.charAt(i)!='f' &&
					bgText.charAt(i)!='A' &&
					bgText.charAt(i)!='B' &&
					bgText.charAt(i)!='C' &&
					bgText.charAt(i)!='D' &&
					bgText.charAt(i)!='E' &&
					bgText.charAt(i)!='F')
				{
					bgWarning=true;
				}
				else
				{
					bgWarning=false;
				}
			}
		}
		else
		{
			bgWarning=true;
		}
	}

	//a getter method for the controller to use
	//asks the model what the background warning status is
	public boolean isBackgroundWarnings() 
	{
		return bgWarning;
	}

	//checks for valid input if the user chooses a custom fractal color
	//a custom color must be 6 characters long and must be a hex character
	public void checkFractalOptions(String fractText) 
	{
		if(fractText.length()==6)
		{
			for(int i=0;i<6;i++)
			{
				if(fractText.charAt(i)!='0' &&
					fractText.charAt(i)!='1' &&
					fractText.charAt(i)!='2' &&
					fractText.charAt(i)!='3' &&
					fractText.charAt(i)!='4' &&
					fractText.charAt(i)!='5' &&
					fractText.charAt(i)!='6' &&
					fractText.charAt(i)!='7' &&
					fractText.charAt(i)!='8' &&
					fractText.charAt(i)!='9' &&
					fractText.charAt(i)!='a' &&
					fractText.charAt(i)!='b' &&
					fractText.charAt(i)!='c' &&
					fractText.charAt(i)!='d' &&
					fractText.charAt(i)!='e' &&
					fractText.charAt(i)!='f' &&
					fractText.charAt(i)!='A' &&
					fractText.charAt(i)!='B' &&
					fractText.charAt(i)!='C' &&
					fractText.charAt(i)!='D' &&
					fractText.charAt(i)!='E' &&
					fractText.charAt(i)!='F')
				{
					fractWarning=true;
				}
				else
				{
					fractWarning=false;
				}
			}
		}
		else
		{
			fractWarning=true;
		}
	}

	//a getter method for the controller to use to see if there there are any fractal warnings
	public boolean isFractalWarnings() 
	{
		return fractWarning;
	}

	//checks for valid input when the user chooses a line length
	//lengths must be an integer of 1 or higher
	public void checkLineLengthOptions(String lineNumber) 
	{
		if(lineNumber.length()<4)
		{
			for(int i=0;i<lineNumber.length();i++)
			{
				if(lineNumber.charAt(i)!='0' &&
					lineNumber.charAt(i)!='1' &&
					lineNumber.charAt(i)!='2' &&
					lineNumber.charAt(i)!='3' &&
					lineNumber.charAt(i)!='4' &&
					lineNumber.charAt(i)!='5' &&
					lineNumber.charAt(i)!='6' &&
					lineNumber.charAt(i)!='7' &&
					lineNumber.charAt(i)!='8' &&
					lineNumber.charAt(i)!='9')
				{
					lineWarning=true;
				}
				else
				{
					lineWarning=false;
					lineLength=Integer.parseInt(lineNumber);
					
					//if the user inputs zero as the line length then throw aa warning
					if(lineLength==0)
					{
						lineWarning=true;
					}
				}
			}
		}
		else
		{
			lineWarning=true;
		}
	}

	//a getter method for the controller to use to check if there is a warning to display regarding line length
	public boolean isLineLengthWarnings() 
	{
		return lineWarning;
	}

	//resets all warnings to false
	public void resetWarnings() 
	{
		bgWarning=false;
		fractWarning=false;
		lineWarning=false;
	}

	//creates a color array starting with red and slowly changes to purple
	public void createRainbow() 
	{
		spectrum=new Color[360];
		for(int i=0;i<60;i++)
		{
			spectrum[i]=new Color((float)1.0,(float)(i/60.0),(float)0.0);
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+60]=new Color((float)((60-i)/60.0),(float)1.0,(float)0.0);
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+120]=new Color((float)0.0,(float)1.0,(float)(i/60.0));
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+180]=new Color((float)0.0,(float)((60-i)/60.0),(float)1.0);
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+240]=new Color((float)(i/60.0),(float)0.0,(float)1.0);
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+300]=new Color((float)1.0,(float)0.0,(float)((60-i)/60.0));
		}
	}
	
	//gets the color array
	public Color[] getRainbow()
	{
		return spectrum;
	}

	

	
}
