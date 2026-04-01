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
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
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
public anywheresoftware.b4a.objects.LabelWrapper _sessionlbl = null;
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
public static int _break = 0;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.todoactivity _todoactivity = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.card_module _card_module = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.editnote _editnote = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.themeactivity _themeactivity = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=18350080;
 //BA.debugLineNum = 18350080;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=18350081;
 //BA.debugLineNum = 18350081;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=18350082;
 //BA.debugLineNum = 18350082;BA.debugLine="Activity.LoadLayout(\"clocklayout\")";
mostCurrent._activity.LoadLayout("clocklayout",mostCurrent.activityBA);
 }else {
RDebugUtils.currentLine=18350084;
 //BA.debugLineNum = 18350084;BA.debugLine="Activity.LoadLayout(\"clocklayoutDark\")";
mostCurrent._activity.LoadLayout("clocklayoutDark",mostCurrent.activityBA);
 };
RDebugUtils.currentLine=18350087;
 //BA.debugLineNum = 18350087;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=18350088;
 //BA.debugLineNum = 18350088;BA.debugLine="timerCount.Initialize(\"tmr\", 1000)";
_timercount.Initialize(processBA,"tmr",(long) (1000));
 };
RDebugUtils.currentLine=18350091;
 //BA.debugLineNum = 18350091;BA.debugLine="timerCount.Enabled = False";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18350092;
 //BA.debugLineNum = 18350092;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=18350093;
 //BA.debugLineNum = 18350093;BA.debugLine="pomoCounter.Text = counter";
mostCurrent._pomocounter.setText(BA.ObjectToCharSequence(_counter));
RDebugUtils.currentLine=18350094;
 //BA.debugLineNum = 18350094;BA.debugLine="End Sub";
return "";
}
public static String  _updatelbl() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updatelbl", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "updatelbl", null));}
int _mins = 0;
int _secs = 0;
RDebugUtils.currentLine=18808832;
 //BA.debugLineNum = 18808832;BA.debugLine="Sub updateLbl";
RDebugUtils.currentLine=18808833;
 //BA.debugLineNum = 18808833;BA.debugLine="Dim mins As Int = secondsRemain / 60";
_mins = (int) (_secondsremain/(double)60);
RDebugUtils.currentLine=18808834;
 //BA.debugLineNum = 18808834;BA.debugLine="Dim secs As Int = secondsRemain Mod 60";
_secs = (int) (_secondsremain%60);
RDebugUtils.currentLine=18808835;
 //BA.debugLineNum = 18808835;BA.debugLine="pomotimerLbl.Text = $\"$02.0{mins}:$02.0{secs}\"$";
mostCurrent._pomotimerlbl.setText(BA.ObjectToCharSequence((""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("02.0",(Object)(_mins))+":"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("02.0",(Object)(_secs))+"")));
RDebugUtils.currentLine=18808836;
 //BA.debugLineNum = 18808836;BA.debugLine="pomoCounter.Text = counter";
mostCurrent._pomocounter.setText(BA.ObjectToCharSequence(_counter));
RDebugUtils.currentLine=18808838;
 //BA.debugLineNum = 18808838;BA.debugLine="If timerState = 0 Then";
if (_timerstate==0) { 
RDebugUtils.currentLine=18808839;
 //BA.debugLineNum = 18808839;BA.debugLine="sessionLbl.Text = \"Pomodoro\"";
mostCurrent._sessionlbl.setText(BA.ObjectToCharSequence("Pomodoro"));
 }else {
RDebugUtils.currentLine=18808841;
 //BA.debugLineNum = 18808841;BA.debugLine="If break = 1 Then";
if (_break==1) { 
RDebugUtils.currentLine=18808842;
 //BA.debugLineNum = 18808842;BA.debugLine="sessionLbl.Text = \"Long Break\"";
mostCurrent._sessionlbl.setText(BA.ObjectToCharSequence("Long Break"));
 }else {
RDebugUtils.currentLine=18808844;
 //BA.debugLineNum = 18808844;BA.debugLine="sessionLbl.Text = \"Short Break\"";
mostCurrent._sessionlbl.setText(BA.ObjectToCharSequence("Short Break"));
 };
 };
RDebugUtils.currentLine=18808847;
 //BA.debugLineNum = 18808847;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="clockactivity";
RDebugUtils.currentLine=18481152;
 //BA.debugLineNum = 18481152;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=18481154;
 //BA.debugLineNum = 18481154;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=18415616;
 //BA.debugLineNum = 18415616;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=18415618;
 //BA.debugLineNum = 18415618;BA.debugLine="End Sub";
return "";
}
public static String  _closel_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "closel_click", null));}
RDebugUtils.currentLine=19202048;
 //BA.debugLineNum = 19202048;BA.debugLine="Private Sub closeL_Click";
RDebugUtils.currentLine=19202049;
 //BA.debugLineNum = 19202049;BA.debugLine="settingsPnl.Visible = False";
mostCurrent._settingspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=19202050;
 //BA.debugLineNum = 19202050;BA.debugLine="End Sub";
return "";
}
public static String  _exitbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "exitbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "exitbtn_click", null));}
RDebugUtils.currentLine=18546688;
 //BA.debugLineNum = 18546688;BA.debugLine="Private Sub exitBtn_Click";
RDebugUtils.currentLine=18546689;
 //BA.debugLineNum = 18546689;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=18546690;
 //BA.debugLineNum = 18546690;BA.debugLine="End Sub";
return "";
}
public static String  _formatbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "formatbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "formatbtn_click", null));}
RDebugUtils.currentLine=18612224;
 //BA.debugLineNum = 18612224;BA.debugLine="Private Sub formatBtn_Click";
RDebugUtils.currentLine=18612226;
 //BA.debugLineNum = 18612226;BA.debugLine="MainActivity.format24h = Not(MainActivity.format2";
mostCurrent._mainactivity._format24h /*boolean*/  = anywheresoftware.b4a.keywords.Common.Not(mostCurrent._mainactivity._format24h /*boolean*/ );
RDebugUtils.currentLine=18612228;
 //BA.debugLineNum = 18612228;BA.debugLine="If MainActivity.format24h Then";
if (mostCurrent._mainactivity._format24h /*boolean*/ ) { 
RDebugUtils.currentLine=18612229;
 //BA.debugLineNum = 18612229;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
 }else {
RDebugUtils.currentLine=18612231;
 //BA.debugLineNum = 18612231;BA.debugLine="DateTime.TimeFormat = \"hh:mm a\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("hh:mm a");
 };
RDebugUtils.currentLine=18612233;
 //BA.debugLineNum = 18612233;BA.debugLine="CallSub(MainActivity, \"timerClock_Tick\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._mainactivity.getObject()),"timerClock_Tick");
RDebugUtils.currentLine=18612235;
 //BA.debugLineNum = 18612235;BA.debugLine="End Sub";
return "";
}
public static String  _longbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "longbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "longbtn_click", null));}
RDebugUtils.currentLine=19070976;
 //BA.debugLineNum = 19070976;BA.debugLine="Private Sub longBtn_Click";
RDebugUtils.currentLine=19070977;
 //BA.debugLineNum = 19070977;BA.debugLine="timerStop";
_timerstop();
RDebugUtils.currentLine=19070978;
 //BA.debugLineNum = 19070978;BA.debugLine="secondsRemain = longDef";
_secondsremain = _longdef;
RDebugUtils.currentLine=19070979;
 //BA.debugLineNum = 19070979;BA.debugLine="timerState = 1";
_timerstate = (int) (1);
RDebugUtils.currentLine=19070980;
 //BA.debugLineNum = 19070980;BA.debugLine="break = 1";
_break = (int) (1);
RDebugUtils.currentLine=19070981;
 //BA.debugLineNum = 19070981;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=19070982;
 //BA.debugLineNum = 19070982;BA.debugLine="End Sub";
return "";
}
public static String  _timerstop() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timerstop", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timerstop", null));}
RDebugUtils.currentLine=19398656;
 //BA.debugLineNum = 19398656;BA.debugLine="Private Sub timerStop";
RDebugUtils.currentLine=19398657;
 //BA.debugLineNum = 19398657;BA.debugLine="timerCount.Enabled = False";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=19398658;
 //BA.debugLineNum = 19398658;BA.debugLine="playing = False";
_playing = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=19398659;
 //BA.debugLineNum = 19398659;BA.debugLine="playBtn.Text = \"Start\"";
mostCurrent._playbtn.setText(BA.ObjectToCharSequence("Start"));
RDebugUtils.currentLine=19398660;
 //BA.debugLineNum = 19398660;BA.debugLine="End Sub";
return "";
}
public static String  _playbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "playbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "playbtn_click", null));}
RDebugUtils.currentLine=18677760;
 //BA.debugLineNum = 18677760;BA.debugLine="Private Sub playBtn_Click";
RDebugUtils.currentLine=18677761;
 //BA.debugLineNum = 18677761;BA.debugLine="If secondsRemain > 0 Then";
if (_secondsremain>0) { 
RDebugUtils.currentLine=18677762;
 //BA.debugLineNum = 18677762;BA.debugLine="timerCount.Enabled = True";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=18677764;
 //BA.debugLineNum = 18677764;BA.debugLine="If playing = True Then";
if (_playing==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=18677765;
 //BA.debugLineNum = 18677765;BA.debugLine="timerStop";
_timerstop();
 }else {
RDebugUtils.currentLine=18677767;
 //BA.debugLineNum = 18677767;BA.debugLine="timerCount.Enabled = True";
_timercount.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=18677768;
 //BA.debugLineNum = 18677768;BA.debugLine="playing = True";
_playing = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=18677769;
 //BA.debugLineNum = 18677769;BA.debugLine="playBtn.Text = \"Pause\"";
mostCurrent._playbtn.setText(BA.ObjectToCharSequence("Pause"));
 };
RDebugUtils.currentLine=18677772;
 //BA.debugLineNum = 18677772;BA.debugLine="End Sub";
return "";
}
public static String  _pomobtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pomobtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pomobtn_click", null));}
RDebugUtils.currentLine=18939904;
 //BA.debugLineNum = 18939904;BA.debugLine="Private Sub pomoBtn_Click";
RDebugUtils.currentLine=18939905;
 //BA.debugLineNum = 18939905;BA.debugLine="timerStop";
_timerstop();
RDebugUtils.currentLine=18939906;
 //BA.debugLineNum = 18939906;BA.debugLine="secondsRemain = pomoDef";
_secondsremain = _pomodef;
RDebugUtils.currentLine=18939907;
 //BA.debugLineNum = 18939907;BA.debugLine="timerState = 0";
_timerstate = (int) (0);
RDebugUtils.currentLine=18939908;
 //BA.debugLineNum = 18939908;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=18939909;
 //BA.debugLineNum = 18939909;BA.debugLine="End Sub";
return "";
}
public static String  _savebtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "savebtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "savebtn_click", null));}
RDebugUtils.currentLine=19267584;
 //BA.debugLineNum = 19267584;BA.debugLine="Private Sub saveBtn_Click";
RDebugUtils.currentLine=19267586;
 //BA.debugLineNum = 19267586;BA.debugLine="If IsNumber(pomoTxt.Text) Then pomoDef = pomoTxt.";
if (anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._pomotxt.getText())) { 
_pomodef = (int) ((double)(Double.parseDouble(mostCurrent._pomotxt.getText()))*60);};
RDebugUtils.currentLine=19267587;
 //BA.debugLineNum = 19267587;BA.debugLine="If IsNumber(shortTxt.Text) Then shortDef = shortT";
if (anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._shorttxt.getText())) { 
_shortdef = (int) ((double)(Double.parseDouble(mostCurrent._shorttxt.getText()))*60);};
RDebugUtils.currentLine=19267588;
 //BA.debugLineNum = 19267588;BA.debugLine="If IsNumber(longTxt.Text) Then longDef = longTxt.";
if (anywheresoftware.b4a.keywords.Common.IsNumber(mostCurrent._longtxt.getText())) { 
_longdef = (int) ((double)(Double.parseDouble(mostCurrent._longtxt.getText()))*60);};
RDebugUtils.currentLine=19267590;
 //BA.debugLineNum = 19267590;BA.debugLine="If timerState = 0 Then";
if (_timerstate==0) { 
RDebugUtils.currentLine=19267591;
 //BA.debugLineNum = 19267591;BA.debugLine="secondsRemain = pomoDef";
_secondsremain = _pomodef;
 }else {
RDebugUtils.currentLine=19267594;
 //BA.debugLineNum = 19267594;BA.debugLine="If break = 1 Then";
if (_break==1) { 
RDebugUtils.currentLine=19267595;
 //BA.debugLineNum = 19267595;BA.debugLine="secondsRemain = longDef";
_secondsremain = _longdef;
 }else {
RDebugUtils.currentLine=19267597;
 //BA.debugLineNum = 19267597;BA.debugLine="secondsRemain = shortDef";
_secondsremain = _shortdef;
 };
 };
RDebugUtils.currentLine=19267600;
 //BA.debugLineNum = 19267600;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=19267601;
 //BA.debugLineNum = 19267601;BA.debugLine="settingsPnl.Visible = False";
mostCurrent._settingspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=19267602;
 //BA.debugLineNum = 19267602;BA.debugLine="End Sub";
return "";
}
public static String  _settingsbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "settingsbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "settingsbtn_click", null));}
RDebugUtils.currentLine=19136512;
 //BA.debugLineNum = 19136512;BA.debugLine="Private Sub settingsBtn_Click";
RDebugUtils.currentLine=19136513;
 //BA.debugLineNum = 19136513;BA.debugLine="settingsWindow(250dip, 180dip)";
_settingswindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=19136514;
 //BA.debugLineNum = 19136514;BA.debugLine="settingsPnl.Visible = True";
mostCurrent._settingspnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=19136515;
 //BA.debugLineNum = 19136515;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=18874368;
 //BA.debugLineNum = 18874368;BA.debugLine="Private Sub settingsWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=18874369;
 //BA.debugLineNum = 18874369;BA.debugLine="settingsPnl = xui.CreatePanel(\"settingsPnl\")";
mostCurrent._settingspnl = _xui.CreatePanel(processBA,"settingsPnl");
RDebugUtils.currentLine=18874370;
 //BA.debugLineNum = 18874370;BA.debugLine="Activity.AddView(settingsPnl, centerLeft, centerT";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._settingspnl.getObject()),_centerleft,_centertop,_pw,_ph);
RDebugUtils.currentLine=18874371;
 //BA.debugLineNum = 18874371;BA.debugLine="settingsPnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._settingspnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=18874372;
 //BA.debugLineNum = 18874372;BA.debugLine="settingsPnl.SetColorAndBorder(xui.Color_White, 2d";
mostCurrent._settingspnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=18874373;
 //BA.debugLineNum = 18874373;BA.debugLine="settingsPnl.Enabled = False";
mostCurrent._settingspnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18874374;
 //BA.debugLineNum = 18874374;BA.debugLine="settingsPnl.Visible = False";
mostCurrent._settingspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=18874376;
 //BA.debugLineNum = 18874376;BA.debugLine="pomoTxt.Initialize(\"pomoTxt\")";
mostCurrent._pomotxt.Initialize(mostCurrent.activityBA,"pomoTxt");
RDebugUtils.currentLine=18874377;
 //BA.debugLineNum = 18874377;BA.debugLine="pomoTxt.Hint = \"Pomo\"";
mostCurrent._pomotxt.setHint("Pomo");
RDebugUtils.currentLine=18874378;
 //BA.debugLineNum = 18874378;BA.debugLine="pomoTxt.InputType = pomoTxt.INPUT_TYPE_NUMBERS";
mostCurrent._pomotxt.setInputType(mostCurrent._pomotxt.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=18874379;
 //BA.debugLineNum = 18874379;BA.debugLine="pomoTxt.Text = pomoDef / 60";
mostCurrent._pomotxt.setText(BA.ObjectToCharSequence(_pomodef/(double)60));
RDebugUtils.currentLine=18874380;
 //BA.debugLineNum = 18874380;BA.debugLine="pomoTxt.Gravity = Gravity.CENTER_HORIZONTAL";
mostCurrent._pomotxt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=18874381;
 //BA.debugLineNum = 18874381;BA.debugLine="settingsPnl.AddView(pomoTxt, 10dip, 40dip, 70dip,";
mostCurrent._settingspnl.AddView((android.view.View)(mostCurrent._pomotxt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=18874383;
 //BA.debugLineNum = 18874383;BA.debugLine="shortTxt.Initialize(\"shortTxt\")";
mostCurrent._shorttxt.Initialize(mostCurrent.activityBA,"shortTxt");
RDebugUtils.currentLine=18874384;
 //BA.debugLineNum = 18874384;BA.debugLine="shortTxt.Hint = \"Short\"";
mostCurrent._shorttxt.setHint("Short");
RDebugUtils.currentLine=18874385;
 //BA.debugLineNum = 18874385;BA.debugLine="shortTxt.InputType = shortTxt.INPUT_TYPE_NUMBERS";
mostCurrent._shorttxt.setInputType(mostCurrent._shorttxt.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=18874386;
 //BA.debugLineNum = 18874386;BA.debugLine="shortTxt.Text = shortDef / 60";
mostCurrent._shorttxt.setText(BA.ObjectToCharSequence(_shortdef/(double)60));
RDebugUtils.currentLine=18874387;
 //BA.debugLineNum = 18874387;BA.debugLine="shortTxt.Gravity = Gravity.CENTER_HORIZONTAL";
mostCurrent._shorttxt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=18874388;
 //BA.debugLineNum = 18874388;BA.debugLine="settingsPnl.AddView(shortTxt, 90dip, 40dip, 70dip";
mostCurrent._settingspnl.AddView((android.view.View)(mostCurrent._shorttxt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=18874390;
 //BA.debugLineNum = 18874390;BA.debugLine="longTxt.Initialize(\"longTxt\")";
mostCurrent._longtxt.Initialize(mostCurrent.activityBA,"longTxt");
RDebugUtils.currentLine=18874391;
 //BA.debugLineNum = 18874391;BA.debugLine="longTxt.Hint = \"Long\"";
mostCurrent._longtxt.setHint("Long");
RDebugUtils.currentLine=18874392;
 //BA.debugLineNum = 18874392;BA.debugLine="longTxt.InputType = longTxt.INPUT_TYPE_NUMBERS";
mostCurrent._longtxt.setInputType(mostCurrent._longtxt.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=18874393;
 //BA.debugLineNum = 18874393;BA.debugLine="longTxt.Text = longDef / 60";
mostCurrent._longtxt.setText(BA.ObjectToCharSequence(_longdef/(double)60));
RDebugUtils.currentLine=18874394;
 //BA.debugLineNum = 18874394;BA.debugLine="longTxt.Gravity = Gravity.CENTER_HORIZONTAL";
mostCurrent._longtxt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=18874395;
 //BA.debugLineNum = 18874395;BA.debugLine="settingsPnl.AddView(longTxt, 170dip, 40dip, 70dip";
mostCurrent._settingspnl.AddView((android.view.View)(mostCurrent._longtxt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (170)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=18874397;
 //BA.debugLineNum = 18874397;BA.debugLine="Dim lblP, lblS, lblL As Label";
_lblp = new anywheresoftware.b4a.objects.LabelWrapper();
_lbls = new anywheresoftware.b4a.objects.LabelWrapper();
_lbll = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18874399;
 //BA.debugLineNum = 18874399;BA.debugLine="lblP.Initialize(\"\")";
_lblp.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=18874400;
 //BA.debugLineNum = 18874400;BA.debugLine="lblP.Text = \"Pomo\"";
_lblp.setText(BA.ObjectToCharSequence("Pomo"));
RDebugUtils.currentLine=18874401;
 //BA.debugLineNum = 18874401;BA.debugLine="lblP.TextSize = 12";
_lblp.setTextSize((float) (12));
RDebugUtils.currentLine=18874402;
 //BA.debugLineNum = 18874402;BA.debugLine="lblP.Gravity = Gravity.CENTER_HORIZONTAL";
_lblp.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=18874403;
 //BA.debugLineNum = 18874403;BA.debugLine="settingsPnl.AddView(lblP, 10dip, 80dip, 70dip, 20";
mostCurrent._settingspnl.AddView((android.view.View)(_lblp.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=18874405;
 //BA.debugLineNum = 18874405;BA.debugLine="lblS.Initialize(\"\")";
_lbls.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=18874406;
 //BA.debugLineNum = 18874406;BA.debugLine="lblS.Text = \"Short\"";
_lbls.setText(BA.ObjectToCharSequence("Short"));
RDebugUtils.currentLine=18874407;
 //BA.debugLineNum = 18874407;BA.debugLine="lblS.TextSize = 12";
_lbls.setTextSize((float) (12));
RDebugUtils.currentLine=18874408;
 //BA.debugLineNum = 18874408;BA.debugLine="lblS.Gravity = Gravity.CENTER_HORIZONTAL";
_lbls.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=18874409;
 //BA.debugLineNum = 18874409;BA.debugLine="settingsPnl.AddView(lblS, 90dip, 80dip, 70dip, 20";
mostCurrent._settingspnl.AddView((android.view.View)(_lbls.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=18874411;
 //BA.debugLineNum = 18874411;BA.debugLine="lblL.Initialize(\"\")";
_lbll.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=18874412;
 //BA.debugLineNum = 18874412;BA.debugLine="lblL.Text = \"Long\"";
_lbll.setText(BA.ObjectToCharSequence("Long"));
RDebugUtils.currentLine=18874413;
 //BA.debugLineNum = 18874413;BA.debugLine="lblL.TextSize = 12";
_lbll.setTextSize((float) (12));
RDebugUtils.currentLine=18874414;
 //BA.debugLineNum = 18874414;BA.debugLine="lblL.Gravity = Gravity.CENTER_HORIZONTAL";
_lbll.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=18874415;
 //BA.debugLineNum = 18874415;BA.debugLine="settingsPnl.AddView(lblL, 170dip, 80dip, 70dip, 2";
mostCurrent._settingspnl.AddView((android.view.View)(_lbll.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (170)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=18874417;
 //BA.debugLineNum = 18874417;BA.debugLine="Dim closeL As Label";
_closel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=18874418;
 //BA.debugLineNum = 18874418;BA.debugLine="closeL.Initialize(\"closeL\")";
_closel.Initialize(mostCurrent.activityBA,"closeL");
RDebugUtils.currentLine=18874419;
 //BA.debugLineNum = 18874419;BA.debugLine="settingsPnl.AddView(closeL, 10dip, 10dip, 20dip,";
mostCurrent._settingspnl.AddView((android.view.View)(_closel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=18874420;
 //BA.debugLineNum = 18874420;BA.debugLine="closeL.Text = \"X\"";
_closel.setText(BA.ObjectToCharSequence("X"));
RDebugUtils.currentLine=18874422;
 //BA.debugLineNum = 18874422;BA.debugLine="Dim saveBtn As Button";
_savebtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=18874423;
 //BA.debugLineNum = 18874423;BA.debugLine="saveBtn.Initialize(\"saveBtn\")";
_savebtn.Initialize(mostCurrent.activityBA,"saveBtn");
RDebugUtils.currentLine=18874424;
 //BA.debugLineNum = 18874424;BA.debugLine="saveBtn.Text = \"Save Settings\"";
_savebtn.setText(BA.ObjectToCharSequence("Save Settings"));
RDebugUtils.currentLine=18874425;
 //BA.debugLineNum = 18874425;BA.debugLine="settingsPnl.AddView(saveBtn, 10dip, 130dip, 230di";
mostCurrent._settingspnl.AddView((android.view.View)(_savebtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (130)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (230)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=18874427;
 //BA.debugLineNum = 18874427;BA.debugLine="End Sub";
return "";
}
public static String  _shortbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "shortbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "shortbtn_click", null));}
RDebugUtils.currentLine=19005440;
 //BA.debugLineNum = 19005440;BA.debugLine="Private Sub shortBtn_Click";
RDebugUtils.currentLine=19005441;
 //BA.debugLineNum = 19005441;BA.debugLine="timerStop";
_timerstop();
RDebugUtils.currentLine=19005442;
 //BA.debugLineNum = 19005442;BA.debugLine="secondsRemain = shortDef";
_secondsremain = _shortdef;
RDebugUtils.currentLine=19005443;
 //BA.debugLineNum = 19005443;BA.debugLine="timerState = 1";
_timerstate = (int) (1);
RDebugUtils.currentLine=19005444;
 //BA.debugLineNum = 19005444;BA.debugLine="break = 0";
_break = (int) (0);
RDebugUtils.currentLine=19005445;
 //BA.debugLineNum = 19005445;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=19005446;
 //BA.debugLineNum = 19005446;BA.debugLine="End Sub";
return "";
}
public static String  _skipbtn_click() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "skipbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "skipbtn_click", null));}
RDebugUtils.currentLine=19333120;
 //BA.debugLineNum = 19333120;BA.debugLine="Private Sub skipBtn_Click";
RDebugUtils.currentLine=19333121;
 //BA.debugLineNum = 19333121;BA.debugLine="If timerState = 0 Then";
if (_timerstate==0) { 
RDebugUtils.currentLine=19333122;
 //BA.debugLineNum = 19333122;BA.debugLine="counter = counter + 1";
_counter = (int) (_counter+1);
RDebugUtils.currentLine=19333124;
 //BA.debugLineNum = 19333124;BA.debugLine="If counter Mod 4 = 0 Then";
if (_counter%4==0) { 
RDebugUtils.currentLine=19333125;
 //BA.debugLineNum = 19333125;BA.debugLine="secondsRemain = longDef";
_secondsremain = _longdef;
RDebugUtils.currentLine=19333126;
 //BA.debugLineNum = 19333126;BA.debugLine="break = 1";
_break = (int) (1);
 }else {
RDebugUtils.currentLine=19333128;
 //BA.debugLineNum = 19333128;BA.debugLine="secondsRemain = shortDef";
_secondsremain = _shortdef;
RDebugUtils.currentLine=19333129;
 //BA.debugLineNum = 19333129;BA.debugLine="break = 0";
_break = (int) (0);
 };
RDebugUtils.currentLine=19333131;
 //BA.debugLineNum = 19333131;BA.debugLine="timerState = 1";
_timerstate = (int) (1);
 }else 
{RDebugUtils.currentLine=19333133;
 //BA.debugLineNum = 19333133;BA.debugLine="Else If timerState = 1 Then";
if (_timerstate==1) { 
RDebugUtils.currentLine=19333134;
 //BA.debugLineNum = 19333134;BA.debugLine="secondsRemain = pomoDef";
_secondsremain = _pomodef;
RDebugUtils.currentLine=19333135;
 //BA.debugLineNum = 19333135;BA.debugLine="timerState = 0";
_timerstate = (int) (0);
 }}
;
RDebugUtils.currentLine=19333138;
 //BA.debugLineNum = 19333138;BA.debugLine="updateLbl";
_updatelbl();
RDebugUtils.currentLine=19333139;
 //BA.debugLineNum = 19333139;BA.debugLine="timerStop";
_timerstop();
RDebugUtils.currentLine=19333140;
 //BA.debugLineNum = 19333140;BA.debugLine="End Sub";
return "";
}
public static String  _tmr_tick() throws Exception{
RDebugUtils.currentModule="clockactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tmr_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tmr_tick", null));}
RDebugUtils.currentLine=18743296;
 //BA.debugLineNum = 18743296;BA.debugLine="Sub tmr_Tick";
RDebugUtils.currentLine=18743297;
 //BA.debugLineNum = 18743297;BA.debugLine="If secondsRemain > 0 Then";
if (_secondsremain>0) { 
RDebugUtils.currentLine=18743298;
 //BA.debugLineNum = 18743298;BA.debugLine="secondsRemain = secondsRemain - 1";
_secondsremain = (int) (_secondsremain-1);
RDebugUtils.currentLine=18743299;
 //BA.debugLineNum = 18743299;BA.debugLine="updateLbl";
_updatelbl();
 }else {
RDebugUtils.currentLine=18743301;
 //BA.debugLineNum = 18743301;BA.debugLine="timerStop";
_timerstop();
RDebugUtils.currentLine=18743303;
 //BA.debugLineNum = 18743303;BA.debugLine="If timerState = 0 Then";
if (_timerstate==0) { 
RDebugUtils.currentLine=18743304;
 //BA.debugLineNum = 18743304;BA.debugLine="counter = counter + 1";
_counter = (int) (_counter+1);
RDebugUtils.currentLine=18743306;
 //BA.debugLineNum = 18743306;BA.debugLine="If counter Mod 4 = 0 Then";
if (_counter%4==0) { 
RDebugUtils.currentLine=18743307;
 //BA.debugLineNum = 18743307;BA.debugLine="secondsRemain = longDef";
_secondsremain = _longdef;
RDebugUtils.currentLine=18743308;
 //BA.debugLineNum = 18743308;BA.debugLine="break = 1";
_break = (int) (1);
 }else {
RDebugUtils.currentLine=18743310;
 //BA.debugLineNum = 18743310;BA.debugLine="secondsRemain = shortDef";
_secondsremain = _shortdef;
RDebugUtils.currentLine=18743311;
 //BA.debugLineNum = 18743311;BA.debugLine="break = 0";
_break = (int) (0);
 };
RDebugUtils.currentLine=18743313;
 //BA.debugLineNum = 18743313;BA.debugLine="timerState = 1";
_timerstate = (int) (1);
 }else 
{RDebugUtils.currentLine=18743315;
 //BA.debugLineNum = 18743315;BA.debugLine="Else If timerState = 1 Then";
if (_timerstate==1) { 
RDebugUtils.currentLine=18743316;
 //BA.debugLineNum = 18743316;BA.debugLine="secondsRemain = pomoDef";
_secondsremain = _pomodef;
RDebugUtils.currentLine=18743317;
 //BA.debugLineNum = 18743317;BA.debugLine="timerState = 0";
_timerstate = (int) (0);
 }}
;
RDebugUtils.currentLine=18743320;
 //BA.debugLineNum = 18743320;BA.debugLine="updateLbl";
_updatelbl();
 };
RDebugUtils.currentLine=18743322;
 //BA.debugLineNum = 18743322;BA.debugLine="End Sub";
return "";
}
}