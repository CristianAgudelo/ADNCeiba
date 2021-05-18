package com.ceiba.dominio.excepcion;

public class ExepcionNoExisteAsesor extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExepcionNoExisteAsesor(String mensaje) {
        super(mensaje);
    }
}
