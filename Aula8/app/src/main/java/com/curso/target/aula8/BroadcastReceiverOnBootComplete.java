package com.curso.target.aula8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastReceiverOnBootComplete extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
            Intent serviceIntent = new Intent(context, AndroidServiceStartOnBoot.class);

            context.startService(serviceIntent);

//            PendingIntent pintent = PendingIntent.getService(context, 0, serviceIntent, 0);
//            AlarmManager alarm  = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//            //1 em 1 minuto
//            alarm.setRepeating(AlarmManager.RTC_WAKEUP,
//                    System.currentTimeMillis(),60*1000,pintent);

            
        }
    }
}