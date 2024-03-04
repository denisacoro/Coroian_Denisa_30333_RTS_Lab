package Labsession1.lab2_ex2;

import java.util.Observable;

public class Model extends Observable {
    private int[] progressValues;

    public Model(int noOfThreads) {
        progressValues = new int[noOfThreads];
    }

    public void setProgressValue(int id, int val) {
        progressValues[id] = val;
        setChanged();
        notifyObservers(id);
    }

    public int getProgressValue(int id) {
        return progressValues[id];
    }
}