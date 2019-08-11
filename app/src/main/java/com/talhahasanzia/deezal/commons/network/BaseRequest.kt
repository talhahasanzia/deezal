package com.talhahasanzia.deezal.commons.network


import com.talhahasanzia.deezal.commons.utils.Constants
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * This layer separates application layer from network layer and allows communication through an abstract layer
 * This abstract layer is ResponseCallback. App should not know what is happening in the network layer.
 * So interactor just make requests and get results based on request, without knowing underlying logic of network layer
 *
 * To define request specifications like end points or payloads extend BaseRequest and implement this interface to specify Response type T.
 * This layer will act as mediator between pure network logic and application layer.
 * Any changes in Retrofit or Network layer should not effect app layer directly.
 */
abstract class BaseRequest<T : BaseResponseDto, R : Any> : Request<T, R> {

    protected var retrofit: Retrofit
    protected var disposable: CompositeDisposable


    init {
        retrofit = initRetrofit()
        disposable = CompositeDisposable()
    }

    /**
     * Create HTTP Client using OkHttp
     */
    private fun createHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.connectTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
        return builder.build()
    }

    /**
     * Create retrofit client
     */
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Urls.BASE_URL)
            .client(createHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun dispose() {
        disposable.clear()
    }
}
