package com.itsoeh.jmendoza.evaluacionae.accesoADatos;

public interface Api {
    String URL = "https://atributosegresoitsoeh5.000webhostapp.com//evaluacionAE/Api.php";

    String GUARDAR=URL+"?apicall=guardarDocente";
    String BUSCARCONTRASENIA=URL+"?apicall=buscarContrasenia";
    String OBTENERIDDOCENTE=URL+"?apicall=obtenerIdDocente";
    String ACTUALIZAR_NOMBRE=URL+"?apicall=actualizarNombre";
    String ACTUALIZAR_CORREO=URL+"?apicall=actualizarCorreo";
    String ACTUALIZAR_PASSWORD=URL+"?apicall=actualizarPassword";
}
