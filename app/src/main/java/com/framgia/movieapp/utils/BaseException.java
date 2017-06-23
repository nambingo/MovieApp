package com.framgia.movieapp.utils;

import java.io.IOException;
import java.util.List;
import okhttp3.Response;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public class BaseException extends RuntimeException {
    private Type type;
    private BaseErrorResponse errorResponse;
    private Response response;

    private BaseException(Type type, Throwable cause) {
        super(cause.getMessage(), cause);
        this.type = type;
    }

    public static BaseException toUnexpectedError(Throwable cause) {
        return new BaseException(Type.UNEXPECTED, cause);
    }

    public enum Type {
        /**
         * An {@link IOException} occurred while communicating to the server.
         */
        NETWORK,
        /**
         * A non-2xx HTTP status code was received from the server.
         */
        HTTP,
        /**
         * A error server with code & message
         */
        SERVER,
        /**
         * An internal error occurred while attempting to execute a request. It is best practice to
         * re-throw this exception so your application crashes.
         */
        UNEXPECTED
    }

    static class BaseErrorResponse{
        List<Error> errors;

        public int getErrorCode() {
            return errors.get(0).code;
        }

        public String getErrorMessage() {
            return errors.get(0).message;
        }

        public boolean isError() {
            return errors != null;
        }

        private static final class Error {

            int code;

            String message;
        }
    }
}


