import React, { useEffect, useState } from "react";
import { Greetings } from "../components/greetings"
import "./home-page.css"

export const HomePage = () => {
    const [showGreeting, setShowGreeting] = useState(true);
    const [counter, setCounter] = useState(0);

    useEffect(()=> console.log('CAMBIO'))
    useEffect(()=> console.log('MONTATO'),[])
    useEffect(()=> console.log('AGGIORNATO'),[showGreeting])
    useEffect(()=> setCounter(i => i+1), [showGreeting])

    const showOrHide = () => {
        setShowGreeting(!showGreeting)
    }
    return (
        <div className="main-container">
            <div style={{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                alignItems: 'center'
            }}>
                <button onClick={showOrHide}>{showGreeting ? "Nascondi saluto" : "Mostra saluto"}</button>
                {showGreeting && <Greetings name="Valerio"/>}
                <h1 id="button-color">{counter}</h1>
            </div>
        </div>
    )
}