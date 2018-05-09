package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import service.Recordcall;

public class Callreceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state == null){
            //outgoing call

        }else if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            //incoming call

        }else if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){

            String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Intent startintent = new Intent(context,Recordcall.class);
            startintent.putExtra("number",number);
            context.startService(startintent);

        }else if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){

            context.stopService(new Intent(context,Recordcall.class));
        }
    }
}
