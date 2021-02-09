package fine.koacaiia.androidysk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
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

    Button btnRecycler;
    Button btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions(permission_list,0);
        btnRecycler=findViewById(R.id.btnRecyclerView);
        btnRecycler.setOnClickListener(v->{
            Intent intent=new Intent(MainActivity.this, Recyclerview.class);
            startActivity(intent);
        });
        btnCamera=findViewById(R.id.btnCameraView);
        btnCamera.setOnClickListener(v->{
            Intent intent=new Intent(MainActivity.this, CameraView.class);
            startActivity(intent);
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int result:grantResults){
            if (result==PackageManager.PERMISSION_DENIED){
               Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
        Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
    }
}