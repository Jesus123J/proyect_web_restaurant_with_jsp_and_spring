




/* global response, text */

async function changeContainerRegisterEmployeeAdmin(token) {

    const action = 'createEmployee';
    try {
        const response = await fetch('ControllerAdministrator', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                action: action
            })
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const text = await response.text();
        document.getElementById('rightForm').innerHTML = text;
        insetDataTableManagerEmployeeList(token);
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}
/*  */

async function changeContainerShowEmployeeAdmin() {

    const action = 'showEmployee';

    try {
        const response = await fetch('ControllerAdministrator', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                action: action
            })
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const text = await response.text();
        document.getElementById('rightForm').innerHTML = text;

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

/* */

async function changeContainerShowStoreAdmin(token) {

    const action = 'showStore';

    try {
        const response = await fetch('ControllerAdministrator', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                action: action
            })
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const text = await response.text();
        document.getElementById('rightForm').innerHTML = text
        fetchProducts(token);

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

/* */


async function changeContainerShowOrderAdmin(token) {

    const action = 'showOrder';

    try {
        const response = await fetch('ControllerAdministrator', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                action: action
            })
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const text = await response.text();
        document.getElementById('rightForm').innerHTML = text;
        fetchOrders(token);

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}
async function fetchOrders(token) {
    try {
        const response = await fetch('http://localhost:9091/boss/order/list'
                , {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': token
                    }
                });
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const data = await response.json();
        populateTable(data.bossOrders);
    } catch (error) {
        console.error('Error fetching orders:', error);
    }
}

function populateTable(orders) {
    const tableBody = document.querySelector('#ordersTable tbody');
    tableBody.innerHTML = ''; // Limpiar tabla antes de agregar nuevos datos

    orders.forEach(order => {
        const row = document.createElement('tr');

        // Crear celdas y añadir valores
        row.innerHTML = `
            <td>${order.id}</td>
            <td>${order.clientName}</td>
            <td>${order.orderCode}</td>
            <td>${order.orderPrice}</td>
            <td>${order.createTime || 'N/A'}</td>
            <td>${order.updateTime || 'N/A'}</td>
        `;

        // Añadir la fila a la tabla
        tableBody.appendChild(row);
    });
}

// function of the method 
async function changeContainerShowStoreManager() {

    const action = 'showStoreManager';
    console.log("store");
    try {
        const response = await fetch('http://localhost:8080/Raccon_Brothers/ControllerManager', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                action: action,
                veri: false
            })
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const text = await response.text();
        document.getElementsByClassName('container-info')[0].innerHTML = text;
        const elements = document.getElementsByClassName('container-info');
        for (let element of elements) {
            element.innerHTML = text;
        }

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

async function changeContainerShowEmployeeManager(verificaion) {
    const action = 'showEmployeeManager';

    try {
        const response = await fetch('http://localhost:8080/Raccon_Brothers/ControllerManager', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'eyJpZEFjY291bnQiOjQsImlkUGVyc29uIjo0LCJzdGF0dXMiOjEsInVzZXJuYW1lIjoieWFucGllcmNhdmVyb0BnbWFpbC5jb20iLCJuYW1lIjoiWUFOUElFUiIsImxhc3RuYW1lIjoiQ0FWRVJPIiwibW90aGVyTGFzdG5hbWUiOiJQT1JSTyIsImlkUm9sZSI6NCwicm9sZVR5cGUiOiJFTVBMRUFETyJ9'
            },
            body: JSON.stringify({
                action: action,
                veri: verificaion

            })
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const contentType = response.headers.get('Content-Type');

        if (contentType.includes('application/json')) {
            console.log("json");
            const employees = await response.json();
            let tableHtml = '';
            employees.forEach(employee => {
                tableHtml += `
                <tr class="table-light">
                    <td>${employee.fullName}</td>
                    <td>${employee.email}</td>
                    <td>${employee.cellphone}</td>
                    <td>${employee.dni}</td>
                    <td>${employee.accountType}</td>
                </tr>
            `;
            });

        } else if (contentType.includes('text/html')) {
            console.log("html");
            const text = await response.text();
            document.getElementsByClassName('container-info')[0].innerHTML = text;
            const elements = document.getElementsByClassName('container-info');
            for (let element of elements) {
                element.innerHTML = text;
            }
        } else {
            throw new Error('Unsupported content type');
        }

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

async function changeContainerShowOrderManager() {

    const action = 'showOrderManager';
    console.log("order");
    try {
        const response = await fetch('http://localhost:8080/Raccon_Brothers/ControllerManager', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                action: action,
                veri: false
            })
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const text = await response.text();
        document.getElementsByClassName('container-info')[0].innerHTML = text;
        const elements = document.getElementsByClassName('container-info');
        for (let element of elements) {
            element.innerHTML = text;
        }
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

async function  componentLoadingTable(token) {
    try {
        const responseData = await fetch('http://localhost:9091/employee/dataEmployee',
                {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': token
                    }
                });

        responseDataEmployee = await  responseData.json();

        const response = await fetch('http://localhost:9091/boss/attendance/employee/list?idAccount=' + responseDataEmployee.idAccount,
                {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'eyJpZEFjY291bnQiOjIsImlkUGVyc29uIjoyLCJzdGF0dXMiOjEsInVzZXJuYW1lIjoiamVzdXN0aGlhZ29AZ21haWwuY29tIiwibmFtZSI6IkpFU1VTIiwibGFzdG5hbWUiOiJUSElBR08iLCJtb3RoZXJMYXN0bmFtZSI6IlRPUlJFUyIsImlkUm9sZSI6Miwicm9sZVR5cGUiOiJKRUZFIn0='
                    }
                });

        responseDatePicker = await response.json();
        responseDatePicker.bossEmployeeHistoryAttendances.forEach(fecha => {
            // Obtenemos el elemento tbody de la tabla
            const tbody = document.querySelector('#descansosTable tbody');

            const date = new Date(fecha.entryTime);

            // Opciones de formato para la fecha y la hora
            const options = {
                year: 'numeric',
                month: 'long',
                day: 'numeric',
                hour: '2-digit',
                minute: '2-digit',
                second: '2-digit',
                hour12: false
            };

            // Formatear la fecha y la hora
            const formattedDate = new Intl.DateTimeFormat('es-ES', options).format(date);


            // Crear una nueva fila con la fecha y hora actual
            const row = document.createElement('tr');
            const cell = document.createElement('td');
            cell.textContent = formattedDate;
            row.appendChild(cell);
            tbody.appendChild(row);
        });

    } catch (e) {
        console.error('There was a problem with the fetch operation:', e);
    }
}
async function componentContext(token) {
    try {
        const response = await fetch('http://localhost:9091/employee/register-entry', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': token
            }
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const responseJson = await response.json();

        // Mostrar mensaje de respuesta
        alert(responseJson.message);
        if (responseJson.status === 400) {
            return;
        }
        // Obtener la fecha y hora actual
        const currentDateTime = new Date();
        const formattedDateTime = currentDateTime.toLocaleString(); // Formato legible de fecha y hora

        // Obtenemos el elemento tbody de la tabla
        const tbody = document.querySelector('#descansosTable tbody');

        // Crear una nueva fila con la fecha y hora actual
        const row = document.createElement('tr');
        const cell = document.createElement('td');
        cell.textContent = formattedDateTime;
        row.appendChild(cell);
        tbody.appendChild(row);

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

let precioTotal = 0.00; // Inicializar el precio total con el valor actual

async function listaProductos(token) {
    try {
        console.log(token);
        const response = await fetch('http://localhost:9091/manager/product/list', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': token
            }
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const data = await response.json();
        console.log(data);

        // Crear la tabla y añadir los datos de los productos
        let tableHtml = '<table class="table">';
        tableHtml += '<thead><tr><th>ID</th><th>Código</th><th>Nombre</th><th>Precio</th><th>Acción</th></tr></thead>';
        tableHtml += '<tbody>';

        data.managerProducts.forEach(product => {
            tableHtml += `<tr>
                                <td>${product.id}</td>
                                <td>${product.code}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td><button class="btn btn-primary" onclick="agregarProducto(${product})">Agregar</button></td>
                              </tr>`;
        });

        tableHtml += '</tbody></table>';

        // Insertar la tabla en el modal
        document.querySelector('#exampleModalCenter .modal-body').innerHTML = tableHtml;

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

function openModal(token) {
    document.getElementById('exampleModalCenter').style.display = 'flex';
    console.log("Puto + " + token);
    listaProductos(token); // Reemplaza con el token real
}

function closeModal() {
    document.getElementById('exampleModalCenter').style.display = 'none';
}

//crear variables
let ListaProductos;


// Función para manejar el evento de agregar producto
function agregarProducto(producto) {
    console.log(`Producto con precio ${producto} agregado.`);
    ListaProductos.push(producto);
    actualizarPrecioTotal(producto.price);

}

function actualizarPrecioTotal(price) {
    precioTotal += price;
    document.querySelector('.l-pedido p').textContent = precioTotal.toFixed(2);
}

function registroPedido() {
    console.log(ListaProductos);

}

async function componentAsync(token) {
    //El  clase fetch  es una libreria propia de javascript hace una promesa en el cual  espera la respusta
    // method diferentes tipos :
    //GET es de atraer 
    //POST es de enviar algo 

    const responsesEmployee = await fetch('http://localhost:9091/boss/product/list',
            {
                method: 'GET',
                headers: {
                    'Content-type': '',
                    'Authorization': token
                },
                body: JSON.stringify({
                    action: ''
                })
            }
    );

    const responseJson = await responsesEmployee.json();


}



async function insetDataTableManagerEmployeeList(token) {
    console.log("Hola ");
    console.log(token);

    try {
        const response = await fetch('http://localhost:9091/boss/employee/list', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': token
            }
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const responseJson = await response.json();
        const employees = responseJson.boosEmployees;  // Corregir el nombre del campo en el JSON de respuesta

        console.log(responseJson);

        // Obtener el cuerpo de la tabla
        const tbody = document.getElementById('employeeTableBody');

        // Limpiar la tabla
        tbody.innerHTML = '';

        // Agregar nuevas filas
        employees.forEach(employee => {
            // Separar fullName en nombre, apellido paterno y apellido materno
            const [nombre, apellidoPaterno, apellidoMaterno] = employee.fullName.split(' ');

            // Crear una nueva fila
            const row = document.createElement('tr');

            // Crear y agregar las celdas a la fila
            row.innerHTML = `
                <td>${nombre}</td>
                <td>${apellidoPaterno}</td>
                <td>${apellidoMaterno}</td>
                <td>${employee.email}</td>
                <td>${employee.cellphone}</td>
                <td>${employee.dni}</td>
                <td>${employee.accountType}</td>
                 <td>
                    <button class="btn btn-warning" onclick='editEmployee(${JSON.stringify(employee)})'>Editar</button>
                    <button class="btn btn-danger" onclick='editAccount(${JSON.stringify(employee)})'>Editar Cuenta</button>
                </td>
            `;

            // Agregar la fila al cuerpo de la tabla
            tbody.appendChild(row);
        });

    } catch (error) {
        console.error('Hubo un problema con la operación de fetch:', error);
    }
}

async function addEmployee(token) {
    // Obtener los valores del formulario
    const nombre = document.querySelector('input[name="nombre"]').value;
    const apellidoPaterno = document.querySelector('input[name="apellidoPaterno"]').value;
    const apellidoMaterno = document.querySelector('input[name="apellidoMaterno"]').value;
    const email = document.querySelector('input[name="email"]').value;
    const celular = document.querySelector('input[name="celular"]').value;
    const dni = document.querySelector('input[name="dni"]').value;
    const rol = document.getElementById('rolSelect').value; // Ajusta este valor según el campo de rol


    // Crear un objeto con esos valores
    const employeeData = {
        name: nombre,
        lastname: apellidoPaterno,
        motherLastname: apellidoMaterno,
        email: email,
        cellphone: celular,
        dni: dni,
        role: parseInt(rol)
    };

    console.log("Modelo que se da ala clase de json : " + employeeData);
    try {
        // Enviar una solicitud POST usando fetch
        const response = await fetch('http://localhost:9091/boss/employee/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': token  // Asegúrate de añadir el token de autorización
            },
            body: JSON.stringify(employeeData)
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const responseJson = await response.json();
        console.log("Respues : " + responseJson);
        if (responseJson.status === 200) {
            document.querySelector('input[name="nombre"]').value = '';
            document.querySelector('input[name="apellidoPaterno"]').value = '';
            document.querySelector('input[name="apellidoMaterno"]').value = '';
            document.querySelector('input[name="email"]').value = '';
            document.querySelector('input[name="celular"]').value = '';
            document.querySelector('input[name="dni"]').value = '';
            document.getElementById('rolSelect').value = '';
            alert(responseJson.message);
            insetDataTableManagerEmployeeList(token);
        } else {
            alert(responseJson.message);
        }

        // Opcional: Puedes agregar lógica aquí para actualizar la tabla o hacer algo después de añadir el empleado

    } catch (error) {
        console.error('Hubo un problema con la operación de fetch:', error);
    }
}
function editEmployee(employee) {

    console.log("Edit employee with ID: " + employee.id);
    console.log("Id account aaaaaaaaaaa : " + employee.idAccount);
    // Rellenar el formulario del modal con los datos del empleado
    document.getElementById('editEmployeeId').value = employee.id;

    document.getElementById('editEmployeeAccountId').value = employee.idAccount;
    document.getElementById('editEmployeeName').value = employee.fullName.split(' ')[0];
    document.getElementById('editEmployeeLastName').value = employee.fullName.split(' ')[1];
    document.getElementById('editEmployeeMotherLastName').value = employee.fullName.split(' ')[2];
    document.getElementById('editEmployeeEmail').value = employee.email;
    document.getElementById('editEmployeeCellphone').value = employee.cellphone;
    document.getElementById('editEmployeeDni').value = employee.dni;
    document.getElementById('rolSelect').value = employee.accountType; // Asume que `accountType` es el valor que usas para el rol

    // Abrir el modal
    $('#editEmployeeModal').modal('show');
}

function validateFormData() {

    if (!validateFormData()) {
        return; // Si la validación falla, no proceder
    }

    const id = document.getElementById('editEmployeeId').value.trim();
    const idAccount = document.getElementById('editEmployeeAccountId').value.trim();
    const name = document.getElementById('editEmployeeName').value.trim();
    const lastName = document.getElementById('editEmployeeLastName').value.trim();
    const motherLastName = document.getElementById('editEmployeeMotherLastName').value.trim();
    const email = document.getElementById('editEmployeeEmail').value.trim();
    const cellphone = document.getElementById('editEmployeeCellphone').value.trim();
    const dni = document.getElementById('editEmployeeDni').value.trim();
    const role = document.getElementById('rolSelect').value;

    // Verificar si algún campo es nulo o vacío
    if (!id || !name || !lastName || !motherLastName || !email || !cellphone || !dni || !role) {
        console.log('Hay campos vacíos o nulos');
        if (!id)
            console.log('ID está vacío');
        if (!name)
            console.log('Nombre está vacío');
        if (!lastName)
            console.log('Apellido está vacío');
        if (!motherLastName)
            console.log('Apellido Materno está vacío');
        if (!email)
            console.log('Email está vacío');
        if (!cellphone)
            console.log('Celular está vacío');
        if (!dni)
            console.log('DNI está vacío');
        if (!role)
            console.log('Rol está vacío');

        // Mostrar un mensaje de error al usuario o manejar el caso
        alert('Por favor, complete todos los campos antes de enviar.');

        return false; // Indica que la validación falló
    }

    // Si todos los campos son válidos, retornar true
    return true;
}

async function saveEditedEmployee(token) {

    const id = document.getElementById('editEmployeeId').value;
    const idAccount = document.getElementById('editEmployeeAccountId').value.trim();
    const name = document.getElementById('editEmployeeName').value;
    const lastName = document.getElementById('editEmployeeLastName').value;
    const motherLastName = document.getElementById('editEmployeeMotherLastName').value;
    const email = document.getElementById('editEmployeeEmail').value;
    const cellphone = document.getElementById('editEmployeeCellphone').value;
    const dni = document.getElementById('editEmployeeDni').value;
    const role = document.getElementById('rolSelect').value; // Ajusta este valor según el campo de rol

// Verifica si alguno de los campos está vacío o es null
    // Verificar si algún campo es nulo o vacío
    if (!id || !name || !lastName || !motherLastName || !email || !cellphone || !dni) {
        console.log('Hay campos vacíos o nulos');
        if (!id)
            console.log('ID está vacío');
        if (!name)
            console.log('Nombre está vacío');
        if (!lastName)
            console.log('Apellido está vacío');
        if (!motherLastName)
            console.log('Apellido Materno está vacío');
        if (!email)
            console.log('Email está vacío');
        if (!cellphone)
            console.log('Celular está vacío');
        if (!dni)
            console.log('DNI está vacío');

        // Mostrar un mensaje de error al usuario o manejar el caso
        alert('Por favor, complete todos los campos antes de enviar.');

        return false; // Indica que la validación falló
    }

    const editedEmployee = {
        id: parseInt(id), // Asegúrate de que sea un número
        idAccount: parseInt(idAccount), // Asumiendo que tienes idAccount también
        name,
        lastname: lastName,
        motherLastname: motherLastName,
        email,
        cellphone,
        dni
    };

// Ahora puedes enviar editedEmployee al servidor
    console.log(JSON.stringify(editedEmployee));


    try {
        const response = await fetch('http://localhost:9091/boss/employee/edit', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': token // Asegúrate de tener el token disponible aquí
            },
            body: JSON.stringify(editedEmployee)
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const responseJson = await response.json();
        alert(responseJson.message);

        // Actualizar la tabla después de la edición
        await insetDataTableManagerEmployeeList(token);

        // Cerrar el modal
        $('#editEmployeeModal').modal('hide');
        insetDataTableManagerEmployeeList(token);

    } catch (error) {
        console.error('Hubo un problema con la operación de fetch:', error);
    }
}


function editAccount(employee) {
    console.log("Hola");
    document.getElementById('editEmployeeIdAccount').value = employee.id;
    document.getElementById('editEmployeeAccountIdAccount').value = employee.idAccount;

    $('#editEmployeeModalAccount').modal('show'); // Usa el selector jQuery correctamente
}

async function saveEditedAccountEmployee(token) {

    console.log("Hola aaaaaaaaaaaaaa");

    const id = document.getElementById('editEmployeeIdAccount').value;
    const idAccount = document.getElementById('editEmployeeAccountIdAccount').value.trim();
    const password = document.getElementById('editEmployeePassword').value.trim();

    const editedAccountEmployee = {
        id: parseInt(idAccount),
        password: password
    };

    try {
        const response = await fetch('http://localhost:9091/boss/employee/account/edit', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': token // Asegúrate de tener el token disponible aquí
            },
            body: JSON.stringify(editedAccountEmployee)
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const responseJson = await response.json();
        alert(responseJson.message);

        // Actualizar la tabla después de la edición
        await insetDataTableManagerEmployeeList(token);

        // Cerrar el modal
        $('#editEmployeeModalAccount').modal('hide'); // Usa el selector jQuery correctamente
        insetDataTableManagerEmployeeList(token);

    } catch (error) {
        console.error('Hubo un problema con la operación de fetch:', error);
    }
}


//
async function fetchProducts(token) {
    try {
        const response = await fetch('http://localhost:9091/boss/product/list',
                {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': token // Asegúrate de tener el token disponible aquí
                    }
                });
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const data = await response.json();
        populateProductTable(data.bossProducts);
    } catch (error) {
        console.error('Error fetching products:', error);
    }
}

function populateProductTable(products) {
    const tableBody = document.querySelector('#productsTable tbody');
    tableBody.innerHTML = ''; // Limpiar tabla antes de agregar nuevos datos

    products.forEach(product => {
        const row = document.createElement('tr');

        // Crear celdas y añadir valores
        row.innerHTML = `
            <td>${product.id}</td>
            <td>${product.id}</td> <!-- Aquí es necesario que tengas un campo 'id' en el objeto de producto, si no es así reemplaza con el campo correcto -->
            <td>${product.productCode}</td>
            <td>${product.productName}</td>
            <td>${product.productPrice.toFixed(2)}</td>
            <td><input type="number" value="1" min="1" id="quantity-${product.id}"></td>
            <td><span id="price-${product.id}">${(product.productPrice * 1).toFixed(2)}</span></td>
        `;

        // Añadir la fila a la tabla
        tableBody.appendChild(row);
    });

    // Añadir event listeners a los inputs de cantidad para actualizar el precio
    document.querySelectorAll('input[type="number"]').forEach(input => {
        input.addEventListener('input', (e) => {
            const productId = e.target.id.split('-')[1];
            const quantity = parseInt(e.target.value) || 1;
            const priceElement = document.querySelector(`#price-${productId}`);
            const productPrice = parseFloat(priceElement.textContent) / quantity;
            priceElement.textContent = (productPrice * quantity).toFixed(2);
        });
    });
}
async function addProduct(token) {
    console.log(token);
    // Obtener los valores del formulario
    const form = document.getElementById('createProductForm');
    const nombreProducto = form.elements['nombreProducto'].value;
    const codigoProducto = form.elements['codigoProducto'].value;
    const precioUnitario = parseFloat(form.elements['precioUnitario'].value);

    // Crear el objeto para enviar al backend
    const productData = {
        name: nombreProducto,
        code: codigoProducto,
        price: precioUnitario
    };

    try {
        const response = await fetch('http://localhost:9091/boss/product/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': token
            },
            body: JSON.stringify(productData)
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        const responseData = await response.json();
        alert(responseData.message);
        fetchProducts(token);
        // Aquí puedes agregar lógica para actualizar la lista de productos en la tabla
        // fetchProducts(); // Si tienes una función para actualizar la tabla de productos

    } catch (error) {
        console.error('Error al registrar el producto:', error);
    }
}