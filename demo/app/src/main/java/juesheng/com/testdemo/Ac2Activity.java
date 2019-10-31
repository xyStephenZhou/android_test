package juesheng.com.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * 功能:
 * Created by ws on 2019/10/30 18:27
 * 公司:楚商金服
 */
public  class Ac2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_one);
        Log.d("hehe","Ac2Activity-----------onCreate-------------");
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ac2Activity.this,Ac2Activity.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("hehe","Ac2Activity-----------onRestart-------------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("hehe","Ac2Activity-----------onStart-------------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("hehe","Ac2Activity-----------onResume-------------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("hehe","Ac2Activity-----------onPause-------------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("hehe","Ac2Activity-----------onStop-------------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("hehe","Ac2Activity-----------onDestroy-------------");
    }
}
