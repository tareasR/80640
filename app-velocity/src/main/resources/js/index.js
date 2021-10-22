var correo;
var id;

var btnEnviar = document.getElementById("btnEnviar");
btnEnviar.addEventListener("click", () => {
    axios.post("https://deployment-jrrc.herokuapp.com/enviar", {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    })
        .then(function (res) {
            alert("Usuario:" + res.data.status + " id:" + res.data.id);
            correo = document.getElementById("email").value;
            id = res.data.id;
        })
        .catch(function (error) {
            console.log(error)
        })
});

var btnLista = document.getElementById("btnLista");
btnLista.addEventListener("click", () => {
    let params = new URLSearchParams();
    params.append("email", correo);
    params.append("id", id);
    window.location.replace("http://127.0.0.1:5500/lista.html?" + params);
});

var btnTabla = document.getElementById("btnTabla");
btnTabla.addEventListener("click", () => {
    axios.get("http://localhost:4567/usuarios")
        .then(function (res) {
            let json = res.data;
            let listaTareas = document.getElementById("usuarios");
            for (var clave in json) {
                // Controlando que json realmente tenga esa propiedad
                if (json.hasOwnProperty(clave)) {
                    // Mostrando en pantalla la clave junto a su valor
                    // alert("La clave es " + clave + " y el valor es " + json[clave]);
                    let tarea = document.createElement("li");
                    tarea.textContent = clave + " " + json[clave].email;
                    listaTareas.appendChild(tarea);
                }
            }
        })
        .catch()
})

var btnRedireccion = document.getElementById("btnRedireccion");
btnRedireccion.addEventListener("click", () => {
    window.location.replace("http://localhost:4567/hola");
});