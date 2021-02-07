package fine.koacaiia.androidysk;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String[] permission_list={
            Manifest.permission.CAMERA
          , Manifest.permission.INTERNET,
    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.VIBRATE,
//            Manifest.permission.USE_FULL_SCREEN_INTENT,
    Manifest.permission.RECEIVE_BOOT_COMPLETED,
//            Manifest.permission.SET_ALARM,
    Manifest.permission.WAKE_LOCK

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions(permission_list,0);
    }


}