package io.bffcorreia.template.presentation.login;

import android.os.Bundle;
import io.bffcorreia.template.R;
import io.bffcorreia.template.presentation.BaseActivity;
import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginContract.View {

  @Inject LoginPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter.start(this);
  }

  @Override protected int getLayoutRes() {
    return R.layout.activity_login;
  }

  @Override protected void initializeInjector() {
    getActivityComponent().inject(this);
  }
}
