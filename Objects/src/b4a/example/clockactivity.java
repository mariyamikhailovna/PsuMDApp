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

public class clockactivity extends Activity implements B4AActivity{
	public static clockactivity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.clockactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (clockactivity).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.clockactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.clockactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (clockactivity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (clockactivity) Resume **");
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
		return clockactivity.class;
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
            BA.LogInfo("** Activity (clockactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (clockactivity) Pause event (activity is not paused). **");
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
            clockactivity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (clockactivity) Resume **");
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
public static anywheresoftware.b4a.objects.Timer _timercount = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static int _secondsremain = 0;
public anywheresoftware.b4a.objects.LabelWrapper _pomotimerlbl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _playbtn = null;
public anywheresoftware.b4a.objects.LabelWrapper _pomocounter = null;
public anywheresoftware.b4a.objects.ButtonWrapper _settingsbtn = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _settingspnl = null;
public anywheresoftware.b4a.objects.EditTextWrapper _pomotxt = null;
public anywheresoftware.b4a.objects.EditTextWrapper _shorttxt = null;
public anywheresoftware.b4a.objects.EditTextWrapper _longtxt = null;
public static int _timerstate = 0;
public static int _counter = 0;
public static int _pomodef = 0;
public static int _shortdef = 0;
public static int _longdef = 0;
public static int _centerleft = 0;
public static int _centertop = 0;
public static boolean _playing = false;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.corkactivity _corkactivity = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Activity.LoadLayout(\"clocklayout\")";
mostCurrent._activity.LoadLayout("clocklayout",mostCurrent.activityBA);
 }else {
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="Activity.LoadLayout(\"clocklayoutDark\")";
mostCurrent._activity.LoadLayout("clocklayoutDark",mostCurrent.activityBA);
 };
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="timerCount.Initialize(\"tmr\", 1000)";
_timercount.Initialize(processBA,"tmr",(long) (1000));
 };
RDebugUtils.currentLine=3145738;
 //BA.debugLineNum = 3145738;BA.debugLine="timerCount.Enabled = False";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=3145740;
 //BA.debugLineNum = 3145740;BA.debugLine="pomoCounter.Text = counter";
mostCurrent._pomocounter.setText(BA.ObjectToCharSequence(_counter));
RDebugUtils.currentLine=3145741;
 //BA.debugLineNum = 3145741;BA.debugLine="End Sub";
return "";
}
public static String  _updatelbl() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updatelbl", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "updatelbl", null));}
int _mins = 0;
int _secs = 0;
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub updateLbl";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Dim mins As Int = secondsRemain / 60";
_mins = (int) (_secondsremain/(double)60);
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Dim secs As Int = secondsRemain Mod 60";
_secs = (int) (_secondsremain%60);
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="pomotimerLbl.Text = $\"$02.0{mins}:$02.0{secs}\"$";
mostCurrent._pomotimerlbl.setText(BA.ObjectToCharSequence((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("02.0",(Object)(_mins))+":"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("02.0",(Object)(_secs))+"")));
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="pomoCounter.Text = counter";
mostCurrent._pomocounter.setText(BA.ObjectToCharSequence(_counter));
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="clockactivity";
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="End Sub";
return "";
}
public static String  _closel_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "closel_click", null));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Private Sub closeL_Click";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="settingsPnl.Visible = False";
mostCurrent._settingspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="End Sub";
return "";
}
public static String  _exitbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "exitbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "exitbtn_click", null));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Private Sub exitBtn_Click";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="End Sub";
return "";
}
public static String  _formatbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "formatbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "formatbtn_click", null));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Private Sub formatBtn_Click";
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="MainActivity.format24h = Not(MainActivity.format2";
mostCurrent._mainactivity._format24h /*boolean*/  = anywheresoftware.b4a.keywords.Common.Not(mostCurrent._mainactivity._format24h /*boolean*/ );
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="If MainActivity.format24h Then";
if (mostCurrent._mainactivity._format24h /*boolean*/ ) { 
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
 }else {
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="DateTime.TimeFormat = \"hh:mm a\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("hh:mm a");
 };
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="CallSub(MainActivity, \"timerClock_Tick\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._mainactivity.getObject()),"timerClock_Tick");
RDebugUtils.currentLine=3407883;
 //BA.debugLineNum = 3407883;BA.debugLine="End Sub";
return "";
}
public static String  _longbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "longbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "longbtn_click", null));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Private Sub longBtn_Click";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="timerStop";
_timerstop();
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="secondsRemain = longDef";
_secondsremain = _longdef;
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="timerState = 1";
_timerstate = (int) (1);
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="End Sub";
return "";
}
public static String  _timerstop() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timerstop", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timerstop", null));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Private Sub timerStop";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="timerCount.Enabled = False";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="playing = False";
_playing = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="playBtn.Text = \"Start\"";
mostCurrent._playbtn.setText(BA.ObjectToCharSequence("Start"));
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="End Sub";
return "";
}
public static String  _playbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "playbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "playbtn_click", null));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Private Sub playBtn_Click";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="If secondsRemain > 0 Then";
if (_secondsremain>0) { 
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="timerCount.Enabled = True";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="If playing = True Then";
if (_playing==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="timerCount.Enabled = False";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="playing = False";
_playing = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="playBtn.Text = \"Start\"";
mostCurrent._playbtn.setText(BA.ObjectToCharSequence("Start"));
 }else {
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="timerCount.Enabled = True";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3473418;
 //BA.debugLineNum = 3473418;BA.debugLine="playing = True";
_playing = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3473419;
 //BA.debugLineNum = 3473419;BA.debugLine="playBtn.Text = \"Pause\"";
mostCurrent._playbtn.setText(BA.ObjectToCharSequence("Pause"));
 };
RDebugUtils.currentLine=3473422;
 //BA.debugLineNum = 3473422;BA.debugLine="End Sub";
return "";
}
public static String  _pomobtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pomobtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pomobtn_click", null));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Private Sub pomoBtn_Click";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="timerStop";
_timerstop();
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="secondsRemain = pomoDef";
_secondsremain = _pomodef;
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="timerState = 0";
_timerstate = (int) (0);
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="End Sub";
return "";
}
public static String  _savebtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "savebtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "savebtn_click", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub saveBtn_Click";
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="If IsNumber(pomoTxt.Text) Then pomoDef = pomoTxt.";
if (anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._pomotxt.getText())) { 
_pomodef = (int) ((double)(Double.parseDouble(mostCurrent._pomotxt.getText()))*60);};
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="If IsNumber(shortTxt.Text) Then shortDef = shortT";
if (anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._shorttxt.getText())) { 
_shortdef = (int) ((double)(Double.parseDouble(mostCurrent._shorttxt.getText()))*60);};
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="If IsNumber(longTxt.Text) Then longDef = longTxt.";
if (anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._longtxt.getText())) { 
_longdef = (int) ((double)(Double.parseDouble(mostCurrent._longtxt.getText()))*60);};
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="If timerState = 0 Then";
if (_timerstate==0) { 
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="secondsRemain = pomoDef";
_secondsremain = _pomodef;
 }else {
RDebugUtils.currentLine=4063242;
 //BA.debugLineNum = 4063242;BA.debugLine="If counter Mod 4 = 0 Then";
if (_counter%4==0) { 
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="secondsRemain = longDef";
_secondsremain = _longdef;
 }else {
RDebugUtils.currentLine=4063245;
 //BA.debugLineNum = 4063245;BA.debugLine="secondsRemain = shortDef";
_secondsremain = _shortdef;
 };
 };
RDebugUtils.currentLine=4063248;
 //BA.debugLineNum = 4063248;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=4063249;
 //BA.debugLineNum = 4063249;BA.debugLine="settingsPnl.Visible = False";
mostCurrent._settingspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4063250;
 //BA.debugLineNum = 4063250;BA.debugLine="End Sub";
return "";
}
public static String  _settingsbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "settingsbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "settingsbtn_click", null));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Private Sub settingsBtn_Click";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="settingsWindow(250dip, 180dip)";
_settingswindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="settingsPnl.Visible = True";
mostCurrent._settingspnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="End Sub";
return "";
}
public static String  _settingswindow(int _pw,int _ph) throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "settingswindow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "settingswindow", new Object[] {_pw,_ph}));}
anywheresoftware.b4a.objects.LabelWrapper _lblp = null;
anywheresoftware.b4a.objects.LabelWrapper _lbls = null;
anywheresoftware.b4a.objects.LabelWrapper _lbll = null;
anywheresoftware.b4a.objects.LabelWrapper _closel = null;
anywheresoftware.b4a.objects.ButtonWrapper _savebtn = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Private Sub settingsWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="settingsPnl = xui.CreatePanel(\"settingsPnl\")";
mostCurrent._settingspnl = _xui.CreatePanel(processBA,"settingsPnl");
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Activity.AddView(settingsPnl, centerLeft, centerT";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._settingspnl.getObject()),_centerleft,_centertop,_pw,_ph);
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="settingsPnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._settingspnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="settingsPnl.SetColorAndBorder(xui.Color_White, 2d";
mostCurrent._settingspnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="settingsPnl.Enabled = False";
mostCurrent._settingspnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="settingsPnl.Visible = False";
mostCurrent._settingspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="pomoTxt.Initialize(\"pomoTxt\")";
mostCurrent._pomotxt.Initialize(mostCurrent.activityBA,"pomoTxt");
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="pomoTxt.Hint = \"Pomo\"";
mostCurrent._pomotxt.setHint("Pomo");
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="pomoTxt.InputType = pomoTxt.INPUT_TYPE_NUMBERS";
mostCurrent._pomotxt.setInputType(mostCurrent._pomotxt.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=3670027;
 //BA.debugLineNum = 3670027;BA.debugLine="pomoTxt.Text = pomoDef / 60";
mostCurrent._pomotxt.setText(BA.ObjectToCharSequence(_pomodef/(double)60));
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="pomoTxt.Gravity = Gravity.CENTER_HORIZONTAL";
mostCurrent._pomotxt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=3670029;
 //BA.debugLineNum = 3670029;BA.debugLine="settingsPnl.AddView(pomoTxt, 10dip, 40dip, 70dip,";
mostCurrent._settingspnl.AddView((android.view.View)(mostCurrent._pomotxt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="shortTxt.Initialize(\"shortTxt\")";
mostCurrent._shorttxt.Initialize(mostCurrent.activityBA,"shortTxt");
RDebugUtils.currentLine=3670032;
 //BA.debugLineNum = 3670032;BA.debugLine="shortTxt.Hint = \"Short\"";
mostCurrent._shorttxt.setHint("Short");
RDebugUtils.currentLine=3670033;
 //BA.debugLineNum = 3670033;BA.debugLine="shortTxt.InputType = shortTxt.INPUT_TYPE_NUMBERS";
mostCurrent._shorttxt.setInputType(mostCurrent._shorttxt.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=3670034;
 //BA.debugLineNum = 3670034;BA.debugLine="shortTxt.Text = shortDef / 60";
mostCurrent._shorttxt.setText(BA.ObjectToCharSequence(_shortdef/(double)60));
RDebugUtils.currentLine=3670035;
 //BA.debugLineNum = 3670035;BA.debugLine="shortTxt.Gravity = Gravity.CENTER_HORIZONTAL";
mostCurrent._shorttxt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=3670036;
 //BA.debugLineNum = 3670036;BA.debugLine="settingsPnl.AddView(shortTxt, 90dip, 40dip, 70dip";
mostCurrent._settingspnl.AddView((android.view.View)(mostCurrent._shorttxt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=3670038;
 //BA.debugLineNum = 3670038;BA.debugLine="longTxt.Initialize(\"longTxt\")";
mostCurrent._longtxt.Initialize(mostCurrent.activityBA,"longTxt");
RDebugUtils.currentLine=3670039;
 //BA.debugLineNum = 3670039;BA.debugLine="longTxt.Hint = \"Long\"";
mostCurrent._longtxt.setHint("Long");
RDebugUtils.currentLine=3670040;
 //BA.debugLineNum = 3670040;BA.debugLine="longTxt.InputType = longTxt.INPUT_TYPE_NUMBERS";
mostCurrent._longtxt.setInputType(mostCurrent._longtxt.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=3670041;
 //BA.debugLineNum = 3670041;BA.debugLine="longTxt.Text = longDef / 60";
mostCurrent._longtxt.setText(BA.ObjectToCharSequence(_longdef/(double)60));
RDebugUtils.currentLine=3670042;
 //BA.debugLineNum = 3670042;BA.debugLine="longTxt.Gravity = Gravity.CENTER_HORIZONTAL";
mostCurrent._longtxt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=3670043;
 //BA.debugLineNum = 3670043;BA.debugLine="settingsPnl.AddView(longTxt, 170dip, 40dip, 70dip";
mostCurrent._settingspnl.AddView((android.view.View)(mostCurrent._longtxt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (170)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=3670045;
 //BA.debugLineNum = 3670045;BA.debugLine="Dim lblP, lblS, lblL As Label";
_lblp = new anywheresoftware.b4a.objects.LabelWrapper();
_lbls = new anywheresoftware.b4a.objects.LabelWrapper();
_lbll = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3670047;
 //BA.debugLineNum = 3670047;BA.debugLine="lblP.Initialize(\"\")";
_lblp.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3670048;
 //BA.debugLineNum = 3670048;BA.debugLine="lblP.Text = \"Pomo\"";
_lblp.setText(BA.ObjectToCharSequence("Pomo"));
RDebugUtils.currentLine=3670049;
 //BA.debugLineNum = 3670049;BA.debugLine="lblP.TextSize = 12";
_lblp.setTextSize((float) (12));
RDebugUtils.currentLine=3670050;
 //BA.debugLineNum = 3670050;BA.debugLine="lblP.Gravity = Gravity.CENTER_HORIZONTAL";
_lblp.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=3670051;
 //BA.debugLineNum = 3670051;BA.debugLine="settingsPnl.AddView(lblP, 10dip, 80dip, 70dip, 20";
mostCurrent._settingspnl.AddView((android.view.View)(_lblp.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=3670053;
 //BA.debugLineNum = 3670053;BA.debugLine="lblS.Initialize(\"\")";
_lbls.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3670054;
 //BA.debugLineNum = 3670054;BA.debugLine="lblS.Text = \"Short\"";
_lbls.setText(BA.ObjectToCharSequence("Short"));
RDebugUtils.currentLine=3670055;
 //BA.debugLineNum = 3670055;BA.debugLine="lblS.TextSize = 12";
_lbls.setTextSize((float) (12));
RDebugUtils.currentLine=3670056;
 //BA.debugLineNum = 3670056;BA.debugLine="lblS.Gravity = Gravity.CENTER_HORIZONTAL";
_lbls.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=3670057;
 //BA.debugLineNum = 3670057;BA.debugLine="settingsPnl.AddView(lblS, 90dip, 80dip, 70dip, 20";
mostCurrent._settingspnl.AddView((android.view.View)(_lbls.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=3670059;
 //BA.debugLineNum = 3670059;BA.debugLine="lblL.Initialize(\"\")";
_lbll.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3670060;
 //BA.debugLineNum = 3670060;BA.debugLine="lblL.Text = \"Long\"";
_lbll.setText(BA.ObjectToCharSequence("Long"));
RDebugUtils.currentLine=3670061;
 //BA.debugLineNum = 3670061;BA.debugLine="lblL.TextSize = 12";
_lbll.setTextSize((float) (12));
RDebugUtils.currentLine=3670062;
 //BA.debugLineNum = 3670062;BA.debugLine="lblL.Gravity = Gravity.CENTER_HORIZONTAL";
_lbll.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=3670063;
 //BA.debugLineNum = 3670063;BA.debugLine="settingsPnl.AddView(lblL, 170dip, 80dip, 70dip, 2";
mostCurrent._settingspnl.AddView((android.view.View)(_lbll.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (170)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=3670065;
 //BA.debugLineNum = 3670065;BA.debugLine="Dim closeL As Label";
_closel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3670066;
 //BA.debugLineNum = 3670066;BA.debugLine="closeL.Initialize(\"closeL\")";
_closel.Initialize(mostCurrent.activityBA,"closeL");
RDebugUtils.currentLine=3670067;
 //BA.debugLineNum = 3670067;BA.debugLine="settingsPnl.AddView(closeL, 10dip, 10dip, 20dip,";
mostCurrent._settingspnl.AddView((android.view.View)(_closel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=3670068;
 //BA.debugLineNum = 3670068;BA.debugLine="closeL.Text = \"X\"";
_closel.setText(BA.ObjectToCharSequence("X"));
RDebugUtils.currentLine=3670070;
 //BA.debugLineNum = 3670070;BA.debugLine="Dim saveBtn As Button";
_savebtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3670071;
 //BA.debugLineNum = 3670071;BA.debugLine="saveBtn.Initialize(\"saveBtn\")";
_savebtn.Initialize(mostCurrent.activityBA,"saveBtn");
RDebugUtils.currentLine=3670072;
 //BA.debugLineNum = 3670072;BA.debugLine="saveBtn.Text = \"Save Settings\"";
_savebtn.setText(BA.ObjectToCharSequence("Save Settings"));
RDebugUtils.currentLine=3670073;
 //BA.debugLineNum = 3670073;BA.debugLine="settingsPnl.AddView(saveBtn, 10dip, 130dip, 230di";
mostCurrent._settingspnl.AddView((android.view.View)(_savebtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (130)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (230)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=3670075;
 //BA.debugLineNum = 3670075;BA.debugLine="End Sub";
return "";
}
public static String  _shortbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "shortbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "shortbtn_click", null));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Private Sub shortBtn_Click";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="timerStop";
_timerstop();
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="secondsRemain = shortDef";
_secondsremain = _shortdef;
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="timerState = 1";
_timerstate = (int) (1);
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="End Sub";
return "";
}
public static String  _skipbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skipbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skipbtn_click", null));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Private Sub skipBtn_Click";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="If timerState = 0 Then";
if (_timerstate==0) { 
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="counter = counter + 1";
_counter = (int) (_counter+1);
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="If counter Mod 4 = 0 Then";
if (_counter%4==0) { 
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="secondsRemain = longDef";
_secondsremain = _longdef;
 }else {
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="secondsRemain = shortDef";
_secondsremain = _shortdef;
 };
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="timerState = 1";
_timerstate = (int) (1);
 }else 
{RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="Else If timerState = 1 Then";
if (_timerstate==1) { 
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="secondsRemain = pomoDef";
_secondsremain = _pomodef;
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="timerState = 0";
_timerstate = (int) (0);
 }}
;
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=4128785;
 //BA.debugLineNum = 4128785;BA.debugLine="timerCount.Enabled = False";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128786;
 //BA.debugLineNum = 4128786;BA.debugLine="playing = False";
_playing = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4128787;
 //BA.debugLineNum = 4128787;BA.debugLine="playBtn.Text = \"Start\"";
mostCurrent._playbtn.setText(BA.ObjectToCharSequence("Start"));
RDebugUtils.currentLine=4128788;
 //BA.debugLineNum = 4128788;BA.debugLine="End Sub";
return "";
}
public static String  _tmr_tick() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tmr_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tmr_tick", null));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub tmr_Tick";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="If secondsRemain > 0 Then";
if (_secondsremain>0) { 
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="secondsRemain = secondsRemain - 1";
_secondsremain = (int) (_secondsremain-1);
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="updateLbl";
_updatelbl();
 }else {
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="timerCount.Enabled = False";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="playBtn.Enabled = True";
mostCurrent._playbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="If timerState = 0 Then";
if (_timerstate==0) { 
RDebugUtils.currentLine=3538954;
 //BA.debugLineNum = 3538954;BA.debugLine="counter = counter + 1";
_counter = (int) (_counter+1);
RDebugUtils.currentLine=3538956;
 //BA.debugLineNum = 3538956;BA.debugLine="If counter Mod 4 = 0 Then";
if (_counter%4==0) { 
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="secondsRemain = longDef";
_secondsremain = _longdef;
 }else {
RDebugUtils.currentLine=3538959;
 //BA.debugLineNum = 3538959;BA.debugLine="secondsRemain = shortDef";
_secondsremain = _shortdef;
 };
RDebugUtils.currentLine=3538961;
 //BA.debugLineNum = 3538961;BA.debugLine="timerState = 1";
_timerstate = (int) (1);
 }else 
{RDebugUtils.currentLine=3538963;
 //BA.debugLineNum = 3538963;BA.debugLine="Else If timerState = 1 Then";
if (_timerstate==1) { 
RDebugUtils.currentLine=3538964;
 //BA.debugLineNum = 3538964;BA.debugLine="secondsRemain = pomoDef";
_secondsremain = _pomodef;
RDebugUtils.currentLine=3538965;
 //BA.debugLineNum = 3538965;BA.debugLine="timerState = 0";
_timerstate = (int) (0);
 }}
;
RDebugUtils.currentLine=3538968;
 //BA.debugLineNum = 3538968;BA.debugLine="updateLbl";
_updatelbl();
 };
RDebugUtils.currentLine=3538970;
 //BA.debugLineNum = 3538970;BA.debugLine="End Sub";
return "";
}
}