import React, { useState, useEffect } from "react";
import axios from "axios";
import Container from "@mui/material/Container";
import Box from "@mui/material/Box";
import TodoInput from "./components/TodoInput";
import TodoList from "./components/TodoList";
import Filter from "./components/Filter";

const App = () => {
  // Estado para el input del usuario
  const [userInput, setUserInput] = useState("");
  // Estado para la lista de tareas
  const [list, setList] = useState([]);
  // Estado para el filtro de las tareas
  const [filter, setFilter] = useState("all");

  // Efecto para cargar las tareas desde una API al montar el componente
  useEffect(() => {
    axios.get("https://jsonplaceholder.typicode.com/todos")
      .then(response => {
        setList(response.data);
      })
      .catch(error => {
        console.error("Error fetching the todos", error);
      });
  }, []);

  // Actualizar el estado del input del usuario
  const updateInput = (value) => {
    setUserInput(value);
  };

  // Agregar una nueva tarea a la lista
  const addItem = () => {
    if (userInput.trim() !== "") {
      const newItem = {
        id: Math.random(),
        title: userInput,
        completed: false,
      };
      setList([newItem, ...list]);
      setUserInput("");
    }
  };

  // Eliminar una tarea de la lista
  const deleteItem = (id) => {
    const updatedList = list.filter((item) => item.id !== id);
    setList(updatedList);
  };

  // Alternar el estado de completado de una tarea
  const toggleComplete = (id) => {
    const updatedList = list.map((item) =>
      item.id === id ? { ...item, completed: !item.completed } : item
    );
    setList(updatedList);
  };

  // Actualizar el estado del filtro
  const handleFilterChange = (event) => {
    setFilter(event.target.value);
  };

  // Filtrar la lista de tareas según el filtro seleccionado
  const filteredList = list.filter(item => {
    if (filter === "completed") return item.completed;
    if (filter === "incomplete") return !item.completed;
    return true;
  });

  return (
    <Container>
      {/* Título */}
      <Box
        sx={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          fontSize: "3rem",
          fontWeight: "bolder",
          marginTop: "2rem",
        }}
      >
        Lista de tareas
      </Box>

      {/* Componente para la entrada de nuevas tareas */}
      <TodoInput
        userInput={userInput}
        updateInput={updateInput}
        addItem={addItem}
      />

      {/* Componente para el filtro de tareas */}
      <Filter filter={filter} handleFilterChange={handleFilterChange} />

      {/* Componente para la lista de tareas */}
      <TodoList
        list={filteredList}
        toggleComplete={toggleComplete}
        deleteItem={deleteItem}
      />
    </Container>
  );
};

export default App;
