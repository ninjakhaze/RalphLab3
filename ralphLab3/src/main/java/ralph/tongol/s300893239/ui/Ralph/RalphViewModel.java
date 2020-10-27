package ralph.tongol.s300893239.ui.Ralph;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RalphViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RalphViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}