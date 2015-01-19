package com.wangwl.mycalculator;

import com.wangwl.expression.*;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private EditText etHist;
	private EditText etInput;
	private String strInput;
	private boolean flag;
	private ExpressionParser expParser = null;
    private int[] btnIds = { 
    		R.id.mod,R.id.clean, R.id.leftp, R.id.rightp, R.id.backspace,  
    		R.id.sin,R.id.num7, R.id.num8, R.id.num9, R.id.div, 
    		R.id.cos,R.id.num4, R.id.num5,R.id.num6,R.id.mult,  
    		R.id.tan,R.id.num1, R.id.num2,R.id.num3,R.id.sub,
    		R.id.log,R.id.num0, R.id.point,R.id.equal,R.id.add};  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        strInput = "0";
        flag = false;
        expParser =  new ExpressionParser(); 
        setContentView(R.layout.activity_main);

        etHist = (EditText)findViewById(R.id.hist);
        etHist.setGravity(Gravity.RIGHT);
        etHist.setEnabled(false);
        etInput = (EditText)findViewById(R.id.input);
        etInput.setGravity(Gravity.RIGHT);
        etInput.setText(strInput); 
        etInput.setEnabled(false);
        etInput.setFocusable(true);
        for(int i = 0;i<btnIds.length;i++){
        	((Button)findViewById(btnIds[i])).setOnClickListener(this);
        }
    }
    
    @Override  
    protected void onSaveInstanceState(Bundle outState) {  
        super.onSaveInstanceState(outState);  
        outState.putString("Input", strInput);
        outState.putBoolean("flag", flag);
    } 

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
    	super.onRestoreInstanceState(savedState);
    	strInput = (String) savedState.getString("Input");
    	flag = (boolean)savedState.getBoolean("flag");
    }
    
    public void onConfigurationChanged(Configuration newConfig) {  
        super.onConfigurationChanged(newConfig);  
        // Checks the orientation of the screen  
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {  
  
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){  
  
        }  
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	System.exit(0);
            return true;
        }
        else if(id == R.id.action_info){
        	Toast.makeText(getApplicationContext(), "Developed by Wang Wenlong \n for week5 assignment \n E-mail:lonwon@126.com",
        		     Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String txt = ((Button) v).getText().toString();
		switch(v.getId()){
			case R.id.equal:
				strInput += txt;
				etHist.setText(strInput);
				strInput = expParser.eval(strInput);
				if(strInput.endsWith(".0")){
					strInput = strInput.substring(0, strInput.length()-2);
				}
				etInput.setText(strInput);
				flag = true;
				break;
			case R.id.backspace:
				strInput=etInput.getText().toString();
				if(strInput.length() > 0){
					strInput= strInput.substring(0, strInput.length()-1);
				}
				etInput.setText(strInput);
				break;
			case R.id.clean:
				strInput = "0";
				etInput.setText(strInput); 
				etHist.setText("");
				break;
			case R.id.sin:
			case R.id.cos:
			case R.id.tan:
			case R.id.log:
				txt += "(";
				if(flag || strInput == "0"){
					strInput = "";
				}
			case R.id.add:
			case R.id.sub:
			case R.id.mult:
			case R.id.div:
			case R.id.mod:
				flag = false;
				strInput+= txt;
				etInput.setText(strInput);
				break;
			case R.id.num0:
				if(strInput == "0"){
					break;
				}
			case R.id.num1:
			case R.id.num2:
			case R.id.num3:
			case R.id.num4:
			case R.id.num5:
			case R.id.num6:
			case R.id.num7:
			case R.id.num8:
			case R.id.num9:
			case R.id.leftp:
			case R.id.rightp:
			case R.id.point:
				if(flag || strInput == "0"){
					strInput = "";
					flag = false;
				}
				strInput+= txt;
				etInput.setText(strInput);
				break;
			default:
				break;
		}
	}
}
