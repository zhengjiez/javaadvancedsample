import java.net.*;
import java.io.*;

public class EchoClient {
    /**
     * TCP/IP client program.
     *
     * 1) Set up a client socket (IP address, PORT)
     *
     *      sock = new Socket("127.0.0.1", 10007);
     *
     * 2) Define a writer and reader from clientSock streams.
     *
     *      output = new PrintWriter(sock.getOutputStream(), true);
     *      input = new BufferedReader(new InputStreamReader (
     *                  sock.getInputStream()));
     *
     * 3) Send user input.
     *      
     *      output.println(userInput);
     *
     * 4) Receive response from server.
     *
     *      System.out.println("echo: " + input.readLine());
     */

    public static void main(String [] args) throws IOException {
        Socket sock = null;
        PrintWriter output = null;
        BufferedReader input = null;

        try {
            sock = new Socket("127.0.0.1", 10007);
            output = new PrintWriter(sock.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader (
                        sock.getInputStream()));
        } 
        catch (UnknownHostException e) {
            System.out.println("Unknown host");
            System.exit(1);
        }
        catch (IOException ie) {
            System.out.println("Cannot connect to host");
            System.exit(1);
        }
        
        // Get client input from STDIN (client typing).
        BufferedReader stdIn = new BufferedReader(
            new InputStreamReader(System.in));

        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            // Send the user input
            output.println(userInput);

            // Return the echo from echo server.
            System.out.println("echo: " + input.readLine());
        }
        output.close();
        input.close();
        stdIn.close();
        sock.close();
    }
}
