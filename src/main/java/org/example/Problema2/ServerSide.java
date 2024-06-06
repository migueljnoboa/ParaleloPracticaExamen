package org.example.Problema2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {

    public static void main(String[] args) {
        System.out.println("Server Escuchando");
        try(
                ServerSocket servidor = new ServerSocket(9090)
        ){
            Socket conexion = servidor.accept();
            System.out.println("Conexion creada");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String str = "El Server dice: " + entrada.readLine();
            PrintWriter out = new PrintWriter(conexion.getOutputStream(), true);
            out.println(str);


        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
