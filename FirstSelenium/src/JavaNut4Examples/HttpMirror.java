package JavaNut4Examples;

import java.io.*;
import java.net.*;

public class HttpMirror {
  public static void main(String[] args) {
    try {
      int port = Integer.parseInt(args[0]);        // The port to listen on
      @SuppressWarnings("resource")
	ServerSocket ss = new ServerSocket(port);    // Create a socket to listen
      for(;;) {                                    // Loop forever
        Socket client = ss.accept();               // Wait for a connection
        ClientThread t = new ClientThread(client); // A thread to handle it
        t.start();                                 // Start the thread running
      }                                            // Loop again
    } 
    catch (Exception e) {
      System.err.println(e.getMessage());
      System.err.println("Usage: java HttpMirror <port>;");
    }
  }

  static class ClientThread extends Thread {
    Socket client;
    ClientThread(Socket client) { this.client = client; }
    public void run() {
      try {
        // Get streams to talk to the client
        BufferedReader in = 
          new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out =
          new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        
        // Send an HTTP response header to the client
        out.print("HTTP/1.0 200\r\nContent-Type: text/plain\r\n\r\n");
        
        // Read the HTTP request from the client and send it right back
        // Stop when we read the blank line from the client that marks 
        // the end of the request and its headers. 
        String line;
        while((line = in.readLine()) != null) {
          if (line.length() == 0) break;
          out.println(line);
        }
        
        out.close();
        in.close();
        client.close();
      }
      catch (IOException e) { /* Ignore exceptions */ }
    }
  }
}
