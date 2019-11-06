package juesheng.com.testdemo.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.FileProvider;
import com.yanzhenjie.permission.runtime.Permission;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;

import juesheng.com.testdemo.R;

/**
 * Created by 2019/11/4.
 * author:sdifenzhou
 * company 杭州决盛网络科技有限公司
 */

public class FileActivity extends AppCompatActivity {

    private ImageView imageView;

    public static final String[] PERMISSIONS = new String[] {Permission.READ_EXTERNAL_STORAGE,
            Permission.WRITE_EXTERNAL_STORAGE,Permission.CAMERA};
    private static final int REQUEST_IMAGE_CAPTURE=1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        EventBus.getDefault().register(this);
        imageView = ((ImageView) findViewById(R.id.image));

    }
    private  File pictureFile=null;

    public void send_msg(View view){
        startActivity(new Intent(FileActivity.this,MainActivity.class));

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Log.d("hehe","1..........."+event.getMessage());
        };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent1(MessageEvent1 event) {
        Log.d("hehe","2..........."+event.getMessage());
      };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void take_pic(View view){
        AndPermission.with(FileActivity.this)
                .runtime()
                .permission(PERMISSIONS)
                .onGranted(permissions -> {
                    Uri pictureUri;
                    Intent intent = new Intent();
                    pictureFile = new File(Environment.getExternalStorageDirectory()
                            + File.separator + "MyPet/11.jpg");
                    if (!pictureFile.getParentFile().exists()) {
                        pictureFile.getParentFile().mkdirs();
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        pictureUri= FileProvider.getUriForFile(FileActivity.this,
                                getPackageName()+".fileprovider", pictureFile);
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    } else {
                        pictureUri= Uri.fromFile(pictureFile);
                    }
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

                })
                .onDenied(permissions -> {

                })
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case RESULT_OK:
                switch (requestCode) {
                    // 拍照
                    case REQUEST_IMAGE_CAPTURE:
                        Glide.with(FileActivity.this).load(pictureFile.getAbsolutePath()).into(imageView);
                        break;
                }
                break;
        }


    }
}
