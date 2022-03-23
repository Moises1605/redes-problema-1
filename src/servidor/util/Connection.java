package servidor.util;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
* Classe responsável por criar a conexão e enviar dados para o cliente.
*/
public class Connection {
    private int port;
    private ServerSocket server;

    public void connect(int port){
        this.port = port;

        try {
            ServerSocket server = new ServerSocket(this.port);
            this.server = server;
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
