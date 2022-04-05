package course2.lesson6;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        Socket socket = null;

        try (ServerSocket serverSocket = new ServerSocket(8189)//;
             // ServerSocket serverSocket1 = new ServerSocket(8190)
        )
        { //try with resources
            System.out.println("Сервер запущен, ожидаем подключение");
            socket = serverSocket.accept();// блокирующий метод, блокирует пока не подключится какой-нибудь клиент
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());//получение сообщения
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());//отправление сообщения
            while (true){
                String message = in.readUTF();//блокирующий метод
                if("/end".equalsIgnoreCase(message)){
                    out.writeUTF("/end");
                    break;
                }
                out.writeUTF("echo " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Сервер остановлен");
    }
}
