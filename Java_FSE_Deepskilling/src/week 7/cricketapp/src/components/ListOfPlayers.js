import React from 'react';

const ListOfPlayers = () => {
  const players = [
    { name: 'Virat', score: 95 },
    { name: 'Rohit', score: 65 },
    { name: 'Dhoni', score: 88 },
    { name: 'KL Rahul', score: 55 },
    { name: 'Hardik', score: 75 },
    { name: 'Shami', score: 60 },
    { name: 'Bumrah', score: 82 },
    { name: 'Pant', score: 45 },
    { name: 'Jadeja', score: 91 },
    { name: 'Gill', score: 66 },
    { name: 'Surya', score: 50 }
  ];

  // Use map to display all
  const playerList = players.map((p, i) => (
    <li key={i}>{p.name} - {p.score}</li>
  ));

  // Filter with arrow function
  const below70 = players.filter(p => p.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>{playerList}</ul>

      <h3>Players Scored Below 70</h3>
      <ul>
        {below70.map((p, i) => <li key={i}>{p.name} - {p.score}</li>)}
      </ul>
    </div>
  );
};

export default ListOfPlayers;
