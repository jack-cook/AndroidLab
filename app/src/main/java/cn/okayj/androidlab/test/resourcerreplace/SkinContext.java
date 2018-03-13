package cn.okayj.androidlab.test.resourcerreplace;

import android.content.Context;
import android.content.ContextWrapper;

/**
 * Created by jack on 2017/11/14.
 */

public class SkinContext extends ContextWrapper{
    public SkinContext(Context base) {
        super(base);
    }

    public static SkinContext wrap(Context context){
        if(!(context instanceof SkinContext)){
            return new SkinContext(context);
        }else {
            return (SkinContext) context;
        }
    }
}
