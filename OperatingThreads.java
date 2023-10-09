package ControlUNIT.MyCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OperatingThreads extends Thread{
    Car newCar = new Car();
    User AlexandruUser = new User();
    public void startCar() throws InterruptedException {
        newCar.setName("Audi");
        System.out.println("Welcome");
        Thread.sleep(950);
        System.out.println("to");
        Thread.sleep(950);
        System.out.println(newCar.getName());
    }
    public void afterStartShowWelcomePage() throws InterruptedException{
        String showPage = "What do you want to do today?";
        System.out.println(showPage);
        afterStartMenu();
    }

    //methods to be implemented for the first list's thread

    private double speed;
    public void setSpeed(double speed){
        this.speed = speed;
    }
    private double getSpeed(){
        return speed;
    }
    private void forDriving() throws InterruptedException{
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Car started, now driving");
        System.out.println("Setting a cruising speed");
        this.setSpeed(newScanner.nextDouble());
        if(this.getSpeed() > 130){
        Thread.sleep(950);
        System.out.println("Warning!!!! " + this.getSpeed() + " Exceeds limit speed, reduce pace!");
        }
        else{
            Thread.sleep(500);
            System.out.println("Ok, setting speed to " + this.getSpeed());
        }
        Thread.sleep(950);
    afterStartShowWelcomePage();
    }

    ArrayList<String> listOfProblems = new ArrayList<>();
    private void forRevision() throws InterruptedException{
        Scanner scanToCheck = new Scanner(System.in);
        listOfProblems.add("Oil");
        listOfProblems.add("Engine");
        listOfProblems.add("Cooling");
        listOfProblems.add("Emission");
        listOfProblems.add("Electronics");
        listOfProblems.add("Battery");
        listOfProblems.add("Steering");
        listOfProblems.add("Tyre pressure");
        for(int i = 0; i < listOfProblems.size(); i++){
            System.out.println(listOfProblems.get(i));
            Thread.sleep(550);
        }
        Thread.sleep(450);
        System.out.println("Check eventual problems?");
        String checking = scanToCheck.next();
        if(checking.equalsIgnoreCase("yes")){
            Thread.sleep(450);
            System.out.println("What's the car's mileage?");
            newCar.setKmaj(scanToCheck.nextInt());
            Thread.sleep(500);
            System.out.println("Ok, given the " + newCar.getKmaj() + " km");
            Thread.sleep(350);
            System.out.println("The most common problem is provided by: ");
            Thread.sleep(550);
            if(newCar.getKmaj() > 100000 && newCar.getKmaj() < 150000){
                Thread.sleep(450);
                System.out.println(listOfProblems.get(2));
            }
            else if(newCar.getKmaj() > 150000 && newCar.getKmaj() < 200000){
                Thread.sleep(450);
                System.out.println(listOfProblems.get(4));
            }
            else if(newCar.getKmaj() > 200000){
                Thread.sleep(450);
                System.out.println(listOfProblems.get(1));
            }
        }
        Thread.sleep(450);
        afterStartShowWelcomePage();
    }

    String airConditioning = "";
    private void forsettingAC() throws InterruptedException{
        try (Scanner newScanner = new Scanner(System.in)) {
            System.out.println("Want to set Ac On or Off?");
            airConditioning = newScanner.next();
            if(airConditioning.equalsIgnoreCase("On")){
                System.out.println("Air conditioning is on");
                Thread.sleep(500);
                System.out.println("Auto or manual?");
                String autoORManual = newScanner.next();
                if(autoORManual.equalsIgnoreCase("Auto")){
                    System.out.println(autoORManual.toUpperCase() + " air conditioning, enjoy your journey");
                    Thread.sleep(500);
                } else if(autoORManual.equalsIgnoreCase("manual")){
                    System.out.println("Set a temperature");
                    int temperature =newScanner.nextInt();
                    if(temperature > 18 && temperature < 22){
                        Thread.sleep(450);
                        System.out.println("It must be hot outside");
                        System.out.println("Temperature set to " + temperature);
                        Thread.sleep(450);
                    }
                    else if(temperature > 22){
                        Thread.sleep(450);
                        System.out.println("Must be cold outside");
                        System.out.println("Temperature set to " + temperature);
                    }
                    System.out.println(autoORManual.toUpperCase() + " air conditioning, enjoy your journey");
                    Thread.sleep(500);
                }
            }
            else if(airConditioning.equalsIgnoreCase("Off")){
                System.out.println("Air Conditioning is " + airConditioning);
            }
        Thread.sleep(950);
        afterStartShowWelcomePage();
        }
    }


    // --------------------
    public void afterStartMenu() throws InterruptedException {
        try (Scanner newScanner = new Scanner(System.in)) {
            String[] actions = {"Drive", "Revision", "Set AC", "Others..."};
            for (int i = 0; i < actions.length; i++){
                System.out.println(actions[i]);
                Thread.sleep(450);
            }
            String cmd = newScanner.next();
            String[] listActions = {"System Preferences","Radio","Media","Phone"};
            if(cmd.equalsIgnoreCase("drive")){
                forDriving();
            } else if(cmd.equalsIgnoreCase("revision")){
                forRevision();
            } else if(cmd.equalsIgnoreCase("AC")){
                forsettingAC();
            }
            if (cmd.equalsIgnoreCase("others")){
                System.out.println("Ok, here's a list with other actions");
                for (int i = 0; i < listActions.length; i++){
                    System.out.println(listActions[i]);
                    Thread.sleep(500);
                }
                System.out.println("Choose now");
                String comand = newScanner.next();
                switch(comand){
                    case "System Preferences":
                        Thread.sleep(450);
                        System.out.println(comand);
                        enterSysPref();
                        break;
                    case "Radio":
                        Thread.sleep(450);
                        System.out.println(comand);
                        useRadio();
                        break;
                    case "Media":
                        Thread.sleep(450);
                        System.out.println(comand);
                        useMedia();
                        break;
                    case "Phone":
                        Thread.sleep(450);
                        System.out.println(comand);
                        usePhone();
                        break;
                }
            }
            else{
                System.out.println("Ok, bye have a nice day :))");
                System.exit(0);
            }
        }
    }

    private void enterSysPref() throws InterruptedException{
        String[] List = {"Equalizer", "Trip", "Theme and Appereance"};
        for(int i = 0; i < List.length; i++){
            System.out.println(List[i]);
            Thread.sleep(500);
        }
        System.out.println("Choose now");
        Scanner someNewScanner = new Scanner(System.in);
        String actionToBe = someNewScanner.nextLine();
        switch (actionToBe) {
            case "Equalizer" -> {
                System.out.println("Using " + actionToBe.toUpperCase());
                String equalList[] = {"Highs", "Mids", "Lows"};
                for (int i = 0; i < equalList.length; i++) {
                    System.out.println(equalList[i]);
                }
                int values;
                System.out.println("Set the values for " + equalList[0]);
                values = someNewScanner.nextInt();
                Thread.sleep(500);
                System.out.println("Highs: " + values);
                Thread.sleep(500);
                System.out.println("Set the values for " + equalList[1]);
                values = someNewScanner.nextInt();
                Thread.sleep(500);
                System.out.println("Mids: " + values);
                Thread.sleep(500);
                System.out.println("Set the values for " + equalList[2]);
                values = someNewScanner.nextInt();
                Thread.sleep(500);
                System.out.println("Lows: " + values);
                Thread.sleep(500);
            }
            case "Trip" ->
                    System.out.println("You've already beaten the " + (newCar.getKmaj() - (150000 * 2.5)) + " mark");
            case "Theme" -> {
                String darkLight = someNewScanner.next();
                if (darkLight.equalsIgnoreCase("Dark")) {
                    System.out.println("Theme set to " + darkLight.toUpperCase());
                }
                if (darkLight.equalsIgnoreCase("Light")) {
                    System.out.println("Theme set to " + darkLight.toUpperCase());
                }
            }
        }
        Thread.sleep(950);
        afterStartShowWelcomePage();
    }


    private void usePhone() throws InterruptedException{
        String[] actions = {"Call", "Text", "Voicemail", "BACK"};
        
        System.out.println("Select an action");
        for(int i = 0; i < actions.length; i++){
            System.out.println(actions[i]);
            Thread.sleep(250);
        }
        Scanner someScanner = new Scanner(System.in);
        String actionUsed = someScanner.next();
        System.out.println("You have chosen " + actionUsed);
        String contact;
        if(actionUsed.equalsIgnoreCase("call")){
            System.out.println("Who do you want to call");
            contact = someScanner.next();
            Thread.sleep(450);
            System.out.println("Ok, calling " + contact);
            Thread.sleep(450);
            usePhone();
        }
        if(actionUsed.equalsIgnoreCase("Text")){
            System.out.println("Use your voice, or type some text");
            String someText = someScanner.next();
            Thread.sleep(450);
            System.out.println("Type contact to receive the message");
            contact = someScanner.next();
            Thread.sleep(450);
            System.out.println("Wanna send message: " + someText + " to "+ contact + "?");
            String cmd = someScanner.next();
            switch(cmd){
                case "yes":
                System.out.println("Sending message");
                for(int i = 0; i < 3; i ++){
                    System.out.println(i);
                    Thread.sleep(450);
                }
                System.out.println("Sent " + someText + " to " + contact);
                break;

                case "no":
                System.out.println("Unsending message...");
                usePhone();
                break;
            }
        }
        if(actionUsed.equalsIgnoreCase("VoiceMail")){
            Thread.sleep(500);
            System.out.println("There are no messages left in your voicemail");
            usePhone();
        }
        if(actionUsed.equalsIgnoreCase("Back")){
            System.out.println("Going back to home menu");
            afterStartShowWelcomePage();
        }
    }

    private void useRadio() throws InterruptedException{
        try (Scanner setFrequency = new Scanner(System.in)) {
            System.out.println("Set a frequency");
            double frequency = setFrequency.nextDouble();
                /*
                 * 90.0 = ProFM
                 * 107.8 = ProFm
                 * 95.0 = KissFm
                 * 101.0 = RadioZu
                 */
                if(frequency > 87.50 && frequency < 90.0){
                    System.out.println("You are now listening to ProFM(part1) " + frequency);
                } else if(frequency > 90.0 && frequency <= 95.0){
                    System.out.println("You are now listening to KissFm " + frequency);
                } else if(frequency > 95.0 && frequency <= 108.0){
                    System.out.println("You are now listening to ProFM(part2) " + frequency);
                }
                else{
                    while(frequency < 87.50 || frequency > 108.0){
                    System.out.println("Frequency not supported");
                    frequency = setFrequency.nextDouble();
                    }
                }
                Thread.sleep(500);
                afterStartShowWelcomePage();
        }
    }

    private void useMedia() throws InterruptedException {
        System.out.println("Playing media via: ");
        String[] connections = {"Bluetooth", "CD", "AUX"};
        for(int i = 0; i < connections.length; i++){
            Thread.sleep(500);
            System.out.println(connections[i]);
        }
        try (Scanner anotherScanner = new Scanner(System.in)) {
            String command = anotherScanner.next();
            System.out.println("You are connected via: " + command);
            Thread.sleep(970);
            System.out.println("Now playing from Car's " + command);
            Thread.sleep(950);
            if (command.equalsIgnoreCase("bluetooth")){
                useBluetooth();
            } else if(command.equalsIgnoreCase("CD")){
                useCD();
            }
            else{
                useAUX();
            }
            Thread.sleep(500);
            afterStartShowWelcomePage();
        }
    }
    private void useBluetooth() throws InterruptedException {
        Scanner appsScanner = new Scanner(System.in);
        System.out.println(AlexandruUser.getName() +  " bluetooth is connected");
        String[] appsBT = {"Spotify", "YTMusic", "AppleMusic", "Other"};
        System.out.println("What's the app you're using for music streaming?");
        for(int i = 0; i < appsBT.length; i++){
            Thread.sleep(450);
            System.out.println(appsBT[i]);
        }
        String appsCmd = appsScanner.next();
        switch(appsCmd){
            case "Spotify":
                Thread.sleep(450);
                System.out.println("Choose your playlist");
                String playlistCmd = "Polske";
                Thread.sleep(450);
                AlexandruUser.setName("ohmyalexxu");
                System.out.println("Playing " + playlistCmd + " by " + AlexandruUser.getName());
                break;
            case "YTMusic":
                Thread.sleep(450);
                System.out.println("Account:");
                Thread.sleep(450);
                System.out.println(AlexandruUser.getName());
                Thread.sleep(450);
                break;
            case"AppleMusic":
                System.out.println("Apple music is crap!!");
                break;
            case "Other":
                System.out.println("G there is no other application, get outta here");
                System.exit(0);
                break;
            default:
                System.out.println("Playing from " + AlexandruUser.getName() + "'s libraries");
        }
    }
    private void useCD() throws InterruptedException{
        Scanner choosing = new Scanner(System.in);
        System.out.println("Playing: Caseta 13 - Cântec 2 - Fac Deranj - Tzanca Uraganu");
        Thread.sleep(500);
        System.out.println("Playing: Disk 13 - Song 14 - La inima m-ai ars - Florin Salam");
        Thread.sleep(500);
        System.out.println("Disk ended, restart?");
        String chooseYesOrNo = choosing.next();
        if(chooseYesOrNo.equalsIgnoreCase("yes")){
            useCD();
        }
        else{
            System.out.println("Ok");
            Thread.sleep(500);
            afterStartShowWelcomePage();
        }
    }
    private void useAUX(){
        System.out.println("User Auxiliary Cable for audio input is in");
    }


}
