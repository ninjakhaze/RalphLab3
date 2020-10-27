package ralph.tongol.s300893239.ui.Tongol;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ralph.tongol.s300893239.R;

public class TongolFragment extends Fragment {

    private TongolViewModel tongolViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tongolViewModel =
                new ViewModelProvider(this).get(TongolViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tongol, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        tongolViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}