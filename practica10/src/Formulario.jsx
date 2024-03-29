import { Button, TextField, Box } from "@mui/material"
import { useState } from "react"
import axios from "axios"
import Popup from "./Popup.jsx"

function Formulario (props) {
    const [Cargando, setCargando] = useState(false)
    const [datosFormulario, setDatosFormulario] = useState(
        {nombre: '',
        password: ''}
    )

    const hacerPeticion = async () => {
        try {
            const response = await axios.post('http://localhost:4567/usuarios',datosFormulario )
            // const response = await axios.get('http://localhost:4567/ruta2',{params: datosFormulario} )
            console.log(response.data)
            setId(response.data.id)
            abrirPopup()
            return response.data
        } catch (error) {
            throw error
        }
    }
    // Hook para pasar el Id recibido
    const [id, setId] = useState('')
    const [mostrarPopup, setMostrarPopup] = useState(false)
    const abrirPopup = () => {
        setMostrarPopup(true)
    }

    const procesarFormulario = async (evento) => {
        evento.preventDefault()
        console.log("datos recuperados del formulario: ", datosFormulario)
        setCargando(true)
        try {
            const response = await hacerPeticion()
            console.log("salida",response.alumno)
            setCargando(false)
            // validar los datos formulario contra lo del backend
            if (datosFormulario.nombre === response.alumno) {
                console.log('ok el usuario existe')
            } else {
                console.log('error el usuario no existe')
            }
        } catch (error) {
            console.log('error', error)
            setCargando(false)
        }
    }

    const cambiosFomulario = (evento) => {
         //console.log(evento.target)
        const {name, value} = evento.target
        setDatosFormulario( { ...datosFormulario, [name]:value} )
    }

    return (
        <>
            <form onSubmit={ procesarFormulario }>
                <h1>Inicio de Sesión</h1>
                <Box m={5}>
                    <TextField label="Nombre:" variant="outlined" fullWidth onChange={ cambiosFomulario } name="nombre" value={datosFormulario.nombre} ></TextField>
                </Box>
                <Box m={5}>
                    <TextField label="Contraseña:" variant="outlined" fullWidth onChange={ cambiosFomulario } name="password" value={datosFormulario.password} ></TextField>
                </Box>
                <Box m={5}>
                    <Button variant="contained" type="submit" color="primary" fullWidth disabled={Cargando}>Inicar Sesión</Button>
                </Box>
                <Box m={5}>
                    {mostrarPopup && <Popup id={id} onClose={() => setMostrarPopup(false)}/>} 
                </Box>

            </form>
        </>
    )
}

export default Formulario