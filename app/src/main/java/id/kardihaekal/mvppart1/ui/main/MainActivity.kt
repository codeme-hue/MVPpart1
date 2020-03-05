package id.kardihaekal.mvppart1.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import id.kardihaekal.mvppart1.R
import id.kardihaekal.mvppart1.di.component.DaggerActivityComponent
import id.kardihaekal.mvppart1.di.module.ActivityModule
import id.kardihaekal.mvppart1.models.Comics
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() , MainContract.View{


    @Inject
    lateinit var presenter: MainContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
        presenter.attach(this)

        initViews()

    }

    private fun initViews() {
        buttonNumber.setOnClickListener{
            //cek kosong atau tidak
            if (txtNumber.text.toString().isEmpty()) {
                Toast.makeText(this, "Text tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                //pemanggilan API
                presenter.getComics(txtNumber.text.toString().toInt())
            }
        }
    }


    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun onGetComicSucces(comic: Comics) {
        judulComic.text = comic.title
        tahunComic.text = comic.year
        Picasso.get().load(comic.gambar).into(gambarComic, object: com.squareup.picasso.Callback {
            override fun onSuccess() {
                //set animations here
                ll_progress_bar.visibility = View.GONE

            }

            override fun onError(e: Exception?) {
                //do smth when there is picture loading error
            }
        })
    }

    override fun onDomainError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        ll_progress_bar.visibility = View.GONE
    }

    override fun onLoadingBar() {
        ll_progress_bar.visibility = View.VISIBLE
    }
}

