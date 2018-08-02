package com.akshay.asynctask

import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL
import java.security.Policy

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        b1.setOnClickListener {
            var task = Mytask(iv)
            task.execute()
        }
    } //oncreate

    class Mytask(var imageView: ImageView): AsyncTask<Unit,Unit, Unit>(){

        var a : InputStream? = null

        override fun doInBackground(vararg p0: Unit?) {
            var ish = URL("dsdfsd")
            a = ish.openStream()
            
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            var bmp = BitmapFactory.decodeStream(a)
            imageView.setImageBitmap(bmp)
        }

    }


}
