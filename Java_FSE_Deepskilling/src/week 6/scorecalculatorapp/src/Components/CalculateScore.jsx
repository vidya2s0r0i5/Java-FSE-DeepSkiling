// src/Components/CalculateScore.jsx
import React from 'react';

function CalculateScore(props) {
  const average = (props.total / props.goal).toFixed(2);

  return (
    <div className="score-container">
      <h2>Student Score Report</h2>
      <p><strong>Name:</strong> {props.name}</p>
      <p><strong>School:</strong> {props.school}</p>
      <p><strong>Total Score:</strong> {props.total}</p>
      <p><strong>Goal:</strong> {props.goal}</p>
      <p><strong>Average Score:</strong> {average}</p>
    </div>
  );
}

export default CalculateScore;
