package com.agent.executor;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * MVP executor. It intentionally has no hidden network listener and no remote-control channel yet.
 * The next layer can feed validated commands to this service.
 */
public class AgentAccessibilityService extends AccessibilityService {
  private static AgentAccessibilityService instance;
  public static AgentAccessibilityService getInstance() { return instance; }
  @Override protected void onServiceConnected() { instance = this; }
  @Override public void onAccessibilityEvent(AccessibilityEvent e) { }
  @Override public void onInterrupt() { }
  @Override public void onDestroy() { if (instance == this) instance = null; super.onDestroy(); }

  public boolean tap(float x, float y) {
    Path p = new Path(); p.moveTo(x,y);
    GestureDescription g = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(p,0,80)).build();
    return dispatchGesture(g, null, null);
  }
  public boolean swipe(float x1,float y1,float x2,float y2,long duration) {
    Path p = new Path(); p.moveTo(x1,y1); p.lineTo(x2,y2);
    GestureDescription g = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(p,0,duration)).build();
    return dispatchGesture(g, null, null);
  }
  public boolean back() { return performGlobalAction(GLOBAL_ACTION_BACK); }
  public boolean home() { return performGlobalAction(GLOBAL_ACTION_HOME); }
  public List<String> readVisibleText() {
    List<String> out = new ArrayList<>(); AccessibilityNodeInfo root=getRootInActiveWindow(); if(root==null)return out;
    walk(root,out); return out;
  }
  private void walk(AccessibilityNodeInfo n,List<String> out){ if(n==null)return; CharSequence t=n.getText(); if(t!=null && t.length()>0)out.add(t.toString()); for(int i=0;i<n.getChildCount();i++)walk(n.getChild(i),out); }
}
