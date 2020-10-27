package ralph.tongol.s300893239.ui.Tongol;
/*Name: Ralph Lawrence G Tongol
        Student No: 300893239
        Section: 002 */
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