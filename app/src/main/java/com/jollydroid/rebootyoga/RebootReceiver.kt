package com.jollydroid.rebootyoga

import android.app.admin.DevicePolicyManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log

class RebootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("happy", "reboot event")

        val admin = ComponentName(context, AdminReceiver::class.java)
        val policyManager = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

        try {
            policyManager.reboot(admin)
        } catch (e: SecurityException) {
            Log.d("happy", "App is not a Device owner: ${e.message}")
        }
    }
}