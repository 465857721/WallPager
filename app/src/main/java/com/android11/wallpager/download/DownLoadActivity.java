package com.android11.wallpager.download;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android11.wallpager.R;
import com.android11.wallpager.download.adapter.DownListAdapter;
import com.android11.wallpager.main.BaseActivity;
import com.android11.wallpager.pic.BigPicActivity;
import com.android11.wallpager.pic.PicDetailActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DownLoadActivity extends BaseActivity implements DownListAdapter.OnDetailClickLitener, DownListAdapter.OndeleteClickLitener, DownListAdapter.OnItemClickLitener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.listview)
    RecyclerView listview;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    private File[] fileList;
    private List<File> list = new ArrayList<>();
    private DownListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        ButterKnife.bind(this);
        initViw();
        File file = Environment.getExternalStorageDirectory();
        String fileName = "android11/download";
        File appDir = new File(file, fileName);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        fileList = appDir.listFiles();
        for (File f : fileList) {
            if (f.getName().contains("downpic_"))
                list.add(f);
        }
        adapter = new DownListAdapter(list, this);
        listview.setAdapter(adapter);
        listview.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickLitener(this);
        adapter.setOndeleteClickLitener(this);
        adapter.setOnDetailClickLitener(this);
        if (list.size() > 0)
            tvEmpty.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initViw() {
        setSupportActionBar(mToolbar);
        //显示那个箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitle("下载管理");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent gobig = new Intent(this, BigPicActivity.class);
        gobig.putExtra("url", list.get(position).getAbsolutePath());

        startActivity(gobig);
        overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    @Override
    public void onDeleteClick(View view, final int position) {
        new MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .content("您确定要删除吗？")
                .positiveText("确定")
                .negativeText("取消")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        File f = list.get(position);
                        if (f.exists())
                            list.get(position).delete();

                        list.remove(position);
                        adapter.notifyItemRemoved(position);
                        adapter.notifyItemRangeChanged(position, list.size() - position);
//                        adapter.notifyDataSetChanged();
                        if (list.size() == 0)
                            tvEmpty.setVisibility(View.VISIBLE);
                        Log.d("zk position", "" + position);
                        Log.d("zk list size = ", "" + list.size());
                    }
                })
                .show();
    }

    @Override
    public void onDetaiClick(View view, int position) {
        Intent godetail = new Intent(this, PicDetailActivity.class);
        godetail.putExtra("id", list.get(position).getName()
                .replace("downpic_", "").replace(".jpg", ""));
        godetail.putExtra("url", list.get(position).getAbsolutePath());
        startActivity(godetail);

    }
}
