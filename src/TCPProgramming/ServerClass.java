package TCPProgramming;

import java.io.*;
import java.net.*;

public class ServerClass {

    static int port = 1234;

    public static void main(String[] args) {

        try {
            // Register service on port 1234
            ServerSocket serverSocket = new ServerSocket(1234);

            while (true) {
                // Wait and accept a client connection
                Socket clientSocket = serverSocket.accept();//establishes connection   

                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                String str = dis.readUTF();
//                System.out.println("message= " + str);

                // Get a communication stream associated with the client socket
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

                if ("Ping".equals(str)) {
                    // Send a string!
                    dos.writeUTF("Pong");
                } else {
                    // Send a string!
                    dos.writeUTF("Not the right message");
                }

                // Close the connection, but not the server socket
                dis.close();
                dos.close();
                clientSocket.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
