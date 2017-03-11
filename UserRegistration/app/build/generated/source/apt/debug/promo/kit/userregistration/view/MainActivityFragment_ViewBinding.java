// Generated code from Butter Knife. Do not modify!
package promo.kit.userregistration.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import promo.kit.userregistration.R;

public class MainActivityFragment_ViewBinding<T extends MainActivityFragment> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivityFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.rv = Utils.findRequiredViewAsType(source, R.id.recycler, "field 'rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rv = null;

    this.target = null;
  }
}
