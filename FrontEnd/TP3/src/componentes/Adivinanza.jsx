import React, { useState } from 'react';
import '../styles/Adivinanza.css';

export const Adivinanza = () => {
  const [randomNumber, setRandomNumber] = useState(Math.floor(Math.random() * 100) + 1);
  const [guess, setGuess] = useState('');
  const [message, setMessage] = useState('');

  const handleGuessChange = (event) => {
    setGuess(event.target.value);
  };

  const handleGuessSubmit = (event) => {
    event.preventDefault();
    const userGuess = parseInt(guess, 10);
    if (userGuess === randomNumber) {
      setMessage('¡Correcto! Adivinaste el número.');
    } else if (userGuess < randomNumber) {
      setMessage('Demasiado bajo. Inténtalo de nuevo.');
    } else {
      setMessage('Demasiado alto. Inténtalo de nuevo.');
    }
  };

  return (
    <div className="adivinanza">
      <h2>Adivina el Número</h2>
      <form onSubmit={handleGuessSubmit}>
        <input
          type="number"
          value={guess}
          onChange={handleGuessChange}
          placeholder="Ingresa un número"
        />
        <button type="submit">Adivinar</button>
      </form>
      <p>{message}</p>
    </div>
  );
};