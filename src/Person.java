/**
 * This class represents a person whose birthday has an even chance of being any day of the year, except leap years
 * The constructor for this class sets the object's birthday to a random number between 1 and 365
 *
 * @author Alexander Mortillite
 */
public class Person
{
    private int birthday;
    Person() {
        birthday = (int)(365*Math.random())+1;
    }

    /**
     * Returns the birthday
     * @return birthday
     */
    public int getBirthday() {
        return birthday;
    }
}
