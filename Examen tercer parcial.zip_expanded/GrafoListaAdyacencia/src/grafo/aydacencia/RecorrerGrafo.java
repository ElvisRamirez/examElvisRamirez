package grafo.aydacencia;
import java.util.HashSet;
import java.util.Stack;

public class RecorrerGrafo {

    public static void DFS(GrafoAdcia grafo, VerticeAdy inicio1, VerticeAdy destino1) {
        HashSet<Integer> visitados = new HashSet<>();
        Stack<Integer> pila = new Stack<>();
        
        pila.push(inicio1.numVertice);
        
        while (!pila.isEmpty()) {
            int actualNum = pila.pop();
            VerticeAdy actual = grafo.tablAdc[actualNum];
            
            if (!visitados.contains(actualNum)) {
                System.out.println("Visitando: " + actual.nomVertice());
                visitados.add(actualNum);
                
                for (Arco arco : actual.lad) {
                    int vecinoNum = arco.getDestino();
                    if (!visitados.contains(vecinoNum)) {
                        pila.push(vecinoNum);
                    }
                }
            }
        }
    }
}

