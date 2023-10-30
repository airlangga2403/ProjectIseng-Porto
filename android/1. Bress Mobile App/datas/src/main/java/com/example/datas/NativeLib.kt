package com.example.datas

class NativeLib {

    /**
     * A native method that is implemented by the 'datas' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'datas' library on application startup.
        init {
            System.loadLibrary("datas")
        }
    }
}