/**
 * @(#)SnakeMenu.java
 *
 *
 * @authors Martin Verde
 * @version 1.00 2014/5/20
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SnakeMenu extends SnakeObject implements ActionListener
{
	private JFrame frame = new JFrame();
	private static final int WIDTH = 320;
	private static final int HEIGHT = 320;
	private static final int SCALE = 2;
	private String playing;
	private JButton[][] grid;
	
    public SnakeMenu(int width, int length)  //constructs a new button menu
    {
    	playing = "f";
    	frame.setLayout(new GridLayout(width, length));
    	grid = new JButton[width][length];
    	for(int l=0; l<length; l++)
    	{
    		for(int w=0; w<width; w++)
    		{
    			if(w == 0)
    			{
    				grid[w][l] = new JButton("Play!");
    			}
    			else if(w == 1)
    			{
    				grid[w][l] = new JButton("Quit");
    			}
    			frame.add(grid[w][l]);
    		}
    	}
    	grid[0][0].addActionListener(this);
    	grid[1][0].addActionListener(this);
    	frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event)  //gets which menu button was pressed and sets the state of the game to match
    {
    	Object source = event.getSource();
    	if(source == grid[0][0])
    	{
    		this.setPlaying();
    	}
    	else if(source == grid[1][0])
    	{
    		System.exit(0);
    	}
    } 
    public void setPlaying()  //sets whether or not the game is running
    {
    	if(playing.equals("f"))
    		playing = "t";
    	else
    		playing = "f";
    }
    public String getPlaying()  //returns whether or not the game is playing
    {
    	return playing;
    }
}
