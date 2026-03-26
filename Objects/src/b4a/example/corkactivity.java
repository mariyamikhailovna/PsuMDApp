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

public class corkactivity extends Activity implements B4AActivity{
	public static corkactivity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.corkactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (corkactivity).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.corkactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.corkactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (corkactivity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (corkactivity) Resume **");
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
		return corkactivity.class;
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
            BA.LogInfo("** Activity (corkactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (corkactivity) Pause event (activity is not paused). **");
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
            corkactivity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (corkactivity) Resume **");
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
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=7143425;
 //BA.debugLineNum = 7143425;BA.debugLine="Activity.LoadLayout(\"corkboardLayout\")";
mostCurrent._activity.LoadLayout("corkboardLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="penSpnr.AddAll(Array As String(\"Red\", \"Blue\", \"Gr";
mostCurrent._penspnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Red","Blue","Green","Black","Yellow","Eraser"}));
RDebugUtils.currentLine=7143427;
 //BA.debugLineNum = 7143427;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=7143428;
 //BA.debugLineNum = 7143428;BA.debugLine="imgPicker.Initialize(\"CC\")";
_imgpicker.Initialize("CC");
 };
RDebugUtils.currentLine=7143430;
 //BA.debugLineNum = 7143430;BA.debugLine="penSpnr.Visible = False";
mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7143431;
 //BA.debugLineNum = 7143431;BA.debugLine="Width = 80dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=7143432;
 //BA.debugLineNum = 7143432;BA.debugLine="Height = 60dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
RDebugUtils.currentLine=7143433;
 //BA.debugLineNum = 7143433;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="corkactivity";
RDebugUtils.currentLine=7274496;
 //BA.debugLineNum = 7274496;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=7274498;
 //BA.debugLineNum = 7274498;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="End Sub";
return "";
}
public static void  _addcanvas(int _x,int _y) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addcanvas", false))
	 {Debug.delegate(mostCurrent.activityBA, "addcanvas", new Object[] {_x,_y}); return;}
ResumableSub_AddCanvas rsub = new ResumableSub_AddCanvas(null,_x,_y);
rsub.resume(processBA, null);
}
public static class ResumableSub_AddCanvas extends BA.ResumableSub {
public ResumableSub_AddCanvas(b4a.example.corkactivity parent,int _x,int _y) {
this.parent = parent;
this._x = _x;
this._y = _y;
}
b4a.example.corkactivity parent;
int _x;
int _y;
anywheresoftware.b4a.objects.PanelWrapper _f = null;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
b4a.example.dragdropview _dd = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="corkactivity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=7536641;
 //BA.debugLineNum = 7536641;BA.debugLine="Dim f As Panel";
_f = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="f.Initialize(\"CanvasFrame\")";
_f.Initialize(mostCurrent.activityBA,"CanvasFrame");
RDebugUtils.currentLine=7536643;
 //BA.debugLineNum = 7536643;BA.debugLine="f.Color = Colors.Gray";
_f.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7536644;
 //BA.debugLineNum = 7536644;BA.debugLine="boardPnl.AddView(f, x, y, Width + 20dip, Height +";
parent.mostCurrent._boardpnl.AddView((android.view.View)(_f.getObject()),_x,_y,(int) (parent._width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (parent._height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))));
RDebugUtils.currentLine=7536646;
 //BA.debugLineNum = 7536646;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=7536647;
 //BA.debugLineNum = 7536647;BA.debugLine="p.Initialize(\"CanvasPanel\")";
_p.Initialize(mostCurrent.activityBA,"CanvasPanel");
RDebugUtils.currentLine=7536648;
 //BA.debugLineNum = 7536648;BA.debugLine="p.Color = Colors.White";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=7536649;
 //BA.debugLineNum = 7536649;BA.debugLine="f.AddView(p, 10dip, 20dip, Width, Height)";
_f.AddView((android.view.View)(_p.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),parent._width,parent._height);
RDebugUtils.currentLine=7536651;
 //BA.debugLineNum = 7536651;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "addcanvas"),(int) (0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=7536653;
 //BA.debugLineNum = 7536653;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=7536654;
 //BA.debugLineNum = 7536654;BA.debugLine="cvs.Initialize(p)";
_cvs.Initialize((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())));
RDebugUtils.currentLine=7536655;
 //BA.debugLineNum = 7536655;BA.debugLine="cvs.DrawRect(cvs.TargetRect, Colors.LightGray, Fa";
_cvs.DrawRect(_cvs.getTargetRect(),anywheresoftware.b4a.keywords.Common.Colors.LightGray,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=7536656;
 //BA.debugLineNum = 7536656;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
RDebugUtils.currentLine=7536657;
 //BA.debugLineNum = 7536657;BA.debugLine="p.Tag = cvs";
_p.setTag((Object)(_cvs));
RDebugUtils.currentLine=7536659;
 //BA.debugLineNum = 7536659;BA.debugLine="Dim dd As DragDropView";
_dd = new b4a.example.dragdropview();
RDebugUtils.currentLine=7536660;
 //BA.debugLineNum = 7536660;BA.debugLine="dd.Initialize(Me, \"CanvasDrag\")";
_dd._initialize(processBA,corkactivity.getObject(),"CanvasDrag");
RDebugUtils.currentLine=7536661;
 //BA.debugLineNum = 7536661;BA.debugLine="dd.AddDragView(f, False)";
_dd._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_f.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536662;
 //BA.debugLineNum = 7536662;BA.debugLine="dd.AddPlaceView(place1).AddPlaceView(place2).AddP";
_dd._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place12.getObject())));
RDebugUtils.currentLine=7536663;
 //BA.debugLineNum = 7536663;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _addcbtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addcbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addcbtn_click", null));}
int _randomx = 0;
int _randomy = 0;
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Private Sub addcBtn_Click";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="AddCanvas(randomX, randomY)";
_addcanvas(_randomx,_randomy);
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="canvasPnl.Visible = False";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7929861;
 //BA.debugLineNum = 7929861;BA.debugLine="End Sub";
return "";
}
public static String  _addnbtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addnbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addnbtn_click", null));}
int _randomx = 0;
int _randomy = 0;
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Private Sub addnBtn_Click";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="AddStickyNote(\"\", randomX, randomY)";
_addstickynote("",_randomx,_randomy);
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="notePnl.Visible = False";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7864325;
 //BA.debugLineNum = 7864325;BA.debugLine="R = 255";
_r = (int) (255);
RDebugUtils.currentLine=7864326;
 //BA.debugLineNum = 7864326;BA.debugLine="G = 0";
_g = (int) (0);
RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="B = 0";
_b = (int) (0);
RDebugUtils.currentLine=7864328;
 //BA.debugLineNum = 7864328;BA.debugLine="End Sub";
return "";
}
public static String  _addstickynote(String _text,int _x,int _y) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addstickynote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addstickynote", new Object[] {_text,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.EditTextWrapper _txt = null;
b4a.example.dragdropview _dd = null;
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
RDebugUtils.currentLine=7340033;
 //BA.debugLineNum = 7340033;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=7340034;
 //BA.debugLineNum = 7340034;BA.debugLine="p.Initialize(\"NotePanel\")";
_p.Initialize(mostCurrent.activityBA,"NotePanel");
RDebugUtils.currentLine=7340035;
 //BA.debugLineNum = 7340035;BA.debugLine="p.Color = Colors.RGB(R, G, B)";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB(_r,_g,_b));
RDebugUtils.currentLine=7340037;
 //BA.debugLineNum = 7340037;BA.debugLine="Dim txt As EditText";
_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=7340038;
 //BA.debugLineNum = 7340038;BA.debugLine="txt.Initialize(\"\")";
_txt.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7340039;
 //BA.debugLineNum = 7340039;BA.debugLine="txt.Text = Text";
_txt.setText(BA.ObjectToCharSequence(_text));
RDebugUtils.currentLine=7340040;
 //BA.debugLineNum = 7340040;BA.debugLine="txt.TextSize = 12";
_txt.setTextSize((float) (12));
RDebugUtils.currentLine=7340041;
 //BA.debugLineNum = 7340041;BA.debugLine="txt.Background = Null";
_txt.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=7340042;
 //BA.debugLineNum = 7340042;BA.debugLine="txt.TextColor = Colors.Black";
_txt.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=7340043;
 //BA.debugLineNum = 7340043;BA.debugLine="txt.Gravity = Gravity.TOP";
_txt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=7340045;
 //BA.debugLineNum = 7340045;BA.debugLine="p.AddView(txt, 5dip, 15dip, 90dip, 70dip)";
_p.AddView((android.view.View)(_txt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=7340047;
 //BA.debugLineNum = 7340047;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
mostCurrent._boardpnl.AddView((android.view.View)(_p.getObject()),_x,_y,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=7340049;
 //BA.debugLineNum = 7340049;BA.debugLine="Dim dd As DragDropView";
_dd = new b4a.example.dragdropview();
RDebugUtils.currentLine=7340050;
 //BA.debugLineNum = 7340050;BA.debugLine="dd.Initialize(Me, \"NoteDrag\")";
_dd._initialize(processBA,corkactivity.getObject(),"NoteDrag");
RDebugUtils.currentLine=7340051;
 //BA.debugLineNum = 7340051;BA.debugLine="dd.AddDragView(p, False)";
_dd._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7340052;
 //BA.debugLineNum = 7340052;BA.debugLine="dd.AddPlaceView(place1).AddPlaceView(place2).AddP";
_dd._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place12.getObject())));
RDebugUtils.currentLine=7340053;
 //BA.debugLineNum = 7340053;BA.debugLine="End Sub";
return "";
}
public static String  _canvabtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvabtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvabtn_click", null));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Private Sub canvaBtn_Click";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="canvasWindow(250dip, 180dip)";
_canvaswindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="canvasPnl.Visible = True";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="penSpnr.Visible = True";
mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="End Sub";
return "";
}
public static String  _canvaswindow(int _pw,int _ph) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvaswindow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvaswindow", new Object[] {_pw,_ph}));}
anywheresoftware.b4a.objects.SpinnerWrapper _sizespnr = null;
anywheresoftware.b4a.objects.ButtonWrapper _addcbtn = null;
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Private Sub canvasWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="canvasPnl = xui.CreatePanel(\"canvasPanel\")";
mostCurrent._canvaspnl = _xui.CreatePanel(processBA,"canvasPanel");
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="Activity.AddView(canvasPnl, 100dip, 225dip, pW, p";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._canvaspnl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (225)),_pw,_ph);
RDebugUtils.currentLine=7798787;
 //BA.debugLineNum = 7798787;BA.debugLine="canvasPnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._canvaspnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=7798788;
 //BA.debugLineNum = 7798788;BA.debugLine="canvasPnl.SetColorAndBorder(xui.Color_White, 2dip";
mostCurrent._canvaspnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=7798790;
 //BA.debugLineNum = 7798790;BA.debugLine="Dim sizeSpnr As Spinner";
_sizespnr = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=7798791;
 //BA.debugLineNum = 7798791;BA.debugLine="sizeSpnr.Initialize(\"sizeSpnr\")";
_sizespnr.Initialize(mostCurrent.activityBA,"sizeSpnr");
RDebugUtils.currentLine=7798792;
 //BA.debugLineNum = 7798792;BA.debugLine="sizeSpnr.AddAll(Array As String(\"1x1\", \"2x1\", \"1x";
_sizespnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"1x1","2x1","1x2","2x2","3x2","2x3"}));
RDebugUtils.currentLine=7798793;
 //BA.debugLineNum = 7798793;BA.debugLine="canvasPnl.AddView(sizeSpnr, 10dip, 10dip, pW - 20";
mostCurrent._canvaspnl.AddView((android.view.View)(_sizespnr.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_pw-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=7798795;
 //BA.debugLineNum = 7798795;BA.debugLine="Dim addcBtn As Button";
_addcbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=7798796;
 //BA.debugLineNum = 7798796;BA.debugLine="addcBtn.Initialize(\"addcBtn\")";
_addcbtn.Initialize(mostCurrent.activityBA,"addcBtn");
RDebugUtils.currentLine=7798797;
 //BA.debugLineNum = 7798797;BA.debugLine="addcBtn.Text = \"Add Canvas\"";
_addcbtn.setText(BA.ObjectToCharSequence("Add Canvas"));
RDebugUtils.currentLine=7798798;
 //BA.debugLineNum = 7798798;BA.debugLine="canvasPnl.AddView(addcBtn, 10dip, 60dip, (pW / 2)";
mostCurrent._canvaspnl.AddView((android.view.View)(_addcbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),(int) ((_pw/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=7798800;
 //BA.debugLineNum = 7798800;BA.debugLine="canvasPnl.Enabled = False";
mostCurrent._canvaspnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7798801;
 //BA.debugLineNum = 7798801;BA.debugLine="canvasPnl.Visible = False";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7798802;
 //BA.debugLineNum = 7798802;BA.debugLine="End Sub";
return "";
}
public static String  _canvaspanel_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvaspanel_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvaspanel_touch", new Object[] {_action,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Sub CanvasPanel_Touch (Action As Int, X As Float,";
RDebugUtils.currentLine=7602177;
 //BA.debugLineNum = 7602177;BA.debugLine="Dim p As Panel = Sender";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="Dim cvs As B4XCanvas = p.Tag";
_cvs = (anywheresoftware.b4a.objects.B4XCanvas)(_p.getTag());
RDebugUtils.currentLine=7602179;
 //BA.debugLineNum = 7602179;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN,mostCurrent._activity.ACTION_MOVE)) {
case 0: {
RDebugUtils.currentLine=7602181;
 //BA.debugLineNum = 7602181;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=7602182;
 //BA.debugLineNum = 7602182;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
case 1: {
RDebugUtils.currentLine=7602184;
 //BA.debugLineNum = 7602184;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, Colors.RGB(R2,";
_cvs.DrawLine(_lastx,_lasty,_x,_y,anywheresoftware.b4a.keywords.Common.Colors.RGB(_r2,_g2,_b2),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3))));
RDebugUtils.currentLine=7602185;
 //BA.debugLineNum = 7602185;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
RDebugUtils.currentLine=7602186;
 //BA.debugLineNum = 7602186;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=7602187;
 //BA.debugLineNum = 7602187;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
}
;
RDebugUtils.currentLine=7602189;
 //BA.debugLineNum = 7602189;BA.debugLine="End Sub";
return "";
}
public static String  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cc_result", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cc_result", new Object[] {_success,_dir,_filename}));}
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
RDebugUtils.currentLine=7405569;
 //BA.debugLineNum = 7405569;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="imgView.Bitmap = LoadBitmapResize(Dir, FileName,";
mostCurrent._imgview.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapResize(_dir,_filename,mostCurrent._imgview.getWidth(),mostCurrent._imgview.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=7405572;
 //BA.debugLineNum = 7405572;BA.debugLine="ToastMessageShow(\"No image selected\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No image selected"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=7405574;
 //BA.debugLineNum = 7405574;BA.debugLine="End Sub";
return "";
}
public static String  _colorsspnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "colorsspnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "colorsspnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Private Sub colorsSpnr_ItemClick (Position As Int,";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=8192003;
 //BA.debugLineNum = 8192003;BA.debugLine="R = 255";
_r = (int) (255);
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="G = 0";
_g = (int) (0);
RDebugUtils.currentLine=8192005;
 //BA.debugLineNum = 8192005;BA.debugLine="B = 0";
_b = (int) (0);
 break; }
case 1: {
RDebugUtils.currentLine=8192007;
 //BA.debugLineNum = 8192007;BA.debugLine="R = 0";
_r = (int) (0);
RDebugUtils.currentLine=8192008;
 //BA.debugLineNum = 8192008;BA.debugLine="G = 0";
_g = (int) (0);
RDebugUtils.currentLine=8192009;
 //BA.debugLineNum = 8192009;BA.debugLine="B = 255";
_b = (int) (255);
 break; }
case 2: {
RDebugUtils.currentLine=8192011;
 //BA.debugLineNum = 8192011;BA.debugLine="R = 0";
_r = (int) (0);
RDebugUtils.currentLine=8192012;
 //BA.debugLineNum = 8192012;BA.debugLine="G = 255";
_g = (int) (255);
RDebugUtils.currentLine=8192013;
 //BA.debugLineNum = 8192013;BA.debugLine="B = 0";
_b = (int) (0);
 break; }
}
;
RDebugUtils.currentLine=8192015;
 //BA.debugLineNum = 8192015;BA.debugLine="End Sub";
return "";
}
public static String  _imgbtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgbtn_click", null));}
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Private Sub imgBtn_Click";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="imgPicker.Show(\"image/*\", \"Select a Photo\")";
_imgpicker.Show(processBA,"image/*","Select a Photo");
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="imgPick";
_imgpick();
RDebugUtils.currentLine=7995395;
 //BA.debugLineNum = 7995395;BA.debugLine="End Sub";
return "";
}
public static String  _imgpick() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgpick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgpick", null));}
int _randomx = 0;
int _randomy = 0;
b4a.example.dragdropview _dd = null;
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub imgPick";
RDebugUtils.currentLine=7471105;
 //BA.debugLineNum = 7471105;BA.debugLine="imgView.Initialize(\"ImgView\")";
mostCurrent._imgview.Initialize(mostCurrent.activityBA,"ImgView");
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="Dim randomX As Int = Rnd(20dip, 300dip)";
_randomx = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=7471107;
 //BA.debugLineNum = 7471107;BA.debugLine="Dim randomY As Int = Rnd(20dip, 500dip)";
_randomy = anywheresoftware.b4a.keywords.Common.Rnd(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=7471108;
 //BA.debugLineNum = 7471108;BA.debugLine="boardPnl.AddView(imgView, randomX, randomY, 100di";
mostCurrent._boardpnl.AddView((android.view.View)(mostCurrent._imgview.getObject()),_randomx,_randomy,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=7471110;
 //BA.debugLineNum = 7471110;BA.debugLine="Dim dd As DragDropView";
_dd = new b4a.example.dragdropview();
RDebugUtils.currentLine=7471111;
 //BA.debugLineNum = 7471111;BA.debugLine="dd.Initialize(Me, \"ImgDrag\")";
_dd._initialize(processBA,corkactivity.getObject(),"ImgDrag");
RDebugUtils.currentLine=7471112;
 //BA.debugLineNum = 7471112;BA.debugLine="dd.AddDragView(imgView, False)";
_dd._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._imgview.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7471113;
 //BA.debugLineNum = 7471113;BA.debugLine="dd.AddPlaceView(place1).AddPlaceView(place2).AddP";
_dd._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place9.getObject())));
RDebugUtils.currentLine=7471115;
 //BA.debugLineNum = 7471115;BA.debugLine="End Sub";
return "";
}
public static String  _notewindow(int _pw,int _ph) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "notewindow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "notewindow", new Object[] {_pw,_ph}));}
anywheresoftware.b4a.objects.SpinnerWrapper _colorsspnr = null;
anywheresoftware.b4a.objects.ButtonWrapper _addnbtn = null;
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Private Sub noteWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="notePnl = xui.CreatePanel(\"notePnl\")";
mostCurrent._notepnl = _xui.CreatePanel(processBA,"notePnl");
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="Activity.AddView(notePnl, 100dip, 225dip, pW, pH)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._notepnl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (225)),_pw,_ph);
RDebugUtils.currentLine=7733251;
 //BA.debugLineNum = 7733251;BA.debugLine="notePnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._notepnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=7733252;
 //BA.debugLineNum = 7733252;BA.debugLine="notePnl.SetColorAndBorder(xui.Color_White, 2dip,";
mostCurrent._notepnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=7733254;
 //BA.debugLineNum = 7733254;BA.debugLine="Dim colorsSpnr As Spinner";
_colorsspnr = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=7733255;
 //BA.debugLineNum = 7733255;BA.debugLine="colorsSpnr.Initialize(\"colorsSpnr\")";
_colorsspnr.Initialize(mostCurrent.activityBA,"colorsSpnr");
RDebugUtils.currentLine=7733256;
 //BA.debugLineNum = 7733256;BA.debugLine="colorsSpnr.AddAll(Array As String(\"Red\", \"Blue\",";
_colorsspnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Red","Blue","Green"}));
RDebugUtils.currentLine=7733257;
 //BA.debugLineNum = 7733257;BA.debugLine="notePnl.AddView(colorsSpnr, 10dip, 10dip, pW - 20";
mostCurrent._notepnl.AddView((android.view.View)(_colorsspnr.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_pw-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=7733259;
 //BA.debugLineNum = 7733259;BA.debugLine="Dim addnBtn As Button";
_addnbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=7733260;
 //BA.debugLineNum = 7733260;BA.debugLine="addnBtn.Initialize(\"addnBtn\")";
_addnbtn.Initialize(mostCurrent.activityBA,"addnBtn");
RDebugUtils.currentLine=7733261;
 //BA.debugLineNum = 7733261;BA.debugLine="addnBtn.Text = \"Add Note\"";
_addnbtn.setText(BA.ObjectToCharSequence("Add Note"));
RDebugUtils.currentLine=7733262;
 //BA.debugLineNum = 7733262;BA.debugLine="notePnl.AddView(addnBtn, 10dip, 60dip, (pW / 2) -";
mostCurrent._notepnl.AddView((android.view.View)(_addnbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),(int) ((_pw/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=7733264;
 //BA.debugLineNum = 7733264;BA.debugLine="notePnl.Enabled = False";
mostCurrent._notepnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7733265;
 //BA.debugLineNum = 7733265;BA.debugLine="notePnl.Visible = False";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7733266;
 //BA.debugLineNum = 7733266;BA.debugLine="End Sub";
return "";
}
public static String  _penspnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "penspnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "penspnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Private Sub penSpnr_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=8257540;
 //BA.debugLineNum = 8257540;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=8257541;
 //BA.debugLineNum = 8257541;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 1: {
RDebugUtils.currentLine=8257543;
 //BA.debugLineNum = 8257543;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=8257544;
 //BA.debugLineNum = 8257544;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=8257545;
 //BA.debugLineNum = 8257545;BA.debugLine="B2 = 255";
_b2 = (int) (255);
 break; }
case 2: {
RDebugUtils.currentLine=8257547;
 //BA.debugLineNum = 8257547;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=8257548;
 //BA.debugLineNum = 8257548;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=8257549;
 //BA.debugLineNum = 8257549;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 3: {
RDebugUtils.currentLine=8257551;
 //BA.debugLineNum = 8257551;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=8257552;
 //BA.debugLineNum = 8257552;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=8257553;
 //BA.debugLineNum = 8257553;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 4: {
RDebugUtils.currentLine=8257555;
 //BA.debugLineNum = 8257555;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=8257556;
 //BA.debugLineNum = 8257556;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=8257557;
 //BA.debugLineNum = 8257557;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 5: {
RDebugUtils.currentLine=8257559;
 //BA.debugLineNum = 8257559;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=8257560;
 //BA.debugLineNum = 8257560;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=8257561;
 //BA.debugLineNum = 8257561;BA.debugLine="B2 = 255";
_b2 = (int) (255);
 break; }
}
;
RDebugUtils.currentLine=8257563;
 //BA.debugLineNum = 8257563;BA.debugLine="End Sub";
return "";
}
public static String  _sizespnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sizespnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sizespnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Private Sub sizeSpnr_ItemClick (Position As Int, V";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="Width = 80dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=8126468;
 //BA.debugLineNum = 8126468;BA.debugLine="Height = 60dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
 break; }
case 1: {
RDebugUtils.currentLine=8126470;
 //BA.debugLineNum = 8126470;BA.debugLine="Width = 205dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (205));
RDebugUtils.currentLine=8126471;
 //BA.debugLineNum = 8126471;BA.debugLine="Height = 60dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
 break; }
case 2: {
RDebugUtils.currentLine=8126473;
 //BA.debugLineNum = 8126473;BA.debugLine="Width = 80dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=8126474;
 //BA.debugLineNum = 8126474;BA.debugLine="Height = 185dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (185));
 break; }
case 3: {
RDebugUtils.currentLine=8126476;
 //BA.debugLineNum = 8126476;BA.debugLine="Width = 205dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (205));
RDebugUtils.currentLine=8126477;
 //BA.debugLineNum = 8126477;BA.debugLine="Height = 185dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (185));
 break; }
case 4: {
RDebugUtils.currentLine=8126479;
 //BA.debugLineNum = 8126479;BA.debugLine="Width = 330dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (330));
RDebugUtils.currentLine=8126480;
 //BA.debugLineNum = 8126480;BA.debugLine="Height = 185dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (185));
 break; }
case 5: {
RDebugUtils.currentLine=8126482;
 //BA.debugLineNum = 8126482;BA.debugLine="Width = 205dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (205));
RDebugUtils.currentLine=8126483;
 //BA.debugLineNum = 8126483;BA.debugLine="Height = 310dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (310));
 break; }
}
;
RDebugUtils.currentLine=8126485;
 //BA.debugLineNum = 8126485;BA.debugLine="End Sub";
return "";
}
public static String  _stickybtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "stickybtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "stickybtn_click", null));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Private Sub stickyBtn_Click";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="noteWindow(250dip, 180dip)";
_notewindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="notePnl.Visible = True";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7667715;
 //BA.debugLineNum = 7667715;BA.debugLine="End Sub";
return "";
}
}