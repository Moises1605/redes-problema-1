package exemplo;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class exemplo_conexao {
    public void exemplo(){
        //Cliente
        try {
            Socket cliente = new Socket("10.0.0.130",12345);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            Date data_atual = (Date)entrada.readObject();
            JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data_atual.toString());
            entrada.close();
            System.out.println("Conexão encerrada");
        }
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        //Servidor
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
                saida.writeObject(new Date());
                saida.close();
                cliente.close();
            }
        }
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        finally {}
    }
}
