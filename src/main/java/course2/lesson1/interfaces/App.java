package course2.lesson1.interfaces;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        Student student = new Student();
        Pupil pupil = new Pupil();

        Studyable studyable = student;
        //studyable.study(); // у него нет метода work()!

        Studyable[] studyables = new Studyable[] {student, pupil}; //массив объектов, которые могут обучаться
        for (Studyable studyable1: studyables) {
            studyable1.study();
        }

    }
}
