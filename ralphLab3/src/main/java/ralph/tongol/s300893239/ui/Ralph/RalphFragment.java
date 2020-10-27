package ralph.tongol.s300893239.ui.Ralph;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ralph.tongol.s300893239.R;

public class RalphFragment extends Fragment {

    private RalphViewModel RalphViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RalphViewModel =
                new ViewModelProvider(this).get(RalphViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ralph, container, false);
        final CanvasView myCanvas = (CanvasView) root.findViewById(R.id.ralphFragment1Canvas);

        final RadioButton redBtn = root.findViewById(R.id.ralphRadioBtnRed);
        final RadioButton blackBtn = root.findViewById(R.id.ralphRadioBtnBlack);
        final RadioButton blueBtn = root.findViewById(R.id.ralphRadioBtnBlue);
        final RadioButton smallBtn = root.findViewById(R.id.ralphRadioBtnSmall);
        final RadioButton medBtn = root.findViewById(R.id.ralphRadioBtnMedium);
        final RadioButton largeBtn = root.findViewById(R.id.ralphRadioBtnLarge);
        blackBtn.setChecked(true);
        smallBtn.setChecked(true);
        final Button penBtn = root.findViewById(R.id.ralphPenBtn);

        penBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(redBtn.isChecked()){
                    myCanvas.setColour(2);

                }else if(blueBtn.isChecked()){
                    myCanvas.setColour(3);
                }else{
                    myCanvas.setColour(1);
                }

                if(medBtn.isChecked()){
                    myCanvas.setSize(2);
                }else if(largeBtn.isChecked()){
                    myCanvas.setSize(3);
                }else{
                    myCanvas.setSize(1);
                }
            }
        });

        final Button clrBtn = root.findViewById(R.id.ralphClrBtn);
        clrBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myCanvas.clearPath();

            }
        });
        return root;
    }
}
