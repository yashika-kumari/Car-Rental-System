public class Rental {
    private Car car;
    private Customer customer;
    private int days;
    private double totalPrice;
    private int actualDays;
    private double fine;

    public Rental(Car car, Customer customer, int days, double totalPrice) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        this.totalPrice = totalPrice;
        this.actualDays = days;
        this.fine = 0.0;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getActualDays() {
        return actualDays;
    }

    public void setActualDays(int actualDays) {
        this.actualDays = actualDays;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}

