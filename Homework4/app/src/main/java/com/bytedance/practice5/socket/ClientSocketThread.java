package com.bytedance.practice5.socket;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.logging.Handler;

import static android.os.Looper.getMainLooper;

public class ClientSocketThread extends Thread {
    public ClientSocketThread(SocketActivity.SocketCallback callback) {
        this.callback = callback;
    }

    private SocketActivity.SocketCallback callback;

    //head请求内容
    private static String content = "HEAD /xxjj/index.html HTTP/1.1\r\nHost:www.sjtu.edu.cn\r\n\r\n";


    @Override
    public void run() {
        // TODO 6 用socket实现简单的HEAD请求（发送content）
        //  将返回结果用callback.onresponse(result)进行展示
        try{
            Socket socket = new Socket("www.sjtu.edu.cn", 80);
            BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream is = new BufferedInputStream(socket.getInputStream());
            byte[] data = new byte[1024 * 5];
            if (socket.isConnected()) {
                os.write(content.getBytes());
                os.flush();
                int receiveLen = is.read(data);
                if (receiveLen != -1) {
                    String receive = new String(data, 0, receiveLen);
                    callback.onResponse(receive);
                }
            }
            os.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}