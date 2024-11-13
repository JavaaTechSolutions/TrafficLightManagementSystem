package com.jts.traffic.gui;

public class TrafficLight {
	private TrafficLightState state;
	
	private final Object lock = new Object();
	
	private final int greenTime; // time in milliseconds the light stays green
	private final int yellowTime; // time in milliseconds the light stays yellow
	private final int redTime; // time in milliseconds the light stays red
	
	public TrafficLight(int greenTime, int yellowTime, int redTime) {
		this.state = TrafficLightState.RED;
		this.greenTime = greenTime;
		this.yellowTime = yellowTime;
		this.redTime = redTime;
	}
	
	public TrafficLightState getState() {
		return state;
	}
	
	public void changeState() {
		synchronized (lock) {
			switch (state) {
			case RED:
				state = TrafficLightState.GREEN;
				break;
			case GREEN:
				state = TrafficLightState.YELLOW;
				break;
			case YELLOW:
				state = TrafficLightState.RED;
				break;
			}
		}
	}
	
	public int getCurrentStateDuration() {
		switch (state) {
		case GREEN:
			return greenTime;
		case YELLOW:
			return yellowTime;
		case RED:
			return redTime;
		default:
			return 0;
		}
	}
	
	public void displayState() {
		synchronized (lock) {
			System.out.println("Traffic Light is now: " + state);
		}
	}

}
