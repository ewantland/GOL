package gameoflife;


import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import gameoflife.ClearSimulationActionListener;
import gameoflife.GameOfLifeFrame;
import gameoflife.GenerationDelayChangeListener;
import gameoflife.RandomInitializationActionListener;
import gameoflife.StartSimulationActionListener;
import gameoflife.StopSimulationActionListener;
import gameoflife.GameOfLifeModel;


public class ControlPanel {
    
private static final Insets buttonInsets = new Insets(10,10,0,10);

private GameOfLifeFrame frame;

private GameOfLifeModel model;

private JPanel panel;

private JTextField generationTextField;

public ControlPanel(GameOfLifeFrame frame , GameOfLifeModel model) {
    this.frame = frame;
    this.model = model;
    
    createPartControl();
    
}
        
private void createPartControl() {
    StartSimulationActionListener startListener = new StartSimulationActionListener(frame, model);
    
    StopSimulationActionListener stopListener = new StopSimulationActionListener();
    stopListener.setListener(startListener);
    
    panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    
    int gurdy = 0;
    
    JButton randomButton = new JButton(" Random Initialization ");
    randomButton.addActionListener(
            new RandomInitializationActionListener(frame, model));
    addComponent(panel, randomButton, 0, gurdy++, 2, 1, 
            buttonInsets, GridBagConstraints.LINE_START, 
            GridBagConstraints.HORIZONTAL);
            
            
    JButton startButton = new JButton(" Start Simulation ");
    startButton.addActionListener(startListener);
    addComponent(panel, startButton, 0, gurdy++, 2, 1, buttonInsets,
            GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
    
    JButton stopButton = new JButton(" Stop SImulation ");
    stopButton.addActionListener(stopListener);
    addComponent(panel, stopButton, 0, gurdy++, 2, 1, 
            buttonInsets, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
    
    JButton clearButton = new JButton(" Clear Simulation ");
    clearButton.addActionListener(
             new ClearSimulationActionListener(frame, model));
    addComponent(panel, clearButton, 0, gurdy++, 2, 1,
            buttonInsets, GridBagConstraints.LINE_START, 
            GridBagConstraints.HORIZONTAL);
    
    JLabel sliderLabel = new JLabel(" Generation Delay in Seconds " , 
            JLabel.CENTER);
    sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    addComponent(panel, sliderLabel, 0, gurdy++, 2, 1,
            buttonInsets, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
    
    int defaultDelay = (int) model.getGenerationDelay() / 1000;
    
    JSlider generationDelaySlider =
            new JSlider (JSlider.HORIZONTAL, 2, 10, defaultDelay);
    generationDelaySlider.addChangeListener(
             new GenerationDelayChangeListener(model));
    generationDelaySlider.setMajorTickSpacing(1);
    generationDelaySlider.setPaintLabels(true);
    generationDelaySlider.setPaintTicks(true);
    addComponent(panel, generationDelaySlider, 0, gurdy++, 2, 1,
            buttonInsets, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL );
    
    
    JLabel generationLabel = new JLabel(" Generation ");
    addComponent(panel, generationLabel, 0, gurdy, 1, 1,
            buttonInsets, GridBagConstraints.LINE_START, 
            GridBagConstraints.HORIZONTAL);
    
    generationTextField = new JTextField(10);
    generationTextField.setHorizontalAlignment(JTextField.RIGHT);
    generationTextField.setEditable(false);
    addComponent(panel,generationTextField, 1, gurdy++, 1, 1,
            buttonInsets, GridBagConstraints.LINE_START, 
            GridBagConstraints.HORIZONTAL);
           
}
    
    
private void addComponent(Container container, Component component, 
        int gridx, int gurdy, int gridwidth, int gridheight, 
        Insets insets, int anchor, int fill) {
    
    GridBagConstraints gbc = new GridBagConstraints(gridx, gurdy, 
            gridwidth, gridheight, 1.0D, 1.0D, anchor, fill,insets,0,0);
    container.add(component, gbc);
}   
 
public void setGenerationTextField(long generationCount) {
    NumberFormat nf = NumberFormat.getInstance();
    generationTextField.setText(nf.format(generationCount));  
}
    
public JPanel getPanel() {
    return panel;
}    
    
   
    
}
