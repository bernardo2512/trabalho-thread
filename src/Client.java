import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
            for (int i = 0; i < 10; i++) {
                    //1 - Abrir conexão
                    Socket socket = new Socket("localhost", 54322);
                    //2 - Definir stream de saída de dados do cliente
                    ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
                    saida.writeObject(new Aluno("Aluno"+i , Arrays.asList(1.0+i,1.5+i,7.0))); //Enviar  Objeto aluno para o servidor

                    //3 - Definir stream de entrada de dados no cliente
                    ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                    Aluno alunoOutPut = (Aluno) entrada.readObject();;//Receber objecto aluno com media calculada do servidor
                    System.out.println("[CLIENT] Media Calculada! \nAluno :" + alunoOutPut.getNomeAluno() + "\nMedia: " + alunoOutPut.getMediaNotas()); //Mostrar nota normaliada no cliente

                    //4 - Fechar streams de entrada e saída
                    entrada.close();
                    saida.close();

                    //5 - Fechar o socket
                    socket.close();
                    Thread.sleep(100);
            }


    }
}
