package cliente.model;
//import javax.json;
public class TrashCan extends Cliente{
    private int id;
    private int capacity;
    private boolean released;
    private double latitude;
    private double longitude;

    public TrashCan(double latitude, double longitude,String host, int port){
        super(host,port);
        this.capacity = 0;
        this.latitude = latitude;
        this.longitude = longitude;
        this.released = true;
        this.id = 1;
    }

    public int get_capacity(){
        return this.capacity;
    }

    public void set_capacity(int capacity){
        this.capacity = capacity;
    }

    public String make_request(String data){
        String message = this.id + ";" + this.capacity + ";" + this.longitude +";" + this.latitude + ";" + this.released;

        return message;
    }

    public String decode(String data){
        //Decodificar o json enviado
        return null;
    }
}
