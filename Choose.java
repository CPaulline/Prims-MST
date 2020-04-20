import java.util.Scanner;

/**
 * command prompt for the program to make program easier to use with preset files
 */
public class Choose {
    private boolean exitflag;
    private GraphHelper h;

    /**
     * ctor for the class to set exit flag to false and create helper object
     */
    public Choose(){
        exitflag = false;
        h = new GraphHelper();

    }

    /**
     * runs the console that is being outputted and scanned for input
     */
    public void run(){
        //creates scanner for input
        Scanner scanner = new Scanner(System.in);

        //while exit flag isn't flagged the program keeps running
        while(!exitflag){
            String cmd = getUserValue(scanner);
            execCommand(cmd, scanner);
        }
        scanner.close();
    }

    /**
     * takes what the scanner gets and trims it down from all spaces
     * @param scanner being used in the program for input
     * @return a command without spaces
     */
    private String getUserValue(Scanner scanner){
        String cmd = scanner.nextLine();
        cmd = cmd.trim();
        return cmd;
    }

    /**
     * has all typed commands for specific files to be read and performed on
     * @param cmd the command that wa typed
     * @param scanner the scanner being used for input
     */
    private void execCommand(String cmd, Scanner scanner){
        if(cmd.isEmpty()){return;}

        switch(cmd){
            case "1": //for the tinyEWG file
                Graph210 g = h.readGraphFile("data/tinyEWG.txt");
                h.writeFile(h.prims(g, 0));
                System.out.println("\nLoading tinyEWG...");
                break;

            case "2": //for the mediumEWG file
                Graph210 c = h.readGraphFile("data/mediumEWG.txt");
                h.writeFile(h.prims(c, 0));
                System.out.println("\nLoading mediumEWG...");
                break;

            case "3": //for the 1000EWG file
                Graph210 d = h.readGraphFile("data/1000EWG.txt");
                h.writeFile(h.prims(d, 0));
                System.out.println("\nLoading 1000EWG...");
                break;

            case "4": //for the 10000EWG file
                Graph210 v = h.readGraphFile("data/10000EWG.txt");
                h.writeFile(h.prims(v, 0));
                System.out.println("\nLoading 10000EWG...");
                break;

            case "exit": //to exit the program
                System.out.println("Exiting...");
                exitflag = true;
                break;

            default: //for if a command is not recogized
                System.out.println("Unknown Command = " + cmd);
                break;
        }
    }
}