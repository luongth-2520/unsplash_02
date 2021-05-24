package com.sun.unsplash_02.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading")
        progressDialog.setCancelable(false)
        progressDialog.isIndeterminate = true

        onInit()
        onEvent()
    }

    abstract fun getLayoutId(): Int

    abstract fun onInit()

    abstract fun onEvent()

    fun showProgressDialog() {
        if (!progressDialog.isShowing) {
            progressDialog.show()
        }
    }

    fun dismissProgressDialog() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }
}
