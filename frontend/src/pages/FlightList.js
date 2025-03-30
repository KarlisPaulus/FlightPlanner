import React, { useEffect, useState } from "react";
import { getFlights } from "../api/backend";
import { Link } from "react-router-dom";

const FlightList = () => {
    const [flights, setFlights] = useState([]);

    useEffect(() => {
        getFlights().then((data) => {
            setFlights(data);
        });
    }, []);

    return (
        <div>
          <h1>All Flights</h1>
          <ul>
            {flights.map(flight => (
              <li key={flight.id}>
                <Link to={`/select-tickets/${flight.id}`}>{flight.destination} - {flight.date}</Link>
              </li>
            ))}
          </ul>
        </div>
      );
    };

export default FlightList;