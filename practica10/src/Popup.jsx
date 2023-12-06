import { useState } from "react"
import Button from '@mui/material/Button'
import Dialog from '@mui/material/Dialog'
import DialogTitle from '@mui/material/DialogTitle'
import DialogContent from '@mui/material/DialogContent'
import DialogContentText from '@mui/material/DialogContentText'
import DialogActions from '@mui/material/DialogActions'

function Popup({id}) {
    const [open, setOpen] = useState(true)

    const eventoAbrir = () => {
        setOpen(true)
    }

    const eventoCerrar = () => {
        setOpen(false)
    }

    return (
        <>
            <div>
                <Button variant="outlined" onClick={eventoAbrir}>
                    Mostrar Popup
                </Button>
                <Dialog open={open} onClose={eventoCerrar}>
                    <DialogTitle>Respuesta del servidor</DialogTitle>
                    <DialogContent>
                    <DialogContentText>
                        El ID del usuario es {id}
                    </DialogContentText>
                    </DialogContent>
                    <DialogActions>
                    <Button onClick={eventoCerrar}>Cerrar</Button>
                    </DialogActions>
                </Dialog>
            </div>

        </>
    )
}

export default Popup