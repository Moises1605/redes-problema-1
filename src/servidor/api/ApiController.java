package servidor.api;

import servidor.util.Connection;

/**
 *
 * */
public class ApiController {
    private int port;
    private Connection connection;

    public ApiController(int port){
        this.port = port;
    }

    public void connect(){
        this.connection = new Connection();
        this.connection.connect(this.port);
    }

    /** Endpoints da api  */
    public String get_capacity_trashCan(int lixeira_id){
        return null;
    }

    /**
     * Retorna a lista das lixeiras
     * @return
     */
    public String get_list_trashCan(){
        this.connection.get_server();
        return null;
    }

    public Connection get_connection(){
        return this.connection;
    }

    public String format_message(String data){
        String[] info = data.split(";");

        return "Lixeira: " + info[0] + "\nCapacidade: " + info[1] + "\nLatitude: " + info[2] + "\nLongitude: " + info[3] +
                "\nLiberada: " + info[4];
    }
}
