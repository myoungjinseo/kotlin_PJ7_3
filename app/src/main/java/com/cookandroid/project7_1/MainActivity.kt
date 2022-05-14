package com.cookandroid.project7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var tvName : EditText
    lateinit var tvEmail : EditText
    lateinit var button1 : Button
    lateinit var dlgEdtName : EditText
    lateinit var dlgEdtEmail : EditText
    lateinit var toastText : TextView
    lateinit var dialogView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"

        tvName = findViewById<EditText>(R.id.tvName)
        tvEmail = findViewById<EditText>(R.id.tvEmail)
        button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener{
            dialogView = View.inflate(this@MainActivity,R.layout.dialog1,null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.drawable.ic_menu_allfriends)
            dlg.setView(dialogView)
            dlgEdtName = dialogView.findViewById<EditText>(R.id.dlgEdt1)
            dlgEdtEmail = dialogView.findViewById<EditText>(R.id.dlgEdt2)
            dlgEdtEmail.text = tvEmail.text
            dlgEdtName.text = tvName.text
            dlg.setPositiveButton("확인"){ dialog,which ->
                tvName.text = dlgEdtName.text
                tvEmail.text = dlgEdtEmail.text
            }
            dlg.setNegativeButton("취소"){ dialog,which ->
                var toast = Toast(this@MainActivity)
                toastView = View.inflate(this@MainActivity,R.layout.toast1,null)
                toastText = toastView.findViewById<TextView>(R.id.toastText1)
                toast.setGravity(0, 200, 200);
                toastText.text = "취소했습니다."
                toast.view = toastView
                toast.show()
            }
            dlg.show()
        }
    }
}