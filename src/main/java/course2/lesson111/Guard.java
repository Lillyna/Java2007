package course2.lesson111;

public class Guard {
    boolean canPass(User1 user1){
        return user1.getAgeBefore18() == 0;
    }
}
