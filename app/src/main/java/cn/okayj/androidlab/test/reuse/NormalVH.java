package cn.okayj.androidlab.test.reuse;

import android.view.View;

import cn.okayj.androidlab.R;

/**
 * Created by jack on 2017/11/26.
 */
public class NormalVH extends VH {
    public static final int LAYOUT = R.layout.item_recyclerview_keep;

    public NormalVH(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Object o) {

    }
}
