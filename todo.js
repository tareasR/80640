var btnAgregar = document.getElementById("agregar"); // input button
btnAgregar.addEventListener("click", agregar);

var txtTarea = document.getElementById("tarea");     // input text
var listaTareas = document.getElementById("tareas"); // UL

function agregar() {
    let tarea = document.createElement("li");
    tarea.textContent = txtTarea.value;
    listaTareas.appendChild(tarea);
}