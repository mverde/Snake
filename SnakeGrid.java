/**
 * @(#)SnakeGrid.java
 *
 *
 * @authors Martin Verde
 * @version 1.00 2014/5/7
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class SnakeGrid extends SnakeObject 
{
	private JFrame frame = new JFrame();
	private static final int WIDTH = 320;
	private static final int HEIGHT = 320;
	private static final int SCALE = 2;
	private JPanel[][] grid;
	
	public SnakeGrid(int width, int length)  //constructs a grid of JPanels with int parameters for dimensions of the grid
	{
		frame.setLayout(new GridLayout(width, length));
		grid = new JPanel[width][length];
		for(int y=0; y<length; y++)
		{
			for(int x=0; x<width; x++)
			{
				grid[x][y] = new JPanel();
				frame.add(grid[x][y]);
				grid[x][y].setBackground(Color.GRAY);
			}
		}
		frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public JPanel[][] getGrid()  //returns the 2D array of JPanels
	{
		return grid;
	}
	public void closeFrame()  //exits the game
	{
		frame.setVisible(false);
	}
}
