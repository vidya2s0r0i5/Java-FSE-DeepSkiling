import React from 'react';

const imageStyle = {
  width: '300px',
  height: '200px',
  borderRadius: '8px',
  objectFit: 'cover'
};

const containerStyle = {
  padding: '20px',
  fontFamily: 'Arial'
};

const cardStyle = {
  marginBottom: '20px',
  border: '1px solid #ccc',
  padding: '15px',
  borderRadius: '10px',
  backgroundColor: '#f9f9f9'
};

const offices = [
  {
    id: 1,
    name: "Tech Park",
    rent: 50000,
    address: "MG Road, Bangalore",
    image: "/images/techpark.jpg"
  },
  {
    id: 2,
    name: "Cyber Hub",
    rent: 70000,
    address: "Cyber City, Gurgaon",
    image: "/images/cyberhub.jpg"
  },
  {
    id: 3,
    name: "Eco Park",
    rent: 60000,
    address: "Whitefield, Bangalore",
    image: "/images/ecopark.jpg"
  }
];

function App() {
  return (
    <div style={containerStyle}>
      <h1>Office Space Rental App</h1>

      {offices.map((office) => (
        <div key={office.id} style={cardStyle}>
          <img src={office.image} alt={office.name} style={imageStyle} />

          <h2>{office.name}</h2>
          <p><strong>Address:</strong> {office.address}</p>
          <p>
            <strong>Rent:</strong>{' '}
            <span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
              ₹{office.rent}
            </span>
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;
