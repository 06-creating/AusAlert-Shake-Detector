package com.example.ausalertshake;
import android.app.*; import android.os.*; import android.content.*; import android.graphics.Color; import android.graphics.Typeface; import android.graphics.drawable.GradientDrawable; import android.view.*; import android.widget.*;
public class MainActivity extends Activity {
 LinearLayout root; TextView status; Button monitor; boolean armed;
 int bg=0xff0b1220,card=0xff192338,red=0xffff3d53;
 int dp(int n){return (int)(getResources().getDisplayMetrics().density*n+.5f);}
 GradientDrawable shape(int color){GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(dp(18));return d;}
 TextView label(String s,int size,int color){TextView t=new TextView(this);t.setText(s);t.setTextSize(size);t.setTextColor(color);t.setGravity(Gravity.CENTER);t.setPadding(dp(12),dp(14),dp(12),dp(14));return t;}
 Button button(String s,int color){Button b=new Button(this);b.setText(s);b.setAllCaps(false);b.setTextColor(-1);b.setTextSize(17);b.setTypeface(null,Typeface.BOLD);b.setBackground(shape(color));return b;}
 void action(String a){Intent i=new Intent(this,ShakeService.class).setAction(a);if(a.equals("START"))startForegroundService(i);else if(a.equals("OFF"))stopService(new Intent(this,ShakeService.class));else startService(i);}
 void refresh(){armed=getPreferences(0).getBoolean("armed",false);status.setText(armed?"● MONITORING ACTIVE":"○ MONITORING OFF");status.setTextColor(armed?0xff62e5b0:0xffa5b3cb);monitor.setText(armed?"STOP MONITORING":"START MONITORING");}
 @Override public void onCreate(Bundle b){super.onCreate(b);getWindow().setStatusBarColor(bg);getWindow().setNavigationBarColor(bg);
 ScrollView scroll=new ScrollView(this);scroll.setBackgroundColor(bg);root=new LinearLayout(this);root.setOrientation(1);root.setPadding(dp(22),dp(30),dp(22),dp(24));scroll.addView(root);
 root.addView(label("AUSALERT  /  SHAKE DETECTOR",14,red));
 TextView title=label("SHAKE TO ALERT",29,-1);title.setTypeface(null,Typeface.BOLD);root.addView(title);
 ImageView icon=new ImageView(this);icon.setImageResource(R.drawable.icon);root.addView(icon,new LinearLayout.LayoutParams(-1,dp(175)));
 status=label("",20,0xffa5b3cb);root.addView(status);
 root.addView(label("3 alternating shakes • Sensitivity 65/100\n1-second activation delay • 30-second cooldown",14,0xffa5b3cb));
 monitor=button("",red);LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,dp(65));p.topMargin=dp(18);root.addView(monitor,p);
 monitor.setOnClickListener(v->{armed=!armed;getPreferences(0).edit().putBoolean("armed",armed).apply();action(armed?"START":"OFF");refresh();});
 Button test=button("TEST ALARM (1s countdown)",card);p=new LinearLayout.LayoutParams(-1,dp(60));p.topMargin=dp(15);root.addView(test,p);test.setOnClickListener(v->action("TEST"));
 Button stop=button("STOP ALARM",card);p=new LinearLayout.LayoutParams(-1,dp(60));p.topMargin=dp(12);root.addView(stop,p);stop.setOnClickListener(v->action("STOP"));
 root.addView(label("UNOFFICIAL DEMONSTRATION • Not an Australian government emergency warning service. Screen-off shake detection depends on device sensor restrictions.",12,0xffa5b3cb));
 setContentView(scroll);refresh();}
 @Override protected void onResume(){super.onResume();if(status!=null)refresh();}
}