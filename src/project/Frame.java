package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class Frame extends JFrame {
	
	public static final int width = 640;
	public static final int height = 1000;
	

	private BufferedImage image = new BufferedImage(640,1000,BufferedImage.TYPE_INT_RGB);;
	private void render()
	{
		BufferStrategy bs=this.getBufferStrategy();
		
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		Graphics g=bs.getDrawGraphics();
		
		g.drawImage(image, 0,0,getWidth(),getHeight(),this);
		
		g.dispose();
		bs.show();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		JFrame frame=new JFrame("Game");
		frame.setVisible(true);
		frame.setSize(width, height);
		drawrect d=new drawrect();
		
		
		frame.add(d);
		frame.addKeyListener(d);
		frame.addMouseListener(d);

		
		
		
		
	
		
}
}
