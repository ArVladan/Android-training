// Generated code from Butter Knife. Do not modify!
package promo.kit.userregistration.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import promo.kit.userregistration.R;

public class UserAdapter$UserHolder_ViewBinding<T extends UserAdapter.UserHolder> implements Unbinder {
  protected T target;

  @UiThread
  public UserAdapter$UserHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.poster = Utils.findRequiredViewAsType(source, R.id.imageView, "field 'poster'", ImageView.class);
    target.name = Utils.findRequiredViewAsType(source, R.id.name, "field 'name'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.poster = null;
    target.name = null;

    this.target = null;
  }
}
