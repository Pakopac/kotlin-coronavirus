package com.example.coronavirus.utils

import android.util.Log

private const val LOG_TAG = "iPlant LOG"

fun logI(message: String) = Log.i(LOG_TAG, message)
fun logD(message: String) = Log.d(LOG_TAG, message)
fun logE(message: String) = Log.e(LOG_TAG, message)