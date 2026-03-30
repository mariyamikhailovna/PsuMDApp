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
	public static final boolean includeTitle = false;
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
public anywheresoftware.b4a.objects.LabelWrapper _deletelbl = null;
public b4a.example.dragdropview _ddn = null;
public b4a.example.dragdropview _ddi = null;
public b4a.example.dragdropview _ddc = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.themeactivity _themeactivity = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.card_module _card_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.todoactivity _todoactivity = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Activity.LoadLayout(\"corkboardLayout\")";
mostCurrent._activity.LoadLayout("corkboardLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="penSpnr.AddAll(Array As String(\"Black\", \"Blue\", \"";
mostCurrent._penspnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Black","Blue","Green","Red","Yellow","Eraser"}));
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="imgPicker.Initialize(\"CC\")";
_imgpicker.Initialize("CC");
 };
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="penSpnr.Visible = False";
mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5898247;
 //BA.debugLineNum = 5898247;BA.debugLine="Width = 80dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=5898248;
 //BA.debugLineNum = 5898248;BA.debugLine="Height = 60dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
RDebugUtils.currentLine=5898249;
 //BA.debugLineNum = 5898249;BA.debugLine="ddn.Initialize(Me, \"NoteDrag\")";
mostCurrent._ddn._initialize(processBA,corkactivity.getObject(),"NoteDrag");
RDebugUtils.currentLine=5898250;
 //BA.debugLineNum = 5898250;BA.debugLine="ddi.Initialize(Me, \"ImgDrag\")";
mostCurrent._ddi._initialize(processBA,corkactivity.getObject(),"ImgDrag");
RDebugUtils.currentLine=5898251;
 //BA.debugLineNum = 5898251;BA.debugLine="ddc.Initialize(Me, \"CanvasDrag\")";
mostCurrent._ddc._initialize(processBA,corkactivity.getObject(),"CanvasDrag");
RDebugUtils.currentLine=5898252;
 //BA.debugLineNum = 5898252;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="corkactivity";
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Dim f As Panel";
_f = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="f.Initialize(\"CanvasFrame\")";
_f.Initialize(mostCurrent.activityBA,"CanvasFrame");
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="f.Color = Colors.Black";
_f.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="boardPnl.AddView(f, x, y, Width + 20dip, Height +";
parent.mostCurrent._boardpnl.AddView((android.view.View)(_f.getObject()),_x,_y,(int) (parent._width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (parent._height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))));
RDebugUtils.currentLine=6291462;
 //BA.debugLineNum = 6291462;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="p.Initialize(\"CanvasPanel\")";
_p.Initialize(mostCurrent.activityBA,"CanvasPanel");
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="p.Color = Colors.White";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=6291465;
 //BA.debugLineNum = 6291465;BA.debugLine="f.AddView(p, 10dip, 20dip, Width, Height)";
_f.AddView((android.view.View)(_p.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),parent._width,parent._height);
RDebugUtils.currentLine=6291467;
 //BA.debugLineNum = 6291467;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "addcanvas"),(int) (0));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
RDebugUtils.currentLine=6291469;
 //BA.debugLineNum = 6291469;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=6291470;
 //BA.debugLineNum = 6291470;BA.debugLine="cvs.Initialize(p)";
_cvs.Initialize((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())));
RDebugUtils.currentLine=6291471;
 //BA.debugLineNum = 6291471;BA.debugLine="cvs.DrawRect(cvs.TargetRect, Colors.LightGray, Fa";
_cvs.DrawRect(_cvs.getTargetRect(),anywheresoftware.b4a.keywords.Common.Colors.LightGray,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=6291472;
 //BA.debugLineNum = 6291472;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
RDebugUtils.currentLine=6291473;
 //BA.debugLineNum = 6291473;BA.debugLine="p.Tag = cvs";
_p.setTag((Object)(_cvs));
RDebugUtils.currentLine=6291475;
 //BA.debugLineNum = 6291475;BA.debugLine="ddc.AddDragView(f, False)";
parent.mostCurrent._ddc._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_f.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6291476;
 //BA.debugLineNum = 6291476;BA.debugLine="ddc.AddPlaceView(place1).AddPlaceView(place2).Add";
parent.mostCurrent._ddc._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place12.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._deletelbl.getObject())));
RDebugUtils.currentLine=6291477;
 //BA.debugLineNum = 6291477;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _addcbtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addcbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addcbtn_click", null));}
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Private Sub addcBtn_Click";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="AddCanvas(150dip, 500dip)";
_addcanvas(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="canvasPnl.Visible = False";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="End Sub";
return "";
}
public static String  _addnbtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addnbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addnbtn_click", null));}
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Private Sub addnBtn_Click";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="AddStickyNote(\"\", 150dip, 500dip)";
_addstickynote("",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="notePnl.Visible = False";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="R = 255";
_r = (int) (255);
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="G = 105";
_g = (int) (105);
RDebugUtils.currentLine=6553605;
 //BA.debugLineNum = 6553605;BA.debugLine="B = 97";
_b = (int) (97);
RDebugUtils.currentLine=6553606;
 //BA.debugLineNum = 6553606;BA.debugLine="stickyBtn.Enabled = True";
mostCurrent._stickybtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6553607;
 //BA.debugLineNum = 6553607;BA.debugLine="End Sub";
return "";
}
public static String  _addstickynote(String _text,int _x,int _y) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addstickynote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addstickynote", new Object[] {_text,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.EditTextWrapper _txt = null;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="p.Initialize(\"NotePanel\")";
_p.Initialize(mostCurrent.activityBA,"NotePanel");
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="p.Color = Colors.RGB(R, G, B)";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB(_r,_g,_b));
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="Dim txt As EditText";
_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="txt.Initialize(\"\")";
_txt.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="txt.Text = Text";
_txt.setText(BA.ObjectToCharSequence(_text));
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="txt.TextSize = 12";
_txt.setTextSize((float) (12));
RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="txt.Background = Null";
_txt.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=6094858;
 //BA.debugLineNum = 6094858;BA.debugLine="txt.TextColor = Colors.Black";
_txt.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=6094859;
 //BA.debugLineNum = 6094859;BA.debugLine="txt.Gravity = Gravity.TOP";
_txt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=6094861;
 //BA.debugLineNum = 6094861;BA.debugLine="p.AddView(txt, 5dip, 15dip, 90dip, 70dip)";
_p.AddView((android.view.View)(_txt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=6094863;
 //BA.debugLineNum = 6094863;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
mostCurrent._boardpnl.AddView((android.view.View)(_p.getObject()),_x,_y,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=6094865;
 //BA.debugLineNum = 6094865;BA.debugLine="ddn.AddDragView(p, False)";
mostCurrent._ddn._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6094866;
 //BA.debugLineNum = 6094866;BA.debugLine="ddn.AddPlaceView(place1).AddPlaceView(place2).Add";
mostCurrent._ddn._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place12.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._deletelbl.getObject())));
RDebugUtils.currentLine=6094868;
 //BA.debugLineNum = 6094868;BA.debugLine="End Sub";
return "";
}
public static String  _canvabtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvabtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvabtn_click", null));}
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Private Sub canvaBtn_Click";
RDebugUtils.currentLine=6815745;
 //BA.debugLineNum = 6815745;BA.debugLine="canvasWindow(250dip, 180dip)";
_canvaswindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="canvasPnl.Visible = True";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6815747;
 //BA.debugLineNum = 6815747;BA.debugLine="penSpnr.Visible = True";
mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6815748;
 //BA.debugLineNum = 6815748;BA.debugLine="End Sub";
return "";
}
public static String  _canvaswindow(int _pw,int _ph) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvaswindow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvaswindow", new Object[] {_pw,_ph}));}
anywheresoftware.b4a.objects.SpinnerWrapper _sizespnr = null;
anywheresoftware.b4a.objects.ButtonWrapper _addcbtn = null;
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Private Sub canvasWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="canvasPnl = xui.CreatePanel(\"canvasPanel\")";
mostCurrent._canvaspnl = _xui.CreatePanel(processBA,"canvasPanel");
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="Activity.AddView(canvasPnl, 100dip, 225dip, pW, p";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._canvaspnl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (225)),_pw,_ph);
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="canvasPnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._canvaspnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="canvasPnl.SetColorAndBorder(xui.Color_White, 2dip";
mostCurrent._canvaspnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=6488070;
 //BA.debugLineNum = 6488070;BA.debugLine="Dim sizeSpnr As Spinner";
_sizespnr = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=6488071;
 //BA.debugLineNum = 6488071;BA.debugLine="sizeSpnr.Initialize(\"sizeSpnr\")";
_sizespnr.Initialize(mostCurrent.activityBA,"sizeSpnr");
RDebugUtils.currentLine=6488072;
 //BA.debugLineNum = 6488072;BA.debugLine="sizeSpnr.AddAll(Array As String(\"1x1\", \"2x1\", \"1x";
_sizespnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"1x1","2x1","1x2","2x2","3x2","2x3"}));
RDebugUtils.currentLine=6488073;
 //BA.debugLineNum = 6488073;BA.debugLine="canvasPnl.AddView(sizeSpnr, 10dip, 10dip, pW - 20";
mostCurrent._canvaspnl.AddView((android.view.View)(_sizespnr.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_pw-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=6488075;
 //BA.debugLineNum = 6488075;BA.debugLine="Dim addcBtn As Button";
_addcbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=6488076;
 //BA.debugLineNum = 6488076;BA.debugLine="addcBtn.Initialize(\"addcBtn\")";
_addcbtn.Initialize(mostCurrent.activityBA,"addcBtn");
RDebugUtils.currentLine=6488077;
 //BA.debugLineNum = 6488077;BA.debugLine="addcBtn.Text = \"Add Canvas\"";
_addcbtn.setText(BA.ObjectToCharSequence("Add Canvas"));
RDebugUtils.currentLine=6488078;
 //BA.debugLineNum = 6488078;BA.debugLine="canvasPnl.AddView(addcBtn, 10dip, 60dip, (pW / 2)";
mostCurrent._canvaspnl.AddView((android.view.View)(_addcbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),(int) ((_pw/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=6488080;
 //BA.debugLineNum = 6488080;BA.debugLine="canvasPnl.Enabled = False";
mostCurrent._canvaspnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6488081;
 //BA.debugLineNum = 6488081;BA.debugLine="canvasPnl.Visible = False";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6488082;
 //BA.debugLineNum = 6488082;BA.debugLine="End Sub";
return "";
}
public static void  _canvasdrag_placedview(anywheresoftware.b4a.objects.B4XViewWrapper _dragview,anywheresoftware.b4a.objects.B4XViewWrapper _placeview) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvasdrag_placedview", false))
	 {Debug.delegate(mostCurrent.activityBA, "canvasdrag_placedview", new Object[] {_dragview,_placeview}); return;}
ResumableSub_CanvasDrag_PlacedView rsub = new ResumableSub_CanvasDrag_PlacedView(null,_dragview,_placeview);
rsub.resume(processBA, null);
}
public static class ResumableSub_CanvasDrag_PlacedView extends BA.ResumableSub {
public ResumableSub_CanvasDrag_PlacedView(b4a.example.corkactivity parent,anywheresoftware.b4a.objects.B4XViewWrapper _dragview,anywheresoftware.b4a.objects.B4XViewWrapper _placeview) {
this.parent = parent;
this._dragview = _dragview;
this._placeview = _placeview;
}
b4a.example.corkactivity parent;
anywheresoftware.b4a.objects.B4XViewWrapper _dragview;
anywheresoftware.b4a.objects.B4XViewWrapper _placeview;
int _res = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="corkactivity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=7208961;
 //BA.debugLineNum = 7208961;BA.debugLine="If PlaceView = deleteLbl Then";
if (true) break;

case 1:
//if
this.state = 8;
if ((_placeview).equals((java.lang.Object)(parent.mostCurrent._deletelbl.getObject()))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete ca";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete canvas?"),BA.ObjectToCharSequence("Delete Canvas"),"No","","Yes",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7208963;
 //BA.debugLineNum = 7208963;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "canvasdrag_placedview"), null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=7208964;
 //BA.debugLineNum = 7208964;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=7208965;
 //BA.debugLineNum = 7208965;BA.debugLine="DragView.Visible = False";
_dragview.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7208966;
 //BA.debugLineNum = 7208966;BA.debugLine="DragView = Null";
_dragview = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=7208967;
 //BA.debugLineNum = 7208967;BA.debugLine="ToastMessageShow(\"Canvas Deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Canvas Deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
RDebugUtils.currentLine=7208970;
 //BA.debugLineNum = 7208970;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _canvaspanel_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvaspanel_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvaspanel_touch", new Object[] {_action,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub CanvasPanel_Touch (Action As Int, X As Float,";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="Dim p As Panel = Sender";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="Dim cvs As B4XCanvas = p.Tag";
_cvs = (anywheresoftware.b4a.objects.B4XCanvas)(_p.getTag());
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN,mostCurrent._activity.ACTION_MOVE)) {
case 0: {
RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
case 1: {
RDebugUtils.currentLine=6357000;
 //BA.debugLineNum = 6357000;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, Colors.RGB(R2,";
_cvs.DrawLine(_lastx,_lasty,_x,_y,anywheresoftware.b4a.keywords.Common.Colors.RGB(_r2,_g2,_b2),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3))));
RDebugUtils.currentLine=6357001;
 //BA.debugLineNum = 6357001;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
RDebugUtils.currentLine=6357002;
 //BA.debugLineNum = 6357002;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=6357003;
 //BA.debugLineNum = 6357003;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
}
;
RDebugUtils.currentLine=6357005;
 //BA.debugLineNum = 6357005;BA.debugLine="End Sub";
return "";
}
public static String  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cc_result", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cc_result", new Object[] {_success,_dir,_filename}));}
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="imgView.Bitmap = LoadBitmapResize(Dir, FileName,";
mostCurrent._imgview.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapResize(_dir,_filename,mostCurrent._imgview.getWidth(),mostCurrent._imgview.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="ToastMessageShow(\"No image selected\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No image selected"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="End Sub";
return "";
}
public static String  _colorsspnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "colorsspnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "colorsspnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Private Sub colorsSpnr_ItemClick (Position As Int,";
RDebugUtils.currentLine=6946817;
 //BA.debugLineNum = 6946817;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=6946819;
 //BA.debugLineNum = 6946819;BA.debugLine="R = 255";
_r = (int) (255);
RDebugUtils.currentLine=6946820;
 //BA.debugLineNum = 6946820;BA.debugLine="G = 105";
_g = (int) (105);
RDebugUtils.currentLine=6946821;
 //BA.debugLineNum = 6946821;BA.debugLine="B = 97";
_b = (int) (97);
 break; }
case 1: {
RDebugUtils.currentLine=6946823;
 //BA.debugLineNum = 6946823;BA.debugLine="R = 155";
_r = (int) (155);
RDebugUtils.currentLine=6946824;
 //BA.debugLineNum = 6946824;BA.debugLine="G = 190";
_g = (int) (190);
RDebugUtils.currentLine=6946825;
 //BA.debugLineNum = 6946825;BA.debugLine="B = 237";
_b = (int) (237);
 break; }
case 2: {
RDebugUtils.currentLine=6946827;
 //BA.debugLineNum = 6946827;BA.debugLine="R = 248";
_r = (int) (248);
RDebugUtils.currentLine=6946828;
 //BA.debugLineNum = 6946828;BA.debugLine="G = 241";
_g = (int) (241);
RDebugUtils.currentLine=6946829;
 //BA.debugLineNum = 6946829;BA.debugLine="B = 174";
_b = (int) (174);
 break; }
}
;
RDebugUtils.currentLine=6946831;
 //BA.debugLineNum = 6946831;BA.debugLine="End Sub";
return "";
}
public static String  _imgbtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgbtn_click", null));}
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Private Sub imgBtn_Click";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="imgPicker.Show(\"image/*\", \"Select a Photo\")";
_imgpicker.Show(processBA,"image/*","Select a Photo");
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="imgPick";
_imgpick();
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="End Sub";
return "";
}
public static String  _imgpick() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgpick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgpick", null));}
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub imgPick";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="imgView.Initialize(\"ImgView\")";
mostCurrent._imgview.Initialize(mostCurrent.activityBA,"ImgView");
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="boardPnl.AddView(imgView, 150dip, 500dip, 100dip,";
mostCurrent._boardpnl.AddView((android.view.View)(mostCurrent._imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="ddi.AddDragView(imgView, False)";
mostCurrent._ddi._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._imgview.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="ddi.AddPlaceView(place1).AddPlaceView(place2).Add";
mostCurrent._ddi._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place12.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._deletelbl.getObject())));
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="End Sub";
return "";
}
public static void  _imgdrag_placedview(anywheresoftware.b4a.objects.B4XViewWrapper _dragview,anywheresoftware.b4a.objects.B4XViewWrapper _placeview) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgdrag_placedview", false))
	 {Debug.delegate(mostCurrent.activityBA, "imgdrag_placedview", new Object[] {_dragview,_placeview}); return;}
ResumableSub_ImgDrag_PlacedView rsub = new ResumableSub_ImgDrag_PlacedView(null,_dragview,_placeview);
rsub.resume(processBA, null);
}
public static class ResumableSub_ImgDrag_PlacedView extends BA.ResumableSub {
public ResumableSub_ImgDrag_PlacedView(b4a.example.corkactivity parent,anywheresoftware.b4a.objects.B4XViewWrapper _dragview,anywheresoftware.b4a.objects.B4XViewWrapper _placeview) {
this.parent = parent;
this._dragview = _dragview;
this._placeview = _placeview;
}
b4a.example.corkactivity parent;
anywheresoftware.b4a.objects.B4XViewWrapper _dragview;
anywheresoftware.b4a.objects.B4XViewWrapper _placeview;
int _res = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="corkactivity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=7143425;
 //BA.debugLineNum = 7143425;BA.debugLine="If PlaceView = deleteLbl Then";
if (true) break;

case 1:
//if
this.state = 8;
if ((_placeview).equals((java.lang.Object)(parent.mostCurrent._deletelbl.getObject()))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete im";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete image?"),BA.ObjectToCharSequence("Delete Image"),"No","","Yes",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7143427;
 //BA.debugLineNum = 7143427;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "imgdrag_placedview"), null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=7143428;
 //BA.debugLineNum = 7143428;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=7143429;
 //BA.debugLineNum = 7143429;BA.debugLine="DragView.Visible = False";
_dragview.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7143430;
 //BA.debugLineNum = 7143430;BA.debugLine="DragView = Null";
_dragview = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=7143431;
 //BA.debugLineNum = 7143431;BA.debugLine="ToastMessageShow(\"Image Deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Image Deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
RDebugUtils.currentLine=7143434;
 //BA.debugLineNum = 7143434;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _notedrag_placedview(anywheresoftware.b4a.objects.B4XViewWrapper _dragview,anywheresoftware.b4a.objects.B4XViewWrapper _placeview) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "notedrag_placedview", false))
	 {Debug.delegate(mostCurrent.activityBA, "notedrag_placedview", new Object[] {_dragview,_placeview}); return;}
ResumableSub_NoteDrag_PlacedView rsub = new ResumableSub_NoteDrag_PlacedView(null,_dragview,_placeview);
rsub.resume(processBA, null);
}
public static class ResumableSub_NoteDrag_PlacedView extends BA.ResumableSub {
public ResumableSub_NoteDrag_PlacedView(b4a.example.corkactivity parent,anywheresoftware.b4a.objects.B4XViewWrapper _dragview,anywheresoftware.b4a.objects.B4XViewWrapper _placeview) {
this.parent = parent;
this._dragview = _dragview;
this._placeview = _placeview;
}
b4a.example.corkactivity parent;
anywheresoftware.b4a.objects.B4XViewWrapper _dragview;
anywheresoftware.b4a.objects.B4XViewWrapper _placeview;
int _res = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="corkactivity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=7077889;
 //BA.debugLineNum = 7077889;BA.debugLine="If PlaceView = deleteLbl Then";
if (true) break;

case 1:
//if
this.state = 8;
if ((_placeview).equals((java.lang.Object)(parent.mostCurrent._deletelbl.getObject()))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete no";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete note?"),BA.ObjectToCharSequence("Delete Note"),"No","","Yes",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7077891;
 //BA.debugLineNum = 7077891;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "notedrag_placedview"), null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=7077892;
 //BA.debugLineNum = 7077892;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=7077893;
 //BA.debugLineNum = 7077893;BA.debugLine="DragView.Visible = False";
_dragview.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7077894;
 //BA.debugLineNum = 7077894;BA.debugLine="DragView = Null";
_dragview = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=7077895;
 //BA.debugLineNum = 7077895;BA.debugLine="ToastMessageShow(\"Note Deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Note Deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
RDebugUtils.currentLine=7077898;
 //BA.debugLineNum = 7077898;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _notewindow(int _pw,int _ph) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "notewindow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "notewindow", new Object[] {_pw,_ph}));}
anywheresoftware.b4a.objects.SpinnerWrapper _colorsspnr = null;
anywheresoftware.b4a.objects.ButtonWrapper _addnbtn = null;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Private Sub noteWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="notePnl = xui.CreatePanel(\"notePnl\")";
mostCurrent._notepnl = _xui.CreatePanel(processBA,"notePnl");
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="Activity.AddView(notePnl, 100dip, 225dip, pW, pH)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._notepnl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (225)),_pw,_ph);
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="notePnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._notepnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="notePnl.SetColorAndBorder(xui.Color_White, 2dip,";
mostCurrent._notepnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=6422534;
 //BA.debugLineNum = 6422534;BA.debugLine="Dim colorsSpnr As Spinner";
_colorsspnr = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="colorsSpnr.Initialize(\"colorsSpnr\")";
_colorsspnr.Initialize(mostCurrent.activityBA,"colorsSpnr");
RDebugUtils.currentLine=6422536;
 //BA.debugLineNum = 6422536;BA.debugLine="colorsSpnr.AddAll(Array As String(\"Red\", \"Blue\",";
_colorsspnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Red","Blue","Yellow"}));
RDebugUtils.currentLine=6422537;
 //BA.debugLineNum = 6422537;BA.debugLine="notePnl.AddView(colorsSpnr, 10dip, 10dip, pW - 20";
mostCurrent._notepnl.AddView((android.view.View)(_colorsspnr.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_pw-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=6422539;
 //BA.debugLineNum = 6422539;BA.debugLine="Dim addnBtn As Button";
_addnbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=6422540;
 //BA.debugLineNum = 6422540;BA.debugLine="addnBtn.Initialize(\"addnBtn\")";
_addnbtn.Initialize(mostCurrent.activityBA,"addnBtn");
RDebugUtils.currentLine=6422541;
 //BA.debugLineNum = 6422541;BA.debugLine="addnBtn.Text = \"Add Note\"";
_addnbtn.setText(BA.ObjectToCharSequence("Add Note"));
RDebugUtils.currentLine=6422542;
 //BA.debugLineNum = 6422542;BA.debugLine="notePnl.AddView(addnBtn, 10dip, 60dip, (pW / 2) -";
mostCurrent._notepnl.AddView((android.view.View)(_addnbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),(int) ((_pw/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=6422544;
 //BA.debugLineNum = 6422544;BA.debugLine="notePnl.Enabled = False";
mostCurrent._notepnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6422545;
 //BA.debugLineNum = 6422545;BA.debugLine="notePnl.Visible = False";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6422546;
 //BA.debugLineNum = 6422546;BA.debugLine="End Sub";
return "";
}
public static String  _penspnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "penspnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "penspnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Private Sub penSpnr_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=7012353;
 //BA.debugLineNum = 7012353;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=7012355;
 //BA.debugLineNum = 7012355;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=7012356;
 //BA.debugLineNum = 7012356;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=7012357;
 //BA.debugLineNum = 7012357;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 1: {
RDebugUtils.currentLine=7012359;
 //BA.debugLineNum = 7012359;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=7012360;
 //BA.debugLineNum = 7012360;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=7012361;
 //BA.debugLineNum = 7012361;BA.debugLine="B2 = 255";
_b2 = (int) (255);
 break; }
case 2: {
RDebugUtils.currentLine=7012363;
 //BA.debugLineNum = 7012363;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=7012364;
 //BA.debugLineNum = 7012364;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=7012365;
 //BA.debugLineNum = 7012365;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 3: {
RDebugUtils.currentLine=7012367;
 //BA.debugLineNum = 7012367;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=7012368;
 //BA.debugLineNum = 7012368;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=7012369;
 //BA.debugLineNum = 7012369;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 4: {
RDebugUtils.currentLine=7012371;
 //BA.debugLineNum = 7012371;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=7012372;
 //BA.debugLineNum = 7012372;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=7012373;
 //BA.debugLineNum = 7012373;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 5: {
RDebugUtils.currentLine=7012375;
 //BA.debugLineNum = 7012375;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=7012376;
 //BA.debugLineNum = 7012376;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=7012377;
 //BA.debugLineNum = 7012377;BA.debugLine="B2 = 255";
_b2 = (int) (255);
 break; }
}
;
RDebugUtils.currentLine=7012379;
 //BA.debugLineNum = 7012379;BA.debugLine="End Sub";
return "";
}
public static String  _sizespnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sizespnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sizespnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Private Sub sizeSpnr_ItemClick (Position As Int, V";
RDebugUtils.currentLine=6881281;
 //BA.debugLineNum = 6881281;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=6881283;
 //BA.debugLineNum = 6881283;BA.debugLine="Width = 80dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=6881284;
 //BA.debugLineNum = 6881284;BA.debugLine="Height = 60dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
 break; }
case 1: {
RDebugUtils.currentLine=6881286;
 //BA.debugLineNum = 6881286;BA.debugLine="Width = 205dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (205));
RDebugUtils.currentLine=6881287;
 //BA.debugLineNum = 6881287;BA.debugLine="Height = 60dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
 break; }
case 2: {
RDebugUtils.currentLine=6881289;
 //BA.debugLineNum = 6881289;BA.debugLine="Width = 80dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=6881290;
 //BA.debugLineNum = 6881290;BA.debugLine="Height = 185dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (185));
 break; }
case 3: {
RDebugUtils.currentLine=6881292;
 //BA.debugLineNum = 6881292;BA.debugLine="Width = 205dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (205));
RDebugUtils.currentLine=6881293;
 //BA.debugLineNum = 6881293;BA.debugLine="Height = 185dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (185));
 break; }
case 4: {
RDebugUtils.currentLine=6881295;
 //BA.debugLineNum = 6881295;BA.debugLine="Width = 330dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (330));
RDebugUtils.currentLine=6881296;
 //BA.debugLineNum = 6881296;BA.debugLine="Height = 185dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (185));
 break; }
case 5: {
RDebugUtils.currentLine=6881298;
 //BA.debugLineNum = 6881298;BA.debugLine="Width = 205dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (205));
RDebugUtils.currentLine=6881299;
 //BA.debugLineNum = 6881299;BA.debugLine="Height = 310dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (310));
 break; }
}
;
RDebugUtils.currentLine=6881301;
 //BA.debugLineNum = 6881301;BA.debugLine="End Sub";
return "";
}
public static String  _stickybtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "stickybtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "stickybtn_click", null));}
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Private Sub stickyBtn_Click";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="noteWindow(250dip, 180dip)";
_notewindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="notePnl.Visible = True";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="stickyBtn.Enabled = False";
mostCurrent._stickybtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="End Sub";
return "";
}
}