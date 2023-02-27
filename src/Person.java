import java.util.Random;

public class Person
{
    private int birthday;
    private int id;
    private Random rand = new Random();
    Person()
    {
        birthday = (int)(365*rand.nextDouble())+1;
        //id =
    }

    public int getBirthday() {
        return birthday;
    }
}
