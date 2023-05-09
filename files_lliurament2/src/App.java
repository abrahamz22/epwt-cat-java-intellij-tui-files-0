import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App {

    public static void main(String[] args) throws Exception {
        File file = new File("testfile.html");
        //TODO Crear un fitxer amb la classe File
        //el nom del fitxer serà testfile.html


        String str = urlReader("http://inslaguineueta.cat");

        saveToFile(str, file, true);
        //TODO cridar la funció perquè guardi str al fitxer

        System.out.println(readFromFile(file));
        //TODO LLegir el contingut del fitxer i imprimir-lo
        //per pantalla.
    }

    static String readFromFile(File file) throws IOException {
        //Aqui esta el bufferedReader
        FileReader lectura_archivo = new FileReader(file);
        BufferedReader lector_buffer = new BufferedReader(lectura_archivo);
        StringBuilder constructor_string = new StringBuilder();
        String line;
        while((line = lector_buffer.readLine()) != null){
            constructor_string.append(line);
        }
        lector_buffer.close();
        return constructor_string.toString();
        //TODO usant FileReader i BufferedReader
    }

    static void saveToFile(String str, File file, boolean append) throws IOException {
        FileWriter escritor_archivo = new FileWriter(file, true);

        BufferedWriter escritor_buffer = new BufferedWriter(escritor_archivo);

        escritor_buffer.write(str);

        escritor_buffer.close();
        //TODO usant FileWriter i BufferedWriter
    }

    public static String urlReader(String url) throws Exception {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            return sb.toString();
    }

}

