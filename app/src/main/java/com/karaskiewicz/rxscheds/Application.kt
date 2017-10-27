package com.karaskiewicz.rxscheds

import android.app.Application
import timber.log.Timber

class Application : Application() {

  override fun onCreate() {
    super.onCreate()
    initializeLogs()
  }

  private fun initializeLogs() {
    Timber.plant(Timber.DebugTree())
  }
}
