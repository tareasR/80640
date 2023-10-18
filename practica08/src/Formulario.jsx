// import MiFieldSet from "./MiFieldSet"
import DatosPersonales from "./DatosPersonales"
import DatosEscolares from "./DatosEscolares"

function Formulario() {
    return (
        <>
            <form action="">
                {/* <MiFieldSet titulo="Datos Personales" txt1="Nombre" txt2="Password" />
                <MiFieldSet titulo="Datos Escolares" txt1="Carrera" txt2="Semestre" /> */}
                <DatosPersonales></DatosPersonales>
                <DatosEscolares></DatosEscolares>
                <input type="submit" value="Enviar datos"/>
            </form>
        </>
    )
}

export default Formulario