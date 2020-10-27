package ralph.tongol.s300893239.ui.Tongol;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TongolViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TongolViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}