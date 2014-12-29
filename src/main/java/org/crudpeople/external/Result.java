package org.crudpeople.external;

public class Result {
    private String message;
    private ResultStatus status;

    public Result() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }
    
    
}
