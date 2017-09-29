package com.sunm.model.compose;

/**
 * Created by Administrator on 2017/9/29.
 */

public class AddErrorException extends RuntimeException {

    public AddErrorException(String message) {
        super(message);
    }

    public AddErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddErrorException(Throwable cause) {
        super(cause);
    }
}
