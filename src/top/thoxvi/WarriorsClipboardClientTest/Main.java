package top.thoxvi.WarriorsClipboardClientTest;

import top.thoxvi.WarriorsClipboardClientTest.Security.Security;
import top.thoxvi.WarriorsClipboardClientTest.Security.SecurityMode;
import top.thoxvi.WarriorsClipboardClientTest.Tool.NetTool;
import top.thoxvi.WarriorsClipboardClientTest.Tool.StringTool;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String password = "自己的密码";
        String passwordS = "服务器的密码";
        SecurityMode security = new Security(passwordS.getBytes());
        try {
            String only = StringTool.getRandomString();
            System.out.println(only);
            Socket w = new Socket("127.0.0.1", 2333);
            NetTool.sendData(w, security, ("RegisteredR:" + password + " " + only).getBytes());

            Socket r = new Socket("127.0.0.1", 2333);
            NetTool.sendData(r, security, ("RegisteredW:" + password + " " + only).getBytes());
            byte[] data = NetTool.getData(r, security);
            if (data != null) {
                System.out.println("返回为：" + new String(data));
            }

            SecurityMode security1 = new Security(password.getBytes());

            new Thread(() -> {
                while (true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("输入字符：");
                    String data2 = sc.nextLine();
                    if (data2.equals("q")) return;
                    try {
                        NetTool.sendData(w, security1, data2.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(() -> {
                while (true) {
                    byte[] data1 = NetTool.getData(r, security1);
                    if (data1 == null) continue;
                    System.out.println(new String(data1));
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


