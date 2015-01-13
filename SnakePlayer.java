/**
 * @(#)SnakePlayer.java
 *
 *
 * @authors Martin Verde
 * @version 1.00 2014/5/7
 */
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.lang.Integer;
import java.lang.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SnakePlayer extends SnakeObject implements KeyListener {
	private SnakeGrid grid;
	private JPanel[][] arr;
	private JLabel scoreNum;
	private char c;
	private String cLast;
	private Integer currx;
	private Integer curry;
	private Integer numFood;
	private Integer score;
	private Integer snakeLength;
	private ArrayList<Integer> direcs = new ArrayList<Integer>();
	private ArrayList<JPanel> segments = new ArrayList<JPanel>();
	private String isAlive;

    public SnakePlayer(SnakeGrid gr) {  //constructs a SnakePlayer, places it on the game grid, enables key inputs, and allows access to the grid and its panels
    	grid = gr;
    	arr = gr.getGrid();
    	currx = new Integer(15);
    	curry = new Integer(15);
    	numFood = new Integer(0);
    	snakeLength = new Integer(1);
    	score = new Integer(0);
    	isAlive = "true";
    	cLast = "d";
    	scoreNum = new JLabel(score.toString(),JLabel.CENTER);
    	arr[28][0].add(new JLabel("sco",JLabel.CENTER));
    	arr[29][0].add(new JLabel("re:",JLabel.CENTER));
    	arr[30][0].add(scoreNum);
    	arr[15][15].setBackground(Color.GREEN);
    	arr[15][15].addKeyListener(this);
    	arr[15][15].requestFocusInWindow();
    	for(int i=0; i<5; i++)
    	{
    		direcs.add(new Integer(0));
    	}
    	direcs.set(1,new Integer(1));
    }
    

    public void keyTyped(KeyEvent key)
    {
    	return;
    }
    public void keyPressed(KeyEvent key)  //gets the key that was pressed and changes the current direction to match it
    {
    	c = key.getKeyChar();
    	if((c == 'w' || c == 'W') && !cLast.equals("d"))
    	{
    		direcs.set(0,new Integer(1));
    		direcs.set(1,new Integer(0));
    		direcs.set(2,new Integer(0));
    		direcs.set(3,new Integer(0));
    		cLast = "u";
    	}
    	else if((c == 's' || c == 'S') && !cLast.equals("u")) 
    	{
    		direcs.set(0,new Integer(0));
    		direcs.set(1,new Integer(1));
    		direcs.set(2,new Integer(0));
    		direcs.set(3,new Integer(0));
    		cLast = "d";
    	}
    	else if((c == 'a' || c == 'A') && !cLast.equals("r"))
    	{
    		direcs.set(0,new Integer(0));
    		direcs.set(1,new Integer(0));
    		direcs.set(2,new Integer(1));
    		direcs.set(3,new Integer(0));
    		cLast = "l";
    	}
    	else if((c == 'd' || c == 'D') && !cLast.equals("l"))
    	{
    		direcs.set(0,new Integer(0));
    		direcs.set(1,new Integer(0));
    		direcs.set(2,new Integer(0));
    		direcs.set(3,new Integer(1));
    		cLast = "r";
    	}
    	else
    		return;
    }
    public void keyReleased(KeyEvent key)
    {
    	return;
    }
    public void update()  //updates the location and length of the snake based on which direction it is moving in and whether it has eaten food
    {
    	try
    	{
	    	if(direcs.get(0).intValue() == 1)
	        {
		    	if(curry.intValue()>0 && arr[currx.intValue()][curry.intValue() - 1].getBackground() != Color.GREEN)
		    	{
		    		if(snakeLength.intValue() == 1)
		    		{
		    			this.arr[currx.intValue()][curry.intValue()].setBackground(Color.GRAY);
		    		}
		    		this.curry = new Integer(curry.intValue() - 1);
		    		if(arr[currx.intValue()][curry.intValue()].getBackground() == Color.YELLOW)
		    		{
		    			numFood = new Integer(numFood.intValue() - 1);
		    			snakeLength = new Integer(snakeLength.intValue() + 1);
		    			setScore();
		    		}
		    		if(snakeLength.intValue()>1)
		    		{
		    			segments.add(arr[currx.intValue()][curry.intValue()]);
		    			removeBack();
		    		}
		    		this.arr[currx.intValue()][curry.intValue()].setBackground(Color.GREEN);
		    	}
		    	else if(curry.intValue()<=0 || arr[currx.intValue()][curry.intValue() - 1].getBackground() == Color.GREEN)
		   			isAlive = "false";
		    }
		   	else if(direcs.get(1).intValue() == 1)
		   	{
		   		if(curry.intValue()>0 && arr[currx.intValue()][curry.intValue() + 1].getBackground() != Color.GREEN)
		   		{
		    		if(snakeLength.intValue() == 1)
		    	    {
		    			this.arr[currx.intValue()][curry.intValue()].setBackground(Color.GRAY);
		    		}
		   			this.curry = new Integer(curry.intValue() + 1);
		   		    if(arr[currx.intValue()][curry.intValue()].getBackground() == Color.YELLOW)
		    		{
		    			numFood = new Integer(numFood.intValue() - 1);
		    			snakeLength = new Integer(snakeLength.intValue() + 1);
		    			setScore();
		    		}
		    		if(snakeLength.intValue()>1)
		    		{
		    			segments.add(arr[currx.intValue()][curry.intValue()]);
		    			removeBack();
		    		}
		   			this.arr[currx.intValue()][curry.intValue()].setBackground(Color.GREEN);
		   		}
		   	    else if(curry.intValue()<=0 || arr[currx.intValue()][curry.intValue() + 1].getBackground() == Color.GREEN)
		   			isAlive = "false";
		   	}
		   	else if(direcs.get(2).intValue() == 1)
		   	{
		   		if(curry.intValue()>0 && arr[currx.intValue() - 1][curry.intValue()].getBackground() != Color.GREEN)
		   		{
		    	    if(snakeLength.intValue() == 1)
		    		{
		    			this.arr[currx.intValue()][curry.intValue()].setBackground(Color.GRAY);
		    		}
		   			this.currx = new Integer(currx.intValue() - 1);
		   			if(arr[currx.intValue()][curry.intValue()].getBackground() == Color.YELLOW)
		    		{
		    			numFood = new Integer(numFood.intValue() - 1);
		    			snakeLength = new Integer(snakeLength.intValue() + 1);
		                setScore();
		    		}
		    		if(snakeLength.intValue()>1)
		    		{
		    			segments.add(arr[currx.intValue()][curry.intValue()]);
		    			removeBack();
		    		}
		   			this.arr[currx.intValue()][curry.intValue()].setBackground(Color.GREEN);
		   		}
		   		else if(curry.intValue()<=0 || arr[currx.intValue() - 1][curry.intValue()].getBackground() == Color.GREEN)
		   			isAlive = "false";
		   	}
		   	else if(direcs.get(3).intValue() == 1)
		   	{
		   		if(curry.intValue()>0 && arr[currx.intValue() + 1][curry.intValue()].getBackground() != Color.GREEN)
		   		{
		    		if(snakeLength.intValue() == 1)
		    	    {
		    			this.arr[currx.intValue()][curry.intValue()].setBackground(Color.GRAY);
		    		}
		   			this.currx = new Integer(currx.intValue() + 1);
		   			if(arr[currx.intValue()][curry.intValue()].getBackground() == Color.YELLOW)
		    		{
		    			numFood = new Integer(numFood.intValue() - 1);
		    			snakeLength = new Integer(snakeLength.intValue() + 1);
		    			setScore();
		    		}
		    		if(snakeLength.intValue()>1)
		    		{
		    			segments.add(arr[currx.intValue()][curry.intValue()]);
		    			removeBack();
		    		}
		   			this.arr[currx.intValue()][curry.intValue()].setBackground(Color.GREEN);
		   		}
		   		else if(curry.intValue()<=0 || arr[currx.intValue() + 1][curry.intValue()].getBackground() == Color.GREEN)
		   			isAlive = "false";
		   	}
    	}
    	catch(Exception e)
    	{
    		isAlive = "false";
    	}
	   	try
	   	{
	   		TimeUnit.MILLISECONDS.sleep(75);
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.println("Error.");
	   	}
    }
    public void foodGenerator()  //generates food randomly on the grid, making sure not to replace snake tiles
    {
    	int x = (int)(Math.random() * 31);
    	int y = (int)(Math.random() * 31);
    	if((x>0 && x<31) && (y>0 && y<31))
    	{
    		if(arr[x][y].getBackground() == Color.GRAY)
    			arr[x][y].setBackground(Color.YELLOW);
    		if(arr[x][y].getBackground() == Color.YELLOW)
    			numFood = new Integer(numFood.intValue() + 1);
    	}
    	else
    		foodGenerator();
    }
    public void removeBack()  //removes the last segment of the snake to make it move when snakeLength > 1
    {
    	if(segments.size()>snakeLength.intValue())
    	{
    		segments.get(0).setBackground(Color.GRAY);
    		segments.remove(0);
    	}
    }
    public void setScore()  //increases the score by 1
    {
    	scoreNum.setVisible(false);
    	score = new Integer(score.intValue() + 1);
    	scoreNum = new JLabel(score.toString(),JLabel.CENTER);
    	arr[30][0].add(scoreNum);
    }
    public Integer getScore()
    {
    	return score;
    }
    public boolean getLife()  //returns true if the player is alive, false if not
    {
    	if(isAlive.equals("true"))
    		return true;
    	return false;
    }
    public int getNumFood()  //returns the number of food tiles currently on the grid
    {
    	return numFood.intValue();
    }
}
