import React from 'react';
import FlightList from './FlightList';

function GuestPage() {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <p>You can view available flights but must login to book.</p>
      <FlightList />
    </div>
  );
}

export default GuestPage;
