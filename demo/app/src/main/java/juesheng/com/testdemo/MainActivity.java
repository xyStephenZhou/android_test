package juesheng.com.testdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import juesheng.com.testdemo.sku1.SKU1Activity;
import juesheng.com.testdemo.sku2.SKU2Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SKU1Activity.class));
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SKU2Activity.class));
            }
        });
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Ac1Activity.class));
            }
        });


       ArrayList<Long> canChecked=new ArrayList<>();
       Long[][] result=new Long[][]{{2L,3L,5L},{19L,23L},{43L,47L},{83L,89L},{113L,127L,137L}};

        Long[][] add=new Long[][]{{2L,19L,43L,89L,113L},{2L,19L,43L,89L,127L},{2L,23L,43L,89L,127L},{3L,23L,43L,89L,113L},{3L,19L,43L,89L,113L},{3L,19L,43L,83L,127L},{3L,19L,47L,89L,113L},{5L,23L,43L,89L,113L},{5L,23L,43L,89L,137L}};
        for (int i = 0; i < add.length; i++) {
            long sum=1;
            for (int j = 0; j < add[i].length; j++) {
                sum*=add[i][j];
            }
            canChecked.add(sum);
        }
        for (int i = 0; i < canChecked.size(); i++) {
            Log.d("Test",canChecked.get(i).toString());
        }


    }
}
