public class liskov{
 class Kacsa
{
	public void repul()
	{
		System.out.print("Repulok");
		System.out.print("\n");
	}
}

 class Program
{
	public void fgv(Kacsa kacsa)
	{
		kacsa.repul();
	}
}

 class JatekKacsa extends Kacsa
{}



public static void main(String[] args)
{
	Liskov lis = new Liskov();
	

	Program program = lis.new Program();
	Kacsa kacsa = lis.new Kacsa();
	program.fgv(kacsa);
	
        JatekKacsa jatek_kacsa = lis.new JatekKacsa();
	program.fgv(jatek_kacsa);
	}
}
