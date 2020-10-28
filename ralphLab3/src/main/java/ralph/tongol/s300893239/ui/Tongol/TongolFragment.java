package ralph.tongol.s300893239.ui.Tongol;
/*Name: Ralph Lawrence G Tongol
        Student No: 300893239
        Section: 002 */
import android.Manifest;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;

import ralph.tongol.s300893239.R;

public class TongolFragment extends Fragment {

    int timeDuration;
    private static final String TAG = "Contacts";
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    AnimationDrawable mframeAnimation;
    ImageView img;

    private TongolViewModel tongolViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tongolViewModel =
                new ViewModelProvider(this).get(TongolViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tongol, container, false);
        img = (ImageView) root.findViewById(R.id.ralphImageViewNinja);
        Button start = root.findViewById(R.id.ralphStartBtn);
        final Button button = root.findViewById(R.id.ralphPermissionBtn);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          insertDummyContactsWrapper();
                                      }
                                  });
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Spinner speedSpinner = root.findViewById(R.id.ralphAnimationSpeed);
                        TextView speedSpinnerText = (TextView) speedSpinner.getSelectedView();
                        String text = speedSpinnerText.getText().toString();
                        switch (text) {
                            case "0.2 Sec":
                                timeDuration = 200;
                                break;
                            case "0.25 Sec":
                                timeDuration = 250;
                                break;
                            case "0.3 Sec":
                                timeDuration = 300;
                                break;
                            case "0.35 Sec":
                                timeDuration = 350;
                                break;
                            default:
                                break;
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
    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    Toast.makeText(getActivity(), "Thanks! Contact Creation Allowed.", Toast.LENGTH_SHORT)
                            .show();
                    addContacts();
                } else {
                    // Permission Denied
                    Toast.makeText(getActivity(), "Contact Creation Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private void insertDummyContactsWrapper() {

        int hasWriteContactsPermission = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            hasWriteContactsPermission = ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.WRITE_CONTACTS);

            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_CONTACTS},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }
        addContacts();
    }
    public void addContacts (){
        ArrayList<ContentProviderOperation> operations = new ArrayList<>(2);

        ContentProviderOperation.Builder op =
                ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                        .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                        .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null);
        operations.add(op.build());

        op = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                .withValue(ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
                        "__DUMMY CONTACT from runtime permissions sample");
        operations.add(op.build());

        // Apply the operations.
        ContentResolver resolver = getActivity().getContentResolver();
        try {
            resolver.applyBatch(ContactsContract.AUTHORITY, operations);
            Toast.makeText(getActivity(), "New contact inserted!", Toast.LENGTH_SHORT)
                    .show();
        } catch (RemoteException e) {
            Log.d(TAG, "Could not add a new contact: " + e.getMessage());
        } catch (OperationApplicationException e) {
            Log.d(TAG, "Could not add a new contact: " + e.getMessage());
        }
    }
}