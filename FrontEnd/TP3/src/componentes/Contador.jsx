import { useState } from 'react'
import React from 'react'

export const Contador = ({titulo}) => {
    const [count, setCount] = useState(0)
    return (
    <>
    <div className="card">
      <button onClick={() => setCount((count) => count + 1)}>
      {titulo} {count} 
      </button>
    </div>
  </>
  )
}

