package esempi.java_packages;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderWriter {

    public static void main(String[] args){

        /* Come gestire un Path */
        String filePath="module_09/src/esempi/resources/test.txt";
        Path path = Paths.get("module_09", "src", "esempi", "resources", "test.txt"); //metodo consigliato

        /* 01 - Come scrivere dati */
        writeLine(path.toString(), "Hello World!");

        /* Come scrivere dati senza sovrascrivere (append) */

        /* Read by scanner con try-with-resources */

        /* Read All lines */

    }

    /* 01 - Scrittura di un file (in questo modo sovrascriviamo*/
    public static void writeLine(String filePath, String line2write){

        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath))){
            bw.write(line2write);
            bw.newLine();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
