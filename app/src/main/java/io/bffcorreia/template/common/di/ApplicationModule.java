package io.bffcorreia.template.common.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.bffcorreia.template.common.AndroidApplication;
import javax.inject.Singleton;

@Module public class ApplicationModule {

  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton public Context provideApplicationContext() {
    return application;
  }
}
