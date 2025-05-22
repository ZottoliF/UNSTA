import React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";

// Componente para la entrada de nuevas tareas
const TodoInput = ({ userInput, updateInput, addItem }) => {
  return (
    <Box mt={2}>
      {/* Campo de texto para la entrada del usuario */}
      <TextField
        label="Agregar tarea..."
        variant="outlined"
        fullWidth
        size="large"    
        value={userInput}
        onChange={(e) => updateInput(e.target.value)}
      />
      {/* Botón para agregar la nueva tarea */}
      <Button
        variant="contained"
        color="primary"
        onClick={addItem}
        size="large"
        sx={{ mt: 2 }}
      >
        Agregar tarea
      </Button>
    </Box>
  );
};

export default TodoInput;
