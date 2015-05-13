package gameoflife;


import javax.swing.SwingUtilities;

import gameoflife.GameOfLifeModel;
import gameoflife.GameOfLifeFrame;





public class GameOfLife implements Runnable {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GameOfLife());
    }
    @Override
    public void run(){
        new GameOfLifeFrame(new GameOfLifeModel());
    }
}
