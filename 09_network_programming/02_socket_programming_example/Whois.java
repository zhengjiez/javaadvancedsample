import java.net.*;
import java.io.*;

public class Whois {
	/* 
     * A client socket.
     *
	 * TCP/IP protocol: needs sockets.
	 */

	public static void main(String []args) throws Exception {
		Socket sock = new Socket("whois.internic.net", 43);

        // Input stream to receive data.
        // Output stream to send data.
        InputStream input = sock.getInputStream();
        OutputStream output = sock.getOutputStream();

        String strng = "infiniteskills.com\n";

        // Convert our string into a byte array for transmitting.
        byte buffer[] = strng.getBytes();

        // Send our command to the socket.
        output.write(buffer);

        // Get the data coming back as bytes. convert it into char
        int ch;
        while ((ch = input.read()) != -1) {
            System.out.print((char) ch);
        }
        sock.close();
	}
}

