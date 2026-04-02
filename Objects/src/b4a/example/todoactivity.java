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

public class todoactivity extends Activity implements B4AActivity{
	public static todoactivity mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.todoactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (todoactivity).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.todoactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.todoactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (todoactivity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (todoactivity) Resume **");
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
		return todoactivity.class;
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
            BA.LogInfo("** Activity (todoactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (todoactivity) Pause event (activity is not paused). **");
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
            todoactivity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (todoactivity) Resume **");
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
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static b4a.example3.keyvaluestore _kvs = null;
public anywheresoftware.b4a.objects.EditTextWrapper _addtitletextarea = null;
public b4a.example3.customlistview _listslist = null;
public anywheresoftware.b4a.objects.ButtonWrapper _newlistbtn = null;
public b4a.example3.customlistview _taskslist = null;
public static boolean _isaddinglist = false;
public anywheresoftware.b4a.objects.PanelWrapper _addtaskbtnpnl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _addtaskbtn = null;
public static String _currentlist = "";
public anywheresoftware.b4a.objects.PanelWrapper _addtaskpanel = null;
public anywheresoftware.b4a.objects.EditTextWrapper _addtasktextarea = null;
public anywheresoftware.b4a.objects.ButtonWrapper _entertaskbtn = null;
public static int _untitledno = 0;
public anywheresoftware.b4a.objects.LabelWrapper _progressnumber = null;
public anywheresoftware.b4a.objects.LabelWrapper _progresspercent = null;
public anywheresoftware.b4a.objects.ProgressBarWrapper _progressbar = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.card_module _card_module = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.editnote _editnote = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.themeactivity _themeactivity = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.collections.List _savedlists = null;
String _title = "";
 //BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 41;BA.debugLine="If Starter.darkMode Then";
if (mostCurrent._starter._darkmode /*boolean*/ ) { 
 //BA.debugLineNum = 42;BA.debugLine="Activity.LoadLayout(\"todoListLayoutDark.bal\")";
mostCurrent._activity.LoadLayout("todoListLayoutDark.bal",mostCurrent.activityBA);
 }else {
 //BA.debugLineNum = 44;BA.debugLine="Activity.LoadLayout(\"todoListLayout.bal\")";
mostCurrent._activity.LoadLayout("todoListLayout.bal",mostCurrent.activityBA);
 };
 //BA.debugLineNum = 47;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 48;BA.debugLine="addTitleTextArea.Background = Null";
mostCurrent._addtitletextarea.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 50;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
 //BA.debugLineNum = 51;BA.debugLine="tasksList.GetBase.Visible = False";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 53;BA.debugLine="kvs = Starter.taskKvs";
_kvs = mostCurrent._starter._taskkvs /*b4a.example3.keyvaluestore*/ ;
 //BA.debugLineNum = 55;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
 //BA.debugLineNum = 56;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
 //BA.debugLineNum = 57;BA.debugLine="For Each title As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group13 = _savedlists;
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_title = BA.ObjectToString(group13.Get(index13));
 //BA.debugLineNum = 58;BA.debugLine="listsList.AddTextItem(title, title)";
mostCurrent._listslist._addtextitem((Object)(_title),(Object)(_title));
 }
};
 };
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _addtaskbtn_click() throws Exception{
 //BA.debugLineNum = 334;BA.debugLine="Sub addTaskBtn_Click";
 //BA.debugLineNum = 336;BA.debugLine="addTaskBtn.Enabled = False";
mostCurrent._addtaskbtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 337;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
mostCurrent._taskslist._removeat((int) (mostCurrent._taskslist._getsize()-1));
 //BA.debugLineNum = 339;BA.debugLine="addTaskPanel.Initialize(\"addTaskPanel\")";
mostCurrent._addtaskpanel.Initialize(mostCurrent.activityBA,"addTaskPanel");
 //BA.debugLineNum = 340;BA.debugLine="addTaskPanel.SetLayout(10dip, 0, 250dip, 100dip)";
mostCurrent._addtaskpanel.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 //BA.debugLineNum = 341;BA.debugLine="If Starter.darkMode Then";
if (mostCurrent._starter._darkmode /*boolean*/ ) { 
 //BA.debugLineNum = 342;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 17, 17, 17";
mostCurrent._addtaskpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (17),(int) (17),(int) (17)));
 }else {
 //BA.debugLineNum = 344;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 247, 247,";
mostCurrent._addtaskpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (247),(int) (247),(int) (247)));
 };
 //BA.debugLineNum = 348;BA.debugLine="addTaskTextArea.Initialize(\"addTodoText\")";
mostCurrent._addtasktextarea.Initialize(mostCurrent.activityBA,"addTodoText");
 //BA.debugLineNum = 349;BA.debugLine="addTaskTextArea.Hint = \"Add a task...\"";
mostCurrent._addtasktextarea.setHint("Add a task...");
 //BA.debugLineNum = 350;BA.debugLine="If Starter.darkMode Then";
if (mostCurrent._starter._darkmode /*boolean*/ ) { 
 //BA.debugLineNum = 351;BA.debugLine="addTaskTextArea.HintColor = Colors.ARGB(255, 247";
mostCurrent._addtasktextarea.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (247),(int) (247),(int) (247)));
 }else {
 //BA.debugLineNum = 353;BA.debugLine="addTaskTextArea.HintColor = Colors.ARGB(255, 17,";
mostCurrent._addtasktextarea.setHintColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (17),(int) (17),(int) (17)));
 };
 //BA.debugLineNum = 355;BA.debugLine="addTaskTextArea.Tag = Null";
mostCurrent._addtasktextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 357;BA.debugLine="enterTaskBtn.Initialize(\"enterTaskBtn\")";
mostCurrent._entertaskbtn.Initialize(mostCurrent.activityBA,"enterTaskBtn");
 //BA.debugLineNum = 358;BA.debugLine="enterTaskBtn.Text = \"Enter task\"";
mostCurrent._entertaskbtn.setText(BA.ObjectToCharSequence("Enter task"));
 //BA.debugLineNum = 360;BA.debugLine="addTaskPanel.AddView(addTaskTextArea, 0, 0, addTa";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._addtasktextarea.getObject()),(int) (0),(int) (0),mostCurrent._addtaskbtnpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
 //BA.debugLineNum = 361;BA.debugLine="addTaskPanel.AddView(enterTaskBtn, 0, 50dip, addT";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._entertaskbtn.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),mostCurrent._addtaskbtnpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 363;BA.debugLine="tasksList.Add(addTaskPanel, addTaskPanel)";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskpanel.getObject())),(Object)(mostCurrent._addtaskpanel.getObject()));
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public static String  _addtitletextarea_enterpressed() throws Exception{
anywheresoftware.b4a.objects.collections.List _ctx = null;
int _oldindex = 0;
String _oldtitle = "";
String _newtitle = "";
anywheresoftware.b4a.objects.collections.List _savedlists = null;
String _existingtitle = "";
String _oldkey = "";
String _newkey = "";
anywheresoftware.b4a.objects.collections.List _savedtasks = null;
String _task = "";
String _oldck = "";
String _newck = "";
anywheresoftware.b4a.objects.collections.List _savedlists2 = null;
String _t = "";
String _title = "";
 //BA.debugLineNum = 121;BA.debugLine="Sub addTitleTextArea_EnterPressed";
 //BA.debugLineNum = 124;BA.debugLine="If addTitleTextArea.Tag <> Null And addTitleTextA";
if (mostCurrent._addtitletextarea.getTag()!= null && mostCurrent._addtitletextarea.getTag() instanceof java.util.List) { 
 //BA.debugLineNum = 125;BA.debugLine="Dim ctx As List = addTitleTextArea.Tag";
_ctx = new anywheresoftware.b4a.objects.collections.List();
_ctx = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(mostCurrent._addtitletextarea.getTag()));
 //BA.debugLineNum = 126;BA.debugLine="Dim oldIndex As Int = ctx.Get(0)";
_oldindex = (int)(BA.ObjectToNumber(_ctx.Get((int) (0))));
 //BA.debugLineNum = 127;BA.debugLine="Dim oldTitle As String = ctx.Get(1)";
_oldtitle = BA.ObjectToString(_ctx.Get((int) (1)));
 //BA.debugLineNum = 128;BA.debugLine="Dim newTitle As String = addTitleTextArea.Text.T";
_newtitle = mostCurrent._addtitletextarea.getText().trim();
 //BA.debugLineNum = 130;BA.debugLine="If newTitle = \"\" Or newTitle = oldTitle Then";
if ((_newtitle).equals("") || (_newtitle).equals(_oldtitle)) { 
 //BA.debugLineNum = 131;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 132;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
 //BA.debugLineNum = 133;BA.debugLine="addTitleTextArea.Enabled = False";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 134;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 138;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
 //BA.debugLineNum = 139;BA.debugLine="For Each existingTitle As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group13 = _savedlists;
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_existingtitle = BA.ObjectToString(group13.Get(index13));
 //BA.debugLineNum = 140;BA.debugLine="If existingTitle = newTitle Then";
if ((_existingtitle).equals(_newtitle)) { 
 //BA.debugLineNum = 141;BA.debugLine="MsgboxAsync(\"A list with that name already exi";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("A list with that name already exists."),BA.ObjectToCharSequence("Duplicate title"),processBA);
 //BA.debugLineNum = 142;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 147;BA.debugLine="savedLists.Set(oldIndex, newTitle)";
_savedlists.Set(_oldindex,(Object)(_newtitle));
 //BA.debugLineNum = 148;BA.debugLine="kvs.Put(\"lists\", savedLists)";
_kvs._put("lists",(Object)(_savedlists.getObject()));
 //BA.debugLineNum = 151;BA.debugLine="Dim oldKey As String = \"list_\" & oldTitle";
_oldkey = "list_"+_oldtitle;
 //BA.debugLineNum = 152;BA.debugLine="Dim newKey As String = \"list_\" & newTitle";
_newkey = "list_"+_newtitle;
 //BA.debugLineNum = 153;BA.debugLine="If kvs.ContainsKey(oldKey) Then";
if (_kvs._containskey(_oldkey)) { 
 //BA.debugLineNum = 154;BA.debugLine="Dim savedTasks As List = kvs.Get(oldKey)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_oldkey)));
 //BA.debugLineNum = 155;BA.debugLine="For Each task As String In savedTasks";
{
final anywheresoftware.b4a.BA.IterableList group25 = _savedtasks;
final int groupLen25 = group25.getSize()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_task = BA.ObjectToString(group25.Get(index25));
 //BA.debugLineNum = 156;BA.debugLine="Dim oldCK As String = \"checked_\" & oldTitle &";
_oldck = "checked_"+_oldtitle+"_"+_task;
 //BA.debugLineNum = 157;BA.debugLine="Dim newCK As String = \"checked_\" & newTitle &";
_newck = "checked_"+_newtitle+"_"+_task;
 //BA.debugLineNum = 158;BA.debugLine="If kvs.ContainsKey(oldCK) Then";
if (_kvs._containskey(_oldck)) { 
 //BA.debugLineNum = 159;BA.debugLine="kvs.Put(newCK, kvs.Get(oldCK))";
_kvs._put(_newck,_kvs._get(_oldck));
 //BA.debugLineNum = 160;BA.debugLine="kvs.Remove(oldCK)";
_kvs._remove(_oldck);
 };
 }
};
 //BA.debugLineNum = 163;BA.debugLine="kvs.Put(newKey, savedTasks)";
_kvs._put(_newkey,(Object)(_savedtasks.getObject()));
 //BA.debugLineNum = 164;BA.debugLine="kvs.Remove(oldKey)";
_kvs._remove(_oldkey);
 };
 //BA.debugLineNum = 168;BA.debugLine="If currentList = oldTitle Then";
if ((mostCurrent._currentlist).equals(_oldtitle)) { 
 //BA.debugLineNum = 169;BA.debugLine="currentList = newTitle";
mostCurrent._currentlist = _newtitle;
 };
 //BA.debugLineNum = 173;BA.debugLine="listsList.Clear";
mostCurrent._listslist._clear();
 //BA.debugLineNum = 174;BA.debugLine="Dim savedLists2 As List = kvs.Get(\"lists\")";
_savedlists2 = new anywheresoftware.b4a.objects.collections.List();
_savedlists2 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
 //BA.debugLineNum = 175;BA.debugLine="For Each t As String In savedLists2";
{
final anywheresoftware.b4a.BA.IterableList group41 = _savedlists2;
final int groupLen41 = group41.getSize()
;int index41 = 0;
;
for (; index41 < groupLen41;index41++){
_t = BA.ObjectToString(group41.Get(index41));
 //BA.debugLineNum = 176;BA.debugLine="listsList.AddTextItem(t, t)";
mostCurrent._listslist._addtextitem((Object)(_t),(Object)(_t));
 }
};
 //BA.debugLineNum = 179;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 180;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
 //BA.debugLineNum = 181;BA.debugLine="addTitleTextArea.Enabled = False";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 182;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 183;BA.debugLine="isAddingList = False";
_isaddinglist = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 184;BA.debugLine="ToastMessageShow(\"List renamed\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("List renamed"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 185;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 189;BA.debugLine="Dim title As String = addTitleTextArea.Text";
_title = mostCurrent._addtitletextarea.getText();
 //BA.debugLineNum = 191;BA.debugLine="Dim savedLists As List";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 192;BA.debugLine="savedLists.Initialize";
_savedlists.Initialize();
 //BA.debugLineNum = 194;BA.debugLine="If title = \"\" Then";
if ((_title).equals("")) { 
 //BA.debugLineNum = 195;BA.debugLine="title = \"Untitled\" & untitledNo";
_title = "Untitled"+BA.NumberToString(_untitledno);
 //BA.debugLineNum = 197;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
 //BA.debugLineNum = 198;BA.debugLine="savedLists = kvs.Get(\"lists\")";
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
 //BA.debugLineNum = 199;BA.debugLine="For Each existingTitle As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group59 = _savedlists;
final int groupLen59 = group59.getSize()
;int index59 = 0;
;
for (; index59 < groupLen59;index59++){
_existingtitle = BA.ObjectToString(group59.Get(index59));
 //BA.debugLineNum = 200;BA.debugLine="If title = existingTitle Then";
if ((_title).equals(_existingtitle)) { 
 //BA.debugLineNum = 201;BA.debugLine="untitledNo = untitledNo + 1";
_untitledno = (int) (_untitledno+1);
 //BA.debugLineNum = 202;BA.debugLine="title = \"Untitled\" & untitledNo";
_title = "Untitled"+BA.NumberToString(_untitledno);
 };
 }
};
 };
 //BA.debugLineNum = 207;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 210;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
 //BA.debugLineNum = 211;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
 //BA.debugLineNum = 212;BA.debugLine="For Each existingTitle As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group70 = _savedlists;
final int groupLen70 = group70.getSize()
;int index70 = 0;
;
for (; index70 < groupLen70;index70++){
_existingtitle = BA.ObjectToString(group70.Get(index70));
 //BA.debugLineNum = 213;BA.debugLine="If existingTitle = title Then";
if ((_existingtitle).equals(_title)) { 
 //BA.debugLineNum = 214;BA.debugLine="MsgboxAsync(\"List already exists.\", \"Duplicate";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("List already exists."),BA.ObjectToCharSequence("Duplicate title"),processBA);
 //BA.debugLineNum = 215;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 216;BA.debugLine="addTitleTextArea.Text = \"\"";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 217;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 };
 //BA.debugLineNum = 222;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
 //BA.debugLineNum = 223;BA.debugLine="savedLists = kvs.Get(\"lists\")";
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
 };
 //BA.debugLineNum = 226;BA.debugLine="savedLists.Add(title)";
_savedlists.Add((Object)(_title));
 //BA.debugLineNum = 227;BA.debugLine="kvs.Put(\"lists\", savedLists)";
_kvs._put("lists",(Object)(_savedlists.getObject()));
 //BA.debugLineNum = 229;BA.debugLine="listsList.AddTextItem(title, title)";
mostCurrent._listslist._addtextitem((Object)(_title),(Object)(_title));
 //BA.debugLineNum = 231;BA.debugLine="currentList = title";
mostCurrent._currentlist = _title;
 //BA.debugLineNum = 232;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
 //BA.debugLineNum = 233;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 234;BA.debugLine="addTitleTextArea.Enabled = False";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 236;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
 //BA.debugLineNum = 237;BA.debugLine="tasksList.GetBase.Visible = True";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 238;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
 //BA.debugLineNum = 240;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 241;BA.debugLine="isAddingList = False";
_isaddinglist = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 242;BA.debugLine="progressNumber.Text = \"0 / 0 tasks done!\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence("0 / 0 tasks done!"));
 //BA.debugLineNum = 243;BA.debugLine="progressPercent.Text = \"0%\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence("0%"));
 //BA.debugLineNum = 244;BA.debugLine="progressBar.Progress = 0";
mostCurrent._progressbar.setProgress((int) (0));
 //BA.debugLineNum = 246;BA.debugLine="End Sub";
return "";
}
public static String  _entertaskbtn_click() throws Exception{
String _newtask = "";
anywheresoftware.b4a.objects.collections.List _ctx = null;
String _oldtask = "";
String _key = "";
anywheresoftware.b4a.objects.collections.List _savedtasks = null;
int _taskindex = 0;
String _oldck = "";
String _newck = "";
anywheresoftware.b4a.objects.collections.List _savedtasks2 = null;
String _t = "";
 //BA.debugLineNum = 367;BA.debugLine="Sub enterTaskBtn_Click";
 //BA.debugLineNum = 369;BA.debugLine="Dim newTask As String = addTaskTextArea.Text.Trim";
_newtask = mostCurrent._addtasktextarea.getText().trim();
 //BA.debugLineNum = 370;BA.debugLine="If newTask = \"\" Then";
if ((_newtask).equals("")) { 
 //BA.debugLineNum = 371;BA.debugLine="MsgboxAsync(\"Please enter a task.\", \"No task ent";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Please enter a task."),BA.ObjectToCharSequence("No task entered"),processBA);
 //BA.debugLineNum = 372;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 376;BA.debugLine="If addTaskTextArea.Tag <> Null Then";
if (mostCurrent._addtasktextarea.getTag()!= null) { 
 //BA.debugLineNum = 377;BA.debugLine="Dim ctx As List = addTaskTextArea.Tag";
_ctx = new anywheresoftware.b4a.objects.collections.List();
_ctx = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(mostCurrent._addtasktextarea.getTag()));
 //BA.debugLineNum = 378;BA.debugLine="Dim oldTask As String = ctx.Get(1)";
_oldtask = BA.ObjectToString(_ctx.Get((int) (1)));
 //BA.debugLineNum = 380;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
 //BA.debugLineNum = 381;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
 //BA.debugLineNum = 382;BA.debugLine="Dim taskIndex As Int = savedTasks.IndexOf(oldTas";
_taskindex = _savedtasks.IndexOf((Object)(_oldtask));
 //BA.debugLineNum = 383;BA.debugLine="If taskIndex >= 0 Then";
if (_taskindex>=0) { 
 //BA.debugLineNum = 384;BA.debugLine="savedTasks.Set(taskIndex, newTask)";
_savedtasks.Set(_taskindex,(Object)(_newtask));
 //BA.debugLineNum = 385;BA.debugLine="kvs.Put(key, savedTasks)";
_kvs._put(_key,(Object)(_savedtasks.getObject()));
 };
 //BA.debugLineNum = 389;BA.debugLine="Dim oldCK As String = \"checked_\" & currentList &";
_oldck = "checked_"+mostCurrent._currentlist+"_"+_oldtask;
 //BA.debugLineNum = 390;BA.debugLine="Dim newCK As String = \"checked_\" & currentList &";
_newck = "checked_"+mostCurrent._currentlist+"_"+_newtask;
 //BA.debugLineNum = 391;BA.debugLine="If kvs.ContainsKey(oldCK) Then";
if (_kvs._containskey(_oldck)) { 
 //BA.debugLineNum = 392;BA.debugLine="kvs.Put(newCK, kvs.Get(oldCK))";
_kvs._put(_newck,_kvs._get(_oldck));
 //BA.debugLineNum = 393;BA.debugLine="kvs.Remove(oldCK)";
_kvs._remove(_oldck);
 };
 //BA.debugLineNum = 396;BA.debugLine="addTaskTextArea.Tag = Null";
mostCurrent._addtasktextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 399;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
 //BA.debugLineNum = 400;BA.debugLine="Dim savedTasks2 As List = kvs.Get(key)";
_savedtasks2 = new anywheresoftware.b4a.objects.collections.List();
_savedtasks2 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
 //BA.debugLineNum = 401;BA.debugLine="For Each t As String In savedTasks2";
{
final anywheresoftware.b4a.BA.IterableList group25 = _savedtasks2;
final int groupLen25 = group25.getSize()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_t = BA.ObjectToString(group25.Get(index25));
 //BA.debugLineNum = 402;BA.debugLine="tasksListUI(t)";
_taskslistui(_t);
 }
};
 //BA.debugLineNum = 404;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
 //BA.debugLineNum = 405;BA.debugLine="addTaskBtn.Enabled = True";
mostCurrent._addtaskbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 406;BA.debugLine="updateProgress";
_updateprogress();
 //BA.debugLineNum = 407;BA.debugLine="ToastMessageShow(\"Task renamed\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Task renamed"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 408;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 412;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
mostCurrent._taskslist._removeat((int) (mostCurrent._taskslist._getsize()-1));
 //BA.debugLineNum = 414;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
 //BA.debugLineNum = 415;BA.debugLine="Dim savedTasks As List";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 416;BA.debugLine="If kvs.ContainsKey(key) Then";
if (_kvs._containskey(_key)) { 
 //BA.debugLineNum = 417;BA.debugLine="savedTasks = kvs.Get(key)";
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
 }else {
 //BA.debugLineNum = 419;BA.debugLine="savedTasks.Initialize";
_savedtasks.Initialize();
 };
 //BA.debugLineNum = 422;BA.debugLine="savedTasks.Add(newTask)";
_savedtasks.Add((Object)(_newtask));
 //BA.debugLineNum = 423;BA.debugLine="kvs.Put(key, savedTasks)";
_kvs._put(_key,(Object)(_savedtasks.getObject()));
 //BA.debugLineNum = 425;BA.debugLine="tasksListUI(newTask)";
_taskslistui(_newtask);
 //BA.debugLineNum = 426;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
 //BA.debugLineNum = 427;BA.debugLine="addTaskBtn.Enabled = True";
mostCurrent._addtaskbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 428;BA.debugLine="updateProgress";
_updateprogress();
 //BA.debugLineNum = 430;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private addTitleTextArea As EditText";
mostCurrent._addtitletextarea = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private listsList As CustomListView";
mostCurrent._listslist = new b4a.example3.customlistview();
 //BA.debugLineNum = 18;BA.debugLine="Private newListBtn As Button";
mostCurrent._newlistbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private tasksList As CustomListView";
mostCurrent._taskslist = new b4a.example3.customlistview();
 //BA.debugLineNum = 20;BA.debugLine="Dim isAddingList As Boolean = False";
_isaddinglist = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 22;BA.debugLine="Dim addTaskBtnPNL As Panel";
mostCurrent._addtaskbtnpnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Dim addTaskBtn As Button";
mostCurrent._addtaskbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private currentList As String = \"\"";
mostCurrent._currentlist = "";
 //BA.debugLineNum = 27;BA.debugLine="Dim addTaskPanel As Panel";
mostCurrent._addtaskpanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Dim addTaskTextArea As EditText";
mostCurrent._addtasktextarea = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim enterTaskBtn As Button";
mostCurrent._entertaskbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Dim untitledNo As Int = 1";
_untitledno = (int) (1);
 //BA.debugLineNum = 33;BA.debugLine="Private progressNumber As Label";
mostCurrent._progressnumber = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private progressPercent As Label";
mostCurrent._progresspercent = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private progressBar As ProgressBar";
mostCurrent._progressbar = new anywheresoftware.b4a.objects.ProgressBarWrapper();
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _listslist_itemclick(int _index,Object _value) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _listpnl = null;
anywheresoftware.b4a.objects.LabelWrapper _listlbl = null;
String _key = "";
anywheresoftware.b4a.objects.collections.List _savedtasks = null;
String _task = "";
 //BA.debugLineNum = 248;BA.debugLine="Sub listsList_ItemClick(Index As Int, Value As Obj";
 //BA.debugLineNum = 250;BA.debugLine="If isAddingList Then Return";
if (_isaddinglist) { 
if (true) return "";};
 //BA.debugLineNum = 252;BA.debugLine="Dim listPNL As B4XView = listsList.GetPanel(Index";
_listpnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_listpnl = mostCurrent._listslist._getpanel(_index);
 //BA.debugLineNum = 253;BA.debugLine="Dim listLBL As Label = listPNL.GetView(0)";
_listlbl = new anywheresoftware.b4a.objects.LabelWrapper();
_listlbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_listpnl.GetView((int) (0)).getObject()));
 //BA.debugLineNum = 255;BA.debugLine="currentList = listLBL.Text";
mostCurrent._currentlist = _listlbl.getText();
 //BA.debugLineNum = 256;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
 //BA.debugLineNum = 257;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 259;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
 //BA.debugLineNum = 261;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
 //BA.debugLineNum = 263;BA.debugLine="If kvs.ContainsKey(key) Then";
if (_kvs._containskey(_key)) { 
 //BA.debugLineNum = 264;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
 //BA.debugLineNum = 265;BA.debugLine="For Each task As String In savedTasks";
{
final anywheresoftware.b4a.BA.IterableList group11 = _savedtasks;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_task = BA.ObjectToString(group11.Get(index11));
 //BA.debugLineNum = 266;BA.debugLine="tasksListUI(task)";
_taskslistui(_task);
 }
};
 };
 //BA.debugLineNum = 270;BA.debugLine="tasksList.GetBase.Visible = True";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 271;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
 //BA.debugLineNum = 272;BA.debugLine="updateProgress";
_updateprogress();
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
return "";
}
public static void  _listslist_itemlongclick(int _index,Object _value) throws Exception{
ResumableSub_listsList_ItemLongClick rsub = new ResumableSub_listsList_ItemLongClick(null,_index,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_listsList_ItemLongClick extends BA.ResumableSub {
public ResumableSub_listsList_ItemLongClick(b4a.example.todoactivity parent,int _index,Object _value) {
this.parent = parent;
this._index = _index;
this._value = _value;
}
b4a.example.todoactivity parent;
int _index;
Object _value;
int _res = 0;
anywheresoftware.b4a.objects.collections.List _savedlists = null;
String _key = "";
anywheresoftware.b4a.objects.collections.List _savedtasks = null;
String _task = "";
anywheresoftware.b4a.BA.IterableList group17;
int index17;
int groupLen17;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 278;BA.debugLine="Msgbox2Async(\"Delete or rename this list?\", Value";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Delete or rename this list?"),BA.ObjectToCharSequence(_value),"Rename","","Delete",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 279;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 22;
return;
case 22:
//C
this.state = 1;
_res = (Integer) result[0];
;
 //BA.debugLineNum = 281;BA.debugLine="If res = DialogResponse.POSITIVE Then ' Rename";
if (true) break;

case 1:
//if
this.state = 21;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}else if(_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 21;
 //BA.debugLineNum = 282;BA.debugLine="showRenameListPanel(Index, Value)";
_showrenamelistpanel(_index,BA.ObjectToString(_value));
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 286;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete th";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete the list \""+BA.ObjectToString(_value)+"\"?"),BA.ObjectToCharSequence("Confirmation"),"No","","Yes",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 287;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 23;
return;
case 23:
//C
this.state = 6;
_res = (Integer) result[0];
;
 //BA.debugLineNum = 288;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
if (true) break;

case 6:
//if
this.state = 9;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 8;
}if (true) break;

case 8:
//C
this.state = 9;
 //BA.debugLineNum = 289;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent._kvs._get("lists")));
 //BA.debugLineNum = 290;BA.debugLine="savedLists.RemoveAt(Index)";
_savedlists.RemoveAt(_index);
 //BA.debugLineNum = 291;BA.debugLine="kvs.Put(\"lists\", savedLists)";
parent._kvs._put("lists",(Object)(_savedlists.getObject()));
 //BA.debugLineNum = 292;BA.debugLine="listsList.RemoveAt(Index)";
parent.mostCurrent._listslist._removeat(_index);
 if (true) break;

case 9:
//C
this.state = 10;
;
 //BA.debugLineNum = 296;BA.debugLine="Dim key As String = \"list_\" & Value";
_key = "list_"+BA.ObjectToString(_value);
 //BA.debugLineNum = 297;BA.debugLine="If kvs.ContainsKey(key) Then";
if (true) break;

case 10:
//if
this.state = 17;
if (parent._kvs._containskey(_key)) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 298;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent._kvs._get(_key)));
 //BA.debugLineNum = 299;BA.debugLine="For Each task As String In savedTasks";
if (true) break;

case 13:
//for
this.state = 16;
group17 = _savedtasks;
index17 = 0;
groupLen17 = group17.getSize();
this.state = 24;
if (true) break;

case 24:
//C
this.state = 16;
if (index17 < groupLen17) {
this.state = 15;
_task = BA.ObjectToString(group17.Get(index17));}
if (true) break;

case 25:
//C
this.state = 24;
index17++;
if (true) break;

case 15:
//C
this.state = 25;
 //BA.debugLineNum = 300;BA.debugLine="kvs.Remove(\"checked_\" & Value & \"_\" & task)";
parent._kvs._remove("checked_"+BA.ObjectToString(_value)+"_"+_task);
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
;
 //BA.debugLineNum = 302;BA.debugLine="kvs.Remove(key)";
parent._kvs._remove(_key);
 if (true) break;
;
 //BA.debugLineNum = 306;BA.debugLine="If currentList = Value Then";

case 17:
//if
this.state = 20;
if ((parent.mostCurrent._currentlist).equals(BA.ObjectToString(_value))) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 307;BA.debugLine="currentList = \"\"";
parent.mostCurrent._currentlist = "";
 //BA.debugLineNum = 308;BA.debugLine="tasksList.Clear";
parent.mostCurrent._taskslist._clear();
 //BA.debugLineNum = 309;BA.debugLine="tasksList.GetBase.Visible = False";
parent.mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 310;BA.debugLine="addTitleTextArea.Text = \"\"";
parent.mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 311;BA.debugLine="addTitleTextArea.Visible = False";
parent.mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 20:
//C
this.state = 21;
;
 //BA.debugLineNum = 314;BA.debugLine="ToastMessageShow(\"List deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("List deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 21:
//C
this.state = -1;
;
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _res) throws Exception{
}
public static String  _newaddtaskbtn() throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Sub newAddTaskBtn";
 //BA.debugLineNum = 73;BA.debugLine="If Starter.darkMode Then";
if (mostCurrent._starter._darkmode /*boolean*/ ) { 
 //BA.debugLineNum = 74;BA.debugLine="addTaskBtnPNL.Initialize(\"addTaskBtnPNL\")";
mostCurrent._addtaskbtnpnl.Initialize(mostCurrent.activityBA,"addTaskBtnPNL");
 //BA.debugLineNum = 75;BA.debugLine="addTaskBtnPNL.SetLayout(0, 0, 235dip, 50dip)";
mostCurrent._addtaskbtnpnl.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (235)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 76;BA.debugLine="addTaskBtnPNL.Color = Colors.ARGB(255, 17, 17, 1";
mostCurrent._addtaskbtnpnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (17),(int) (17),(int) (17)));
 //BA.debugLineNum = 78;BA.debugLine="addTaskBtn.Initialize(\"addTaskBtn\")";
mostCurrent._addtaskbtn.Initialize(mostCurrent.activityBA,"addTaskBtn");
 //BA.debugLineNum = 79;BA.debugLine="addTaskBtn.Text = \"+ add a task \"";
mostCurrent._addtaskbtn.setText(BA.ObjectToCharSequence("+ add a task "));
 //BA.debugLineNum = 80;BA.debugLine="addTaskBtn.TextColor = Colors.DarkGray";
mostCurrent._addtaskbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
 //BA.debugLineNum = 81;BA.debugLine="addTaskBtnPNL.AddView(addTaskBtn, -10dip, 0dip,";
mostCurrent._addtaskbtnpnl.AddView((android.view.View)(mostCurrent._addtaskbtn.getObject()),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._addtaskbtnpnl.getWidth(),mostCurrent._addtaskbtnpnl.getHeight());
 //BA.debugLineNum = 83;BA.debugLine="tasksList.Add(addTaskBtnPNL, \"\")";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskbtnpnl.getObject())),(Object)(""));
 }else {
 //BA.debugLineNum = 85;BA.debugLine="addTaskBtnPNL.Initialize(\"addTaskBtnPNL\")";
mostCurrent._addtaskbtnpnl.Initialize(mostCurrent.activityBA,"addTaskBtnPNL");
 //BA.debugLineNum = 86;BA.debugLine="addTaskBtnPNL.SetLayout(0, 0, 235dip, 50dip)";
mostCurrent._addtaskbtnpnl.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (235)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 87;BA.debugLine="addTaskBtnPNL.Color = Colors.ARGB(255, 250, 250,";
mostCurrent._addtaskbtnpnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (250),(int) (250),(int) (250)));
 //BA.debugLineNum = 89;BA.debugLine="addTaskBtn.Initialize(\"addTaskBtn\")";
mostCurrent._addtaskbtn.Initialize(mostCurrent.activityBA,"addTaskBtn");
 //BA.debugLineNum = 90;BA.debugLine="addTaskBtn.Text = \"+ add a task \"";
mostCurrent._addtaskbtn.setText(BA.ObjectToCharSequence("+ add a task "));
 //BA.debugLineNum = 91;BA.debugLine="addTaskBtnPNL.AddView(addTaskBtn, -10dip, 0dip, a";
mostCurrent._addtaskbtnpnl.AddView((android.view.View)(mostCurrent._addtaskbtn.getObject()),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._addtaskbtnpnl.getWidth(),mostCurrent._addtaskbtnpnl.getHeight());
 //BA.debugLineNum = 93;BA.debugLine="tasksList.Add(addTaskBtnPNL, \"\")";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskbtnpnl.getObject())),(Object)(""));
 };
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _newlistbtn_click() throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Sub newListBtn_Click";
 //BA.debugLineNum = 99;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
 //BA.debugLineNum = 100;BA.debugLine="isAddingList = True";
_isaddinglist = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 102;BA.debugLine="progressNumber.Text = \"\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 103;BA.debugLine="progressPercent.Text = \"\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 104;BA.debugLine="progressBar.Progress = 0";
mostCurrent._progressbar.setProgress((int) (0));
 //BA.debugLineNum = 106;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 107;BA.debugLine="addTitleTextArea.Enabled = True";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 108;BA.debugLine="addTitleTextArea.Background = Null";
mostCurrent._addtitletextarea.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 109;BA.debugLine="addTitleTextArea.Text = \"\"";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 110;BA.debugLine="addTitleTextArea.Hint = \"+ add a title...\"";
mostCurrent._addtitletextarea.setHint("+ add a title...");
 //BA.debugLineNum = 111;BA.debugLine="addTitleTextArea.RequestFocus";
mostCurrent._addtitletextarea.RequestFocus();
 //BA.debugLineNum = 112;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 114;BA.debugLine="newListBtn.Enabled = False";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 116;BA.debugLine="tasksList.GetBase.Visible = True";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 117;BA.debugLine="addTaskBtn.Visible = True";
mostCurrent._addtaskbtn.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 10;BA.debugLine="Public kvs As KeyValueStore";
_kvs = new b4a.example3.keyvaluestore();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _showrenamelistpanel(int _index,String _oldtitle) throws Exception{
anywheresoftware.b4a.objects.collections.List _ctx = null;
 //BA.debugLineNum = 319;BA.debugLine="Sub showRenameListPanel(Index As Int, oldTitle As";
 //BA.debugLineNum = 321;BA.debugLine="addTitleTextArea.Text = oldTitle";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(_oldtitle));
 //BA.debugLineNum = 322;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 323;BA.debugLine="addTitleTextArea.Enabled = True";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 324;BA.debugLine="addTitleTextArea.RequestFocus";
mostCurrent._addtitletextarea.RequestFocus();
 //BA.debugLineNum = 326;BA.debugLine="Dim ctx As List";
_ctx = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 327;BA.debugLine="ctx.Initialize";
_ctx.Initialize();
 //BA.debugLineNum = 328;BA.debugLine="ctx.Add(Index)";
_ctx.Add((Object)(_index));
 //BA.debugLineNum = 329;BA.debugLine="ctx.Add(oldTitle)";
_ctx.Add((Object)(_oldtitle));
 //BA.debugLineNum = 330;BA.debugLine="addTitleTextArea.Tag = ctx";
mostCurrent._addtitletextarea.setTag((Object)(_ctx.getObject()));
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
return "";
}
public static String  _showrenametaskpanel(int _index,String _oldtask) throws Exception{
anywheresoftware.b4a.objects.collections.List _ctx = null;
 //BA.debugLineNum = 455;BA.debugLine="Sub showRenameTaskPanel(Index As Int, oldTask As S";
 //BA.debugLineNum = 457;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1) ' remove \"";
mostCurrent._taskslist._removeat((int) (mostCurrent._taskslist._getsize()-1));
 //BA.debugLineNum = 459;BA.debugLine="addTaskPanel.Initialize(\"addTaskPanel\")";
mostCurrent._addtaskpanel.Initialize(mostCurrent.activityBA,"addTaskPanel");
 //BA.debugLineNum = 460;BA.debugLine="addTaskPanel.SetLayout(10dip, 0, 250dip, 100dip)";
mostCurrent._addtaskpanel.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 //BA.debugLineNum = 461;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 247, 247, 2";
mostCurrent._addtaskpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (247),(int) (247),(int) (247)));
 //BA.debugLineNum = 463;BA.debugLine="addTaskTextArea.Initialize(\"addTodoText\")";
mostCurrent._addtasktextarea.Initialize(mostCurrent.activityBA,"addTodoText");
 //BA.debugLineNum = 464;BA.debugLine="addTaskTextArea.Text = oldTask";
mostCurrent._addtasktextarea.setText(BA.ObjectToCharSequence(_oldtask));
 //BA.debugLineNum = 465;BA.debugLine="Dim ctx As List";
_ctx = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 466;BA.debugLine="ctx.Initialize";
_ctx.Initialize();
 //BA.debugLineNum = 467;BA.debugLine="ctx.Add(Index)";
_ctx.Add((Object)(_index));
 //BA.debugLineNum = 468;BA.debugLine="ctx.Add(oldTask)";
_ctx.Add((Object)(_oldtask));
 //BA.debugLineNum = 469;BA.debugLine="addTaskTextArea.Tag = ctx";
mostCurrent._addtasktextarea.setTag((Object)(_ctx.getObject()));
 //BA.debugLineNum = 471;BA.debugLine="enterTaskBtn.Initialize(\"enterTaskBtn\")";
mostCurrent._entertaskbtn.Initialize(mostCurrent.activityBA,"enterTaskBtn");
 //BA.debugLineNum = 472;BA.debugLine="enterTaskBtn.Text = \"Rename task\"";
mostCurrent._entertaskbtn.setText(BA.ObjectToCharSequence("Rename task"));
 //BA.debugLineNum = 474;BA.debugLine="addTaskPanel.AddView(addTaskTextArea, 0, 0, addTa";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._addtasktextarea.getObject()),(int) (0),(int) (0),mostCurrent._addtaskbtnpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
 //BA.debugLineNum = 475;BA.debugLine="addTaskPanel.AddView(enterTaskBtn, 0, 50dip, addT";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._entertaskbtn.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),mostCurrent._addtaskbtnpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 477;BA.debugLine="tasksList.Add(addTaskPanel, addTaskPanel)";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskpanel.getObject())),(Object)(mostCurrent._addtaskpanel.getObject()));
 //BA.debugLineNum = 479;BA.debugLine="End Sub";
return "";
}
public static String  _taskcheckbox_checkedchange(boolean _checked) throws Exception{
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _taskcheckbox = null;
anywheresoftware.b4a.objects.LabelWrapper _tasklbl = null;
String _key = "";
 //BA.debugLineNum = 481;BA.debugLine="Sub taskCheckbox_CheckedChange(Checked As Boolean)";
 //BA.debugLineNum = 483;BA.debugLine="Dim taskCheckbox As CheckBox = Sender";
_taskcheckbox = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_taskcheckbox = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 484;BA.debugLine="Dim taskLBL As Label = taskCheckbox.Tag";
_tasklbl = new anywheresoftware.b4a.objects.LabelWrapper();
_tasklbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_taskcheckbox.getTag()));
 //BA.debugLineNum = 485;BA.debugLine="If Starter.darkMode Then";
if (mostCurrent._starter._darkmode /*boolean*/ ) { 
 //BA.debugLineNum = 486;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 487;BA.debugLine="taskLBL.TextColor = Colors.ARGB(255, 128, 128,";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (128),(int) (128),(int) (128)));
 }else {
 //BA.debugLineNum = 489;BA.debugLine="taskLBL.TextColor = Colors.White";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 };
 }else {
 //BA.debugLineNum = 492;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 493;BA.debugLine="taskLBL.TextColor = Colors.ARGB(255, 128, 128,";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (128),(int) (128),(int) (128)));
 }else {
 //BA.debugLineNum = 495;BA.debugLine="taskLBL.TextColor = Colors.Black";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
 };
 //BA.debugLineNum = 500;BA.debugLine="Dim key As String = \"checked_\" & currentList & \"_";
_key = "checked_"+mostCurrent._currentlist+"_"+_tasklbl.getText();
 //BA.debugLineNum = 501;BA.debugLine="kvs.Put(key, Checked)";
_kvs._put(_key,(Object)(_checked));
 //BA.debugLineNum = 503;BA.debugLine="updateProgress";
_updateprogress();
 //BA.debugLineNum = 505;BA.debugLine="End Sub";
return "";
}
public static void  _taskslist_itemlongclick(int _index,Object _value) throws Exception{
ResumableSub_tasksList_ItemLongClick rsub = new ResumableSub_tasksList_ItemLongClick(null,_index,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_tasksList_ItemLongClick extends BA.ResumableSub {
public ResumableSub_tasksList_ItemLongClick(b4a.example.todoactivity parent,int _index,Object _value) {
this.parent = parent;
this._index = _index;
this._value = _value;
}
b4a.example.todoactivity parent;
int _index;
Object _value;
int _res = 0;
String _key = "";
anywheresoftware.b4a.objects.collections.List _savedtasks = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 434;BA.debugLine="If Value = \"\" Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if ((_value).equals((Object)(""))) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 436;BA.debugLine="Msgbox2Async(\"Delete or rename this task?\", Value";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Delete or rename this task?"),BA.ObjectToCharSequence(_value),"Rename","","Delete",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 437;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 13;
return;
case 13:
//C
this.state = 7;
_res = (Integer) result[0];
;
 //BA.debugLineNum = 439;BA.debugLine="If res = DialogResponse.POSITIVE Then ' Rename";
if (true) break;

case 7:
//if
this.state = 12;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 9;
}else if(_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 //BA.debugLineNum = 440;BA.debugLine="showRenameTaskPanel(Index, Value)";
_showrenametaskpanel(_index,BA.ObjectToString(_value));
 if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 443;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+parent.mostCurrent._currentlist;
 //BA.debugLineNum = 444;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent._kvs._get(_key)));
 //BA.debugLineNum = 445;BA.debugLine="savedTasks.RemoveAt(Index)";
_savedtasks.RemoveAt(_index);
 //BA.debugLineNum = 446;BA.debugLine="kvs.Put(key, savedTasks)";
parent._kvs._put(_key,(Object)(_savedtasks.getObject()));
 //BA.debugLineNum = 447;BA.debugLine="kvs.Remove(\"checked_\" & currentList & \"_\" & Valu";
parent._kvs._remove("checked_"+parent.mostCurrent._currentlist+"_"+BA.ObjectToString(_value));
 //BA.debugLineNum = 448;BA.debugLine="tasksList.RemoveAt(Index)";
parent.mostCurrent._taskslist._removeat(_index);
 //BA.debugLineNum = 449;BA.debugLine="updateProgress";
_updateprogress();
 //BA.debugLineNum = 450;BA.debugLine="ToastMessageShow(\"Task deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Task deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 453;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _taskslistui(String _newtask) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _taskpnl = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _taskcheckbox = null;
anywheresoftware.b4a.objects.LabelWrapper _tasklbl = null;
anywheresoftware.b4a.objects.PanelWrapper _divider = null;
String _checkedkey = "";
boolean _ischecked = false;
 //BA.debugLineNum = 507;BA.debugLine="Sub tasksListUI(newTask As String)";
 //BA.debugLineNum = 509;BA.debugLine="Dim taskPNL As Panel";
_taskpnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 510;BA.debugLine="taskPNL.Initialize(\"taskPNL\")";
_taskpnl.Initialize(mostCurrent.activityBA,"taskPNL");
 //BA.debugLineNum = 511;BA.debugLine="taskPNL.SetLayout(0, 0, 250dip, 60dip)";
_taskpnl.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
 //BA.debugLineNum = 513;BA.debugLine="Dim taskCheckbox As CheckBox";
_taskcheckbox = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 514;BA.debugLine="taskCheckbox.Initialize(\"taskCheckbox\")";
_taskcheckbox.Initialize(mostCurrent.activityBA,"taskCheckbox");
 //BA.debugLineNum = 515;BA.debugLine="taskPNL.AddView(taskCheckbox, 0dip, 10dip, 40dip,";
_taskpnl.AddView((android.view.View)(_taskcheckbox.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 517;BA.debugLine="Dim taskLBL As Label";
_tasklbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 518;BA.debugLine="If Starter.darkMode Then";
if (mostCurrent._starter._darkmode /*boolean*/ ) { 
 //BA.debugLineNum = 519;BA.debugLine="taskLBL.Initialize(\"taskLBL\")";
_tasklbl.Initialize(mostCurrent.activityBA,"taskLBL");
 //BA.debugLineNum = 520;BA.debugLine="taskLBL.Text = newTask";
_tasklbl.setText(BA.ObjectToCharSequence(_newtask));
 //BA.debugLineNum = 521;BA.debugLine="taskLBL.TextColor = Colors.White";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 522;BA.debugLine="taskPNL.AddView(taskLBL, 40dip, 20dip, taskPNL.W";
_taskpnl.AddView((android.view.View)(_tasklbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (_taskpnl.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80))),_taskpnl.getHeight());
 }else {
 //BA.debugLineNum = 524;BA.debugLine="taskLBL.Initialize(\"taskLBL\")";
_tasklbl.Initialize(mostCurrent.activityBA,"taskLBL");
 //BA.debugLineNum = 525;BA.debugLine="taskLBL.Text = newTask";
_tasklbl.setText(BA.ObjectToCharSequence(_newtask));
 //BA.debugLineNum = 526;BA.debugLine="taskLBL.TextColor = Colors.Black";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 527;BA.debugLine="taskPNL.AddView(taskLBL, 40dip, 20dip, taskPNL.W";
_taskpnl.AddView((android.view.View)(_tasklbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (_taskpnl.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80))),_taskpnl.getHeight());
 };
 //BA.debugLineNum = 531;BA.debugLine="Dim divider As Panel";
_divider = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 532;BA.debugLine="divider.Initialize(\"line\")";
_divider.Initialize(mostCurrent.activityBA,"line");
 //BA.debugLineNum = 533;BA.debugLine="divider.Color = Colors.ARGB(255, 60, 60, 60)";
_divider.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (60),(int) (60),(int) (60)));
 //BA.debugLineNum = 534;BA.debugLine="taskPNL.AddView(divider, 0, 59dip, taskPNL.Width,";
_taskpnl.AddView((android.view.View)(_divider.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (59)),_taskpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
 //BA.debugLineNum = 536;BA.debugLine="taskCheckbox.Tag = taskLBL";
_taskcheckbox.setTag((Object)(_tasklbl.getObject()));
 //BA.debugLineNum = 539;BA.debugLine="Dim checkedKey As String = \"checked_\" & currentLi";
_checkedkey = "checked_"+mostCurrent._currentlist+"_"+_newtask;
 //BA.debugLineNum = 540;BA.debugLine="If kvs.ContainsKey(checkedKey) Then";
if (_kvs._containskey(_checkedkey)) { 
 //BA.debugLineNum = 541;BA.debugLine="Dim isChecked As Boolean = kvs.Get(checkedKey)";
_ischecked = BA.ObjectToBoolean(_kvs._get(_checkedkey));
 //BA.debugLineNum = 542;BA.debugLine="taskCheckbox.Checked = isChecked";
_taskcheckbox.setChecked(_ischecked);
 //BA.debugLineNum = 543;BA.debugLine="If isChecked Then";
if (_ischecked) { 
 //BA.debugLineNum = 544;BA.debugLine="taskLBL.TextColor = Colors.ARGB(50, 0, 0, 0)";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
 };
 };
 //BA.debugLineNum = 548;BA.debugLine="tasksList.Add(taskPNL, newTask)";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_taskpnl.getObject())),(Object)(_newtask));
 //BA.debugLineNum = 550;BA.debugLine="End Sub";
return "";
}
public static String  _updateprogress() throws Exception{
String _key = "";
anywheresoftware.b4a.objects.collections.List _savedtasks = null;
int _totaltasks = 0;
int _donetasks = 0;
int _percentagetasks = 0;
String _task = "";
String _checkedkey = "";
 //BA.debugLineNum = 552;BA.debugLine="Sub updateProgress";
 //BA.debugLineNum = 554;BA.debugLine="If currentList = \"\" Then";
if ((mostCurrent._currentlist).equals("")) { 
 //BA.debugLineNum = 555;BA.debugLine="progressNumber.Text = \"\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 556;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 559;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
 //BA.debugLineNum = 560;BA.debugLine="If kvs.ContainsKey(key) = False Then";
if (_kvs._containskey(_key)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 561;BA.debugLine="progressNumber.Text = \"0 / 0 tasks done!\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence("0 / 0 tasks done!"));
 //BA.debugLineNum = 562;BA.debugLine="progressPercent.Text = \"0%\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence("0%"));
 //BA.debugLineNum = 563;BA.debugLine="progressBar.Progress = 0";
mostCurrent._progressbar.setProgress((int) (0));
 //BA.debugLineNum = 564;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 568;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
 //BA.debugLineNum = 569;BA.debugLine="Dim totalTasks As Int = savedTasks.Size";
_totaltasks = _savedtasks.getSize();
 //BA.debugLineNum = 570;BA.debugLine="Dim doneTasks As Int = 0";
_donetasks = (int) (0);
 //BA.debugLineNum = 571;BA.debugLine="Dim percentageTasks As Int = 0";
_percentagetasks = (int) (0);
 //BA.debugLineNum = 573;BA.debugLine="For Each task As String In savedTasks";
{
final anywheresoftware.b4a.BA.IterableList group16 = _savedtasks;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_task = BA.ObjectToString(group16.Get(index16));
 //BA.debugLineNum = 574;BA.debugLine="Dim checkedKey As String = \"checked_\" & currentL";
_checkedkey = "checked_"+mostCurrent._currentlist+"_"+_task;
 //BA.debugLineNum = 575;BA.debugLine="If kvs.ContainsKey(checkedKey) Then";
if (_kvs._containskey(_checkedkey)) { 
 //BA.debugLineNum = 576;BA.debugLine="If kvs.Get(checkedKey) = True Then";
if ((_kvs._get(_checkedkey)).equals((Object)(anywheresoftware.b4a.keywords.Common.True))) { 
 //BA.debugLineNum = 577;BA.debugLine="doneTasks = doneTasks + 1";
_donetasks = (int) (_donetasks+1);
 };
 };
 }
};
 //BA.debugLineNum = 582;BA.debugLine="percentageTasks = (doneTasks / totalTasks) * 100";
_percentagetasks = (int) ((_donetasks/(double)_totaltasks)*100);
 //BA.debugLineNum = 584;BA.debugLine="progressNumber.Text = doneTasks & \" / \" & totalTa";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence(BA.NumberToString(_donetasks)+" / "+BA.NumberToString(_totaltasks)+" tasks done!"));
 //BA.debugLineNum = 585;BA.debugLine="progressPercent.Text = percentageTasks & \"%\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence(BA.NumberToString(_percentagetasks)+"%"));
 //BA.debugLineNum = 586;BA.debugLine="progressBar.Progress = percentageTasks";
mostCurrent._progressbar.setProgress(_percentagetasks);
 //BA.debugLineNum = 588;BA.debugLine="End Sub";
return "";
}
}
