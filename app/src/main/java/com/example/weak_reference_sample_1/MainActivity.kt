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

        i = softReference?.get()
        Log.d("Tatsuya", "開放後の呼び出し: ${i}")
    }
}
