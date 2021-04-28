package com.example.alphabeta



import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper



class MainActivity : Activity() {
   private var viewFlipper: ViewFlipper? = null

    companion object {
        const val DEFAULT_100_PERCENT = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewFlipper = findViewById(R.id.view_flipper)
        val textView = TextView(this)
        textView.text = "Dynamically added TextView"
        textView.gravity = Gravity.CENTER
       /* viewFlipper.addView(textView)
        viewFlipper.setFlipInterval(2000)
        viewFlipper.startFlipping()*/

        val vopros_read = findViewById<ImageView>(R.id.vopros_read)
        vopros_read.setOnClickListener {
            var resID = getResources().getIdentifier("hint_read", "raw", getPackageName())
            val mediaPlayer = MediaPlayer.create(this, resID)
            mediaPlayer.start()
        }

        val vopros_write = findViewById<ImageView>(R.id.vopros_write)
        vopros_write.setOnClickListener {
            var resID = getResources().getIdentifier("hint_write", "raw", getPackageName())
            val mediaPlayer = MediaPlayer.create(this, resID)
            mediaPlayer.start()
        }

        val letterd = findViewById<TextView>(R.id.letterd)
        letterd.setOnClickListener {
            var resID = getResources().getIdentifier("a", "raw", getPackageName())
            val mediaPlayer = MediaPlayer.create(this, resID)
            mediaPlayer.start()
        }

        val pic1 = findViewById<ImageView>(R.id.pic1)
        pic1.setOnClickListener {
            var resID = getResources().getIdentifier("arbuz", "raw", getPackageName())
            val mediaPlayer = MediaPlayer.create(this, resID)
            mediaPlayer.start()
        }

        val arrow1 = findViewById<ImageView>(R.id.arrow1)
        arrow1.setOnClickListener{
            val randomIntent = Intent(this, MainMenu::class.java)
            startActivity(randomIntent)
        }
        val arrow2 = findViewById<ImageView>(R.id.arrow2)
        arrow2.setOnClickListener{
            val randomIntent = Intent(this, MainMenu::class.java)
            startActivity(randomIntent)
        }
    }



    fun nextView(v: View?) {
        viewFlipper!!.setInAnimation(this, R.anim.slide_in_right)
        viewFlipper!!.setOutAnimation(this, R.anim.slide_out_left)
        viewFlipper!!.showNext()
    }

    fun previousView(v: View?) {
        viewFlipper!!.setOutAnimation(this, R.anim.slide_out_right)
        viewFlipper!!.setInAnimation(this, R.anim.slide_in_left)
        viewFlipper!!.showPrevious()
    }




}