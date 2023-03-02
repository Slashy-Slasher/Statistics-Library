/**
 * This program simulates the famous "Birthday Paradox"
 * Prints the percentage to the console
 * In order to make sure the percentage is accurate the simulation runs "timesRan" which is by default set to 1000000
 *
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

        System.out.println("The probability of 2 people having the same birthday in a group of " + classSize + " is " + ((double)count/(double)timesRan)*100 +"%"); // Print the percentage
    }

    /**
     * This method is the engine behind this simulation, this method takes a classSize in int form and returns whether
     * the class has two people with identical birthdays to the main method
     * It takes the classSize and generates an ArrayList of type Person to send to the hasBirthday Method
     * For this method to work there is a sub method called hasBirthday() this method is required
     *
     *
     * @param classSize Size of the class of people
     * @return Returns true if two people have the same birthday, false otherwise
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

    /**
     *
     * This is supporting method for the testLoop Method it purpose is to return true or false to the test loop
     * It is a nested for loop that compares the birthdays of every Person Object in the ArrayList classroom
     *
     * @param classroom
     * @return Returns true if two people have the same birthday, false otherwise
     */

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