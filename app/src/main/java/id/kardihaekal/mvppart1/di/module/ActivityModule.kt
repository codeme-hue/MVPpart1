package id.kardihaekal.mvppart1.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import id.kardihaekal.mvppart1.ui.main.MainContract
import id.kardihaekal.mvppart1.ui.main.MainPresenter


@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }


}