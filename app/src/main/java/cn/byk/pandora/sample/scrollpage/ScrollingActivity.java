package cn.byk.pandora.sample.scrollpage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Byk on 2018/11/27.
 */
public class ScrollingActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTab;

    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setView();
        setValue();
        setWatch();
    }

    private void setView() {
        mViewPager = findViewById(R.id.viewpager);
        mTab = findViewById(R.id.tb_top);
    }

    private void setValue() {
        mFragments.add(new ContentFragment());
        mFragments.add(new ContentFragment());
        mFragments.add(new ContentFragment());

        mViewPager.setAdapter(new ContentPagerAdapter(getSupportFragmentManager(), mFragments));
        mTab.setupWithViewPager(mViewPager);
    }

    private void setWatch() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Toast.makeText(ScrollingActivity.this, "Page:" + i, Toast.LENGTH_SHORT)
                     .show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
