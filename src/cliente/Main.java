package cliente;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("10.0.0.130", 12345);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            String mensagem = (String) entrada.readObject();
            System.out.println(mensagem);

            String resposta;
            do {

                System.out.println("Conexão estabelecida.");
                Scanner teclado = new Scanner(System.in);
                String ordem = teclado.nextLine();
                saida.writeObject(ordem);
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
