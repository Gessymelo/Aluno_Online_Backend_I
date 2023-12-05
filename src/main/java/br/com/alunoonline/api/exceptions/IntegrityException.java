package br.com.alunoonline.api.exceptions;


/*conler de erros*/
public class IntegrityException extends RuntimeException {
    public IntegrityException(Object id){
        super("Deletion violates foreign key constraint. Id " + id);
    }
}
