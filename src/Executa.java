import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;

/**
 * Created by ilegra on 20/04/2016.
 */
public class Executa {

    public static void main(String[] args) {
        Arquivo arq = new Arquivo();
        ApuraVotacao apura = new ApuraVotacao();
        List<Votacao> vot;
        List<Integer> votoRepetido;
        Map recebeVoto;
        int cont = 0;
        String aux = "";

        vot = arq.readFile("votos.txt");
        for (int i = 0; i <vot.size(); i++) {
            System.out.println("Voto de:"+vot.get(i).getNome()+ ". Partido:"+vot.get(i).getPartido()+". Estado:"+vot.get(i).getEstado()+". Voto:"+vot.get(i).getVoto());
        }

        recebeVoto = apura.contaVotos(vot);
        System.out.println("O número de votos SIM é: "+recebeVoto.get("sim")+" e o número de votos NÃO é: "+recebeVoto.get("nao"));
        vot = apura.contaVotosRepetidos(vot);
        System.out.println(vot.size());
        recebeVoto.clear();
        for (int i = 0; i <vot.size(); i++) {
                recebeVoto.put(vot.get(i).getPartido(), cont++);
        }

        System.out.println(recebeVoto);
    }
}