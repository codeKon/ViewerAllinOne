package allinoneviewer.codekon.de.viewerallinone.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import allinoneviewer.codekon.de.viewerallinone.Contoller.CustomListViewAdapter;
import allinoneviewer.codekon.de.viewerallinone.Fragment.ImagesFragment;
import allinoneviewer.codekon.de.viewerallinone.Fragment.VideoFragment;
import allinoneviewer.codekon.de.viewerallinone.R;

public class MainActivity extends FragmentActivity {

    private final static String TAG_1 = "FRAGMENT_IMAGES";
    private final static String TAG_2 = "FRAGMENT_VIDEO";

    private final static String KEY_1 = "KEY_IMAGES";
    private final static String KEY_2 = "KEY_VIDEO";

    private static List<String> mList;

    private ImagesFragment mFragmentImages = new ImagesFragment();
    private VideoFragment mVideoFragment = new VideoFragment();

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;


    @Override
    public void onCreate(Bundle _savedInstanceState) {

        super.onCreate(_savedInstanceState);

        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listView);
        final TextView title = (TextView) findViewById(R.id.title);

        mList = new ArrayList<String>();

        mList.add(getString(R.string.images));
        mList.add(getString(R.string.video));

        CustomListViewAdapter adapter = new CustomListViewAdapter(this, mList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CustomListViewAdapter listViewAdapter = (CustomListViewAdapter) listView.getAdapter();

                mFragmentManager = getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();

                ImagesFragment fragmentI = (ImagesFragment) mFragmentManager.findFragmentByTag(TAG_1);
                VideoFragment fragmentV = (VideoFragment) mFragmentManager.findFragmentByTag(TAG_2);

                if (listViewAdapter.getItem(position) == getString(R.string.images)) {

                    if (fragmentI == null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(KEY_1, "Replace 1");
                        mFragmentImages.setArguments(bundle);

                        mFragmentTransaction.replace(R.id.container, mFragmentImages, TAG_1);

                        title.setText(getString(R.string.images));
                    }

                } else if (listViewAdapter.getItem(position) == getString(R.string.video)) {

                    if (fragmentV == null) {

                        Bundle bundle = new Bundle();
                        bundle.putString(KEY_2, "Replace 2");
                        mVideoFragment.setArguments(bundle);

                        mFragmentTransaction.replace(R.id.container, mVideoFragment, TAG_2);

                        title.setText(getString(R.string.video));
                    }

                } else {
                    mFragmentTransaction.replace(R.id.container, mFragmentImages, TAG_1);
                    title.setText(getString(R.string.images));
                }

                mFragmentTransaction.commitAllowingStateLoss();
            }
        });


    }
}
