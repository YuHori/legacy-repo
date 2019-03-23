package wp.com.yuhori.remscripture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ボタンにクリックイベント
		Button button_random = (Button)findViewById(R.id.start_random_button);
		button_random.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
        		// 画面遷移
        		Intent intent = new Intent();
        		intent.setClassName("wp.com.yuhori.remscripture", "wp.com.yuhori.remscripture.RandomActivity");
        		startActivity(intent);
            }
        });
		
		Button button_reorder = (Button)findViewById(R.id.start_reorder_button);
		button_reorder.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
        		// 画面遷移
        		Intent intent = new Intent();
        		intent.setClassName("wp.com.yuhori.remscripture", "wp.com.yuhori.remscripture.ReorderActivity");
        		startActivity(intent);
            }
        });
	}
}
