package course2.lesson111;

public class App {
    public static void main(String[] args) {
        User1 user1 = new ComputerUser();
        Guard guard = new Guard();
        boolean canPass = guard.canPass(user1);

    }
}
