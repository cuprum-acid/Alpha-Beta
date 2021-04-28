package com.example.alphabeta


import java.util.*
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.view.Gravity
import android.view.View
import android.widget.*
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : Activity() {
   private var viewFlipper: ViewFlipper? = null
    var a = "space"
    var textView: TextView? = null
    private val REQ_CODE = 100
    companion object {
        const val DEFAULT_100_PERCENT = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        var textView: TextView? = null
        val REQ_CODE = 100


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewFlipper = findViewById(R.id.view_flipper)
        val textView1 = TextView(this)
        textView1.text = "Dynamically added TextView"
        textView1.gravity = Gravity.CENTER
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



        textView = findViewById(R.id.text)
        val speak = findViewById<ImageView>(R.id.speak)
        speak.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Говорите")
            try {
                startActivityForResult(intent, REQ_CODE)
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(applicationContext,
                        "Просим прощения, ваше устройство не поддерживается",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        textView = findViewById(R.id.text)
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQ_CODE -> {
                if (resultCode == RESULT_OK && null != data) {
                    val result: ArrayList<String>? = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    a = result?.get(0).toString()
                    if (a == "yeah") {
                        textView?.setText("Молодец!");
                        var resID = getResources().getIdentifier("good", "raw", getPackageName())
                        val mediaPlayer = MediaPlayer.create(this, resID)
                        mediaPlayer.start()
                    } else{
                        textView?.setText("Попробуй еще раз!");
                        var resID = getResources().getIdentifier("bad", "raw", getPackageName())
                        val mediaPlayer = MediaPlayer.create(this, resID)
                        mediaPlayer.start()
                    }
                }
            }
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