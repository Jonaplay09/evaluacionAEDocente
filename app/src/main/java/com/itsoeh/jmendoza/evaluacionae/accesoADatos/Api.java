package com.itsoeh.jmendoza.evaluacionae.accesoADatos;

public interface Api {
    String URL = "https://atributosegresoitsoeh5.000webhostapp.com//evaluacionAE/Api.php";
    //String URL = "http://192.168.137.160/evaluacionAE/Api.php";

    String GUARDAR=URL+"?apicall=guardarDocente";
    String GUARDAR_ASIGNATURA=URL+"?apicall=guardarAsignatura";
    String GUARDAR_ATRIBUTOE=URL+"?apicall=guardarAtributoE";
    String ELIMINAR_ASIGNATURA=URL+"?apicall=eliminarAsignatura";
    String GUARDAR_CRITERIOSEVAL=URL+"?apicall=guardarCriteriosEval";
    String GUARDAR_CALIFICACION=URL+"?apicall=guardarCalificacion";
    String OBTENER_NOMBRE_POR_IDESTUDIANTE=URL+"?apicall=obtenerNombrePorIdEstudiante";
    String OBTENER_ID_ATRIBUTOE=URL+"?apicall=obtenerIdAtributoE";
    String OBTENER_ID_CRITERIO_POR_INDICADOR=URL+"?apicall=obtenerIdCriterioPorIndicador";
    String OBTENER_CRITERIOS_POR_ATRIBUTO=URL+"?apicall=obtenerCriteriosPorAtributo";
    String LISTAR_ASIGNATURA_POR_IDDOCENTE=URL+"?apicall=listarAsignaturaPorIdDocente";
    String BUSCARCONTRASENIA=URL+"?apicall=buscarContrasenia";
    String OBTENERIDDOCENTE=URL+"?apicall=obtenerIdDocente";
    String OBTENER_ID_ASIGNATURA=URL+"?apicall=obtenerIdAsignatura";
    String ACTUALIZAR_NOMBRE=URL+"?apicall=actualizarNombre";
    String ACTUALIZAR_CORREO=URL+"?apicall=actualizarCorreo";
    String ACTUALIZAR_PASSWORD=URL+"?apicall=actualizarPassword";
    String VERIFICAR_CORREO=URL+"?apicall=verificarCorreo";
    String LISTAR_ASIGNATURA=URL+"?apicall=listarAsignatura";
    String LISTAR_ESTUDIANTE=URL+"?apicall=listarEstudiante";
    String LISTAR_ATRIBUTOS_EGRESO_POR_IDASIGNATURA=URL+"?apicall=listarAtributosEgresoPorIdAsignatura";
    String ACTUALIZAR_PASSWORD_SIN_VERI=URL+"?apicall=actualizarPasswordSinVerificar";
}
