package com.ceiba.dominio.excepcion;

public class ExepcionNoSePuedeEliminar extends RuntimeException {

    private static final long serialVersionUID = 2L;

    public ExepcionNoSePuedeEliminar(String message) {
        super(message);
    }
}
