import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOperation {


    public String fileReader() {
        BufferedReader objReader = null;
        StringBuilder line = new StringBuilder();
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader("GameFile"));

            while ((strCurrentLine = objReader.readLine()) != null) {
                line.append(strCurrentLine + '\n');
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return line.toString();
    }
}
