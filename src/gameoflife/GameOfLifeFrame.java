
package gameoflife;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameoflife.GameOfLifeModel;

public class GameOfLifeFrame {
    
    private ControlPanel controlPanel;
    
    private GameOfLifeModel model;
    
    private GridPanel gridPanel;
    
    private JFrame frame;
    
    public GameOfLifeFrame(GameOfLifeModel model) {
        this.model = model;
        createPartControl();
    }
    
    
    private void createPartControl() {
        
        controlPanel = new ControlPanel(this, model);
        gridPanel = new GridPanel(model);
        
        frame = new JFrame();
        frame.setTitle(" Conways Game of Life\n A cellular Automata! ");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter(){ 
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });
            
        
        JPanel mainPanel =new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(gridPanel);
        mainPanel.add(controlPanel.getPanel());
        
        frame.setLayout(new FlowLayout());
        frame.add(mainPanel);
        frame.setSize(640, 480);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
    }
    
    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
        
    }
        
    public void setGenerationTextField() {
        controlPanel.setGenerationTextField(model.getGenerationCount());
    }
        
    public void repaintGridPanel() {
        gridPanel.repaint();
    }
        
    
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
