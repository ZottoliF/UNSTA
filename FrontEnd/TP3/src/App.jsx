import './App.css'
import { Contador } from './componentes/Contador'
import { Tarjeta } from './componentes/Tarjeta'
import { Colores } from './componentes/Colores'
import { Emojis } from './componentes/Emojis'
import { Adivinanza } from './componentes/Adivinanza'

function App() {

  return (
    <>
      <Contador titulo='Contador:' /> 
      <Tarjeta nombre='Facundo' apellido='Zottoli' profesion='Programador Junior' descripcion='Soy una persona de rapido aprendizaje, con muchas ganas de tener nuevos conocimientos.' />
      <Colores />
      <Emojis />
      <Adivinanza />
    </>
  )
}

export default App
