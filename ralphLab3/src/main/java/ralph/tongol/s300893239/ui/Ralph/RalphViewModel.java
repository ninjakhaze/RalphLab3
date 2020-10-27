package ralph.tongol.s300893239.ui.Ralph;
/*Name: Ralph Lawrence G Tongol
        Student No: 300893239
        Section: 002 */
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