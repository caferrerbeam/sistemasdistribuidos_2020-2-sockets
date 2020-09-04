package co.edu.eam.distribuidos.sockets.hiloxcliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHiloXCliente {

  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(50000);
    System.out.println("Esperando conexion hilo x cliente.........");

    Socket connection = server.accept();
    System.out.println("Conexion establecida hilo x clinte.........");

    HiloXCliente hilo = new HiloXCliente(connection);
    new Thread(hilo).start();

  }
}
