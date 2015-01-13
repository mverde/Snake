/**
 * @(#)SnakeRunner.java
 *
 *
 * @authors Martin Verde
 * @version 1.00 2014/5/8
 */
import javax.swing.JOptionPane;
import java.util.concurrent.TimeUnit;


public class SnakeRunner extends SnakeObject 
{
    public static void main(String[] args)  //runs a game of snake 
    {
    	SnakeMenu menu = null;
    	SnakeGrid grid = null;
    	SnakeRun run = new SnakeRun();
    	run.runGame(menu, grid);
    }
}
