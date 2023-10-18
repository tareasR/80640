function DatosPersonales() {
    return (
        <>
            <fieldset>
                <legend>Datos Personales</legend>
                <label htmlFor="nombre">Nombre: </label>
                <input type="text" id="nombre"/>
                <label htmlFor="paterno">Apellido Paterno:</label>
                <input type="text" id="paterno"/>
                <label htmlFor="materno">Apellido Materno:</label>
                <input type="text" id="materno"/>
                <label htmlFor="password">Contraseña:</label>
                <input type="password" id="password"></input>
            </fieldset>
        </>
    )
}

export default DatosPersonales