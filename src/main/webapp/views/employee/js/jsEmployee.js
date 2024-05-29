/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 * 
 * 
 */
/* scripts.js */
/* scripts.js */

$(document).ready(function() {
    // Aquí puedes escribir el código para manejar eventos, como hacer peticiones AJAX para obtener los datos de los horarios de los empleados y actualizar las tablas
    
    // Ejemplo de cómo podrías hacer una petición AJAX para obtener los datos de los horarios de entrada
    $.ajax({
        url: 'obtener_horarios_entrada',
        type: 'GET',
        success: function(data) {
            // Actualizar la tabla de registro de entrada con los datos obtenidos
            actualizarTablaEntrada(data);
        },
        error: function(xhr, status, error) {
            console.error('Error al obtener los horarios de entrada:', error);
        }
    });

    // Función para actualizar la tabla de registro de entrada
    function actualizarTablaEntrada(data) {
        // Código para actualizar la tabla de registro de entrada con los datos recibidos
    }
});