import java.util.List;

public class CalculaMedia {

    public static Double calcular(List<Double> notas) {

        Double somatoria = 0.0;
        for (Double nota: notas) {
            somatoria = somatoria + nota;
        }
        return somatoria / notas.size();
    }
}
