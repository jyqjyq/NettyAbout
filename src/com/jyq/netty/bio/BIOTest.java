package com.jyq.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            ServerSocket serverSocket = new ServerSocket(8888);

            while (true){
                Socket socket = serverSocket.accept();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        hander(socket);
                    }
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void hander(Socket socket ){

        byte[] bytes = new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();
            while(true){
                int read = inputStream.read(bytes);
                if(read!=-1){
                    System.out.println(new String(bytes,0,read));
                }else{
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }

    }
}
