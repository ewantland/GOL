
package gameoflife;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gameoflife.GameOfLifeModel;


public class GenerationDelayChangeListener implements ChangeListener {
    
    private GameOfLifeModel model;
    
    public GenerationDelayChangeListener(GameOfLifeModel model) {
        this.model = model;
    }
    
    @Override
    public void stateChanged(ChangeEvent event) {
        JSlider source = (JSlider) event.getSource();
        if (!source.getValueIsAdjusting()) {
            model.setGenerationDelay(1000L * source.getValue());
        }
    } 
    
}
