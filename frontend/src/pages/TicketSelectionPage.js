import React, { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { recommendSeats } from '../api/backend'; // Assuming this exists in backend.js

const TicketSelectionPage = () => {
  const { flightId } = useParams();
  const navigate = useNavigate();

  const [numberOfTickets, setNumberOfTickets] = useState(1);
  const [filters, setFilters] = useState({
    window: false,
    extraLegroom: false,
    closeToExit: false,
    sideBySide: false,
  });

  const handleFilterChange = (e) => {
    const { name, checked } = e.target;
    setFilters(prev => ({ ...prev, [name]: checked }));
  };

  const handleTicketCountChange = (e) => {
    setNumberOfTickets(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const filteredSeats = await recommendSeats(flightId, { ...filters, numberOfTickets });
    navigate(`/seats/${flightId}`, { state: { seats: filteredSeats, filters } });
  };

  return (
    <div>
      <h1>Select Tickets for Flight {flightId}</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Number of Tickets:</label>
          <input
            type="number"
            value={numberOfTickets}
            onChange={handleTicketCountChange}
            min="1"
          />
        </div>
        <div>
          <label>
            <input
              type="checkbox"
              name="window"
              checked={filters.window}
              onChange={handleFilterChange}
            />
            Window Seat
          </label>
          <label>
            <input
              type="checkbox"
              name="extraLegroom"
              checked={filters.extraLegroom}
              onChange={handleFilterChange}
            />
            Extra Legroom
          </label>
          <label>
            <input
              type="checkbox"
              name="closeToExit"
              checked={filters.closeToExit}
              onChange={handleFilterChange}
            />
            Close to Exit
          </label>

          {numberOfTickets > 1 && (
            <label>
              <input
                type="checkbox"
                name="sideBySide"
                checked={filters.sideBySide}
                onChange={handleFilterChange}
              />
              Side-by-Side
            </label>
          )}
        </div>
        <button type="submit">Find Seats</button>
      </form>
    </div>
  );
};

export default TicketSelectionPage;