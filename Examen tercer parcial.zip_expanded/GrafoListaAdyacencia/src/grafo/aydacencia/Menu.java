package grafo.aydacencia;
import java.util.Scanner;
public class Menu {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrafoAdcia grafo = new GrafoAdcia(20);  // Crear el grafo con un máximo de 20 vértices

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Agregar vértice");
            System.out.println("2. Agregar arco");
            System.out.println("3. Realizar DFS");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del vértice: ");
                    String nombreVertice = scanner.next();
                    VerticeAdy nuevoVertice = new VerticeAdy(nombreVertice);
                    grafo.agregarVerticeER(nuevoVertice);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del vértice de origen: ");
                    String nombreOrigen = scanner.next();
                    
                    System.out.print("Ingrese el nombre del vértice de destino: ");
                    String nombreDestino = scanner.next();
                    
                    VerticeAdy origen = null;
                    VerticeAdy destino = null;
                    
                    for (VerticeAdy vertice : grafo.tablAdc) {
                        if (vertice != null && vertice.nomVertice().equals(nombreOrigen)) {
                            origen = vertice;
                        }
                        if (vertice != null && vertice.nomVertice().equals(nombreDestino)) {
                            destino = vertice;
                        }
                    }
                    
                    if (origen != null && destino != null) {
                        System.out.print("Ingrese el peso del arco: ");
                        double pesoArco = scanner.nextDouble();
                        
                        grafo.agregarArco(origen, destino, pesoArco);
                        System.out.println("Arco agregado correctamente.");
                    } else {
                        System.out.println("Nombre de vértice inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del vértice de origen: ");
                    String nombreOrigen1 = scanner.next();
                    
                    System.out.print("Ingrese el nombre del vértice de destino: ");
                    String nombreDestino1 = scanner.next();
                    
                    VerticeAdy origen1 = null;
                    VerticeAdy destino1 = null;
                    
                    for (VerticeAdy vertice : grafo.tablAdc) {
                        if (vertice != null && vertice.nomVertice().equals(nombreOrigen1)) {
                        	origen1 = vertice;
                        }
                        if (vertice != null && vertice.nomVertice().equals(nombreDestino1)) {
                        	destino1 = vertice;
                        }
                    }
                    
                    if (origen1 != null && destino1 != null) {
                        
                    	RecorrerGrafo.DFS(grafo, origen1,destino1);
                    } else {
                        System.out.println("Nombre de vértice inválido.");
                    }
                    break;


                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }
}


