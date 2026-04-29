import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarRentalGUI {
    private JFrame frame;
    private JTextField customerNameField;
    private JTextField carIdField;
    private JTextField rentalDaysField;
    private JTextField actualDaysField;
    private JTextField searchField;
    private JPanel outputPanel;
    private final CarRentalSystem rentalSystem;
    private JPanel mainPanel;
    private JLabel statusLabel;
    private JTable carsTable;
    private static final String ADMIN_PASSWORD = "admin123";

    public CarRentalGUI(CarRentalSystem rentalSystem) {
        this.rentalSystem = rentalSystem;
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Car Rental System - Professional Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(250, 250, 250));

        // Title
        JLabel titleLabel = new JLabel("Car Rental System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(33, 33, 33));
        titleLabel.setBounds(50, 15, 400, 40);
        mainPanel.add(titleLabel);

        // Status Label
        statusLabel = new JLabel("Ready");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusLabel.setForeground(new Color(34, 139, 34));
        statusLabel.setBounds(900, 20, 250, 30);
        mainPanel.add(statusLabel);

        // Left Panel - Input Fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(20, 70, 350, 700);
        inputPanel.setBackground(new Color(255, 255, 255));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Operations"));

        // Customer Name
        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        nameLabel.setBounds(15, 20, 120, 20);
        inputPanel.add(nameLabel);

        customerNameField = new JTextField();
        customerNameField.setBounds(15, 42, 310, 32);
        customerNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        inputPanel.add(customerNameField);

        // Car ID
        JLabel carIdLabel = new JLabel("Car ID:");
        carIdLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        carIdLabel.setBounds(15, 80, 120, 20);
        inputPanel.add(carIdLabel);

        carIdField = new JTextField();
        carIdField.setBounds(15, 102, 310, 32);
        carIdField.setFont(new Font("Arial", Font.PLAIN, 12));
        inputPanel.add(carIdField);

        // Rental Days
        JLabel rentalDaysLabel = new JLabel("Rental Days:");
        rentalDaysLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        rentalDaysLabel.setBounds(15, 140, 120, 20);
        inputPanel.add(rentalDaysLabel);

        rentalDaysField = new JTextField();
        rentalDaysField.setBounds(15, 162, 310, 32);
        rentalDaysField.setFont(new Font("Arial", Font.PLAIN, 12));
        inputPanel.add(rentalDaysField);

        // Actual Days
        JLabel actualDaysLabel = new JLabel("Actual Days Used:");
        actualDaysLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        actualDaysLabel.setBounds(15, 200, 120, 20);
        inputPanel.add(actualDaysLabel);

        actualDaysField = new JTextField();
        actualDaysField.setBounds(15, 222, 310, 32);
        actualDaysField.setFont(new Font("Arial", Font.PLAIN, 12));
        inputPanel.add(actualDaysField);

        // Search Field
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        searchLabel.setBounds(15, 260, 120, 20);
        inputPanel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(15, 282, 310, 32);
        searchField.setFont(new Font("Arial", Font.PLAIN, 12));
        inputPanel.add(searchField);

        // Buttons Section
        int buttonY = 330;
        int buttonHeight = 38;

        JButton rentButton = new JButton("Rent Car");
        rentButton.setBounds(15, buttonY, 150, buttonHeight);
        rentButton.setBackground(new Color(0, 150, 200));
        rentButton.setForeground(Color.WHITE);
        rentButton.setFont(new Font("Arial", Font.BOLD, 12));
        rentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentButton.addActionListener(e -> rentCar());
        inputPanel.add(rentButton);

        JButton returnButton = new JButton("Return Car");
        returnButton.setBounds(175, buttonY, 150, buttonHeight);
        returnButton.setBackground(new Color(200, 50, 50));
        returnButton.setForeground(Color.WHITE);
        returnButton.setFont(new Font("Arial", Font.BOLD, 12));
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnButton.addActionListener(e -> returnCar());
        inputPanel.add(returnButton);

        buttonY += buttonHeight + 8;

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(15, buttonY, 150, buttonHeight);
        searchButton.setBackground(new Color(180, 140, 0));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Arial", Font.BOLD, 12));
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchButton.addActionListener(e -> searchCar());
        inputPanel.add(searchButton);

        JButton sortButton = new JButton("Sort by Price");
        sortButton.setBounds(175, buttonY, 150, buttonHeight);
        sortButton.setBackground(new Color(100, 50, 150));
        sortButton.setForeground(Color.WHITE);
        sortButton.setFont(new Font("Arial", Font.BOLD, 12));
        sortButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sortButton.addActionListener(e -> sortByPrice());
        inputPanel.add(sortButton);

        buttonY += buttonHeight + 8;

        JButton viewAllButton = new JButton("View All Cars");
        viewAllButton.setBounds(15, buttonY, 150, buttonHeight);
        viewAllButton.setBackground(new Color(60, 140, 80));
        viewAllButton.setForeground(Color.WHITE);
        viewAllButton.setFont(new Font("Arial", Font.BOLD, 12));
        viewAllButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewAllButton.addActionListener(e -> viewAllCars());
        inputPanel.add(viewAllButton);

        JButton historyButton = new JButton("View History");
        historyButton.setBounds(175, buttonY, 150, buttonHeight);
        historyButton.setBackground(new Color(120, 80, 120));
        historyButton.setForeground(Color.WHITE);
        historyButton.setFont(new Font("Arial", Font.BOLD, 12));
        historyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        historyButton.addActionListener(e -> viewHistory());
        inputPanel.add(historyButton);

        buttonY += buttonHeight + 8;

        JButton adminButton = new JButton("Admin Mode");
        adminButton.setBounds(15, buttonY, 310, buttonHeight);
        adminButton.setBackground(new Color(150, 80, 0));
        adminButton.setForeground(Color.WHITE);
        adminButton.setFont(new Font("Arial", Font.BOLD, 12));
        adminButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminButton.addActionListener(e -> adminMode());
        inputPanel.add(adminButton);

        buttonY += buttonHeight + 8;

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(15, buttonY, 310, buttonHeight);
        clearButton.setBackground(new Color(100, 100, 100));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 12));
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(e -> clearInputFields());
        inputPanel.add(clearButton);

        mainPanel.add(inputPanel);

        // Right Panel - Table View
        outputPanel = new JPanel();
        outputPanel.setLayout(null);
        outputPanel.setBounds(390, 70, 790, 700);
        outputPanel.setBackground(new Color(255, 255, 255));
        outputPanel.setBorder(BorderFactory.createTitledBorder("Display"));

        // Create table for cars
        String[] columns = {"ID", "Brand", "Model", "Price/Day", "Status"};
        Object[][] data = getCarTableData(rentalSystem.getCars());
        carsTable = new JTable(data, columns);
        carsTable.setFont(new Font("Arial", Font.PLAIN, 12));
        carsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        carsTable.getTableHeader().setBackground(new Color(33, 150, 243));
        carsTable.getTableHeader().setForeground(Color.WHITE);
        carsTable.setRowHeight(25);
        carsTable.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(carsTable);
        scrollPane.setBounds(15, 25, 760, 660);
        outputPanel.add(scrollPane);

        mainPanel.add(outputPanel);

        frame.add(mainPanel);
        frame.setVisible(true);

        // Initial display
        viewAllCars();
    }

    private Object[][] getCarTableData(List<Car> cars) {
        Object[][] data = new Object[cars.size()][5];
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            data[i][0] = car.getCarId();
            data[i][1] = car.getBrand();
            data[i][2] = car.getModel();
            data[i][3] = "$" + String.format("%.2f", car.calculatePrice(1));
            data[i][4] = car.isAvailable() ? "Available" : "Rented";
        }
        return data;
    }

    private void updateCarTable(List<Car> cars) {
        Object[][] data = getCarTableData(cars);
        String[] columns = {"ID", "Brand", "Model", "Price/Day", "Status"};
        carsTable.setModel(new javax.swing.table.DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        carsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        carsTable.getTableHeader().setBackground(new Color(33, 150, 243));
        carsTable.getTableHeader().setForeground(Color.WHITE);
    }

    private void clearInputFields() {
        customerNameField.setText("");
        carIdField.setText("");
        rentalDaysField.setText("");
        actualDaysField.setText("");
        searchField.setText("");
    }

    private void rentCar() {
        String customerName = customerNameField.getText().trim();
        String carId = carIdField.getText().trim().toUpperCase();
        String daysStr = rentalDaysField.getText().trim();

        if (!validateInputs(customerName, carId, daysStr)) {
            JOptionPane.showMessageDialog(frame, "Please fill all rental fields with valid data!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int days = Integer.parseInt(daysStr);
            if (days <= 0) {
                JOptionPane.showMessageDialog(frame, "Rental days must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Car selectedCar = null;
            for (Car car : rentalSystem.getCars()) {
                if (car.getCarId().equalsIgnoreCase(carId) && car.isAvailable()) {
                    selectedCar = car;
                    break;
                }
            }

            if (selectedCar == null) {
                statusLabel.setText("ERROR: Car ID not found or unavailable");
                statusLabel.setForeground(new Color(200, 50, 50));
                JOptionPane.showMessageDialog(frame, "Car ID '" + carId + "' not found or not available!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double totalPrice = selectedCar.calculatePrice(days);
            Customer newCustomer = new Customer("CUS" + (rentalSystem.getRentalHistory().size() + 1), customerName);
            rentalSystem.addCustomer(newCustomer);
            rentalSystem.rentCar(selectedCar, newCustomer, days);

            String message = "Car rented successfully!\n\n" +
                    "Customer: " + customerName + "\n" +
                    "Car: " + selectedCar.getBrand() + " " + selectedCar.getModel() + "\n" +
                    "Rental Days: " + days + "\n" +
                    "Total Cost: $" + String.format("%.2f", totalPrice);

            JOptionPane.showMessageDialog(frame, message, "Rental Successful", JOptionPane.INFORMATION_MESSAGE);
            
            statusLabel.setText("Car rented: " + carId + " to " + customerName);
            statusLabel.setForeground(new Color(34, 139, 34));
            
            clearInputFields();
            viewAllCars();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for rental days!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void returnCar() {
        String carId = carIdField.getText().trim().toUpperCase();
        String actualDaysStr = actualDaysField.getText().trim();

        if (carId.isEmpty() || actualDaysStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter Car ID and Actual Days Used!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int actualDays = Integer.parseInt(actualDaysStr);
            if (actualDays <= 0) {
                JOptionPane.showMessageDialog(frame, "Actual days must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Car carToReturn = null;
            Rental currentRental = null;

            for (Car car : rentalSystem.getCars()) {
                if (car.getCarId().equalsIgnoreCase(carId) && !car.isAvailable()) {
                    carToReturn = car;
                    break;
                }
            }

            if (carToReturn == null) {
                statusLabel.setText("ERROR: Car not found or not rented");
                statusLabel.setForeground(new Color(200, 50, 50));
                JOptionPane.showMessageDialog(frame, "Car ID '" + carId + "' not found or not currently rented!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Rental rental : rentalSystem.getCurrentRentals()) {
                if (rental.getCar() == carToReturn) {
                    currentRental = rental;
                    break;
                }
            }

            if (currentRental == null) {
                statusLabel.setText("ERROR: No rental record found");
                statusLabel.setForeground(new Color(200, 50, 50));
                return;
            }

            rentalSystem.returnCar(carToReturn, actualDays);
            
            double fine = 0;
            if (actualDays > currentRental.getDays()) {
                fine = (actualDays - currentRental.getDays()) * 20.0;
            }
            
            String message = "Car returned successfully!\n\n" +
                    "Customer: " + currentRental.getCustomer().getName() + "\n" +
                    "Car: " + carToReturn.getBrand() + " " + carToReturn.getModel() + "\n" +
                    "Booked Days: " + currentRental.getDays() + "\n" +
                    "Actual Days: " + actualDays + "\n" +
                    "Original Cost: $" + String.format("%.2f", currentRental.getTotalPrice()) + "\n" +
                    (fine > 0 ? "Fine: $" + String.format("%.2f", fine) + "\n" : "") +
                    "Total Amount: $" + String.format("%.2f", currentRental.getTotalPrice() + fine);

            JOptionPane.showMessageDialog(frame, message, "Return Successful", JOptionPane.INFORMATION_MESSAGE);

            statusLabel.setText("Car returned: " + carId);
            statusLabel.setForeground(new Color(34, 139, 34));
            
            clearInputFields();
            viewAllCars();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for actual days!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewHistory() {
        List<Rental> history = rentalSystem.getRentalHistory();

        if (history.isEmpty()) {
            statusLabel.setText("No rental history");
            statusLabel.setForeground(new Color(100, 100, 100));
            JOptionPane.showMessageDialog(frame, "No rental history available yet.", "History", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Create table for history
        String[] columns = {"Customer", "Car", "Days", "Base Cost", "Fine", "Total"};
        Object[][] data = new Object[history.size()][6];
        
        for (int i = 0; i < history.size(); i++) {
            Rental rental = history.get(i);
            data[i][0] = rental.getCustomer().getName();
            data[i][1] = rental.getCar().getBrand() + " " + rental.getCar().getModel();
            data[i][2] = rental.getDays();
            data[i][3] = "$" + String.format("%.2f", rental.getTotalPrice());
            data[i][4] = "$" + String.format("%.2f", rental.getFine());
            data[i][5] = "$" + String.format("%.2f", rental.getTotalPrice() + rental.getFine());
        }

        carsTable.setModel(new javax.swing.table.DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        statusLabel.setText("Showing rental history (" + history.size() + " records)");
        statusLabel.setForeground(new Color(34, 139, 34));
    }

    private void searchCar() {
        String keyword = searchField.getText().trim();

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a search term (Brand or Model)!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Car> results = rentalSystem.searchByBrandOrModel(keyword);

        if (results.isEmpty()) {
            statusLabel.setText("No cars found matching: " + keyword);
            statusLabel.setForeground(new Color(200, 50, 50));
            JOptionPane.showMessageDialog(frame, "No cars found matching '" + keyword + "'", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        updateCarTable(results);
        statusLabel.setText("Found " + results.size() + " car(s) matching '" + keyword + "'");
        statusLabel.setForeground(new Color(34, 139, 34));
        searchField.setText("");
    }

    private void sortByPrice() {
        List<Car> sortedCars = rentalSystem.sortCarsByPrice();
        updateCarTable(sortedCars);
        statusLabel.setText("Cars sorted by price (ascending)");
        statusLabel.setForeground(new Color(34, 139, 34));
    }

    private void viewAllCars() {
        List<Car> cars = rentalSystem.getCars();

        if (cars.isEmpty()) {
            statusLabel.setText("No cars in system");
            statusLabel.setForeground(new Color(100, 100, 100));
            return;
        }

        updateCarTable(cars);
        
        int availableCount = 0;
        for (Car car : cars) {
            if (car.isAvailable()) availableCount++;
        }

        statusLabel.setText("Showing all cars (" + availableCount + " available, " + (cars.size() - availableCount) + " rented)");
        statusLabel.setForeground(new Color(34, 139, 34));
    }

    private void adminMode() {
        // First, prompt for password
        JPasswordField passwordField = new JPasswordField();
        int result = JOptionPane.showConfirmDialog(frame, passwordField, "Enter Admin Password:", JOptionPane.OK_CANCEL_OPTION);

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        String enteredPassword = new String(passwordField.getPassword());
        if (!enteredPassword.equals(ADMIN_PASSWORD)) {
            JOptionPane.showMessageDialog(frame, "Incorrect password! Admin access denied.", "Access Denied", JOptionPane.ERROR_MESSAGE);
            statusLabel.setText("Failed admin login attempt");
            statusLabel.setForeground(new Color(200, 50, 50));
            return;
        }

        // Password accepted, show admin dialog
        JDialog adminDialog = new JDialog(frame, "Admin Mode - Add New Car", true);
        adminDialog.setSize(450, 400);
        adminDialog.setLocationRelativeTo(frame);
        adminDialog.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(250, 250, 250));

        // Title
        JLabel titleLabel = new JLabel("Admin Panel - Add New Car");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(150, 80, 0));
        titleLabel.setBounds(80, 15, 300, 30);
        panel.add(titleLabel);

        // Car ID
        JLabel carIdLabel = new JLabel("Car ID:");
        carIdLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        carIdLabel.setBounds(30, 60, 100, 25);
        panel.add(carIdLabel);

        JTextField carIdField = new JTextField();
        carIdField.setBounds(150, 60, 270, 32);
        carIdField.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(carIdField);

        // Brand
        JLabel brandLabel = new JLabel("Brand:");
        brandLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        brandLabel.setBounds(30, 100, 100, 25);
        panel.add(brandLabel);

        JTextField brandField = new JTextField();
        brandField.setBounds(150, 100, 270, 32);
        brandField.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(brandField);

        // Model
        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        modelLabel.setBounds(30, 140, 100, 25);
        panel.add(modelLabel);

        JTextField modelField = new JTextField();
        modelField.setBounds(150, 140, 270, 32);
        modelField.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(modelField);

        // Price per Day
        JLabel priceLabel = new JLabel("Price/Day:");
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        priceLabel.setBounds(30, 180, 100, 25);
        panel.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(150, 180, 270, 32);
        priceField.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(priceField);

        // Buttons
        JButton addButton = new JButton("Add Car");
        addButton.setBounds(100, 230, 120, 45);
        addButton.setBackground(new Color(34, 139, 34));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.BOLD, 12));
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(addButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 230, 120, 45);
        cancelButton.setBackground(new Color(200, 50, 50));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 12));
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(cancelButton);

        // Status Label
        JLabel statusLabel2 = new JLabel("");
        statusLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        statusLabel2.setBounds(30, 290, 390, 50);
        statusLabel2.setVerticalAlignment(JLabel.TOP);
        panel.add(statusLabel2);

        // Add Car Button Action
        addButton.addActionListener(e -> {
            String carId = carIdField.getText().trim().toUpperCase();
            String brand = brandField.getText().trim();
            String model = modelField.getText().trim();
            String priceStr = priceField.getText().trim();

            if (carId.isEmpty() || brand.isEmpty() || model.isEmpty() || priceStr.isEmpty()) {
                statusLabel2.setForeground(new Color(200, 50, 50));
                statusLabel2.setText("ERROR: Please fill all fields!");
                return;
            }

            // Check if car ID already exists
            for (Car car : rentalSystem.getCars()) {
                if (car.getCarId().equalsIgnoreCase(carId)) {
                    statusLabel2.setForeground(new Color(200, 50, 50));
                    statusLabel2.setText("ERROR: Car ID '" + carId + "' already exists!");
                    return;
                }
            }

            try {
                double price = Double.parseDouble(priceStr);
                if (price <= 0) {
                    statusLabel2.setForeground(new Color(200, 50, 50));
                    statusLabel2.setText("ERROR: Price must be greater than 0!");
                    return;
                }

                // Add car to system
                Car newCar = new Car(carId, brand, model, price);
                rentalSystem.addCar(newCar);

                statusLabel2.setForeground(new Color(34, 139, 34));
                statusLabel2.setText("SUCCESS: Car '" + carId + "' added successfully!");

                // Clear fields
                carIdField.setText("");
                brandField.setText("");
                modelField.setText("");
                priceField.setText("");

                // Schedule dialog close
                java.util.Timer timer = new java.util.Timer();
                timer.schedule(new java.util.TimerTask() {
                    @Override
                    public void run() {
                        adminDialog.dispose();
                        viewAllCars();
                    }
                }, 1200);

            } catch (NumberFormatException ex) {
                statusLabel2.setForeground(new Color(200, 50, 50));
                statusLabel2.setText("ERROR: Price must be a valid number!");
            }
        });

        // Cancel Button Action
        cancelButton.addActionListener(e -> adminDialog.dispose());

        adminDialog.add(panel);
        adminDialog.setVisible(true);
        
        statusLabel.setText("Admin mode accessed");
        statusLabel.setForeground(new Color(34, 139, 34));
    }

    private boolean validateInputs(String name, String carId, String days) {
        if (name.isEmpty() || carId.isEmpty() || days.isEmpty()) {
            return false;
        }

        try {
            Integer.parseInt(days);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

