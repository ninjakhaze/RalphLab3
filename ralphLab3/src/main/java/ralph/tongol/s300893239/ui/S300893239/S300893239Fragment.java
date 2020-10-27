package ralph.tongol.s300893239.ui.S300893239;

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

public class S300893239Fragment extends Fragment {

    private S300893239ViewModel s300893239ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s300893239ViewModel =
                new ViewModelProvider(this).get(S300893239ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_s300893239, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        s300893239ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}