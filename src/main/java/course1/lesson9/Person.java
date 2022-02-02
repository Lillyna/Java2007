package course1.lesson9;

public class Person {
    private final String name;
    private final int age;
    private final String position;
    private final double salary;

    public void info(){
        System.out.println(this);
    }


    public static Builder builder(){
        return new Builder();
    }
    private Person (Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.position = builder.position;
        this.salary = builder.salary;
    }

    public Builder fromPerson(Person person){
        return new Builder().withSalary(person.salary).withAge(Person.builder().age).withName(person.name);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * static - для создания билдера не нужно создавать Person, он сам по себе
     */
    public static class Builder{
        private String name;
        private int age;
        private String position;
        private double salary;

        /**
         * по сути это сеттер
         * @param name
         */
        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withAge(int age){
            this.age = age;
            return this;
        }

        public Builder withSalary(double salary){
            this.salary = salary;
            return this;
        }
        public Person build(){
            return new Person(this);
        }
    }
}
