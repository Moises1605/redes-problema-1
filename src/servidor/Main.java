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
        try {
            // Instancia o ServerSocket ouvindo a porta 12345
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor ouvindo a porta 12345");
            while(true) {
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                Socket cliente = servidor.accept();

                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                saida.writeObject("Qual a ordem para recolher as lixeiras?");

                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                System.out.println("A lista de lixeiras é: " + entrada.readObject());
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
