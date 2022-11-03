package heath.com.recordvideo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import heath.com.recordvideo.utils.ACache;

public class MainActivity extends AppCompatActivity {

    private Button button;
    public static ACache aCache;
    public static File cache;
    private static ImageView mShowImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open();
        init();
        button = this.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        RecordVideoActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    public static void update(Bitmap bitmap){
        mShowImg.setImageBitmap(bitmap);
    }

    private void init() {
        aCache = ACache.get(this);
        mShowImg = findViewById(R.id.show_img);
        cache = new File(Environment.getExternalStorageDirectory() + "/" + getPackageName() + "/nim", "cache");
        if (!cache.exists()) {
            cache.mkdirs();
        }
    }

    private void open() {
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.CAMERA};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                }
            }
        }
    }
}
