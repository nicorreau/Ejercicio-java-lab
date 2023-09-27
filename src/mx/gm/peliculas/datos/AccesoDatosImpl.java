package mx.gm.peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import mx.gm.peliculas.domain.Pelicula;
import mx.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo)  {
        var archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Exception al listar peliculas" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Exception al listar peliculas" + ex.getMessage());
        }

        return peliculas;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo " + pelicula);
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Exception al escribir peliculas" + e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula encontrada " + linea + "encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;

            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Exception al buscar peliculas" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Exception al buscar peliculas" + e.getMessage());

        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccesoDatosEx("Exception al crear peliculas" + e.getMessage());

        }

    }

    @Override
    public void borrar(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
        if (archivo.exists())
            archivo.delete();
        System.out.println("Se elimino el archivo ");

    }

}
