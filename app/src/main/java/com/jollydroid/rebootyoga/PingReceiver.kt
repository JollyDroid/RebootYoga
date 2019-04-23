package com.jollydroid.rebootyoga

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import java.util.concurrent.TimeUnit

class PingReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("happy", "ping "  + SystemClock.elapsedRealtime())

        val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intentToReboot = Intent(context, RebootReceiver::class.java)
        val pending = PendingIntent.getBroadcast(context, 1, intentToReboot, 0)

        alarmMgr.setExact(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + DELAY,
            pending)
    }

    companion object {
        val DELAY = TimeUnit.MINUTES.toMillis(10)
    }
}