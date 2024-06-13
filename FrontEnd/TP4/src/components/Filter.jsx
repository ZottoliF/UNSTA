import React from "react";
import FormControl from "@mui/material/FormControl";
import InputLabel from "@mui/material/InputLabel";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";

// Componente para el filtro de tareas  
const Filter = ({ filter, handleFilterChange }) => {
  return (
    <FormControl fullWidth sx={{ mt: 2 }}>
      {/* Etiqueta del filtro */}
      <InputLabel id="filter-label">Filtrar</InputLabel>
      {/* Selector del filtro */}
      <Select
        labelId="filter-label"
        id="filter-select"
        value={filter}
        label="Filter"
        onChange={handleFilterChange}
      >
        <MenuItem value="all">Todas</MenuItem>
        <MenuItem value="completed">Completadas</MenuItem>
        <MenuItem value="incomplete">Incompletas</MenuItem>
      </Select>
    </FormControl>
  );
};

export default Filter;