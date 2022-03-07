/*jshint esversion: 8 */
(() => {
    async function postData(url = '', data = {}) {
        // Default options are marked with *
        const response = await fetch(url, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            mode: 'cors', // no-cors, *cors, same-origin
            cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
            credentials: 'same-origin', // include, *same-origin, omit
            headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            redirect: 'follow', // manual, *follow, error
            referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
            body: JSON.stringify(data) // body data type must match "Content-Type" header
        });
        return response.json(); // parses JSON response into native JavaScript objects
    }
// Añadir Conocimiento
const createConocimientoForm = document.getElementById('createConocimiento');
const createConocimientoFormHandler = async (event) => {
    event.preventDefault();
    const conocimientos = document.querySelector("#createConocimiento input[name='cono']").value;
    try {
        await postData('http://localhost:4567/conocimiento', {conocimientos});            
        alert('Agregado el conocimiento Correctamente.');
        window.location.href = "/frontend/admin.html";
    } catch (error) {            
        alert('Error en la petición.');
    }        
};
createConocimientoForm.addEventListener('submit', createConocimientoFormHandler);
})();