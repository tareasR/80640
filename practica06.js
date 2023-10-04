const formulario = document.getElementById("formulario")
formulario.addEventListener("submit", evento => {
    evento.preventDefault()
    let u = document.getElementById("user").value
    let p = document.getElementById("password").value
    alert(u + p)
})