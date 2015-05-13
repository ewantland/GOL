
package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StopSimulationActionListener implements ActionListener {
    
    private StartSimulationActionListener listener;
    
    public void setListener(StartSimulationActionListener listener) {
        this.listener = listener;
        
    }
    
    @Override 
    public void actionPerformed(ActionEvent event) {
        listener.StopSimulation();
    }
}
