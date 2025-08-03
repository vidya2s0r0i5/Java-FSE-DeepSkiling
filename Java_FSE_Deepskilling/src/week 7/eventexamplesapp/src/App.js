import React from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      clickedMsg: ''
    };
    // Bind if needed (not required with arrow functions)
    this.increment = this.increment.bind(this);
  }

  increment() {
    this.setState(prev => ({ count: prev.count + 1 }));
    this.sayHello();
  }

  sayHello = () => {
    alert("Hello! You clicked Increase.");
  }

  decrement = () => {
    this.setState(prev => ({ count: prev.count - 1 }));
  }

  sayWelcome = (message) => {
    alert(message);
  }

  handleSyntheticEvent = (e) => {
    e.preventDefault();
    this.setState({ clickedMsg: "I was clicked" });
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h1>React Event Examples</h1>

        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.increment}>Increase</button>{' '}
        <button onClick={this.decrement}>Decrease</button>

        <hr />

        <button onClick={() => this.sayWelcome("Welcome to React Events!")}>
          Say Welcome
        </button>

        <hr />

        <button onClick={this.handleSyntheticEvent}>OnPress</button>
        <p>{this.state.clickedMsg}</p>

        <hr />

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
