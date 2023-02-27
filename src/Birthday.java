/**
 * This program simulates the famous "Birthday Paradox"
 * Prints the percentage to the console
 *
 * @author Alexander Mortillite
 */
import java.util.ArrayList;

public class Birthday
{
    public static void main(String[] args)
    {
        int classSize = 23;                         //Number of people in the class
        int count = 0;                              //Records the number of times that two people have the same birthday
        int timesRan = 1000000;                     //Records the number of times that the simulation is going to loop
        Birthday Bday = new Birthday();             //Creates a Birthday Object to avoid static methods
        for(int i = 0; i< timesRan;i++)
            if(Bday.testLoop(classSize) == true)       //I use a return value of true
                count++;                            //Increment the count variable

        System.out.println(((double)count/(double)timesRan)*100 +"%"); // Print the percentage
    }

    /**
     *
     * @param classSize Size of the class of people
     * @return This return is used as a singal
     */
    public boolean testLoop(int classSize)
    {
        boolean match = false;
        ArrayList<Person> classroom = new ArrayList<>();
        for(int i = 0; i<classSize; i++)
            classroom.add(new Person());

        if(hasBirthday(classroom))
            match = true;

        return match;
    }

    public boolean hasBirthday(ArrayList<Person> classroom)
    {
        boolean output = false;               //Sets the default return to false
        for(int i = 0; i < classroom.size(); i++)
            for(int j = 0; j < classroom.size(); j++)
                if((classroom.get(i).getBirthday() == classroom.get(j).getBirthday()) && (i != j))
                {
                    output = true;             //Sets the return statement = true
                    i = classroom.size();      //These two lines are added so the nested for loop exits early
                    j = classroom.size();      //refer previous
                }

        return output;
    }
}