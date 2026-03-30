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

public class add_events_module extends Activity implements B4AActivity{
	public static add_events_module mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.add_events_module");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (add_events_module).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.add_events_module");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.add_events_module", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (add_events_module) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (add_events_module) Resume **");
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
		return add_events_module.class;
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
            BA.LogInfo("** Activity (add_events_module) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (add_events_module) Pause event (activity is not paused). **");
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
            add_events_module mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (add_events_module) Resume **");
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
public static String _eventtype = "";
public static String _currentdate = "";
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _taskrb = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _eventrb = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _birthdayrb = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _ooorb = null;
public anywheresoftware.b4a.objects.LabelWrapper _timelbl = null;
public anywheresoftware.b4a.objects.EditTextWrapper _title_et = null;
public anywheresoftware.b4a.objects.EditTextWrapper _description_et = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.themeactivity _themeactivity = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.card_module _card_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.todoactivity _todoactivity = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=15073280;
 //BA.debugLineNum = 15073280;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=15073283;
 //BA.debugLineNum = 15073283;BA.debugLine="Activity.LoadLayout(\"AEMLayout\")";
mostCurrent._activity.LoadLayout("AEMLayout",mostCurrent.activityBA);
RDebugUtils.currentLine=15073284;
 //BA.debugLineNum = 15073284;BA.debugLine="timelbl.Text = currentDate";
mostCurrent._timelbl.setText(BA.ObjectToCharSequence(_currentdate));
RDebugUtils.currentLine=15073286;
 //BA.debugLineNum = 15073286;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="add_events_module";
RDebugUtils.currentLine=15204352;
 //BA.debugLineNum = 15204352;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=15204353;
 //BA.debugLineNum = 15204353;BA.debugLine="eventrb.Checked = False";
mostCurrent._eventrb.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=15204354;
 //BA.debugLineNum = 15204354;BA.debugLine="taskrb.Checked = False";
mostCurrent._taskrb.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=15204355;
 //BA.debugLineNum = 15204355;BA.debugLine="birthdayrb.Checked = False";
mostCurrent._birthdayrb.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=15204356;
 //BA.debugLineNum = 15204356;BA.debugLine="ooorb.Checked = False";
mostCurrent._ooorb.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=15204357;
 //BA.debugLineNum = 15204357;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=15138816;
 //BA.debugLineNum = 15138816;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=15138817;
 //BA.debugLineNum = 15138817;BA.debugLine="If eventtype = \"Event\" Then";
if ((_eventtype).equals("Event")) { 
RDebugUtils.currentLine=15138818;
 //BA.debugLineNum = 15138818;BA.debugLine="eventrb.Checked = True";
mostCurrent._eventrb.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=15138819;
 //BA.debugLineNum = 15138819;BA.debugLine="Else if eventtype = \"Task\" Then";
if ((_eventtype).equals("Task")) { 
RDebugUtils.currentLine=15138820;
 //BA.debugLineNum = 15138820;BA.debugLine="taskrb.Checked = True";
mostCurrent._taskrb.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=15138821;
 //BA.debugLineNum = 15138821;BA.debugLine="Else if eventtype = \"Birthday\" Then";
if ((_eventtype).equals("Birthday")) { 
RDebugUtils.currentLine=15138822;
 //BA.debugLineNum = 15138822;BA.debugLine="birthdayrb.Checked = True";
mostCurrent._birthdayrb.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=15138823;
 //BA.debugLineNum = 15138823;BA.debugLine="Else if eventtype = \"OOO\" Then";
if ((_eventtype).equals("OOO")) { 
RDebugUtils.currentLine=15138824;
 //BA.debugLineNum = 15138824;BA.debugLine="ooorb.Checked = True";
mostCurrent._ooorb.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }}}}
;
RDebugUtils.currentLine=15138826;
 //BA.debugLineNum = 15138826;BA.debugLine="End Sub";
return "";
}
public static String  _birthdayrb_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "birthdayrb_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "birthdayrb_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=15597568;
 //BA.debugLineNum = 15597568;BA.debugLine="Private Sub birthdayrb_CheckedChange(Checked As Bo";
RDebugUtils.currentLine=15597569;
 //BA.debugLineNum = 15597569;BA.debugLine="eventtype = \"Birthday\"";
_eventtype = "Birthday";
RDebugUtils.currentLine=15597570;
 //BA.debugLineNum = 15597570;BA.debugLine="End Sub";
return "";
}
public static String  _eventrb_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "eventrb_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "eventrb_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=15663104;
 //BA.debugLineNum = 15663104;BA.debugLine="Private Sub eventrb_CheckedChange(Checked As Boole";
RDebugUtils.currentLine=15663105;
 //BA.debugLineNum = 15663105;BA.debugLine="eventtype = \"Event\"";
_eventtype = "Event";
RDebugUtils.currentLine=15663106;
 //BA.debugLineNum = 15663106;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _mapinitializer() throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mapinitializer", false))
	 {return ((anywheresoftware.b4a.objects.collections.Map) Debug.delegate(mostCurrent.activityBA, "mapinitializer", null));}
anywheresoftware.b4a.objects.collections.Map _eventmap = null;
anywheresoftware.b4a.objects.collections.List _allevents = null;
anywheresoftware.b4a.objects.collections.List _timeline = null;
RDebugUtils.currentLine=15400960;
 //BA.debugLineNum = 15400960;BA.debugLine="Sub MapInitializer As Map";
RDebugUtils.currentLine=15400961;
 //BA.debugLineNum = 15400961;BA.debugLine="Dim eventmap As Map";
_eventmap = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=15400963;
 //BA.debugLineNum = 15400963;BA.debugLine="eventmap.Initialize";
_eventmap.Initialize();
RDebugUtils.currentLine=15400964;
 //BA.debugLineNum = 15400964;BA.debugLine="Dim allevents As List";
_allevents = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=15400965;
 //BA.debugLineNum = 15400965;BA.debugLine="allevents.initialize";
_allevents.Initialize();
RDebugUtils.currentLine=15400967;
 //BA.debugLineNum = 15400967;BA.debugLine="Dim timeline As List";
_timeline = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=15400968;
 //BA.debugLineNum = 15400968;BA.debugLine="timeline.initialize";
_timeline.Initialize();
RDebugUtils.currentLine=15400970;
 //BA.debugLineNum = 15400970;BA.debugLine="eventmap.Put(\"AllEvents\", allevents)";
_eventmap.Put((Object)("AllEvents"),(Object)(_allevents.getObject()));
RDebugUtils.currentLine=15400971;
 //BA.debugLineNum = 15400971;BA.debugLine="eventmap.Put(\"Timeline\", timeline)";
_eventmap.Put((Object)("Timeline"),(Object)(_timeline.getObject()));
RDebugUtils.currentLine=15400973;
 //BA.debugLineNum = 15400973;BA.debugLine="CalendarActivity.CalendarMap.Put(day_module.curre";
mostCurrent._calendaractivity._calendarmap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)(mostCurrent._day_module._currentdate /*String*/ ),(Object)(_eventmap.getObject()));
RDebugUtils.currentLine=15400975;
 //BA.debugLineNum = 15400975;BA.debugLine="Return eventmap";
if (true) return _eventmap;
RDebugUtils.currentLine=15400976;
 //BA.debugLineNum = 15400976;BA.debugLine="End Sub";
return null;
}
public static String  _ooorb_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ooorb_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ooorb_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=15532032;
 //BA.debugLineNum = 15532032;BA.debugLine="Private Sub ooorb_CheckedChange(Checked As Boolean";
RDebugUtils.currentLine=15532033;
 //BA.debugLineNum = 15532033;BA.debugLine="eventtype = \"OOO\"";
_eventtype = "OOO";
RDebugUtils.currentLine=15532034;
 //BA.debugLineNum = 15532034;BA.debugLine="End Sub";
return "";
}
public static String  _save_btn_click() throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "save_btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "save_btn_click", null));}
anywheresoftware.b4a.objects.collections.Map _eventmap = null;
anywheresoftware.b4a.objects.collections.List _getallevents = null;
anywheresoftware.b4a.objects.collections.Map _putevent = null;
RDebugUtils.currentLine=15466496;
 //BA.debugLineNum = 15466496;BA.debugLine="Private Sub save_btn_Click";
RDebugUtils.currentLine=15466497;
 //BA.debugLineNum = 15466497;BA.debugLine="Dim eventmap As Map";
_eventmap = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=15466498;
 //BA.debugLineNum = 15466498;BA.debugLine="If title_et.text = \"\" Then";
if ((mostCurrent._title_et.getText()).equals("")) { 
RDebugUtils.currentLine=15466499;
 //BA.debugLineNum = 15466499;BA.debugLine="MsgboxAsync(\"Enter The Event Title\", \"Error\")";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Enter The Event Title"),BA.ObjectToCharSequence("Error"),processBA);
RDebugUtils.currentLine=15466500;
 //BA.debugLineNum = 15466500;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=15466503;
 //BA.debugLineNum = 15466503;BA.debugLine="If CalendarActivity.CalendarMap.ContainsKey(day_m";
if (mostCurrent._calendaractivity._calendarmap /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)(mostCurrent._day_module._currentdate /*String*/ ))) { 
RDebugUtils.currentLine=15466504;
 //BA.debugLineNum = 15466504;BA.debugLine="eventmap = CalendarActivity.CalendarMap.Get(day_";
_eventmap = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(mostCurrent._calendaractivity._calendarmap /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)(mostCurrent._day_module._currentdate /*String*/ ))));
 }else {
RDebugUtils.currentLine=15466506;
 //BA.debugLineNum = 15466506;BA.debugLine="eventmap = MapInitializer";
_eventmap = _mapinitializer();
 };
RDebugUtils.currentLine=15466509;
 //BA.debugLineNum = 15466509;BA.debugLine="Dim getAllevents As List = eventmap.Get(\"AllEvent";
_getallevents = new anywheresoftware.b4a.objects.collections.List();
_getallevents = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_eventmap.Get((Object)("AllEvents"))));
RDebugUtils.currentLine=15466510;
 //BA.debugLineNum = 15466510;BA.debugLine="Dim putevent As Map";
_putevent = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=15466511;
 //BA.debugLineNum = 15466511;BA.debugLine="putevent.Initialize";
_putevent.Initialize();
RDebugUtils.currentLine=15466512;
 //BA.debugLineNum = 15466512;BA.debugLine="putevent.Put(\"Title\", title_et.Text)";
_putevent.Put((Object)("Title"),(Object)(mostCurrent._title_et.getText()));
RDebugUtils.currentLine=15466513;
 //BA.debugLineNum = 15466513;BA.debugLine="putevent.Put(\"Description\", description_et.Text)";
_putevent.Put((Object)("Description"),(Object)(mostCurrent._description_et.getText()));
RDebugUtils.currentLine=15466514;
 //BA.debugLineNum = 15466514;BA.debugLine="putevent.Put(\"Tags\", eventtype)";
_putevent.Put((Object)("Tags"),(Object)(_eventtype));
RDebugUtils.currentLine=15466516;
 //BA.debugLineNum = 15466516;BA.debugLine="getAllevents.Add(putevent)";
_getallevents.Add((Object)(_putevent.getObject()));
RDebugUtils.currentLine=15466517;
 //BA.debugLineNum = 15466517;BA.debugLine="SaveCalendar";
_savecalendar();
RDebugUtils.currentLine=15466518;
 //BA.debugLineNum = 15466518;BA.debugLine="day_module.addeventsfeedback = True";
mostCurrent._day_module._addeventsfeedback /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=15466519;
 //BA.debugLineNum = 15466519;BA.debugLine="Activity.finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=15466520;
 //BA.debugLineNum = 15466520;BA.debugLine="End Sub";
return "";
}
public static String  _savecalendar() throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "savecalendar", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "savecalendar", null));}
RDebugUtils.currentLine=15335424;
 //BA.debugLineNum = 15335424;BA.debugLine="Sub SaveCalendar";
RDebugUtils.currentLine=15335425;
 //BA.debugLineNum = 15335425;BA.debugLine="CalendarActivity.kvs.put(\"CalendarKVS\", CalendarA";
mostCurrent._calendaractivity._kvs /*b4a.example3.keyvaluestore*/ ._put("CalendarKVS",(Object)(mostCurrent._calendaractivity._calendarmap /*anywheresoftware.b4a.objects.collections.Map*/ .getObject()));
RDebugUtils.currentLine=15335426;
 //BA.debugLineNum = 15335426;BA.debugLine="End Sub";
return "";
}
public static String  _taskrb_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "taskrb_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "taskrb_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=15728640;
 //BA.debugLineNum = 15728640;BA.debugLine="Private Sub taskrb_CheckedChange(Checked As Boolea";
RDebugUtils.currentLine=15728641;
 //BA.debugLineNum = 15728641;BA.debugLine="eventtype = \"Task\"";
_eventtype = "Task";
RDebugUtils.currentLine=15728642;
 //BA.debugLineNum = 15728642;BA.debugLine="End Sub";
return "";
}
public static String  _x_btn_click() throws Exception{
RDebugUtils.currentModule="add_events_module";
if (Debug.shouldDelegate(mostCurrent.activityBA, "x_btn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "x_btn_click", null));}
RDebugUtils.currentLine=15269888;
 //BA.debugLineNum = 15269888;BA.debugLine="Private Sub x_btn_Click";
RDebugUtils.currentLine=15269889;
 //BA.debugLineNum = 15269889;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=15269890;
 //BA.debugLineNum = 15269890;BA.debugLine="End Sub";
return "";
}
}