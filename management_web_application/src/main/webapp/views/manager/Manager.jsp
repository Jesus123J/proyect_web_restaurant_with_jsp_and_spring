<%@ page import="com.utp.management_web_application.data.dto.AccountDto" %>
<%@ page import="com.utp.management_web_application.data.dao.ManagerDao" %>
<%@ page import="com.utp.management_web_application.data.rest.LoginResponse" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    .table-light {
        font-size: 16px; /* Ajusta el tamaño del texto */
        color: black; /* Cambia el color del texto a negro */
    }
    .table-light td {
        padding: 20px; /* Ajusta el tamaño de las celdas */
    }
</style>
<%
    ManagerDao managerDao = new ManagerDao();
    AccountDto accountDto = managerDao.dataCompletManager(((LoginResponse) request.getSession().getAttribute("sessionAccount")).getToken());
%>
<main>
    <div class="container-main">
        <div id="section-user">
            <img class="img_user" src="views/manager/resource/User.png" alt="imgUser">
            <ul class="list">
                <li class="list-item" id="AreaEmpleado" onclick="changeContainerShowEmployeeManager(false)">Area de empleado</li>
                <li class="list-item" id="AreaPedidos" onclick="changeContainerShowOrderManager()">Area de pedidos</li>
                <li class="list-item" id="AreaAlmacen" onclick="changeContainerShowStoreManager()">Area de almacen</li>
            </ul>
            <button type="button" class="btn btn-primary b_exit">Salir</button>
        </div>
        <div id="content">
            <div class="section-info">
                <label class="info">Nombre completo: <%= accountDto.getName().concat(" " + accountDto.getLastname().concat(" " + accountDto.getMotherLastname()))%></label>
                <label class="info">Cargo: <%= ((LoginResponse) request.getSession().getAttribute("sessionAccount")).getRoleType()%></label>
                <label class="info" style="background-color: greenyellow">Estado: Activado</label>
            </div>
        </div>
        <div id="content">
            <div class="container-info" id="float">

            </div>
        </div>
    </div>
</main>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<!-- Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="ajax/ajax.js" type="text/javascript"></script>

<script>
  function downloadPDF() {
        const url = `http://localhost:8080/Raccon_Brothers/ControllerManager?downloadPDF=true`;

        fetch(url, { method: 'GET' })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Ocurrió un error al descargar el PDF.');
                }
                return response.blob();
            })
            .then(blob => {
                const url = URL.createObjectURL(blob);

                // Abrir el PDF en una nueva pestaña
                window.open(url, '_blank');

                URL.revokeObjectURL(url);
            })
            .catch(error => {
                console.error('Error al descargar el PDF:', error);
                alert('Error al descargar el PDF. Por favor, inténtelo de nuevo más tarde.');
            });
    }
                    // Declarar observer antes de usarlo
                    const observer = new MutationObserver((mutationsList, observer) => {
                        for (const mutation of mutationsList) {
                            if (mutation.type === 'childList') {
                                // Llama a fetchEmployees cada vez que hay un cambio en el contenido
                                fetchEmployees();
                                break; // Si no deseas múltiples llamadas, puedes salir del bucle.
                            }
                        }
                    });

                    // Observador de mutaciones para el div con id "content"
                    const contentDiv = document.getElementById('float');
                    observer.observe(contentDiv, {childList: true, subtree: true});

                    const createEmployeeRow = (employee) => {
                        const {fullName, email, cellphone, dni, accountType} = employee;

                        const row = document.createElement("tr");
                        row.classList.add("table-light");

                        const tdFullName = document.createElement("td");
                        tdFullName.textContent = fullName;

                        const tdEmail = document.createElement("td");
                        tdEmail.textContent = email;

                        const tdCellphone = document.createElement("td");
                        tdCellphone.textContent = cellphone;

                        const tdDni = document.createElement("td");
                        tdDni.textContent = dni;

                        const tdAccountType = document.createElement("td");
                        tdAccountType.textContent = accountType;

                        row.appendChild(tdFullName);
                        row.appendChild(tdEmail);
                        row.appendChild(tdCellphone);
                        row.appendChild(tdDni);
                        row.appendChild(tdAccountType);

                        return row;
                    };

                    async function fetchEmployees() {
                        const action = 'showEmployeeManager';
                        try {
                            const response = await fetch('http://localhost:8080/Raccon_Brothers/ControllerManager', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json'
                                },
                                body: JSON.stringify({
                                    action: action,
                                    veri: true
                                })
                            });

                            if (!response.ok) {
                                throw new Error('Network response was not ok ' + response.statusText);
                            }

                            const employees = await response.json();
                            console.log("Received employees:", employees);

                            const employeeTableBody = document.getElementById('employeeTableBody');
                            employeeTableBody.innerHTML = ''; // Clear existing rows

                            employees.forEach((employee) => {
                                const row = createEmployeeRow(employee);
                                employeeTableBody.appendChild(row);
                            });

                        } catch (error) {
                            console.error('There was a problem with the fetch operation:', error);
                        }
                    }

                    // Llamar a la función fetchEmployees() cuando la página se haya cargado
                    document.addEventListener('DOMContentLoaded', (event) => {
                        fetchEmployees();
                    });
</script>
