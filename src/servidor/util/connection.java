package servidor.util;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
* Classe responsável por criar a conexão e enviar dados para o cliente.
*/
public class connection {

    private String host;
    private Integer port;
    private ServerSocket server;

    public void connect(String host,Integer port){
        this.host = host;
        this.port = port;

        try {
            ServerSocket server = new ServerSocket(12345);
            this.server = server;
            while(true) {
                Socket cliente = server.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                saida.writeObject(new Date());
                saida.close();
                cliente.close();
            }
        }
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public ServerSocket get_server(){
        return this.server;
    }

    public void send_data(){

    }
}
