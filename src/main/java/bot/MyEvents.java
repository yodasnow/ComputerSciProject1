package bot;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class MyEvents {
    private int fN;
    private int sN;
    private int calcStep = 0;
    private String op;
    private String msg;
    private String msgAuthor;
    private Calculator calc = new Calculator();

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event){
        //This is the calculator code
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "calc")){
            calcStep = 1;
            msgAuthor = event.getAuthor().toString();
            msg = event.getMessage().getContent();
            BotUtils.sendMessage(event.getChannel(), "You have now entered the calculator mode, please input the first value.");
        }
        else if(event.getMessage().getAuthor().toString().equals(msgAuthor) && calcStep == 1){
            System.out.println("The code reached the next step");
            calcStep = 2;
            msg = event.getMessage().getContent();
            fN = Integer.parseInt(msg);
            BotUtils.sendMessage(event.getChannel(), "Your first value has been recieved, please input the second value.");
        }
        else if(event.getMessage().getAuthor().toString().equals(msgAuthor) && calcStep == 2){
            calcStep = 3;
            msg = event.getMessage().getContent();
            sN = Integer.parseInt(msg);
            BotUtils.sendMessage(event.getChannel(), "Your second value has been recieved, please input the operator.");
        }
        else if(event.getMessage().getAuthor().toString().equals(msgAuthor) && calcStep == 3){
            calcStep = 0;
            msg = event.getMessage().getContent();
            op = msg;
            BotUtils.sendMessage(event.getChannel(), String.valueOf(fN) + " " + String.valueOf(op) + " " + String.valueOf(sN) + " " + "equals" + " " + String.valueOf(calc.calculate(op, fN, sN)));
        }
    }

}