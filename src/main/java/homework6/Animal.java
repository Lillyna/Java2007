package homework6;

public class Animal {
        String name;
        int runability;

        public Animal(String name, int runDistance) {
            this.name = name;
            this.runability = runDistance;
        }

        void run(int distance) {
            if (distance <= this.runability && distance > 0) {
                System.out.println(this.name + " пробежал " + distance + " м.");
            } else if (distance > this.runability) {
                System.out.println(this.name + " пробежал " + this.runability + " м и умер.");
            } else {
                System.out.println(this.name + " никуда не бежит, потому что ленивый.");
            }

        }

        void swim(int distance) {
            System.out.println(this.name + " проплыл " + distance + " м.");
        }
    }
