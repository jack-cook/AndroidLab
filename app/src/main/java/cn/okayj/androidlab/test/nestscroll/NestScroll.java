package cn.okayj.androidlab.test.nestscroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.okayj.androidlab.R;
import cn.okayj.androidlab.base.ui.BaseActivity;
import cn.okayj.androidlab.test.reuse.Adapter;

/**
 * Created by jack on 2017/11/26.
 */

public class NestScroll extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nestscroll);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new Adapter());
    }

}
