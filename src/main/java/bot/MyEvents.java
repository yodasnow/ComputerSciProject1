package bot;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;

import java.io.IOException;

public class MyEvents {
    private int fN;
    private int sN;
    private int calcStep = 0;
    private String op;
    private String msg;
    private String msgAuthor;
    private Calculator calc = new Calculator();
    private Gambling gamble = new Gambling();

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) throws IOException{
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
        //This is the gambling code
        else if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "gamble")){
            int bet = Integer.parseInt(event.getMessage().getContent().toString().substring(8));
            BotUtils.sendMessage(event.getChannel(), String.valueOf(gamble.gamble(event.getMessage().getAuthor().toString(), bet)));
        }
        //Checking your bal
        else if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "bal")){
            BotUtils.sendMessage(event.getChannel(), "Your balance " + event.getAuthor().toString() + " is " + String.valueOf(gamble.bal(event.getAuthor().toString())));
        }
        //Get your id
        else if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "findmyid")){
            BotUtils.sendMessage(event.getChannel(), "Your id is " + event.getAuthor().toString().substring(3, 21));
            $OO.println("An ID to add to money.txt is " + event.getAuthor().toString());
        }
    }

}