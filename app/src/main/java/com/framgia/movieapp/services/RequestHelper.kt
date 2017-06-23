package com.framgia.movieapp.services

import com.framgia.movieapp.utils.Constant
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

object RequestHelper {
  private val CONNECTION_TIMEOUT = 30

  val requestHeader: ApiServices
    get() = getRequest(Constant.URL_BASE)

  fun getRequest(url: String): ApiServices {
    val logging = httpLoggingInterceptor

    val httpClient = OkHttpClient.Builder()
    httpClient.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
    httpClient.readTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
    httpClient.addInterceptor(logging)

    val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(httpClient.build())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
    return retrofit.create(ApiServices::class.java)
  }

  private val httpLoggingInterceptor: HttpLoggingInterceptor
    get() {
      val interceptor = HttpLoggingInterceptor()
      interceptor.level = if (Constant.DEBUG)
        HttpLoggingInterceptor.Level.BODY
      else
        HttpLoggingInterceptor.Level.NONE
      return interceptor
    }
}
