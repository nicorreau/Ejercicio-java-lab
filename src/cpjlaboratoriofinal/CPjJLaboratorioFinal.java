package cpjlaboratoriofinal;

import java.util.Scanner;

import mx.gm.peliculas.negocio.*;

public class CPjJLaboratorioFinal {
    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("\nElige una opcion: \n"
                    + "1.Iniciar Catalago Peliculas\n"
                    + "2. Agregar pelicula\n"
                    + "3.Listar peliculas\n"
                    + "4.Buscar peliculas\n"
                    + "0. Salir\n");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalago();
                    break;
                case 2:
                    System.out.println("Ingresa el nombre de la pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4: 
                    System.out.println("Introduce el nombre de una pelicula a buscar");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPeliculas(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                        System.out.println("Opcion no reconocida");
                        break;

                    

            }
        }
    }

}
