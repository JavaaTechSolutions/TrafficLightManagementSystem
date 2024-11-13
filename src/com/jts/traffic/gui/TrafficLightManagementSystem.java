package com.jts.traffic.gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TrafficLightManagementSystem {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Traffic Light Management System");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new GridLayout(1, 2));
			
			TrafficLight trafficLight1 = new TrafficLight(5000, 2000, 5000);
			TrafficLightPanel panel1 = new TrafficLightPanel();
			TrafficLightController controller1 = new TrafficLightController(trafficLight1, panel1);
			new Thread(controller1).start();
			
			TrafficLight trafficLight2 = new TrafficLight(5000, 2000, 5000);
			TrafficLightPanel panel2 = new TrafficLightPanel();
			TrafficLightController controller2 = new TrafficLightController(trafficLight2, panel2);
			new Thread(controller2).start();
			
			frame.add(panel1);
			frame.add(panel2);
			frame.pack();
			frame.setVisible(true);
		});
	}

}
