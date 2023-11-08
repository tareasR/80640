import { Button, TextField, Box } from "@mui/material"
import { useState } from "react"
import axios from "axios"

function Formulario (props) {
    const [Cargando, setCargando] = useState(false)
    const [datosFormulario, setDatosFormulario] = useState(
        {nombre: '',
        password: ''}
    )

    const hacerPeticion = async () => {
        try {
            const response = await axios.get('http://localhost:4567')
        } catch (error) {
            throw error
        }
    }

    const procesarFormulario = (evento) => {
        evento.preventDefault()
        console.log("datos recuperados del formulario: ", datosFormulario)
        setCargando(true)
        try {
            const response = hacerPeticion()
            setCargando(false)
        } catch (error) {
            console.log('error', error)
            setCargando(false)
        }
    }

    return (
        <>
            <form onSubmit={ procesarFormulario }>
                <h1>Inicio de Sesión</h1>
                <Box m={5}>
                    <TextField label="Nombre:" variant="outlined" fullWidth></TextField>
                </Box>
                <Box m={5}>
                    <TextField label="Contraseña:" variant="outlined" fullWidth></TextField>
                </Box>
                <Box m={5}>
                    <Button variant="contained" type="submit" color="primary" fullWidth disabled={Cargando}>Inicar Sesión</Button>
                </Box>
            </form>
        </>
    )
}

export default Formulario