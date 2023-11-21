package com.itsoeh.jmendoza.evaluacionae.accesoADatos;

public interface Api {
    //String URL ="http://192.168.137.126/ws/Api.php";
    //String URL ="http://178.6.11.199/WS/Api.php";
    String URL = "https://atributosegresoitsoeh5.000webhostapp.com//evaluacionAE/Api.php";

    //String URL ="http://178.6.10.194/ws/Api.php";
    //String URL ="http://192.168.1.102/ws/Api.php";
    String LISTAR=URL+"?apicall=listarPersona";
    String BUSCAR=URL+"?apicall=buscarPersona";
    String GUARDAR=URL+"?apicall=guardarDocente";
    String BUSCARCONTRASENIA=URL+"?apicall=buscarContrasenia";
    String OBTENERIDDOCENTE=URL+"?apicall=obtenerIdDocente";
    String ELIMINAR=URL+"?apicall=eliminarPersona";
    String EDITAR=URL+"?apicall=editarPersona";
    String SUBEFOTO=URL+"?apicall=subirfoto";
    String BAJAFOTO=URL+"?apicall=bajarfoto";
}
