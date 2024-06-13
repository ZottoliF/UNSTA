import React from "react";
import List from "@mui/material/List";
import TodoItem from "./TodoItem";

// Componente para la lista de tareas
const TodoList = ({ list, toggleComplete, deleteItem }) => {
  return (
    <List sx={{ mt: 2 }}>
      {/* Mapeo de la lista de tareas para renderizar cada tarea individual */}
      {list.map((item) => (
        <TodoItem
          key={item.id}
          item={item}
          toggleComplete={toggleComplete}
          deleteItem={deleteItem}
        />
      ))}
    </List>
  );
};

export default TodoList;
