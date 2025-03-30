# FlightPlanner

FlightPlanner is a web application designed to help users find flights and filter available seats based on various criteria.

## Features
- Filter flights
- View flight details
- Filter seats

---

## Technologies Used
- **Frontend**: React.js
- **Backend**: Java 21 with Spring Boot, H2 database

---

## Installation instructions
- **Clone the Repository**
    ```bash
    git clone https://github.com/KarlisPaulus/FlightPlanner
### Backend

1. **Navigate to the Backend Directory:**
    ```bash
    cd backend
    ```
2. **Build the Project Using Maven:**
    ```bash
    mvn clean install
    ```
3. **Run the Application:**
    ```bash
    mvn spring-boot:run
    ```
    The default port is 8080

### Frontend
1. **Navigate to the frontend directory:**
    ```bash
    cd frontend
    ```
2. **Install dependencies:**
    ```bash
    npm install
    ```
3. **Start the development server:**
    ```bash
    npm start
    ```
4. **Open your browser and navigate to `http://localhost:3000`**


### Usage

1. Start the backend server.
2. Start the frontend development server.
3. Open http://localhost:3000 in your browser.
4. Use the application to search for and book flights.

### Backend API Endpoints

- **Endpoint:** `GET /flights`
- **Parameters:**
    - `destination:` The destination of the flight (optional).
    - `date:` The date of the flight in YYYY-MM-DD format (optional).
    - `maxPrice:` The maximum price of the flight (optional).
    - `departureTime:` The departure time of the flight in HH:MM:SS format (optional).
    - `arrivalTime:` The arrival time of the flight in HH:MM:SS format (optional).
    - **Description:** Retrieves a list of flights based on the specified filters.
- **Example:** http://localhost:8080/flights?destination=Tallinn

---

- **Endpoint:** `GET /seats/{flightId}`
- **Parameters:**
    - `flightId:` The ID of the flight for which seats are being retrieved (required).
    - **Description:** Retrieves a list of all seats for a specific flight.
- **Example:** http://localhost:8080/seats/1

---

- **Endpoint:** `GET /seats/filter/{flightId}`
- **Parameters:**
    - `flightId:` The ID of the flight for which seat recommendations are being retrieved (required).
    - `numberOfTickets:` The number of tickets to book (required).
    - `window:` Whether to prioritize window seats (optional, default: false).
    - `extraLegroom:` Whether to prioritize seats with extra legroom (optional, default: false).
    - `closeToExit:` Whether to prioritize seats close to the exit (optional, default: false).
    - `sideBySide:` Whether to prioritize seats that are side by side (optional, default: false).
    - **Description:** Retrieves a list of recommended seats based on the specified filters.
- **Example:** http://localhost:8080/seats/filter/1?numberOfTickets=2&window=true&sideBySide=true