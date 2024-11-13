package com.jts.traffic.gui;

import java.awt.Color;

public enum TrafficLightState {
	RED(Color.RED), 
	GREEN(Color.GREEN), 
	YELLOW(Color.YELLOW);

	private Color color;

	TrafficLightState(Color color) {
		this.setColor(color);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
