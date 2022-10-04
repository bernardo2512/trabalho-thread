import java.io.Serializable;
import java.util.List;

public class Aluno implements Serializable {
    private List<Double> listaNotas;
    private String nomeAluno;

    private Double mediaNotas;

    public Aluno(String nomeAluno,List<Double> listaNotas){
        this.listaNotas = listaNotas;
        this.nomeAluno = nomeAluno;
    }

    public List<Double> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<Double> listaNotas) {
        this.listaNotas = listaNotas;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Double getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(Double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }


}
