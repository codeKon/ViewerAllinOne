package allinoneviewer.codekon.de.viewerallinone.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import allinoneviewer.codekon.de.viewerallinone.R;

public class WebViewFragment extends Fragment {

    private WebView mBrowserImages;
    private String mHtml;

    public static WebViewFragment newInstance(String html){

        WebViewFragment fragment = new WebViewFragment();
        fragment.mHtml = html;
        fragment.setRetainInstance(true);

        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_webview, container, false);
        mBrowserImages = (WebView)v.findViewById(R.id.browser_images);

        mBrowserImages.setWebViewClient(new WebViewClient());
        mBrowserImages.getSettings().setJavaScriptEnabled(true);

        mBrowserImages.loadDataWithBaseURL("", mHtml, "text/html", "utf-8", "");

        return v;

    }

}
