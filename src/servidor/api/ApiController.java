package servidor.api;

import servidor.util.connection;

/**
 *
 * */
public class ApiController {
    private String host;
    private Integer port;
    private connection connection;

    public void constructor(String host, Integer port){
        this.connection = new connection();
        this.connection.connect(host,port);
    }

    /** Endpoints da api  */
    public String get_capacity_laystall(int lixeira_id){
        return null;
    }

    /**
     * Retorna a lista das lixeiras
     * @return
     */
    public String get_list_laystall(){
        this.connection.get_server();
        return null;
    }
}
