package course2.lesson11;

import java.time.LocalDate;

public class Employee {
    private final long id;


    public Employee(long id, String firstname, String lastname) {
        this.id = id;

    }

    public long getId() {
        return id;
    }


    public Employee (Builder builder){
        this.id = builder.id;

    }
    public static class Builder{
        private  long id;
        private  String firstname;
        private  String lastname;
        private  LocalDate birthdate;
        private  LocalDate start;
        private  LocalDate leave;
        private  String email;
        private  String department;
        private  Employee manager;
        private  Double coef;
        private  Double salary;
        private  String position;

        public Builder id(long id) {
            this.id = id;
            return this;
        }



        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder birthdate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Builder setStart(LocalDate start) {
            this.start = start;
            return this;
        }

        public Builder setLeave(LocalDate leave) {
            this.leave = leave;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public Builder setManager(Employee manager) {
            this.manager = manager;
            return this;
        }

        public Builder setCoef(Double coef) {
            this.coef = coef;
            return this;
        }

        public Builder setSalary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

    }
}
