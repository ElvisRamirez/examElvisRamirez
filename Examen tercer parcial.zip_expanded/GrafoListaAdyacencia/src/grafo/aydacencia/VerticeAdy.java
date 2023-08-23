package grafo.aydacencia;

import java.util.ArrayList;
public class VerticeAdy {
	
	String nombreCiudad;
	int numVertice;
	ArrayList <Arco>lad; // lista de adyacencia
	
	// constructor de la clase
	public VerticeAdy(String x) {
		nombreCiudad = x;
		numVertice = -1;
		lad = new ArrayList<Arco>();
	}
	
	public String nomVertice() { // devuelve identificador del vértice 
		return nombreCiudad;
	}

	public boolean equals(VerticeAdy n) { // true, si dos vértices son iguales
		return nombreCiudad.equals(n.nombreCiudad);
	}

	public void asigVert(int n) {// establece el número de vértices
		numVertice = n;
	}
	
	public String toString() {// características del vértice
		return nombreCiudad + " (" + numVertice + ")";
	}
	
	
	 // Método para agregar un arco a la lista de adyacencia
    public void agregarArco(Arco arco) {
        lad.add(arco);
    }

    // Método para verificar si ya existe un arco hacia un vértice destino
    public boolean tieneArcoHacia(int destino) {
        for (Arco arco : lad) {
            if (arco.getDestino() == destino) {
                return true;
            }
        }
        return false;
    }
}
