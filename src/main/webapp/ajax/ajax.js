

/* global response */

async function changeContainerRegisterEmployeeAdmin() {

    const action = 'createEmployee';

    try {
        const response = await fetch('ControllerServlet', {
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
        const response = await fetch('ControllerServlet', {
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
        const response = await fetch('/management_web_application/ControllerServlet', {
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
        const response = await fetch('/management_web_application/ControllerServlet', {
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

