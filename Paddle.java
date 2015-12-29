package edu.nyu.cs.hc1334.Homework6;
/**
 * Assignment 6
 * 
 * Paddle class for pong game
 * 
 * @author Helen Chang
 * @version 1.0
 * Due: 4/13/2015
 */
public class Paddle {
	TestPong parent; 
	
	private int xCoord;
	private int yCoord;

	public static final int WIDTH = 20;
	public static final int LENGTH = 100;
	public static final int SPEED = 7;
	
	/**
	 * gets x coordinate of paddle (top left corner of rectangle)
	 * @return x coord as int
	 */
	public int getXCoord(){
		return this.xCoord;
	}
	
	/**
	 * set x coordinate of paddle
	 * @param xCoord to be set
	 * @param parent class where app is run
	 */
	public void setXCoord(int xCoord, TestPong parent){
		if (xCoord >= 0 + parent.MARGIN && xCoord<=parent.WINDOWSIZE - parent.MARGIN){
			this.xCoord = xCoord;
		}
	}
	/**
	 * gets x coordinate of paddle (top left corner of rectangle)
	 * @return y coordinate as int
	 */
	public int getYCoord(){
		return this.yCoord;
	}
	/**
	 * set Y coordinate of paddle, limited to window size
	 * @param yCoord to be set
	 * @param parent class where app is run
	 */
	public void setYCoord(int yCoord, TestPong parent){
		if (yCoord >= 0 && yCoord+LENGTH <= parent.WINDOWSIZE){
			this.yCoord = yCoord;
		}
	}
	/**
	 * moves paddle up according to y speed set
	 * @param parent class where app is run
	 */
	public void moveUp(TestPong parent){
		setYCoord(yCoord+SPEED, parent );
	}
	/**
	 * moves paddle down according to y speed set
	 * @param parent class where app is run
	 */
	public void moveDown(TestPong parent){
		setYCoord(yCoord-SPEED, parent);
	}
	
	/**
	 * Draws this paddle to the PApplet screen. 
	 */
	public void draw(){
		parent.rect(this.getXCoord(), this.getYCoord(), WIDTH, LENGTH);
	}
	/**
	 * paddle object moves to follow ball
	 * @param ball object to be followed
	 * @param parent class where app is run
	 */
	public void followBall(Ball ball, TestPong parent){
		if (this.getYCoord() < ball.getYCoord()){
			this.moveUp(parent);
		}
		if (this.getYCoord() > ball.getYCoord()){
			this.moveDown(parent);
		}
	}
	
	//no args contructor creates paddle at (0,0)
	public Paddle(){
		this.xCoord = 0;
		this.yCoord = 0;
	}
	
	public Paddle(int xCoord, int yCoord, TestPong parent){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.parent = parent;
	}
	
	
	
}
