package homework5;

public class Employer {
    String name;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Employer(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    /**
     * Выводит на экран информацию о сотруднике
     */
    public void printEmployerInfo() {
        System.out.println(
                "ФИО: " + name + "\n" +
                "Должность: " + position + "\n" +
                "E-mail: " + email + "\n" +
                "Номер телефона: " + phoneNumber + "\n" +
                "Оклад: " + salary + "\n" +
                "Возраст: " + age + "\n");
    }

    public int getAge() {
        return age;
    }
}
