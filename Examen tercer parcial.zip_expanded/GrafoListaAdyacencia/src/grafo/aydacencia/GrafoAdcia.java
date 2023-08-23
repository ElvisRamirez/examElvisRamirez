package grafo.aydacencia;

public class GrafoAdcia {
	
	int numVerts;
	static int maxVerts = 20;
	VerticeAdy [] tablAdc;
	
	public GrafoAdcia(int mx) {
		tablAdc = new VerticeAdy[mx];
		numVerts = 0;
		maxVerts = mx;
	}
	
	
	// Agregar la m�todo que permite agregar un nuevo v�rtice
	/*
	 * A�ade un nuevo v�rtice a la lista directorio. Si el v�rtice ya est� en la tabla no hace nada, 
	 * devuelve control; si es nuevo, se asigna a continuaci�n del �ltimo. 
	 */
	
	public void agregarVerticeER(VerticeAdy vertice) {
	    if (numVerts < maxVerts) {  // Verifica si hay espacio para agregar el vértice
	        if (!existenciaVertice(vertice)) {  // Verifica si el vértice ya existe en el grafo
	        	tablAdc[numVerts] = vertice;  // Agrega el vértice a la tabla de adyacencia
	            vertice.asigVert(numVerts);   // Asigna el número de vértice al vértice agregado
	            numVerts++;  // Incrementa el contador de vértices
	        }
	    } else {
	        System.out.println("imposible agregar más vértices. El grafo está lleno.");
	    }
	}

	private boolean existenciaVertice(VerticeAdy vertice) {
	    for (int i = 0; i < numVerts; i++) {
	        if (tablAdc[i].equals(vertice)) {
	            return true;
	        }
	    }
	    return false;
	}

	
	
	
	//Agregar m�todo que permite agregar un nuevo arco
	/*
	 * Esta operaci�n da entrada a un arco del grafo. El m�todo tiene como entrada el v�rtice origen y el 
	 * v�rtice destino. El m�todo adyacente() determina si la arista ya est� en la lista de adyacencia, 
	 * y, por �ltimo, el Arco se inserta en la lista de adyacencia del nodo origen. 
	 * La inserci�n se hace como primer nodo para que el tiempo sea constante, O(1). 
	 * Otra versi�n del m�todo recibe, directamente, los n�meros de v�rtices que forman los extremos del arco. 
	 * ara a�adir una arista en un grafo valorado, se debe asignar el factor de peso al crear el Arco.
	 */
	
	
	public void agregarArco(VerticeAdy origen, VerticeAdy destino, double pesoDKm) {
	    if (existenciaVertice(origen) && existenciaVertice(destino)) {
	        if (!adyacente(origen, destino)) {
	            Arco nuevoArco = new Arco(destino.numVertice, pesoDKm); // Crear el arco con peso
	            origen.lad.add(0, nuevoArco);
	        } else {
	            System.out.println("El arco ya existe en la lista de adyacencia.");
	        }
	    } else {
	        System.out.println("Uno o ambos vértices no existen en el grafo.");
	    }
	}

	private boolean adyacente(VerticeAdy origen, VerticeAdy destino) {
	    for (Arco arco : origen.lad) {
	        if (arco.getDestino() == destino.numVertice) {
	            return true;
	        }
	    }
	    return false;
	}

	
	//Agregar un m�todo que determina si dos v�rtices son adyacentes
	/*
	 * La operaci�n determina si dos v�rtices, v1 y v2, forman un arco. En definitiva, 
	 * si el v�rtice v2 est� en la lista de adyacencia de v1. 
	 * El m�todo buscarLista() devuelve la direcci�n del nodo que contiene al arco, si no est� devuelve null. 
	 */
	public boolean sonAdyacentes(VerticeAdy v1, VerticeAdy v2) {
	    if (existenciaVertice(v1) && existenciaVertice(v2)) {  // Verifica que ambos vértices existan en el grafo
	        for (Arco arco : v1.lad) {
	            if (arco.getDestino() == v2.numVertice) {
	                return true;
	            }
	        }
	    }
	    return false;
	}


}
