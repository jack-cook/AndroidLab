package cn.okayj.androidlab.test.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.okayj.androidlab.R;
import cn.okayj.androidlab.base.ui.BaseActivity;

/**
 * Created by jack on 2017/10/21.
 * 实验证明，{@link android.support.v7.widget.RecyclerView.ViewHolder#setIsRecyclable(boolean) 并不能让 ViewHolder 保持在RecyclerView中}
 * 猜测此方法应该仅仅用于动画
 * ViewHolder 无法被回收，被抛弃，新的ViewHolder被创建。
 * 考虑尝试 {@link android.support.v7.widget.RecyclerView.LayoutManager#ignoreView(View)}
 */

public class RecyclerViewKeepViewTest extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ArrayList<Object> items = new ArrayList<>();
    private Adapter adapter = new Adapter();

    {
        items.add(new Object());
        items.add("<p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ ><p>html</ >");
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
        items.add(new Object());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recyclerview_keep_child);
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }

    private class Adapter extends RecyclerView.Adapter<VH>{
        public Adapter() {
            setHasStableIds(true);
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
            if(viewType == WebViewVH.LAYOUT){
                return new WebViewVH(v);
            }else {
                return new NormalVH(v);
            }
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.bind(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public int getItemViewType(int position) {
            Object o = items.get(position);
            if(o instanceof String){
                return WebViewVH.LAYOUT;
            }else {
                return NormalVH.LAYOUT;
            }
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

    }

    private abstract static class VH<D> extends RecyclerView.ViewHolder {
        public VH(View itemView) {
            super(itemView);
        }

        public abstract void bind(D d);
    }

    static class NormalVH extends VH {
        private static final int LAYOUT = R.layout.item_recyclerview_keep;

        public NormalVH(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(java.lang.Object o) {

        }
    }

    static class WebViewVH extends VH<String> {
        private static final int LAYOUT = R.layout.item_recyclerview_keeeeeeep_webview;

        @BindView(R.id.webView)
        WebView webView;

        public WebViewVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setIsRecyclable(false);
            Toast.makeText(itemView.getContext(),"web view created",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void bind(String o) {
            webView.loadData(o,"text/html","utf-8");
            Toast.makeText(itemView.getContext(),"web view binded",Toast.LENGTH_SHORT).show();
        }


    }
}
