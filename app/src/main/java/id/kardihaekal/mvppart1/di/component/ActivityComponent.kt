package id.kardihaekal.mvppart1.di.component

import dagger.Component
import id.kardihaekal.mvppart1.ui.main.MainActivity
import id.kardihaekal.mvppart1.di.module.ActivityModule

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}