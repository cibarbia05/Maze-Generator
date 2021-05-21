package Model;

import View.StartView;

public class Maze {
    private boolean [][] maze1;
    /*Fills the maze created with the number of columns and rows by the user with the value true
    * so that they are initially all set to the color of the walls in the maze
    */
    public void setMaze(){
        maze1 = new boolean[StartView.getInputRows()][StartView.getInputCols()];
        for(int i=0;i<maze1.length;i++){
            for(int j=0;j<maze1[0].length;j++){
                maze1[i][j] = true;
            }
        }
    }
    public boolean[][] getMaze(){
        return maze1;
    }
}
