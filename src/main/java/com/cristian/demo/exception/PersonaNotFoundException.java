package com.cristian.demo.exception;

public class PersonaNotFoundException extends RuntimeException{
    public PersonaNotFoundException(Long id){
        super("No se ha podido encontrar la persona con ID: "+ id);
    }
}