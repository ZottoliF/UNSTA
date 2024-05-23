import React, { useState } from 'react';
import "../styles/Colores.css";

export const Colores = () => {
    // Array de colores aleatorios
    const colors = ['#FF5733', '#33FF57', '#3357FF', '#F33FF5', '#F5F33F'];

    // useState para manejar el estado de los colores
    const [selectedColor, setSelectedColor] = useState('#ccc');

    // Funcion para modificar el estado del color 
    const handleColorClick = (color) => {
        setSelectedColor(color);
    };

    return(
        <div className="container">
            <div className="color-list">
                {colors.map((color, index) => (
                <div
                    key={index}
                    className="color-box"
                    style={{ backgroundColor: color }}
                    onClick={() => handleColorClick(color)}
                ></div>
                ))}
            </div>
            <div className="cuadrado" style={{ backgroundColor: selectedColor }}></div>
        </div>
    )
}
