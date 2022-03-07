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
// Añadir Referencia
const createReferenciaForm = document.getElementById('createReferencia');
const createReferenciaFormHandler = async (event) => {
    event.preventDefault();
    const referencias = document.querySelector("#createReferencia input[name='refe']").value;
    try {
        await postData('http://localhost:4567/referencia', {referencias});            
        alert('Agregada la referencia Correctamente.');
        window.location.href = "/frontend/admin.html";
    } catch (error) {            
        alert('Error en la petición.');
    }        
};
createReferenciaForm.addEventListener('submit', createReferenciaFormHandler);
})();