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

public class schedule_module extends Activity implements B4AActivity{
	public static schedule_module mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.schedule_module");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (schedule_module).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.schedule_module");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.schedule_module", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (schedule_module) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (schedule_module) Resume **");
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
		return schedule_module.class;
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
            BA.LogInfo("** Activity (schedule_module) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (schedule_module) Pause event (activity is not paused). **");
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
            schedule_module mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (schedule_module) Resume **");
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

public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.PanelWrapper _menupanel = null;
public anywheresoftware.b4a.objects.ButtonWrapper _sched_btn = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _schedulesv = null;
public anywheresoftware.b4a.objects.LabelWrapper _noschedlabel = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.themeactivity _themeactivity = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.todoactivity _todoactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.day_module _day_module = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.card_module _card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public b4a.example.navactivity _navactivity = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 24;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"Schedule_ModuleLayout\")";
mostCurrent._activity.LoadLayout("Schedule_ModuleLayout",mostCurrent.activityBA);
 }else {
 //BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"Schedule_ModuleLayoutDark\")";
mostCurrent._activity.LoadLayout("Schedule_ModuleLayoutDark",mostCurrent.activityBA);
 };
 //BA.debugLineNum = 30;BA.debugLine="sched_btn.Color = Colors.blue";
mostCurrent._sched_btn.setColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 31;BA.debugLine="DrawSchedule";
_drawschedule();
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 185;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public static String  _day_btn_click() throws Exception{
int _currentyear = 0;
int _currentmonth = 0;
int _currentday = 0;
 //BA.debugLineNum = 198;BA.debugLine="Private Sub Day_btn_Click";
 //BA.debugLineNum = 199;BA.debugLine="Dim currentyear As Int = DateTime.GetYear(DateTim";
_currentyear = anywheresoftware.b4a.keywords.Common.DateTime.GetYear(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 200;BA.debugLine="Dim currentmonth As Int = DateTime.GetMonth(DateT";
_currentmonth = anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 201;BA.debugLine="Dim currentday As Int = DateTime.GetDayOfMonth(Da";
_currentday = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 202;BA.debugLine="day_module.currentDate = currentyear & \"-\" & curr";
mostCurrent._day_module._currentdate /*String*/  = BA.NumberToString(_currentyear)+"-"+BA.NumberToString(_currentmonth)+"-"+BA.NumberToString(_currentday);
 //BA.debugLineNum = 203;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 204;BA.debugLine="StartActivity(day_module)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._day_module.getObject()));
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public static String  _drawschedule() throws Exception{
int _y = 0;
anywheresoftware.b4a.objects.collections.List _sorteddates = null;
String _keys = "";
String _date = "";
anywheresoftware.b4a.objects.collections.Map _eventmap = null;
anywheresoftware.b4a.objects.collections.List _allevents = null;
anywheresoftware.b4a.objects.collections.List _timeline = null;
anywheresoftware.b4a.objects.LabelWrapper _lbldate = null;
anywheresoftware.b4a.objects.collections.Map _ev = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
int _st = 0;
int _en = 0;
 //BA.debugLineNum = 35;BA.debugLine="Sub DrawSchedule";
 //BA.debugLineNum = 36;BA.debugLine="scheduleSV.Panel.RemoveAllViews";
mostCurrent._schedulesv.getPanel().RemoveAllViews();
 //BA.debugLineNum = 38;BA.debugLine="Dim y As Int = 0";
_y = (int) (0);
 //BA.debugLineNum = 39;BA.debugLine="Dim sortedDates As List";
_sorteddates = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 40;BA.debugLine="sortedDates.Initialize";
_sorteddates.Initialize();
 //BA.debugLineNum = 42;BA.debugLine="If CalendarActivity.CalendarMap.Size = 0 Then";
if (mostCurrent._calendaractivity._calendarmap /*anywheresoftware.b4a.objects.collections.Map*/ .getSize()==0) { 
 //BA.debugLineNum = 43;BA.debugLine="noschedlabel.Text = \"No Schedule\"";
mostCurrent._noschedlabel.setText(BA.ObjectToCharSequence("No Schedule"));
 };
 //BA.debugLineNum = 46;BA.debugLine="For Each keys As String In CalendarActivity.Calen";
{
final anywheresoftware.b4a.BA.IterableList group8 = mostCurrent._calendaractivity._calendarmap /*anywheresoftware.b4a.objects.collections.Map*/ .Keys();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_keys = BA.ObjectToString(group8.Get(index8));
 //BA.debugLineNum = 47;BA.debugLine="sortedDates.Add(keys)";
_sorteddates.Add((Object)(_keys));
 //BA.debugLineNum = 48;BA.debugLine="Log(keys)";
anywheresoftware.b4a.keywords.Common.LogImpl("020316173",_keys,0);
 }
};
 //BA.debugLineNum = 51;BA.debugLine="sortedDates.Sort(True)";
_sorteddates.Sort(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 53;BA.debugLine="For Each date As String In sortedDates";
{
final anywheresoftware.b4a.BA.IterableList group13 = _sorteddates;
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_date = BA.ObjectToString(group13.Get(index13));
 //BA.debugLineNum = 54;BA.debugLine="Dim eventmap As Map = CalendarActivity.CalendarM";
_eventmap = new anywheresoftware.b4a.objects.collections.Map();
_eventmap = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._calendaractivity._calendarmap /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(_date))));
 //BA.debugLineNum = 55;BA.debugLine="Dim allevents As List = eventmap.Get(\"AllEvents\"";
_allevents = new anywheresoftware.b4a.objects.collections.List();
_allevents = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_eventmap.Get((Object)("AllEvents"))));
 //BA.debugLineNum = 56;BA.debugLine="Dim timeline As List = eventmap.Get(\"Timeline\")";
_timeline = new anywheresoftware.b4a.objects.collections.List();
_timeline = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_eventmap.Get((Object)("Timeline"))));
 //BA.debugLineNum = 58;BA.debugLine="Dim lbldate As Label";
_lbldate = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 59;BA.debugLine="lbldate.initialize(\"\")";
_lbldate.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 60;BA.debugLine="lbldate.Text = SetDate(date)";
_lbldate.setText(BA.ObjectToCharSequence(_setdate(_date)));
 //BA.debugLineNum = 61;BA.debugLine="lbldate.TextSize = 16";
_lbldate.setTextSize((float) (16));
 //BA.debugLineNum = 62;BA.debugLine="lbldate.Color = Colors.LightGray";
_lbldate.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 //BA.debugLineNum = 63;BA.debugLine="lbldate.TextColor = Colors.Black";
_lbldate.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 65;BA.debugLine="If allevents.Size = 0 And timeline.size = 0 Then";
if (_allevents.getSize()==0 && _timeline.getSize()==0) { 
 //BA.debugLineNum = 66;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 69;BA.debugLine="scheduleSV.Panel.AddView(lbldate, 0, y, schedule";
mostCurrent._schedulesv.getPanel().AddView((android.view.View)(_lbldate.getObject()),(int) (0),_y,mostCurrent._schedulesv.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 70;BA.debugLine="y = y+ 40dip";
_y = (int) (_y+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 72;BA.debugLine="For Each ev As Map In allevents";
_ev = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group28 = _allevents;
final int groupLen28 = group28.getSize()
;int index28 = 0;
;
for (; index28 < groupLen28;index28++){
_ev = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group28.Get(index28)));
 //BA.debugLineNum = 73;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 74;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 75;BA.debugLine="lbl.Text = ev.Get(\"Title\")";
_lbl.setText(BA.ObjectToCharSequence(_ev.Get((Object)("Title"))));
 //BA.debugLineNum = 76;BA.debugLine="lbl.Color = IdentifyColor(ev.Get(\"Tags\"))";
_lbl.setColor(_identifycolor(BA.ObjectToString(_ev.Get((Object)("Tags")))));
 //BA.debugLineNum = 77;BA.debugLine="lbl.TextColor = Colors.Black";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 78;BA.debugLine="scheduleSV.Panel.AddView(lbl, 10dip, y, schedul";
mostCurrent._schedulesv.getPanel().AddView((android.view.View)(_lbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_y,(int) (mostCurrent._schedulesv.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 79;BA.debugLine="y = y + 40dip";
_y = (int) (_y+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 }
};
 //BA.debugLineNum = 83;BA.debugLine="For Each ev As Map In timeline";
_ev = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group37 = _timeline;
final int groupLen37 = group37.getSize()
;int index37 = 0;
;
for (; index37 < groupLen37;index37++){
_ev = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group37.Get(index37)));
 //BA.debugLineNum = 84;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 85;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 86;BA.debugLine="Dim st As Int = ev.Get(\"Start\")";
_st = (int)(BA.ObjectToNumber(_ev.Get((Object)("Start"))));
 //BA.debugLineNum = 87;BA.debugLine="Dim en As Int = ev.Get(\"End\")";
_en = (int)(BA.ObjectToNumber(_ev.Get((Object)("End"))));
 //BA.debugLineNum = 88;BA.debugLine="lbl.Text = ev.Get(\"Title\") & \" (\" & GetTimeStri";
_lbl.setText(BA.ObjectToCharSequence(BA.ObjectToString(_ev.Get((Object)("Title")))+" ("+_gettimestring(_st)+" - "+_gettimestring(_en)+")"));
 //BA.debugLineNum = 90;BA.debugLine="lbl.Color = IdentifyColor(ev.Get(\"Tags\"))";
_lbl.setColor(_identifycolor(BA.ObjectToString(_ev.Get((Object)("Tags")))));
 //BA.debugLineNum = 91;BA.debugLine="lbl.TextColor = Colors.Black";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 92;BA.debugLine="scheduleSV.Panel.AddView(lbl, 10dip, y, schedul";
mostCurrent._schedulesv.getPanel().AddView((android.view.View)(_lbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_y,(int) (mostCurrent._schedulesv.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 93;BA.debugLine="y = y+40dip";
_y = (int) (_y+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 }
};
 }
};
 //BA.debugLineNum = 96;BA.debugLine="scheduleSV.Panel.Height = y";
mostCurrent._schedulesv.getPanel().setHeight(_y);
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public static String  _gettimestring(int _h) throws Exception{
int _num = 0;
String _ampm = "";
 //BA.debugLineNum = 101;BA.debugLine="Sub GetTimeString (h As Int) As String";
 //BA.debugLineNum = 102;BA.debugLine="Dim num As Int";
_num = 0;
 //BA.debugLineNum = 103;BA.debugLine="Dim ampm As String";
_ampm = "";
 //BA.debugLineNum = 104;BA.debugLine="If h = 0 Then";
if (_h==0) { 
 //BA.debugLineNum = 105;BA.debugLine="num = 12";
_num = (int) (12);
 //BA.debugLineNum = 106;BA.debugLine="ampm = \"am\"";
_ampm = "am";
 }else if(_h==12) { 
 //BA.debugLineNum = 108;BA.debugLine="num = h";
_num = _h;
 //BA.debugLineNum = 109;BA.debugLine="ampm = \"pm\"";
_ampm = "pm";
 }else if(_h>12) { 
 //BA.debugLineNum = 111;BA.debugLine="num = h - 12";
_num = (int) (_h-12);
 //BA.debugLineNum = 112;BA.debugLine="If num = 12 Then";
if (_num==12) { 
 //BA.debugLineNum = 113;BA.debugLine="ampm = \"am\"";
_ampm = "am";
 }else {
 //BA.debugLineNum = 115;BA.debugLine="ampm = \"pm\"";
_ampm = "pm";
 };
 }else {
 //BA.debugLineNum = 119;BA.debugLine="num = h";
_num = _h;
 //BA.debugLineNum = 120;BA.debugLine="ampm = \"am\"";
_ampm = "am";
 };
 //BA.debugLineNum = 123;BA.debugLine="Return num & \":00\" & ampm";
if (true) return BA.NumberToString(_num)+":00"+_ampm;
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private menupanel As Panel";
mostCurrent._menupanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private sched_btn As Button";
mostCurrent._sched_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private scheduleSV As ScrollView";
mostCurrent._schedulesv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private noschedlabel As Label";
mostCurrent._noschedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static int  _identifycolor(String _typeofevent) throws Exception{
int _mycolor = 0;
 //BA.debugLineNum = 127;BA.debugLine="Sub IdentifyColor (typeofevent As String) As Int";
 //BA.debugLineNum = 128;BA.debugLine="Dim mycolor As Int";
_mycolor = 0;
 //BA.debugLineNum = 129;BA.debugLine="If typeofevent = \"Task\" Then";
if ((_typeofevent).equals("Task")) { 
 //BA.debugLineNum = 130;BA.debugLine="mycolor = Colors.Blue";
_mycolor = anywheresoftware.b4a.keywords.Common.Colors.Blue;
 }else if((_typeofevent).equals("Event")) { 
 //BA.debugLineNum = 132;BA.debugLine="mycolor = Colors.Green";
_mycolor = anywheresoftware.b4a.keywords.Common.Colors.Green;
 }else if((_typeofevent).equals("Birthday")) { 
 //BA.debugLineNum = 134;BA.debugLine="mycolor = Colors.Magenta";
_mycolor = anywheresoftware.b4a.keywords.Common.Colors.Magenta;
 }else if((_typeofevent).equals("OOO")) { 
 //BA.debugLineNum = 136;BA.debugLine="mycolor = Colors.Yellow";
_mycolor = anywheresoftware.b4a.keywords.Common.Colors.Yellow;
 };
 //BA.debugLineNum = 139;BA.debugLine="Return mycolor";
if (true) return _mycolor;
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return 0;
}
public static String  _menu_btn_click() throws Exception{
 //BA.debugLineNum = 189;BA.debugLine="Private Sub menu_btn_Click";
 //BA.debugLineNum = 190;BA.debugLine="menupanel.Visible =True";
mostCurrent._menupanel.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public static String  _month_btn_click() throws Exception{
 //BA.debugLineNum = 207;BA.debugLine="Private Sub Month_btn_Click";
 //BA.debugLineNum = 208;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 209;BA.debugLine="StartActivity(CalendarActivity)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._calendaractivity.getObject()));
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _sched_btn_click() throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Private Sub sched_btn_Click";
 //BA.debugLineNum = 195;BA.debugLine="menupanel.visible = False";
mostCurrent._menupanel.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return "";
}
public static String  _setdate(String _tagdate) throws Exception{
String[] _parts = null;
String _year = "";
int _monthnum = 0;
String _day = "";
String _monthname = "";
long _ts = 0L;
int _weekdaynum = 0;
String _week = "";
 //BA.debugLineNum = 142;BA.debugLine="Sub SetDate(Tagdate As String) As String";
 //BA.debugLineNum = 144;BA.debugLine="Dim parts() As String = Regex.Split(\"-\", Tagdate)";
_parts = anywheresoftware.b4a.keywords.Common.Regex.Split("-",_tagdate);
 //BA.debugLineNum = 145;BA.debugLine="Dim year As String = parts(0)";
_year = _parts[(int) (0)];
 //BA.debugLineNum = 146;BA.debugLine="Dim monthNum As Int = parts(1)";
_monthnum = (int)(Double.parseDouble(_parts[(int) (1)]));
 //BA.debugLineNum = 147;BA.debugLine="Dim day As String = parts(2)";
_day = _parts[(int) (2)];
 //BA.debugLineNum = 149;BA.debugLine="Dim monthName As String";
_monthname = "";
 //BA.debugLineNum = 150;BA.debugLine="Select monthNum";
switch (_monthnum) {
case 1: {
 //BA.debugLineNum = 151;BA.debugLine="Case 1: monthName = \"January\"";
_monthname = "January";
 break; }
case 2: {
 //BA.debugLineNum = 152;BA.debugLine="Case 2: monthName = \"February\"";
_monthname = "February";
 break; }
case 3: {
 //BA.debugLineNum = 153;BA.debugLine="Case 3: monthName = \"March\"";
_monthname = "March";
 break; }
case 4: {
 //BA.debugLineNum = 154;BA.debugLine="Case 4: monthName = \"April\"";
_monthname = "April";
 break; }
case 5: {
 //BA.debugLineNum = 155;BA.debugLine="Case 5: monthName = \"May\"";
_monthname = "May";
 break; }
case 6: {
 //BA.debugLineNum = 156;BA.debugLine="Case 6: monthName = \"June\"";
_monthname = "June";
 break; }
case 7: {
 //BA.debugLineNum = 157;BA.debugLine="Case 7: monthName = \"July\"";
_monthname = "July";
 break; }
case 8: {
 //BA.debugLineNum = 158;BA.debugLine="Case 8: monthName = \"August\"";
_monthname = "August";
 break; }
case 9: {
 //BA.debugLineNum = 159;BA.debugLine="Case 9: monthName = \"September\"";
_monthname = "September";
 break; }
case 10: {
 //BA.debugLineNum = 160;BA.debugLine="Case 10: monthName = \"October\"";
_monthname = "October";
 break; }
case 11: {
 //BA.debugLineNum = 161;BA.debugLine="Case 11: monthName = \"November\"";
_monthname = "November";
 break; }
case 12: {
 //BA.debugLineNum = 162;BA.debugLine="Case 12: monthName = \"December\"";
_monthname = "December";
 break; }
}
;
 //BA.debugLineNum = 165;BA.debugLine="Dim ts As Long = DateTime.DateParse(Tagdate)";
_ts = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(_tagdate);
 //BA.debugLineNum = 166;BA.debugLine="Dim weekdayNum As Int = DateTime.GetDayOfWeek(ts)";
_weekdaynum = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(_ts);
 //BA.debugLineNum = 167;BA.debugLine="Dim week As String";
_week = "";
 //BA.debugLineNum = 168;BA.debugLine="Select weekdayNum";
switch (_weekdaynum) {
case 1: {
 //BA.debugLineNum = 169;BA.debugLine="Case 1: week = \"Sunday\"";
_week = "Sunday";
 break; }
case 2: {
 //BA.debugLineNum = 170;BA.debugLine="Case 2: week = \"Monday\"";
_week = "Monday";
 break; }
case 3: {
 //BA.debugLineNum = 171;BA.debugLine="Case 3: week = \"Tuesday\"";
_week = "Tuesday";
 break; }
case 4: {
 //BA.debugLineNum = 172;BA.debugLine="Case 4: week = \"Wednesday\"";
_week = "Wednesday";
 break; }
case 5: {
 //BA.debugLineNum = 173;BA.debugLine="Case 5: week = \"Thursday\"";
_week = "Thursday";
 break; }
case 6: {
 //BA.debugLineNum = 174;BA.debugLine="Case 6: week = \"Friday\"";
_week = "Friday";
 break; }
case 7: {
 //BA.debugLineNum = 175;BA.debugLine="Case 7: week = \"Saturday\"";
_week = "Saturday";
 break; }
}
;
 //BA.debugLineNum = 178;BA.debugLine="Return week & \", \" & monthName & \" \" & day & \", \"";
if (true) return _week+", "+_monthname+" "+_day+", "+_year;
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
}
