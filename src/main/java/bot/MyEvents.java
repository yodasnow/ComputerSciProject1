package bot;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.IShard;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.audio.IAudioManager;
import sx.blah.discord.handle.audit.ActionType;
import sx.blah.discord.handle.audit.AuditLog;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.*;
import sx.blah.discord.util.Ban;
import sx.blah.discord.util.Image;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class MyEvents {
    private int fN;
    private int sN;
    private int calcStep = 0;
    private int purchaseStep = 0;
    private String op;
    private String msg;
    private String msgAuthor;
    private Calculator calc = new Calculator();
    private Gambling gamble = new Gambling();
    private MiskewCommands mcmds = new MiskewCommands();
    private Shop shop = new Shop();

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
            try{
                int bet = Integer.parseInt(event.getMessage().getContent().toString().substring(8));
                BotUtils.sendMessage(event.getChannel(), String.valueOf(gamble.gamble(event.getMessage().getAuthor().toString(), bet)));
            }
            catch (StringIndexOutOfBoundsException e){
                BotUtils.sendMessage(event.getChannel(), "Please put in a value");
            }
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
        //Link to help channel
        else if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "help")){
            BotUtils.sendMessage(event.getChannel(), "Please visit this channel <#373111723722407937>");
            $OO.pause(200);
            BotUtils.sendMessage(event.getChannel(), "If you have any more questions message <@!285238921204334593>");
        }
        //Money roles
        else if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "purchase") && purchaseStep == 0){
            purchaseStep = 1;
            BotUtils.sendMessage(event.getChannel(), "Please select which role you would like to purchase.");
            $OO.pause(200);
            BotUtils.sendMessage(event.getChannel(), "You can choose from: $1000, $5000, $10000, $20000, $50000.");
            $OO.pause(200);
            BotUtils.sendMessage(event.getChannel(), "Please reply with just the number of the role you would like to purchase.");
        }
        else if(event.getMessage().getContent().startsWith("1000") && purchaseStep == 1){
            purchaseStep = 0;
            String strRole = event.getMessage().getContent().toString();
            BotUtils.sendMessage(event.getChannel(), "Processing request...");
            $OO.pause(200);
            if(shop.rolePurchase(event.getAuthor().toString(), strRole) == true){
                event.getAuthor().addRole(event.getGuild().getRoleByID(377524546619703297L));
                BotUtils.sendMessage(event.getChannel(), "You have purchased the role " + event.getAuthor());
            }
            else{
                BotUtils.sendMessage(event.getChannel(), "You do not have enough money to purchase that.");
            }
        }
        else if(event.getMessage().getContent().startsWith("5000") && purchaseStep == 1){
            purchaseStep = 0;
            String strRole = event.getMessage().getContent().toString();
            BotUtils.sendMessage(event.getChannel(), "Processing request...");
            $OO.pause(200);
            if(shop.rolePurchase(event.getAuthor().toString(), strRole) == true){
                event.getAuthor().addRole(event.getGuild().getRoleByID(377524569478660106L));
                BotUtils.sendMessage(event.getChannel(), "You have purchased the role " + event.getAuthor());
            }
            else{
                BotUtils.sendMessage(event.getChannel(), "You do not have enough money to purchase that.");
            }
        }
        else if(event.getMessage().getContent().startsWith("10000") && purchaseStep == 1){
            purchaseStep = 0;
            String strRole = event.getMessage().getContent().toString();
            BotUtils.sendMessage(event.getChannel(), "Processing request...");
            $OO.pause(200);
            if(shop.rolePurchase(event.getAuthor().toString(), strRole) == true){
                event.getAuthor().addRole(event.getGuild().getRoleByID(377524609425080325L));
                BotUtils.sendMessage(event.getChannel(), "You have purchased the role " + event.getAuthor());
            }
            else{
                BotUtils.sendMessage(event.getChannel(), "You do not have enough money to purchase that.");
            }
        }
        else if(event.getMessage().getContent().startsWith("20000") && purchaseStep == 1){
            purchaseStep = 0;
            String strRole = event.getMessage().getContent().toString();
            BotUtils.sendMessage(event.getChannel(), "Processing request...");
            $OO.pause(200);
            if(shop.rolePurchase(event.getAuthor().toString(), strRole) == true){
                event.getAuthor().addRole(event.getGuild().getRoleByID(377524635924824065L));
                BotUtils.sendMessage(event.getChannel(), "You have purchased the role " + event.getAuthor());
            }
            else{
                BotUtils.sendMessage(event.getChannel(), "You do not have enough money to purchase that.");
            }
        }
        else if(event.getMessage().getContent().startsWith("50000") && purchaseStep == 1){
            purchaseStep = 0;
            String strRole = event.getMessage().getContent().toString();
            BotUtils.sendMessage(event.getChannel(), "Processing request...");
            $OO.pause(200);
            if(shop.rolePurchase(event.getAuthor().toString(), strRole) == true){
                event.getAuthor().addRole(event.getGuild().getRoleByID(377524660780400640L));
                BotUtils.sendMessage(event.getChannel(), "You have purchased the role " + event.getAuthor());
            }
            else{
                BotUtils.sendMessage(event.getChannel(), "You do not have enough money to purchase that.");
            }
        }
        //Michael !sauce command
        else if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "sauce")){
            int times = Integer.parseInt(event.getMessage().getContent().toString().substring(7));
            if (times <= 10){
                for (int i = 0; i < times; i++){
                    BotUtils.sendMessage(event.getChannel(), "DEUS VULT INFIDEL");
                }
            }
        }
        //Money give to Mr. Miskew
        else if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "moneygive")){
            if (event.getAuthor().toString().equals("<@!377900189312352259>") || event.getAuthor().toString().equals("<@!285238921204334593>")){
                int moneyAmount = Integer.parseInt(event.getMessage().getContent().substring(11));
                BotUtils.sendMessage(event.getChannel(), mcmds.moneyGive(moneyAmount));
            }
        }
        //Show information about the event
        else if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "eventinfo")){
            BotUtils.sendMessage(event.getChannel(), "Info has been sent to the console");
            $OO.println("Author");
            $OO.println(event.getAuthor().toString());
            $OO.println("Channel");
            $OO.println(event.getChannel().toString());
        }
    }

}