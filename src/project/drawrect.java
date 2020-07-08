package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;


public class drawrect extends JPanel implements MouseListener,ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x1 = 50, x3 = 70, x4 = 140, x5 = 300, x6 = 400, x7 = 300, x8 = 400, x9 = 300, x10 = 400;
	int x2 = 500;
	int y1 = -10, y3 = -23, y4 = -40, y5 = -80, y6 = -100, y7 = -23, y8 = -40, y9 = -80, y10 = -100;
	int y2 = -17;
	int collision = 0;
	int dx;
	int speed = 1;
	int score = 0;
	int dy1 = speed, dy3 = speed + 1, dy5 = speed + 3, dy7 = speed + 2, dy9 = speed + 7;
	int dy2 = speed + 7, dy4 = speed + 4, dy6 = speed + 7, dy8 = speed + 1, dy10 = speed + 3;
	int cx = 350, cy = 900, cdx = 0;
	Timer t = new Timer(5, this);

	public Rectangle playButton = new Rectangle(Frame.width / 2 - 95, 450, 200, 70);
	public Rectangle exitButton = new Rectangle(Frame.width / 2 - 95, 650, 200, 70);
	public Rectangle backButton = new Rectangle (Frame.width/2 - 95,800,200,70);
	public Image img = null;
	public Image menu = null;
	public Image gover = null;
	
	public static enum STATE {
		MENU, GAME, GOVER
	};

	public static STATE state = STATE.MENU;

	public drawrect() {
		t.start();

	
				
		try {
			img = ImageIO.read(new File("resource/Game_Background.png"));
			menu = ImageIO.read(new File("resource/Menu.png"));
			gover = ImageIO.read(new File("resource/Game_Background.png"));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

	}

	public void randomnum() {
		Random rand = new Random();
		x1 = rand.nextInt(600) - 24;
		x2 = rand.nextInt(600) - 4;
		x3 = rand.nextInt(600) - 48;
		x4 = rand.nextInt(600) - 8;
		x5 = rand.nextInt(600) - 72;
		x6 = rand.nextInt(600) - 15;
		x7 = rand.nextInt(600) - 100;
		x8 = rand.nextInt(600) - 32;
		x9 = rand.nextInt(600) - 308;
		x10 = rand.nextInt(600) - 67;

	}

	public void collision() {
		if (collision == 0)
			score++;
		if (score % 500 == 0) {
			speed = speed + 5;
		}
		if (cx + 13 >= x1 && cx - 12 < x1 + 13) {
			if (cy + 20 > y1 && cy - 20 <= y1 + 20) {
				score = score;
				collision = 1;
				state = STATE.GOVER;
			}
		}
		if (cx + 13 >= x2 && cx - 12 < x2 + 13) {
			if (cy + 20 > y2 && cy - 20 <= y2 + 20) {

				collision = 1;
				state = STATE.GOVER;
			}
		}
		if (cx + 13 >= x3 && cx - 13 < x3 + 13) {
			if (cy + 20 > y3 && cy - 20 <= y3 + 20) {

				collision = 1;
				state = STATE.GOVER;
			}
		}
		if (cx + 13 >= x4 && cx - 13 < x4 + 13) {
			if (cy + 20 > y4 && cy - 20 <= y4 + 20) {

				collision = 1;
				state = STATE.GOVER;
			}
		}
		if (cx + 13 >= x5 && cx - 13 < x5 + 13) {
			if (cy + 20 > y5 && cy - 20 <= y5 + 20) {

				collision = 1;
				state = STATE.GOVER;
			}
		}
		if (cx + 13 >= x6 && cx - 13 < x6 + 13) {
			if (cy + 20 > y6 && cy - 20 <= y6 + 20) {

				collision = 1;
				state = STATE.GOVER;
			}
		}
		if (cx + 13 >= x7 && cx - 13 < x7 + 13) {
			if (cy + 20 > y7 && cy - 20 <= y7 + 20) {

				collision = 1;
				state = STATE.GOVER;
			}
		}
		if (cx + 13 >= x8 && cx - 13 < x8 + 13) {
			if (cy + 20 > y8 && cy - 20 <= y8 + 20) {

				collision = 1;
				state = STATE.GOVER;
			}
		}
		if (cx + 13 >= x9 && cx - 13 < x9 + 13) {
			if (cy + 20 > y9 && cy - 20 <= y9 + 20) {

				collision = 1;
				state = STATE.GOVER;
			}
		}
		if (cx + 13 >= x10 && cx - 13 < x10 + 13) {
			if (cy + 20 > y10 && cy - 20 <= y10 + 20) {

				collision = 1;
				state = STATE.GOVER;
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (y1 >= 700 && y2 >= 700 && y3 >= 700 && y4 >= 700 && y5 >= 700 && y6 >= 700 && y7 >= 700 && y8 >= 700
				&& y9 >= 700 && y10 >= 700) {

			y1 = -10;
			y2 = -17;
			y3 = -50;
			y4 = -180;
			y5 = -250;
			y6 = -300;
			y7 = -350;
			y8 = -400;
			y9 = -450;
			y10 = -500;
			randomnum();
			collision();
			repaint();
		} else {
			y1 = y1 + dy1;
			y2 = y2 + dy2;
			y3 = y3 + dy3;
			y4 = y4 + dy4;
			y5 = y5 + dy5;
			y6 = y6 + dy6;
			y7 = y7 + dy7;
			y8 = y8 + dy8;
			y9 = y9 + dy9;
			y10 = y10 + dy10;
			collision();
			repaint();
		}
		if (cx >= 570) {
			cdx = -2;
		}
		if (cx <= 0) {
			cdx = 2;
		}
		cx += cdx;

	}

	public void paint(Graphics g) {
		
		
		
		
		
		if (state == STATE.GAME) {
			super.paintComponent(g);

			if (collision == 0) {
				g.drawImage(img, 0, 0, this);
				g.setColor(Color.magenta);
				g.fillRect(x1, y1, 30, 65);
				g.setColor(Color.blue);
				g.fillRect(x2, y2, 30, 65);
				g.setColor(Color.red);
				g.fillRect(x3, y3, 30, 65);
				g.setColor(Color.blue);
				g.fillRect(x4, y4, 30, 65);
				g.setColor(Color.red);
				g.fillRect(x5, y5, 30, 65);
				g.setColor(Color.blue);
				g.fillRect(x6, y6, 30, 65);
				g.setColor(Color.red);
				g.fillRect(x7, y7, 30, 65);
				g.setColor(Color.blue);
				g.fillRect(x8, y8, 30, 65);
				g.setColor(Color.red);
				g.fillRect(x9, y9, 30, 65);
				g.setColor(Color.blue);
				g.fillRect(x10, y10, 30, 65);
				g.setColor(Color.darkGray);
				g.fillOval(cx, cy, 20, 20);
			}
		}

		else if (state == STATE.GOVER)

		{
			Graphics2D g2d = (Graphics2D) g;
			g.drawImage(gover, 0, 0, this);
			if (collision == 1) {
				String str;
				str = String.valueOf(score);
				
				
				Font fnt = new Font("comicsans", Font.BOLD,50);
				g.setColor(Color.WHITE);
				g.setFont(fnt);
				g.drawString("Score: ", Frame.width/2 - 95, 350);
				g.drawString(str, Frame.width/2-90,450);
				
				
//				g.drawString("Menu", playButton.x + 50, playButton.y + 50);
//				g.setColor(Color.black);
//				g2d.draw(playButton);
				
				g.setColor(Color.RED);
				g.drawString("Exit", exitButton.x + 50, exitButton.y + 50);
				g.setColor(Color.black);
				g2d.draw(exitButton);

			}
		}
		
		else if (state == STATE.MENU) {
			g.drawImage(menu, 0, 0, this);
			Graphics2D g2d = (Graphics2D) g;

			Font fnt = new Font("comicsans", Font.BOLD, 50);
			g.setColor(Color.RED);
			g.setFont(fnt);

			g.drawString("Play", playButton.x + 50, playButton.y + 50);
			g.setColor(Color.black);
			g2d.draw(playButton);

			g.setColor(Color.RED);
			g.drawString("Exit", exitButton.x + 50, exitButton.y + 50);
			g.setColor(Color.black);
			g2d.draw(exitButton);

	}
	}

	public void keyPressed(KeyEvent e) {
		int z = e.getKeyCode();
		if (z == KeyEvent.VK_LEFT) {
			cdx = -4;
		}
		if (z == KeyEvent.VK_RIGHT) {
			cdx = 4;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		cdx = 0;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx= e.getX();
		int my= e.getY();
		
		System.out.println("X: "+mx +"Y: "+my);

		// playButton
		if (mx >= Frame.width / 2 - 95 && mx <= Frame.width / 2 + 295) {
			if (my >= 450 && my <= 560 && state == STATE.MENU) {
				state = STATE.GAME;

			}
		}

		// quitButton
		if (mx >= Frame.width / 2 - 95 && mx <= Frame.width / 2 + 295) {
			if (my >= 650 && my <= 770 && state == STATE.MENU) {
				System.exit(1);

			}
		}

		// MenuButton
		if (mx >= Frame.width / 2 - 95 && mx <= Frame.width / 2 + 295) {
			if (my >= 450 && my <= 560 && state == STATE.GOVER) {
				state = STATE.MENU;

			}
		}

		// quitButton
		if (mx >= Frame.width / 2 - 95 && mx <= Frame.width / 2 + 295) {
			if (my >= 650 && my <= 770 && state == STATE.GOVER) {
				System.exit(1);

			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
