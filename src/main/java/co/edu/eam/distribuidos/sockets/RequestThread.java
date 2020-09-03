package co.edu.eam.distribuidos.sockets;

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

      switch (comando) {
        case "hora":  salida.println(new Date().toString()); break;
        case "suma":
          int n1 = Integer.valueOf(entrada.readLine());
          int n2 = Integer.valueOf(entrada.readLine());

          salida.println(n1 + n2);
      }

      connection.close();

    }catch (Exception exception){
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
