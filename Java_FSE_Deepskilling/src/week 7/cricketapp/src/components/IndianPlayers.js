import React from 'react';

const IndianPlayers = () => {
  const oddPlayers = ['Virat', 'Dhoni', 'Hardik', 'Pant', 'Gill'];
  const evenPlayers = ['Rohit', 'KL Rahul', 'Shami', 'Jadeja', 'Bumrah', 'Surya'];

  // Destructuring
  const [odd1, odd2, ...restOdd] = oddPlayers;
  const [even1, even2, ...restEven] = evenPlayers;

  // Merge with spread
  const T20Players = ['Virat', 'Rohit', 'Surya'];
  const RanjiTrophyPlayers = ['Manish', 'Karun', 'Pujara'];
  const allPlayers = [...T20Players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        {restOdd.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        {restEven.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>All Indian Cricket Players</h2>
      <ul>
        {allPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
