import java.util.*;

/**
 * Created by ilegra on 20/04/2016.
 */
    //Quantos disseram sim e quantos disseram nao?
    //Quantos votaram mais de uma vez (nomes repetidos) e serão eliminados e qual partido que isso mais aconteceu?

public class ApuraVotacao {
    Arquivo arq = new Arquivo();
    List<Votacao> votoRepetido = new ArrayList<>();
    Map voto = new HashMap<>();
    int contS = 0;
    int contN = 0;
    //Map votoRepetido = new HashMap<>();

    public Map contaVotos(List<Votacao> votos){
        for (int i = 0; i <votos.size(); i++) {
            if (votos.get(i).getVoto().equals("sim")){
                contS++;
                voto.put("sim", contS);
            }else{
                contN++;
                voto.put("nao", contN);
            }
        }
        return voto;
    }

    public List<Votacao> contaVotosRepetidos(List<Votacao> votos){
        for (int i = 0; i <votos.size(); i++) {
            if(!votoRepetido.contains(votos.get(i))) {
                for (int j = 0; j < votos.size(); j++) {
                    if (votos.get(i).getNome().equals(votos.get(j).getNome()) && votos.get(i).getPartido().equals(votos.get(j).getPartido()) && votos.get(i).getEstado().equals(votos.get(j).getEstado()) && i != j) {
                        if (!votoRepetido.contains(votos.get(j))) {
                            votoRepetido.add(votos.get(j));
                        }
                    }
                }
            }
        }
        return votoRepetido;
    }

}
