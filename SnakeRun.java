/**
 * @(#)SnakeRun.java
 *
 *
 * @authors Martin Verde
 * @version 1.00 2014/5/27
 */
import javax.swing.JOptionPane;
import java.util.concurrent.TimeUnit;

public class SnakeRun extends SnakeObject 
{
    public void runGame(SnakeMenu men, SnakeGrid gr)  //runs a game of snake
    {
    	men = new SnakeMenu(2,1);
    	while(men.getPlaying().equals("f"))
    	{
    		int i = 0;
    	}
    	JOptionPane.showMessageDialog(null,"Get Ready!","MESSAGE",JOptionPane.ERROR_MESSAGE);
    	gr = new SnakeGrid(31,31);
        try
        {
        	TimeUnit.NANOSECONDS.sleep(2);
        }
        catch(Exception e)
        {
        	System.out.println("error");
        }
        SnakePlayer player = new SnakePlayer(gr);
        while(player.getLife())
        {
        	if(player.getNumFood()<1)
        		player.foodGenerator();
        	player.update();
        }
        JOptionPane.showMessageDialog(null,"Game Over! Your score was: " + player.getScore(),"MESSAGE",JOptionPane.ERROR_MESSAGE);
        if(!player.getLife())
        {
        	gr.closeFrame();
        	men.setPlaying();
        }
        runGame(men,gr);
    }  
}
