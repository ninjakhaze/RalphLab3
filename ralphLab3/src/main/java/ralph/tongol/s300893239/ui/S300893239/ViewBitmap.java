package ralph.tongol.s300893239.ui.S300893239;
/*Name: Ralph Lawrence G Tongol
        Student No: 300893239
        Section: 002 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.View;

import ralph.tongol.s300893239.R;

public class ViewBitmap extends View {

    // constructor
    public ViewBitmap(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        Bitmap firstnameBitmap = BitmapFactory.decodeResource(getResources(), R.string.firstnmae);
        Bitmap lastnameBitmap = BitmapFactory.decodeResource(getResources(), R.string.lastname);
        Matrix topLeft = new Matrix();
        topLeft.preRotate(45);
        Matrix topRight = new Matrix();
        topRight.preRotate(-45);

        Bitmap firstnameTopLeft = Bitmap.createBitmap(firstnameBitmap, 0, 0, firstnameBitmap.getWidth(), firstnameBitmap.getHeight(), topLeft, false);
        Bitmap lastnameTopRight = Bitmap.createBitmap(lastnameBitmap, 0, 0, lastnameBitmap.getWidth(), lastnameBitmap.getHeight(), topRight, false);

        // saving memory by means of disregarding bitmaps that not needed
        firstnameBitmap.recycle();
        lastnameBitmap.recycle();
        //bitmap has been draw in the canvas
        canvas.drawBitmap(firstnameTopLeft, 30, 30, null);
        canvas.drawBitmap(lastnameTopRight, 1025, 30, null);
    }
}