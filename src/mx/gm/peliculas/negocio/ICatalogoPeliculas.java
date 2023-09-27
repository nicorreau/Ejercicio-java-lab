package mx.gm.peliculas.negocio;

public interface ICatalogoPeliculas {

    String NOMBRE_ARCHIVO = "peliculas.txt";


    void agregarPelicula (String nombrePelicula);

    void listarPeliculas ();

    void buscarPeliculas (String buscar);

    void iniciarCatalago();
    
}
