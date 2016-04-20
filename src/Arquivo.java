import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo{

    private static List<Votacao> voto = new ArrayList<Votacao>();

    public static List<Votacao> readFile(String arquivoCSV) {
        BufferedReader br = null;
        String linha = "";
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                //voto = null;
                String[] linhas = linha.split(";");
                Votacao votado = new Votacao(linhas[0], linhas[1],(linhas[2].trim()), (linhas[3].toLowerCase()));
                voto.add(votado);
            }
            return voto;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}