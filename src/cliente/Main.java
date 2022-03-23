package cliente;

import cliente.model.Cliente;
import cliente.model.TrashCan;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrashCan trashCan = new TrashCan(-12.220240948263967,-38.98620457393851,"10.0.0.130", 12345);
        String message;
        try {
            trashCan.connect();
            Socket cliente = trashCan.get_connection().get_client();
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            message = trashCan.make_request(entrada.toString());

            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            String mensagem = (String) entrada.readObject();
            System.out.println(mensagem);

            String resposta;
            do {

                System.out.println("Conexão estabelecida.");
                Scanner teclado = new Scanner(System.in);
                saida.writeObject(message);
                System.out.println("Deseja encerrar a Conexão?");
                resposta = teclado.nextLine();

            } while (resposta.equalsIgnoreCase("N"));

            entrada.close();
            saida.close();
            System.out.println("Conexão encerrada");
        }
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
