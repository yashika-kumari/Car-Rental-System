import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Preload Cars
        rentalSystem.addCar(new Car("C001", "Toyota", "Camry", 60.0));
        rentalSystem.addCar(new Car("C002", "Honda", "Accord", 70.0));
        rentalSystem.addCar(new Car("C003", "Mahindra", "Thar", 150.0));
        rentalSystem.addCar(new Car("C004", "Hyundai", "Creta", 65.0));
        rentalSystem.addCar(new Car("C005", "Maruti", "Swift", 45.0));
        rentalSystem.addCar(new Car("C006", "Tata", "Nexon", 80.0));
        rentalSystem.addCar(new Car("C007", "Kia", "Seltos", 85.0));
        rentalSystem.addCar(new Car("C008", "BMW", "320d", 200.0));
        rentalSystem.addCar(new Car("C009", "Audi", "A4", 220.0));
        rentalSystem.addCar(new Car("C010", "Mercedes", "C-Class", 250.0));

        SwingUtilities.invokeLater(() -> new CarRentalGUI(rentalSystem));
    }
}

