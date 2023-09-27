package mx.gm.peliculas.datos;

import java.util.List;

import mx.gm.peliculas.domain.Pelicula;
import mx.gm.peliculas.excepciones.*;

public interface IAccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
