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
	public static final boolean includeTitle = false;
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
public static anywheresoftware.b4a.objects.Timer _timerclock = null;
public static b4a.example3.keyvaluestore _kvs = null;
public static boolean _format24h = false;
public anywheresoftware.b4a.objects.B4XViewWrapper _reglayout = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _darkmodelayout = null;
public static int _size = 0;
public anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hsv = null;
public b4a.example.b4xgifview _computergif = null;
public b4a.example.b4xgifview _dcomputergif = null;
public anywheresoftware.b4a.objects.ButtonWrapper _clockbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _clocklightbtn = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _infopnl = null;
public anywheresoftware.b4a.objects.LabelWrapper _infotitlelbl = null;
public anywheresoftware.b4a.objects.LabelWrapper _infodesclbl = null;
public anywheresoftware.b4a.objects.LabelWrapper _infopagelbl = null;
public static int _infopage = 0;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.corkactivity _corkactivity = null;
public static void  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.mainactivity parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
b4a.example.mainactivity parent;
boolean _firsttime;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="mainactivity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Activity.LoadLayout(\"Layouthsv\")";
parent.mostCurrent._activity.LoadLayout("Layouthsv",mostCurrent.activityBA);
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="If FirstTime Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_firsttime) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="kvs.Initialize(File.DirInternal, \"notes_data\")";
parent._kvs._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"notes_data");
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="timerClock.Initialize(\"timerClock\", 1000)";
parent._timerclock.Initialize(processBA,"timerClock",(long) (1000));
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="timerClock.Enabled = True";
parent._timerclock.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 4:
//C
this.state = 5;
;
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="hsv.Panel.Width = size";
parent.mostCurrent._hsv.getPanel().setWidth(parent._size);
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="hsv.Panel.Height = size";
parent.mostCurrent._hsv.getPanel().setHeight(parent._size);
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="regLayout = xui.CreatePanel(\"\")";
parent.mostCurrent._reglayout = parent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="darkModeLayout = xui.CreatePanel(\"\")";
parent.mostCurrent._darkmodelayout = parent._xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="hsv.Panel.AddView(regLayout, 0, 0, hsv.Panel.Widt";
parent.mostCurrent._hsv.getPanel().AddView((android.view.View)(parent.mostCurrent._reglayout.getObject()),(int) (0),(int) (0),parent.mostCurrent._hsv.getPanel().getWidth(),parent.mostCurrent._hsv.getPanel().getHeight());
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="hsv.Panel.AddView(darkModeLayout, 0, 0, hsv.Panel";
parent.mostCurrent._hsv.getPanel().AddView((android.view.View)(parent.mostCurrent._darkmodelayout.getObject()),(int) (0),(int) (0),parent.mostCurrent._hsv.getPanel().getWidth(),parent.mostCurrent._hsv.getPanel().getHeight());
RDebugUtils.currentLine=851987;
 //BA.debugLineNum = 851987;BA.debugLine="regLayout.BringToFront";
parent.mostCurrent._reglayout.BringToFront();
RDebugUtils.currentLine=851989;
 //BA.debugLineNum = 851989;BA.debugLine="Select Starter.themeNumber";
if (true) break;

case 5:
//select
this.state = 10;
switch (BA.switchObjectToInt(parent.mostCurrent._starter._themenumber /*int*/ ,(int) (0),(int) (1))) {
case 0: {
this.state = 7;
if (true) break;
}
case 1: {
this.state = 9;
if (true) break;
}
}
if (true) break;

case 7:
//C
this.state = 10;
RDebugUtils.currentLine=851991;
 //BA.debugLineNum = 851991;BA.debugLine="regLayout.LoadLayout(\"Layout\") 'light mode for";
parent.mostCurrent._reglayout.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="darkModeLayout.LoadLayout(\"Layout2\") 'dark mode";
parent.mostCurrent._darkmodelayout.LoadLayout("Layout2",mostCurrent.activityBA);
 if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=851994;
 //BA.debugLineNum = 851994;BA.debugLine="regLayout.LoadLayout(\"Layout\") 'light mode for";
parent.mostCurrent._reglayout.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=851995;
 //BA.debugLineNum = 851995;BA.debugLine="darkModeLayout.LoadLayout(\"Layout2\") 'dark mode";
parent.mostCurrent._darkmodelayout.LoadLayout("Layout2",mostCurrent.activityBA);
 if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=851998;
 //BA.debugLineNum = 851998;BA.debugLine="computerGif.SetGif(File.DirAssets, \"BtnComputer.G";
parent.mostCurrent._computergif._setgif /*String*/ (null,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"BtnComputer.GIF");
RDebugUtils.currentLine=851999;
 //BA.debugLineNum = 851999;BA.debugLine="dcomputerGif.SetGif(File.DirAssets, \"Dark BtnComp";
parent.mostCurrent._dcomputergif._setgif /*String*/ (null,anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Dark BtnComputer.GIF");
RDebugUtils.currentLine=852000;
 //BA.debugLineNum = 852000;BA.debugLine="darkModeLayout.Visible = False";
parent.mostCurrent._darkmodelayout.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=852002;
 //BA.debugLineNum = 852002;BA.debugLine="Sleep(50)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "mainactivity", "activity_create"),(int) (50));
this.state = 11;
return;
case 11:
//C
this.state = -1;
;
RDebugUtils.currentLine=852003;
 //BA.debugLineNum = 852003;BA.debugLine="hsv.ScrollPosition = Max(0, (hsv.Panel.Width - 10";
parent.mostCurrent._hsv.setScrollPosition((int) (anywheresoftware.b4a.keywords.Common.Max(0,(parent.mostCurrent._hsv.getPanel().getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA))/(double)2)));
RDebugUtils.currentLine=852005;
 //BA.debugLineNum = 852005;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="mainactivity";
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="If format24h Then";
if (_format24h) { 
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="DateTime.TimeFormat = \"HH:mm\" ' 24-Hour Format";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
 }else {
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="DateTime.TimeFormat = \"hh:mm a\" ' AM/PM Format";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("hh:mm a");
 };
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="End Sub";
return "";
}
public static String  _clockbtn_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clockbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clockbtn_click", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub clockBtn_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="StartActivity(clockActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._clockactivity.getObject()));
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public static String  _clockbtn_longclick() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clockbtn_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clockbtn_longclick", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub clockBtn_LongClick";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="showInfoPopup";
_showinfopopup();
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="If infoPnl <> Null Then";
if (mostCurrent._infopnl!= null) { 
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="infoPnl.Visible = True";
mostCurrent._infopnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="infoPnl.BringToFront";
mostCurrent._infopnl.BringToFront();
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="showInfoPage(0)";
_showinfopage((int) (0));
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="End Sub";
return "";
}
public static String  _showinfopopup() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showinfopopup", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showinfopopup", null));}
anywheresoftware.b4a.objects.ButtonWrapper _closebtn = null;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub showInfoPopup";
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="infoPnl = xui.CreatePanel(\"infoPnl\")";
mostCurrent._infopnl = _xui.CreatePanel(processBA,"infoPnl");
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="Activity.AddView(infoPnl, 75dip, 225dip, 300dip,";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._infopnl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (225)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="infoPnl.SetColorAndBorder(xui.Color_White, 2dip,";
mostCurrent._infopnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="Dim closeBtn As Button";
_closebtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="closeBtn.Initialize(\"infoPnlClose\")";
_closebtn.Initialize(mostCurrent.activityBA,"infoPnlClose");
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="closeBtn.Text = \"X\"";
_closebtn.setText(BA.ObjectToCharSequence("X"));
RDebugUtils.currentLine=1638410;
 //BA.debugLineNum = 1638410;BA.debugLine="closeBtn.TextSize = 8";
_closebtn.setTextSize((float) (8));
RDebugUtils.currentLine=1638411;
 //BA.debugLineNum = 1638411;BA.debugLine="infoPnl.AddView(closeBtn, 265dip, 8dip, 28dip, 28";
mostCurrent._infopnl.AddView((android.view.View)(_closebtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (265)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (28)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (28)));
RDebugUtils.currentLine=1638413;
 //BA.debugLineNum = 1638413;BA.debugLine="infoTitleLbl.Initialize(\"\")";
mostCurrent._infotitlelbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1638414;
 //BA.debugLineNum = 1638414;BA.debugLine="infoTitleLbl.TextSize = 16";
mostCurrent._infotitlelbl.setTextSize((float) (16));
RDebugUtils.currentLine=1638415;
 //BA.debugLineNum = 1638415;BA.debugLine="infoTitleLbl.Gravity = Gravity.CENTER_HORIZONTAL";
mostCurrent._infotitlelbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=1638416;
 //BA.debugLineNum = 1638416;BA.debugLine="infoPnl.AddView(infoTitleLbl, 10dip, 12dip, 248di";
mostCurrent._infopnl.AddView((android.view.View)(mostCurrent._infotitlelbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (248)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=1638418;
 //BA.debugLineNum = 1638418;BA.debugLine="infoDescLbl.Initialize(\"\")";
mostCurrent._infodesclbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1638419;
 //BA.debugLineNum = 1638419;BA.debugLine="infoDescLbl.TextSize = 13";
mostCurrent._infodesclbl.setTextSize((float) (13));
RDebugUtils.currentLine=1638420;
 //BA.debugLineNum = 1638420;BA.debugLine="infoDescLbl.Gravity = Gravity.TOP";
mostCurrent._infodesclbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=1638421;
 //BA.debugLineNum = 1638421;BA.debugLine="infoDescLbl.SingleLine = False";
mostCurrent._infodesclbl.setSingleLine(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1638422;
 //BA.debugLineNum = 1638422;BA.debugLine="infoPnl.AddView(infoDescLbl, 12dip, 52dip, 276dip";
mostCurrent._infopnl.AddView((android.view.View)(mostCurrent._infodesclbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (52)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (276)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)));
RDebugUtils.currentLine=1638424;
 //BA.debugLineNum = 1638424;BA.debugLine="infoPageLbl.Initialize(\"\")";
mostCurrent._infopagelbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1638425;
 //BA.debugLineNum = 1638425;BA.debugLine="infoPageLbl.Gravity = Gravity.CENTER_HORIZONTAL";
mostCurrent._infopagelbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=1638426;
 //BA.debugLineNum = 1638426;BA.debugLine="infoPageLbl.TextSize = 11";
mostCurrent._infopagelbl.setTextSize((float) (11));
RDebugUtils.currentLine=1638427;
 //BA.debugLineNum = 1638427;BA.debugLine="infoPnl.AddView(infoPageLbl, 95dip, 184dip, 110di";
mostCurrent._infopnl.AddView((android.view.View)(mostCurrent._infopagelbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (95)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (184)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (22)));
RDebugUtils.currentLine=1638430;
 //BA.debugLineNum = 1638430;BA.debugLine="showInfoPage(0)";
_showinfopage((int) (0));
RDebugUtils.currentLine=1638431;
 //BA.debugLineNum = 1638431;BA.debugLine="End Sub";
return "";
}
public static String  _showinfopage(int _page) throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showinfopage", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showinfopage", new Object[] {_page}));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub showInfoPage(page As Int)";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="infoPage = page";
_infopage = _page;
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Select page";
switch (_page) {
case 0: {
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="infoTitleLbl.Text = \"Calendar\"";
mostCurrent._infotitlelbl.setText(BA.ObjectToCharSequence("Calendar"));
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="infoDescLbl.Text = \"The calendar comes in three";
mostCurrent._infodesclbl.setText(BA.ObjectToCharSequence("The calendar comes in three views to match however you like to plan. The Schedule view lets you see all your upcoming days at a glance, with major events and to-do items laid out on a timeline. The Day view shows you the full timeline for a single day, where you can add events, tasks, or birthdays, and color-coded backgrounds make each type of entry easy to tell apart. The Month view presents the classic calendar layout, complete with a month and year spinner to jump around quickly, a sneak peek of events on each day's cell, and neighboring dates filling in the empty cells so the grid always looks complete."));
 break; }
case 1: {
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="infoTitleLbl.Text = \"Clock\"";
mostCurrent._infotitlelbl.setText(BA.ObjectToCharSequence("Clock"));
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="infoDescLbl.Text = \"The clock keeps you on time";
mostCurrent._infodesclbl.setText(BA.ObjectToCharSequence("The clock keeps you on time and on task all in one place. A format button lets you switch between clock displays to whatever you prefer. It also comes with a built-in Pomodoro timer to help you stay focused and productive, and if the default durations don't work for you, you can freely adjust them to fit your own rhythm."));
 break; }
case 2: {
RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="infoTitleLbl.Text = \"Corkboard\"";
mostCurrent._infotitlelbl.setText(BA.ObjectToCharSequence("Corkboard"));
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="infoDescLbl.Text = \"The corkboard gives you a c";
mostCurrent._infodesclbl.setText(BA.ObjectToCharSequence("The corkboard gives you a creative space to pin your thoughts and ideas. You can place sticky notes in a variety of colors to keep things visually organized and easy to tell apart. Images from your gallery can be attached right onto the board for extra context or inspiration. And when words and notes aren't enough, you can open up a drawable canvas with a selection of colored pens and sketch, doodle, or diagram anything you have in mind."));
 break; }
case 3: {
RDebugUtils.currentLine=1703949;
 //BA.debugLineNum = 1703949;BA.debugLine="infoTitleLbl.Text = \"Flashcards\"";
mostCurrent._infotitlelbl.setText(BA.ObjectToCharSequence("Flashcards"));
RDebugUtils.currentLine=1703950;
 //BA.debugLineNum = 1703950;BA.debugLine="infoDescLbl.Text = \"The flashcard feature organ";
mostCurrent._infodesclbl.setText(BA.ObjectToCharSequence("The flashcard feature organizes your cards into decks and subdecks, and you have the freedom to add, rename, or delete any of them — with a confirmation before anything gets deleted for good. Cards are automatically shuffled so every session feels fresh. A progress bar and percentage track how far you've made it through a deck, and when you're ready to dive back in, two buttons have you covered — restart the entire deck from scratch, or continue right where you left off."));
 break; }
case 4: {
RDebugUtils.currentLine=1703952;
 //BA.debugLineNum = 1703952;BA.debugLine="infoTitleLbl.Text = \"Music Player\"";
mostCurrent._infotitlelbl.setText(BA.ObjectToCharSequence("Music Player"));
RDebugUtils.currentLine=1703953;
 //BA.debugLineNum = 1703953;BA.debugLine="infoDescLbl.Text = \"The music player plays the";
mostCurrent._infodesclbl.setText(BA.ObjectToCharSequence("The music player plays the music on startup, meaning the app greets you with songs! Filled with chill, lo-fi tracks, you have the freedom to choose what track you want to play--either through the previous/next song buttons, or through the list of songs below where you can click on whatever chooses your fancy. There's a segment of the song that you want to listen to again or you want to zoom through a certain bit of a song? The seek bar presents itself to you where you can navigate within the music.  "));
 break; }
case 5: {
RDebugUtils.currentLine=1703955;
 //BA.debugLineNum = 1703955;BA.debugLine="infoTitleLbl.Text = \"Notepad\"";
mostCurrent._infotitlelbl.setText(BA.ObjectToCharSequence("Notepad"));
RDebugUtils.currentLine=1703956;
 //BA.debugLineNum = 1703956;BA.debugLine="infoDescLbl.Text = \"The notepad keeps all your";
mostCurrent._infodesclbl.setText(BA.ObjectToCharSequence("The notepad keeps all your notes in one tidy list that's easy to browse through. A search bar lets you quickly find any note by its title or tags, so nothing ever gets lost in the pile. Adding a new note is simple — just give it a title, attach some tags to keep things organized, and write away to your heart's content."));
 break; }
case 6: {
RDebugUtils.currentLine=1703958;
 //BA.debugLineNum = 1703958;BA.debugLine="infoTitleLbl.Text = \"To-do List\"";
mostCurrent._infotitlelbl.setText(BA.ObjectToCharSequence("To-do List"));
RDebugUtils.currentLine=1703959;
 //BA.debugLineNum = 1703959;BA.debugLine="infoDescLbl.Text = \"The to-do list enables you";
mostCurrent._infodesclbl.setText(BA.ObjectToCharSequence("The to-do list enables you to create lists with titles and, especially, tasks you want or are obligated to do. You are able to keep a lot of lists that you can easily navigate through the left side of your screen. The task section is a checklist of your tasks that you input, and once achieved, you can tick it off the list. The to-do list will also show you your progress in the list."));
 break; }
}
;
RDebugUtils.currentLine=1703961;
 //BA.debugLineNum = 1703961;BA.debugLine="End Sub";
return "";
}
public static String  _clocklightbtn_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clocklightbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clocklightbtn_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub  clockLightBtn_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="StartActivity(clockActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._clockactivity.getObject()));
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public static String  _clocklightbtn_longclick() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clocklightbtn_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clocklightbtn_longclick", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub clockLightBtn_LongClick";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="showInfoPopup";
_showinfopopup();
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="If infoPnl <> Null Then";
if (mostCurrent._infopnl!= null) { 
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="infoPnl.Visible = True";
mostCurrent._infopnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="infoPnl.BringToFront";
mostCurrent._infopnl.BringToFront();
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="showInfoPage(0)";
_showinfopage((int) (0));
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Starter.darkMode = False";
parent.mostCurrent._starter._darkmode /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="regLayout.Visible = True";
parent.mostCurrent._reglayout.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="regLayout.BringToFront";
parent.mostCurrent._reglayout.BringToFront();
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="regLayout.Alpha = 0";
parent.mostCurrent._reglayout.setAlpha((float) (0));
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="regLayout.SetAlphaAnimated(250, 1)";
parent.mostCurrent._reglayout.SetAlphaAnimated((int) (250),(float) (1));
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 0)";
parent.mostCurrent._darkmodelayout.SetAlphaAnimated((int) (250),(float) (0));
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="Sleep(250)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "mainactivity", "dlamp_click"),(int) (250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="darkModeLayout.Visible = False";
parent.mostCurrent._darkmodelayout.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _helpbtn_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "helpbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "helpbtn_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub helpBtn_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="StartActivity(helpActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._helpactivity.getObject()));
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="End Sub";
return "";
}
public static String  _infopnlclose_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "infopnlclose_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "infopnlclose_click", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Private Sub infoPnlClose_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="infoPnl.Visible = False";
mostCurrent._infopnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Starter.darkMode = True";
parent.mostCurrent._starter._darkmode /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="darkModeLayout.Visible = True";
parent.mostCurrent._darkmodelayout.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="darkModeLayout.BringToFront";
parent.mostCurrent._darkmodelayout.BringToFront();
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="darkModeLayout.Alpha = 0";
parent.mostCurrent._darkmodelayout.setAlpha((float) (0));
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="darkModeLayout.SetAlphaAnimated(250, 1)";
parent.mostCurrent._darkmodelayout.SetAlphaAnimated((int) (250),(float) (1));
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="regLayout.SetAlphaAnimated(250, 0)";
parent.mostCurrent._reglayout.SetAlphaAnimated((int) (250),(float) (0));
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="Sleep(250)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "mainactivity", "lamp_click"),(int) (250));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="regLayout.Visible = False";
parent.mostCurrent._reglayout.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _navbtn_click() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "navbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "navbtn_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub navBtn_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="StartActivity(navActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._navactivity.getObject()));
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public static String  _timerclock_tick() throws Exception{
RDebugUtils.currentModule="mainactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "timerclock_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "timerclock_tick", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub timerClock_Tick";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="clockBtn.Text = DateTime.Time(DateTime.Now)";
mostCurrent._clockbtn.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="clockLightBtn.Text = DateTime.Time(DateTime.Now)";
mostCurrent._clocklightbtn.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow())));
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="End Sub";
return "";
}
}