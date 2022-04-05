package course2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    public static void main(String[] args) {
        EchoClient echoClient = new EchoClient();
        echoClient.start();


    }
    private void start (){
        try{
            openConnection();
            Scanner scanner = new Scanner(System.in);
            while(true){
                String msg = scanner.nextLine(); //блокирующий метод
                out.writeUTF(msg);// посылка сообщений на сервер
                if ("/end".equalsIgnoreCase(msg)) {
                    break;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        if(socket!=null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(in!=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(out!=null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket("localhost", 8189);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String s = in.readUTF(); // блокирующий метод
                        if ("/end".equalsIgnoreCase(s)) {
                            break;
                        }
                        System.out.println("Сообщение от сервера " + s);
                    }
                }catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        closeConnection();
                    }
                }

        });
        thread.start();

    }
}
