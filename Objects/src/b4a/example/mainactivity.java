package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class mainactivity extends Activity implements B4AActivity{
	public static mainactivity mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.mainactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (mainactivity).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.mainactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.mainactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (mainactivity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (mainactivity) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return mainactivity.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (mainactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (mainactivity) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            mainactivity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (mainactivity) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _reglayout = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _darkmodelayout = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="regLayout = xui.CreatePanel(\"\")";
mostCurrent._reglayout = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="darkModeLayout = xui.CreatePanel(\"\")";
mostCurrent._darkmodelayout = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="Activity.AddView(darkModeLayout, 0, 0, 100%x, 100";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._darkmodelayout.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Activity.AddView(regLayout, 0, 0, 100%x, 100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._reglayout.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="regLayout.LoadLayout(\"Layout\")";
mostCurrent._reglayout.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="darkModeLayout.LoadLayout(\"Layout2\")";
mostCurrent._darkmodelayout.LoadLayout("Layout2",mostCurrent.activityBA);
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="mainactivity";
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _clockbtn_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clockbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clockbtn_click", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Private Sub clockBtn_Click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="StartActivity(clockActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._clockactivity.getObject()));
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="End Sub";
return "";
}
public static String  _clockbtn_longclick() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clockbtn_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clockbtn_longclick", null));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Private Sub clockBtn_LongClick";
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static void  _dlamp_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dlamp_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "dlamp_click", null); return;}
ResumableSub_dlamp_Click rsub = new ResumableSub_dlamp_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_dlamp_Click extends BA.ResumableSub {
public ResumableSub_dlamp_Click(b4a.example.mainactivity parent) {
this.parent = parent;
}
b4a.example.mainactivity parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="mainactivity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Starter.darkMode = False";
parent.mostCurrent._starter._darkmode /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="regLayout.Visible = True";
parent.mostCurrent._reglayout.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="regLayout.Alpha = 0";
parent.mostCurrent._reglayout.setAlpha((float) (0));
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="regLayout.SetAlphaAnimated(250, 1)";
parent.mostCurrent._reglayout.SetAlphaAnimated((int) (250),(float) (1));
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 0)";
parent.mostCurrent._darkmodelayout.SetAlphaAnimated((int) (250),(float) (0));
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="Sleep(250)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "mainactivity", "dlamp_click"),(int) (250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="darkModeLayout.Visible = False";
parent.mostCurrent._darkmodelayout.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _helpbtn_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "helpbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "helpbtn_click", null));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Private Sub helpBtn_Click";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="StartActivity(helpActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._helpactivity.getObject()));
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="End Sub";
return "";
}
public static void  _lamp_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lamp_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "lamp_click", null); return;}
ResumableSub_lamp_Click rsub = new ResumableSub_lamp_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_lamp_Click extends BA.ResumableSub {
public ResumableSub_lamp_Click(b4a.example.mainactivity parent) {
this.parent = parent;
}
b4a.example.mainactivity parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="mainactivity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Starter.darkMode = True";
parent.mostCurrent._starter._darkmode /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="darkModeLayout.Visible = True";
parent.mostCurrent._darkmodelayout.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="darkModeLayout.Alpha = 0";
parent.mostCurrent._darkmodelayout.setAlpha((float) (0));
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 1)";
parent.mostCurrent._darkmodelayout.SetAlphaAnimated((int) (250),(float) (1));
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="regLayout.SetAlphaAnimated(250, 0)";
parent.mostCurrent._reglayout.SetAlphaAnimated((int) (250),(float) (0));
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="Sleep(250)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "mainactivity", "lamp_click"),(int) (250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="regLayout.Visible = False";
parent.mostCurrent._reglayout.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _navbtn_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "navbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "navbtn_click", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Private Sub navBtn_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="StartActivity(navActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._navactivity.getObject()));
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="End Sub";
return "";
}
}