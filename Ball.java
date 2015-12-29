package edu.nyu.cs.hc1334.Homework6;
/**
 * Assignment 6
 * 
 * ball class for pong game
 * 
 * @author Helen Chang
 * @version 1.0
 * Due: 4/13/2015
 */
public class Ball {
	private int xCoord;
	private int yCoord;
	final int SPEED = 5;
	private int ySpeed;
	private int xSpeed;
	final int DIAMETER = 20;
	
	TestPong parent;
	
	/**
	 * Set x coordinate of ball
	 * @param xCoord as integer
	 */
	public void setXCoord(int xCoord){
		this.xCoord = xCoord;
	}
	/**
	 * gets the x coordinate of the ball
	 * @return x Coordinate as integer
	 */
	public int getXCoord(){
		return xCoord;
	}
	
	
	
	/**
	 * Set y coordinate of ball, limited to height of school
	 * If Y coord of ball about to be outside window dimensions, change direction of y coordinate
	 * @param yCoord as integer
	 */
	public void setYCoord(int yCoord){
		if ((int)(yCoord+(DIAMETER/2)) <= 600 && (int)(yCoord-(DIAMETER/2)) >= 0){
			this.yCoord = yCoord;
		}
		else{
			this.changeDirection("yCoord");
		}
	}
	
	/**
	 * Gets the y coordinate of the ball
	 * @return y coord as integer
	 */
	public int getYCoord(){
		return yCoord;
	}
	
	/**
	 * gets the speed of the y coordinate of the ball
	 * @return speed of vertical movement of ball as int
	 */
	public int getYSpeed(){
		return ySpeed;
	}
	/**
	 * sets the speed of the y coordinate of the ball
	 * @param ySpeed as int
	 */
	public void setYSpeed(int ySpeed){
		this.ySpeed = ySpeed;
	}
	
	/**
	 * gets the speed of the x coordinate of the ball
	 * @return speed of horizontal movement of ball as int
	 */
	public int getXSpeed(){
		return xSpeed;
	}
	/**
	 * sets speed of x coordinate of the ball
	 * @param xSpeed as int
	 */
	public void setXSpeed(int xSpeed){
		this.xSpeed = xSpeed;
	}
	
	/**
	 * moves the ball vertically according to ySpeed
	 */
	public void moveYCoord(){
		setYCoord(getYCoord()+ySpeed);
	}

	/**
	 * moves the ball horizontally according to ySpeed
	 */
	public void moveXCoord (){
		setXCoord(getXCoord()+xSpeed);
	}
	/**
	 * if x coord of ball leaves window, reset ball to center of window
	 * @param parent reference to TestPong class, class where game is run (this)
	 */
	public void checkReset(TestPong parent){
		if (this.getXCoord() < 0 || this.getXCoord() > parent.WINDOWSIZE){
			setXCoord(300);
			setYCoord(300);
			
		}
	}
	
	/**
	 * check if user lost
	 * 
	 * @param parent reference to class where object is used
	 * @param userPaddle User's paddle
	 * @return boolean- if user lost or not
	 */
	public boolean checkLose(TestPong parent, Paddle userPaddle){
		if (this.getXCoord() > userPaddle.getXCoord()){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * change direction of either vertical or horizontal movement of ball
	 * @param coord String of either "xCoord" or "yCoord" that needs to be changed
	 */
	public void changeDirection(String coord){
		if (coord.equals("xCoord")){
			setXSpeed(xSpeed*(-1));
		}
		else if (coord.equals("yCoord")){
			setYSpeed(ySpeed*(-1));
		}
	}
	/**
	 * checks if ball collides with specified paddle
	 * @param paddle collision with ball to be checked
	 * @param side of the window the paddle is on (either "r" or "l")
	 */
	public void checkCollision (Paddle paddle, String side){
		if (side.equals ("r")){
			if (this.getXCoord()+(int)(DIAMETER/2) == paddle.getXCoord()){
				if (this.getYCoord() - DIAMETER <= (paddle.getYCoord() + Paddle.LENGTH) && this.getYCoord() + DIAMETER >= (paddle.getYCoord())){
					this.changeDirection("xCoord");
				}
			}
		}
		if (side.equals ("l")){
			if (this.getXCoord()-(int)(DIAMETER/2) == (paddle.getXCoord() + Paddle.WIDTH)){
				if (this.getYCoord() - DIAMETER <= (paddle.getYCoord() + Paddle.LENGTH) && this.getYCoord() + DIAMETER >= (paddle.getYCoord())){
					this.changeDirection("xCoord");
				}
			}
		}
		
	}
	/**
	 * Draws this ball to the PApplet screen. 
	 * @param parent class where the app is run
	 */
	public void draw(TestPong parent){
		parent.ellipse(this.getXCoord(), this.getYCoord(), this.DIAMETER, this.DIAMETER);
	}
	
	//starts position in center of screen
	public Ball() {
		this.xCoord = 300;
		this.yCoord = 300;
		this.ySpeed = SPEED;
		this.xSpeed = SPEED;
	}
	
	public Ball(int xCoord, int yCoord, int diameter, int speed){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.ySpeed = speed;
	}
}
