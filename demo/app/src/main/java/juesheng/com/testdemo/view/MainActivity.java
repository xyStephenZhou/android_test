package juesheng.com.testdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import juesheng.com.testdemo.R;

/**
 * Created by 2019/11/6.
 * author:sdifenzhou
 * company 杭州决盛网络科技有限公司
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

    }
    public void send_msg(View view){
        EventBus.getDefault().post(new MessageEvent("我是消息"));
    }


    public void take_pic(View view){
        EventBus.getDefault().post(new MessageEvent1("我是消息1"));
    }

}
