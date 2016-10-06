package io.bffcorreia.template.common.di;

import dagger.Subcomponent;
import io.bffcorreia.template.presentation.login.LoginActivity;

@PerActivity @Subcomponent(modules = ActivityModule.class) public interface ActivityComponent {

  ViewComponent plus(ViewModule viewModule);

  void inject(LoginActivity loginActivity);
}
