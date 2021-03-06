package mk.webfactory.template.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import mk.webfactory.template.App
import mk.webfactory.template.data.DataModule
import mk.webfactory.template.model.user.UserSession
import mk.webfactory.template.network.NetworkModule
import mk.webfactory.template.network.api.ApiServiceModule
import mk.webfactory.template.user.UserManager
import mk.webfactory.template.user.UserModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DataModule::class,
        ApiServiceModule::class,
        UserModule::class,
        GlobalBindingModule::class,
        AndroidSupportInjectionModule::class
        //TODO: Insert modules here that don't require logged in user
    ]
)
interface AppComponent : AndroidInjector<App> {

    fun userScopeComponentBuilder(): UserScopeComponent.Builder

    val userManager: UserManager<UserSession>

    override fun inject(app: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}