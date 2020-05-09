package jp.techacademy.hisashi.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val value1 = intent.getDoubleExtra("VALUE",0.0)
        val regex =Regex(".0+\$")
        textview.text = regex.replace(value1.toString(),"")//少数点以下の無効な0を削除
        //Log.d("yonehisa","${"%.2f".format(value1)}")//少数２桁丸め用試し

    }
}
