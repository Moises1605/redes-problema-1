package cliente.util;

import java.net.Socket;

/**
* Classe responsável por criar a conexão e enviar os dados para o servidor.
*/
public class Connection {
    private String host;
    private int port;
    private Socket client = null;

    public void connect(String host, int port){
        this.host = host;
        this.port = port;

        try {
            Socket client = new Socket(this.host,this.port);
            this.client = client;
        }
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Socket get_client(){
        return this.client;
    }

    /**
     * Método responsável por enviar os dados para o servidor
     * @param data
     * @return
     */
    public String send_data(String data){
        //Codicicar dado e colocar no padrão utf-8

        return null;
    }

    /**
     * Método responsável por formatar o dado para o formato json
     * @param data
     * @return
     */
    public String format_data_json(String data){
        return null;
    }

    /**
     * Método responsável por solicitar um dado do servidor
     * @return
     */
    public String get_data(){
        return null;
    }
}
