import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Preload Cars
        rentalSystem.addCar(new Car("C001", "Toyota", "Camry", 2500.0));
        rentalSystem.addCar(new Car("C002", "Honda", "Accord", 2200.0));
        rentalSystem.addCar(new Car("C003", "Mahindra", "Thar", 3500.0));
        rentalSystem.addCar(new Car("C004", "Hyundai", "Creta", 1800.0));
        rentalSystem.addCar(new Car("C005", "Maruti", "Swift", 1200.0));
        rentalSystem.addCar(new Car("C006", "Tata", "Nexon", 1600.0));
        rentalSystem.addCar(new Car("C007", "Kia", "Seltos", 2000.0));
        rentalSystem.addCar(new Car("C008", "BMW", "320d", 6000.0));
        rentalSystem.addCar(new Car("C009", "Audi", "A4", 6500.0));
        rentalSystem.addCar(new Car("C010", "Mercedes", "C-Class", 7000.0));

        SwingUtilities.invokeLater(() -> new CarRentalGUI(rentalSystem));
    }
}

