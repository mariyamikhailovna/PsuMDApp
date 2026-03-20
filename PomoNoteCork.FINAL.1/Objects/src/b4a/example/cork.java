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
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.PanelWrapper _boardpnl = null;
public anywheresoftware.b4a.objects.PanelWrapper _addpnl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _canvabtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _imgbtn = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _stickybtn = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _notepnl = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _canvaspnl = null;
public static float _lastx = 0f;
public static float _lasty = 0f;
public b4a.example.dragdropview _dragmanager = null;
public anywheresoftware.b4a.objects.LabelWrapper _place1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place8 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place9 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place10 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _place12 = null;
public static int _r = 0;
public static int _g = 0;
public static int _b = 0;
public static int _r2 = 0;
public static int _g2 = 0;
public static int _b2 = 0;
public anywheresoftware.b4a.objects.SpinnerWrapper _penspnr = null;
public static int _width = 0;
public static int _height = 0;
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
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="penSpnr.AddAll(Array As String(\"Red\", \"Blue\", \"Gr";
mostCurrent._penspnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Red","Blue","Green","Black","Yellow","Eraser"}));
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="imgPicker.Initialize(\"CC\")";
_imgpicker.Initialize("CC");
 };
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="penSpnr.Visible = False";
mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="Width = 100dip  ' Default starting width";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="Height = 100dip ' Default starting height";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="End Sub";
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
public static void  _addcanvas(int _x,int _y) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addcanvas", false))
	 {Debug.delegate(mostCurrent.activityBA, "addcanvas", new Object[] {_x,_y}); return;}
ResumableSub_AddCanvas rsub = new ResumableSub_AddCanvas(null,_x,_y);
rsub.resume(processBA, null);
}
public static class ResumableSub_AddCanvas extends BA.ResumableSub {
public ResumableSub_AddCanvas(b4a.example.cork parent,int _x,int _y) {
this.parent = parent;
this._x = _x;
this._y = _y;
}
b4a.example.cork parent;
int _x;
int _y;
anywheresoftware.b4a.objects.PanelWrapper _f = null;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
b4a.example.dragdropview _dd = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="cork";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Dim f As Panel";
_f = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="f.Initialize(\"CanvasFrame\")";
_f.Initialize(mostCurrent.activityBA,"CanvasFrame");
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="f.Color = Colors.Gray";
_f.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="boardPnl.AddView(f, x, y, Width + 20dip, Height +";
parent.mostCurrent._boardpnl.AddView((android.view.View)(_f.getObject()),_x,_y,(int) (parent._width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (parent._height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))));
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="p.Initialize(\"CanvasPanel\")";
_p.Initialize(mostCurrent.activityBA,"CanvasPanel");
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="p.Color = Colors.White";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3932169;
 //BA.debugLineNum = 3932169;BA.debugLine="f.AddView(p, 10dip, 20dip, Width, Height)";
_f.AddView((android.view.View)(_p.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),parent._width,parent._height);
RDebugUtils.currentLine=3932171;
 //BA.debugLineNum = 3932171;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "cork", "addcanvas"),(int) (0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=3932173;
 //BA.debugLineNum = 3932173;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=3932174;
 //BA.debugLineNum = 3932174;BA.debugLine="cvs.Initialize(p)";
_cvs.Initialize((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())));
RDebugUtils.currentLine=3932175;
 //BA.debugLineNum = 3932175;BA.debugLine="cvs.DrawRect(cvs.TargetRect, Colors.LightGray, Fa";
_cvs.DrawRect(_cvs.getTargetRect(),anywheresoftware.b4a.keywords.Common.Colors.LightGray,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=3932176;
 //BA.debugLineNum = 3932176;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
RDebugUtils.currentLine=3932177;
 //BA.debugLineNum = 3932177;BA.debugLine="p.Tag = cvs";
_p.setTag((Object)(_cvs));
RDebugUtils.currentLine=3932179;
 //BA.debugLineNum = 3932179;BA.debugLine="Dim dd As DragDropView";
_dd = new b4a.example.dragdropview();
RDebugUtils.currentLine=3932180;
 //BA.debugLineNum = 3932180;BA.debugLine="dd.Initialize(Me, \"CanvasDrag\")";
_dd._initialize(processBA,cork.getObject(),"CanvasDrag");
RDebugUtils.currentLine=3932181;
 //BA.debugLineNum = 3932181;BA.debugLine="dd.AddDragView(f, False)";
_dd._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_f.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3932182;
 //BA.debugLineNum = 3932182;BA.debugLine="dd.AddPlaceView(place1).AddPlaceView(place2).AddP";
_dd._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place12.getObject())));
RDebugUtils.currentLine=3932183;
 //BA.debugLineNum = 3932183;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _addcbtn_click() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addcbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addcbtn_click", null));}
int _randomx = 0;
int _randomy = 0;
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Private Sub addcBtn_Click";
RDebugUtils.currentLine=9306113;
 //BA.debugLineNum = 9306113;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=9306114;
 //BA.debugLineNum = 9306114;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=9306115;
 //BA.debugLineNum = 9306115;BA.debugLine="AddCanvas(randomX, randomY)";
_addcanvas(_randomx,_randomy);
RDebugUtils.currentLine=9306116;
 //BA.debugLineNum = 9306116;BA.debugLine="canvasPnl.Visible = False";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9306117;
 //BA.debugLineNum = 9306117;BA.debugLine="End Sub";
return "";
}
public static String  _addnbtn_click() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addnbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addnbtn_click", null));}
int _randomx = 0;
int _randomy = 0;
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Private Sub addnBtn_Click";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=9240578;
 //BA.debugLineNum = 9240578;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=9240579;
 //BA.debugLineNum = 9240579;BA.debugLine="AddStickyNote(\"\", randomX, randomY)";
_addstickynote("",_randomx,_randomy);
RDebugUtils.currentLine=9240580;
 //BA.debugLineNum = 9240580;BA.debugLine="notePnl.Visible = False";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9240581;
 //BA.debugLineNum = 9240581;BA.debugLine="R = 255";
_r = (int) (255);
RDebugUtils.currentLine=9240582;
 //BA.debugLineNum = 9240582;BA.debugLine="G = 0";
_g = (int) (0);
RDebugUtils.currentLine=9240583;
 //BA.debugLineNum = 9240583;BA.debugLine="B = 0";
_b = (int) (0);
RDebugUtils.currentLine=9240584;
 //BA.debugLineNum = 9240584;BA.debugLine="End Sub";
return "";
}
public static String  _addstickynote(String _text,int _x,int _y) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addstickynote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addstickynote", new Object[] {_text,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.EditTextWrapper _txt = null;
b4a.example.dragdropview _dd = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="p.Initialize(\"NotePanel\")";
_p.Initialize(mostCurrent.activityBA,"NotePanel");
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="p.Color = Colors.RGB(R, G, B)";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB(_r,_g,_b));
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="Dim txt As EditText";
_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="txt.Initialize(\"\")";
_txt.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="txt.Text = Text";
_txt.setText(BA.ObjectToCharSequence(_text));
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="txt.TextSize = 12";
_txt.setTextSize((float) (12));
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="txt.Background = Null";
_txt.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="txt.TextColor = Colors.Black";
_txt.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=3735563;
 //BA.debugLineNum = 3735563;BA.debugLine="txt.Gravity = Gravity.TOP";
_txt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=3735565;
 //BA.debugLineNum = 3735565;BA.debugLine="p.AddView(txt, 5dip, 15dip, 90dip, 70dip)";
_p.AddView((android.view.View)(_txt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=3735567;
 //BA.debugLineNum = 3735567;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
mostCurrent._boardpnl.AddView((android.view.View)(_p.getObject()),_x,_y,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=3735569;
 //BA.debugLineNum = 3735569;BA.debugLine="Dim dd As DragDropView";
_dd = new b4a.example.dragdropview();
RDebugUtils.currentLine=3735570;
 //BA.debugLineNum = 3735570;BA.debugLine="dd.Initialize(Me, \"NoteDrag\")";
_dd._initialize(processBA,cork.getObject(),"NoteDrag");
RDebugUtils.currentLine=3735571;
 //BA.debugLineNum = 3735571;BA.debugLine="dd.AddDragView(p, False)";
_dd._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3735572;
 //BA.debugLineNum = 3735572;BA.debugLine="dd.AddPlaceView(place1).AddPlaceView(place2).AddP";
_dd._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place12.getObject())));
RDebugUtils.currentLine=3735573;
 //BA.debugLineNum = 3735573;BA.debugLine="End Sub";
return "";
}
public static String  _canvabtn_click() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvabtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvabtn_click", null));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Private Sub canvaBtn_Click";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="canvasWindow(250dip, 180dip)";
_canvaswindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="canvasPnl.Visible = True";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="penSpnr.Visible = True";
mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="End Sub";
return "";
}
public static String  _canvaswindow(int _pw,int _ph) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvaswindow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvaswindow", new Object[] {_pw,_ph}));}
anywheresoftware.b4a.objects.SpinnerWrapper _sizespnr = null;
anywheresoftware.b4a.objects.ButtonWrapper _addcbtn = null;
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Private Sub canvasWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="canvasPnl = xui.CreatePanel(\"canvasPanel\")";
mostCurrent._canvaspnl = _xui.CreatePanel(processBA,"canvasPanel");
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="Activity.AddView(canvasPnl, 100dip, 225dip, pW, p";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._canvaspnl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (225)),_pw,_ph);
RDebugUtils.currentLine=8912899;
 //BA.debugLineNum = 8912899;BA.debugLine="canvasPnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._canvaspnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=8912900;
 //BA.debugLineNum = 8912900;BA.debugLine="canvasPnl.SetColorAndBorder(xui.Color_White, 2dip";
mostCurrent._canvaspnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=8912902;
 //BA.debugLineNum = 8912902;BA.debugLine="Dim sizeSpnr As Spinner";
_sizespnr = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=8912903;
 //BA.debugLineNum = 8912903;BA.debugLine="sizeSpnr.Initialize(\"sizeSpnr\")";
_sizespnr.Initialize(mostCurrent.activityBA,"sizeSpnr");
RDebugUtils.currentLine=8912904;
 //BA.debugLineNum = 8912904;BA.debugLine="sizeSpnr.AddAll(Array As String(\"1x1\", \"2x1\", \"1x";
_sizespnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"1x1","2x1","1x2","2x2","3x2","2x3"}));
RDebugUtils.currentLine=8912905;
 //BA.debugLineNum = 8912905;BA.debugLine="canvasPnl.AddView(sizeSpnr, 10dip, 10dip, pW - 20";
mostCurrent._canvaspnl.AddView((android.view.View)(_sizespnr.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_pw-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=8912907;
 //BA.debugLineNum = 8912907;BA.debugLine="Dim addcBtn As Button";
_addcbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=8912908;
 //BA.debugLineNum = 8912908;BA.debugLine="addcBtn.Initialize(\"addcBtn\")";
_addcbtn.Initialize(mostCurrent.activityBA,"addcBtn");
RDebugUtils.currentLine=8912909;
 //BA.debugLineNum = 8912909;BA.debugLine="addcBtn.Text = \"Add Canvas\"";
_addcbtn.setText(BA.ObjectToCharSequence("Add Canvas"));
RDebugUtils.currentLine=8912910;
 //BA.debugLineNum = 8912910;BA.debugLine="canvasPnl.AddView(addcBtn, 10dip, 60dip, (pW / 2)";
mostCurrent._canvaspnl.AddView((android.view.View)(_addcbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),(int) ((_pw/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=8912912;
 //BA.debugLineNum = 8912912;BA.debugLine="canvasPnl.Enabled = False";
mostCurrent._canvaspnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8912913;
 //BA.debugLineNum = 8912913;BA.debugLine="canvasPnl.Visible = False";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8912914;
 //BA.debugLineNum = 8912914;BA.debugLine="End Sub";
return "";
}
public static String  _canvaspanel_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvaspanel_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvaspanel_touch", new Object[] {_action,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub CanvasPanel_Touch (Action As Int, X As Float,";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="Dim p As Panel = Sender";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="Dim cvs As B4XCanvas = p.Tag";
_cvs = (anywheresoftware.b4a.objects.B4XCanvas)(_p.getTag());
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN,mostCurrent._activity.ACTION_MOVE)) {
case 0: {
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=3997703;
 //BA.debugLineNum = 3997703;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
case 1: {
RDebugUtils.currentLine=3997706;
 //BA.debugLineNum = 3997706;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, Colors.RGB(R2,";
_cvs.DrawLine(_lastx,_lasty,_x,_y,anywheresoftware.b4a.keywords.Common.Colors.RGB(_r2,_g2,_b2),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3))));
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="cvs.Invalidate ' This refresh is required to sh";
_cvs.Invalidate();
RDebugUtils.currentLine=3997708;
 //BA.debugLineNum = 3997708;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=3997709;
 //BA.debugLineNum = 3997709;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
}
;
RDebugUtils.currentLine=3997711;
 //BA.debugLineNum = 3997711;BA.debugLine="End Sub";
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
public static String  _colorsspnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "colorsspnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "colorsspnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Private Sub colorsSpnr_ItemClick (Position As Int,";
RDebugUtils.currentLine=7471105;
 //BA.debugLineNum = 7471105;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=7471107;
 //BA.debugLineNum = 7471107;BA.debugLine="R = 255";
_r = (int) (255);
RDebugUtils.currentLine=7471108;
 //BA.debugLineNum = 7471108;BA.debugLine="G = 0";
_g = (int) (0);
RDebugUtils.currentLine=7471109;
 //BA.debugLineNum = 7471109;BA.debugLine="B = 0";
_b = (int) (0);
 break; }
case 1: {
RDebugUtils.currentLine=7471111;
 //BA.debugLineNum = 7471111;BA.debugLine="R = 0";
_r = (int) (0);
RDebugUtils.currentLine=7471112;
 //BA.debugLineNum = 7471112;BA.debugLine="G = 0";
_g = (int) (0);
RDebugUtils.currentLine=7471113;
 //BA.debugLineNum = 7471113;BA.debugLine="B = 255";
_b = (int) (255);
 break; }
case 2: {
RDebugUtils.currentLine=7471115;
 //BA.debugLineNum = 7471115;BA.debugLine="R = 0";
_r = (int) (0);
RDebugUtils.currentLine=7471116;
 //BA.debugLineNum = 7471116;BA.debugLine="G = 255";
_g = (int) (255);
RDebugUtils.currentLine=7471117;
 //BA.debugLineNum = 7471117;BA.debugLine="B = 0";
_b = (int) (0);
 break; }
}
;
RDebugUtils.currentLine=7471119;
 //BA.debugLineNum = 7471119;BA.debugLine="End Sub";
return "";
}
public static String  _imgbtn_click() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgbtn_click", null));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Private Sub imgBtn_Click";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="imgPicker.Show(\"image/*\", \"Select a Photo\")";
_imgpicker.Show(processBA,"image/*","Select a Photo");
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="imgPick";
_imgpick();
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="End Sub";
return "";
}
public static String  _imgpick() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgpick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgpick", null));}
int _randomx = 0;
int _randomy = 0;
b4a.example.dragdropview _dd = null;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub imgPick";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="imgView.Initialize(\"ImgView\")";
mostCurrent._imgview.Initialize(mostCurrent.activityBA,"ImgView");
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="boardPnl.AddView(imgView, randomX, randomY, 100di";
mostCurrent._boardpnl.AddView((android.view.View)(mostCurrent._imgview.getObject()),_randomx,_randomy,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="Dim dd As DragDropView";
_dd = new b4a.example.dragdropview();
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="dd.Initialize(Me, \"ImgDrag\")";
_dd._initialize(processBA,cork.getObject(),"ImgDrag");
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="dd.AddDragView(imgView, False)";
_dd._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._imgview.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866633;
 //BA.debugLineNum = 3866633;BA.debugLine="dd.AddPlaceView(place1).AddPlaceView(place2).AddP";
_dd._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place9.getObject())));
RDebugUtils.currentLine=3866635;
 //BA.debugLineNum = 3866635;BA.debugLine="End Sub";
return "";
}
public static String  _notewindow(int _pw,int _ph) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "notewindow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "notewindow", new Object[] {_pw,_ph}));}
anywheresoftware.b4a.objects.SpinnerWrapper _colorsspnr = null;
anywheresoftware.b4a.objects.ButtonWrapper _addnbtn = null;
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Private Sub noteWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="notePnl = xui.CreatePanel(\"notePnl\")";
mostCurrent._notepnl = _xui.CreatePanel(processBA,"notePnl");
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="Activity.AddView(notePnl, 100dip, 225dip, pW, pH)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._notepnl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (225)),_pw,_ph);
RDebugUtils.currentLine=7995395;
 //BA.debugLineNum = 7995395;BA.debugLine="notePnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._notepnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="notePnl.SetColorAndBorder(xui.Color_White, 2dip,";
mostCurrent._notepnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="Dim colorsSpnr As Spinner";
_colorsspnr = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=7995399;
 //BA.debugLineNum = 7995399;BA.debugLine="colorsSpnr.Initialize(\"colorsSpnr\")";
_colorsspnr.Initialize(mostCurrent.activityBA,"colorsSpnr");
RDebugUtils.currentLine=7995400;
 //BA.debugLineNum = 7995400;BA.debugLine="colorsSpnr.AddAll(Array As String(\"Red\", \"Blue\",";
_colorsspnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Red","Blue","Green"}));
RDebugUtils.currentLine=7995401;
 //BA.debugLineNum = 7995401;BA.debugLine="notePnl.AddView(colorsSpnr, 10dip, 10dip, pW - 20";
mostCurrent._notepnl.AddView((android.view.View)(_colorsspnr.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_pw-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=7995403;
 //BA.debugLineNum = 7995403;BA.debugLine="Dim addnBtn As Button";
_addnbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=7995404;
 //BA.debugLineNum = 7995404;BA.debugLine="addnBtn.Initialize(\"addnBtn\")";
_addnbtn.Initialize(mostCurrent.activityBA,"addnBtn");
RDebugUtils.currentLine=7995405;
 //BA.debugLineNum = 7995405;BA.debugLine="addnBtn.Text = \"Add Note\"";
_addnbtn.setText(BA.ObjectToCharSequence("Add Note"));
RDebugUtils.currentLine=7995406;
 //BA.debugLineNum = 7995406;BA.debugLine="notePnl.AddView(addnBtn, 10dip, 60dip, (pW / 2) -";
mostCurrent._notepnl.AddView((android.view.View)(_addnbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),(int) ((_pw/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=7995408;
 //BA.debugLineNum = 7995408;BA.debugLine="notePnl.Enabled = False";
mostCurrent._notepnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7995409;
 //BA.debugLineNum = 7995409;BA.debugLine="notePnl.Visible = False";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7995410;
 //BA.debugLineNum = 7995410;BA.debugLine="End Sub";
return "";
}
public static String  _penspnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "penspnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "penspnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Private Sub penSpnr_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=7667715;
 //BA.debugLineNum = 7667715;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=7667716;
 //BA.debugLineNum = 7667716;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=7667717;
 //BA.debugLineNum = 7667717;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 1: {
RDebugUtils.currentLine=7667719;
 //BA.debugLineNum = 7667719;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=7667720;
 //BA.debugLineNum = 7667720;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=7667721;
 //BA.debugLineNum = 7667721;BA.debugLine="B2 = 255";
_b2 = (int) (255);
 break; }
case 2: {
RDebugUtils.currentLine=7667723;
 //BA.debugLineNum = 7667723;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=7667724;
 //BA.debugLineNum = 7667724;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=7667725;
 //BA.debugLineNum = 7667725;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 3: {
RDebugUtils.currentLine=7667727;
 //BA.debugLineNum = 7667727;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=7667728;
 //BA.debugLineNum = 7667728;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=7667729;
 //BA.debugLineNum = 7667729;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 4: {
RDebugUtils.currentLine=7667731;
 //BA.debugLineNum = 7667731;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=7667732;
 //BA.debugLineNum = 7667732;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=7667733;
 //BA.debugLineNum = 7667733;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 5: {
RDebugUtils.currentLine=7667735;
 //BA.debugLineNum = 7667735;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=7667736;
 //BA.debugLineNum = 7667736;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=7667737;
 //BA.debugLineNum = 7667737;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
}
;
RDebugUtils.currentLine=7667739;
 //BA.debugLineNum = 7667739;BA.debugLine="End Sub";
return "";
}
public static String  _sizespnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sizespnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sizespnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Private Sub sizeSpnr_ItemClick (Position As Int, V";
RDebugUtils.currentLine=9175041;
 //BA.debugLineNum = 9175041;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=9175043;
 //BA.debugLineNum = 9175043;BA.debugLine="Width = 100dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=9175044;
 //BA.debugLineNum = 9175044;BA.debugLine="Height = 100dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
 break; }
case 1: {
RDebugUtils.currentLine=9175046;
 //BA.debugLineNum = 9175046;BA.debugLine="Width = 200dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200));
RDebugUtils.currentLine=9175047;
 //BA.debugLineNum = 9175047;BA.debugLine="Height = 200dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200));
 break; }
case 2: {
RDebugUtils.currentLine=9175049;
 //BA.debugLineNum = 9175049;BA.debugLine="Width = 100dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=9175050;
 //BA.debugLineNum = 9175050;BA.debugLine="Height = 100dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
 break; }
case 3: {
RDebugUtils.currentLine=9175052;
 //BA.debugLineNum = 9175052;BA.debugLine="Width = 100dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=9175053;
 //BA.debugLineNum = 9175053;BA.debugLine="Height = 100dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
 break; }
case 4: {
RDebugUtils.currentLine=9175055;
 //BA.debugLineNum = 9175055;BA.debugLine="Width = 100dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=9175056;
 //BA.debugLineNum = 9175056;BA.debugLine="Height = 100dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
 break; }
case 5: {
RDebugUtils.currentLine=9175058;
 //BA.debugLineNum = 9175058;BA.debugLine="Width = 100dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=9175059;
 //BA.debugLineNum = 9175059;BA.debugLine="Height = 100dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
 break; }
}
;
RDebugUtils.currentLine=9175061;
 //BA.debugLineNum = 9175061;BA.debugLine="End Sub";
return "";
}
public static String  _stickybtn_click() throws Exception{
RDebugUtils.currentModule="cork";
if (Debug.shouldDelegate(mostCurrent.activityBA, "stickybtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "stickybtn_click", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub stickyBtn_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="noteWindow(250dip, 180dip)";
_notewindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="notePnl.Visible = True";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="End Sub";
return "";
}
}