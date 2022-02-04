package com.elmiramammadova.runnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {
    var number=0
    var runnable:Runnable= Runnable {  }
    var handler : android.os.Handler=android.os.Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Start(view: View){
        runnable=object :Runnable{
            override fun run() {
                number++
                textView.text="Time: $number"
                handler.postDelayed(this,1000)
            }
        }
        handler.post(runnable)
    }

    fun Stop(view: View){
        handler.removeCallbacks(runnable)
        number=0
        textView.text="Time: 0"
    }
}