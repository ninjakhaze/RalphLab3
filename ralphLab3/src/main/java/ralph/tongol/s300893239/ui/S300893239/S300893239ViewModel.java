package ralph.tongol.s300893239.ui.S300893239;
/*Name: Ralph Lawrence G Tongol
        Student No: 300893239
        Section: 002 */
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class S300893239ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S300893239ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}