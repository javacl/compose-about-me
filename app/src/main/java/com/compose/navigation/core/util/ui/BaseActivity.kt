package com.compose.navigation.core.util.ui

import android.content.Context
import androidx.activity.ComponentActivity
import com.compose.navigation.core.util.localizedContext

abstract class BaseActivity : ComponentActivity() {

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(localizedContext(context))
    }

    override fun onStart() {
        super.onStart()
        localizedContext(this)
    }
}
