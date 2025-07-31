import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScores';

function App() {
  return (
    <div className="App">
      <CalculateScore 
        name="6400615"
        school="DigitalNuture Java FSE"
        total={480}
        goal={6}
      />
    </div>
  );
}

export default App;
