import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import FlightList from './pages/FlightList';
import TicketSelectionPage from './pages/TicketSelectionPage';
import SeatSelectionPage from './pages/SeatSelectionPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<FlightList />} />
        <Route path="/select-tickets/:flightId" element={<TicketSelectionPage />} />
        <Route path="/seats/:flightId" element={<SeatSelectionPage />} />
      </Routes>
    </Router>
  );
}

export default App;
