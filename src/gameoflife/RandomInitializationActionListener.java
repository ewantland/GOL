
package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
 
import gameoflife.GameOfLifeModel;
import gameoflife.GameOfLifeFrame;
 
public class RandomInitializationActionListener implements ActionListener {
 
    private GameOfLifeFrame frame;
     
    private GameOfLifeModel model;
     
    private Random random;
 
    public RandomInitializationActionListener(GameOfLifeFrame frame,
            GameOfLifeModel model) {
        this.frame = frame;
        this.model = model;
        this.random = new Random();
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        int size = model.getGridWidth();
        int count = size * size / 5;
        for (int k = 0; k < count; k++) {
            int i = random.nextInt(size);
            int j = random.nextInt(size);
            model.setCell(i, j);
        }
        frame.repaintGridPanel();
    }
     
     
}
