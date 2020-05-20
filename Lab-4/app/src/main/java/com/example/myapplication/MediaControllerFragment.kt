package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_media_controller.*


class MediaControllerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_media_controller, container, false);

        val chooseButton = view.findViewById(R.id.button5) as Button
        val clickListenerChoose = View.OnClickListener {view ->
            chooseFile(view);
        }
        chooseButton.setOnClickListener(clickListenerChoose)

        val buttonLoad = view.findViewById(R.id.button10) as Button
        val clickListenerLoad = View.OnClickListener {view ->
            load(view);
        }
        buttonLoad.setOnClickListener(clickListenerLoad)
        return view
    }

    fun load(view: View)
    {
        val mediaController = MediaController(context)
        videoView2.setMediaController(mediaController)
        mediaController.setMediaPlayer(videoView2)


        val uri = Uri.parse(editText.text.toString());
        videoView2.setVideoURI(uri)
    }

    private fun chooseFile(view: View)
    {
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
                val mediaController = MediaController(context)
                videoView2.setMediaController(mediaController)
                mediaController.setMediaPlayer(videoView2)


                val uri = data.data!!
                videoView2.setVideoURI(uri)
            }
        }
    }
}
