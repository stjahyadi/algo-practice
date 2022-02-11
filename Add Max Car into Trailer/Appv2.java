package com.seanyoung;

import java.util.ArrayList;
import java.util.List;

class Car {
	private String name;
	private int length;
	private int weight;

	public Car(String name, int length, int weight) {
		this.name = name;
		this.length = length;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}

class Trailer {
	private int maxLength;
	private int maxWeight;
	private List<Car> cars = new ArrayList<>();

	public Trailer() {
		this.maxLength = 10;
		this.maxWeight = 10;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public void addCar(Car car) {
		this.getCars().add(car);
	}

	public void recalculateTrailer(int length, int weight) {
		this.setMaxLength(this.getMaxLength() - length);
		this.setMaxWeight(this.getMaxWeight() - weight);
	}

	public boolean isFit(Car car) {
		return car.getLength() <= maxLength && car.getWeight() <= maxWeight;
	}
}

public class Appv2 {
	public static void main(String[] args) {
		List<Trailer> trailers = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			Car c = new Car("Car" + i, i, i);
			int selected = trailers.size() == 0 ? 0 : trailers.size() - 1;
			if (trailers.size() == 0)
				trailers.add(new Trailer());
			else {
				selected = findAvailableTrailer(trailers, c, selected);
			}

			Trailer t = trailers.get(selected);
			if (t.isFit(c)) {
				t.addCar(c);
				t.recalculateTrailer(c.getLength(), c.getWeight());
			}
		}

		System.out.println("Total trailer: " + trailers.size());
	}

	private static int findAvailableTrailer(List<Trailer> trailers, Car c, int selected) {
		boolean fit = false;
		for (int j = 0; j < trailers.size(); j++) {
			if (trailers.get(j).isFit(c)) {
				selected = j;
				fit = true;
				break;
			}
		}
		if (!fit) {
			trailers.add(new Trailer());
			selected = trailers.size() - 1;
		}
		return selected;
	}
}
