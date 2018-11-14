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
		
		public String toString() {
			return Rutinas.PonCeros(this.nSoldado, 5);
		}
		
	}
	
	private AplSoldadoV()
	{
		Lista<Soldado> soldados = new Lista();
		
		llenarLista(soldados);
		imprimirLista(soldados);
		int soldadoSalvado,soldadoAnterior=1;
		byte i;
		Nodo<Soldado> it  = soldados.getFrente();
		
		while(soldados.Length() > 1)
		{
			soldadoSalvado = Rutinas.nextInt(1,10);
		    System.out.println("Selesción:  "+soldadoSalvado);
			for(i =1; i<soldadoSalvado; i++ )
			{
				it = it.getSig();
				if(it == null)
					it= soldados.getFrente();
			}
			soldados.Retira(it.Info);
			System.out.println("Soldado: "+soldados.Dr.nSoldado+" Salvado");
			System.out.println("Soldados: "+soldados.Length());
			soldadoAnterior = i;
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
	
	
	
	
/*
 * totalSoldados = soldados.Length();
			soldadoSalvado = Rutinas.nextInt(1,10) ;
			System.out.println("Soldado anterior: "+soldadoAnterior);
			if(soldadoSalvado%nLargo==0)
				continue;
			System.out.println("Selección: "+soldadoSalvado);
			if(soldadoSalvado%totalSoldados==0)
			{
				System.out.println("1");
				soldados.Retira(soldadoAnterior-1);
				soldadoAnterior -= 1;
				System.out.println("Soldado "+soldados.Dr.nSoldado+" salvado");
				continue;
			}
			if(nLargo > soldadoSalvado)
			{System.out.println("2");
				soldados.Retira(soldadoSalvado+soldadoAnterior-1);
				soldadoAnterior = soldadoSalvado;
				System.out.println("Soldado "+soldados.Dr.nSoldado+" salvado");
				continue;
			}
			soldados.Retira(soldadoSalvado%nLargo);
			soldadoAnterior= soldadoSalvado%nLargo;
			System.out.println("Soldado "+soldados.Dr.nSoldado+" salvado");
			nLargo=totalSoldados-soldadoAnterior;
			System.out.println("3");
 * */
}
