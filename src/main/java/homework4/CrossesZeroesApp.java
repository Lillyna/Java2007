package homework4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CrossesZeroesApp {

    //Поле
    public static char[][] map;

    //Размер поля
    public static final int SIZE = 3;

    //Точек для победы
    public static final int DOTS_TO_WIN = 3;

    //Описание точек
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    //Сканер
    public static final Scanner SCANNER = new Scanner(System.in);
    //Рандом
    public static final Random RANDOM = new Random();

    /**
     * Проинициализировать поле
     */
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    /**
     * Вывод игрового поля на экран
     */
    public static void printMap() {
        //нумеруем верхний ряд
        for (int i = 0; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        //пишем строки мапы
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Ход человека
     */
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    /**
     * Ход компьютера
     */
    public static void aiTurn(){
        int[] coords = blockTurn();
        System.out.println("Робот делает ход в " + (coords[0] + 1) + " " + (coords[1] +1));
        map[coords[1]][coords[0]] = DOT_O;
    }

    /**
     * Блокирует ход игрока (определяет наиболее выгодные координаты, чтобы предотвратить выигрыш соперника)
     * @return координаты хода компьютера
     */
    public static int[] blockTurn(){
        int[] coords = new int[2];
        char[] arr = new char[DOTS_TO_WIN-1];
        Arrays.fill(arr,DOT_X);
        String sequenceOfX = String.valueOf(arr);
        System.out.println("Последовательность"+sequenceOfX);
        //проверка по строкам
        for (int i = 0; i < map.length; i++) {
            String row = String.valueOf(map[i]);
            int startSequenceIndex = row.indexOf(sequenceOfX);
            System.out.println("Первый индекс"+row.indexOf(sequenceOfX));
            int endSequenceIndex = startSequenceIndex+DOTS_TO_WIN-1;
            if(startSequenceIndex>=0){
                System.out.println("Проверка по строкам");
                if (isCellValid(startSequenceIndex-1,i)){
                    System.out.println("Проверка по строкам"+(startSequenceIndex-1)+i);
                coords[0] = startSequenceIndex-1;
                coords[1] = i;
                return coords;
                }
                else if (isCellValid(endSequenceIndex+1,i)){
                    coords[0] = endSequenceIndex+1;
                    coords[1] = i;
                    return coords;
                }
            }
        }
        //проверка по столбцам
        char[][] mapTransposed = swap(map);
        for (int i = 0; i < mapTransposed.length; i++) {
            String row = String.valueOf(mapTransposed[i]);
            int startSequenceIndex = row.indexOf(sequenceOfX);
            int endSequenceIndex = startSequenceIndex+DOTS_TO_WIN-1;
            if(startSequenceIndex>=0){
                if (isCellValid(startSequenceIndex-1,i)){
                    coords[1] = startSequenceIndex-1;
                    coords[0] = i;
                    return coords;
                }
                else if (isCellValid(endSequenceIndex+1,i)){
                    coords[1] = endSequenceIndex+1;
                    coords[0] = i;
                    return coords;
                }
            }
        }

        //проверка по главной диагонали
        char[] diagMain = new char[SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <map[i].length; j++) {
                if(i==j){
                    diagMain[i]=map[i][j];
                }
            }
        }
        System.out.println(Arrays.toString(diagMain));
        int startSequenceIndex = String.valueOf(diagMain).indexOf(sequenceOfX);
        int endSequenceIndex = startSequenceIndex + DOTS_TO_WIN -1;
        if(startSequenceIndex>=0){
            if(isCellValid(startSequenceIndex-1,startSequenceIndex-1)) {
                coords[0] = coords[1] = startSequenceIndex - 1;
                System.out.println(Arrays.toString(coords));
                return coords;
            }
            else if (isCellValid(endSequenceIndex+1,endSequenceIndex+1)) {
                coords[0] = coords[1] = endSequenceIndex + 1;
                System.out.println(Arrays.toString(coords));
                return coords;
            }
        }

        //проверка по неглавной диагонали
        char[] diagSecond = new char[SIZE];
        int k = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <map[i].length; j++) {
                if(map[i].length - i == j + 1){
                    diagSecond[k] = map[i][j];
                    k++;
                }
            }
        }
        startSequenceIndex = String.valueOf(diagSecond).indexOf(sequenceOfX);
        endSequenceIndex = startSequenceIndex + DOTS_TO_WIN -1;
        if(startSequenceIndex>=0){
            if(isCellValid(startSequenceIndex-1,SIZE - startSequenceIndex+1)) {
                coords[0] = startSequenceIndex - 1;
                coords[1] = SIZE - startSequenceIndex+1;
                System.out.println(Arrays.toString(coords));
                return coords;
            }
            else if (isCellValid(endSequenceIndex+1,SIZE - endSequenceIndex-2)) {
                coords[0] = endSequenceIndex + 1;
                coords[1] = SIZE - endSequenceIndex-2;
                System.out.println(Arrays.toString(coords));
                return coords;
            }
        }
        //если нечего пока блокировать, делаем случайный ход
        do{
            coords[0] = RANDOM.nextInt(SIZE);
            coords[1] = RANDOM.nextInt(SIZE);
        } while (!isCellValid(coords[0],coords[1]));
        return coords;
    }

    /**
     * Проверка, валидны ли значения поля
     *
     * @param x координата X
     * @param y координата Y
     * @return да/нет
     */
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x]!=DOT_EMPTY){
            return false;
        }
        return true;
    }

    /**
     * Проверка, что в поле не осталось ни одной свободной ячейки
     * @return true, если нет ни одной свободной
     */
    public static boolean isMapFull(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Проверка победы
     * @param symbol Крестик или нолик
     * @return true, если выиграл
     */
    public static boolean checkWin(char symbol){
        char[] arr = new char[DOTS_TO_WIN];
        Arrays.fill(arr,symbol);
        String winCombo = String.valueOf(arr);
        //строки
        for (int i = 0; i < map.length; i++) {
            String row = String.valueOf(map[i]);
            if(row.contains(winCombo)){
                return true;
            }
        }

        //столбцы
        char[][] mapTransposed = swap(map);
        for (int i = 0; i < mapTransposed.length; i++) {
            String row = String.valueOf(mapTransposed[i]);
            if(row.contains(winCombo)){
                return true;
            }
        }

        //главная диагональ
        char[] diagMain = new char[SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <map[i].length; j++) {
                if(i==j){
                    diagMain[i]=map[i][j];
                }
            }
        }
        if(String.valueOf(diagMain).contains(winCombo)){
            return true;
        }

        //неглавная диагональ
        char[] diagSecond = new char[SIZE];
        int k = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <map[i].length; j++) {
                if(map[i].length - i == j + 1){
                    diagSecond[k] = map[i][j];
                    k++;
                }
            }
        }
        if(String.valueOf(diagSecond).contains(winCombo)){
            return true;
        }
        return false;
    }

    /**
     * Траспонирует матрицу
     * @param map входная матрица
     * @return траспонированная матрица
     */
    public static char[][] swap (char[][] map){
        char[][] mapTransposed = new char[SIZE][SIZE];
        for(int i=0;i<map.length;i++) {
            for (int j = i; j < map[i].length; j++) {
                if (i != j) {
                    mapTransposed[i][j] = map[j][i];
                    mapTransposed[j][i] = map[i][j];
                }
                else {
                    mapTransposed[i][j] = map[i][j];
                }
            }
        }
        return mapTransposed;
    }

    public static void main(String[] args) {
        initMap();
        printMap();
        while(true){
            humanTurn();
            printMap();
            if(checkWin(DOT_X)){
                System.out.println("Побеждает человек");
                break;
            }
            if(isMapFull()){
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if(checkWin(DOT_O)){
                System.out.println("Побеждает ai");
                break;
            }
            if(isMapFull()){
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Game over");

    }
}
