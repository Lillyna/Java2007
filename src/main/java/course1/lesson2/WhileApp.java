package course1.lesson2;

public class WhileApp {
    public static void main(String[] args) {
        int i = -10;
        while (i > 0) { //may not be executed at all
            if(i%2==0) {
                i--;
                continue;
            }
            System.out.println("i = "+i);
            i--;
        }
        int j = -10;
        do { //at least one time
            System.out.println("j = " + j);
            j--;
        } while (j > 0);

        //бесконечный цикл
//        while (true){
//
//        }
    }
}
