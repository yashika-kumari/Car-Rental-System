# 🚗 Car Rental System

A professional **Java Swing-based GUI application** for managing car rentals with dynamic car management, rental tracking, and automated billing.

---

## 📋 Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Key Classes](#key-classes)
- [Admin Mode](#admin-mode)
- [System Requirements](#system-requirements)
- [Technologies Used](#technologies-used)

---

## ✨ Features

### 🎯 Core Features

- **Rent a Car**: Browse available cars and rent them for specified days
- **Return a Car**: Return rented cars with automatic fine calculation for late returns
- **Dynamic Car Management**: Add new cars to the system without restarting (Admin feature)
- **Rental History**: View complete transaction history with billing details
- **Search Functionality**: Search cars by brand or model name
- **Price Sorting**: Sort available cars by daily rental price (ascending order)

### 💰 Billing System

- **Rental Receipt**: Automatic receipt generation with:
  - Customer name and ID
  - Car details (brand, model, ID)
  - Daily rental rate
  - Number of rental days
  - Total cost calculation

- **Late Return Charges**: 
  - Fine: **₹20 per extra day**
  - Automatic calculation and display
  - Final amount with all charges

- **GST Breakdown**:
  - Subtotal, 18% GST, and final payable amount are shown in the receipt
  - Display-only calculation for a more professional invoice look

### 🔐 Admin Features

- **Password-Protected Admin Panel** (Password: `admin123`)
- **Add New Cars**: Input car details in real-time
  - Car ID (unique identifier)
  - Brand name
  - Model name
  - Price per day
- **No Complex Setup**: Simply add cars and they appear in all system views

### 📊 Data Management

- **Real-time Updates**: All lists update automatically after operations
- **Persistent Rental History**: Complete transaction records
- **Car Status Tracking**: Available/Rented status for each vehicle
- **Availability Indicators**: Shows count of available vs. rented cars

### 🎨 User Interface

- **Professional Swing GUI**: Clean, modern design with color-coded buttons
- **Table-Based Display**: Easy-to-read tables with scrollable content
- **Responsive Feedback**: Status bar shows operation results
- **Dialog Boxes**: Clear confirmations and error messages
- **Intuitive Layout**: Left panel for operations, right panel for data display

---

## 📁 Project Structure

```
Car Rental System/
├── src/
│   ├── Car.java              # Car model with rental logic
│   ├── Customer.java         # Customer model
│   ├── Rental.java           # Rental transaction model with fine tracking
│   ├── CarRentalSystem.java  # Backend business logic
│   ├── CarRentalGUI.java     # Swing GUI interface (665 lines)
│   └── Main.java             # Entry point with preloaded cars
├── README.md                 # This file
└── .gitignore               # Git ignore file
```

---

## 🚀 Installation

### Prerequisites

- **Java 8 or higher** installed on your system
- **Git** (for cloning the repository)

### Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yashika-kumari/Car-Rental-System.git
   cd Car-Rental-System
   ```

2. **Navigate to Source Directory**
   ```bash
   cd src
   ```

3. **Compile the Project**
   ```bash
   javac *.java
   ```

4. **Run the Application**
   ```bash
   java Main
   ```

---

## 📖 Usage

### Main Window Layout

**Left Panel - Operations**
- Input fields for customer name, car ID, rental days
- Buttons for all operations
- Search field for finding cars

**Right Panel - Display**
- Professional table showing cars, history, or search results
- Scrollable content area
- Status bar showing operation feedback

### Step-by-Step Operations

#### 1️⃣ Rent a Car

1. Enter **Customer Name**
2. Enter **Car ID** (e.g., C001, c002) - *case-insensitive*
3. Enter **Rental Days** (must be > 0)
4. Click **"Rent Car"** button
5. Confirm rental in the dialog
6. Receipt is displayed with all charges
7. Car status updates to "Rented"

#### 2️⃣ Return a Car

1. Enter **Car ID** of the rented car
2. Enter **Actual Days Used**
3. Click **"Return Car"** button
4. System calculates:
   - Original charge based on booked days
   - Fine if actual days exceed booked days (₹20/extra day)
   - Subtotal, GST (18%), and total amount due
5. Return summary is displayed

#### 3️⃣ View All Cars

1. Click **"View All Cars"** button
2. See table with:
   - Car ID, Brand, Model
   - Daily rental price
   - Availability status (Available ✓ / Rented ✗)
3. Status shows count of available cars

#### 4️⃣ Search Cars

1. Enter search keyword in **"Search"** field (brand or model)
2. Click **"Search"** button
3. Table displays only matching cars
4. All car details shown in results

#### 5️⃣ Sort by Price

1. Click **"Sort by Price"** button
2. Cars displayed in ascending order of daily rental rate
3. Cheapest cars appear first

#### 6️⃣ View Rental History

1. Click **"View History"** button
2. Complete transaction history displayed in table:
   - Customer name
   - Car details (brand + model)
   - Days rented
   - Subtotal
   - Fine (if any)
   - GST
   - Total payable

#### 7️⃣ Admin Mode - Add Car

1. Click **"Admin Mode"** button
2. Enter password: `admin123`
3. If correct:
   - Admin panel opens
   - Enter Car ID (e.g., C011)
   - Enter Brand (e.g., Ferrari)
   - Enter Model (e.g., F8)
   - Enter Price/Day (e.g., 500)
4. Click **"Add Car"**
5. New car automatically appears in:
   - View All Cars
   - Search results
   - Available cars for rental

---

## 🔑 Key Classes

### **Car.java**
Represents a vehicle in the system.

**Properties:**
- `carId` - Unique identifier
- `brand` - Manufacturer name
- `model` - Car model name
- `basePricePerDay` - Rental rate per day
- `isAvailable` - Current availability status

**Methods:**
- `calculatePrice(int days)` - Total rental cost
- `rent()` - Mark car as rented
- `returnCar()` - Mark car as available

---

### **Customer.java**
Represents a customer renting a car.

**Properties:**
- `customerId` - Unique customer identifier
- `name` - Customer name

---

### **Rental.java**
Tracks individual rental transactions.

**Properties:**
- `car` - Rented car object
- `customer` - Renting customer
- `days` - Booked rental days
- `totalPrice` - Amount for booked days
- `actualDays` - Actual days used
- `fine` - Late return charges

---

### **CarRentalSystem.java**
Core backend business logic.

**Key Methods:**
- `addCar(Car car)` - Add new car to inventory
- `rentCar(Car car, Customer customer, int days)` - Process rental
- `returnCar(Car car, int actualDays)` - Process return with fine calculation
- `searchByBrandOrModel(String keyword)` - Search cars
- `sortCarsByPrice()` - Get cars sorted by price

---

### **CarRentalGUI.java**
Professional Swing-based user interface (665 lines).

**Features:**
- Complete GUI implementation
- Event handling for all buttons
- Table management and updates
- Dialog boxes for admin and confirmations
- Status bar feedback
- Error validation

---

### **Main.java**
Application entry point.

**Functionality:**
- Initializes CarRentalSystem
- Preloads 10 cars:
    -  - Toyota Camry (₹2500/day)
    -  - Honda Accord (₹2200/day)
    -  - Mahindra Thar (₹3500/day)
    -  - Hyundai Creta (₹1800/day)
    -  - Maruti Swift (₹1200/day)
    -  - Tata Nexon (₹1600/day)
    -  - Kia Seltos (₹2000/day)
    -  - BMW 320d (₹6000/day)
    -  - Audi A4 (₹6500/day)
    -  - Mercedes C-Class (₹7000/day)
- Launches GUI

---

## 🔐 Admin Mode Details

### Password Protection
- **Default Password:** `admin123`
- Password required before accessing admin panel
- Prevents unauthorized car additions

### Validation in Admin Panel
- ✅ All fields must be filled
- ✅ Car ID must be unique (no duplicates)
- ✅ Price must be a valid positive number > 0
- ❌ Error messages for invalid inputs

### Car Addition Process
1. Password verified
2. Admin form opens
3. Input car details
4. System validates
5. Car added to inventory
6. Automatically appears everywhere
7. Dialog closes after success

---

## 💻 System Requirements

| Requirement | Specification |
|-------------|---------------|
| **Java Version** | JDK 8 or higher |
| **Operating System** | Windows, macOS, Linux (any OS with Java) |
| **RAM** | Minimum 512 MB |
| **Screen Resolution** | Minimum 1280x800 (for optimal GUI display) |
| **Build Tool** | None (uses javac compiler) |

---

## 🛠️ Technologies Used

- **Java SE 8+** - Core programming language
- **Swing (javax.swing)** - GUI framework
- **ArrayList** - Data structure for car and rental storage
- **Object-Oriented Programming** - Design patterns and principles

---

## ✅ Validation & Error Handling

### Input Validation

- **Empty Fields**: Prevents submission with blank inputs
- **Numeric Validation**: Ensures days and prices are valid numbers
- **Positive Numbers**: Days and price must be > 0
- **Duplicate Car IDs**: Sistema prevents duplicate car IDs in admin mode
- **Car Availability**: Cannot rent unavailable cars
- **Rental Records**: Validates rental exists before return

### Error Messages

All errors displayed via clear dialog boxes:
- Invalid input format
- Missing required fields
- Car not found
- Car not available
- Duplicate ID
- Invalid price

---

## 🎓 Learning Outcomes

This project demonstrates:

✅ **Object-Oriented Design** - Classes, inheritance, encapsulation  
✅ **GUI Development** - Swing components, event handling  
✅ **Data Management** - ArrayList, object relationships  
✅ **Business Logic** - Rental algorithms, fine calculation  
✅ **File Organization** - Separate classes, clean code structure  
✅ **User Experience** - Professional interface, clear feedback  
✅ **Input Validation** - Error handling, data integrity  

---

## 📝 Sample Scenario

### Renting a Car

```
Customer: John Doe
Car ID: C001 (Toyota Camry - ₹2500/day)
Rental Days: 5

RECEIPT:
├─ Customer: John Doe (CUS1)
├─ Car: Toyota Camry
├─ Daily Rate: ₹2500
├─ Days: 5
├─ Subtotal: ₹12500
├─ GST (18%): ₹2250
└─ Total Payable: ₹14750
```

### Late Return with Fine

```
Booked Days: 5
Actual Days: 7
Extra Days: 2
Fine: 2 × ₹20 = ₹40

Original Cost: ₹12500
Fine: ₹40
Subtotal: ₹12540
GST (18%): ₹2257.20
─────────────
Total Due: ₹14797.20
```

---

## 🔄 Future Enhancements

Possible improvements for future versions:

- Database integration (MySQL/PostgreSQL)
- User authentication system
- Invoice PDF generation
- Email notifications
- Payment gateway integration
- Car maintenance tracking
- Multiple location support
- Advanced reporting and analytics
- Mobile app version

---

## 📄 License

This project is created for educational purposes as part of Java Lab coursework (B.Tech, Semester 4).

---

## 👤 Author

**Yashika Kumari**  
B.Tech Student | Semester 4 | Java Lab Project

---

## 📧 Contact & Support

For questions or issues:
- GitHub Issues: [Report Here](https://github.com/yashika-kumari/Car-Rental-System/issues)
- Check existing documentation above

---

## 🎉 Credits

- **Java Swing Documentation** - Oracle
- **Object-Oriented Design** - Course Curriculum
- **Best Practices** - Java Community Standards

---

**Last Updated:** April 2026  
**Version:** 1.0  
**Status:** ✅ Production Ready

