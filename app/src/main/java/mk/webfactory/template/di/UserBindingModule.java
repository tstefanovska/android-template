package mk.webfactory.template.di;

import android.app.Activity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mk.webfactory.template.di.scope.ActivityScope;
import mk.webfactory.template.di.scope.UserScope;
import mk.webfactory.template.feature.home.ui.HomeActivity;
import mk.webfactory.template.feature.home.ui.HomePresenterModule;

/**
 * Binding of {@linkplain Activity Activities} within the {@linkplain UserScope}
 * i.e. screens requiring logged in user to display user specific data.
 *
 * @see GlobalBindingModule AppBindingModule for global scope
 */
@Module public abstract class UserBindingModule {

  @ActivityScope
  @ContributesAndroidInjector(modules = HomePresenterModule.class)
  abstract HomeActivity homeActivity();
}