package com.aluradesafios.forohub.Infra;

public class ValidacionExcepcional extends RuntimeException {

    public ValidacionExcepcional ( String mensaje){
        super(mensaje);
    }
}
