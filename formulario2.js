function boton4() {
    window.alert('enviar4');
}

// definimos una variable la cual "apunta" a un elemento HTML identificado por su ID
var btnEnviar1 = document.getElementById('btnEnviar1');
btnEnviar1.style.color = "yellow";
// se agrega un listener (escucha) para cachar el evento click en el botón
// la acción que ocurrirá al dar click la ejecutará una función anónima function() { }
btnEnviar1.addEventListener('click', function () {
    window.alert('enviar1');
    cambiarColor("red");
    cambiarEstado(true);
});

var emailHelp = document.getElementById('emailHelp');
function cambiarColor(color) {
    emailHelp.style.color = color;
}

function cambiarEstado(estado) {
    var exampleCheck1 = document.getElementById("exampleCheck1").checked = estado;
}

var btnEnviar5 = document.getElementById('btnEnviar5');
btnEnviar5.addEventListener('click', callback);

function callback() {
    cambiarColor("green");
    cambiarEstado(false);
}