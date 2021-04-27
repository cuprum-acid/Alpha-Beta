package com.example.alphabeta



import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.View
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

    }
    fun nextView(v: View?) {
        viewFlipper!!.setOutAnimation(this, R.anim.slide_in_right)
        viewFlipper!!.setInAnimation(this, R.anim.slide_out_left)
        viewFlipper!!.showNext()
    }

    fun previousView(v: View?) {
        viewFlipper!!.setInAnimation(this, R.anim.slide_in_right)
        viewFlipper!!.setOutAnimation(this, R.anim.slide_out_left)
        viewFlipper!!.showPrevious()
    }

}