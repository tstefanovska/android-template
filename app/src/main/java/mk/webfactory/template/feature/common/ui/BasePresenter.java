package mk.webfactory.template.feature.common.ui;

import static mk.webfactory.template.util.Preconditions.checkArgument;
import static mk.webfactory.template.util.Preconditions.checkNotNull;
import static mk.webfactory.template.util.Preconditions.checkState;

/**
 * @deprecated - We'll use view model
 */
@Deprecated
public abstract class BasePresenter<View> {

  private View view;

  public final void takeView(View view) {
    checkState(this.view == null, "takeView before previous view is dropped.");
    this.view = checkNotNull(view, "view == null");
    onTakeView(view);
  }

  public final void dropView(View view) {
    checkArgument(view != null, "dropView with null argument.");
    if (this.view != view) { return; }
    onDropView();
    this.view = null;
  }

  protected abstract void onTakeView(View v);

  protected abstract void onDropView();

  public final boolean hasView() {
    return view != null;
  }

  protected final View getView() {
    return view;
  }
}
