package co.edu.eam.distribuidos.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

  public static void main(String[] args) throws IOException {

    //cliente se conecta al servvidor...
    //solicitud de conexion....
    System.out.println("Estableciendo conexion con el servidor....");
    Socket conexion = new Socket("localhost", 45000);

    System.out.println("conexion establecida");

    String saludo = "Ola k ase";

    //conexion.getOutputStream().write(saludo.getBytes());
    PrintStream salida = new PrintStream(conexion.getOutputStream());
    salida.println("hola q mas, como va?");
    //conexion.getInputStream();
    conexion.close();
  }
}
