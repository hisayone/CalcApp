package jp.techacademy.hisashi.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import android.support.v7.app.AlertDialog


class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusbutton.setOnClickListener(this)
        minusbutton.setOnClickListener(this)
        multiplybutton.setOnClickListener(this)
        devidebutton.setOnClickListener(this)

//      plusbutton.setOnClickListener{
//          val intent = Intent(this,SecondActivity::class.java)
//
//          intent.putExtra("VALUE1",edittext1.text.toString())
//          intent.putExtra("VALUE2",edittext2.text.toString())
//          startActivity(intent)
//      }

    }

    override fun onClick(v:View){
        val intent = Intent(this,SecondActivity::class.java)

        if (edittext1.text.toString() == "" || edittext2.text.toString()==""){

            showAlertDialog()

            Log.d("","")
        }else {
            when(v.id){
                R.id.plusbutton ->intent.putExtra("VALUE",
                    edittext1.text.toString().toDouble()+edittext2.text.toString().toDouble())
                R.id.minusbutton ->intent.putExtra("VALUE",
                    edittext1.text.toString().toDouble()-edittext2.text.toString().toDouble())
                R.id.multiplybutton ->intent.putExtra("VALUE",
                    edittext1.text.toString().toDouble()*edittext2.text.toString().toDouble())
                R.id.devidebutton ->intent.putExtra("VALUE",
                    edittext1.text.toString().toDouble()/edittext2.text.toString().toDouble())
            }
            startActivity(intent)
        }

    }

    private fun showAlertDialog(){
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("タイトル")
        alertDialogBuilder.setMessage("数値が入力されていません。入力してください。")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK"){dialog, which ->
            Log.d("UI_PARTS", "OKボタン")
        }

        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

    }

}
