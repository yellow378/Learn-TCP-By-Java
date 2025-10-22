package org.lwx.learnTCP.Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server is running on port 8888");

        Socket socket = serverSocket.accept();
        System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out =  new PrintWriter(socket.getOutputStream(), true);

        String message = in.readLine();
        System.out.println("Received message: " + message);
        out.println("Echo: " + message);

        socket.close();
        serverSocket.close();

    }
}
