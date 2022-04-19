package course2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class EchoServer {

    public static void main(String[] args) {
        EchoServer echoServer = new EchoServer();
        echoServer.start();
    }
    private void start() {
        try (ServerSocket serverSocket = new ServerSocket(8189)
        ) { //try with resources
            System.out.println("Сервер запущен, ожидаем подключение");
            Socket socket = serverSocket.accept();// блокирующий метод, блокирует пока не подключится какой-нибудь клиент
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());//получение сообщения
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());//отправление сообщения
            sendMsgToClient(socket, out);
            listenMsgFromClient(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Сервер остановлен");
            System.exit(0);
        }
    }

    private void sendMsgToClient(Socket socket, DataOutputStream out) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        String s = scanner.nextLine();
                        System.out.println("Посылаю на клиент сообщение: " + s);
                        out.writeUTF(s);// посылка сообщений на клиент
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void listenMsgFromClient(DataInputStream in, DataOutputStream out) throws IOException {
        while (true) {
            String message = in.readUTF();//блокирующий метод
            if ("/end".equalsIgnoreCase(message)) {
                out.writeUTF("/end");
                break;
            }
            out.writeUTF("echo " + message);
        }
    }
}
