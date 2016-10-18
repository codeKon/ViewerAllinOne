package allinoneviewer.codekon.de.viewerallinone.Contoller;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import allinoneviewer.codekon.de.viewerallinone.Fragment.WebViewFragment;

public class CustomViewPagerAdapter extends FragmentStatePagerAdapter {

    String mHtml0 = "<html><head></head><body><img src=file:///android_res/drawable/software_book_1.jpg></body></html>";
    String mHtml1 = "<html><head></head><body><img src=file:///android_res/drawable/software_book_2.jpg></body></html>";
    String mHtml2 = "<html><head></head><body><img src=file:///android_res/drawable/software_book_3.jpg></body></html>";
    String mHtml3 = "<html><head></head><body><img src=file:///android_res/drawable/software_book_4.jpg></body></html>";
    String mHtml4 = "<html><head></head><body><img src=file:///android_res/drawable/software_book_5.jpg></body></html>";

    String [] mImagePathHtml = {mHtml0,mHtml1,mHtml2,mHtml3,mHtml4};

    WebViewFragment[] mFragmentWebViews;

    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);

        this.mFragmentWebViews =  new WebViewFragment[]{WebViewFragment.newInstance(mImagePathHtml[0]), WebViewFragment.newInstance(mImagePathHtml[1]),
                WebViewFragment.newInstance(mImagePathHtml[2]), WebViewFragment.newInstance(mImagePathHtml[3]), WebViewFragment.newInstance(mImagePathHtml[4])};
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        return super.instantiateItem(container, position);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int i) {
        return mFragmentWebViews[i];
    }

    @Override
    public int getCount() {
        return 5;
    }
}
