/*
 * Author: Mr. M
 * Date: 12/02/24
 * Description: Boostrap class to set up the screen and widgets. Nothing exciting going on here.
 * Take a look at BrickBreak.java for all the exciting stuff!
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

public class Game  {
	public static void main(String[] args) {
	    JFrame obj = new JFrame();
	    BrickBreak gamePlay = new BrickBreak(7,5, 20, 20);
	    obj.setBounds(10, 10, 700, 600);
	    obj.setTitle("Brick Break");
	    obj.setResizable(false);
	    obj.setVisible(true);
	    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    obj.add(gamePlay);
	    obj.addKeyListener(gamePlay);
	}
}