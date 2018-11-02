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
		int soldadoSalvado,totalSoldados;
		
		while(soldados.Length() > 1)
		{
			totalSoldados = soldados.Length();
			soldadoSalvado = Rutinas.nextInt(1,50);
			if(totalSoldados >= soldadoSalvado)
				soldados.Retira(soldadoSalvado);
			else
				soldados.Retira(soldadoSalvado - totalSoldados);
		}
		
		System.out.println("El soldado a realizar la misión es el soldado número: "+soldados.getFrente().Info.nSoldado);
		
	}

	public static void main(String[] args) 
	{
		AplSoldadoV a = new AplSoldadoV();
	}

	
	private  void llenarLista(Lista<Soldado> L)
	{
		int totalS = Rutinas.nextInt(20,50);
		for(byte i = 0; i < totalS; i++ )
		{
			L.InsertaFin(new Soldado(Rutinas.nextInt(1,10000),Rutinas.nextInt(18,25)));
		}
	}
}
