package Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShowText {

    public void showText() {
        String nombreArchivo = "person2.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 4) {
                    String formato = "%-12s%-20s%-20s%-1s";
                    System.out.printf(formato, partes[0], partes[1], partes[2], partes[3]);
                    System.out.println();
                } else {
                    System.err.println("Error en el formato de la linea: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
