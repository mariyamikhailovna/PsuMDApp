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

public class cork extends Activity implements B4AActivity{
	public static cork mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.cork");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (cork).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.cork");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.cork", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (cork) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (cork) Resume **");
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
		return cork.class;
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
            BA.LogInfo("** Activity (cork) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (cork) Pause event (activity is not paused). **");
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
            cork mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (cork) Resume **");
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
public static float _lastx = 0f;
public static float _lasty = 0f;
public anywheresoftware.b4a.objects.PanelWrapper _boardpnl = null;
public anywheresoftware.b4a.objects.PanelWrapper _addpnl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _canvabtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _imgbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _stickybtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _stringbtn = null;
public anywheresoftware.b4a.objects.EditTextWrapper _stickytxt = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.clock _clock = null;
public b4a.example.note _note = null;
public b4a.example.editnote _editnote = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Activity.LoadLayout(\"corkboardLayout\")";
mostCurrent._activity.LoadLayout("corkboardLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="boardPnl.Width = Activity.Width";
mostCurrent._boardpnl.setWidth(mostCurrent._activity.getWidth());
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="boardPnl.Height = Activity.Height";
mostCurrent._boardpnl.setHeight(mostCurrent._activity.getHeight());
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="cork";
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="End Sub";
return "";
}
public static String  _addstickynote(String _text,int _x,int _y) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addstickynote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addstickynote", new Object[] {_text,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.PanelWrapper _draghandle = null;
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="p.Initialize(\"Sticky\")";
_p.Initialize(mostCurrent.activityBA,"Sticky");
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="p.Color = Colors.RGB(255, 192, 203)";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (192),(int) (203)));
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="Dim dragHandle As Panel";
_draghandle = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5373958;
 //BA.debugLineNum = 5373958;BA.debugLine="dragHandle.Initialize(\"Sticky\")";
_draghandle.Initialize(mostCurrent.activityBA,"Sticky");
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="dragHandle.Color = Colors.RGB(0, 0, 0)";
_draghandle.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="p.AddView(dragHandle, 0, 0, 100dip, 20dip)";
_p.AddView((android.view.View)(_draghandle.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=5373962;
 //BA.debugLineNum = 5373962;BA.debugLine="stickyTxt.Initialize(\"stickyTxt\")";
mostCurrent._stickytxt.Initialize(mostCurrent.activityBA,"stickyTxt");
RDebugUtils.currentLine=5373963;
 //BA.debugLineNum = 5373963;BA.debugLine="stickyTxt.Text = Text";
mostCurrent._stickytxt.setText(BA.ObjectToCharSequence(_text));
RDebugUtils.currentLine=5373964;
 //BA.debugLineNum = 5373964;BA.debugLine="stickyTxt.TextSize = 9";
mostCurrent._stickytxt.setTextSize((float) (9));
RDebugUtils.currentLine=5373965;
 //BA.debugLineNum = 5373965;BA.debugLine="stickyTxt.Background = Null";
mostCurrent._stickytxt.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=5373966;
 //BA.debugLineNum = 5373966;BA.debugLine="stickyTxt.Gravity = Gravity.TOP";
mostCurrent._stickytxt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=5373968;
 //BA.debugLineNum = 5373968;BA.debugLine="p.AddView(stickyTxt, 5dip, 15dip, 90dip, 70dip)";
_p.AddView((android.view.View)(mostCurrent._stickytxt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=5373970;
 //BA.debugLineNum = 5373970;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
mostCurrent._boardpnl.AddView((android.view.View)(_p.getObject()),_x,_y,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=5373972;
 //BA.debugLineNum = 5373972;BA.debugLine="Log(\"Note Added. Is it enabled? \" & p.Enabled)";
anywheresoftware.b4a.keywords.Common.LogImpl("05373972","Note Added. Is it enabled? "+BA.ObjectToString(_p.getEnabled()),0);
RDebugUtils.currentLine=5373973;
 //BA.debugLineNum = 5373973;BA.debugLine="End Sub";
return "";
}
public static String  _sticky_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sticky_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sticky_touch", new Object[] {_action,_x,_y}));}
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub Sticky_Touch (Action As Int, X As Float, Y As";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="Dim v As B4XView = Sender";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
_v = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="Select Action";
switch (_action) {
case 0: {
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="LastY = Y";
_lasty = _y;
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="v.BringToFront";
_v.BringToFront();
 break; }
case 2: {
RDebugUtils.currentLine=5439500;
 //BA.debugLineNum = 5439500;BA.debugLine="v.Left = v.Left + X - LastX";
_v.setLeft((int) (_v.getLeft()+_x-_lastx));
RDebugUtils.currentLine=5439501;
 //BA.debugLineNum = 5439501;BA.debugLine="v.Top = v.Top + Y - LastY";
_v.setTop((int) (_v.getTop()+_y-_lasty));
 break; }
}
;
RDebugUtils.currentLine=5439503;
 //BA.debugLineNum = 5439503;BA.debugLine="End Sub";
return "";
}
public static String  _stickybtn_click() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "stickybtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "stickybtn_click", null));}
int _randomx = 0;
int _randomy = 0;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Private Sub stickyBtn_Click";
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="Dim randomX As Int = Rnd(20dip, 150dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="Dim randomY As Int = Rnd(20dip, 150dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="AddStickyNote(\"\", randomX, randomY)";
_addstickynote("",_randomx,_randomy);
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="End Sub";
return "";
}
}