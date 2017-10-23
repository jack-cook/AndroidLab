package cn.okayj.androidlab.test.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by jack on 2017/10/21.
 */

public class MyWebview extends WebView {
    public MyWebview(Context context) {
        super(context);
    }

    public MyWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Toast.makeText(this.getContext(),"++++++web view attached to window",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Toast.makeText(this.getContext(),"------web view detached from window",Toast.LENGTH_SHORT).show();
    }
}
