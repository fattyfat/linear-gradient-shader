package fatty.a42textviewandshader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Fatty on 2017-02-09.
 */

public class testView extends TextView {

    private int mViewWidth ,mTranslate;
    private Paint mpaint;
    private Matrix mGradientMatrix;
    private LinearGradient mLinearGradient;

    public testView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w,h,oldw,oldh);

        if(mViewWidth == 0){
            mViewWidth = getMeasuredWidth();
            if(mViewWidth > 0) {
                mpaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[]{Color.WHITE, 0xff5E2430, Color.WHITE}, null, Shader.TileMode.CLAMP);
                mpaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        if(mGradientMatrix != null){
            mTranslate += mViewWidth/5;
            if(mTranslate > 2*mViewWidth)
                mTranslate = -mViewWidth;

            mGradientMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }


}
