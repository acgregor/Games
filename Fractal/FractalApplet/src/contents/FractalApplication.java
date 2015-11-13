package contents;
/**
 * 
 * @author Austen Gregor
 * 
 * Created 09/4/2015
 */
public class FractalApplication
{

	public static void main(String[] args)
	{
		FractalView v=new FractalView();
		FractalModel m=new FractalModel();
		FractalController c=new FractalController(m,v);
	}

}
