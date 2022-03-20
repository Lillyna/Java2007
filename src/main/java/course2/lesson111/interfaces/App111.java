package course2.lesson111.interfaces;

import java.util.Arrays;

public class App111 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));
        Student student = new Student();
        Pupil pupil = new Pupil();
        Studyable[] studyables = new Studyable[] {student, pupil};
        for (Studyable studyable: studyables){
            studyable.study();
        }

    }
}
