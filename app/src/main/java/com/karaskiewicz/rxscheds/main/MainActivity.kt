package com.karaskiewicz.rxscheds.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import com.karaskiewicz.rxscheds.R
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

  val completableObserver = object : CompletableObserver {
    override fun onSubscribe(d: Disposable) {
      Timber.d("onSubscribe thread = ${Thread.currentThread().name}")
    }

    override fun onComplete() {
      Timber.d("onComplete thread = ${Thread.currentThread().name}")
      throw IllegalStateException("onComplete")
    }

    override fun onError(e: Throwable) {
      Timber.d("onError thread = ${Thread.currentThread().name}")
      throw IllegalStateException("onError")
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

    val rxTestBlock = {
      foo()
      // bar()
    }

    Handler(Looper.getMainLooper()).postDelayed(rxTestBlock, 1000)
  }

  private fun foo() {
    Completable.timer(1, TimeUnit.SECONDS)
      .subscribe(completableObserver)
  }

  private fun bar() {
    Completable.complete().subscribeOn(Schedulers.computation())
      .subscribe(completableObserver)
  }
}
