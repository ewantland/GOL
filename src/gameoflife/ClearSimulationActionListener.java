
package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameoflife.GameOfLifeModel;
import gameoflife.GameOfLifeFrame;

        
public class ClearSimulationActionListener implements ActionListener {
    
    private GameOfLifeFrame frame;
    private GameOfLifeModel model;
    
    public ClearSimulationActionListener(GameOfLifeFrame frame,
            GameOfLifeModel model) {
        this.frame = frame;
        this.model = model;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        model.clearGrid();
        frame.setGenerationTextField();
        frame.repaintGridPanel();
    }
            
}
