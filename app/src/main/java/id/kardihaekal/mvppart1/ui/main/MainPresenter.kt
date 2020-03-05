package id.kardihaekal.mvppart1.ui.main

import android.util.Log
import android.widget.ProgressBar
import id.kardihaekal.mvppart1.api.ApiServiceInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter :MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View
    private val ApiSevices: ApiServiceInterface = ApiServiceInterface.create()

//    override fun getMovie() {
//        val subscribe = ApiSevices.getMovie().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.d("DOMAIN", it.toString())
//                // view.onProgress(false)
//                view.onDomainSuccess(it)
//            }, { error ->
//                var msg = error.localizedMessage
//                view.onDomainError(msg)
//            })
//        subscriptions.add(subscribe)
//    }

    override fun getComics(nomor : Int) {

        view.onLoadingBar()
        val subscribe = ApiSevices.getComic(nomor).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("DOMAIN", it.toString())
                // view.onProgress(false)
                view.onGetComicSucces(it)
            }, { error ->
                var msg = error.localizedMessage
                view.onDomainError(msg)
            })
        subscriptions.add(subscribe)
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }


}