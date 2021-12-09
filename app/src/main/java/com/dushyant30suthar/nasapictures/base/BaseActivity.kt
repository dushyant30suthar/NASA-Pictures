package com.dushyant30suthar.nasapictures.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.AndroidInjection

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    companion object {
        const val TAG: String = "BaseActivity"
    }

    var binding: T? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutResourceFile())
        setViewModel()
        initObservers()
    }

    abstract fun getLayoutResourceFile(): Int
    abstract fun setViewModel()
    abstract fun initObservers()

    open fun setUpActionBar(
        title: String?,
        addBackButton: Boolean,
        toolbar: Toolbar?,
        backDrawable: Drawable?
    ): ActionBar? {
        toolbar?.let { setSupportActionBar(it) }
        val actionBar = supportActionBar
        actionBar?.title = title
        if (addBackButton) {
            actionBar?.setHomeButtonEnabled(true)
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setDisplayShowHomeEnabled(true)
            if (backDrawable != null) actionBar?.setHomeAsUpIndicator(backDrawable)
        }
        return actionBar
    }
}