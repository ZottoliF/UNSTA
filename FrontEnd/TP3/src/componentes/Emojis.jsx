import React, { useState } from 'react';
import "../styles/Emojis.css"

export const Emojis = () => {
    const emojis = ['😀', '😂', '🥰', '😎', '😭', '🤔', '😴', '😜', '😡', '🥳'];   

    const [emoji, setEmoji] = useState('😀');

    const handleButtonClick = () => {
        const randomEmoji = emojis[Math.floor(Math.random() * emojis.length)];
        setEmoji(randomEmoji);
    };

    return(
        <div className="container_emoji">
            <div className="emoji">{emoji}</div>
            <button onClick={handleButtonClick} className="button_emoji">Emoji Aleatorio</button>
        </div>
    )
}