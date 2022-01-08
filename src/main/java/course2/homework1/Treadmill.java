package course2.homework1;

public class Treadmill implements Barrier{
    String brand;
    int length;

    public Treadmill(){
        this.brand = "Yamaguchi";
        this.length = 2;
    }

    public Treadmill(String brand, int length){
        this.brand = brand;
        this.length = length;
    }
    @Override
    public void takeBarrier(Object object){
        if(object instanceof Human){
            ((Human) object).doRun();
            System.out.println("Running on a treadmill!");
        }
        else if (object instanceof Cat){
            ((Cat) object).doRun();
            System.out.println("Failed to run on a treadmill!");
        }
        else if (object instanceof Robot){
            ((Robot) object).doRun();
            System.out.println("Running on a treadmill!");
        }
    };

    public boolean canManage(Object object){
        if(object instanceof Human){
            return ((Human)object).getRunDistance()>=this.length;
        }
        else if (object instanceof Cat){
            return ((Cat)object).getRunDistance()>=this.length;
        }
        else if (object instanceof Robot){
            return ((Robot)object).getRunDistance()>=this.length;
        }
       return false;
    }

    public int getLength() {
        return length;
    }
    public String toString(){
        return "Treadmill " + this.brand;
    }
}
