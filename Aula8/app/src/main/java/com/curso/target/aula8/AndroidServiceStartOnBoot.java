package com.curso.target.aula8;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class AndroidServiceStartOnBoot extends Service {

    @Override
    //binding de serviços
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    //criação do serviço
    public void onCreate() {
        super.onCreate();
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, new Intent(this, AndroidServiceStartOnBoot.class), 0);
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60 * 1000, pendingIntent);
    }

    @Override
    //quando o serviço for morto
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        repeat();
        return super.onStartCommand(intent, flags, startId);
    }

    private void repeat() {
        Toast.makeText(
                getApplicationContext()
                ,"fui chamado"
                ,Toast.LENGTH_LONG)
                .show();

        Log.d("mLog","bla");



    }
}