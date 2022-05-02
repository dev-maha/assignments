package com.example.java22.activity14;


import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class exercise31_04 extends Application {
    private TextArea w = new TextArea();
    private int q = 0;

    @Override
    public void start(Stage primaryStage) {

        //FX
        Scene scene = new Scene(new ScrollPane(w), 450, 200);
        primaryStage.setTitle("ServerMain");
        primaryStage.setScene(scene);
        primaryStage.show();


        //Server
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                w.appendText("Exercise31_04Sever started at " + new Date() + '\n');

                while (true) {
                    Socket socket = serverSocket.accept();

                    Platform.runLater(() -> {
                        w.appendText("Starting thread " + q++ + '\n');

                        InetAddress inetAddress = socket.getInetAddress();
                        w.appendText("Client IP /" +
                                inetAddress.getHostAddress() + '\n');

                    });

                    new Thread(new HandleAClient(socket)).start();
                }
            }
            catch(IOException ex) {
                System.err.println(ex);
            }
        }).start();
    }

    class HandleAClient implements Runnable {
        private Socket socket;


        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {

                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                outputToClient.writeUTF("You are visitor " + q);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
