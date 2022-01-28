package homework5;

public class HomeworkApp {
    public static void main(String[] args) {
        Employer employer1 = new Employer("Ivanov Ivan", "engineer", "ivanov@mail.com", "2765", 50000, 50);
        Employer employer2 = new Employer("Petrov Ivan", "analyst", "petrov@mail.com", "2764", 80000, 30);
        Employer employer3 = new Employer("Sidorov Sidor", "tester", "sidorov@mail.com", "2763", 30000, 41);
        Employer employer4 = new Employer("Golubeva Victoria", "hr", "golubeva@mail.com", "2762", 15000, 19);
        Employer employer5 = new Employer("Smirnova Valentina", "quality manager", "smirnova@mail.com", "2761", 20000, 65);
        Employer[] employers = new Employer[]{employer1, employer2, employer3, employer4, employer5};

        for (Employer employer : employers) {
            if (employer.getAge() > 40) employer.printEmployerInfo();
        }
    }
}
