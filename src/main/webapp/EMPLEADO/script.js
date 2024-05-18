function agregarEntrada() {
    var empleadoId = document.getElementById('employee').value;
    var fechaEntrada = document.getElementById('entrada').value;
    if (fechaEntrada) {
        document.getElementById('entrada-' + empleadoId).innerText = new Date(fechaEntrada).toLocaleString();
    } else {
        alert('Por favor, seleccione una fecha de entrada.');
    }
}

function agregarSalida() {
    var empleadoId = document.getElementById('employee').value;
    var fechaSalida = document.getElementById('salida').value;
    if (fechaSalida) {
        document.getElementById('salida-' + empleadoId).innerText = new Date(fechaSalida).toLocaleString();
    } else {
        alert('Por favor, seleccione una fecha de salida.');
    }
}
