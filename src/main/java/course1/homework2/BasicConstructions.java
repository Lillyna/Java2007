package course1.homework2;

public class BasicConstructions {
    public static void main(String[] args) {
        //check task1
        System.out.println(isSumInsideBounds(10,11)+"\n");
        //check task2
        numberSign(0);
        //check task3
        System.out.println(isNumberNegative(0)+"\n");
        //check task4
        printStr("Some solid message",5);
        //check task5
        System.out.println(isLeapYear(400));
    }

    //task1
    public static boolean isSumInsideBounds (int a, int b){
        int sum = a+b;
        return sum>=10&&sum<=20;
    }

    //task2
    public static void numberSign (int a){
        System.out.println(a>=0?"Число положительное\n":"Число отрицательное\n");
    }

    //task3
    public static boolean isNumberNegative (int a){
        return a<0;
    }

    //task4
    public static void printStr (String str, int a){
        for (int i = 0; i < a; i++) {
            System.out.println(str+"\n");
        }
    }

    //task5
    public static boolean isLeapYear(int year){
        if(year%4==0&&year%100!=0&&year%400==0) return true;
        else return false;
    }
}
