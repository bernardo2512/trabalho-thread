import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ProcessamentoThread extends Thread{
    private Socket socket;

    public ProcessamentoThread(Socket socket){
        this.socket = socket;
    }
    public void run() {
        try {
            //1 - Definir stream de entrada de dados no servidor
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            Aluno aluno = (Aluno) entrada.readObject();
            System.out.println("[PROCESS] Calculando nota do aluno: " + aluno.getNomeAluno());

            //2 - Calcula media do aluno
            Double media = CalculaMedia.calcular(aluno.getListaNotas());
            aluno.setMediaNotas(media);

            //3 - Devolve aluno com media calculada
            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            saida.writeObject(aluno);

            //4 - Fechar streams de entrada e saída de dados
            entrada.close();
            saida.close();

            //5 - Fechar socket de comunicação
            socket.close();
        } catch (IOException ioe) {
            System.out.println("Erro: " + ioe.toString());
        } catch (ClassNotFoundException  e) {
            throw new RuntimeException(e);
        }
    }
}
