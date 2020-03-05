package id.kardihaekal.mvppart1.ui.main

import android.widget.ProgressBar
import id.kardihaekal.mvppart1.models.Comics
import id.kardihaekal.mvppart1.models.Movie
import id.kardihaekal.mvppart1.ui.base.BaseContract


class MainContract {

    interface View: BaseContract.View{

        //fun onDomainSuccess(movie: List<Movie>)
        fun onGetComicSucces(comic : Comics)
        fun onDomainError(msg: String)
        fun onLoadingBar()

    }

    interface Presenter:BaseContract.Presenter<View>{
        //fun getMovie()
        fun getComics(nomor : Int)
    }
}