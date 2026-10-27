
import java.io.*;

public class FileCopy {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        try {
            br = new BufferedReader(new FileReader("source.txt"));
            bw = new BufferedWriter(new FileWriter("destination.txt"));

            Read();

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());

        } finally {
            if (br != null) {
                br.close();
            }

            if (bw != null) {
                bw.close();
            }
        }
    }


    private static void Read() throws IOException {
        String line;

        while ((line = br.readLine()) != null) {
            Write(line);
        }
    }


    private static void Write(String line) throws IOException {
        bw.write(line);
        bw.newLine();
    }
}
