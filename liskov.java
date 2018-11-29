// ez a T az LSP-ben
public class Madar
{
	 public void repul()
	 {
	 }
}

// ez a két osztály alkotja a "P programot" az LPS-ben
public class Program
{
	 public final void fgv(Madar madar)
	 {
		  madar.repul();
	 }
}

// itt jönnek az LSP-s S osztályok
public class Sas extends Madar
{
}

public class Pingvin extends Madar // ezt úgy is lehet/kell olvasni, hogy a pingvin tud repülni
{
}

package <missing>;

public class GlobalMembers
{
	public static void Main(String[] args)
	{
		 Program program = new Program();
		 Madar madar = new Madar();
		 program.fgv(madar);

		 Sas sas = new Sas();
		 program.fgv(sas);

		 Pingvin pingvin = new Pingvin();
		 program.fgv(pingvin); // sérül az LSP, mert a P::fgv röptetné a Pingvint, ami ugye lehetetlen.

	}
}

