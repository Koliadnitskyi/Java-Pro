package Exceptions;

public class SqlSaveException extends RuntimeException {
    public SqlSaveException(String message) {
        super(message);
    }
}