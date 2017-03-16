package promo.kit.userregistration.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.sephiroth.android.library.picasso.Picasso;
import promo.kit.userregistration.R;
import promo.kit.userregistration.interfaces.MVPUser;
import promo.kit.userregistration.model.Result;
import promo.kit.userregistration.model.User;
import promo.kit.userregistration.presenter.UserPresenters;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddNewUserFragment extends Fragment implements MVPUser.ViewUser {

    private List<Result> results;
    private User user;
    private Result result;
    private MVPUser.PresenterUser presenter;
    private Context context;

    @BindView(R.id.portrait)
    ImageView poster;
    @BindView(R.id.name_id)
    TextView name;
    @BindView(R.id.password_id)
    TextView pass;
    @BindView(R.id.mail_id)
    TextView mail;
    @BindView(R.id.login_id)
    TextView login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_new_user, container, false);

        presenter = new UserPresenters();

        setRetainInstance(true);

        initUI(root);
        return root;
    }

    private void initUI(View root) {
        results = new ArrayList<Result>();
        ButterKnife.bind(this, root);

    }

    @OnClick(R.id.fab_add)
    public void performSend(View view) {
        Intent i = new Intent(getActivity(), MainActivity.class);
        i.putExtra("id", result.getName().getFirst());
        i.putExtra("icon", result.getPicture().getThumbnail());
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setUser(this);
        presenter.getList();
    }

    @Override
    public void onResult(User user) {
        this.results.clear();
        this.results.addAll(user.getResults());
        result = results.get(0);
        name.setText(result.getName().getFirst() + " " + result.getName().getLast());
        mail.setText(result.getEmail());
        login.setText(result.getLogin().getUsername());
        pass.setText(result.getLogin().getPassword());
        String image = result.getPicture().getLarge();
        if (!TextUtils.isEmpty(image))
            Picasso.with(getContext())
                    .load(image)
                    .placeholder(R.drawable.image_placeholder)
                    .into(poster);

    }

    @Override
    public void onError(String e) {
        Toast.makeText(getContext(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
    }
}
