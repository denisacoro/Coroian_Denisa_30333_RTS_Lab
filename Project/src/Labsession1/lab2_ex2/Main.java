package Labsession1.lab2_ex2;

public class Main {
    private static final int noOfThreads = 6;
    private static final int processorLoad = 1000000;

    public static void main(String[] args) {
        Model model = new Model(noOfThreads);
        View view = new View(model, noOfThreads);
        Controller controller = new Controller(model, noOfThreads, processorLoad);
        controller.startThreads();
    }
}
