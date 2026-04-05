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

public class calendaractivity extends Activity implements B4AActivity{
	public static calendaractivity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.calendaractivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (calendaractivity).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.calendaractivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.calendaractivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (calendaractivity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (calendaractivity) Resume **");
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
		return calendaractivity.class;
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
            BA.LogInfo("** Activity (calendaractivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (calendaractivity) Pause event (activity is not paused). **");
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
            calendaractivity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (calendaractivity) Resume **");
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
public static anywheresoftware.b4a.objects.collections.Map _calendarmap = null;
public static b4a.example3.keyvaluestore _kvs = null;
public static String[] _months = null;
public anywheresoftware.b4a.objects.PanelWrapper _calendarpanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _weekpanel = null;
public static String _day_of_week = "";
public anywheresoftware.b4a.objects.SpinnerWrapper _monthsp = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _yearsp = null;
public anywheresoftware.b4a.objects.PanelWrapper _menupanel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _month_btn = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.themeactivity _themeactivity = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public b4a.example.todoactivity _todoactivity = null;
public b4a.example.card_module _card_module = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.editnote _editnote = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.schedule_module _schedule_module = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String _datekey = "";
anywheresoftware.b4a.objects.collections.Map _dates = null;
anywheresoftware.b4a.objects.collections.List _timeline = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _ev = null;
int _currentyear = 0;
anywheresoftware.b4a.objects.collections.List _years = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _column = 0;
int _cellw = 0;
int _cellh = 0;
int _c = 0;
anywheresoftware.b4a.objects.LabelWrapper _celllabel = null;
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=7471107;
 //BA.debugLineNum = 7471107;BA.debugLine="Activity.LoadLayout(\"CalendarActivityLayout\")";
mostCurrent._activity.LoadLayout("CalendarActivityLayout",mostCurrent.activityBA);
 }else {
RDebugUtils.currentLine=7471109;
 //BA.debugLineNum = 7471109;BA.debugLine="Activity.LoadLayout(\"CalendarActivityLayoutDark\"";
mostCurrent._activity.LoadLayout("CalendarActivityLayoutDark",mostCurrent.activityBA);
 };
RDebugUtils.currentLine=7471112;
 //BA.debugLineNum = 7471112;BA.debugLine="Month_btn.Color = Colors.LightGray";
mostCurrent._month_btn.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
RDebugUtils.currentLine=7471114;
 //BA.debugLineNum = 7471114;BA.debugLine="kvs = Starter.calKvs";
_kvs = mostCurrent._starter._calkvs /*b4a.example3.keyvaluestore*/ ;
RDebugUtils.currentLine=7471115;
 //BA.debugLineNum = 7471115;BA.debugLine="CalendarMap = Starter.calendarMap";
_calendarmap = mostCurrent._starter._calendarmap /*anywheresoftware.b4a.objects.collections.Map*/ ;
RDebugUtils.currentLine=7471117;
 //BA.debugLineNum = 7471117;BA.debugLine="For Each datekey As String In CalendarMap.Keys";
{
final anywheresoftware.b4a.BA.IterableList group9 = _calendarmap.Keys();
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_datekey = BA.ObjectToString(group9.Get(index9));
RDebugUtils.currentLine=7471118;
 //BA.debugLineNum = 7471118;BA.debugLine="Dim dates As Map = CalendarMap.Get(datekey)";
_dates = new anywheresoftware.b4a.objects.collections.Map();
_dates = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_calendarmap.Get((Object)(_datekey))));
RDebugUtils.currentLine=7471119;
 //BA.debugLineNum = 7471119;BA.debugLine="Dim timeline As List = dates.Get(\"Timeline\")";
_timeline = new anywheresoftware.b4a.objects.collections.List();
_timeline = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_dates.Get((Object)("Timeline"))));
RDebugUtils.currentLine=7471120;
 //BA.debugLineNum = 7471120;BA.debugLine="For i = 0 To timeline.Size -1";
{
final int step12 = 1;
final int limit12 = (int) (_timeline.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
RDebugUtils.currentLine=7471121;
 //BA.debugLineNum = 7471121;BA.debugLine="Dim ev As Map = timeline.Get(i)";
_ev = new anywheresoftware.b4a.objects.collections.Map();
_ev = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_timeline.Get(_i)));
RDebugUtils.currentLine=7471122;
 //BA.debugLineNum = 7471122;BA.debugLine="If ev.ContainsKey(\"ID\") = False Then";
if (_ev.ContainsKey((Object)("ID"))==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=7471123;
 //BA.debugLineNum = 7471123;BA.debugLine="ev.Put(\"ID\", DateTime.Now + Rnd(0,1000))";
_ev.Put((Object)("ID"),(Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()+anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (1000))));
 };
 }
};
 }
};
RDebugUtils.currentLine=7471127;
 //BA.debugLineNum = 7471127;BA.debugLine="kvs.Put(\"CalendarKVS\", CalendarMap)";
_kvs._put("CalendarKVS",(Object)(_calendarmap.getObject()));
RDebugUtils.currentLine=7471130;
 //BA.debugLineNum = 7471130;BA.debugLine="Dim currentyear As Int = DateTime.GetYear(DateTim";
_currentyear = anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=7471131;
 //BA.debugLineNum = 7471131;BA.debugLine="Dim years As List";
_years = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7471132;
 //BA.debugLineNum = 7471132;BA.debugLine="years.Initialize";
_years.Initialize();
RDebugUtils.currentLine=7471133;
 //BA.debugLineNum = 7471133;BA.debugLine="For i = currentyear -10 To currentyear+10";
{
final int step23 = 1;
final int limit23 = (int) (_currentyear+10);
_i = (int) (_currentyear-10) ;
for (;_i <= limit23 ;_i = _i + step23 ) {
RDebugUtils.currentLine=7471134;
 //BA.debugLineNum = 7471134;BA.debugLine="years.Add(i)";
_years.Add((Object)(_i));
 }
};
RDebugUtils.currentLine=7471136;
 //BA.debugLineNum = 7471136;BA.debugLine="YearSP.AddAll(years)";
mostCurrent._yearsp.AddAll(_years);
RDebugUtils.currentLine=7471137;
 //BA.debugLineNum = 7471137;BA.debugLine="YearSP.SelectedIndex = 10";
mostCurrent._yearsp.setSelectedIndex((int) (10));
RDebugUtils.currentLine=7471138;
 //BA.debugLineNum = 7471138;BA.debugLine="If Starter.darkMode = True Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=7471139;
 //BA.debugLineNum = 7471139;BA.debugLine="YearSP.DropdownBackgroundColor = Colors.Black";
mostCurrent._yearsp.setDropdownBackgroundColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=7471143;
 //BA.debugLineNum = 7471143;BA.debugLine="MonthSp.AddAll(Months)";
mostCurrent._monthsp.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(mostCurrent._months));
RDebugUtils.currentLine=7471144;
 //BA.debugLineNum = 7471144;BA.debugLine="MonthSp.SelectedIndex = DateTime.GetMonth(DateTim";
mostCurrent._monthsp.setSelectedIndex((int) (anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow())-1));
RDebugUtils.currentLine=7471145;
 //BA.debugLineNum = 7471145;BA.debugLine="If Starter.darkMode = True Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=7471146;
 //BA.debugLineNum = 7471146;BA.debugLine="MonthSp.DropdownBackgroundColor = Colors.Black";
mostCurrent._monthsp.setDropdownBackgroundColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=7471150;
 //BA.debugLineNum = 7471150;BA.debugLine="DrawCalendar(DateTime.GetMonth(DateTime.Now), Dat";
_drawcalendar(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow()),anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=7471153;
 //BA.debugLineNum = 7471153;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=7471154;
 //BA.debugLineNum = 7471154;BA.debugLine="cd.Initialize2(Colors.White, 0, 2dip, Colors.Blac";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=7471156;
 //BA.debugLineNum = 7471156;BA.debugLine="Dim column As Int = 7";
_column = (int) (7);
RDebugUtils.currentLine=7471157;
 //BA.debugLineNum = 7471157;BA.debugLine="Dim cellW As Int = calendarpanel.Width/column";
_cellw = (int) (mostCurrent._calendarpanel.getWidth()/(double)_column);
RDebugUtils.currentLine=7471158;
 //BA.debugLineNum = 7471158;BA.debugLine="Dim cellH As Int = 60dip";
_cellh = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
RDebugUtils.currentLine=7471159;
 //BA.debugLineNum = 7471159;BA.debugLine="For c = 0 To column -1";
{
final int step42 = 1;
final int limit42 = (int) (_column-1);
_c = (int) (0) ;
for (;_c <= limit42 ;_c = _c + step42 ) {
RDebugUtils.currentLine=7471160;
 //BA.debugLineNum = 7471160;BA.debugLine="Dim celllabel As Label";
_celllabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7471161;
 //BA.debugLineNum = 7471161;BA.debugLine="celllabel.Initialize(\"cell_label\")";
_celllabel.Initialize(mostCurrent.activityBA,"cell_label");
RDebugUtils.currentLine=7471162;
 //BA.debugLineNum = 7471162;BA.debugLine="Weekday(c)";
_weekday(_c);
RDebugUtils.currentLine=7471163;
 //BA.debugLineNum = 7471163;BA.debugLine="celllabel.Text = day_of_week";
_celllabel.setText(BA.ObjectToCharSequence(mostCurrent._day_of_week));
RDebugUtils.currentLine=7471164;
 //BA.debugLineNum = 7471164;BA.debugLine="celllabel.TextSize = 14";
_celllabel.setTextSize((float) (14));
RDebugUtils.currentLine=7471165;
 //BA.debugLineNum = 7471165;BA.debugLine="celllabel.Color = Colors.black";
_celllabel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=7471166;
 //BA.debugLineNum = 7471166;BA.debugLine="weekpanel.AddView(celllabel, c*cellW, 0, cellW,";
mostCurrent._weekpanel.AddView((android.view.View)(_celllabel.getObject()),(int) (_c*_cellw),(int) (0),_cellw,_cellh);
RDebugUtils.currentLine=7471169;
 //BA.debugLineNum = 7471169;BA.debugLine="celllabel.Background = cd";
_celllabel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 }
};
RDebugUtils.currentLine=7471175;
 //BA.debugLineNum = 7471175;BA.debugLine="End Sub";
return "";
}
public static String  _drawcalendar(int _month,int _year) throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawcalendar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "drawcalendar", new Object[] {_month,_year}));}
long _firstday = 0L;
int _startday = 0;
int _daysinmonth = 0;
int _prevmonth = 0;
int _prevyear = 0;
int _daysinprevmonth = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _rows = 0;
int _column = 0;
int _day = 0;
boolean _started = false;
int _index = 0;
int _cellw = 0;
int _cellh = 0;
int _r = 0;
int _c = 0;
anywheresoftware.b4a.objects.PanelWrapper _cell = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
int _displayday = 0;
String _datestr = "";
int _nextmonth = 0;
int _nextyear = 0;
anywheresoftware.b4a.objects.collections.Map _eventmap = null;
anywheresoftware.b4a.objects.collections.List _allevents = null;
int _maxshow = 0;
int _yoffset = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _ev = null;
anywheresoftware.b4a.objects.LabelWrapper _dot = null;
anywheresoftware.b4a.objects.LabelWrapper _morelbl = null;
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Sub DrawCalendar (month As Int, year As Int)";
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="calendarpanel.RemoveAllViews";
mostCurrent._calendarpanel.RemoveAllViews();
RDebugUtils.currentLine=7602181;
 //BA.debugLineNum = 7602181;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy-MM-dd");
RDebugUtils.currentLine=7602182;
 //BA.debugLineNum = 7602182;BA.debugLine="Dim firstDay As Long = DateTime.DateParse(year &";
_firstday = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(BA.NumberToString(_year)+"-"+BA.NumberToString(_month)+"-01");
RDebugUtils.currentLine=7602183;
 //BA.debugLineNum = 7602183;BA.debugLine="Dim startDay As Int = DateTime.GetDayOfweek(first";
_startday = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(_firstday);
RDebugUtils.currentLine=7602184;
 //BA.debugLineNum = 7602184;BA.debugLine="Dim daysInmonth As Int = Daysinamonth(month, year";
_daysinmonth = _daysinamonth(_month,_year);
RDebugUtils.currentLine=7602188;
 //BA.debugLineNum = 7602188;BA.debugLine="Dim prevmonth As Int";
_prevmonth = 0;
RDebugUtils.currentLine=7602189;
 //BA.debugLineNum = 7602189;BA.debugLine="Dim prevyear As Int";
_prevyear = 0;
RDebugUtils.currentLine=7602191;
 //BA.debugLineNum = 7602191;BA.debugLine="If month = 1 Then";
if (_month==1) { 
RDebugUtils.currentLine=7602192;
 //BA.debugLineNum = 7602192;BA.debugLine="prevmonth = 12";
_prevmonth = (int) (12);
RDebugUtils.currentLine=7602193;
 //BA.debugLineNum = 7602193;BA.debugLine="prevyear = year - 1";
_prevyear = (int) (_year-1);
 }else {
RDebugUtils.currentLine=7602195;
 //BA.debugLineNum = 7602195;BA.debugLine="prevmonth = month-1";
_prevmonth = (int) (_month-1);
RDebugUtils.currentLine=7602196;
 //BA.debugLineNum = 7602196;BA.debugLine="prevyear = year";
_prevyear = _year;
 };
RDebugUtils.currentLine=7602198;
 //BA.debugLineNum = 7602198;BA.debugLine="Dim daysInprevMonth As Int = Daysinamonth(prevmon";
_daysinprevmonth = _daysinamonth(_prevmonth,_prevyear);
RDebugUtils.currentLine=7602202;
 //BA.debugLineNum = 7602202;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=7602203;
 //BA.debugLineNum = 7602203;BA.debugLine="cd.Initialize2(Colors.White, 0, 2dip, Colors.Blac";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=7602205;
 //BA.debugLineNum = 7602205;BA.debugLine="Dim rows As Int = 6  'number of rows (days)";
_rows = (int) (6);
RDebugUtils.currentLine=7602206;
 //BA.debugLineNum = 7602206;BA.debugLine="Dim column As Int = 7 'number of columns (the wee";
_column = (int) (7);
RDebugUtils.currentLine=7602208;
 //BA.debugLineNum = 7602208;BA.debugLine="Dim day As Int = 1";
_day = (int) (1);
RDebugUtils.currentLine=7602209;
 //BA.debugLineNum = 7602209;BA.debugLine="Dim started As Boolean = False";
_started = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=7602211;
 //BA.debugLineNum = 7602211;BA.debugLine="Dim index As Int = 0";
_index = (int) (0);
RDebugUtils.currentLine=7602213;
 //BA.debugLineNum = 7602213;BA.debugLine="Dim cellW As Int = calendarpanel.width / column";
_cellw = (int) (mostCurrent._calendarpanel.getWidth()/(double)_column);
RDebugUtils.currentLine=7602214;
 //BA.debugLineNum = 7602214;BA.debugLine="Dim cellH As Int = 60dip";
_cellh = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
RDebugUtils.currentLine=7602215;
 //BA.debugLineNum = 7602215;BA.debugLine="For r = 0 To rows -1";
{
final int step25 = 1;
final int limit25 = (int) (_rows-1);
_r = (int) (0) ;
for (;_r <= limit25 ;_r = _r + step25 ) {
RDebugUtils.currentLine=7602216;
 //BA.debugLineNum = 7602216;BA.debugLine="For c = 0 To column -1";
{
final int step26 = 1;
final int limit26 = (int) (_column-1);
_c = (int) (0) ;
for (;_c <= limit26 ;_c = _c + step26 ) {
RDebugUtils.currentLine=7602218;
 //BA.debugLineNum = 7602218;BA.debugLine="Dim cell As Panel";
_cell = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=7602219;
 //BA.debugLineNum = 7602219;BA.debugLine="cell.Initialize(\"cell_click\")";
_cell.Initialize(mostCurrent.activityBA,"cell_click");
RDebugUtils.currentLine=7602220;
 //BA.debugLineNum = 7602220;BA.debugLine="cell.Enabled  =True";
_cell.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7602222;
 //BA.debugLineNum = 7602222;BA.debugLine="calendarpanel.AddView(cell, c * cellW, r * cell";
mostCurrent._calendarpanel.AddView((android.view.View)(_cell.getObject()),(int) (_c*_cellw),(int) (_r*_cellh),_cellw,_cellh);
RDebugUtils.currentLine=7602223;
 //BA.debugLineNum = 7602223;BA.debugLine="cell.Background = cd";
_cell.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=7602225;
 //BA.debugLineNum = 7602225;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7602226;
 //BA.debugLineNum = 7602226;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7602227;
 //BA.debugLineNum = 7602227;BA.debugLine="lbl.Gravity = Gravity.CENTER_Horizontal";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=7602228;
 //BA.debugLineNum = 7602228;BA.debugLine="lbl.Enabled = False";
_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7602230;
 //BA.debugLineNum = 7602230;BA.debugLine="index = index +1";
_index = (int) (_index+1);
RDebugUtils.currentLine=7602232;
 //BA.debugLineNum = 7602232;BA.debugLine="Dim displayday As Int";
_displayday = 0;
RDebugUtils.currentLine=7602233;
 //BA.debugLineNum = 7602233;BA.debugLine="Dim datestr As String";
_datestr = "";
RDebugUtils.currentLine=7602236;
 //BA.debugLineNum = 7602236;BA.debugLine="If index < startDay Then";
if (_index<_startday) { 
RDebugUtils.currentLine=7602237;
 //BA.debugLineNum = 7602237;BA.debugLine="displayday = daysInprevMonth - (startDay - ind";
_displayday = (int) (_daysinprevmonth-(_startday-_index)+1);
RDebugUtils.currentLine=7602238;
 //BA.debugLineNum = 7602238;BA.debugLine="lbl.TextColor = Colors.gray";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7602239;
 //BA.debugLineNum = 7602239;BA.debugLine="datestr = prevyear & \"-\" & NumberFormat(prevmo";
_datestr = BA.NumberToString(_prevyear)+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_prevmonth,(int) (2),(int) (0))+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_displayday,(int) (2),(int) (0));
 }else 
{RDebugUtils.currentLine=7602240;
 //BA.debugLineNum = 7602240;BA.debugLine="Else if index >= startDay And index < startDay";
if (_index>=_startday && _index<_startday+_daysinmonth) { 
RDebugUtils.currentLine=7602241;
 //BA.debugLineNum = 7602241;BA.debugLine="displayday = index - startDay + 1";
_displayday = (int) (_index-_startday+1);
RDebugUtils.currentLine=7602242;
 //BA.debugLineNum = 7602242;BA.debugLine="lbl.TextColor = Colors.Black";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=7602243;
 //BA.debugLineNum = 7602243;BA.debugLine="datestr = year&\"-\"&NumberFormat(month,2,0)&\"-\"";
_datestr = BA.NumberToString(_year)+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_month,(int) (2),(int) (0))+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_displayday,(int) (2),(int) (0));
 }else {
RDebugUtils.currentLine=7602245;
 //BA.debugLineNum = 7602245;BA.debugLine="displayday = index - (startDay + daysInmonth)";
_displayday = (int) (_index-(_startday+_daysinmonth)+1);
RDebugUtils.currentLine=7602246;
 //BA.debugLineNum = 7602246;BA.debugLine="lbl.TextColor = Colors.Gray";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=7602247;
 //BA.debugLineNum = 7602247;BA.debugLine="Dim nextmonth As Int";
_nextmonth = 0;
RDebugUtils.currentLine=7602248;
 //BA.debugLineNum = 7602248;BA.debugLine="Dim nextyear As Int";
_nextyear = 0;
RDebugUtils.currentLine=7602250;
 //BA.debugLineNum = 7602250;BA.debugLine="If month = 12 Then";
if (_month==12) { 
RDebugUtils.currentLine=7602251;
 //BA.debugLineNum = 7602251;BA.debugLine="nextmonth = 1";
_nextmonth = (int) (1);
RDebugUtils.currentLine=7602252;
 //BA.debugLineNum = 7602252;BA.debugLine="nextyear = year+1";
_nextyear = (int) (_year+1);
 }else {
RDebugUtils.currentLine=7602254;
 //BA.debugLineNum = 7602254;BA.debugLine="nextmonth = month+1";
_nextmonth = (int) (_month+1);
RDebugUtils.currentLine=7602255;
 //BA.debugLineNum = 7602255;BA.debugLine="nextyear = year";
_nextyear = _year;
RDebugUtils.currentLine=7602256;
 //BA.debugLineNum = 7602256;BA.debugLine="datestr = nextyear&\"-\"&NumberFormat(nextmonth";
_datestr = BA.NumberToString(_nextyear)+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_nextmonth,(int) (2),(int) (0))+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_displayday,(int) (2),(int) (0));
 };
 }}
;
RDebugUtils.currentLine=7602261;
 //BA.debugLineNum = 7602261;BA.debugLine="lbl.Text = displayday";
_lbl.setText(BA.ObjectToCharSequence(_displayday));
RDebugUtils.currentLine=7602262;
 //BA.debugLineNum = 7602262;BA.debugLine="cell.Tag = datestr";
_cell.setTag((Object)(_datestr));
RDebugUtils.currentLine=7602263;
 //BA.debugLineNum = 7602263;BA.debugLine="lbl.Enabled = False";
_lbl.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7602264;
 //BA.debugLineNum = 7602264;BA.debugLine="cell.AddView(lbl, 0, 0, cellW, cellH)";
_cell.AddView((android.view.View)(_lbl.getObject()),(int) (0),(int) (0),_cellw,_cellh);
RDebugUtils.currentLine=7602266;
 //BA.debugLineNum = 7602266;BA.debugLine="If CalendarMap.ContainsKey(datestr) Then";
if (_calendarmap.ContainsKey((Object)(_datestr))) { 
RDebugUtils.currentLine=7602267;
 //BA.debugLineNum = 7602267;BA.debugLine="Dim eventmap As Map = CalendarMap.Get(datestr)";
_eventmap = new anywheresoftware.b4a.objects.collections.Map();
_eventmap = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_calendarmap.Get((Object)(_datestr))));
RDebugUtils.currentLine=7602268;
 //BA.debugLineNum = 7602268;BA.debugLine="Dim allevents As List = eventmap.Get(\"AllEvent";
_allevents = new anywheresoftware.b4a.objects.collections.List();
_allevents = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_eventmap.Get((Object)("AllEvents"))));
RDebugUtils.currentLine=7602270;
 //BA.debugLineNum = 7602270;BA.debugLine="Dim maxShow As Int = Min(allevents.Size, 2)";
_maxshow = (int) (anywheresoftware.b4a.keywords.Common.Min(_allevents.getSize(),2));
RDebugUtils.currentLine=7602271;
 //BA.debugLineNum = 7602271;BA.debugLine="Dim yoffset As Int = 20dip";
_yoffset = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20));
RDebugUtils.currentLine=7602273;
 //BA.debugLineNum = 7602273;BA.debugLine="For i = 0 To maxShow -1";
{
final int step70 = 1;
final int limit70 = (int) (_maxshow-1);
_i = (int) (0) ;
for (;_i <= limit70 ;_i = _i + step70 ) {
RDebugUtils.currentLine=7602274;
 //BA.debugLineNum = 7602274;BA.debugLine="Dim ev As Map = allevents.Get(i)";
_ev = new anywheresoftware.b4a.objects.collections.Map();
_ev = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_allevents.Get(_i)));
RDebugUtils.currentLine=7602276;
 //BA.debugLineNum = 7602276;BA.debugLine="Dim dot As Label";
_dot = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7602277;
 //BA.debugLineNum = 7602277;BA.debugLine="dot.Initialize(\"\")";
_dot.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7602278;
 //BA.debugLineNum = 7602278;BA.debugLine="dot.Text = ev.Get(\"Title\")";
_dot.setText(BA.ObjectToCharSequence(_ev.Get((Object)("Title"))));
RDebugUtils.currentLine=7602279;
 //BA.debugLineNum = 7602279;BA.debugLine="dot.TextSize = 8";
_dot.setTextSize((float) (8));
RDebugUtils.currentLine=7602280;
 //BA.debugLineNum = 7602280;BA.debugLine="dot.TextColor = Colors.white";
_dot.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=7602281;
 //BA.debugLineNum = 7602281;BA.debugLine="dot.Color = IdentifyColor(ev.Get(\"Tags\"))";
_dot.setColor(_identifycolor(BA.ObjectToString(_ev.Get((Object)("Tags")))));
RDebugUtils.currentLine=7602282;
 //BA.debugLineNum = 7602282;BA.debugLine="dot.Gravity = Gravity.CENTER_VERTICAL";
_dot.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=7602283;
 //BA.debugLineNum = 7602283;BA.debugLine="dot.SingleLine = True";
_dot.setSingleLine(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7602284;
 //BA.debugLineNum = 7602284;BA.debugLine="dot.Ellipsize = \"END\"";
_dot.setEllipsize("END");
RDebugUtils.currentLine=7602285;
 //BA.debugLineNum = 7602285;BA.debugLine="cell.AddView(dot, 2dip, yoffset +i*12dip, cel";
_cell.AddView((android.view.View)(_dot.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (_yoffset+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12))),(int) (_cellw-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 }
};
RDebugUtils.currentLine=7602288;
 //BA.debugLineNum = 7602288;BA.debugLine="If allevents.Size > 2 Then";
if (_allevents.getSize()>2) { 
RDebugUtils.currentLine=7602289;
 //BA.debugLineNum = 7602289;BA.debugLine="Dim morelbl As Label";
_morelbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7602290;
 //BA.debugLineNum = 7602290;BA.debugLine="morelbl.Initialize(\"\")";
_morelbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7602291;
 //BA.debugLineNum = 7602291;BA.debugLine="morelbl.Text = \"+\" & (allevents.Size -2)";
_morelbl.setText(BA.ObjectToCharSequence("+"+BA.NumberToString((_allevents.getSize()-2))));
RDebugUtils.currentLine=7602292;
 //BA.debugLineNum = 7602292;BA.debugLine="morelbl.TextSize = 8";
_morelbl.setTextSize((float) (8));
RDebugUtils.currentLine=7602293;
 //BA.debugLineNum = 7602293;BA.debugLine="morelbl.TextColor = Colors.black";
_morelbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=7602294;
 //BA.debugLineNum = 7602294;BA.debugLine="cell.AddView(morelbl, 2dip , yoffset + 2 * 12";
_cell.AddView((android.view.View)(_morelbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),(int) (_yoffset+2*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12))),_cellw,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 };
 };
 }
};
 }
};
RDebugUtils.currentLine=7602301;
 //BA.debugLineNum = 7602301;BA.debugLine="End Sub";
return "";
}
public static String  _weekday(int _day) throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "weekday", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "weekday", new Object[] {_day}));}
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Sub Weekday (Day As Int)";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="If Day = 0 Then";
if (_day==0) { 
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="day_of_week = \"Sun\"";
mostCurrent._day_of_week = "Sun";
 }else 
{RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="Else if Day = 1 Then";
if (_day==1) { 
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="day_of_week = \"Mon\"";
mostCurrent._day_of_week = "Mon";
 }else 
{RDebugUtils.currentLine=7864325;
 //BA.debugLineNum = 7864325;BA.debugLine="Else if Day = 2 Then";
if (_day==2) { 
RDebugUtils.currentLine=7864326;
 //BA.debugLineNum = 7864326;BA.debugLine="day_of_week = \"Tue\"";
mostCurrent._day_of_week = "Tue";
 }else 
{RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="Else if Day = 3 Then";
if (_day==3) { 
RDebugUtils.currentLine=7864328;
 //BA.debugLineNum = 7864328;BA.debugLine="day_of_week = \"Wed\"";
mostCurrent._day_of_week = "Wed";
 }else 
{RDebugUtils.currentLine=7864329;
 //BA.debugLineNum = 7864329;BA.debugLine="Else if Day = 4 Then";
if (_day==4) { 
RDebugUtils.currentLine=7864330;
 //BA.debugLineNum = 7864330;BA.debugLine="day_of_week = \"Thu\"";
mostCurrent._day_of_week = "Thu";
 }else 
{RDebugUtils.currentLine=7864331;
 //BA.debugLineNum = 7864331;BA.debugLine="Else if Day = 5 Then";
if (_day==5) { 
RDebugUtils.currentLine=7864332;
 //BA.debugLineNum = 7864332;BA.debugLine="day_of_week = \"Fri\"";
mostCurrent._day_of_week = "Fri";
 }else {
RDebugUtils.currentLine=7864334;
 //BA.debugLineNum = 7864334;BA.debugLine="day_of_week = \"Sat\"";
mostCurrent._day_of_week = "Sat";
 }}}}}}
;
RDebugUtils.currentLine=7864336;
 //BA.debugLineNum = 7864336;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="calendaractivity";
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="End Sub";
return "";
}
public static String  _cell_click_click() throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cell_click_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cell_click_click", null));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
String _datestr = "";
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Sub cell_click_click";
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="Dim p As Panel = Sender";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=7733251;
 //BA.debugLineNum = 7733251;BA.debugLine="Dim datestr As String = p.Tag";
_datestr = BA.ObjectToString(_p.getTag());
RDebugUtils.currentLine=7733252;
 //BA.debugLineNum = 7733252;BA.debugLine="Activity.finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=7733253;
 //BA.debugLineNum = 7733253;BA.debugLine="StartActivity(day_module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._day_module.getObject()));
RDebugUtils.currentLine=7733254;
 //BA.debugLineNum = 7733254;BA.debugLine="day_module.currentDate = datestr";
mostCurrent._day_module._currentdate /*String*/  = _datestr;
RDebugUtils.currentLine=7733255;
 //BA.debugLineNum = 7733255;BA.debugLine="Log(datestr)";
anywheresoftware.b4a.keywords.Common.LogImpl("47733255",_datestr,0);
RDebugUtils.currentLine=7733257;
 //BA.debugLineNum = 7733257;BA.debugLine="End Sub";
return "";
}
public static String  _cleandebugger() throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cleandebugger", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cleandebugger", null));}
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Sub CleanDebugger";
RDebugUtils.currentLine=7536641;
 //BA.debugLineNum = 7536641;BA.debugLine="CalendarMap.Clear";
_calendarmap.Clear();
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="kvs.Put(\"CalendarKVS\", CalendarMap)";
_kvs._put("CalendarKVS",(Object)(_calendarmap.getObject()));
RDebugUtils.currentLine=7536643;
 //BA.debugLineNum = 7536643;BA.debugLine="End Sub";
return "";
}
public static String  _day_btn_click() throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "day_btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "day_btn_click", null));}
int _currentyear = 0;
int _currentmonth = 0;
int _currentday = 0;
String _datestr = "";
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Private Sub Day_btn_Click";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="If day_module.currentDate = \"\" Then";
if ((mostCurrent._day_module._currentdate /*String*/ ).equals("")) { 
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="Dim currentyear As Int = DateTime.GetYear(DateTi";
_currentyear = anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="Dim currentmonth As Int = DateTime.GetMonth(Date";
_currentmonth = anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="Dim currentday As Int = DateTime.GetDayOfMonth(D";
_currentday = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=8323077;
 //BA.debugLineNum = 8323077;BA.debugLine="Dim datestr As String= currentyear & \"-\" & Numbe";
_datestr = BA.NumberToString(_currentyear)+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_currentmonth,(int) (2),(int) (0))+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_currentday,(int) (2),(int) (0));
RDebugUtils.currentLine=8323078;
 //BA.debugLineNum = 8323078;BA.debugLine="day_module.currentDate = datestr";
mostCurrent._day_module._currentdate /*String*/  = _datestr;
RDebugUtils.currentLine=8323079;
 //BA.debugLineNum = 8323079;BA.debugLine="Log(day_module.currentDate)";
anywheresoftware.b4a.keywords.Common.LogImpl("48323079",mostCurrent._day_module._currentdate /*String*/ ,0);
 };
RDebugUtils.currentLine=8323082;
 //BA.debugLineNum = 8323082;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=8323083;
 //BA.debugLineNum = 8323083;BA.debugLine="StartActivity(day_module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._day_module.getObject()));
RDebugUtils.currentLine=8323084;
 //BA.debugLineNum = 8323084;BA.debugLine="End Sub";
return "";
}
public static int  _daysinamonth(int _month,int _year) throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "daysinamonth", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "daysinamonth", new Object[] {_month,_year}));}
int _nextmonth = 0;
int _nextyear = 0;
long _firstnextmonth = 0L;
long _lastdaydate = 0L;
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Sub Daysinamonth(Month As Int, year As Int) As Int";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="Dim nextMonth As Int";
_nextmonth = 0;
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="Dim nextyear As Int";
_nextyear = 0;
RDebugUtils.currentLine=7798788;
 //BA.debugLineNum = 7798788;BA.debugLine="If Month = 12 Then";
if (_month==12) { 
RDebugUtils.currentLine=7798789;
 //BA.debugLineNum = 7798789;BA.debugLine="nextMonth = 1";
_nextmonth = (int) (1);
RDebugUtils.currentLine=7798790;
 //BA.debugLineNum = 7798790;BA.debugLine="nextyear = year+1";
_nextyear = (int) (_year+1);
 }else {
RDebugUtils.currentLine=7798792;
 //BA.debugLineNum = 7798792;BA.debugLine="nextMonth = Month +1";
_nextmonth = (int) (_month+1);
RDebugUtils.currentLine=7798793;
 //BA.debugLineNum = 7798793;BA.debugLine="nextyear = year";
_nextyear = _year;
 };
RDebugUtils.currentLine=7798796;
 //BA.debugLineNum = 7798796;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy-MM-dd");
RDebugUtils.currentLine=7798797;
 //BA.debugLineNum = 7798797;BA.debugLine="Dim firstNextMonth As Long = DateTime.DateParse(n";
_firstnextmonth = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(BA.NumberToString(_nextyear)+"-"+anywheresoftware.b4a.keywords.Common.NumberFormat(_nextmonth,(int) (2),(int) (0))+"-01");
RDebugUtils.currentLine=7798798;
 //BA.debugLineNum = 7798798;BA.debugLine="Dim lastDayDate As Long = firstNextMonth - DateTi";
_lastdaydate = (long) (_firstnextmonth-anywheresoftware.b4a.keywords.Common.DateTime.TicksPerDay);
RDebugUtils.currentLine=7798801;
 //BA.debugLineNum = 7798801;BA.debugLine="Return DateTime.GetDayOfMonth(lastDayDate)";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(_lastdaydate);
RDebugUtils.currentLine=7798803;
 //BA.debugLineNum = 7798803;BA.debugLine="End Sub";
return 0;
}
public static int  _identifycolor(String _typeofevent) throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "identifycolor", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "identifycolor", new Object[] {_typeofevent}));}
int _mycolor = 0;
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Sub IdentifyColor (typeofevent As String) As Int";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Dim mycolor As Int";
_mycolor = 0;
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="If typeofevent = \"Task\" Then";
if ((_typeofevent).equals("Task")) { 
RDebugUtils.currentLine=7667715;
 //BA.debugLineNum = 7667715;BA.debugLine="mycolor = Colors.ARGB(255, 0, 191, 255)";
_mycolor = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (0),(int) (191),(int) (255));
 }else 
{RDebugUtils.currentLine=7667716;
 //BA.debugLineNum = 7667716;BA.debugLine="Else if typeofevent = \"Event\" Then";
if ((_typeofevent).equals("Event")) { 
RDebugUtils.currentLine=7667717;
 //BA.debugLineNum = 7667717;BA.debugLine="mycolor = Colors.ARGB(255, 152, 255, 152)";
_mycolor = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (152),(int) (255),(int) (152));
 }else 
{RDebugUtils.currentLine=7667718;
 //BA.debugLineNum = 7667718;BA.debugLine="Else if typeofevent = \"Birthday\" Then";
if ((_typeofevent).equals("Birthday")) { 
RDebugUtils.currentLine=7667719;
 //BA.debugLineNum = 7667719;BA.debugLine="mycolor = Colors.ARGB(255, 255, 182, 193)";
_mycolor = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (255),(int) (182),(int) (193));
 }else 
{RDebugUtils.currentLine=7667720;
 //BA.debugLineNum = 7667720;BA.debugLine="Else if typeofevent = \"OOO\" Then";
if ((_typeofevent).equals("OOO")) { 
RDebugUtils.currentLine=7667721;
 //BA.debugLineNum = 7667721;BA.debugLine="mycolor = Colors.ARGB(255, 255, 215, 0)";
_mycolor = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (255),(int) (215),(int) (0));
 }}}}
;
RDebugUtils.currentLine=7667723;
 //BA.debugLineNum = 7667723;BA.debugLine="Return mycolor";
if (true) return _mycolor;
RDebugUtils.currentLine=7667724;
 //BA.debugLineNum = 7667724;BA.debugLine="End Sub";
return 0;
}
public static String  _menu_btn_click() throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "menu_btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "menu_btn_click", null));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Private Sub menu_btn_Click";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="menupanel.Visible =True";
mostCurrent._menupanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="End Sub";
return "";
}
public static String  _month_btn_click() throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "month_btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "month_btn_click", null));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Private Sub Month_btn_Click";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="menupanel.Visible = False";
mostCurrent._menupanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="End Sub";
return "";
}
public static String  _monthsp_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "monthsp_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "monthsp_itemclick", new Object[] {_position,_value}));}
int _selectedmonth = 0;
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Private Sub MonthSp_ItemClick (Position As Int, Va";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="Dim selectedmonth As Int = Position +1";
_selectedmonth = (int) (_position+1);
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="DrawCalendar(selectedmonth, DateTime.GetYear(Date";
_drawcalendar(_selectedmonth,anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="End Sub";
return "";
}
public static String  _sched_btn_click() throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sched_btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sched_btn_click", null));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Private Sub sched_btn_Click";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="StartActivity(Schedule_module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._schedule_module.getObject()));
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="End Sub";
return "";
}
public static String  _yearsp_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="calendaractivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "yearsp_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "yearsp_itemclick", new Object[] {_position,_value}));}
int _selectedyear = 0;
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Private Sub YearSP_ItemClick (Position As Int, Val";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Dim selectedyear As Int = Value";
_selectedyear = (int)(BA.ObjectToNumber(_value));
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="DrawCalendar(MonthSp.SelectedIndex +1, selectedye";
_drawcalendar((int) (mostCurrent._monthsp.getSelectedIndex()+1),_selectedyear);
RDebugUtils.currentLine=8126468;
 //BA.debugLineNum = 8126468;BA.debugLine="End Sub";
return "";
}
}