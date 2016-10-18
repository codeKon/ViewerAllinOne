package allinoneviewer.codekon.de.viewerallinone.Fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import allinoneviewer.codekon.de.viewerallinone.R;

public class VideoFragment  extends Fragment {

    private VideoView mVideoView;

    public static VideoFragment newInstance (String content){

        VideoFragment fragment = new VideoFragment();

        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_video, container, false);
        mVideoView=  (VideoView)v.findViewById(R.id.videoView);

        playVideo();

        return v;

    }

    public void playVideo() {

        Uri video = Uri.parse("android.resource://" + getActivity().getApplicationContext().getPackageName() + "/"
                + R.raw.la_linea);

        mVideoView.setVideoURI(video);
        mVideoView.setMediaController(new MediaController(getActivity()));
        mVideoView.requestFocus();
        mVideoView.start();
    }

}