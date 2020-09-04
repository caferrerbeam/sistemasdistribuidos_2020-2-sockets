package co.edu.eam.distribuidos.sockets.peticionrespuesta;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

  static Executor poolHilos;

  public static void main(String[] args) throws IOException {

    ServerSocket server = new ServerSocket(45000);
    poolHilos = Executors.newFixedThreadPool(50);

    //esperando una conexion...
    while(true) {
      System.out.println("Esperando conexion.........");

      Socket connection = server.accept();
      System.out.println("Conexion establecida.........");

      RequestThread hilo = new RequestThread(connection);
      poolHilos.execute(hilo);

    }
  }
}
