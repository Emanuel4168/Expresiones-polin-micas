package expresionesPolinomicas;

import java.util.Scanner;

public class AplSumaPol 
{
	private static class Termino 
	{
		public int base,potencia;
		
		public Termino(int base, int potencia)
		{
			this.base = base;
			this.potencia = potencia;
		}
		
		public String toString()
		{
			return Rutinas.PonCeros(this.potencia, 10);
		}
	}

	
	private AplSumaPol()
	{
		Lista<Termino> polinomio1 = new Lista();
		Lista<Termino> polinomio2 = new Lista();
		Lista<Termino> suma = new Lista();
		
		System.out.println("\tllenando lista 1");
		leerPolinomio(polinomio1);
		System.out.println("\tllenando lista 2");
		leerPolinomio(polinomio2);
		
		Nodo<Termino> itP1 = polinomio1.getFrente();
		Nodo<Termino> itP2 = polinomio2.getFrente();
		
		while(itP1 != null)
		{
			suma.insertaOrdenado(new Termino(itP1.Info.base, itP1.Info.potencia));
			itP1 = itP1.getSig();
		}
		
		while(itP2 != null)
		{
			if (!buscarTermino(suma,itP2.Info))
				suma.insertaOrdenado(itP2.Info);
			itP2 = itP2.getSig();
		}
		
		Nodo<Termino> itSuma = suma.getFrente();
		while(itSuma != null)
		{
			Termino termino = itSuma.Info;
			if(termino.base>0)
				System.out.print("+"+termino.base+"X^"+termino.potencia);
			else
				System.out.print(termino.base+"X^"+termino.potencia);
			itSuma=itSuma.getSig();
		}
	}
	
	public static void main(String[] args) 
	{
		AplSumaPol a = new AplSumaPol();
	}
	
	
	//métodos auxiliares
	public void leerPolinomio(Lista<Termino> lista)
	{
		Scanner scan = new Scanner(System.in);
		int base,pot;
		while(true)
		{
			System.out.println("Ingrese base del polinómio o (0) para terminar la captura");
			base = scan.nextInt();
			if (base == 0)
				return;
			System.out.println("Ingrese potencia del polinómio");
			pot = scan.nextInt();
			
			Termino t = new Termino(base,pot);
			if(!buscarTermino(lista,t))
				lista.InsertaFin(t);
		}
	}
	
	
	public boolean buscarTermino(Lista<Termino> lista, Termino t)
	{
		if(lista.getFrente() == null)
			return false;
		Nodo<Termino> it = lista.getFrente();
		while(it != null && it.Info.potencia <= t.potencia)
		{
			if(it.Info.potencia == t.potencia)
			{
				it.Info.base += t.base;
				return true;
			}
			it = it.getSig();
		}
		return false;
	}
	
	/*public boolean buscarTermino(Lista<Termino> lista, Termino t)
	{
		int centro,inicio=0,fin = lista.Length();
		while(inicio <= fin)
		{
			centro = ((fin - inicio)/2)+inicio;
			lista.Retira(centro);
			if(lista.Dr.potencia == t.potencia)
			{
				lista.Dr.base += t.base;
				return true;
			}
			if(lista.Dr.potencia < t.potencia)
				fin = centro-1;
			if(lista.Dr.potencia > t.potencia)
				inicio = centro+1;
			lista.insertaOrdenado(lista.Dr);
		}
		
		return false;
	}*/

}
