import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1 - Definir o serverSocket (abrir porta de conexão)
        ServerSocket servidorSocket = new ServerSocket(54322);
        System.out.println("[SERVER] A porta 54322 foi aberta!");
        System.out.println("[SERVER] Servidor esperando receber mensagens de clientes...");
        while (true) {
            //2 - Aguardar solicitações de conexão de clientes
            Socket socket = servidorSocket.accept();
            //Mostrar endereço IP do cliente conectado
            System.out.println("[SERVER] Cliente " + socket.getInetAddress().getHostAddress() + " conectado");

            //3 - Definir uma thread para cada cliente conectado
            ProcessamentoThread thread = new ProcessamentoThread(socket);
            thread.start();
            System.out.println("[SERVER] - Thread de processamento em execução.");
        }
    }
}
