navigator.mediaDevices.getUserMedia({
    audio: false, video: true
}).then(function(x) {
    /* usar el flujo de datos */
    console.log(x)
    var camara = document.getElementById("camara")
    camara.srcObject = x
    camara.onloadedmetadata = function(e) {
        // Do something with the video here.
        camara.play()
      };
    console.log(camara)
  }).catch(function(err) {
    /* manejar el error */
    console.log(err)
  });