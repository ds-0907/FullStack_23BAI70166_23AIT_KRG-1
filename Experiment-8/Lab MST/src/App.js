import React, { useState } from "react";
import './App.css';

export default function App() {
  const [count, setCount] = useState(0);

  const increment = () => {
    if (count < 10) {
      setCount(count + 1);
    }
  };

  const decrement = () => {
    if (count > 0) {
      setCount(count - 1);
    }
  };

  return (
    <div className="counter-container">
        <h1 className="counter-title">Counter</h1>
        <p className="counter-display">{count}</p>

        <div className="button-container">
          <button className="counter-button" onClick={decrement} disabled={count === 0}>Decrement</button>
          <button className="counter-button" onClick={increment} disabled={count === 10}>Increment</button>
        </div>

        {count === 10 && <p className="limit-message">Maximum limit reached</p>}
      </div>
  );
}
