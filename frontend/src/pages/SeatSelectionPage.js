import React from 'react';
import { useLocation } from 'react-router-dom';

const SeatSelectionPage = () => {
  const location = useLocation();
  const { seats, filters } = location.state || { seats: [], filters: {} };

  return (
    <div>
      <h1>Recommended Seats</h1>
      <ul>
        {seats.length ? (
          seats.map((seat, index) => (
            <li key={index}>
              {seat.seatNumber} - {seat.available ? 'Available' : 'Taken'}
            </li>
          ))
        ) : (
          <p>No seats found based on your filters.</p>
        )}
      </ul>
      <p>Filters applied:</p>
      <ul>
        <li>Window: {filters.window ? 'Yes' : 'No'}</li>
        <li>Extra Legroom: {filters.extraLegroom ? 'Yes' : 'No'}</li>
        <li>Close to Exit: {filters.closeToExit ? 'Yes' : 'No'}</li>
        <li>Side-by-Side: {filters.sideBySide ? 'Yes' : 'No'}</li>
      </ul>
    </div>
  );
};

export default SeatSelectionPage;