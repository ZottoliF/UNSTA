import React from 'react'
import "../styles/Tarjeta.css"

export const Tarjeta = ({nombre, apellido, profesion, descripcion}) => {
  return (
    <div className="tarjeta">
      <h2>{nombre} {apellido}</h2>
      <h3>{profesion}</h3>
      <p>{descripcion}</p>
    </div>
  )
}
