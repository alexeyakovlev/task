package com.yakovlev.task.util;

import com.yakovlev.task.util.exception.ErrorResponce;
import com.yakovlev.task.util.exception.WalletNotFoundException;

/**
 * Created by alexi on 03.08.2025
 */
public class GlobalExceptionHandler {

    public ErrorResponce handleWalletNotFoundException(WalletNotFoundException ex) {
        return new ErrorResponce(ex.getClass().getSimpleName(), ex.getMessage());
    }
}
