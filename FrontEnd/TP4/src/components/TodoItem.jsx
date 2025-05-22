import React from "react";
import ListItem from "@mui/material/ListItem";
import ListItemText from "@mui/material/ListItemText";
import IconButton from "@mui/material/IconButton";
import DeleteIcon from "@mui/icons-material/Delete";
import Checkbox from "@mui/material/Checkbox";

// Componente para cada tarea individual
const TodoItem = ({ item, toggleComplete, deleteItem }) => {
  return (
    <ListItem key={item.id} disablePadding>
      {/* Checkbox para marcar la tarea como completada */}
      <Checkbox
        checked={item.completed}
        onChange={() => toggleComplete(item.id)}
      />
      {/* Texto de la tarea */}
      <ListItemText primary={item.title} />
      <div>
        {/* Botón para eliminar la tarea */}
        <IconButton
          aria-label="delete"
          onClick={() => deleteItem(item.id)}
        >
          <DeleteIcon />
        </IconButton>
      </div>
    </ListItem>
  );
};

export default TodoItem;
