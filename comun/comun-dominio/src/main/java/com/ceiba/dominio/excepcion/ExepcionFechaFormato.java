package com.ceiba.dominio.excepcion;

public class ExepcionFechaFormato extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExepcionFechaFormato(String message) {
        super(message);
    }
}
