package io.secon.getknowme;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // インスタンス化
        Button twBtn = (Button) findViewById(R.id.twBtn);
        Button mailBtn = (Button) findViewById(R.id.mailBtn);

        // リスナーの設定
        twBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(v);
            }
        });

        mailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(v);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // イベントの設定
    public void btnClick(View v){
        Intent intent = null;
        switch(v.getId()){
            case (R.id.twBtn):
                // Toast.makeText(MainActivity.this, "hoge", Toast.LENGTH_LONG).show();
                intent = new Intent(intent.ACTION_VIEW,
                        Uri.parse("https://twitter.com/secon_second"));
                break;
            case (R.id.mailBtn):
                intent = new Intent(intent.ACTION_SEND);
                intent.setType("text/email");

                // 文字列を取得
                Resources res = getResources();
                String[] mailTo = {res.getString(R.string.mailTo)};
                String mailSub = res.getString(R.string.mailSub);

                intent.putExtra(Intent.EXTRA_EMAIL, mailTo);
                intent.putExtra(Intent.EXTRA_SUBJECT, mailSub);
        }
        if (intent != null){
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
