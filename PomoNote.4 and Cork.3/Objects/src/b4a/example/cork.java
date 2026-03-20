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
public static anywheresoftware.b4a.phone.Phone.ContentChooser _imgpicker = null;
public anywheresoftware.b4a.objects.PanelWrapper _boardpnl = null;
public anywheresoftware.b4a.objects.PanelWrapper _addpnl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _canvabtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _imgbtn = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _stickybtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _stringbtn = null;
public anywheresoftware.b4a.objects.EditTextWrapper _stickytxt = null;
public static float _lastx = 0f;
public static float _lasty = 0f;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.clock _clock = null;
public b4a.example.note _note = null;
public b4a.example.editnote _editnote = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Activity.LoadLayout(\"corkboardLayout\")";
mostCurrent._activity.LoadLayout("corkboardLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="imgPicker.Initialize(\"CC\")";
_imgpicker.Initialize("CC");
 };
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="cork";
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="End Sub";
return "";
}
public static String  _addcanvas(int _x,int _y,int _width,int _height) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addcanvas", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addcanvas", new Object[] {_x,_y,_width,_height}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub AddCanvas(x As Int, y As Int, Width As Int, He";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="p.Initialize(\"CanvasPanel\")";
_p.Initialize(mostCurrent.activityBA,"CanvasPanel");
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="p.Color = Colors.White";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="boardPnl.AddView(p, x, y, Width, Height)";
mostCurrent._boardpnl.AddView((android.view.View)(_p.getObject()),_x,_y,_width,_height);
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="cvs.Initialize(p)";
_cvs.Initialize((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())));
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="cvs.DrawRect(cvs.TargetRect, Colors.LightGray, Fa";
_cvs.DrawRect(_cvs.getTargetRect(),anywheresoftware.b4a.keywords.Common.Colors.LightGray,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
RDebugUtils.currentLine=3735563;
 //BA.debugLineNum = 3735563;BA.debugLine="p.Tag = cvs";
_p.setTag((Object)(_cvs));
RDebugUtils.currentLine=3735564;
 //BA.debugLineNum = 3735564;BA.debugLine="End Sub";
return "";
}
public static String  _addstickynote(String _text,int _x,int _y) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addstickynote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addstickynote", new Object[] {_text,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="p.Initialize(\"Generic\")";
_p.Initialize(mostCurrent.activityBA,"Generic");
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="p.Color = Colors.RGB(255, 192, 203)";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (192),(int) (203)));
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="stickyTxt.Initialize(\"stickyTxt\")";
mostCurrent._stickytxt.Initialize(mostCurrent.activityBA,"stickyTxt");
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="stickyTxt.Text = Text";
mostCurrent._stickytxt.setText(BA.ObjectToCharSequence(_text));
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="stickyTxt.TextSize = 9";
mostCurrent._stickytxt.setTextSize((float) (9));
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="stickyTxt.Background = Null";
mostCurrent._stickytxt.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="stickyTxt.TextColor = Colors.Black";
mostCurrent._stickytxt.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="stickyTxt.Gravity = Gravity.TOP";
mostCurrent._stickytxt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="p.AddView(stickyTxt, 5dip, 15dip, 90dip, 70dip)";
_p.AddView((android.view.View)(mostCurrent._stickytxt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=3670030;
 //BA.debugLineNum = 3670030;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
mostCurrent._boardpnl.AddView((android.view.View)(_p.getObject()),_x,_y,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=3670032;
 //BA.debugLineNum = 3670032;BA.debugLine="End Sub";
return "";
}
public static String  _canvabtn_click() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvabtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvabtn_click", null));}
int _randomx = 0;
int _randomy = 0;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub canvaBtn_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Dim randomX As Int = Rnd(10dip, 150dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)));
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Dim randomY As Int = Rnd(100dip, 300dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="AddCanvas(randomX, randomY, 200dip, 200dip)";
_addcanvas(_randomx,_randomy,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="End Sub";
return "";
}
public static String  _canvaspanel_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvaspanel_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvaspanel_touch", new Object[] {_action,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub CanvasPanel_Touch (Action As Int, X As Float,";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="Dim p As Panel = Sender";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="Dim cvs As B4XCanvas = p.Tag";
_cvs = (anywheresoftware.b4a.objects.B4XCanvas)(_p.getTag());
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN,mostCurrent._activity.ACTION_MOVE)) {
case 0: {
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
case 1: {
RDebugUtils.currentLine=3866634;
 //BA.debugLineNum = 3866634;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, Colors.Black,";
_cvs.DrawLine(_lastx,_lasty,_x,_y,anywheresoftware.b4a.keywords.Common.Colors.Black,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3))));
RDebugUtils.currentLine=3866635;
 //BA.debugLineNum = 3866635;BA.debugLine="cvs.Invalidate ' This refresh is required to sh";
_cvs.Invalidate();
RDebugUtils.currentLine=3866636;
 //BA.debugLineNum = 3866636;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=3866637;
 //BA.debugLineNum = 3866637;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
}
;
RDebugUtils.currentLine=3866639;
 //BA.debugLineNum = 3866639;BA.debugLine="End Sub";
return "";
}
public static String  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cc_result", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cc_result", new Object[] {_success,_dir,_filename}));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="imgView.Bitmap = LoadBitmapResize(Dir, FileName,";
mostCurrent._imgview.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapResize(_dir,_filename,mostCurrent._imgview.getWidth(),mostCurrent._imgview.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="ToastMessageShow(\"No image selected\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No image selected"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="End Sub";
return "";
}
public static String  _generic_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "generic_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "generic_touch", new Object[] {_action,_x,_y}));}
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
float _deltax = 0f;
float _deltay = 0f;
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub Generic_Touch (Action As Int, X As Float, Y As";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Dim v As View = Sender";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
_v = (anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN,mostCurrent._activity.ACTION_MOVE)) {
case 0: {
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
case 1: {
RDebugUtils.currentLine=5898251;
 //BA.debugLineNum = 5898251;BA.debugLine="Dim deltaX As Float = X - LastX";
_deltax = (float) (_x-_lastx);
RDebugUtils.currentLine=5898252;
 //BA.debugLineNum = 5898252;BA.debugLine="Dim deltaY As Float = Y - LastY";
_deltay = (float) (_y-_lasty);
RDebugUtils.currentLine=5898255;
 //BA.debugLineNum = 5898255;BA.debugLine="v.Left = v.Left + deltaX";
_v.setLeft((int) (_v.getLeft()+_deltax));
RDebugUtils.currentLine=5898256;
 //BA.debugLineNum = 5898256;BA.debugLine="v.Top = v.Top + deltaY";
_v.setTop((int) (_v.getTop()+_deltay));
RDebugUtils.currentLine=5898260;
 //BA.debugLineNum = 5898260;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=5898261;
 //BA.debugLineNum = 5898261;BA.debugLine="LastY = Y";
_lasty = _y;
RDebugUtils.currentLine=5898262;
 //BA.debugLineNum = 5898262;BA.debugLine="v.BringToFront";
_v.BringToFront();
 break; }
}
;
RDebugUtils.currentLine=5898264;
 //BA.debugLineNum = 5898264;BA.debugLine="End Sub";
return "";
}
public static String  _imgbtn_click() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgbtn_click", null));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Private Sub imgBtn_Click";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="imgPicker.Show(\"image/*\", \"Select a Photo\")";
_imgpicker.Show(processBA,"image/*","Select a Photo");
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="imgPick";
_imgpick();
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="End Sub";
return "";
}
public static String  _imgpick() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgpick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgpick", null));}
int _randomx = 0;
int _randomy = 0;
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub imgPick";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="imgView.Initialize(\"Generic\")";
mostCurrent._imgview.Initialize(mostCurrent.activityBA,"Generic");
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="Activity.AddView(imgView, randomX, randomY, 100di";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._imgview.getObject()),_randomx,_randomy,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="End Sub";
return "";
}
public static String  _stickybtn_click() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "stickybtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "stickybtn_click", null));}
int _randomx = 0;
int _randomy = 0;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Private Sub stickyBtn_Click";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="AddStickyNote(\"\", randomX, randomY)";
_addstickynote("",_randomx,_randomy);
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="End Sub";
return "";
}
}