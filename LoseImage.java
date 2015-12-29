package edu.nyu.cs.hc1334.Homework6;
/**
 * Assignment 6
 * 
 * loser image for pong game
 * 
 * @author Helen Chang
 * @version 1.0
 * Due: 4/13/2015
 */
import processing.core.*;

public class LoseImage {
	private TestPong parent;
	private final static String IMAGE_PATH = "LOSER.png";
	private PImage image;

	
	public void draw(){
		parent.image(image, 0, 0);
	}
	
	public LoseImage(TestPong parent){

		this.parent = parent;
		this.image = parent.loadImage(LoseImage.IMAGE_PATH);
		
	}
	
}
