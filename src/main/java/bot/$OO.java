package bot;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * This class is my tools class where I will make
 * and demonstrate various skills
 * @author oliver.odendaal
 */
public class $OO {
    /**
     * This method prints out str with a new line to the console
     * @param str
     */
    public static void println(String str){
        System.out.println(str);
    }

    /**
     * This method prints out str to the console
     * @param str
     */
    public static void print(String str){
        System.out.print(str);
    }

    /**
     * This method pauses the code for the specified time in milliseconds
     * @param delay
     */
    public static void pause(int delay){
        try{
            Thread.sleep(delay);
        }
        catch(Exception e){

        }
    }

    //public static
    /**
     * This method returns a random int from 0 - 100
     * @return
     */
    public static int gambleInt(){
        Random rand = new Random();
        return (rand.nextInt(101));
    }
    /**
     * This method sends the message str to the Discord channel
     * @param event
     * @param str
     */
    //public static void discordSendMsg(Event event, String str){
    //    BotUtils.sendMessage(MessageReceivedEvent.getClient().getChannelByID(369873891830792194L), "Test");
    //}

    /**
     * This method will create or overwrite file "fileName.txt" with each element from the Array data
     * @param fileName
     * @param data
     */
    public static void writeToFile(String fileName, String[] data) throws IOException{
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < data.length; i ++){
            pw.println(data[i]);
        }
        pw.close();
    }

} //End class
