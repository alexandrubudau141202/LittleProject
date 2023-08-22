package ControlUNIT;

public class ControlUnit {
    public static void main(String[] args) throws InterruptedException{
        OperatingThreads initiateProgram = new OperatingThreads();
        initiateProgram.startCar();
        Thread.sleep(1500);

        OperatingThreads afterStart = new OperatingThreads();
        afterStart.afterStartShowWelcomePage();
        Thread.sleep(1000);
    }
}
