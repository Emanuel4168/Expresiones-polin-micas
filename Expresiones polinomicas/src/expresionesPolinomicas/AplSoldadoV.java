package expresionesPolinomicas;

public class AplSoldadoV {
	
	private static class Soldado
	{
		public int nSoldado, edad;
		
		public Soldado(int nSol, int edad)
		{
			this.nSoldado = nSol;
			this.edad=edad;
		}
		
		
	}
	
	private AplSoldadoV()
	{
		Lista<Soldado> soldados = new Lista();
		
		llenarLista(soldados);
		imprimirLista(soldados);
		int soldadoSalvado,totalSoldados,soldadoAnterior=0,suma=0,cont = 0;
		
		while(soldados.Length() > 1)
		{
			totalSoldados = soldados.Length();
			soldadoSalvado = Rutinas.nextInt(1,10) ;
			System.out.println("Selección: "+soldadoSalvado);
			if(totalSoldados >= soldadoSalvado+soldadoAnterior)
			{
				suma = soldadoSalvado + soldadoAnterior;
				soldados.Retira(suma);
			}
			else
			{
				suma = (soldadoSalvado % totalSoldados == 0)? totalSoldados:soldadoSalvado % totalSoldados;
				soldados.Retira(suma + soldadoAnterior);
			}
			System.out.println("Soldado "+soldados.Dr.nSoldado+" salvado");
			soldadoAnterior = suma;
			cont ++;
		}
		
		System.out.println("El soldado a realizar la misión es el soldado número: "+soldados.getFrente().Info.nSoldado);
		
	}

	public static void main(String[] args) 
	{
		AplSoldadoV a = new AplSoldadoV();
	}

	
	private  void llenarLista(Lista<Soldado> L)
	{
		int totalS = 5;//Rutinas.nextInt(20,50);
		for(byte i = 0; i < totalS; i++ )
		{
			L.InsertaFin(new Soldado(Rutinas.nextInt(1,10000),Rutinas.nextInt(18,25)));
		}
	}
	
	private void imprimirLista(Lista<Soldado> l)
	{
		if(l.getFrente() == null)
			return;
		Nodo<Soldado> it = l.getFrente();
		while(it != null)
		{
			System.out.println("Soldado n°: "+it.Info.nSoldado+"\t");
			it = it.getSig();
		}
	}
}
