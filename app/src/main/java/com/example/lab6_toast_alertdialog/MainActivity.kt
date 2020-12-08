package com.example.lab6_toast_alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lab6_toast_alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //在Activity中使用View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //使用binding對象訪問視圖
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //建立要顯示在列表上的字串
        val list_item = arrayOf("對話框選項1","對話框選項2","對話框選項3","對話框選項4","對話框選項5")

        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "預設Toast", Toast.LENGTH_SHORT).show()
        }

        binding.btnCustomToast.setOnClickListener {
            //宣告Toast物件
            val toast = Toast(this)
            //設定Toast顯示的位置
            toast.setGravity(Gravity.TOP, 0, 50)
            //設定Toast持續時間
            toast.duration = Toast.LENGTH_SHORT
            //設定Toast自定義畫面
            toast.view = View.inflate(this, R.layout.custom_toast, null)
            //顯示Toast
            toast.show()

        }

        //宣告AlertDialog物件，setButton可以在Dialog對應位置顯示按鈕
        binding.btnDialog.setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle("按鍵式對話框")
                    .setMessage("對話框內容")
                    .setNeutralButton("取消",DialogInterface.OnClickListener {
                        dialog, which ->
                        showToast("左按鈕")
                    })
                    .setNegativeButton("拒絕", DialogInterface.OnClickListener {
                        dialog, which ->
                        showToast("中按鈕")
                    })
                    .setPositiveButton("確定", DialogInterface.OnClickListener {
                        dialog, which ->
                        showToast("右按鈕")
                    })
                    .show()

        }

        binding.btnListDialog.setOnClickListener {
            //宣告AlertDialog物件，setItems可以在Dialog顯示列表
            AlertDialog.Builder(this)
                    .setTitle("列表示對話匡")
                    .setItems(list_item, DialogInterface.OnClickListener { dialog, i ->
                        showToast("你選擇的是" + list_item[i])
                    })
                    .show()
        }

        binding.btnSingleDialog.setOnClickListener {
            //宣告變數用以保存選擇位置
            var position = 0
            //宣告AlertDialog物件，setSingleChoiceItems可以在Dialog顯示單選框
            AlertDialog.Builder(this)
                    .setTitle("單選式對話框")
                    .setSingleChoiceItems(list_item,0,
                            DialogInterface.OnClickListener { dialog, i ->
                                position = i
                            })
                    .setPositiveButton("確定",
                            DialogInterface.OnClickListener { dialog, i ->
                                showToast("你選擇的是" + list_item[position])
                            })
                    .show()
        }

    }

    private fun showToast(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}