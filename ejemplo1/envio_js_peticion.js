// defino dos constantes que recuperan los valores del formulario
const email = document.getElementById("exampleInputEmail1").value;
const pass = document.getElementById("exampleInputPassword1").value;

var btnGet = document.getElementById("btnGet");
btnGet.addEventListener("click", function () {
    var params = new URLSearchParams();
    params.append("nombre", email);
    params.append("pass", pass);
    console.log(params.get("nombre"))
    axios.get("http://localhost:4567/hola?" + params)
        .then(function (rs) {
            console.log(rs.data);
            alert(rs.data)
        })
        .catch(function (error) {
            console.log(error);
        });
});