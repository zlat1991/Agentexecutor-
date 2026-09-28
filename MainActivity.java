package com.agent.executor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
  @Override public void onCreate(Bundle b) {
    super.onCreate(b);
    LinearLayout l = new LinearLayout(this); l.setOrientation(LinearLayout.VERTICAL); l.setPadding(40,60,40,40);
    TextView title = new TextView(this); title.setText("Agent Executor\\n\\nЭто исполнитель для разрешённых действий AI-агента на телефоне.\\n\\n1. Нажмите кнопку ниже.\\n2. Включите Agent Executor в специальных возможностях.\\n3. Вернитесь сюда."); title.setTextSize(18);
    Button settings = new Button(this); settings.setText("Открыть специальные возможности"); settings.setOnClickListener(v -> startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)));
    Button test = new Button(this); test.setText("Тест: открыть Google"); test.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW, android.net.Uri.parse("https://www.google.com"))));
    l.addView(title); l.addView(settings); l.addView(test); setContentView(l);
  }
}
