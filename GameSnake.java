/**
	* Classic game snake
	
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GameSnake {
	
	final String TITLE_OF_PROGRAM = "Classic Game Snake";
	final String GAME_OVER_MSG = "GAME OVER";
	final int POINT_RADIUS = 20; //in pix
	final int FIELD_WIDTH = 30; // in point
	final int FIELD_HEIGHT = 20;
	final int FIELD_DX = 6;
	final int FIELD_DY = 28;
	final int START_LOCATION =200;
	final int START_SNAKE_SIZE = 6;
	final int START_SNAKE_X = 10; 
	final int START_SNAKE_Y = 10;
	final int SHOW_DELAY =150;
	final int LEFT = 37;
	final int RIGHT = 39;
	final int UP = 38;
	final int DOWN = 40;
	final int START_DIRECTION = RIGHT;
	final Color DEFAULT_COLOR = Color.black;
	final Color FOOD_COLOR = Color.green;
	final Color POISON_COLOR = Color.red;
	Snake snake;
	//Food food;
	//Poison poison;
	JFrame frame;
	Canvas canvasPanel;
	Random random = new Random ();
	boolean gameOver = false;
	
	
	public static void main(String[] args){
		new GameSnake().go();
		
	}
	void go(){
		frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
		frame.setLocation(START_LOCATION, START_LOCATION);
		frame.setResizable(false);
		
		canvasPanel = new Canvas();
		canvasPanel.setBackground(Color.white);
		
		frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
		frame.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				 snake.setDirection(e.getKeyCode());
			}
		});
		
		frame.setVisible(true);
		
		snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
	}
	
	class Snake {
		ArrayList<Point> snake = new ArrayList<Point>();
		int direction;
		
		public Snake(int x, int y, int lenght, int direction){
			for (int i = 0; i < lenght; i++){
				Point point = new Point(x-i, y);
				snake.add(point);
				
			}
			this.direction = direction;
		}
		
		void paint(Graphics g) {
			for (Point point : snake) {
				point.paint(g);
			}
		}
	}
	
	class Point{
		int x, y;
		Color color = DEFAULT_COLOR;
		
		public Point(int x, int y) {
			this.setXY(x, y);
		}
		
		void paint(Graphics g) {
			g.setColor(color);
			g.fillOval(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
			
		}
		
		void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public class Canvas extends JPanel {
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			snake.paint(g);
		}
	}
}