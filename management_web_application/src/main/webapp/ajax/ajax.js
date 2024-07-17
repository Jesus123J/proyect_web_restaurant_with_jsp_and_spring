




/* global response, text */

async function changeContainerRegisterEmployeeAdmin() {

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

async function changeContainerShowStoreAdmin() {

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
        document.getElementById('rightForm').innerHTML = text;

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}

/* */


async function changeContainerShowOrderAdmin() {

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

    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
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
               'Authorization' : 'eyJpZEFjY291bnQiOjQsImlkUGVyc29uIjo0LCJzdGF0dXMiOjEsInVzZXJuYW1lIjoieWFucGllcmNhdmVyb0BnbWFpbC5jb20iLCJuYW1lIjoiWUFOUElFUiIsImxhc3RuYW1lIjoiQ0FWRVJPIiwibW90aGVyTGFzdG5hbWUiOiJQT1JSTyIsImlkUm9sZSI6NCwicm9sZVR5cGUiOiJFTVBMRUFETyJ9'
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


async function componentContext(token) {
    try {
        const response = await fetch('http://localhost:9091/employee/register-entry', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization' : token
            }
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        console.log(response);
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
    
   
}
