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
public anywheresoftware.b4a.objects.LabelWrapper _deletelbl = null;
public static int _r = 0;
public static int _g = 0;
public static int _b = 0;
public static int _r2 = 0;
public static int _g2 = 0;
public static int _b2 = 0;
public anywheresoftware.b4a.objects.SpinnerWrapper _penspnr = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _sizespnr = null;
public static int _width = 0;
public static int _height = 0;
public b4a.example.dragdropview _ddn = null;
public b4a.example.dragdropview _ddi = null;
public b4a.example.dragdropview _ddc = null;
public static int _notecount = 0;
public static int _imgcount = 0;
public static int _canvascount = 0;
public static boolean _isloading = false;
public b4a.example.main _main = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.themeactivity _themeactivity = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.card_module _card_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.starter _starter = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.todoactivity _todoactivity = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public static void  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}); return;}
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(b4a.example.corkactivity parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
b4a.example.corkactivity parent;
boolean _firsttime;
int _loadednotecount = 0;
int _i = 0;
String _nkey = "";
int _savedcolor = 0;
int _loadedimgcount = 0;
String _ikey = "";
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
int _loadedcanvascount = 0;
String _ckey = "";
anywheresoftware.b4a.objects.PanelWrapper _f = null;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _canvasrect = null;
int step22;
int limit22;
int step35;
int limit35;
int step49;
int limit49;

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
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="If Starter.darkMode = False Then";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=5636099;
 //BA.debugLineNum = 5636099;BA.debugLine="Activity.LoadLayout(\"corkboardLayout\")";
parent.mostCurrent._activity.LoadLayout("corkboardLayout",mostCurrent.activityBA);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=5636101;
 //BA.debugLineNum = 5636101;BA.debugLine="Activity.LoadLayout(\"corkboardLayoutDark\")";
parent.mostCurrent._activity.LoadLayout("corkboardLayoutDark",mostCurrent.activityBA);
 if (true) break;

case 6:
//C
this.state = 7;
;
RDebugUtils.currentLine=5636104;
 //BA.debugLineNum = 5636104;BA.debugLine="penSpnr.AddAll(Array As String(\"Black\", \"Blue\", \"";
parent.mostCurrent._penspnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Black","Blue","Green","Red","Yellow","Eraser"}));
RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="If FirstTime Then";
if (true) break;

case 7:
//if
this.state = 10;
if (_firsttime) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=5636106;
 //BA.debugLineNum = 5636106;BA.debugLine="imgPicker.Initialize(\"CC\")";
parent._imgpicker.Initialize("CC");
 if (true) break;

case 10:
//C
this.state = 11;
;
RDebugUtils.currentLine=5636108;
 //BA.debugLineNum = 5636108;BA.debugLine="penSpnr.Visible = False";
parent.mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636109;
 //BA.debugLineNum = 5636109;BA.debugLine="Width = 80dip";
parent._width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=5636110;
 //BA.debugLineNum = 5636110;BA.debugLine="Height = 60dip";
parent._height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
RDebugUtils.currentLine=5636111;
 //BA.debugLineNum = 5636111;BA.debugLine="ddn.Initialize(Me, \"NoteDrag\")";
parent.mostCurrent._ddn._initialize(processBA,corkactivity.getObject(),"NoteDrag");
RDebugUtils.currentLine=5636112;
 //BA.debugLineNum = 5636112;BA.debugLine="ddi.Initialize(Me, \"ImgDrag\")";
parent.mostCurrent._ddi._initialize(processBA,corkactivity.getObject(),"ImgDrag");
RDebugUtils.currentLine=5636113;
 //BA.debugLineNum = 5636113;BA.debugLine="ddc.Initialize(Me, \"CanvasDrag\")";
parent.mostCurrent._ddc._initialize(processBA,corkactivity.getObject(),"CanvasDrag");
RDebugUtils.currentLine=5636115;
 //BA.debugLineNum = 5636115;BA.debugLine="If Main.kvs.IsInitialized = False Then";
if (true) break;

case 11:
//if
this.state = 14;
if (parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
RDebugUtils.currentLine=5636116;
 //BA.debugLineNum = 5636116;BA.debugLine="Main.kvs.Initialize(File.DirInternal, \"notes_dat";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"notes_data");
 if (true) break;

case 14:
//C
this.state = 15;
;
RDebugUtils.currentLine=5636119;
 //BA.debugLineNum = 5636119;BA.debugLine="isLoading = True";
parent._isloading = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=5636121;
 //BA.debugLineNum = 5636121;BA.debugLine="If Main.kvs.ContainsKey(\"note_count\") Then noteCo";
if (true) break;

case 15:
//if
this.state = 22;
if (parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._containskey("note_count")) { 
this.state = 17;
;}
else {
this.state = 19;
;}if (true) break;

case 17:
//C
this.state = 22;
parent._notecount = (int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get("note_count")));
if (true) break;

case 19:
//C
this.state = 22;
parent._notecount = (int) (0);
if (true) break;

case 22:
//C
this.state = 23;
;
RDebugUtils.currentLine=5636122;
 //BA.debugLineNum = 5636122;BA.debugLine="Dim loadedNoteCount As Int = noteCount";
_loadednotecount = parent._notecount;
RDebugUtils.currentLine=5636123;
 //BA.debugLineNum = 5636123;BA.debugLine="For i = 0 To loadedNoteCount - 1";
if (true) break;

case 23:
//for
this.state = 30;
step22 = 1;
limit22 = (int) (_loadednotecount-1);
_i = (int) (0) ;
this.state = 65;
if (true) break;

case 65:
//C
this.state = 30;
if ((step22 > 0 && _i <= limit22) || (step22 < 0 && _i >= limit22)) this.state = 25;
if (true) break;

case 66:
//C
this.state = 65;
_i = ((int)(0 + _i + step22)) ;
if (true) break;

case 25:
//C
this.state = 26;
RDebugUtils.currentLine=5636124;
 //BA.debugLineNum = 5636124;BA.debugLine="Dim nkey As String = \"note_\" & i";
_nkey = "note_"+BA.NumberToString(_i);
RDebugUtils.currentLine=5636125;
 //BA.debugLineNum = 5636125;BA.debugLine="If Main.kvs.ContainsKey(nkey & \"_text\") Then";
if (true) break;

case 26:
//if
this.state = 29;
if (parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._containskey(_nkey+"_text")) { 
this.state = 28;
}if (true) break;

case 28:
//C
this.state = 29;
RDebugUtils.currentLine=5636126;
 //BA.debugLineNum = 5636126;BA.debugLine="Dim savedColor As Int = Main.kvs.Get(nkey & \"_c";
_savedcolor = (int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_nkey+"_color")));
RDebugUtils.currentLine=5636127;
 //BA.debugLineNum = 5636127;BA.debugLine="R = Bit.And(Bit.ShiftRight(savedColor, 16), 0xF";
parent._r = anywheresoftware.b4a.keywords.Common.Bit.And(anywheresoftware.b4a.keywords.Common.Bit.ShiftRight(_savedcolor,(int) (16)),((int)0xff));
RDebugUtils.currentLine=5636128;
 //BA.debugLineNum = 5636128;BA.debugLine="G = Bit.And(Bit.ShiftRight(savedColor, 8), 0xFF";
parent._g = anywheresoftware.b4a.keywords.Common.Bit.And(anywheresoftware.b4a.keywords.Common.Bit.ShiftRight(_savedcolor,(int) (8)),((int)0xff));
RDebugUtils.currentLine=5636129;
 //BA.debugLineNum = 5636129;BA.debugLine="B = Bit.And(savedColor, 0xFF)";
parent._b = anywheresoftware.b4a.keywords.Common.Bit.And(_savedcolor,((int)0xff));
RDebugUtils.currentLine=5636130;
 //BA.debugLineNum = 5636130;BA.debugLine="noteCount = i + 1";
parent._notecount = (int) (_i+1);
RDebugUtils.currentLine=5636131;
 //BA.debugLineNum = 5636131;BA.debugLine="AddStickyNote(Main.kvs.Get(nkey & \"_text\"), Mai";
_addstickynote(BA.ObjectToString(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_nkey+"_text")),(int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_nkey+"_x"))),(int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_nkey+"_y"))));
 if (true) break;

case 29:
//C
this.state = 66;
;
 if (true) break;
if (true) break;
;
RDebugUtils.currentLine=5636135;
 //BA.debugLineNum = 5636135;BA.debugLine="If Main.kvs.ContainsKey(\"img_count\") Then imgCoun";

case 30:
//if
this.state = 37;
if (parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._containskey("img_count")) { 
this.state = 32;
;}
else {
this.state = 34;
;}if (true) break;

case 32:
//C
this.state = 37;
parent._imgcount = (int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get("img_count")));
if (true) break;

case 34:
//C
this.state = 37;
parent._imgcount = (int) (0);
if (true) break;

case 37:
//C
this.state = 38;
;
RDebugUtils.currentLine=5636136;
 //BA.debugLineNum = 5636136;BA.debugLine="Dim loadedImgCount As Int = imgCount";
_loadedimgcount = parent._imgcount;
RDebugUtils.currentLine=5636137;
 //BA.debugLineNum = 5636137;BA.debugLine="For i = 0 To loadedImgCount - 1";
if (true) break;

case 38:
//for
this.state = 45;
step35 = 1;
limit35 = (int) (_loadedimgcount-1);
_i = (int) (0) ;
this.state = 67;
if (true) break;

case 67:
//C
this.state = 45;
if ((step35 > 0 && _i <= limit35) || (step35 < 0 && _i >= limit35)) this.state = 40;
if (true) break;

case 68:
//C
this.state = 67;
_i = ((int)(0 + _i + step35)) ;
if (true) break;

case 40:
//C
this.state = 41;
RDebugUtils.currentLine=5636138;
 //BA.debugLineNum = 5636138;BA.debugLine="Dim ikey As String = \"img_\" & i";
_ikey = "img_"+BA.NumberToString(_i);
RDebugUtils.currentLine=5636139;
 //BA.debugLineNum = 5636139;BA.debugLine="If Main.kvs.ContainsKey(ikey & \"_file\") Then";
if (true) break;

case 41:
//if
this.state = 44;
if (parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._containskey(_ikey+"_file")) { 
this.state = 43;
}if (true) break;

case 43:
//C
this.state = 44;
RDebugUtils.currentLine=5636140;
 //BA.debugLineNum = 5636140;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=5636141;
 //BA.debugLineNum = 5636141;BA.debugLine="iv.Initialize(\"ImgView\")";
_iv.Initialize(mostCurrent.activityBA,"ImgView");
RDebugUtils.currentLine=5636142;
 //BA.debugLineNum = 5636142;BA.debugLine="boardPnl.AddView(iv, Main.kvs.Get(ikey & \"_x\"),";
parent.mostCurrent._boardpnl.AddView((android.view.View)(_iv.getObject()),(int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_ikey+"_x"))),(int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_ikey+"_y"))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=5636143;
 //BA.debugLineNum = 5636143;BA.debugLine="iv.Bitmap = LoadBitmapResize(File.DirInternal,";
_iv.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_ikey+"_file")),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=5636144;
 //BA.debugLineNum = 5636144;BA.debugLine="iv.Tag = ikey";
_iv.setTag((Object)(_ikey));
RDebugUtils.currentLine=5636145;
 //BA.debugLineNum = 5636145;BA.debugLine="ddi.AddDragView(iv, False)";
parent.mostCurrent._ddi._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_iv.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636146;
 //BA.debugLineNum = 5636146;BA.debugLine="ddi.AddPlaceView(place1).AddPlaceView(place2).A";
parent.mostCurrent._ddi._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place12.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._deletelbl.getObject())));
 if (true) break;

case 44:
//C
this.state = 68;
;
 if (true) break;
if (true) break;
;
RDebugUtils.currentLine=5636150;
 //BA.debugLineNum = 5636150;BA.debugLine="If Main.kvs.ContainsKey(\"cvs_count\") Then canvasC";

case 45:
//if
this.state = 52;
if (parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._containskey("cvs_count")) { 
this.state = 47;
;}
else {
this.state = 49;
;}if (true) break;

case 47:
//C
this.state = 52;
parent._canvascount = (int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get("cvs_count")));
if (true) break;

case 49:
//C
this.state = 52;
parent._canvascount = (int) (0);
if (true) break;

case 52:
//C
this.state = 53;
;
RDebugUtils.currentLine=5636151;
 //BA.debugLineNum = 5636151;BA.debugLine="Dim loadedCanvasCount As Int = canvasCount";
_loadedcanvascount = parent._canvascount;
RDebugUtils.currentLine=5636152;
 //BA.debugLineNum = 5636152;BA.debugLine="For i = 0 To loadedCanvasCount - 1";
if (true) break;

case 53:
//for
this.state = 64;
step49 = 1;
limit49 = (int) (_loadedcanvascount-1);
_i = (int) (0) ;
this.state = 69;
if (true) break;

case 69:
//C
this.state = 64;
if ((step49 > 0 && _i <= limit49) || (step49 < 0 && _i >= limit49)) this.state = 55;
if (true) break;

case 70:
//C
this.state = 69;
_i = ((int)(0 + _i + step49)) ;
if (true) break;

case 55:
//C
this.state = 56;
RDebugUtils.currentLine=5636153;
 //BA.debugLineNum = 5636153;BA.debugLine="Dim ckey As String = \"cvs_\" & i";
_ckey = "cvs_"+BA.NumberToString(_i);
RDebugUtils.currentLine=5636154;
 //BA.debugLineNum = 5636154;BA.debugLine="If Main.kvs.ContainsKey(ckey & \"_x\") Then";
if (true) break;

case 56:
//if
this.state = 63;
if (parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._containskey(_ckey+"_x")) { 
this.state = 58;
}if (true) break;

case 58:
//C
this.state = 59;
RDebugUtils.currentLine=5636155;
 //BA.debugLineNum = 5636155;BA.debugLine="Width = Main.kvs.Get(ckey & \"_w\")";
parent._width = (int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_ckey+"_w")));
RDebugUtils.currentLine=5636156;
 //BA.debugLineNum = 5636156;BA.debugLine="Height = Main.kvs.Get(ckey & \"_h\")";
parent._height = (int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_ckey+"_h")));
RDebugUtils.currentLine=5636158;
 //BA.debugLineNum = 5636158;BA.debugLine="Dim f As Panel";
_f = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5636159;
 //BA.debugLineNum = 5636159;BA.debugLine="f.Initialize(\"CanvasFrame\")";
_f.Initialize(mostCurrent.activityBA,"CanvasFrame");
RDebugUtils.currentLine=5636160;
 //BA.debugLineNum = 5636160;BA.debugLine="f.Color = Colors.Black";
_f.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5636161;
 //BA.debugLineNum = 5636161;BA.debugLine="boardPnl.AddView(f, Main.kvs.Get(ckey & \"_x\"),";
parent.mostCurrent._boardpnl.AddView((android.view.View)(_f.getObject()),(int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_ckey+"_x"))),(int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get(_ckey+"_y"))),(int) (parent._width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (parent._height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))));
RDebugUtils.currentLine=5636162;
 //BA.debugLineNum = 5636162;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5636163;
 //BA.debugLineNum = 5636163;BA.debugLine="p.Initialize(\"CanvasPanel\")";
_p.Initialize(mostCurrent.activityBA,"CanvasPanel");
RDebugUtils.currentLine=5636164;
 //BA.debugLineNum = 5636164;BA.debugLine="p.Color = Colors.White";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=5636165;
 //BA.debugLineNum = 5636165;BA.debugLine="f.AddView(p, 10dip, 20dip, Width, Height)";
_f.AddView((android.view.View)(_p.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),parent._width,parent._height);
RDebugUtils.currentLine=5636166;
 //BA.debugLineNum = 5636166;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "activity_create"),(int) (0));
this.state = 71;
return;
case 71:
//C
this.state = 59;
;
RDebugUtils.currentLine=5636167;
 //BA.debugLineNum = 5636167;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=5636168;
 //BA.debugLineNum = 5636168;BA.debugLine="cvs.Initialize(p)";
_cvs.Initialize((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())));
RDebugUtils.currentLine=5636169;
 //BA.debugLineNum = 5636169;BA.debugLine="cvs.DrawRect(cvs.TargetRect, Colors.LightGray,";
_cvs.DrawRect(_cvs.getTargetRect(),anywheresoftware.b4a.keywords.Common.Colors.LightGray,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=5636170;
 //BA.debugLineNum = 5636170;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
RDebugUtils.currentLine=5636171;
 //BA.debugLineNum = 5636171;BA.debugLine="p.Tag = cvs";
_p.setTag((Object)(_cvs));
RDebugUtils.currentLine=5636172;
 //BA.debugLineNum = 5636172;BA.debugLine="ddc.AddDragView(f, False)";
parent.mostCurrent._ddc._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_f.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636173;
 //BA.debugLineNum = 5636173;BA.debugLine="ddc.AddPlaceView(place1).AddPlaceView(place2).A";
parent.mostCurrent._ddc._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place12.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._deletelbl.getObject())));
RDebugUtils.currentLine=5636174;
 //BA.debugLineNum = 5636174;BA.debugLine="f.Tag = ckey";
_f.setTag((Object)(_ckey));
RDebugUtils.currentLine=5636176;
 //BA.debugLineNum = 5636176;BA.debugLine="If File.Exists(File.DirInternal, ckey & \".png\")";
if (true) break;

case 59:
//if
this.state = 62;
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_ckey+".png")) { 
this.state = 61;
}if (true) break;

case 61:
//C
this.state = 62;
RDebugUtils.currentLine=5636177;
 //BA.debugLineNum = 5636177;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "activity_create"),(int) (0));
this.state = 72;
return;
case 72:
//C
this.state = 62;
;
RDebugUtils.currentLine=5636178;
 //BA.debugLineNum = 5636178;BA.debugLine="Dim bmp As Bitmap = LoadBitmap(File.DirInterna";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_ckey+".png");
RDebugUtils.currentLine=5636179;
 //BA.debugLineNum = 5636179;BA.debugLine="Dim canvasRect As B4XRect = cvs.TargetRect";
_canvasrect = _cvs.getTargetRect();
RDebugUtils.currentLine=5636180;
 //BA.debugLineNum = 5636180;BA.debugLine="cvs.DrawBitmap(bmp, canvasRect)";
_cvs.DrawBitmap((android.graphics.Bitmap)(_bmp.getObject()),_canvasrect);
RDebugUtils.currentLine=5636181;
 //BA.debugLineNum = 5636181;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
 if (true) break;

case 62:
//C
this.state = 63;
;
 if (true) break;

case 63:
//C
this.state = 70;
;
 if (true) break;
if (true) break;

case 64:
//C
this.state = -1;
;
RDebugUtils.currentLine=5636185;
 //BA.debugLineNum = 5636185;BA.debugLine="canvasCount = loadedCanvasCount";
parent._canvascount = _loadedcanvascount;
RDebugUtils.currentLine=5636186;
 //BA.debugLineNum = 5636186;BA.debugLine="Width = 80dip";
parent._width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=5636187;
 //BA.debugLineNum = 5636187;BA.debugLine="Height = 60dip";
parent._height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
RDebugUtils.currentLine=5636188;
 //BA.debugLineNum = 5636188;BA.debugLine="isLoading = False";
parent._isloading = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=5636189;
 //BA.debugLineNum = 5636189;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _addstickynote(String _text,int _x,int _y) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addstickynote", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addstickynote", new Object[] {_text,_x,_y}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.EditTextWrapper _txt = null;
String _key = "";
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="p.Initialize(\"NotePanel\")";
_p.Initialize(mostCurrent.activityBA,"NotePanel");
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="p.Color = Colors.RGB(R, G, B)";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB(_r,_g,_b));
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="Dim txt As EditText";
_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=5832710;
 //BA.debugLineNum = 5832710;BA.debugLine="txt.Initialize(\"NoteText\")";
_txt.Initialize(mostCurrent.activityBA,"NoteText");
RDebugUtils.currentLine=5832711;
 //BA.debugLineNum = 5832711;BA.debugLine="txt.Tag = p";
_txt.setTag((Object)(_p.getObject()));
RDebugUtils.currentLine=5832712;
 //BA.debugLineNum = 5832712;BA.debugLine="txt.Text = Text";
_txt.setText(BA.ObjectToCharSequence(_text));
RDebugUtils.currentLine=5832713;
 //BA.debugLineNum = 5832713;BA.debugLine="txt.TextSize = 12";
_txt.setTextSize((float) (12));
RDebugUtils.currentLine=5832714;
 //BA.debugLineNum = 5832714;BA.debugLine="txt.Background = Null";
_txt.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=5832715;
 //BA.debugLineNum = 5832715;BA.debugLine="txt.TextColor = Colors.Black";
_txt.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=5832716;
 //BA.debugLineNum = 5832716;BA.debugLine="txt.Gravity = Gravity.TOP";
_txt.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.TOP);
RDebugUtils.currentLine=5832718;
 //BA.debugLineNum = 5832718;BA.debugLine="p.AddView(txt, 5dip, 15dip, 90dip, 70dip)";
_p.AddView((android.view.View)(_txt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=5832720;
 //BA.debugLineNum = 5832720;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
mostCurrent._boardpnl.AddView((android.view.View)(_p.getObject()),_x,_y,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=5832722;
 //BA.debugLineNum = 5832722;BA.debugLine="ddn.AddDragView(p, False)";
mostCurrent._ddn._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5832723;
 //BA.debugLineNum = 5832723;BA.debugLine="ddn.AddPlaceView(place1).AddPlaceView(place2).Add";
mostCurrent._ddn._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place12.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._deletelbl.getObject())));
RDebugUtils.currentLine=5832725;
 //BA.debugLineNum = 5832725;BA.debugLine="If isLoading = False Then";
if (_isloading==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=5832726;
 //BA.debugLineNum = 5832726;BA.debugLine="Dim key As String = \"note_\" & noteCount";
_key = "note_"+BA.NumberToString(_notecount);
RDebugUtils.currentLine=5832727;
 //BA.debugLineNum = 5832727;BA.debugLine="Main.kvs.Put(key & \"_text\", Text)";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_text",(Object)(_text));
RDebugUtils.currentLine=5832728;
 //BA.debugLineNum = 5832728;BA.debugLine="Main.kvs.Put(key & \"_color\", Colors.RGB(R, G, B)";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_color",(Object)(anywheresoftware.b4a.keywords.Common.Colors.RGB(_r,_g,_b)));
RDebugUtils.currentLine=5832729;
 //BA.debugLineNum = 5832729;BA.debugLine="Main.kvs.Put(key & \"_x\", x)";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_x",(Object)(_x));
RDebugUtils.currentLine=5832730;
 //BA.debugLineNum = 5832730;BA.debugLine="Main.kvs.Put(key & \"_y\", y)";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_y",(Object)(_y));
RDebugUtils.currentLine=5832731;
 //BA.debugLineNum = 5832731;BA.debugLine="Main.kvs.Put(\"note_count\", noteCount + 1)";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put("note_count",(Object)(_notecount+1));
RDebugUtils.currentLine=5832732;
 //BA.debugLineNum = 5832732;BA.debugLine="p.Tag = key";
_p.setTag((Object)(_key));
RDebugUtils.currentLine=5832733;
 //BA.debugLineNum = 5832733;BA.debugLine="noteCount = noteCount + 1";
_notecount = (int) (_notecount+1);
 }else {
RDebugUtils.currentLine=5832735;
 //BA.debugLineNum = 5832735;BA.debugLine="p.Tag = \"note_\" & (noteCount - 1)";
_p.setTag((Object)("note_"+BA.NumberToString((_notecount-1))));
 };
RDebugUtils.currentLine=5832737;
 //BA.debugLineNum = 5832737;BA.debugLine="Log(\"deleteLbl initialized: \" & (deleteLbl.IsInit";
anywheresoftware.b4a.keywords.Common.LogImpl("65832737","deleteLbl initialized: "+BA.ObjectToString((mostCurrent._deletelbl.IsInitialized())),0);
RDebugUtils.currentLine=5832738;
 //BA.debugLineNum = 5832738;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="corkactivity";
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="If canvasCount > 0 Then";
if (_canvascount>0) { 
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="penSpnr.Visible = True";
mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="End Sub";
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
String _key = "";

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
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Dim f As Panel";
_f = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="f.Initialize(\"CanvasFrame\")";
_f.Initialize(mostCurrent.activityBA,"CanvasFrame");
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="f.Color = Colors.Black";
_f.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="boardPnl.AddView(f, x, y, Width + 20dip, Height +";
parent.mostCurrent._boardpnl.AddView((android.view.View)(_f.getObject()),_x,_y,(int) (parent._width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (parent._height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))));
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=6029319;
 //BA.debugLineNum = 6029319;BA.debugLine="p.Initialize(\"CanvasPanel\")";
_p.Initialize(mostCurrent.activityBA,"CanvasPanel");
RDebugUtils.currentLine=6029320;
 //BA.debugLineNum = 6029320;BA.debugLine="p.Color = Colors.White";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=6029321;
 //BA.debugLineNum = 6029321;BA.debugLine="f.AddView(p, 10dip, 20dip, Width, Height)";
_f.AddView((android.view.View)(_p.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),parent._width,parent._height);
RDebugUtils.currentLine=6029323;
 //BA.debugLineNum = 6029323;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "addcanvas"),(int) (0));
this.state = 7;
return;
case 7:
//C
this.state = 1;
;
RDebugUtils.currentLine=6029325;
 //BA.debugLineNum = 6029325;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=6029326;
 //BA.debugLineNum = 6029326;BA.debugLine="cvs.Initialize(p)";
_cvs.Initialize((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())));
RDebugUtils.currentLine=6029327;
 //BA.debugLineNum = 6029327;BA.debugLine="cvs.DrawRect(cvs.TargetRect, Colors.LightGray, Fa";
_cvs.DrawRect(_cvs.getTargetRect(),anywheresoftware.b4a.keywords.Common.Colors.LightGray,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=6029328;
 //BA.debugLineNum = 6029328;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
RDebugUtils.currentLine=6029329;
 //BA.debugLineNum = 6029329;BA.debugLine="p.Tag = cvs";
_p.setTag((Object)(_cvs));
RDebugUtils.currentLine=6029331;
 //BA.debugLineNum = 6029331;BA.debugLine="ddc.AddDragView(f, False)";
parent.mostCurrent._ddc._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_f.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6029332;
 //BA.debugLineNum = 6029332;BA.debugLine="ddc.AddPlaceView(place1).AddPlaceView(place2).Add";
parent.mostCurrent._ddc._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._place12.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(parent.mostCurrent._deletelbl.getObject())));
RDebugUtils.currentLine=6029333;
 //BA.debugLineNum = 6029333;BA.debugLine="If isLoading = False Then";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._isloading==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=6029334;
 //BA.debugLineNum = 6029334;BA.debugLine="Dim key As String = \"cvs_\" & canvasCount";
_key = "cvs_"+BA.NumberToString(parent._canvascount);
RDebugUtils.currentLine=6029335;
 //BA.debugLineNum = 6029335;BA.debugLine="Main.kvs.Put(key & \"_x\", x)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_x",(Object)(_x));
RDebugUtils.currentLine=6029336;
 //BA.debugLineNum = 6029336;BA.debugLine="Main.kvs.Put(key & \"_y\", y)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_y",(Object)(_y));
RDebugUtils.currentLine=6029337;
 //BA.debugLineNum = 6029337;BA.debugLine="Main.kvs.Put(key & \"_w\", Width)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_w",(Object)(parent._width));
RDebugUtils.currentLine=6029338;
 //BA.debugLineNum = 6029338;BA.debugLine="Main.kvs.Put(key & \"_h\", Height)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_h",(Object)(parent._height));
RDebugUtils.currentLine=6029339;
 //BA.debugLineNum = 6029339;BA.debugLine="Main.kvs.Put(\"cvs_count\", canvasCount + 1)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put("cvs_count",(Object)(parent._canvascount+1));
RDebugUtils.currentLine=6029340;
 //BA.debugLineNum = 6029340;BA.debugLine="f.Tag = key";
_f.setTag((Object)(_key));
RDebugUtils.currentLine=6029341;
 //BA.debugLineNum = 6029341;BA.debugLine="canvasCount = canvasCount + 1";
parent._canvascount = (int) (parent._canvascount+1);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=6029343;
 //BA.debugLineNum = 6029343;BA.debugLine="f.Tag = \"cvs_\" & (canvasCount - 1)";
_f.setTag((Object)("cvs_"+BA.NumberToString((parent._canvascount-1))));
 if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=6029345;
 //BA.debugLineNum = 6029345;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _addcbtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addcbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addcbtn_click", null));}
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Private Sub addcBtn_Click";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="AddCanvas(150dip, 500dip)";
_addcanvas(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="canvasPnl.Visible = False";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="canvaBtn.Enabled = True";
mostCurrent._canvabtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="stickyBtn.Enabled = True";
mostCurrent._stickybtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="imgBtn.Enabled = True";
mostCurrent._imgbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="End Sub";
return "";
}
public static String  _addnbtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addnbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addnbtn_click", null));}
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Private Sub addnBtn_Click";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="AddStickyNote(\"\", 150dip, 500dip)";
_addstickynote("",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="notePnl.Visible = False";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="R = 255";
_r = (int) (255);
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="G = 105";
_g = (int) (105);
RDebugUtils.currentLine=6291461;
 //BA.debugLineNum = 6291461;BA.debugLine="B = 97";
_b = (int) (97);
RDebugUtils.currentLine=6291462;
 //BA.debugLineNum = 6291462;BA.debugLine="stickyBtn.Enabled = True";
mostCurrent._stickybtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="canvaBtn.Enabled = True";
mostCurrent._canvabtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="imgBtn.Enabled = True";
mostCurrent._imgbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6291465;
 //BA.debugLineNum = 6291465;BA.debugLine="End Sub";
return "";
}
public static String  _canvabtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvabtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvabtn_click", null));}
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Private Sub canvaBtn_Click";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="canvasWindow(250dip, 180dip)";
_canvaswindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="canvasPnl.Visible = True";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="penSpnr.Visible = True";
mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="stickyBtn.Enabled = False";
mostCurrent._stickybtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6553605;
 //BA.debugLineNum = 6553605;BA.debugLine="canvaBtn.Enabled = False";
mostCurrent._canvabtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6553606;
 //BA.debugLineNum = 6553606;BA.debugLine="imgBtn.Enabled = False";
mostCurrent._imgbtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6553607;
 //BA.debugLineNum = 6553607;BA.debugLine="End Sub";
return "";
}
public static String  _canvaswindow(int _pw,int _ph) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvaswindow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "canvaswindow", new Object[] {_pw,_ph}));}
anywheresoftware.b4a.objects.ButtonWrapper _addcbtn = null;
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Private Sub canvasWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="canvasPnl = xui.CreatePanel(\"canvasPanel\")";
mostCurrent._canvaspnl = _xui.CreatePanel(processBA,"canvasPanel");
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="Activity.AddView(canvasPnl, 100dip, 225dip, pW, p";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._canvaspnl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (225)),_pw,_ph);
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="canvasPnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._canvaspnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="canvasPnl.SetColorAndBorder(xui.Color_White, 2dip";
mostCurrent._canvaspnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="sizeSpnr.Initialize(\"sizeSpnr\")";
mostCurrent._sizespnr.Initialize(mostCurrent.activityBA,"sizeSpnr");
RDebugUtils.currentLine=6225928;
 //BA.debugLineNum = 6225928;BA.debugLine="sizeSpnr.AddAll(Array As String(\"1x1\", \"2x1\", \"1x";
mostCurrent._sizespnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"1x1","2x1","1x2","2x2","3x2","2x3"}));
RDebugUtils.currentLine=6225929;
 //BA.debugLineNum = 6225929;BA.debugLine="canvasPnl.AddView(sizeSpnr, 10dip, 10dip, pW - 20";
mostCurrent._canvaspnl.AddView((android.view.View)(mostCurrent._sizespnr.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_pw-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=6225931;
 //BA.debugLineNum = 6225931;BA.debugLine="Dim addcBtn As Button";
_addcbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=6225932;
 //BA.debugLineNum = 6225932;BA.debugLine="addcBtn.Initialize(\"addcBtn\")";
_addcbtn.Initialize(mostCurrent.activityBA,"addcBtn");
RDebugUtils.currentLine=6225933;
 //BA.debugLineNum = 6225933;BA.debugLine="addcBtn.Text = \"Add Canvas\"";
_addcbtn.setText(BA.ObjectToCharSequence("Add Canvas"));
RDebugUtils.currentLine=6225934;
 //BA.debugLineNum = 6225934;BA.debugLine="canvasPnl.AddView(addcBtn, 10dip, 60dip, (pW / 2)";
mostCurrent._canvaspnl.AddView((android.view.View)(_addcbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),(int) ((_pw/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=6225936;
 //BA.debugLineNum = 6225936;BA.debugLine="canvasPnl.Enabled = False";
mostCurrent._canvaspnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6225937;
 //BA.debugLineNum = 6225937;BA.debugLine="canvasPnl.Visible = False";
mostCurrent._canvaspnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6225938;
 //BA.debugLineNum = 6225938;BA.debugLine="End Sub";
return "";
}
public static void  _canvasdrag_placedview(anywheresoftware.b4a.objects.ConcreteViewWrapper _cdragview,anywheresoftware.b4a.objects.ConcreteViewWrapper _cplaceview) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "canvasdrag_placedview", false))
	 {Debug.delegate(mostCurrent.activityBA, "canvasdrag_placedview", new Object[] {_cdragview,_cplaceview}); return;}
ResumableSub_CanvasDrag_PlacedView rsub = new ResumableSub_CanvasDrag_PlacedView(null,_cdragview,_cplaceview);
rsub.resume(processBA, null);
}
public static class ResumableSub_CanvasDrag_PlacedView extends BA.ResumableSub {
public ResumableSub_CanvasDrag_PlacedView(b4a.example.corkactivity parent,anywheresoftware.b4a.objects.ConcreteViewWrapper _cdragview,anywheresoftware.b4a.objects.ConcreteViewWrapper _cplaceview) {
this.parent = parent;
this._cdragview = _cdragview;
this._cplaceview = _cplaceview;
}
b4a.example.corkactivity parent;
anywheresoftware.b4a.objects.ConcreteViewWrapper _cdragview;
anywheresoftware.b4a.objects.ConcreteViewWrapper _cplaceview;
int _res = 0;
anywheresoftware.b4a.objects.PanelWrapper _f = null;
String _key = "";
int _newcount = 0;

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
RDebugUtils.currentLine=6946817;
 //BA.debugLineNum = 6946817;BA.debugLine="If cPlaceView.Tag = \"delete\" Then";
if (true) break;

case 1:
//if
this.state = 14;
if ((_cplaceview.getTag()).equals((Object)("delete"))) { 
this.state = 3;
}else {
this.state = 13;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=6946818;
 //BA.debugLineNum = 6946818;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete ca";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete canvas?"),BA.ObjectToCharSequence("Delete Canvas"),"No","","Yes",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6946819;
 //BA.debugLineNum = 6946819;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "canvasdrag_placedview"), null);
this.state = 15;
return;
case 15:
//C
this.state = 4;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=6946820;
 //BA.debugLineNum = 6946820;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
if (true) break;

case 4:
//if
this.state = 11;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=6946821;
 //BA.debugLineNum = 6946821;BA.debugLine="Dim f As Panel = cDragView";
_f = new anywheresoftware.b4a.objects.PanelWrapper();
_f = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_cdragview.getObject()));
RDebugUtils.currentLine=6946822;
 //BA.debugLineNum = 6946822;BA.debugLine="Dim key As String = f.Tag";
_key = BA.ObjectToString(_f.getTag());
RDebugUtils.currentLine=6946823;
 //BA.debugLineNum = 6946823;BA.debugLine="File.Delete(File.DirInternal, key & \".png\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_key+".png");
RDebugUtils.currentLine=6946824;
 //BA.debugLineNum = 6946824;BA.debugLine="Main.kvs.Remove(key & \"_x\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_x");
RDebugUtils.currentLine=6946825;
 //BA.debugLineNum = 6946825;BA.debugLine="Main.kvs.Remove(key & \"_y\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_y");
RDebugUtils.currentLine=6946826;
 //BA.debugLineNum = 6946826;BA.debugLine="Main.kvs.Remove(key & \"_w\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_w");
RDebugUtils.currentLine=6946827;
 //BA.debugLineNum = 6946827;BA.debugLine="Main.kvs.Remove(key & \"_h\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_h");
RDebugUtils.currentLine=6946828;
 //BA.debugLineNum = 6946828;BA.debugLine="Dim newCount As Int = Main.kvs.Get(\"cvs_count\")";
_newcount = (int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get("cvs_count")));
RDebugUtils.currentLine=6946829;
 //BA.debugLineNum = 6946829;BA.debugLine="Main.kvs.Put(\"cvs_count\", newCount - 1)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put("cvs_count",(Object)(_newcount-1));
RDebugUtils.currentLine=6946830;
 //BA.debugLineNum = 6946830;BA.debugLine="canvasCount = canvasCount - 1";
parent._canvascount = (int) (parent._canvascount-1);
RDebugUtils.currentLine=6946831;
 //BA.debugLineNum = 6946831;BA.debugLine="f.Visible = False";
_f.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6946832;
 //BA.debugLineNum = 6946832;BA.debugLine="ToastMessageShow(\"Canvas Deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Canvas Deleted"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6946833;
 //BA.debugLineNum = 6946833;BA.debugLine="If canvasCount = 0 Then";
if (true) break;

case 7:
//if
this.state = 10;
if (parent._canvascount==0) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=6946834;
 //BA.debugLineNum = 6946834;BA.debugLine="penSpnr.Visible = False";
parent.mostCurrent._penspnr.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 10:
//C
this.state = 11;
;
 if (true) break;

case 11:
//C
this.state = 14;
;
 if (true) break;

case 13:
//C
this.state = 14;
RDebugUtils.currentLine=6946838;
 //BA.debugLineNum = 6946838;BA.debugLine="Dim f As Panel = cDragView";
_f = new anywheresoftware.b4a.objects.PanelWrapper();
_f = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_cdragview.getObject()));
RDebugUtils.currentLine=6946839;
 //BA.debugLineNum = 6946839;BA.debugLine="Dim key As String = f.Tag";
_key = BA.ObjectToString(_f.getTag());
RDebugUtils.currentLine=6946840;
 //BA.debugLineNum = 6946840;BA.debugLine="Main.kvs.Put(key & \"_x\", f.Left)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_x",(Object)(_f.getLeft()));
RDebugUtils.currentLine=6946841;
 //BA.debugLineNum = 6946841;BA.debugLine="Main.kvs.Put(key & \"_y\", f.Top)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_y",(Object)(_f.getTop()));
 if (true) break;

case 14:
//C
this.state = -1;
;
RDebugUtils.currentLine=6946843;
 //BA.debugLineNum = 6946843;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.PanelWrapper _f = null;
String _key = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub CanvasPanel_Touch (Action As Int, X As Float,";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Dim p As Panel = Sender";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="Dim cvs As B4XCanvas = p.Tag";
_cvs = (anywheresoftware.b4a.objects.B4XCanvas)(_p.getTag());
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN,mostCurrent._activity.ACTION_MOVE)) {
case 0: {
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="LastY = Y";
_lasty = _y;
 break; }
case 1: {
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, Colors.RGB(R2,";
_cvs.DrawLine(_lastx,_lasty,_x,_y,anywheresoftware.b4a.keywords.Common.Colors.RGB(_r2,_g2,_b2),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3))));
RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
RDebugUtils.currentLine=6094858;
 //BA.debugLineNum = 6094858;BA.debugLine="LastX = X";
_lastx = _x;
RDebugUtils.currentLine=6094859;
 //BA.debugLineNum = 6094859;BA.debugLine="LastY = Y";
_lasty = _y;
RDebugUtils.currentLine=6094860;
 //BA.debugLineNum = 6094860;BA.debugLine="Dim f As Panel = p.Parent";
_f = new anywheresoftware.b4a.objects.PanelWrapper();
_f = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_p.getParent()));
RDebugUtils.currentLine=6094861;
 //BA.debugLineNum = 6094861;BA.debugLine="Dim key As String = f.Tag";
_key = BA.ObjectToString(_f.getTag());
RDebugUtils.currentLine=6094862;
 //BA.debugLineNum = 6094862;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=6094863;
 //BA.debugLineNum = 6094863;BA.debugLine="out = File.OpenOutput(File.DirInternal, key & \"";
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_key+".png",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6094864;
 //BA.debugLineNum = 6094864;BA.debugLine="cvs.CreateBitmap.WriteToStream(out, 100, \"PNG\")";
_cvs.CreateBitmap().WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=6094865;
 //BA.debugLineNum = 6094865;BA.debugLine="out.Close";
_out.Close();
 break; }
}
;
RDebugUtils.currentLine=6094867;
 //BA.debugLineNum = 6094867;BA.debugLine="End Sub";
return "";
}
public static String  _cc_result(boolean _success,String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cc_result", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cc_result", new Object[] {_success,_dir,_filename}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
String _key = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub CC_Result (Success As Boolean, Dir As String,";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="imgView.Initialize(\"ImgView\")";
mostCurrent._imgview.Initialize(mostCurrent.activityBA,"ImgView");
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="bmp = LoadBitmapResize(Dir, FileName, 100dip, 10";
_bmp = anywheresoftware.b4a.keywords.Common.LoadBitmapResize(_dir,_filename,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="imgView.Bitmap = bmp";
mostCurrent._imgview.setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="boardPnl.AddView(imgView, 150dip, 500dip, 100dip";
mostCurrent._boardpnl.AddView((android.view.View)(mostCurrent._imgview.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=5963783;
 //BA.debugLineNum = 5963783;BA.debugLine="ddi.AddDragView(imgView, False)";
mostCurrent._ddi._adddragview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._imgview.getObject())),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5963784;
 //BA.debugLineNum = 5963784;BA.debugLine="ddi.AddPlaceView(place1).AddPlaceView(place2).Ad";
mostCurrent._ddi._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place1.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place2.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place3.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place4.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place5.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place6.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place7.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place8.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place9.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place10.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place11.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._place12.getObject())))._addplaceview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._deletelbl.getObject())));
RDebugUtils.currentLine=5963785;
 //BA.debugLineNum = 5963785;BA.debugLine="Dim key As String = \"img_\" & imgCount";
_key = "img_"+BA.NumberToString(_imgcount);
RDebugUtils.currentLine=5963786;
 //BA.debugLineNum = 5963786;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=5963787;
 //BA.debugLineNum = 5963787;BA.debugLine="out = File.OpenOutput(File.DirInternal, key & \".";
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_key+".png",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5963788;
 //BA.debugLineNum = 5963788;BA.debugLine="bmp.WriteToStream(out, 100, \"PNG\")";
_bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=5963789;
 //BA.debugLineNum = 5963789;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=5963790;
 //BA.debugLineNum = 5963790;BA.debugLine="Main.kvs.Put(key & \"_file\", key & \".png\")";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_file",(Object)(_key+".png"));
RDebugUtils.currentLine=5963791;
 //BA.debugLineNum = 5963791;BA.debugLine="Main.kvs.Put(key & \"_x\", 150dip)";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_x",(Object)(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (150))));
RDebugUtils.currentLine=5963792;
 //BA.debugLineNum = 5963792;BA.debugLine="Main.kvs.Put(key & \"_y\", 500dip)";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_y",(Object)(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500))));
RDebugUtils.currentLine=5963793;
 //BA.debugLineNum = 5963793;BA.debugLine="Main.kvs.Put(\"img_count\", imgCount + 1)";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put("img_count",(Object)(_imgcount+1));
RDebugUtils.currentLine=5963794;
 //BA.debugLineNum = 5963794;BA.debugLine="imgView.Tag = key";
mostCurrent._imgview.setTag((Object)(_key));
RDebugUtils.currentLine=5963795;
 //BA.debugLineNum = 5963795;BA.debugLine="imgCount = imgCount + 1";
_imgcount = (int) (_imgcount+1);
 }else {
RDebugUtils.currentLine=5963797;
 //BA.debugLineNum = 5963797;BA.debugLine="ToastMessageShow(\"No image selected\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No image selected"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=5963799;
 //BA.debugLineNum = 5963799;BA.debugLine="End Sub";
return "";
}
public static String  _colorsspnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "colorsspnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "colorsspnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Private Sub colorsSpnr_ItemClick (Position As Int,";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="R = 255";
_r = (int) (255);
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="G = 105";
_g = (int) (105);
RDebugUtils.currentLine=6684677;
 //BA.debugLineNum = 6684677;BA.debugLine="B = 97";
_b = (int) (97);
 break; }
case 1: {
RDebugUtils.currentLine=6684679;
 //BA.debugLineNum = 6684679;BA.debugLine="R = 155";
_r = (int) (155);
RDebugUtils.currentLine=6684680;
 //BA.debugLineNum = 6684680;BA.debugLine="G = 190";
_g = (int) (190);
RDebugUtils.currentLine=6684681;
 //BA.debugLineNum = 6684681;BA.debugLine="B = 237";
_b = (int) (237);
 break; }
case 2: {
RDebugUtils.currentLine=6684683;
 //BA.debugLineNum = 6684683;BA.debugLine="R = 248";
_r = (int) (248);
RDebugUtils.currentLine=6684684;
 //BA.debugLineNum = 6684684;BA.debugLine="G = 241";
_g = (int) (241);
RDebugUtils.currentLine=6684685;
 //BA.debugLineNum = 6684685;BA.debugLine="B = 174";
_b = (int) (174);
 break; }
}
;
RDebugUtils.currentLine=6684687;
 //BA.debugLineNum = 6684687;BA.debugLine="End Sub";
return "";
}
public static String  _imgbtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "imgbtn_click", null));}
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Private Sub imgBtn_Click";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="imgPicker.Show(\"image/*\", \"Select a Photo\")";
_imgpicker.Show(processBA,"image/*","Select a Photo");
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="End Sub";
return "";
}
public static void  _imgdrag_placedview(anywheresoftware.b4a.objects.ConcreteViewWrapper _idragview,anywheresoftware.b4a.objects.ConcreteViewWrapper _iplaceview) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "imgdrag_placedview", false))
	 {Debug.delegate(mostCurrent.activityBA, "imgdrag_placedview", new Object[] {_idragview,_iplaceview}); return;}
ResumableSub_ImgDrag_PlacedView rsub = new ResumableSub_ImgDrag_PlacedView(null,_idragview,_iplaceview);
rsub.resume(processBA, null);
}
public static class ResumableSub_ImgDrag_PlacedView extends BA.ResumableSub {
public ResumableSub_ImgDrag_PlacedView(b4a.example.corkactivity parent,anywheresoftware.b4a.objects.ConcreteViewWrapper _idragview,anywheresoftware.b4a.objects.ConcreteViewWrapper _iplaceview) {
this.parent = parent;
this._idragview = _idragview;
this._iplaceview = _iplaceview;
}
b4a.example.corkactivity parent;
anywheresoftware.b4a.objects.ConcreteViewWrapper _idragview;
anywheresoftware.b4a.objects.ConcreteViewWrapper _iplaceview;
int _res = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
String _key = "";
int _newcount = 0;

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
RDebugUtils.currentLine=6881281;
 //BA.debugLineNum = 6881281;BA.debugLine="If iPlaceView.Tag = \"delete\" Then";
if (true) break;

case 1:
//if
this.state = 10;
if ((_iplaceview.getTag()).equals((Object)("delete"))) { 
this.state = 3;
}else {
this.state = 9;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=6881282;
 //BA.debugLineNum = 6881282;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete im";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete image?"),BA.ObjectToCharSequence("Delete Image"),"No","","Yes",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6881283;
 //BA.debugLineNum = 6881283;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "imgdrag_placedview"), null);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=6881284;
 //BA.debugLineNum = 6881284;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
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
RDebugUtils.currentLine=6881285;
 //BA.debugLineNum = 6881285;BA.debugLine="Dim iv As ImageView = iDragView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
_iv = (anywheresoftware.b4a.objects.ImageViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ImageViewWrapper(), (android.widget.ImageView)(_idragview.getObject()));
RDebugUtils.currentLine=6881286;
 //BA.debugLineNum = 6881286;BA.debugLine="Dim key As String = iv.Tag";
_key = BA.ObjectToString(_iv.getTag());
RDebugUtils.currentLine=6881287;
 //BA.debugLineNum = 6881287;BA.debugLine="File.Delete(File.DirInternal, key & \".png\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_key+".png");
RDebugUtils.currentLine=6881288;
 //BA.debugLineNum = 6881288;BA.debugLine="Main.kvs.Remove(key & \"_file\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_file");
RDebugUtils.currentLine=6881289;
 //BA.debugLineNum = 6881289;BA.debugLine="Main.kvs.Remove(key & \"_x\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_x");
RDebugUtils.currentLine=6881290;
 //BA.debugLineNum = 6881290;BA.debugLine="Main.kvs.Remove(key & \"_y\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_y");
RDebugUtils.currentLine=6881291;
 //BA.debugLineNum = 6881291;BA.debugLine="Dim newCount As Int = Main.kvs.Get(\"img_count\")";
_newcount = (int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get("img_count")));
RDebugUtils.currentLine=6881292;
 //BA.debugLineNum = 6881292;BA.debugLine="Main.kvs.Put(\"img_count\", newCount - 1)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put("img_count",(Object)(_newcount-1));
RDebugUtils.currentLine=6881293;
 //BA.debugLineNum = 6881293;BA.debugLine="iv.Visible = False";
_iv.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6881294;
 //BA.debugLineNum = 6881294;BA.debugLine="ToastMessageShow(\"Image Deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Image Deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 7:
//C
this.state = 10;
;
 if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=6881297;
 //BA.debugLineNum = 6881297;BA.debugLine="Dim iv As ImageView = iDragView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
_iv = (anywheresoftware.b4a.objects.ImageViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ImageViewWrapper(), (android.widget.ImageView)(_idragview.getObject()));
RDebugUtils.currentLine=6881298;
 //BA.debugLineNum = 6881298;BA.debugLine="Dim key As String = iv.Tag";
_key = BA.ObjectToString(_iv.getTag());
RDebugUtils.currentLine=6881299;
 //BA.debugLineNum = 6881299;BA.debugLine="Main.kvs.Put(key & \"_x\", iv.Left)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_x",(Object)(_iv.getLeft()));
RDebugUtils.currentLine=6881300;
 //BA.debugLineNum = 6881300;BA.debugLine="Main.kvs.Put(key & \"_y\", iv.Top)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_y",(Object)(_iv.getTop()));
 if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=6881302;
 //BA.debugLineNum = 6881302;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _notedrag_placedview(anywheresoftware.b4a.objects.ConcreteViewWrapper _ndragview,anywheresoftware.b4a.objects.ConcreteViewWrapper _nplaceview) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "notedrag_placedview", false))
	 {Debug.delegate(mostCurrent.activityBA, "notedrag_placedview", new Object[] {_ndragview,_nplaceview}); return;}
ResumableSub_NoteDrag_PlacedView rsub = new ResumableSub_NoteDrag_PlacedView(null,_ndragview,_nplaceview);
rsub.resume(processBA, null);
}
public static class ResumableSub_NoteDrag_PlacedView extends BA.ResumableSub {
public ResumableSub_NoteDrag_PlacedView(b4a.example.corkactivity parent,anywheresoftware.b4a.objects.ConcreteViewWrapper _ndragview,anywheresoftware.b4a.objects.ConcreteViewWrapper _nplaceview) {
this.parent = parent;
this._ndragview = _ndragview;
this._nplaceview = _nplaceview;
}
b4a.example.corkactivity parent;
anywheresoftware.b4a.objects.ConcreteViewWrapper _ndragview;
anywheresoftware.b4a.objects.ConcreteViewWrapper _nplaceview;
int _res = 0;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
String _key = "";
int _newcount = 0;

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
RDebugUtils.currentLine=6815745;
 //BA.debugLineNum = 6815745;BA.debugLine="If nPlaceView.Tag = \"delete\" Then";
if (true) break;

case 1:
//if
this.state = 10;
if ((_nplaceview.getTag()).equals((Object)("delete"))) { 
this.state = 3;
}else {
this.state = 9;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete no";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete note?"),BA.ObjectToCharSequence("Delete Note"),"No","","Yes",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6815747;
 //BA.debugLineNum = 6815747;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "corkactivity", "notedrag_placedview"), null);
this.state = 11;
return;
case 11:
//C
this.state = 4;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=6815748;
 //BA.debugLineNum = 6815748;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
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
RDebugUtils.currentLine=6815749;
 //BA.debugLineNum = 6815749;BA.debugLine="Dim p As Panel = nDragView";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_ndragview.getObject()));
RDebugUtils.currentLine=6815750;
 //BA.debugLineNum = 6815750;BA.debugLine="Dim key As String = p.Tag";
_key = BA.ObjectToString(_p.getTag());
RDebugUtils.currentLine=6815751;
 //BA.debugLineNum = 6815751;BA.debugLine="Main.kvs.Remove(key & \"_text\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_text");
RDebugUtils.currentLine=6815752;
 //BA.debugLineNum = 6815752;BA.debugLine="Main.kvs.Remove(key & \"_color\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_color");
RDebugUtils.currentLine=6815753;
 //BA.debugLineNum = 6815753;BA.debugLine="Main.kvs.Remove(key & \"_x\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_x");
RDebugUtils.currentLine=6815754;
 //BA.debugLineNum = 6815754;BA.debugLine="Main.kvs.Remove(key & \"_y\")";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._remove(_key+"_y");
RDebugUtils.currentLine=6815755;
 //BA.debugLineNum = 6815755;BA.debugLine="Dim newCount As Int = Main.kvs.Get(\"note_count\"";
_newcount = (int)(BA.ObjectToNumber(parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._get("note_count")));
RDebugUtils.currentLine=6815756;
 //BA.debugLineNum = 6815756;BA.debugLine="Main.kvs.Put(\"note_count\", newCount - 1)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put("note_count",(Object)(_newcount-1));
RDebugUtils.currentLine=6815757;
 //BA.debugLineNum = 6815757;BA.debugLine="p.Visible = False";
_p.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6815758;
 //BA.debugLineNum = 6815758;BA.debugLine="ToastMessageShow(\"Note Deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Note Deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 7:
//C
this.state = 10;
;
 if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=6815761;
 //BA.debugLineNum = 6815761;BA.debugLine="Dim p As Panel = nDragView";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_ndragview.getObject()));
RDebugUtils.currentLine=6815762;
 //BA.debugLineNum = 6815762;BA.debugLine="Dim key As String = p.Tag";
_key = BA.ObjectToString(_p.getTag());
RDebugUtils.currentLine=6815763;
 //BA.debugLineNum = 6815763;BA.debugLine="Main.kvs.Put(key & \"_x\", p.Left)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_x",(Object)(_p.getLeft()));
RDebugUtils.currentLine=6815764;
 //BA.debugLineNum = 6815764;BA.debugLine="Main.kvs.Put(key & \"_y\", p.Top)";
parent.mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_y",(Object)(_p.getTop()));
 if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=6815766;
 //BA.debugLineNum = 6815766;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _notetext_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "notetext_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "notetext_textchanged", new Object[] {_old,_new}));}
anywheresoftware.b4a.objects.EditTextWrapper _txt = null;
anywheresoftware.b4a.objects.PanelWrapper _p = null;
String _key = "";
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub NoteText_TextChanged(Old As String, New As Str";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Dim txt As EditText = Sender";
_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
_txt = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="Dim p As Panel = txt.Tag";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_txt.getTag()));
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="Dim key As String = p.Tag";
_key = BA.ObjectToString(_p.getTag());
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="Main.kvs.Put(key & \"_text\", New)";
mostCurrent._main._kvs /*b4a.example3.keyvaluestore*/ ._put(_key+"_text",(Object)(_new));
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="End Sub";
return "";
}
public static String  _notewindow(int _pw,int _ph) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "notewindow", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "notewindow", new Object[] {_pw,_ph}));}
anywheresoftware.b4a.objects.SpinnerWrapper _colorsspnr = null;
anywheresoftware.b4a.objects.ButtonWrapper _addnbtn = null;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Private Sub noteWindow(pW As Int, pH As Int)";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="notePnl = xui.CreatePanel(\"notePnl\")";
mostCurrent._notepnl = _xui.CreatePanel(processBA,"notePnl");
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="Activity.AddView(notePnl, 100dip, 225dip, pW, pH)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._notepnl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (225)),_pw,_ph);
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="notePnl.Color = xui.Color_RGB(50, 50, 50)";
mostCurrent._notepnl.setColor(_xui.Color_RGB((int) (50),(int) (50),(int) (50)));
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="notePnl.SetColorAndBorder(xui.Color_White, 2dip,";
mostCurrent._notepnl.SetColorAndBorder(_xui.Color_White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),_xui.Color_Black,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)));
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="Dim colorsSpnr As Spinner";
_colorsspnr = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="colorsSpnr.Initialize(\"colorsSpnr\")";
_colorsspnr.Initialize(mostCurrent.activityBA,"colorsSpnr");
RDebugUtils.currentLine=6160392;
 //BA.debugLineNum = 6160392;BA.debugLine="colorsSpnr.AddAll(Array As String(\"Red\", \"Blue\",";
_colorsspnr.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Red","Blue","Yellow"}));
RDebugUtils.currentLine=6160393;
 //BA.debugLineNum = 6160393;BA.debugLine="notePnl.AddView(colorsSpnr, 10dip, 10dip, pW - 20";
mostCurrent._notepnl.AddView((android.view.View)(_colorsspnr.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_pw-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=6160395;
 //BA.debugLineNum = 6160395;BA.debugLine="Dim addnBtn As Button";
_addnbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=6160396;
 //BA.debugLineNum = 6160396;BA.debugLine="addnBtn.Initialize(\"addnBtn\")";
_addnbtn.Initialize(mostCurrent.activityBA,"addnBtn");
RDebugUtils.currentLine=6160397;
 //BA.debugLineNum = 6160397;BA.debugLine="addnBtn.Text = \"Add Note\"";
_addnbtn.setText(BA.ObjectToCharSequence("Add Note"));
RDebugUtils.currentLine=6160398;
 //BA.debugLineNum = 6160398;BA.debugLine="notePnl.AddView(addnBtn, 10dip, 60dip, (pW / 2) -";
mostCurrent._notepnl.AddView((android.view.View)(_addnbtn.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),(int) ((_pw/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=6160400;
 //BA.debugLineNum = 6160400;BA.debugLine="notePnl.Enabled = False";
mostCurrent._notepnl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6160401;
 //BA.debugLineNum = 6160401;BA.debugLine="notePnl.Visible = False";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6160402;
 //BA.debugLineNum = 6160402;BA.debugLine="End Sub";
return "";
}
public static String  _penspnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "penspnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "penspnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Private Sub penSpnr_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=6750212;
 //BA.debugLineNum = 6750212;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=6750213;
 //BA.debugLineNum = 6750213;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 1: {
RDebugUtils.currentLine=6750215;
 //BA.debugLineNum = 6750215;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=6750216;
 //BA.debugLineNum = 6750216;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=6750217;
 //BA.debugLineNum = 6750217;BA.debugLine="B2 = 255";
_b2 = (int) (255);
 break; }
case 2: {
RDebugUtils.currentLine=6750219;
 //BA.debugLineNum = 6750219;BA.debugLine="R2 = 0";
_r2 = (int) (0);
RDebugUtils.currentLine=6750220;
 //BA.debugLineNum = 6750220;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=6750221;
 //BA.debugLineNum = 6750221;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 3: {
RDebugUtils.currentLine=6750223;
 //BA.debugLineNum = 6750223;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=6750224;
 //BA.debugLineNum = 6750224;BA.debugLine="G2 = 0";
_g2 = (int) (0);
RDebugUtils.currentLine=6750225;
 //BA.debugLineNum = 6750225;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 4: {
RDebugUtils.currentLine=6750227;
 //BA.debugLineNum = 6750227;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=6750228;
 //BA.debugLineNum = 6750228;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=6750229;
 //BA.debugLineNum = 6750229;BA.debugLine="B2 = 0";
_b2 = (int) (0);
 break; }
case 5: {
RDebugUtils.currentLine=6750231;
 //BA.debugLineNum = 6750231;BA.debugLine="R2 = 255";
_r2 = (int) (255);
RDebugUtils.currentLine=6750232;
 //BA.debugLineNum = 6750232;BA.debugLine="G2 = 255";
_g2 = (int) (255);
RDebugUtils.currentLine=6750233;
 //BA.debugLineNum = 6750233;BA.debugLine="B2 = 255";
_b2 = (int) (255);
 break; }
}
;
RDebugUtils.currentLine=6750235;
 //BA.debugLineNum = 6750235;BA.debugLine="End Sub";
return "";
}
public static String  _sizespnr_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sizespnr_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sizespnr_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Private Sub sizeSpnr_ItemClick (Position As Int, V";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="Select Position";
switch (_position) {
case 0: {
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="Width = 80dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=6619140;
 //BA.debugLineNum = 6619140;BA.debugLine="Height = 60dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
 break; }
case 1: {
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="Width = 205dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (205));
RDebugUtils.currentLine=6619143;
 //BA.debugLineNum = 6619143;BA.debugLine="Height = 60dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
 break; }
case 2: {
RDebugUtils.currentLine=6619145;
 //BA.debugLineNum = 6619145;BA.debugLine="Width = 80dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80));
RDebugUtils.currentLine=6619146;
 //BA.debugLineNum = 6619146;BA.debugLine="Height = 185dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (185));
 break; }
case 3: {
RDebugUtils.currentLine=6619148;
 //BA.debugLineNum = 6619148;BA.debugLine="Width = 205dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (205));
RDebugUtils.currentLine=6619149;
 //BA.debugLineNum = 6619149;BA.debugLine="Height = 185dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (185));
 break; }
case 4: {
RDebugUtils.currentLine=6619151;
 //BA.debugLineNum = 6619151;BA.debugLine="Width = 330dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (330));
RDebugUtils.currentLine=6619152;
 //BA.debugLineNum = 6619152;BA.debugLine="Height = 185dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (185));
 break; }
case 5: {
RDebugUtils.currentLine=6619154;
 //BA.debugLineNum = 6619154;BA.debugLine="Width = 205dip";
_width = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (205));
RDebugUtils.currentLine=6619155;
 //BA.debugLineNum = 6619155;BA.debugLine="Height = 310dip";
_height = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (310));
 break; }
}
;
RDebugUtils.currentLine=6619157;
 //BA.debugLineNum = 6619157;BA.debugLine="End Sub";
return "";
}
public static String  _stickybtn_click() throws Exception{
RDebugUtils.currentModule="corkactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "stickybtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "stickybtn_click", null));}
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Private Sub stickyBtn_Click";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="noteWindow(250dip, 180dip)";
_notewindow(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="notePnl.Visible = True";
mostCurrent._notepnl.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="stickyBtn.Enabled = False";
mostCurrent._stickybtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="canvaBtn.Enabled = False";
mostCurrent._canvabtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="imgBtn.Enabled = False";
mostCurrent._imgbtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6422534;
 //BA.debugLineNum = 6422534;BA.debugLine="End Sub";
return "";
}
}