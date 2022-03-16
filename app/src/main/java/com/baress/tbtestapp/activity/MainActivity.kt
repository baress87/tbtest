package com.baress.tbtestapp.activity

import android.os.Bundle
import androidx.fragment.app.commit
import com.baress.tbtestapp.R
import com.baress.tbtestapp.fragment.main.MainFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            replace(R.id.mainContent, MainFragment.newInstance())
        }
    }
}
