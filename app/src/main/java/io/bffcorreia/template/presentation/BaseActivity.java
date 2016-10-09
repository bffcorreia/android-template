package io.bffcorreia.template.presentation;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.bffcorreia.template.R;
import io.bffcorreia.template.common.AndroidApplication;
import io.bffcorreia.template.common.Preconditions;
import io.bffcorreia.template.common.di.ActivityComponent;
import io.bffcorreia.template.common.di.ActivityModule;
import io.bffcorreia.template.common.di.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {

  @BindView(R.id.toolbar) @Nullable protected Toolbar toolbar;

  private ActivityComponent activityComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initActivityComponent();
    initializeInjector();
    setContentView(getLayoutRes());
    ButterKnife.bind(this);
    setupToolbar();
  }

  @LayoutRes protected abstract int getLayoutRes();

  protected abstract void initializeInjector();

  protected ActivityComponent getActivityComponent() {
    return activityComponent;
  }

  protected void enableToolbarBack() {
    ActionBar actionBar = getSupportActionBar();
    Preconditions.checkNotNull(actionBar, "Toolbar not defined");
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setDisplayShowHomeEnabled(true);
    toolbar.setNavigationOnClickListener(v -> onBackPressed());
  }

  private void initActivityComponent() {
    activityComponent = getApplicationComponent().plus(getActivityModule());
  }

  private ApplicationComponent getApplicationComponent() {
    return ((AndroidApplication) getApplication()).getApplicationComponent();
  }

  private ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

  private void setupToolbar() {
    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }
  }
}
