import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const converted = (parseFloat(rupees) / 90).toFixed(2); // 1 Euro ≈ ₹90 (approx)
    setEuro(converted);
  };

  return (
    <div style={{ marginTop: '30px' }}>
      <h2>Currency Convertor</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Enter amount in ₹"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
        />
        <button type="submit">Convert</button>
      </form>
      {euro && <p>Euro: €{euro}</p>}
    </div>
  );
}

export default CurrencyConvertor;
