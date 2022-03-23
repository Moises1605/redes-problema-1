package servidor;

import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

import servidor.api.ApiController;

public class Main {

    public static void main(String[] args) {
        ApiController api = new ApiController(12345);

        try {
            // Instancia o ServerSocket ouvindo a porta 12345
            api.connect();
            ServerSocket server = api.get_connection().get_server();
            System.out.println("Servidor ouvindo a porta 12345");
            while(true) {
                Socket cliente = server.accept();

                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                saida.writeObject("dados-lixeira");

                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                System.out.println(api.format_message((String)entrada.readObject()));

                saida.close();
                entrada.close();
                cliente.close();
            }
        }
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        finally {}

    }
}
