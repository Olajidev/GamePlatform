package com.tiankonguse.gameplatform;
 
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.tiankonguse.gameplatform.db.GetGameDB;

public class BeginActivity extends Activity {
	Context context = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_begin);
		context = this;
		
		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				//加载数据库
				GetGameDB.LoadGameDB(getContentResolver(), context);
				return null;
			}
			
			@Override
			protected void onPostExecute(Void result) {
				startActivity(new Intent(context,MainDownloadUI.class));
				finish();
				super.onPostExecute(result);
			}
			
		}.execute();
		
	}

}
