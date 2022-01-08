package course2.homework1;

public class Wall implements Barrier {
    String material;
    int height;

    public Wall() {
        this.material = "Brick";
        this.height = 3;
    }

    public Wall(String material, int height) {
        this.material = material;
        this.height = height;
    }

    @Override
    public void takeBarrier(Object object) {
        if (object instanceof Human) {
            ((Human) object).doJump();
            System.out.println("Failed to jump over!");
        } else if (object instanceof Cat) {
            ((Cat) object).doJump();
            System.out.println("Jumped over the wall successfully!");
        } else if (object instanceof Robot) {
            ((Robot) object).doJump();
            System.out.println("Jumped over the wall successfully!");
        }
    }

    public boolean canManage(Object object) {
        if (object instanceof Human) {
            return ((Human) object).getJumpHeight() >= this.height;
        } else if (object instanceof Cat) {
            return ((Cat) object).getJumpHeight() >= this.height;
        } else if (object instanceof Robot) {
            return ((Robot) object).getJumpHeight() >= this.height;
        }
        return false;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return this.material + " wall";
    }
}
