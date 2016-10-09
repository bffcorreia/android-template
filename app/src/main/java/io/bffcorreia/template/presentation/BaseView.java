package io.bffcorreia.template.presentation;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import io.bffcorreia.template.common.di.ActivityComponent;
import io.bffcorreia.template.common.di.ViewComponent;
import io.bffcorreia.template.common.di.ViewModule;

public abstract class BaseView extends FrameLayout {

  private ViewComponent viewComponent;

  public BaseView(Context context) {
    this(context, null);
  }

  public BaseView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  protected abstract @LayoutRes int getLayoutRes();

  protected abstract void initializeInjector();

  protected ViewComponent getViewComponent() {
    return viewComponent;
  }

  private ActivityComponent getActivityComponent() {
    return ((BaseActivity) getContext()).getActivityComponent();
  }

  private ViewModule getViewModule() {
    return new ViewModule(this);
  }

  private void init() {
    initViewComponent();
    initializeInjector();
    setLayoutParams(
        new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    inflate(getContext(), getLayoutRes(), this);
    ButterKnife.bind(this);
  }

  private void initViewComponent() {
    viewComponent = getActivityComponent().plus(getViewModule());
  }
}
