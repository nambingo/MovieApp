package com.framgia.movieapp.utils

import java.io.IOException
import okhttp3.Response

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

class BaseException private constructor(private val type: BaseException.Type,
    cause: Throwable) : RuntimeException(cause.message, cause) {
  private val errorResponse: BaseErrorResponse? = null
  private val response: Response? = null

  enum class Type {
    /**
     * An [IOException] occurred while communicating to the server.
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

  internal class BaseErrorResponse {
    private var errors: List<Error>? = null

    val errorCode: Int
      get() = errors!![0].code

    val errorMessage: String
      get() = errors!![0].message!!

    val isError: Boolean
      get() = errors != null

    private class Error {

      internal var code: Int = 0

      internal var message: String? = null
    }
  }

  companion object {

    fun toUnexpectedError(cause: Throwable): BaseException {
      return BaseException(Type.UNEXPECTED, cause)
    }
  }
}


