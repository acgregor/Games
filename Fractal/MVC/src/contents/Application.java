package contents;

public class Application
{
	public static void main(String[] args)
	{
		Model model=new Model();
		View view=new View(model);
		Control ctrl=new Control(model,view);
		view.setVisible(true);
	}
}
