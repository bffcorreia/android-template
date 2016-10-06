package io.bffcorreia.template.common;

import android.app.Application;
import io.bffcorreia.template.BuildConfig;
import io.bffcorreia.template.common.di.ApplicationComponent;
import io.bffcorreia.template.common.di.ApplicationModule;
import io.bffcorreia.template.common.di.DaggerApplicationComponent;
import timber.log.Timber;

public class AndroidApplication extends Application {

  public static final boolean DEBUG = BuildConfig.DEBUG;

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();

    initApplicationComponent();

    if (DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  private void initApplicationComponent() {
    this.applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }
}