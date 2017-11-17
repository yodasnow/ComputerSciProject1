package bot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Daily {
    private static final String FILENAME = "/Users/oliver.odendaal/git/ComputerSciProject1/src/main/java/bot/money.txt";
    private static final int DAILYINCREASE = 500;
    public String daily() throws IOException{
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
        for (int i = 1; i < stringArr.length; i+= 2){
            String preBal = stringArr[i];
            int preBalInt = Integer.parseInt(preBal);
            preBalInt += DAILYINCREASE;
            String newBal = String.valueOf(preBalInt);
            stringArr[i] = newBal;
        }
        $OO.writeToFile(FILENAME, stringArr);
        return ("@everyone. You have just been awarded your daily money with a value of $" + String.valueOf(DAILYINCREASE)+ ".");
    }
}
