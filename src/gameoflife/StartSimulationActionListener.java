
package gameoflife;

import java.awt.event.*;

import javax.swing.SwingUtilities;

import gameoflife.GameOfLifeModel;
import gameoflife.GameOfLifeFrame;


public class StartSimulationActionListener implements ActionListener {
    
 private GameOfLifeFrame frame;
 private GameOfLifeModel model;
 
 private RunSimulation runSimulation;
 
 public StartSimulationActionListener(GameOfLifeFrame frame,
         GameOfLifeModel model) {
     this.frame = frame;
     this.model = model;
     
 }
 
 @Override
 public void actionPerformed(ActionEvent event) {
     runSimulation = new RunSimulation();
     new Thread(runSimulation).start();
 }
 
 public void StopSimulation() {
     runSimulation.stopRunning();
     runSimulation = null;
     
     
 }
  
 class RunSimulation implements Runnable {
     private volatile boolean running;
     
     
     @Override
     public void run() {
         this.running = true;
         while (running) {
             sleepezz();
             model.cycleGrid();
             repaint();
         } 
     }
     
     private void repaint() {
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 frame.setGenerationTextField();
                 frame.repaintGridPanel();
             }  
         });
         
     }
     
     private void sleepezz() {
             try {
                 Thread.sleep(model.getGenerationDelay());
             } catch (InterruptedException e) {
             }
             
     }
     
     public synchronized void stopRunning() {
         this.running = false;
     }
     
     
  }
    
    
    
 }