import React from 'react';

function FlightList() {
  const flights = [
    { id: 1, from: "Delhi", to: "Mumbai", price: 4500 },
    { id: 2, from: "Chennai", to: "Bangalore", price: 3200 },
    { id: 3, from: "Hyderabad", to: "Kolkata", price: 6000 }
  ];

  return (
    <div>
      <h2>Available Flights</h2>
      <ul>
        {flights.map(flight => (
          <li key={flight.id}>
            {flight.from} → {flight.to} : ₹{flight.price}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FlightList;
