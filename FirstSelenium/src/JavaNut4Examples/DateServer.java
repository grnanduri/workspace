package JavaNut4Examples;

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class DateServer {
    public static void main(String[] args) throws java.io.IOException {
	// Get a CharsetEncoder for encoding the text we send to the client
	CharsetEncoder encoder = Charset.forName("US-ASCII").newEncoder();

	// Create a new ServerSocketChannel, and bind it to port 8000.  
	// Note that we have to do this using the underlying ServerSocket.
	ServerSocketChannel server = ServerSocketChannel.open();
	server.socket().bind(new java.net.InetSocketAddress(8000));

	for(;;) {  // This server runs forever
	    // Wait for a client to connect.
	    SocketChannel client = server.accept();  
	    // Get the current date and time as a string
	    String response = new java.util.Date().toString() + "\r\n";
	    // Wrap, encode, and send the string to the client
	    client.write(encoder.encode(CharBuffer.wrap(response)));
	    // Disconnect from the client
	    client.close();
	}
    }
}
