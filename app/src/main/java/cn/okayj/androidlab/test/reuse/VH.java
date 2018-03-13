package cn.okayj.androidlab.test.reuse;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jack on 2017/11/26.
 */
public abstract class VH<D> extends RecyclerView.ViewHolder {
    public VH(View itemView) {
        super(itemView);
    }

    public abstract void bind(D d);
}
