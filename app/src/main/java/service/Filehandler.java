package service;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class Filehandler {

    public boolean isExternalStorageAvailable() {

        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public File generatefilenameonexternalstorage(){

        File pointtosavedirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
                                             ,"Recorded call");
        File pointtofile = new File(pointtosavedirectory,System.currentTimeMillis()+".3gp");

        if (!pointtofile.exists()){
            pointtofile.mkdirs();
        }
        return pointtofile;
    }


    public File generatetempbackupfileinanternalstorage(Context context){

        File pointtosaveddirectory = new File(context.getFilesDir(),"Recording Backup");
        File pointtofile = new File(pointtosaveddirectory,"Backup.3gp");

        if (!pointtofile.exists()){
            pointtofile.mkdirs();
        }
        return pointtofile;
    }
}
