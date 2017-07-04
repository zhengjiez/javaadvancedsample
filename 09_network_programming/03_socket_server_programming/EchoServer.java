import java.net.*;
import java.io.*;

public class EchoServer {
	/**
	 * TCP/IP server program.
     *
     * Most important commands.
     *
     * 1) Establish connection
     *
     *      serverSock = new ServerSocket(10007);
     *      clientSock = serverSock.accept();
     *
     *
     * 2) Define a writer and reader from clientSock streams
     *
     *     PrintWriter output = new PrintWriter(
     *         clientSock.getOutputStream(), true);
     *
     *     BufferedReader input = new BufferedReader(
     *         new InputStreamReader(clientSock.getInputStream()));
     *
     * 3) Read from input reader, and display it on the STDOUT.
     *
     *         output.println(inputLine);
     *
     * 4) Finally, close streams, connection.
     *
	 */

	public static void main(String []args) throws IOException {
		ServerSocket serverSock = null;
        try {
            // Initiate the server socket, using a nice random
            // port number 10007.
            serverSock = new ServerSocket(10007);
        }
        catch (IOException ie) {
            System.out.println("Can't listen on 10007");
            System.exit(1);
        }

        // Otherwise, set up a client socket.
        // Waiting for a client to connect.
        Socket clientSock = null;
        System.out.println("Listening for connection...");
        try {
            // The server's accept method returns a client socket.
            clientSock = serverSock.accept();
        } 
        catch (IOException ie) {
            System.out.println("Accept failed.");
            System.exit(1);
        }

        // Otherwise we print a successful message.
        System.out.println("Connection successful.");

        // Waiting for the client program to send us a message.
        System.out.println("Listening for input...");

        PrintWriter output = new PrintWriter(
            clientSock.getOutputStream(), true);

        BufferedReader input = new BufferedReader(
            new InputStreamReader(clientSock.getInputStream()));

        // Print the input.
        String inputLine;
        while ((inputLine = input.readLine()) != null) {
            System.out.println("Server: " + inputLine);
            output.println(inputLine);

            // If receive a "Bye" message, break out the while loop.
            if (inputLine.equals("Bye")) {
                break;
            }

        }
        // Finally close all of our connections.
        output.close();
        input.close();
        clientSock.close();
        serverSock.close();

	}
}

