package com.jts.traffic.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TrafficLightPanel extends JPanel {

	private static final long serialVersionUID = -7968041700562959050L;

	private TrafficLightState state;

	public TrafficLightPanel() {
		this.state = TrafficLightState.RED;
		setPreferredSize(new Dimension(100, 300));
	}

	public void setState(TrafficLightState state) {
		this.state = state;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		int lightDiameter = getWidth() / 2;
		int x = getWidth() / 4;
		int yRed = getHeight() / 6;
		int yYellow = getHeight() / 2 - lightDiameter / 2;
		int yGreen = getHeight() * 5 / 6 - lightDiameter;

		if (state == TrafficLightState.RED) {
			g.setColor(Color.RED);
			g.fillOval(x, yRed, lightDiameter, lightDiameter);
		} else {
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, yRed, lightDiameter, lightDiameter);
		}

		if (state == TrafficLightState.YELLOW) {
			g.setColor(Color.YELLOW);
			g.fillOval(x, yYellow, lightDiameter, lightDiameter);
		} else {
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, yYellow, lightDiameter, lightDiameter);
		}

		if (state == TrafficLightState.GREEN) {
			g.setColor(Color.GREEN);
			g.fillOval(x, yGreen, lightDiameter, lightDiameter);
		} else {
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, yGreen, lightDiameter, lightDiameter);
		}
	}

}
