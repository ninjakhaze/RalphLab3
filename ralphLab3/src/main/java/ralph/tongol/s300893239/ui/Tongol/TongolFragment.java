package ralph.tongol.s300893239.ui.Tongol;
/*Name: Ralph Lawrence G Tongol
        Student No: 300893239
        Section: 002 */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import ralph.tongol.s300893239.R;

public class TongolFragment extends Fragment {

    private TongolViewModel tongolViewModel;
    int timeDuration;
    AnimationDrawable mframeAnimation;
    ImageView img;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tongolViewModel =
                new ViewModelProvider(this).get(TongolViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tongol, container, false);
        img = (ImageView) root.findViewById(R.id.ralphImageViewNinja);
        Button start = root.findViewById(R.id.ralphStartBtn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner speedSpinner = root.findViewById(R.id.ralphAnimationSpeed);
                TextView speedSpinnerText = (TextView) speedSpinner.getSelectedView();
                String text = speedSpinnerText.getText().toString();
                switch (text) {
                    case "0.2 Sec" : timeDuration = 200;
                        break;
                    case "0.25 Sec" : timeDuration = 250;
                        break;
                    case "0.3 Sec" : timeDuration = 300;
                        break;
                    case "0.35 Sec" : timeDuration = 350;
                        break;
                    default:break;
                }
                startAnimation();
            }
        });
        // implement stop button
        Button stop = root.findViewById(R.id.ralphStopBtn);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });
        return root;
    }
    private void startAnimation()
    {
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.ninja1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.ninja2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.ninja3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.ninja4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.ninja5);

        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, timeDuration);
        mframeAnimation.addFrame(frame2, timeDuration);
        mframeAnimation.addFrame(frame3, timeDuration);
        mframeAnimation.addFrame(frame4, timeDuration);
        mframeAnimation.addFrame(frame5, timeDuration);

        img.setBackground(mframeAnimation);
        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);
    }
}