function validarFormulario() {
    // OBTENCIÓN DE VALORES DE LOS INPUTS Y LIMPIEZA DE ESPACIOS EN BLANCO
    var nombre = document.getElementById('nombre').value.trim();
    var apellido = document.getElementById('apellido').value.trim();
    var legajo = document.getElementById('legajo').value.trim();
    var email = document.getElementById('email').value.trim();

    // REINICIALIZACIÓN DE MENSAJES DE ERROR
    document.getElementById('errorNombre').textContent = "";
    document.getElementById('errorApellido').textContent = "";
    document.getElementById('errorLegajo').textContent = "";
    document.getElementById('errorEmail').textContent = "";

    // VALIDACIÓN DE CAMPOS VACÍOS Y MOSTRAR MENSAJE DE ERROR
    if (nombre === "") {
        document.getElementById('errorNombre').textContent = "Ingrese su nombre.";
        return false;
    }

    if (apellido === "") {
        document.getElementById('errorApellido').textContent = "Ingrese su apellido";
        return false;
    }

    if (legajo === "") {
        document.getElementById('errorLegajo').textContent = "Ingrese su legajo";
        return false;
    }

    if (email === "") {
        document.getElementById('errorEmail').textContent = "Ingrese su correo electrónico";
        return false;
    }

    // VALIDACIÓN FORMATO DE CORREO ELECTRÓNICO
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        document.getElementById('errorEmail').textContent = "El correo electrónico no es válido";
        return false;
    }

    // OCULTAR FORMULARIO DE ALUMNO Y MOSTRAR EL DE CALCULAR PROMEDIO
    document.getElementById("alumnoForm").style.display = "none";
    document.getElementById("calcularPromedio").style.display = "block";

    // EVITA QUE SE ENVÍE EL FORMULARIO
    return false;
}

function calcularPromedio(event) {
    event.preventDefault();

    // OBTENCIÓN DE VALORES DE LAS NOTAS Y CÁLCULO DEL PROMEDIO
    var nota1 = parseFloat(document.getElementById("nota1").value);
    var nota2 = parseFloat(document.getElementById("nota2").value);
    var nota3 = parseFloat(document.getElementById("nota3").value);
    var nota4 = parseFloat(document.getElementById("nota4").value);
    var nota5 = parseFloat(document.getElementById("nota5").value);
    var promedio = (nota1 + nota2 + nota3 + nota4 + nota5) / 5;

    // MOSTRAR EL RESULTADO DEL PROMEDIO
    document.getElementById("resultadoPromedio").innerText = promedio.toFixed(2);
}
