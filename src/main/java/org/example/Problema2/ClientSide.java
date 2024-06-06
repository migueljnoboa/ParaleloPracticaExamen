package org.example.Problema2;

import java.io.*;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) {

        try(Socket socket = new Socket("localhost",9090)){
            BufferedReader br = new BufferedReader(new StringReader("Hello desde el Cliente"));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(br.readLine());

            BufferedReader servidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(servidor.readLine());
        }
        catch(IOException e){

        }

    }
}
