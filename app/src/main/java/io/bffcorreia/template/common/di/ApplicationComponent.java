package io.bffcorreia.template.common.di;

import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = ApplicationModule.class) public interface ApplicationComponent {

  ActivityComponent plus(ActivityModule activityModule);
}
