package allinoneviewer.codekon.de.viewerallinone.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import allinoneviewer.codekon.de.viewerallinone.Contoller.CustomViewPagerAdapter;
import allinoneviewer.codekon.de.viewerallinone.R;

public class ImagesFragment extends Fragment {

    private FragmentStatePagerAdapter mPagerAdapter;
    private FragmentManager mFragmentManager;

    public ViewPager mViewPager;

    public static ImagesFragment newInstance(String content){

        ImagesFragment fragment = new ImagesFragment();

        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_images, container, false);
        mViewPager = (ViewPager) v.findViewById(R.id.viewPager);

        mFragmentManager = getActivity().getSupportFragmentManager();

        mPagerAdapter = new CustomViewPagerAdapter(mFragmentManager);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);


        return v;
    }
}
