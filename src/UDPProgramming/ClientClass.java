package UDPProgramming;

import java.io.*;
import java.net.*;

public class ClientClass {

    public static void main(String args[]) {

        DatagramSocket aSocket = null;

        try {
            aSocket = new DatagramSocket();
            
            String message1 = "Ping";  
            String message2 = "Hello";  
            InetAddress aHost = InetAddress.getByName("127.0.0.1");
            int serverPort = 6789;  // Or Integer.valueOf(args[2]).intValue() if use <Port number> args[2]
            
            DatagramPacket request = new DatagramPacket(message1.getBytes(), message1.length(), aHost, serverPort);
            aSocket.send(request);
            
            // this receive the data from server
            byte[] buffer = new byte[1000];
            DatagramPacket replyFromServer = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(replyFromServer);
            System.out.println(new String(replyFromServer.getData()));
            
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }

    }

}
