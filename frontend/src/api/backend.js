import axios from 'axios';

const API_URL = "http://localhost:8080"; // Ensure this matches your backend URL

export const getFlights = async () => {
    try {
    const response = await axios.get(`${API_URL}/flights`);
    return response.data;
    } catch (error) {
        console.error("Error fetching flights:", error);
        return [];
    }
};

export const getSeats = async (flightId) => {
    const response = await axios.get(`${API_URL}/seats/${flightId}`);
    return response.data;
};

export const recommendSeats = async (flightId, filters) => {
    const response = await axios.get(`${API_URL}/seats/filter/${flightId}`, {
        params: {
            numberOfTickets: 1, // Adjust as needed
            ...filters,
        },
    });
    return response.data;
};