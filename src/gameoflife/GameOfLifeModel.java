
package gameoflife;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

        


public class GameOfLifeModel {
    private static final int GRID_WIDTH = 100;
    private static final int CELL_WIDTH = 6;
    
    private boolean[][] grid;
    
    private volatile long generationCount;
    private volatile long generationDelay;
    
    public GameOfLifeModel(){
       this.grid =new boolean[GRID_WIDTH][GRID_WIDTH];
       this.generationDelay = 2000L;
       clearGrid();
   
    }
    
    public void clearGrid(){
        this.generationCount = 0;
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                resetCell(i,j);
                
            }
        }  
    }
    
    public void setCell(int i, int j){
        grid[i][j] = true;
    }
    
    public void resetCell(int i, int j){
        grid[i][j] = false;
    }
    public synchronized void cycleGrid() {
        this.generationCount++;
        
        for (int i = 0; i < GRID_WIDTH; i++){
            for (int j = 0; j < GRID_WIDTH; j++){
                int count = countCells(i, j);
                if (count == 3) grid[i][j] = true;
                if (grid[i][j] && count < 2) grid[i][j] = false;
                if (grid[i][j] && count > 3) grid[i][j] = false;
                
             }
        } 
    }
   
    
    private int countCells(int i, int j){
        int count = 0;
        
        int iminus = i - 1;
        int jminus = j - 1;
        int iplus = i + 1;
        int jplus = j + 1;
        
        if(iminus >= 0){
            if(jminus >= 0){
                if (grid[iminus][jminus])  count++;
            }
            if (grid[iminus][j])  count++;
        
            if (jplus < GRID_WIDTH){
                if (grid[iminus][jplus])  count++; 
            }
        }
    
        if (jminus >= 0){
            if(grid[i][jminus])  count++;
        }
        
        if (jplus < GRID_WIDTH) {
            if (grid[i][jplus])  count++;
        }
        
        if (iplus < GRID_WIDTH){
            if(jminus >= 0) {
                if (grid[iplus][jminus]) count++;
            }
            
            if (grid[iplus][j])  count++;
            
            if (jplus < GRID_WIDTH) {
                if (grid[iplus][jplus])  count++;  
            } 
        }
    return count;
    
    }
    
    public Dimension getPrefferedSize() {
        int x = (GRID_WIDTH * (CELL_WIDTH + 1)) + 1;
        return new Dimension(x, x);
    }
    public int getGridWidth() {
        return GRID_WIDTH;
       
    }
    public long  getGenerationCount() {
        return generationCount;
    }
    public long getGenerationDelay() {     
        return generationDelay;
    }
    
    public synchronized void setGenerationDelay(long geneartionDelay) {
        this.generationDelay = generationDelay;  
    }
    
    public void draw(Graphics g) {
        int x = 1;
        for (int i = 0; i<GRID_WIDTH; i++) {
            int y = 1;
            for (int j = 0; j<GRID_WIDTH; j++) {
                drawGridLines(g,x,i,y,j);
                drawCell(g,x,i,y,j);
                y += CELL_WIDTH + 1;
            }
             x += CELL_WIDTH + 1;
        }  
           
    }
    
    private void drawGridLines(Graphics g, int x, int i, int y, int j) {
        g.setColor(Color.BLUE);
        if (i == 0) {
            g.drawLine(0, y-1, 0, y+CELL_WIDTH -1); 
        }
        
        if (j == 0) {
            g.drawLine(x-1, 0, x+CELL_WIDTH-1, 0);    
        }
        
        g.drawLine(x, y+CELL_WIDTH, x+CELL_WIDTH, y+CELL_WIDTH);
        g.drawLine(x+CELL_WIDTH, y, x+CELL_WIDTH, y+CELL_WIDTH);
    }
    
    private void drawCell(Graphics g, int x,int i,int y, int j) {
        if (grid[i][j]){
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, CELL_WIDTH, CELL_WIDTH);
        }
    }
    
    
     
    
}
