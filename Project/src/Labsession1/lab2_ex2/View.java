package Labsession1.lab2_ex2;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class View extends JFrame implements Observer {
    private Model model;

    public View(Model model, int nrThreads) {
        this.model = model;
        model.addObserver(this);

        setLayout(null);
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init(nrThreads);
        setVisible(true);
    }

    private void init(int n) {
        for (int i = 0; i < n; i++) {
            JProgressBar pb = new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(50, (i + 1) * 30, 350, 20);
            add(pb);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        int id = (int) arg;
        int val = model.getProgressValue(id);
        ((JProgressBar) getContentPane().getComponent(id)).setValue(val);
    }
}