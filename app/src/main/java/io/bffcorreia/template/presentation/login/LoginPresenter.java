package io.bffcorreia.template.presentation.login;

import io.bffcorreia.template.common.di.PerActivity;
import javax.inject.Inject;

@PerActivity public class LoginPresenter implements LoginContract.Presenter {

  private LoginContract.View view;

  @Inject public LoginPresenter() {

  }

  @Override public void start(LoginContract.View view) {
    this.view = view;
  }
}
