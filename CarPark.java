import java.lang.*;
import java.util.Scanner;

public class CarPark {

	private int totalTrucks = 0;
	private int totalCars = 0;
	private int totalFees = 0;
	private Truck[] trucks;
	private Car[] cars;
	int enterCar = 0;
	int exitCar = 0;
	int enterTruck = 0;
	int exitTruck=0;

	public CarPark(int totalTrucks, int totalCars, int totalFees, Truck[] trucks, Car[] cars, Scanner carparkScanner,
			String choice, int totalSpace) {
		super();
		this.totalTrucks = totalTrucks;
		this.totalCars = totalCars;
		this.totalFees = totalFees;
		this.trucks = trucks;
		this.cars = cars;
		this.carparkScanner = carparkScanner;
		this.choice = choice;
		this.totalSpace = totalSpace;
	}

	Scanner carparkScanner;
	String choice = carparkScanner.nextLine();
	int totalSpace = carparkScanner.nextInt();

	public void main(String[] args) {
		enterChoice(choice, totalSpace);

	}

	public void enterChoice(String choice, int totalSpace) {
		System.out.println("How many car spaces does the car park have? \n");
		System.out.println("User:" + totalSpace);

		while (choice != null) {
			switch (choice) {
			case "ENTER CAR":
				addCar(choice);
				break;
			case "ENTER TRUCK":
				addTruck(choice);
				break;
			case "EXIT CAR":
				removeCar();
				CalculateCarFee(choice);
				break;
			case "EXIT TRUCK":
				removeTruck();
				CalculateTruckFee(choice);
				break;
			case "REPORT":
				PrintReport();
				break;
			case "QUIT":
				break;
			}
		}
	}

	private void CalculateTruckFee(String Choice) {
		if (choice.contains("[\\d]")) {
			String clean = choice.replaceAll("[\\D+]", "");
			int hours = Integer.parseInt(clean);

			int truckFee = 3 * hours;
			totalFees += truckFee;
		}

	}

	private void CalculateCarFee(String Choice) {
		if (choice.contains("[\\d]")) {
			String clean = choice.replaceAll("[\\D+]", "");
			int hours = Integer.parseInt(clean);

			int carFee = 2 * hours;
			totalFees += carFee;

		}

	}

	private void PrintReport() {
		System.out.println("Cars Entered:" + enterCar);
		System.out.println("Trucks Entered:" + enterTruck);
		System.out.println("Cars Exited:" + exitTruck);
		System.out.println("Trucks Exited:" + exitTruck);
		System.out.println("Parking Cars:" + totalCars);
		System.out.println("Parking Trucks:" + totalTrucks);
		System.out.println("Spaces Available:" + totalSpace);
		System.out.println("Fees Paid: $" + totalFees);

	}

	public void addTruck(String choice) {
		if (totalSpace >= 2) {
			totalTrucks++;
			enterCar++;
		} else {
			System.out.println("Not enough space for a truck");
		}
	}

	public void removeTruck() {
		totalSpace = totalSpace - 2;
		totalTrucks--;
		exitTruck++;
	}

	public void addCar(String choice) {
		if (totalSpace >= 1)
			totalTrucks++;
		else
			System.out.println("Not enough space for a car");
	}

	public void removeCar() {
		totalSpace = totalSpace - 1;
		totalCars--;
		exitCar++;
	}

}
