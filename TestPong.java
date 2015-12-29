package edu.nyu.cs.hc1334.Homework6;
/**
 * Assignment 6
 * 
 * Pong game
 * 
 * @author Helen Chang
 * @version 1.0
 * Due: 4/13/2015
 */

import processing.core.*;


public class TestPong extends PApplet{
	
	final int WINDOWSIZE = 600;
	final int MARGIN = 10;
	
	private Paddle autoPaddle = new Paddle(5,0, this);
	private Ball ball = new Ball();
	private LoseImage loseImage = new LoseImage(this);
	private int counter = 31;
	
	
	
	public void setup(){
		fill(0, 0, 200); 
		stroke(0, 0, 0);
		
		size(WINDOWSIZE,WINDOWSIZE);
	}
	
	public void draw(){
		
		background(200, 200, 200);
		
		//computer's paddle
		autoPaddle.draw();
		autoPaddle.followBall(ball, this);
		
		//user's paddle follows user's cursor
		Paddle userPaddle = new Paddle(WINDOWSIZE - Paddle.WIDTH - MARGIN, mouseY, this);
		userPaddle.draw();

		//ball that moves up/down
		ball.draw(this);
		ball.moveYCoord();
		ball.moveXCoord();
		
		//check collision of ball and paddle, if collide, change direction
		ball.checkCollision(userPaddle, "r");
		ball.checkCollision(autoPaddle, "l");
		
		if (ball.checkLose(this,userPaddle)){
			counter = 0;
		}
		if (counter < 30){
			loseImage.draw();
			counter++;
		}
	
		
		//if ball goes off screen, resets to center
		ball.checkReset(this);
	
	}

}
