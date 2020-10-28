package ralph.tongol.s300893239.ui.S300893239;
/*Name: Ralph Lawrence G Tongol
        Student No: 300893239
        Section: 002 */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ralph.tongol.s300893239.R;

public class S300893239Fragment extends Fragment {

    private S300893239ViewModel s300893239ViewModel;
    private ImageView imgMoon, imgEarth;
    private Animation animateM, animateE;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s300893239ViewModel =
                new ViewModelProvider(this).get(S300893239ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_s300893239, container, false);
        Button start = root.findViewById(R.id.ralphStartAnimation);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgMoon = root.findViewById(R.id.moon);
                animateM = AnimationUtils.loadAnimation(getContext(), R.anim.moon_movement);
                imgMoon.startAnimation(animateM);

                imgEarth = root.findViewById(R.id.earth);
                animateE = AnimationUtils.loadAnimation(getContext(), R.anim.spin);
                imgEarth.startAnimation(animateE);
            }
        });
        Button stop = root.findViewById(R.id.ralphStopAnimation);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgMoon.clearAnimation();
            }
        });
        return root;
    }
}