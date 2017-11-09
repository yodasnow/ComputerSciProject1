package bot;
import sx.blah.discord.api.IDiscordClient;
public class MainRunner {

	public static void main(String[] args){
        /**
         * Shop to buy roles with money
         */
        if(args.length != 1){
            System.out.println("Please enter the bots token as the first argument e.g java -jar thisjar.jar tokenhere");
            return;
        }

        IDiscordClient cli = BotUtils.getBuiltDiscordClient(args[0]);

        cli.getDispatcher().registerListener(new MyEvents());

        cli.login();

    }

}