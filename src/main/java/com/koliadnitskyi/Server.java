package com.koliadnitskyi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {
    private static Socket client;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(8081);
                System.out.println("Server started!");
                client = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    out.write("Hello!" + "\n");
                    out.flush();
                    String word = in.readLine();
                    if (new Verification().languageControl(word)) {
                        out.write("What is palyanica?" + "\n");
                        out.flush();
                        if (in.readLine().equals("Bread")) {
                            out.write("All the best to you. Goodbye. " + LocalDateTime.now() + "\n");
                            out.flush();
                        } else {
                            out.write("Everything is clear with you. Cooperation terminated." + "\n");
                            out.flush();
                        }
                    }
                } finally {
                    client.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server closed!");
                server.close();
            }
        } catch (IOException e) {
            System.out.println("An error has occurred in the application.");
        }
    }
}
