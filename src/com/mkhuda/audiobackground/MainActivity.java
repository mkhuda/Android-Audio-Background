package com.mkhuda.audiobackground;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	//Mendefinisikan MediaPlayer sebagai audioBackground
	MediaPlayer audioBackground;
	
	/*Variabel untuk ToggleButton kita beri nama dengan myToggle*/
	ToggleButton myToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Memberi definisi di onCreate untuk toggle
		myToggle = (ToggleButton) findViewById(R.id.toggleSound); 
		
		//Memanggil file my_sound pada folder raw
		audioBackground = MediaPlayer.create(this, R.raw.my_sound);
        //Set looping ke true untuk mengulang audio jika telah selesai
		audioBackground.setLooping(true);
		//Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();
	}
	
	/*Mendefinisikan fungsi onToggleClicked dengan 
	pengkondisian standar if/else*/
	
	public void onToggleClicked(View view) {
		boolean on = ((ToggleButton) view).isChecked();
		
		if (on) {
			/*Mematikan suara audio*/
			audioBackground.setVolume(0, 0);
		} else {
			/*Menghidupkan kembali audio background*/
			audioBackground.setVolume(1, 1);
		}
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		audioBackground.stop();
		MainActivity.this.finish();
	}

}
