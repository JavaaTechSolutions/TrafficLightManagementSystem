package com.jts.traffic.gui;

public class TrafficLightController implements Runnable {
	private final TrafficLight trafficLight;
	private final TrafficLightPanel panel;

	public TrafficLightController(TrafficLight trafficLight, TrafficLightPanel panel) {
		this.trafficLight = trafficLight;
		this.panel = panel;
	}

	@Override
	public void run() {
		while (true) {
			try {
				panel.setState(trafficLight.getState());
				Thread.sleep(trafficLight.getCurrentStateDuration());
				trafficLight.changeState();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
	}

}
