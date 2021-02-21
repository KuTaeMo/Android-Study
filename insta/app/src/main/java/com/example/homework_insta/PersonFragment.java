package com.example.homework_insta;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class PersonFragment extends Fragment {

    private FragmentActivity myContext;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private ViewPager vpContainer;
    private TabLayout tabs;

    @Override
    public void onAttach(@NonNull Context context) {
        myContext=(FragmentActivity)context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_person,container,false);
        vpContainer=view.findViewById(R.id.vp_container);
        tabs=view.findViewById(R.id.tabs);
        FragmentManager fragmentManager=myContext.getSupportFragmentManager();


        myFragmentPagerAdapter=new MyFragmentPagerAdapter(fragmentManager,1);

        myFragmentPagerAdapter.addFragment(new TabFragment1());
        myFragmentPagerAdapter.addFragment(new TabFragment2());

        vpContainer.setAdapter(myFragmentPagerAdapter);

        tabs.setupWithViewPager(vpContainer);

        tabs.getTabAt(0).setIcon(R.drawable.ic_grid);
        tabs.getTabAt(1).setIcon(R.drawable.ic_image);

        return view;
    }
}
