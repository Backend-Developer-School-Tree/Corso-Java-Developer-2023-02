package esempi.java_packages;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ReaderWriter {

    public static void main(String[] args) {

        /* Come gestire un Path */
        String filePath = "module_09/src/esempi/resources/test.txt";
        Path path = Paths.get("module_09", "src", "esempi", "resources", "testCreazione.txt"); //metodo consigliato

        /* Creazione file */
        createFile(path.toString());

        /* 01 - Come scrivere dati */
        writeLine(path.toString(), "Hello World!");

        /* Come scrivere dati senza sovrascrivere (append) */
        appendLine(path.toString(), "Hello World Append!");
        appendLine(path.toString(), "Hello World Append!");
        appendLine(path.toString(), "Hello World Append!");

        /* Read by scanner con try-with-resources */
        readByScannerTryWithResources(path.toString());

        /* Read All lines */
        readByBufferedReader(path.toString());
    }

    /* Creazione di un file */
    public static void createFile(String filePath) {
        File newFile = new File(filePath);

        try {
            newFile.createNewFile();

        } catch (IOException e) {
           e.printStackTrace();
        }
    }



    /* Scrittura di un file (in questo modo sovrascriviamo*/
    public static void writeLine(String filePath, String line2write) {

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath))) {
            bw.write(line2write);
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* StandardOpenOption è una enum con tutte le operazioni disponibili.
     * Avrei potuto usare un solo metodo che prendeva StandardOpenOption come parametro e usare
     * un solo metodo per scrivere
     * */
    public static void appendLine(String filePath, String line2write) {

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            bw.write(line2write);
            bw.newLine(); // Vado a capo perchè ho messo io l'istruzione!

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Metodo per leggere da file tramite classe Scanner utilizzando try-with-resource per chiudere
     * in automatico l'oggetto Scanner */
    public static void readByScannerTryWithResources(String filePath) {

        try (Scanner sc = new Scanner(new File(filePath))) {

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readByBufferedReader(String filePath) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            br.readLine(); //come si salta la prima riga (es ho intestazione dei dati che non voglio stampare)

            while ((line = br.readLine()) != null)
                System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
