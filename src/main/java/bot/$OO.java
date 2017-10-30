package bot;
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
    /**
     * This method prints out str to the Discord channel
     * @param str
     */
    public static void discordSendMsg(String str){
        BotUtils.sendMessage(MessageReceivedEvent.getClient().getChannelByID(369873891830792194L), "Test");
    }

} //End class
