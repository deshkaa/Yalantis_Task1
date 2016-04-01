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

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        int[] dataset = new int[] {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3};

        RecyclerView.Adapter adapter = new RecyclerViewAdapter(dataset, onClickListener);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
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
