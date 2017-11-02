package bot;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gambling{
    int rand = 0;
    private static final String FILENAME = "/Users/_____/git/ComputerSciProject1/src/main/java/bot/money.txt";
    //0:49 - Returns 0
    //50:60 - Returns the same value
    //61:98 - Returns 2 times the value
    //99:100 - Returns 5 times the value
    public String gamble(String user, int money) throws IOException{
        List<String> list = new ArrayList<String>();
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                list.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String[] stringArr = list.toArray(new String[0]);
        //File reading done
        rand = $OO.gambleInt();
        int location = Arrays.asList(stringArr).indexOf(user);
        if (Integer.parseInt(stringArr[location+1]) >= money){

        }
        else{
            return("You do not have enough money");
        }
        if (rand >= 0 && rand <= 49){
            int newBal = Integer.parseInt(stringArr[location+1]);
            newBal -= money;
            String balToSend = String.valueOf(newBal);
            stringArr[location+1] = balToSend;
            $OO.writeToFile(FILENAME, stringArr);
            return("You lost! " + "Your roll was a " + rand + " Your new balance is " + String.valueOf(newBal));
        }
        else if (rand >= 50 && rand <= 60){
            //Do nothing
            return("You did not lose anything! " + "Your roll was a " + rand + " Your balance is the same");
        }
        else if (rand >= 61 && rand <= 98){
            int newBal = Integer.parseInt(stringArr[location+1]);
            newBal = newBal + money;
            String balToSend = String.valueOf(newBal);
            stringArr[location+1] = balToSend;
            $OO.writeToFile(FILENAME, stringArr);
            return("You won! " + "Your roll was a " + rand + " Your new balance is " + String.valueOf(newBal));
        }
        else if (rand >= 99 && rand <= 100){
            int newBal = Integer.parseInt(stringArr[location+1]);
            newBal = newBal + ((int)money*4);
            String balToSend = String.valueOf(newBal);
            stringArr[location+1] = balToSend;
            $OO.writeToFile(FILENAME, stringArr);
            return("You won! " + "Your roll was a " + rand + " Your new balance is " + String.valueOf(newBal));
        }
        return "An error occurred during the code. Please contact <@!285238921204334593>";
    }
    public int bal(String user){
        List<String> list = new ArrayList<String>();
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                list.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String[] stringArr = list.toArray(new String[0]);
        int location = Arrays.asList(stringArr).indexOf(user);
        String bawl = stringArr[location+1];
        return (Integer.parseInt(bawl));
    }
}
