package cn.okayj.androidlab.test.reuse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by jack on 2017/11/26.
 */
public class Adapter extends RecyclerView.Adapter<VH> {
    private ArrayList<Object> items = new ArrayList<>();

    {
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
        items.add(new Object());
        items.add(new Object());
    }

    public Adapter() {
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(NormalVH.LAYOUT, parent, false);
        return new NormalVH(v);
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
        return NormalVH.LAYOUT;
    }

}
