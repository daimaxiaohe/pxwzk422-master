package com.example.pxwzoukao422;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.pxwzoukao422.fragment.HomeFragment;
import com.example.pxwzoukao422.fragment.MassageFragment;
import com.example.pxwzoukao422.fragment.SheFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpagers)
    ViewPager viewpagers;
    @BindView(R.id.butone)
    RadioButton butone;
    @BindView(R.id.buttwo)
    RadioButton buttwo;
    @BindView(R.id.butsan)
    RadioButton butsan;
    @BindView(R.id.rg)
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {

        final ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new SheFragment());
        list.add(new MassageFragment());

        //设置适配器
        viewpagers.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //设置点击事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId){
                        case R.id.butone:
                            viewpagers.setCurrentItem(0);
                            break;
                        case R.id.buttwo:
                             viewpagers.setCurrentItem(1);

                             break;

                        case 2:
                            viewpagers.setCurrentItem(2);

                            break;
                    }
            }
        });

        //设置滑动
        viewpagers.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                   switch (i){
                       case 0:
                           rg.check(R.id.butone);
                           break;

                       case 1:
                           rg.check(R.id.buttwo);
                           break;

                       case 2:
                           rg.check(R.id.butsan);
                           break;
                   }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
