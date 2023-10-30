package com.example.breesmobileapp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.fragment.app.Fragment

// Intent Without this@
fun Activity.startActivity(
    cls: Class<*>,
    finishCallingActivity: Boolean = true,
    block: (Intent.() -> Unit)? = null
) {
    val intent = Intent(this, cls)
    block?.invoke(intent)
    startActivity(intent)
    if (finishCallingActivity) finish()
}

// Check Network
fun Context.isNetworkAvailable(): Boolean {
    val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities = manager.getNetworkCapabilities(manager.activeNetwork)
    return if (capabilities != null) {
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    } else false
}

//fun Fragment.isNetworkAvailable() = requireContext().isNetworkAvailable()

