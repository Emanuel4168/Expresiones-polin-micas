package expresionesPolinomicas;


public class Lista<T> {
	
	private Nodo<T> Frente;
	private Nodo<T> Fin;
	public T Dr;
	
	public Lista(){
		Frente=Fin=null;
		Dr=null;
	}

	public boolean InsertaFrente(T Dato){
		if(Dato==null)
			return false;
		Nodo<T> Nuevo=new Nodo<T>(Dato);

		if(Frente==null)
			Frente=Fin=Nuevo;
		else{
			Nuevo.setSig(Frente);
			Frente=Nuevo;
		}
		return true;
	}

	public boolean InsertaFin(T Dato){
		if(Dato==null)
			return false;
		Nodo<T> Nuevo;
		try {
		  Nuevo=new Nodo<T>(Dato);
		} catch(Exception e){return false;}

		if(Frente==null)
			Frente=Fin=Nuevo;
		else{
			Fin.setSig(Nuevo);
			Fin=Nuevo;
		}
		return true;
	}
	
	public boolean insertaOrdenado(T Dato)
	{
		if(Dato==null)
			return false;
		Nodo<T> Nuevo;
		
		try {
		  Nuevo=new Nodo<T>(Dato);
		} catch(Exception e){return false;}

		if(Frente == null)
			Frente = Fin = Nuevo;
		
		String idNuevo = Dato.toString();
		if(idNuevo.compareTo(Frente.Info.toString()) <= 0)
		{
			Nuevo.setSig(Frente);
			Frente = Nuevo;
			return true;
		}
		
		if(idNuevo.compareTo(Frente.Info.toString()) >= 0)
		{
			Fin.setSig(Nuevo);
			Fin = Nuevo;
			return true;
		}
		
		Nodo<T> siguiente = Frente;
		Nodo<T> anterior = null;
		while(idNuevo.compareTo(siguiente.Info.toString()) < 0)
		{
			anterior = siguiente;
			siguiente = siguiente.getSig();
		}
		
		anterior.setSig(Nuevo);
		Nuevo.setSig(siguiente);
		return true;
	}

	public int Length(){
		Nodo<T> Aux=Frente;
		int Cont=0;
		while(Aux != null){
			Cont++;
			Aux=Aux.getSig();
		}
		return Cont;
	}

	public boolean Retira(int Posicion){
		if(Posicion>Length())
			return false;
		Nodo<T> Aux=Frente;
		Nodo<T> Ant=null;
		for(int i=1 ; i<Posicion ; i++){
			Ant=Aux;
			Aux=Aux.getSig();
		}
		EliminaNodo(Aux,Ant);
		return true;
		
	}

	private void EliminaNodo(Nodo<T> Aux,Nodo<T> Ant){
		Dr=Aux.Info;
		//�nico nodo de la lista
		if(Frente==Fin){
			Frente=Fin=null;
			return;
		}
		// Primero de la lista
		if(Aux==Frente){
			Frente=Frente.getSig();
			return;
		}
		// �ltimo de la lista
		if(Aux==Fin){
			Ant.setSig(null);
			Fin=Ant;
			return;
		}
		// entre dos nodos
		Ant.setSig(Aux.getSig());
	}

	public boolean Retira(T Dato){
		return true;
	}

	public Nodo<T> getFrente(){
		return Frente;
	}
	
	public Nodo<T> getFin(){
		return Fin;
	}
}

