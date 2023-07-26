package TCPProgramming;

import java.io.*;
import java.net.*;

public class ClientClass {

    public static void main(String args[]) {
        try {
            // Open your connection to a server, at port 1234
            Socket s1 = new Socket("localhost", 1234);
            
            String message1 = "Ping" ;
            String message2 = "Hello" ;

            DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
            dos.writeUTF(message1);

            // Get an input file handle from the socket and read the input
            DataInputStream dis = new DataInputStream(s1.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println(str);

          
            dos.close();
            dis.close();
            s1.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
