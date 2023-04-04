package br.com.fiap.tourbeck.Exception;
public class RestNotFoundException extends RuntimeException{

    public RestNotFoundException(String message) {
        super(message);
    }
    
}
