package com.example.nataliia.pr_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

//[Comment] Wrong toolbar and status bar color
//[Comment] Wrong paddings
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true); //[Comment] getSupportActionBar can be null
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast viewToast = Toast.makeText(MainActivity.this,
                        v.getClass().getSimpleName().toString(),
                        Toast.LENGTH_SHORT);
                viewToast.show();
            }
        };

        setAllControlsOnClick(R.id.linear_sub_layout, onClickListener);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        String[] mDataset = new String[] {"img_1","img_2","img_3"}; //[Comment] Looks like hardcode

        RecyclerView.Adapter mAdapter = new RecyclerViewAdapter(mDataset, onClickListener); //[Comment] use "m" prefix ONLY for private fields.
        // Not for local variables

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setAllControlsOnClick(int id, View.OnClickListener onClickListener) {
        ViewGroup tableViewGroup = (ViewGroup) findViewById(id);
        int mTableChildCount = tableViewGroup.getChildCount();
        for (int i = 0; i < mTableChildCount; i++) {
            View currentView = tableViewGroup.getChildAt(i);
            Class viewClass = currentView.getClass();
            if (!viewClass.equals(TableRow.class) && !viewClass.equals(TableLayout.class)) {
                currentView.setOnClickListener(onClickListener);
            } else {
                setAllControlsOnClick(currentView.getId(), onClickListener);
            }
        }
    }
}
