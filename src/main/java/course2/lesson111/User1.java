package course2.lesson111;

public abstract class User1 {
    private int id;
    private String name;
    private int age;
    //private - инкапсуляция - скрытие деталей класса от внешнего мира

    public User1() {

    }

    public User1(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //this - указатель на самого себя


    public User1(int id) {
        this(id, "default name");
    }
    // перегрузка методов - методы с одним именем и разными параметрами (сигнатурами)
    // тип + агрументы (+ тип возвращаемого исключения - может и не быть) = сигнатура


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }
    public int getAgeBefore18(){
        if(age>=18){
            return 0;
        }
        else return 18-age;
    }
    String  info(){
        return this.toString();
    }

    public abstract void doAction();
}
