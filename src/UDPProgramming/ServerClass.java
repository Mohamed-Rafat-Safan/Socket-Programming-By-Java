package UDPProgramming;

import java.net.*;
import java.io.*;

public class ServerClass {

    public static void main(String args[]) {
        DatagramSocket aSocket = null;

        try {
            aSocket = new DatagramSocket(6789); // fixed port number

            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(response);

                String receiveData = new String(buffer, 0, response.getLength());

                if ("Ping".equals(receiveData)) {
                    // this reply on client 
                    String serverMessage = "Pong";
                    DatagramPacket reply = new DatagramPacket(serverMessage.getBytes(),
                            serverMessage.length(), response.getAddress(), response.getPort());

                    aSocket.send(reply);
                } else {
                    // this reply on client 
                    String serverMessage = "Not the right message";
                    DatagramPacket reply = new DatagramPacket(serverMessage.getBytes(),
                            serverMessage.length(), response.getAddress(), response.getPort());
                    aSocket.send(reply);
                }
            }

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
