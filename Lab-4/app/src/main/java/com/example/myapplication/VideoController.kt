package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_video_media_controller.*


class VideoController : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_video_media_controller, container, false);

        val chooseButton = view.findViewById(R.id.button) as Button
        val clickListenerChoose = View.OnClickListener {view ->
            chooseFile(view);
        }
        chooseButton.setOnClickListener(clickListenerChoose)

        val playButton = view.findViewById(R.id.button2) as Button
        val clickListenerPlay = View.OnClickListener {view ->
            play(view);
        }
        playButton.setOnClickListener(clickListenerPlay)

        val stopButton = view.findViewById(R.id.button3) as Button
        val clickListenerStop = View.OnClickListener {view ->
            stop(view);
        }
        stopButton.setOnClickListener(clickListenerStop)

        val pauseButton = view.findViewById(R.id.button4) as Button
        val clickListenerPause = View.OnClickListener {view ->
            pause(view);
        }
        pauseButton.setOnClickListener(clickListenerPause)

       // val myVideoUri = Uri.parse("android.resource://" + context!!.packageName + "/" + R.raw.inception_trailer)

        playButton.setEnabled(false)
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);

        return view
    }

    private fun chooseFile(view: View)
    {
        /*
        videoPlayer.setMediaController(MediaController(getActivity()))
        val myVideoUri = Uri.parse("android.resource://" + context!!.packageName + "/" + R.raw.inception_trailer)
        val ref = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        val uri = Uri.parse(ref)
        videoPlayer.setVideoURI(uri)
        videoPlayer.setOnPreparedListener(OnPreparedListener { videoPlayer.start() })*/

        val intent = Intent()
        intent.setType("video/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && data != null)
        {
            if(requestCode == 101)
            {
                 val uri = data.data!!
                 videoPlayer.setVideoURI(uri)
                 button2.setEnabled(true)
            }
        }
    }
    fun play(view: View?) {
        videoPlayer.start()
        button2.setEnabled(false)
        button3.setEnabled(true)
        button4.setEnabled(true)
    }

    fun pause(view: View?) {
        videoPlayer.pause()
        button2.setEnabled(true)
        button3.setEnabled(true)
        button4.setEnabled(false)
    }

    fun stop(view: View?) {
        videoPlayer.stopPlayback()
        videoPlayer.resume()
        button2.setEnabled(true)
        button3.setEnabled(false)
        button4.setEnabled(false)
    }
}
