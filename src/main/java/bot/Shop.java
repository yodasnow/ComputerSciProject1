package bot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {
    int roleNum;
    private static final String FILENAME = "/Users/oliver.odendaal/git/ComputerSciProject1/src/main/java/bot/money.txt";
    public boolean rolePurchase(String name, String role) throws IOException{
        roleNum = Integer.parseInt(role);
        //roleNum = Integer.getInteger(role);
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
        int location = Arrays.asList(stringArr).indexOf(name);
        String bal = stringArr[location+1];
        int curBal = Integer.parseInt(bal);
        if (curBal >= roleNum){
            stringArr[location+1] = String.valueOf(curBal - roleNum);
            $OO.writeToFile(FILENAME, stringArr);
            return true;

        }
        return false;
    }
}
