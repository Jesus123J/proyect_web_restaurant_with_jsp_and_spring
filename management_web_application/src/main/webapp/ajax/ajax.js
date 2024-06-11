




/* global response */

var currentPath = window.location.pathname;

var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        console.log("Valor de window.location.pathname enviado al servlet");
    }
};
xhttp.open("POST", "MiServlet", true);
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhttp.send("path=" + encodeURIComponent(currentPath));






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

