package com.xmh.androidabc2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/*
 * Toolbar 顶部工具条（activity标题、home-btn、menu-btn）
 *
 * DrawerLayout 侧边栏
 * NavigationView 侧边导航栏
 *
 * FloatingButton 悬浮按钮
 *
 * Snackbar toast替代品
 *
 * CoordinatorLayout 协调者布局（自动完成大多界面响应）（）
 * AppBarLayout Toolbar容器（继承自LinearLayout）（必须是CoordinatorLayout直接子view）
 * CollapsingToolbarLayout Toolbar容器（必须是AppBarLayout直接子view）
 *
 * CardView 卡片（添加圆角、阴影效果）（继承自FrameView）
 *
 * SwipeRefreshLayout 下拉刷新
 *
 * fitSystemWindows/statusBarColor 自动系统状态栏且背景透明
 */

public class MaterialActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        // tool-bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // drawer-layout
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        }

        // navigation-view
        mNavigationView = (NavigationView) findViewById(R.id.nav);
        mNavigationView.setCheckedItem(R.id.call);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        // float-button
        mFloatingActionButton= (FloatingActionButton) findViewById(R.id.btn);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"btn",Snackbar.LENGTH_SHORT)
                        .setAction("get", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.backup:
                break;
            case R.id.delete:
                break;
            case R.id.settings:
                break;
            case android.R.id.home:
                if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
                break;
        }
        return true;
    }
}
