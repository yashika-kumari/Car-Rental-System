import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;
    private List<Rental> rentalHistory;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
        rentalHistory = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Rental> getRentalHistory() {
        return rentalHistory;
    }

    public List<Rental> getCurrentRentals() {
        return rentals;
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            double totalPrice = car.calculatePrice(days);
            Rental rental = new Rental(car, customer, days, totalPrice);
            rentals.add(rental);
            rentalHistory.add(rental);
        }
    }

    public void returnCar(Car car, int actualDays) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                rental.setActualDays(actualDays);
                if (actualDays > rental.getDays()) {
                    double fine = (actualDays - rental.getDays()) * 20.0;
                    rental.setFine(fine);
                }
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
        }
    }

    public List<Car> searchByBrandOrModel(String keyword) {
        List<Car> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        for (Car car : cars) {
            if (car.getBrand().toLowerCase().contains(lowerKeyword) ||
                car.getModel().toLowerCase().contains(lowerKeyword)) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> sortCarsByPrice() {
        List<Car> sortedCars = new ArrayList<>(cars);
        sortedCars.sort((c1, c2) -> Double.compare(c1.calculatePrice(1), c2.calculatePrice(1)));
        return sortedCars;
    }
}

