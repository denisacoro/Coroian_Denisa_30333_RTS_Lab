package Labsession1.lab2_ex2;

public class Controller {
    private Model model;
    private int noOfThreads;
    private int processorLoad;

    public Controller(Model model, int noOfThreads, int processorLoad) {
        this.model = model;
        this.noOfThreads = noOfThreads;
        this.processorLoad = processorLoad;
    }

    public void startThreads() {
        for (int i = 0; i < noOfThreads; i++) {
            // new Fir(i, i + 2, model, processorLoad).start();
        }
    }
}