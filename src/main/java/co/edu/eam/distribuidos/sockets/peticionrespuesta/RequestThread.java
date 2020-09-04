package co.edu.eam.distribuidos.sockets.peticionrespuesta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

public class RequestThread implements Runnable {

  private Socket connection;

  public RequestThread(Socket connection) {
    this.connection = connection;
  }

  @Override
  public void run() {
    try {

      PrintStream salida = new PrintStream(connection.getOutputStream());
      BufferedReader entrada = new BufferedReader(new InputStreamReader(connection.getInputStream()));

      String comando = entrada.readLine().toLowerCase();

      System.out.println(comando);
/**
      switch (comando) {
        case "fecha":  salida.println(new Date().toString()); break;
        case "suma":
          int n1 = Integer.valueOf(entrada.readLine());
          int n2 = Integer.valueOf(entrada.readLine());

          salida.println(n1 + n2);
      }
**/
salida.println("HTTP/1.0 200 OK");
String cadena = "<html><body>hola que <b>mas</b>" +
        "<img class=\"hero-nav__logo\" src=\"assets/imgs/logo.svg\">" +
        "" +
        "</body></html>";
salida.println("Content-length:"+cadena.length());
salida.println("Content-type: text/html");
salida.println();
salida.write(cadena.getBytes());


      connection.close();

    } catch (Exception exception){
      exception.printStackTrace();
    }finally {
      try {
        connection.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
