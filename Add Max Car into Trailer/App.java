import java.util.ArrayList;
import java.util.List;

/*
Create a logic to add the maximum car into a trailer.
*/

class Car {
	private String name;
	private int weight;
	private int price;
	private int length;

	public Car() {
	}

	public Car(String name, int weight, int price, int length) {
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.length = length;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Trailer {
	private int maxWeight;
	private int maxPrice;
	private int maxLength;
	private List<Car> cars = new ArrayList<Car>();

	public Trailer(int maxWeight, int maxPrice, int maxLength) {
		this.maxWeight = maxWeight;
		this.maxPrice = maxPrice;
		this.maxLength = maxLength;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public boolean isFit(Car car) {
		return getMaxWeight() >= car.getWeight() && getMaxLength() >= car.getLength()
				&& getMaxPrice() >= car.getPrice();
	}
}

public class App {
	
	public static void main(String[] args) {
		List<Car> cars = new ArrayList<Car>();
		Car car = new Car("car1", 1, 1, 1);
		Car car2 = new Car("car2", 1, 2, 1);
		Car car3 = new Car("car3", 2, 1, 2);
		Car car4 = new Car("car4", 1, 2, 1);
		cars.add(car);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		Trailer trailerSpec = new Trailer(5, 5, 5);
		assert solution(cars, trailerSpec).size() == 2;
	}

	public static List<Trailer> solution(List<Car> cars, Trailer trailerSpec) {
		List<Trailer> trailers = new ArrayList<Trailer>();
		Trailer trailer = new Trailer(trailerSpec.getMaxWeight(), trailerSpec.getMaxPrice(),
				trailerSpec.getMaxLength());
		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			if (trailer.isFit(car)) {
				trailer.setMaxWeight(trailer.getMaxWeight() - car.getWeight());
				trailer.setMaxLength(trailer.getMaxLength() - car.getLength());
				trailer.setMaxPrice(trailer.getMaxPrice() - car.getPrice());
				trailer.getCars().add(car);
			}

			if ((i >= cars.size() - 1 || !trailer.isFit(car)) && !trailer.getCars().isEmpty()) {
				trailers.add(trailer);
				trailer = new Trailer(trailerSpec.getMaxWeight(), trailerSpec.getMaxPrice(),
						trailerSpec.getMaxLength());
			}
		}
		return trailers;
	}
}
