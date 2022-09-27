package com.example.weak_reference_sample_1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.SoftReference

class MainActivity : AppCompatActivity() {

    private var number: Int? = 1
    private var softReference: SoftReference<Int>? = SoftReference(1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var i = softReference?.get()
        Log.d("Tatsuya", "初回呼び出し: ${i}")

        number = null
        i = null

        try {
            val map = HashMap<String, Array<Byte?>>()
            for (j in 0..999999) {
                val v = arrayOfNulls<Byte>(100000)
                val k = System.currentTimeMillis().toString()
                map[k] = v
            }
        } catch (oome: OutOfMemoryError) {
            Log.d("Tatsuya", "OutOfMemoryError!!")
        }

        i = softReference?.get()
        Log.d("Tatsuya", "開放後の呼び出し: ${i}")
    }
}
