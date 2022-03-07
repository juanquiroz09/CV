/*jshint esversion: 8*/
(() => {
    const experienciaCard1 = document.querySelector('.card1');
    const getExperience1 = async (event) => {
        const experience1Raw = await fetch('http://localhost:4567/experiencia');
        const {
            group
        } = await experience1Raw.json();
        group.forEach(({
            habilidades
        }) => {
            const template1 = `<div><a href="http://placehold.jp/200x50.png?text={text}"><img
            src="http://placehold.jp/18/90e0ef/000000/200x50.png?text=${habilidades}"></a>
            </div>`;
            experienciaCard1.innerHTML += template1;
        });
    };
    window.addEventListener('load', getExperience1);

    //Conocimientos
    const conocimiento1 = document.querySelector('.card-cono');
    const getConocimiento = async (event) => {
        const conocimientoRaw = await fetch('http://localhost:4567/conocimiento');
        const {
            group_two
        } = await conocimientoRaw.json();
        group_two.forEach(({
            conocimientos
        }) => {
            const template2 = `<div><a href="http://placehold.jp/146x130.png?text={text}"><img
            src="http://placehold.jp/35/90e0ef/000000/146x130.png?text=${conocimientos}"></a>
            </div>`;
            conocimiento1.innerHTML += template2;
        });
    };
    window.addEventListener('load', getConocimiento);

    //Referencias
    const referencia1 = document.querySelector('.card3');
    const getReferencia = async (event) => {
        const referenciaRaw = await fetch('http://localhost:4567/referencia');
        const {
            group_three
        } = await referenciaRaw.json();
        group_three.forEach(({
            referencias
        }) => {
            const template3 = `<div class="parrafo">${referencias}</div>`;
            referencia1.innerHTML += template3;
        });
    };
    window.addEventListener('load', getReferencia);
})();