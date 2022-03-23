package cliente.model;

import cliente.util.Connection;

public class Cliente {
    private int port;
    private String host;
    private Connection connection;

    public Cliente(String host, int port){
        this.port = port;
        this.host = host;
    }

    public void connect(){
        this.connection = new Connection();
        this.connection.connect(this.host,this.port);
    }

    public Connection get_connection(){
        return this.connection;
    }
}
