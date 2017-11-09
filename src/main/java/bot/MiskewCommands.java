package bot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiskewCommands {
    private static final String FILENAME = "/Users/oliver.odendaal/git/ComputerSciProject1/src/main/java/bot/money.txt";
    private static final String USER = "<@!377900189312352259>";
    public String moneyGive(int amount) throws IOException{
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
        int location = Arrays.asList(stringArr).indexOf(USER);
        String curBal = stringArr[location+1];
        int newBal = Integer.parseInt(curBal);
        newBal += amount;
        String balChange = String.valueOf(newBal);
        stringArr[location+1] = balChange;
        $OO.writeToFile(FILENAME, stringArr);
        return ("Completed the task and gave <@!377900189312352259> $" + String.valueOf(amount));
    }
}
