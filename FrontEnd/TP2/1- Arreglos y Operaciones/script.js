// VARIABLE PARA ALMACENAR EL ARREGLO
let arreglo = [];

// FUNCIÓN PARA GENERAR UN ARREGLO ALEATORIO
function generarArreglo() {
    arreglo = [];
    for (let i = 0; i < 10; i++) {
        arreglo.push(Math.floor(Math.random() * 100) + 1);
    }
}

// FUNCIÓN PARA CALCULAR LA SUMA
function calcularSuma() {
    return arreglo.reduce((a, b) => a + b, 0);
}

// FUNCIÓN PARA CALCULAR EL PROMEDIO
function calcularPromedio() {
    return calcularSuma() / arreglo.length;
}

// FUNCIÓN PARA ENCONTRAR EL MAYOR ELEMENTO
function encontrarMaximo() {
    return Math.max(...arreglo);
}

// FUNCIÓN PARA ENCONTRAR EL MENOR ELEMENTO
function encontrarMinimo() {
    return Math.min(...arreglo);
}

// FUNCIÓN PARA ELIMINAR EL PRIMER ELEMENTO
function eliminarPrimero() {
    arreglo.shift();
}

// FUNCIÓN PARA ELIMINAR EL ÚLTIMO ELEMENTO
function eliminarUltimo() {
    arreglo.pop();
}

// FUNCIÓN PARA AGREGAR UN NÚMERO ALEATORIO 
function agregarAleatorio() {
    let nuevoNumero = Math.floor(Math.random() * 100) + 1;
    arreglo.push(nuevoNumero);
}

// FUNCIÓN PARA ORDENAR DE MENOR A MAYOR
function ordenarArreglo() {
    arreglo.sort((a, b) => a - b);
}

// FUNCIÓN PARA INVERTIR EL ORDEN
function invertirArreglo() {
    arreglo.reverse();
}

// ASOCIACIÓN DE LOS BOTONES CON LAS FUNCIONES CORRESPONDIENTES
document.getElementById('crearArreglo').addEventListener('click', () => {
    generarArreglo();
    mostrarResultados();
});

document.getElementById('eliminarPrimero').addEventListener('click', () => {
    eliminarPrimero();
    mostrarResultados();
});

document.getElementById('eliminarUltimo').addEventListener('click', () => {
    eliminarUltimo();
    mostrarResultados();
});

document.getElementById('agregarAleatorio').addEventListener('click', () => {
    agregarAleatorio();
    mostrarResultados();
});

document.getElementById('ordenarArreglo').addEventListener('click', () => {
    ordenarArreglo();
    mostrarResultados();
});

document.getElementById('invertirArreglo').addEventListener('click', () => {
    invertirArreglo();
    mostrarResultados();
});

// FUNCIÓN PARA MOSTRAR EL ARREGLO EN HTML
function mostrarResultados() {
    let resultadosDiv = document.getElementById('resultados');
    resultadosDiv.innerHTML = `
        <p>Arreglo: [${arreglo.join(', ')}]</p>
        <p>Suma: ${calcularSuma()}</p>
        <p>Promedio: ${calcularPromedio()}</p>
        <p>Máximo: ${encontrarMaximo()}</p>
        <p>Mínimo: ${encontrarMinimo()}</p>
    `;
}
