/**
 * Program that creates a graph and runs through prims mst
 * @author Cole Paulline
 */
public class Program4{
    public static void main (String[] args){

        //shows an opening message for the program and options to choose from
        System.out.println("\nPrims MST \nBy: Cole P \n");
        System.out.println("1) tinyEWG");
        System.out.println("2) mediumEWG");
        System.out.println("3) 1000EWG");
        System.out.println("4) 10000EWG");

        //creates the command prompt sequence
        Choose choose = new Choose();
        choose.run();
    }
}