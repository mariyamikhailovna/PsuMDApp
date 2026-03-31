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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.todoactivity");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
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
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.card_module _card_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.starter _starter = null;
public b4a.example.subdeck_module _subdeck_module = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.collections.List _savedlists = null;
String _title = "";
RDebugUtils.currentLine=25296896;
 //BA.debugLineNum = 25296896;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=25296899;
 //BA.debugLineNum = 25296899;BA.debugLine="If Starter.darkMode Then";
if (mostCurrent._starter._darkmode /*boolean*/ ) { 
RDebugUtils.currentLine=25296900;
 //BA.debugLineNum = 25296900;BA.debugLine="Activity.LoadLayout(\"todoListLayoutDark.bal\")";
mostCurrent._activity.LoadLayout("todoListLayoutDark.bal",mostCurrent.activityBA);
 }else {
RDebugUtils.currentLine=25296902;
 //BA.debugLineNum = 25296902;BA.debugLine="Activity.LoadLayout(\"todoListLayout.bal\")";
mostCurrent._activity.LoadLayout("todoListLayout.bal",mostCurrent.activityBA);
 };
RDebugUtils.currentLine=25296905;
 //BA.debugLineNum = 25296905;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=25296906;
 //BA.debugLineNum = 25296906;BA.debugLine="addTitleTextArea.Background = Null";
mostCurrent._addtitletextarea.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=25296908;
 //BA.debugLineNum = 25296908;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=25296909;
 //BA.debugLineNum = 25296909;BA.debugLine="tasksList.GetBase.Visible = False";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25296911;
 //BA.debugLineNum = 25296911;BA.debugLine="kvs = Starter.taskKvs";
_kvs = mostCurrent._starter._taskkvs /*b4a.example3.keyvaluestore*/ ;
RDebugUtils.currentLine=25296913;
 //BA.debugLineNum = 25296913;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
RDebugUtils.currentLine=25296914;
 //BA.debugLineNum = 25296914;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=25296915;
 //BA.debugLineNum = 25296915;BA.debugLine="For Each title As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group13 = _savedlists;
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_title = BA.ObjectToString(group13.Get(index13));
RDebugUtils.currentLine=25296916;
 //BA.debugLineNum = 25296916;BA.debugLine="listsList.AddTextItem(title, title)";
mostCurrent._listslist._addtextitem((Object)(_title),(Object)(_title));
 }
};
 };
RDebugUtils.currentLine=25296920;
 //BA.debugLineNum = 25296920;BA.debugLine="End Sub";
return "";
}
public static String  _newaddtaskbtn() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "newaddtaskbtn", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "newaddtaskbtn", null));}
RDebugUtils.currentLine=25493504;
 //BA.debugLineNum = 25493504;BA.debugLine="Sub newAddTaskBtn";
RDebugUtils.currentLine=25493506;
 //BA.debugLineNum = 25493506;BA.debugLine="addTaskBtnPNL.Initialize(\"addTaskBtnPNL\")";
mostCurrent._addtaskbtnpnl.Initialize(mostCurrent.activityBA,"addTaskBtnPNL");
RDebugUtils.currentLine=25493507;
 //BA.debugLineNum = 25493507;BA.debugLine="addTaskBtnPNL.SetLayout(0, 0, 235dip, 50dip)";
mostCurrent._addtaskbtnpnl.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (235)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=25493508;
 //BA.debugLineNum = 25493508;BA.debugLine="addTaskBtnPNL.Color = Colors.ARGB(255, 250, 250,";
mostCurrent._addtaskbtnpnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (250),(int) (250),(int) (250)));
RDebugUtils.currentLine=25493510;
 //BA.debugLineNum = 25493510;BA.debugLine="addTaskBtn.Initialize(\"addTaskBtn\")";
mostCurrent._addtaskbtn.Initialize(mostCurrent.activityBA,"addTaskBtn");
RDebugUtils.currentLine=25493511;
 //BA.debugLineNum = 25493511;BA.debugLine="addTaskBtn.Text = \"+ add a task \"";
mostCurrent._addtaskbtn.setText(BA.ObjectToCharSequence("+ add a task "));
RDebugUtils.currentLine=25493512;
 //BA.debugLineNum = 25493512;BA.debugLine="addTaskBtnPNL.AddView(addTaskBtn, -10dip, 0, addT";
mostCurrent._addtaskbtnpnl.AddView((android.view.View)(mostCurrent._addtaskbtn.getObject()),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),(int) (0),mostCurrent._addtaskbtnpnl.getWidth(),mostCurrent._addtaskbtnpnl.getHeight());
RDebugUtils.currentLine=25493514;
 //BA.debugLineNum = 25493514;BA.debugLine="tasksList.Add(addTaskBtnPNL, \"\")";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskbtnpnl.getObject())),(Object)(""));
RDebugUtils.currentLine=25493516;
 //BA.debugLineNum = 25493516;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="todoactivity";
RDebugUtils.currentLine=25427968;
 //BA.debugLineNum = 25427968;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=25427970;
 //BA.debugLineNum = 25427970;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=25362432;
 //BA.debugLineNum = 25362432;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=25362434;
 //BA.debugLineNum = 25362434;BA.debugLine="End Sub";
return "";
}
public static String  _addtaskbtn_click() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addtaskbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addtaskbtn_click", null));}
RDebugUtils.currentLine=25886720;
 //BA.debugLineNum = 25886720;BA.debugLine="Sub addTaskBtn_Click";
RDebugUtils.currentLine=25886722;
 //BA.debugLineNum = 25886722;BA.debugLine="addTaskBtn.Enabled = False";
mostCurrent._addtaskbtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25886723;
 //BA.debugLineNum = 25886723;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
mostCurrent._taskslist._removeat((int) (mostCurrent._taskslist._getsize()-1));
RDebugUtils.currentLine=25886725;
 //BA.debugLineNum = 25886725;BA.debugLine="addTaskPanel.Initialize(\"addTaskPanel\")";
mostCurrent._addtaskpanel.Initialize(mostCurrent.activityBA,"addTaskPanel");
RDebugUtils.currentLine=25886726;
 //BA.debugLineNum = 25886726;BA.debugLine="addTaskPanel.SetLayout(10dip, 0, 250dip, 100dip)";
mostCurrent._addtaskpanel.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=25886727;
 //BA.debugLineNum = 25886727;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 247, 247, 2";
mostCurrent._addtaskpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (247),(int) (247),(int) (247)));
RDebugUtils.currentLine=25886729;
 //BA.debugLineNum = 25886729;BA.debugLine="addTaskTextArea.Initialize(\"addTodoText\")";
mostCurrent._addtasktextarea.Initialize(mostCurrent.activityBA,"addTodoText");
RDebugUtils.currentLine=25886730;
 //BA.debugLineNum = 25886730;BA.debugLine="addTaskTextArea.Hint = \"Add a task...\"";
mostCurrent._addtasktextarea.setHint("Add a task...");
RDebugUtils.currentLine=25886731;
 //BA.debugLineNum = 25886731;BA.debugLine="addTaskTextArea.Tag = Null";
mostCurrent._addtasktextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=25886733;
 //BA.debugLineNum = 25886733;BA.debugLine="enterTaskBtn.Initialize(\"enterTaskBtn\")";
mostCurrent._entertaskbtn.Initialize(mostCurrent.activityBA,"enterTaskBtn");
RDebugUtils.currentLine=25886734;
 //BA.debugLineNum = 25886734;BA.debugLine="enterTaskBtn.Text = \"Enter task\"";
mostCurrent._entertaskbtn.setText(BA.ObjectToCharSequence("Enter task"));
RDebugUtils.currentLine=25886736;
 //BA.debugLineNum = 25886736;BA.debugLine="addTaskPanel.AddView(addTaskTextArea, 0, 0, addTa";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._addtasktextarea.getObject()),(int) (0),(int) (0),mostCurrent._addtaskbtnpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=25886737;
 //BA.debugLineNum = 25886737;BA.debugLine="addTaskPanel.AddView(enterTaskBtn, 0, 50dip, addT";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._entertaskbtn.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),mostCurrent._addtaskbtnpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=25886739;
 //BA.debugLineNum = 25886739;BA.debugLine="tasksList.Add(addTaskPanel, addTaskPanel)";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskpanel.getObject())),(Object)(mostCurrent._addtaskpanel.getObject()));
RDebugUtils.currentLine=25886741;
 //BA.debugLineNum = 25886741;BA.debugLine="End Sub";
return "";
}
public static String  _addtitletextarea_enterpressed() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addtitletextarea_enterpressed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addtitletextarea_enterpressed", null));}
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
RDebugUtils.currentLine=25624576;
 //BA.debugLineNum = 25624576;BA.debugLine="Sub addTitleTextArea_EnterPressed";
RDebugUtils.currentLine=25624579;
 //BA.debugLineNum = 25624579;BA.debugLine="If addTitleTextArea.Tag <> Null And addTitleTextA";
if (mostCurrent._addtitletextarea.getTag()!= null && mostCurrent._addtitletextarea.getTag() instanceof java.util.List) { 
RDebugUtils.currentLine=25624580;
 //BA.debugLineNum = 25624580;BA.debugLine="Dim ctx As List = addTitleTextArea.Tag";
_ctx = new anywheresoftware.b4a.objects.collections.List();
_ctx = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(mostCurrent._addtitletextarea.getTag()));
RDebugUtils.currentLine=25624581;
 //BA.debugLineNum = 25624581;BA.debugLine="Dim oldIndex As Int = ctx.Get(0)";
_oldindex = (int)(BA.ObjectToNumber(_ctx.Get((int) (0))));
RDebugUtils.currentLine=25624582;
 //BA.debugLineNum = 25624582;BA.debugLine="Dim oldTitle As String = ctx.Get(1)";
_oldtitle = BA.ObjectToString(_ctx.Get((int) (1)));
RDebugUtils.currentLine=25624583;
 //BA.debugLineNum = 25624583;BA.debugLine="Dim newTitle As String = addTitleTextArea.Text.T";
_newtitle = mostCurrent._addtitletextarea.getText().trim();
RDebugUtils.currentLine=25624585;
 //BA.debugLineNum = 25624585;BA.debugLine="If newTitle = \"\" Or newTitle = oldTitle Then";
if ((_newtitle).equals("") || (_newtitle).equals(_oldtitle)) { 
RDebugUtils.currentLine=25624586;
 //BA.debugLineNum = 25624586;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=25624587;
 //BA.debugLineNum = 25624587;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
RDebugUtils.currentLine=25624588;
 //BA.debugLineNum = 25624588;BA.debugLine="addTitleTextArea.Enabled = False";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25624589;
 //BA.debugLineNum = 25624589;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=25624593;
 //BA.debugLineNum = 25624593;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=25624594;
 //BA.debugLineNum = 25624594;BA.debugLine="For Each existingTitle As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group13 = _savedlists;
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_existingtitle = BA.ObjectToString(group13.Get(index13));
RDebugUtils.currentLine=25624595;
 //BA.debugLineNum = 25624595;BA.debugLine="If existingTitle = newTitle Then";
if ((_existingtitle).equals(_newtitle)) { 
RDebugUtils.currentLine=25624596;
 //BA.debugLineNum = 25624596;BA.debugLine="MsgboxAsync(\"A list with that name already exi";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("A list with that name already exists."),BA.ObjectToCharSequence("Duplicate title"),processBA);
RDebugUtils.currentLine=25624597;
 //BA.debugLineNum = 25624597;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=25624602;
 //BA.debugLineNum = 25624602;BA.debugLine="savedLists.Set(oldIndex, newTitle)";
_savedlists.Set(_oldindex,(Object)(_newtitle));
RDebugUtils.currentLine=25624603;
 //BA.debugLineNum = 25624603;BA.debugLine="kvs.Put(\"lists\", savedLists)";
_kvs._put("lists",(Object)(_savedlists.getObject()));
RDebugUtils.currentLine=25624606;
 //BA.debugLineNum = 25624606;BA.debugLine="Dim oldKey As String = \"list_\" & oldTitle";
_oldkey = "list_"+_oldtitle;
RDebugUtils.currentLine=25624607;
 //BA.debugLineNum = 25624607;BA.debugLine="Dim newKey As String = \"list_\" & newTitle";
_newkey = "list_"+_newtitle;
RDebugUtils.currentLine=25624608;
 //BA.debugLineNum = 25624608;BA.debugLine="If kvs.ContainsKey(oldKey) Then";
if (_kvs._containskey(_oldkey)) { 
RDebugUtils.currentLine=25624609;
 //BA.debugLineNum = 25624609;BA.debugLine="Dim savedTasks As List = kvs.Get(oldKey)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_oldkey)));
RDebugUtils.currentLine=25624610;
 //BA.debugLineNum = 25624610;BA.debugLine="For Each task As String In savedTasks";
{
final anywheresoftware.b4a.BA.IterableList group25 = _savedtasks;
final int groupLen25 = group25.getSize()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_task = BA.ObjectToString(group25.Get(index25));
RDebugUtils.currentLine=25624611;
 //BA.debugLineNum = 25624611;BA.debugLine="Dim oldCK As String = \"checked_\" & oldTitle &";
_oldck = "checked_"+_oldtitle+"_"+_task;
RDebugUtils.currentLine=25624612;
 //BA.debugLineNum = 25624612;BA.debugLine="Dim newCK As String = \"checked_\" & newTitle &";
_newck = "checked_"+_newtitle+"_"+_task;
RDebugUtils.currentLine=25624613;
 //BA.debugLineNum = 25624613;BA.debugLine="If kvs.ContainsKey(oldCK) Then";
if (_kvs._containskey(_oldck)) { 
RDebugUtils.currentLine=25624614;
 //BA.debugLineNum = 25624614;BA.debugLine="kvs.Put(newCK, kvs.Get(oldCK))";
_kvs._put(_newck,_kvs._get(_oldck));
RDebugUtils.currentLine=25624615;
 //BA.debugLineNum = 25624615;BA.debugLine="kvs.Remove(oldCK)";
_kvs._remove(_oldck);
 };
 }
};
RDebugUtils.currentLine=25624618;
 //BA.debugLineNum = 25624618;BA.debugLine="kvs.Put(newKey, savedTasks)";
_kvs._put(_newkey,(Object)(_savedtasks.getObject()));
RDebugUtils.currentLine=25624619;
 //BA.debugLineNum = 25624619;BA.debugLine="kvs.Remove(oldKey)";
_kvs._remove(_oldkey);
 };
RDebugUtils.currentLine=25624623;
 //BA.debugLineNum = 25624623;BA.debugLine="If currentList = oldTitle Then";
if ((mostCurrent._currentlist).equals(_oldtitle)) { 
RDebugUtils.currentLine=25624624;
 //BA.debugLineNum = 25624624;BA.debugLine="currentList = newTitle";
mostCurrent._currentlist = _newtitle;
 };
RDebugUtils.currentLine=25624628;
 //BA.debugLineNum = 25624628;BA.debugLine="listsList.Clear";
mostCurrent._listslist._clear();
RDebugUtils.currentLine=25624629;
 //BA.debugLineNum = 25624629;BA.debugLine="Dim savedLists2 As List = kvs.Get(\"lists\")";
_savedlists2 = new anywheresoftware.b4a.objects.collections.List();
_savedlists2 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=25624630;
 //BA.debugLineNum = 25624630;BA.debugLine="For Each t As String In savedLists2";
{
final anywheresoftware.b4a.BA.IterableList group41 = _savedlists2;
final int groupLen41 = group41.getSize()
;int index41 = 0;
;
for (; index41 < groupLen41;index41++){
_t = BA.ObjectToString(group41.Get(index41));
RDebugUtils.currentLine=25624631;
 //BA.debugLineNum = 25624631;BA.debugLine="listsList.AddTextItem(t, t)";
mostCurrent._listslist._addtextitem((Object)(_t),(Object)(_t));
 }
};
RDebugUtils.currentLine=25624634;
 //BA.debugLineNum = 25624634;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=25624635;
 //BA.debugLineNum = 25624635;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
RDebugUtils.currentLine=25624636;
 //BA.debugLineNum = 25624636;BA.debugLine="addTitleTextArea.Enabled = False";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25624637;
 //BA.debugLineNum = 25624637;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25624638;
 //BA.debugLineNum = 25624638;BA.debugLine="isAddingList = False";
_isaddinglist = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25624639;
 //BA.debugLineNum = 25624639;BA.debugLine="ToastMessageShow(\"List renamed\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("List renamed"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25624640;
 //BA.debugLineNum = 25624640;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=25624644;
 //BA.debugLineNum = 25624644;BA.debugLine="Dim title As String = addTitleTextArea.Text";
_title = mostCurrent._addtitletextarea.getText();
RDebugUtils.currentLine=25624646;
 //BA.debugLineNum = 25624646;BA.debugLine="Dim savedLists As List";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=25624647;
 //BA.debugLineNum = 25624647;BA.debugLine="savedLists.Initialize";
_savedlists.Initialize();
RDebugUtils.currentLine=25624649;
 //BA.debugLineNum = 25624649;BA.debugLine="If title = \"\" Then";
if ((_title).equals("")) { 
RDebugUtils.currentLine=25624650;
 //BA.debugLineNum = 25624650;BA.debugLine="title = \"Untitled\" & untitledNo";
_title = "Untitled"+BA.NumberToString(_untitledno);
RDebugUtils.currentLine=25624652;
 //BA.debugLineNum = 25624652;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
RDebugUtils.currentLine=25624653;
 //BA.debugLineNum = 25624653;BA.debugLine="savedLists = kvs.Get(\"lists\")";
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=25624654;
 //BA.debugLineNum = 25624654;BA.debugLine="For Each existingTitle As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group59 = _savedlists;
final int groupLen59 = group59.getSize()
;int index59 = 0;
;
for (; index59 < groupLen59;index59++){
_existingtitle = BA.ObjectToString(group59.Get(index59));
RDebugUtils.currentLine=25624655;
 //BA.debugLineNum = 25624655;BA.debugLine="If title = existingTitle Then";
if ((_title).equals(_existingtitle)) { 
RDebugUtils.currentLine=25624656;
 //BA.debugLineNum = 25624656;BA.debugLine="untitledNo = untitledNo + 1";
_untitledno = (int) (_untitledno+1);
RDebugUtils.currentLine=25624657;
 //BA.debugLineNum = 25624657;BA.debugLine="title = \"Untitled\" & untitledNo";
_title = "Untitled"+BA.NumberToString(_untitledno);
 };
 }
};
 };
RDebugUtils.currentLine=25624662;
 //BA.debugLineNum = 25624662;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=25624665;
 //BA.debugLineNum = 25624665;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
RDebugUtils.currentLine=25624666;
 //BA.debugLineNum = 25624666;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=25624667;
 //BA.debugLineNum = 25624667;BA.debugLine="For Each existingTitle As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group70 = _savedlists;
final int groupLen70 = group70.getSize()
;int index70 = 0;
;
for (; index70 < groupLen70;index70++){
_existingtitle = BA.ObjectToString(group70.Get(index70));
RDebugUtils.currentLine=25624668;
 //BA.debugLineNum = 25624668;BA.debugLine="If existingTitle = title Then";
if ((_existingtitle).equals(_title)) { 
RDebugUtils.currentLine=25624669;
 //BA.debugLineNum = 25624669;BA.debugLine="MsgboxAsync(\"List already exists.\", \"Duplicate";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("List already exists."),BA.ObjectToCharSequence("Duplicate title"),processBA);
RDebugUtils.currentLine=25624670;
 //BA.debugLineNum = 25624670;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25624671;
 //BA.debugLineNum = 25624671;BA.debugLine="addTitleTextArea.Text = \"\"";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=25624672;
 //BA.debugLineNum = 25624672;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 };
RDebugUtils.currentLine=25624677;
 //BA.debugLineNum = 25624677;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
RDebugUtils.currentLine=25624678;
 //BA.debugLineNum = 25624678;BA.debugLine="savedLists = kvs.Get(\"lists\")";
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
 };
RDebugUtils.currentLine=25624681;
 //BA.debugLineNum = 25624681;BA.debugLine="savedLists.Add(title)";
_savedlists.Add((Object)(_title));
RDebugUtils.currentLine=25624682;
 //BA.debugLineNum = 25624682;BA.debugLine="kvs.Put(\"lists\", savedLists)";
_kvs._put("lists",(Object)(_savedlists.getObject()));
RDebugUtils.currentLine=25624684;
 //BA.debugLineNum = 25624684;BA.debugLine="listsList.AddTextItem(title, title)";
mostCurrent._listslist._addtextitem((Object)(_title),(Object)(_title));
RDebugUtils.currentLine=25624686;
 //BA.debugLineNum = 25624686;BA.debugLine="currentList = title";
mostCurrent._currentlist = _title;
RDebugUtils.currentLine=25624687;
 //BA.debugLineNum = 25624687;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
RDebugUtils.currentLine=25624688;
 //BA.debugLineNum = 25624688;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25624689;
 //BA.debugLineNum = 25624689;BA.debugLine="addTitleTextArea.Enabled = False";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25624691;
 //BA.debugLineNum = 25624691;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
RDebugUtils.currentLine=25624692;
 //BA.debugLineNum = 25624692;BA.debugLine="tasksList.GetBase.Visible = True";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25624693;
 //BA.debugLineNum = 25624693;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=25624695;
 //BA.debugLineNum = 25624695;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25624696;
 //BA.debugLineNum = 25624696;BA.debugLine="isAddingList = False";
_isaddinglist = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=25624697;
 //BA.debugLineNum = 25624697;BA.debugLine="progressNumber.Text = \"0 / 0 tasks done!\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence("0 / 0 tasks done!"));
RDebugUtils.currentLine=25624698;
 //BA.debugLineNum = 25624698;BA.debugLine="progressPercent.Text = \"0%\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence("0%"));
RDebugUtils.currentLine=25624699;
 //BA.debugLineNum = 25624699;BA.debugLine="progressBar.Progress = 0";
mostCurrent._progressbar.setProgress((int) (0));
RDebugUtils.currentLine=25624701;
 //BA.debugLineNum = 25624701;BA.debugLine="End Sub";
return "";
}
public static String  _entertaskbtn_click() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "entertaskbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "entertaskbtn_click", null));}
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
RDebugUtils.currentLine=25952256;
 //BA.debugLineNum = 25952256;BA.debugLine="Sub enterTaskBtn_Click";
RDebugUtils.currentLine=25952258;
 //BA.debugLineNum = 25952258;BA.debugLine="Dim newTask As String = addTaskTextArea.Text.Trim";
_newtask = mostCurrent._addtasktextarea.getText().trim();
RDebugUtils.currentLine=25952259;
 //BA.debugLineNum = 25952259;BA.debugLine="If newTask = \"\" Then";
if ((_newtask).equals("")) { 
RDebugUtils.currentLine=25952260;
 //BA.debugLineNum = 25952260;BA.debugLine="MsgboxAsync(\"Please enter a task.\", \"No task ent";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Please enter a task."),BA.ObjectToCharSequence("No task entered"),processBA);
RDebugUtils.currentLine=25952261;
 //BA.debugLineNum = 25952261;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=25952265;
 //BA.debugLineNum = 25952265;BA.debugLine="If addTaskTextArea.Tag <> Null Then";
if (mostCurrent._addtasktextarea.getTag()!= null) { 
RDebugUtils.currentLine=25952266;
 //BA.debugLineNum = 25952266;BA.debugLine="Dim ctx As List = addTaskTextArea.Tag";
_ctx = new anywheresoftware.b4a.objects.collections.List();
_ctx = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(mostCurrent._addtasktextarea.getTag()));
RDebugUtils.currentLine=25952267;
 //BA.debugLineNum = 25952267;BA.debugLine="Dim oldTask As String = ctx.Get(1)";
_oldtask = BA.ObjectToString(_ctx.Get((int) (1)));
RDebugUtils.currentLine=25952269;
 //BA.debugLineNum = 25952269;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
RDebugUtils.currentLine=25952270;
 //BA.debugLineNum = 25952270;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
RDebugUtils.currentLine=25952271;
 //BA.debugLineNum = 25952271;BA.debugLine="Dim taskIndex As Int = savedTasks.IndexOf(oldTas";
_taskindex = _savedtasks.IndexOf((Object)(_oldtask));
RDebugUtils.currentLine=25952272;
 //BA.debugLineNum = 25952272;BA.debugLine="If taskIndex >= 0 Then";
if (_taskindex>=0) { 
RDebugUtils.currentLine=25952273;
 //BA.debugLineNum = 25952273;BA.debugLine="savedTasks.Set(taskIndex, newTask)";
_savedtasks.Set(_taskindex,(Object)(_newtask));
RDebugUtils.currentLine=25952274;
 //BA.debugLineNum = 25952274;BA.debugLine="kvs.Put(key, savedTasks)";
_kvs._put(_key,(Object)(_savedtasks.getObject()));
 };
RDebugUtils.currentLine=25952278;
 //BA.debugLineNum = 25952278;BA.debugLine="Dim oldCK As String = \"checked_\" & currentList &";
_oldck = "checked_"+mostCurrent._currentlist+"_"+_oldtask;
RDebugUtils.currentLine=25952279;
 //BA.debugLineNum = 25952279;BA.debugLine="Dim newCK As String = \"checked_\" & currentList &";
_newck = "checked_"+mostCurrent._currentlist+"_"+_newtask;
RDebugUtils.currentLine=25952280;
 //BA.debugLineNum = 25952280;BA.debugLine="If kvs.ContainsKey(oldCK) Then";
if (_kvs._containskey(_oldck)) { 
RDebugUtils.currentLine=25952281;
 //BA.debugLineNum = 25952281;BA.debugLine="kvs.Put(newCK, kvs.Get(oldCK))";
_kvs._put(_newck,_kvs._get(_oldck));
RDebugUtils.currentLine=25952282;
 //BA.debugLineNum = 25952282;BA.debugLine="kvs.Remove(oldCK)";
_kvs._remove(_oldck);
 };
RDebugUtils.currentLine=25952285;
 //BA.debugLineNum = 25952285;BA.debugLine="addTaskTextArea.Tag = Null";
mostCurrent._addtasktextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=25952288;
 //BA.debugLineNum = 25952288;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
RDebugUtils.currentLine=25952289;
 //BA.debugLineNum = 25952289;BA.debugLine="Dim savedTasks2 As List = kvs.Get(key)";
_savedtasks2 = new anywheresoftware.b4a.objects.collections.List();
_savedtasks2 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
RDebugUtils.currentLine=25952290;
 //BA.debugLineNum = 25952290;BA.debugLine="For Each t As String In savedTasks2";
{
final anywheresoftware.b4a.BA.IterableList group25 = _savedtasks2;
final int groupLen25 = group25.getSize()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_t = BA.ObjectToString(group25.Get(index25));
RDebugUtils.currentLine=25952291;
 //BA.debugLineNum = 25952291;BA.debugLine="tasksListUI(t)";
_taskslistui(_t);
 }
};
RDebugUtils.currentLine=25952293;
 //BA.debugLineNum = 25952293;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=25952294;
 //BA.debugLineNum = 25952294;BA.debugLine="addTaskBtn.Enabled = True";
mostCurrent._addtaskbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25952295;
 //BA.debugLineNum = 25952295;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=25952296;
 //BA.debugLineNum = 25952296;BA.debugLine="ToastMessageShow(\"Task renamed\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Task renamed"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25952297;
 //BA.debugLineNum = 25952297;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=25952301;
 //BA.debugLineNum = 25952301;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
mostCurrent._taskslist._removeat((int) (mostCurrent._taskslist._getsize()-1));
RDebugUtils.currentLine=25952303;
 //BA.debugLineNum = 25952303;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
RDebugUtils.currentLine=25952304;
 //BA.debugLineNum = 25952304;BA.debugLine="Dim savedTasks As List";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=25952305;
 //BA.debugLineNum = 25952305;BA.debugLine="If kvs.ContainsKey(key) Then";
if (_kvs._containskey(_key)) { 
RDebugUtils.currentLine=25952306;
 //BA.debugLineNum = 25952306;BA.debugLine="savedTasks = kvs.Get(key)";
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
 }else {
RDebugUtils.currentLine=25952308;
 //BA.debugLineNum = 25952308;BA.debugLine="savedTasks.Initialize";
_savedtasks.Initialize();
 };
RDebugUtils.currentLine=25952311;
 //BA.debugLineNum = 25952311;BA.debugLine="savedTasks.Add(newTask)";
_savedtasks.Add((Object)(_newtask));
RDebugUtils.currentLine=25952312;
 //BA.debugLineNum = 25952312;BA.debugLine="kvs.Put(key, savedTasks)";
_kvs._put(_key,(Object)(_savedtasks.getObject()));
RDebugUtils.currentLine=25952314;
 //BA.debugLineNum = 25952314;BA.debugLine="tasksListUI(newTask)";
_taskslistui(_newtask);
RDebugUtils.currentLine=25952315;
 //BA.debugLineNum = 25952315;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=25952316;
 //BA.debugLineNum = 25952316;BA.debugLine="addTaskBtn.Enabled = True";
mostCurrent._addtaskbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25952317;
 //BA.debugLineNum = 25952317;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=25952319;
 //BA.debugLineNum = 25952319;BA.debugLine="End Sub";
return "";
}
public static String  _taskslistui(String _newtask) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "taskslistui", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "taskslistui", new Object[] {_newtask}));}
anywheresoftware.b4a.objects.PanelWrapper _taskpnl = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _taskcheckbox = null;
anywheresoftware.b4a.objects.LabelWrapper _tasklbl = null;
anywheresoftware.b4a.objects.PanelWrapper _divider = null;
String _checkedkey = "";
boolean _ischecked = false;
RDebugUtils.currentLine=26214400;
 //BA.debugLineNum = 26214400;BA.debugLine="Sub tasksListUI(newTask As String)";
RDebugUtils.currentLine=26214402;
 //BA.debugLineNum = 26214402;BA.debugLine="Dim taskPNL As Panel";
_taskpnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=26214403;
 //BA.debugLineNum = 26214403;BA.debugLine="taskPNL.Initialize(\"taskPNL\")";
_taskpnl.Initialize(mostCurrent.activityBA,"taskPNL");
RDebugUtils.currentLine=26214404;
 //BA.debugLineNum = 26214404;BA.debugLine="taskPNL.SetLayout(0, 0, 250dip, 60dip)";
_taskpnl.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=26214406;
 //BA.debugLineNum = 26214406;BA.debugLine="Dim taskCheckbox As CheckBox";
_taskcheckbox = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=26214407;
 //BA.debugLineNum = 26214407;BA.debugLine="taskCheckbox.Initialize(\"taskCheckbox\")";
_taskcheckbox.Initialize(mostCurrent.activityBA,"taskCheckbox");
RDebugUtils.currentLine=26214408;
 //BA.debugLineNum = 26214408;BA.debugLine="taskPNL.AddView(taskCheckbox, 0dip, 10dip, 40dip,";
_taskpnl.AddView((android.view.View)(_taskcheckbox.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=26214410;
 //BA.debugLineNum = 26214410;BA.debugLine="Dim taskLBL As Label";
_tasklbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=26214411;
 //BA.debugLineNum = 26214411;BA.debugLine="taskLBL.Initialize(\"taskLBL\")";
_tasklbl.Initialize(mostCurrent.activityBA,"taskLBL");
RDebugUtils.currentLine=26214412;
 //BA.debugLineNum = 26214412;BA.debugLine="taskLBL.Text = newTask";
_tasklbl.setText(BA.ObjectToCharSequence(_newtask));
RDebugUtils.currentLine=26214413;
 //BA.debugLineNum = 26214413;BA.debugLine="taskLBL.TextColor = Colors.Black";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=26214414;
 //BA.debugLineNum = 26214414;BA.debugLine="taskPNL.AddView(taskLBL, 40dip, 20dip, taskPNL.Wi";
_taskpnl.AddView((android.view.View)(_tasklbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),(int) (_taskpnl.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80))),_taskpnl.getHeight());
RDebugUtils.currentLine=26214416;
 //BA.debugLineNum = 26214416;BA.debugLine="Dim divider As Panel";
_divider = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=26214417;
 //BA.debugLineNum = 26214417;BA.debugLine="divider.Initialize(\"line\")";
_divider.Initialize(mostCurrent.activityBA,"line");
RDebugUtils.currentLine=26214418;
 //BA.debugLineNum = 26214418;BA.debugLine="divider.Color = Colors.ARGB(255, 60, 60, 60)";
_divider.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (60),(int) (60),(int) (60)));
RDebugUtils.currentLine=26214419;
 //BA.debugLineNum = 26214419;BA.debugLine="taskPNL.AddView(divider, 0, 59dip, taskPNL.Width,";
_taskpnl.AddView((android.view.View)(_divider.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (59)),_taskpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=26214421;
 //BA.debugLineNum = 26214421;BA.debugLine="taskCheckbox.Tag = taskLBL";
_taskcheckbox.setTag((Object)(_tasklbl.getObject()));
RDebugUtils.currentLine=26214424;
 //BA.debugLineNum = 26214424;BA.debugLine="Dim checkedKey As String = \"checked_\" & currentLi";
_checkedkey = "checked_"+mostCurrent._currentlist+"_"+_newtask;
RDebugUtils.currentLine=26214425;
 //BA.debugLineNum = 26214425;BA.debugLine="If kvs.ContainsKey(checkedKey) Then";
if (_kvs._containskey(_checkedkey)) { 
RDebugUtils.currentLine=26214426;
 //BA.debugLineNum = 26214426;BA.debugLine="Dim isChecked As Boolean = kvs.Get(checkedKey)";
_ischecked = BA.ObjectToBoolean(_kvs._get(_checkedkey));
RDebugUtils.currentLine=26214427;
 //BA.debugLineNum = 26214427;BA.debugLine="taskCheckbox.Checked = isChecked";
_taskcheckbox.setChecked(_ischecked);
RDebugUtils.currentLine=26214428;
 //BA.debugLineNum = 26214428;BA.debugLine="If isChecked Then";
if (_ischecked) { 
RDebugUtils.currentLine=26214429;
 //BA.debugLineNum = 26214429;BA.debugLine="taskLBL.TextColor = Colors.ARGB(50, 0, 0, 0)";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
 };
 };
RDebugUtils.currentLine=26214433;
 //BA.debugLineNum = 26214433;BA.debugLine="tasksList.Add(taskPNL, newTask)";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_taskpnl.getObject())),(Object)(_newtask));
RDebugUtils.currentLine=26214435;
 //BA.debugLineNum = 26214435;BA.debugLine="End Sub";
return "";
}
public static String  _updateprogress() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "updateprogress", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "updateprogress", null));}
String _key = "";
anywheresoftware.b4a.objects.collections.List _savedtasks = null;
int _totaltasks = 0;
int _donetasks = 0;
int _percentagetasks = 0;
String _task = "";
String _checkedkey = "";
RDebugUtils.currentLine=26279936;
 //BA.debugLineNum = 26279936;BA.debugLine="Sub updateProgress";
RDebugUtils.currentLine=26279938;
 //BA.debugLineNum = 26279938;BA.debugLine="If currentList = \"\" Then";
if ((mostCurrent._currentlist).equals("")) { 
RDebugUtils.currentLine=26279939;
 //BA.debugLineNum = 26279939;BA.debugLine="progressNumber.Text = \"\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=26279940;
 //BA.debugLineNum = 26279940;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=26279943;
 //BA.debugLineNum = 26279943;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
RDebugUtils.currentLine=26279944;
 //BA.debugLineNum = 26279944;BA.debugLine="If kvs.ContainsKey(key) = False Then";
if (_kvs._containskey(_key)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=26279945;
 //BA.debugLineNum = 26279945;BA.debugLine="progressNumber.Text = \"0 / 0 tasks done!\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence("0 / 0 tasks done!"));
RDebugUtils.currentLine=26279946;
 //BA.debugLineNum = 26279946;BA.debugLine="progressPercent.Text = \"0%\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence("0%"));
RDebugUtils.currentLine=26279947;
 //BA.debugLineNum = 26279947;BA.debugLine="progressBar.Progress = 0";
mostCurrent._progressbar.setProgress((int) (0));
RDebugUtils.currentLine=26279948;
 //BA.debugLineNum = 26279948;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=26279952;
 //BA.debugLineNum = 26279952;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
RDebugUtils.currentLine=26279953;
 //BA.debugLineNum = 26279953;BA.debugLine="Dim totalTasks As Int = savedTasks.Size";
_totaltasks = _savedtasks.getSize();
RDebugUtils.currentLine=26279954;
 //BA.debugLineNum = 26279954;BA.debugLine="Dim doneTasks As Int = 0";
_donetasks = (int) (0);
RDebugUtils.currentLine=26279955;
 //BA.debugLineNum = 26279955;BA.debugLine="Dim percentageTasks As Int = 0";
_percentagetasks = (int) (0);
RDebugUtils.currentLine=26279957;
 //BA.debugLineNum = 26279957;BA.debugLine="For Each task As String In savedTasks";
{
final anywheresoftware.b4a.BA.IterableList group16 = _savedtasks;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_task = BA.ObjectToString(group16.Get(index16));
RDebugUtils.currentLine=26279958;
 //BA.debugLineNum = 26279958;BA.debugLine="Dim checkedKey As String = \"checked_\" & currentL";
_checkedkey = "checked_"+mostCurrent._currentlist+"_"+_task;
RDebugUtils.currentLine=26279959;
 //BA.debugLineNum = 26279959;BA.debugLine="If kvs.ContainsKey(checkedKey) Then";
if (_kvs._containskey(_checkedkey)) { 
RDebugUtils.currentLine=26279960;
 //BA.debugLineNum = 26279960;BA.debugLine="If kvs.Get(checkedKey) = True Then";
if ((_kvs._get(_checkedkey)).equals((Object)(anywheresoftware.b4a.keywords.Common.True))) { 
RDebugUtils.currentLine=26279961;
 //BA.debugLineNum = 26279961;BA.debugLine="doneTasks = doneTasks + 1";
_donetasks = (int) (_donetasks+1);
 };
 };
 }
};
RDebugUtils.currentLine=26279966;
 //BA.debugLineNum = 26279966;BA.debugLine="percentageTasks = (doneTasks / totalTasks) * 100";
_percentagetasks = (int) ((_donetasks/(double)_totaltasks)*100);
RDebugUtils.currentLine=26279968;
 //BA.debugLineNum = 26279968;BA.debugLine="progressNumber.Text = doneTasks & \" / \" & totalTa";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence(BA.NumberToString(_donetasks)+" / "+BA.NumberToString(_totaltasks)+" tasks done!"));
RDebugUtils.currentLine=26279969;
 //BA.debugLineNum = 26279969;BA.debugLine="progressPercent.Text = percentageTasks & \"%\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence(BA.NumberToString(_percentagetasks)+"%"));
RDebugUtils.currentLine=26279970;
 //BA.debugLineNum = 26279970;BA.debugLine="progressBar.Progress = percentageTasks";
mostCurrent._progressbar.setProgress(_percentagetasks);
RDebugUtils.currentLine=26279972;
 //BA.debugLineNum = 26279972;BA.debugLine="End Sub";
return "";
}
public static String  _listslist_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listslist_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "listslist_itemclick", new Object[] {_index,_value}));}
anywheresoftware.b4a.objects.B4XViewWrapper _listpnl = null;
anywheresoftware.b4a.objects.LabelWrapper _listlbl = null;
String _key = "";
anywheresoftware.b4a.objects.collections.List _savedtasks = null;
String _task = "";
RDebugUtils.currentLine=25690112;
 //BA.debugLineNum = 25690112;BA.debugLine="Sub listsList_ItemClick(Index As Int, Value As Obj";
RDebugUtils.currentLine=25690114;
 //BA.debugLineNum = 25690114;BA.debugLine="If isAddingList Then Return";
if (_isaddinglist) { 
if (true) return "";};
RDebugUtils.currentLine=25690116;
 //BA.debugLineNum = 25690116;BA.debugLine="Dim listPNL As B4XView = listsList.GetPanel(Index";
_listpnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_listpnl = mostCurrent._listslist._getpanel(_index);
RDebugUtils.currentLine=25690117;
 //BA.debugLineNum = 25690117;BA.debugLine="Dim listLBL As Label = listPNL.GetView(0)";
_listlbl = new anywheresoftware.b4a.objects.LabelWrapper();
_listlbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_listpnl.GetView((int) (0)).getObject()));
RDebugUtils.currentLine=25690119;
 //BA.debugLineNum = 25690119;BA.debugLine="currentList = listLBL.Text";
mostCurrent._currentlist = _listlbl.getText();
RDebugUtils.currentLine=25690120;
 //BA.debugLineNum = 25690120;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
RDebugUtils.currentLine=25690121;
 //BA.debugLineNum = 25690121;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25690123;
 //BA.debugLineNum = 25690123;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
RDebugUtils.currentLine=25690125;
 //BA.debugLineNum = 25690125;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
RDebugUtils.currentLine=25690127;
 //BA.debugLineNum = 25690127;BA.debugLine="If kvs.ContainsKey(key) Then";
if (_kvs._containskey(_key)) { 
RDebugUtils.currentLine=25690128;
 //BA.debugLineNum = 25690128;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
RDebugUtils.currentLine=25690129;
 //BA.debugLineNum = 25690129;BA.debugLine="For Each task As String In savedTasks";
{
final anywheresoftware.b4a.BA.IterableList group11 = _savedtasks;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_task = BA.ObjectToString(group11.Get(index11));
RDebugUtils.currentLine=25690130;
 //BA.debugLineNum = 25690130;BA.debugLine="tasksListUI(task)";
_taskslistui(_task);
 }
};
 };
RDebugUtils.currentLine=25690134;
 //BA.debugLineNum = 25690134;BA.debugLine="tasksList.GetBase.Visible = True";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25690135;
 //BA.debugLineNum = 25690135;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=25690136;
 //BA.debugLineNum = 25690136;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=25690138;
 //BA.debugLineNum = 25690138;BA.debugLine="End Sub";
return "";
}
public static void  _listslist_itemlongclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listslist_itemlongclick", false))
	 {Debug.delegate(mostCurrent.activityBA, "listslist_itemlongclick", new Object[] {_index,_value}); return;}
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
RDebugUtils.currentModule="todoactivity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=25755650;
 //BA.debugLineNum = 25755650;BA.debugLine="Msgbox2Async(\"Delete or rename this list?\", Value";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Delete or rename this list?"),BA.ObjectToCharSequence(_value),"Rename","","Delete",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25755651;
 //BA.debugLineNum = 25755651;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "todoactivity", "listslist_itemlongclick"), null);
this.state = 22;
return;
case 22:
//C
this.state = 1;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=25755653;
 //BA.debugLineNum = 25755653;BA.debugLine="If res = DialogResponse.POSITIVE Then ' Rename";
if (true) break;

case 1:
//if
this.state = 21;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}else 
{RDebugUtils.currentLine=25755656;
 //BA.debugLineNum = 25755656;BA.debugLine="Else If res = DialogResponse.NEGATIVE Then ' Dele";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 5;
}}
if (true) break;

case 3:
//C
this.state = 21;
RDebugUtils.currentLine=25755654;
 //BA.debugLineNum = 25755654;BA.debugLine="showRenameListPanel(Index, Value)";
_showrenamelistpanel(_index,BA.ObjectToString(_value));
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=25755658;
 //BA.debugLineNum = 25755658;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete th";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete the list \""+BA.ObjectToString(_value)+"\"?"),BA.ObjectToCharSequence("Confirmation"),"No","","Yes",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25755659;
 //BA.debugLineNum = 25755659;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "todoactivity", "listslist_itemlongclick"), null);
this.state = 23;
return;
case 23:
//C
this.state = 6;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=25755660;
 //BA.debugLineNum = 25755660;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
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
RDebugUtils.currentLine=25755661;
 //BA.debugLineNum = 25755661;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent._kvs._get("lists")));
RDebugUtils.currentLine=25755662;
 //BA.debugLineNum = 25755662;BA.debugLine="savedLists.RemoveAt(Index)";
_savedlists.RemoveAt(_index);
RDebugUtils.currentLine=25755663;
 //BA.debugLineNum = 25755663;BA.debugLine="kvs.Put(\"lists\", savedLists)";
parent._kvs._put("lists",(Object)(_savedlists.getObject()));
RDebugUtils.currentLine=25755664;
 //BA.debugLineNum = 25755664;BA.debugLine="listsList.RemoveAt(Index)";
parent.mostCurrent._listslist._removeat(_index);
 if (true) break;

case 9:
//C
this.state = 10;
;
RDebugUtils.currentLine=25755668;
 //BA.debugLineNum = 25755668;BA.debugLine="Dim key As String = \"list_\" & Value";
_key = "list_"+BA.ObjectToString(_value);
RDebugUtils.currentLine=25755669;
 //BA.debugLineNum = 25755669;BA.debugLine="If kvs.ContainsKey(key) Then";
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
RDebugUtils.currentLine=25755670;
 //BA.debugLineNum = 25755670;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent._kvs._get(_key)));
RDebugUtils.currentLine=25755671;
 //BA.debugLineNum = 25755671;BA.debugLine="For Each task As String In savedTasks";
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
RDebugUtils.currentLine=25755672;
 //BA.debugLineNum = 25755672;BA.debugLine="kvs.Remove(\"checked_\" & Value & \"_\" & task)";
parent._kvs._remove("checked_"+BA.ObjectToString(_value)+"_"+_task);
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
;
RDebugUtils.currentLine=25755674;
 //BA.debugLineNum = 25755674;BA.debugLine="kvs.Remove(key)";
parent._kvs._remove(_key);
 if (true) break;
;
RDebugUtils.currentLine=25755678;
 //BA.debugLineNum = 25755678;BA.debugLine="If currentList = Value Then";

case 17:
//if
this.state = 20;
if ((parent.mostCurrent._currentlist).equals(BA.ObjectToString(_value))) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
RDebugUtils.currentLine=25755679;
 //BA.debugLineNum = 25755679;BA.debugLine="currentList = \"\"";
parent.mostCurrent._currentlist = "";
RDebugUtils.currentLine=25755680;
 //BA.debugLineNum = 25755680;BA.debugLine="tasksList.Clear";
parent.mostCurrent._taskslist._clear();
RDebugUtils.currentLine=25755681;
 //BA.debugLineNum = 25755681;BA.debugLine="tasksList.GetBase.Visible = False";
parent.mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25755682;
 //BA.debugLineNum = 25755682;BA.debugLine="addTitleTextArea.Text = \"\"";
parent.mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=25755683;
 //BA.debugLineNum = 25755683;BA.debugLine="addTitleTextArea.Visible = False";
parent.mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 20:
//C
this.state = 21;
;
RDebugUtils.currentLine=25755686;
 //BA.debugLineNum = 25755686;BA.debugLine="ToastMessageShow(\"List deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("List deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 21:
//C
this.state = -1;
;
RDebugUtils.currentLine=25755689;
 //BA.debugLineNum = 25755689;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _showrenamelistpanel(int _index,String _oldtitle) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showrenamelistpanel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showrenamelistpanel", new Object[] {_index,_oldtitle}));}
anywheresoftware.b4a.objects.collections.List _ctx = null;
RDebugUtils.currentLine=25821184;
 //BA.debugLineNum = 25821184;BA.debugLine="Sub showRenameListPanel(Index As Int, oldTitle As";
RDebugUtils.currentLine=25821186;
 //BA.debugLineNum = 25821186;BA.debugLine="addTitleTextArea.Text = oldTitle";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(_oldtitle));
RDebugUtils.currentLine=25821187;
 //BA.debugLineNum = 25821187;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25821188;
 //BA.debugLineNum = 25821188;BA.debugLine="addTitleTextArea.Enabled = True";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25821189;
 //BA.debugLineNum = 25821189;BA.debugLine="addTitleTextArea.RequestFocus";
mostCurrent._addtitletextarea.RequestFocus();
RDebugUtils.currentLine=25821191;
 //BA.debugLineNum = 25821191;BA.debugLine="Dim ctx As List";
_ctx = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=25821192;
 //BA.debugLineNum = 25821192;BA.debugLine="ctx.Initialize";
_ctx.Initialize();
RDebugUtils.currentLine=25821193;
 //BA.debugLineNum = 25821193;BA.debugLine="ctx.Add(Index)";
_ctx.Add((Object)(_index));
RDebugUtils.currentLine=25821194;
 //BA.debugLineNum = 25821194;BA.debugLine="ctx.Add(oldTitle)";
_ctx.Add((Object)(_oldtitle));
RDebugUtils.currentLine=25821195;
 //BA.debugLineNum = 25821195;BA.debugLine="addTitleTextArea.Tag = ctx";
mostCurrent._addtitletextarea.setTag((Object)(_ctx.getObject()));
RDebugUtils.currentLine=25821197;
 //BA.debugLineNum = 25821197;BA.debugLine="End Sub";
return "";
}
public static String  _newlistbtn_click() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "newlistbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "newlistbtn_click", null));}
RDebugUtils.currentLine=25559040;
 //BA.debugLineNum = 25559040;BA.debugLine="Sub newListBtn_Click";
RDebugUtils.currentLine=25559042;
 //BA.debugLineNum = 25559042;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
RDebugUtils.currentLine=25559043;
 //BA.debugLineNum = 25559043;BA.debugLine="isAddingList = True";
_isaddinglist = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=25559045;
 //BA.debugLineNum = 25559045;BA.debugLine="progressNumber.Text = \"\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=25559046;
 //BA.debugLineNum = 25559046;BA.debugLine="progressPercent.Text = \"\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=25559047;
 //BA.debugLineNum = 25559047;BA.debugLine="progressBar.Progress = 0";
mostCurrent._progressbar.setProgress((int) (0));
RDebugUtils.currentLine=25559049;
 //BA.debugLineNum = 25559049;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25559050;
 //BA.debugLineNum = 25559050;BA.debugLine="addTitleTextArea.Enabled = True";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25559051;
 //BA.debugLineNum = 25559051;BA.debugLine="addTitleTextArea.Background = Null";
mostCurrent._addtitletextarea.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=25559052;
 //BA.debugLineNum = 25559052;BA.debugLine="addTitleTextArea.Text = \"\"";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=25559053;
 //BA.debugLineNum = 25559053;BA.debugLine="addTitleTextArea.Hint = \"+ add a title...\"";
mostCurrent._addtitletextarea.setHint("+ add a title...");
RDebugUtils.currentLine=25559054;
 //BA.debugLineNum = 25559054;BA.debugLine="addTitleTextArea.RequestFocus";
mostCurrent._addtitletextarea.RequestFocus();
RDebugUtils.currentLine=25559055;
 //BA.debugLineNum = 25559055;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=25559057;
 //BA.debugLineNum = 25559057;BA.debugLine="newListBtn.Enabled = False";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=25559059;
 //BA.debugLineNum = 25559059;BA.debugLine="tasksList.GetBase.Visible = True";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25559060;
 //BA.debugLineNum = 25559060;BA.debugLine="addTaskBtn.Visible = True";
mostCurrent._addtaskbtn.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=25559062;
 //BA.debugLineNum = 25559062;BA.debugLine="End Sub";
return "";
}
public static String  _showrenametaskpanel(int _index,String _oldtask) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showrenametaskpanel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showrenametaskpanel", new Object[] {_index,_oldtask}));}
anywheresoftware.b4a.objects.collections.List _ctx = null;
RDebugUtils.currentLine=26083328;
 //BA.debugLineNum = 26083328;BA.debugLine="Sub showRenameTaskPanel(Index As Int, oldTask As S";
RDebugUtils.currentLine=26083330;
 //BA.debugLineNum = 26083330;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1) ' remove \"";
mostCurrent._taskslist._removeat((int) (mostCurrent._taskslist._getsize()-1));
RDebugUtils.currentLine=26083332;
 //BA.debugLineNum = 26083332;BA.debugLine="addTaskPanel.Initialize(\"addTaskPanel\")";
mostCurrent._addtaskpanel.Initialize(mostCurrent.activityBA,"addTaskPanel");
RDebugUtils.currentLine=26083333;
 //BA.debugLineNum = 26083333;BA.debugLine="addTaskPanel.SetLayout(10dip, 0, 250dip, 100dip)";
mostCurrent._addtaskpanel.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=26083334;
 //BA.debugLineNum = 26083334;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 247, 247, 2";
mostCurrent._addtaskpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (247),(int) (247),(int) (247)));
RDebugUtils.currentLine=26083336;
 //BA.debugLineNum = 26083336;BA.debugLine="addTaskTextArea.Initialize(\"addTodoText\")";
mostCurrent._addtasktextarea.Initialize(mostCurrent.activityBA,"addTodoText");
RDebugUtils.currentLine=26083337;
 //BA.debugLineNum = 26083337;BA.debugLine="addTaskTextArea.Text = oldTask";
mostCurrent._addtasktextarea.setText(BA.ObjectToCharSequence(_oldtask));
RDebugUtils.currentLine=26083338;
 //BA.debugLineNum = 26083338;BA.debugLine="Dim ctx As List";
_ctx = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=26083339;
 //BA.debugLineNum = 26083339;BA.debugLine="ctx.Initialize";
_ctx.Initialize();
RDebugUtils.currentLine=26083340;
 //BA.debugLineNum = 26083340;BA.debugLine="ctx.Add(Index)";
_ctx.Add((Object)(_index));
RDebugUtils.currentLine=26083341;
 //BA.debugLineNum = 26083341;BA.debugLine="ctx.Add(oldTask)";
_ctx.Add((Object)(_oldtask));
RDebugUtils.currentLine=26083342;
 //BA.debugLineNum = 26083342;BA.debugLine="addTaskTextArea.Tag = ctx";
mostCurrent._addtasktextarea.setTag((Object)(_ctx.getObject()));
RDebugUtils.currentLine=26083344;
 //BA.debugLineNum = 26083344;BA.debugLine="enterTaskBtn.Initialize(\"enterTaskBtn\")";
mostCurrent._entertaskbtn.Initialize(mostCurrent.activityBA,"enterTaskBtn");
RDebugUtils.currentLine=26083345;
 //BA.debugLineNum = 26083345;BA.debugLine="enterTaskBtn.Text = \"Rename task\"";
mostCurrent._entertaskbtn.setText(BA.ObjectToCharSequence("Rename task"));
RDebugUtils.currentLine=26083347;
 //BA.debugLineNum = 26083347;BA.debugLine="addTaskPanel.AddView(addTaskTextArea, 0, 0, addTa";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._addtasktextarea.getObject()),(int) (0),(int) (0),mostCurrent._addtaskbtnpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=26083348;
 //BA.debugLineNum = 26083348;BA.debugLine="addTaskPanel.AddView(enterTaskBtn, 0, 50dip, addT";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._entertaskbtn.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),mostCurrent._addtaskbtnpnl.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=26083350;
 //BA.debugLineNum = 26083350;BA.debugLine="tasksList.Add(addTaskPanel, addTaskPanel)";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskpanel.getObject())),(Object)(mostCurrent._addtaskpanel.getObject()));
RDebugUtils.currentLine=26083352;
 //BA.debugLineNum = 26083352;BA.debugLine="End Sub";
return "";
}
public static String  _taskcheckbox_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "taskcheckbox_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "taskcheckbox_checkedchange", new Object[] {_checked}));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _taskcheckbox = null;
anywheresoftware.b4a.objects.LabelWrapper _tasklbl = null;
String _key = "";
RDebugUtils.currentLine=26148864;
 //BA.debugLineNum = 26148864;BA.debugLine="Sub taskCheckbox_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=26148866;
 //BA.debugLineNum = 26148866;BA.debugLine="Dim taskCheckbox As CheckBox = Sender";
_taskcheckbox = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_taskcheckbox = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=26148867;
 //BA.debugLineNum = 26148867;BA.debugLine="Dim taskLBL As Label = taskCheckbox.Tag";
_tasklbl = new anywheresoftware.b4a.objects.LabelWrapper();
_tasklbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_taskcheckbox.getTag()));
RDebugUtils.currentLine=26148869;
 //BA.debugLineNum = 26148869;BA.debugLine="If Checked Then";
if (_checked) { 
RDebugUtils.currentLine=26148870;
 //BA.debugLineNum = 26148870;BA.debugLine="taskLBL.TextColor = Colors.ARGB(50, 0, 0, 0)";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
 }else {
RDebugUtils.currentLine=26148872;
 //BA.debugLineNum = 26148872;BA.debugLine="taskLBL.TextColor = Colors.Black";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=26148875;
 //BA.debugLineNum = 26148875;BA.debugLine="Dim key As String = \"checked_\" & currentList & \"_";
_key = "checked_"+mostCurrent._currentlist+"_"+_tasklbl.getText();
RDebugUtils.currentLine=26148876;
 //BA.debugLineNum = 26148876;BA.debugLine="kvs.Put(key, Checked)";
_kvs._put(_key,(Object)(_checked));
RDebugUtils.currentLine=26148878;
 //BA.debugLineNum = 26148878;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=26148880;
 //BA.debugLineNum = 26148880;BA.debugLine="End Sub";
return "";
}
public static void  _taskslist_itemlongclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "taskslist_itemlongclick", false))
	 {Debug.delegate(mostCurrent.activityBA, "taskslist_itemlongclick", new Object[] {_index,_value}); return;}
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
RDebugUtils.currentModule="todoactivity";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=26017794;
 //BA.debugLineNum = 26017794;BA.debugLine="If Value = \"\" Then Return";
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
RDebugUtils.currentLine=26017796;
 //BA.debugLineNum = 26017796;BA.debugLine="Msgbox2Async(\"Delete or rename this task?\", Value";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Delete or rename this task?"),BA.ObjectToCharSequence(_value),"Rename","","Delete",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=26017797;
 //BA.debugLineNum = 26017797;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "todoactivity", "taskslist_itemlongclick"), null);
this.state = 13;
return;
case 13:
//C
this.state = 7;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=26017799;
 //BA.debugLineNum = 26017799;BA.debugLine="If res = DialogResponse.POSITIVE Then ' Rename";
if (true) break;

case 7:
//if
this.state = 12;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 9;
}else 
{RDebugUtils.currentLine=26017802;
 //BA.debugLineNum = 26017802;BA.debugLine="Else If res = DialogResponse.NEGATIVE Then ' Dele";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 11;
}}
if (true) break;

case 9:
//C
this.state = 12;
RDebugUtils.currentLine=26017800;
 //BA.debugLineNum = 26017800;BA.debugLine="showRenameTaskPanel(Index, Value)";
_showrenametaskpanel(_index,BA.ObjectToString(_value));
 if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=26017803;
 //BA.debugLineNum = 26017803;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+parent.mostCurrent._currentlist;
RDebugUtils.currentLine=26017804;
 //BA.debugLineNum = 26017804;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent._kvs._get(_key)));
RDebugUtils.currentLine=26017805;
 //BA.debugLineNum = 26017805;BA.debugLine="savedTasks.RemoveAt(Index)";
_savedtasks.RemoveAt(_index);
RDebugUtils.currentLine=26017806;
 //BA.debugLineNum = 26017806;BA.debugLine="kvs.Put(key, savedTasks)";
parent._kvs._put(_key,(Object)(_savedtasks.getObject()));
RDebugUtils.currentLine=26017807;
 //BA.debugLineNum = 26017807;BA.debugLine="kvs.Remove(\"checked_\" & currentList & \"_\" & Valu";
parent._kvs._remove("checked_"+parent.mostCurrent._currentlist+"_"+BA.ObjectToString(_value));
RDebugUtils.currentLine=26017808;
 //BA.debugLineNum = 26017808;BA.debugLine="tasksList.RemoveAt(Index)";
parent.mostCurrent._taskslist._removeat(_index);
RDebugUtils.currentLine=26017809;
 //BA.debugLineNum = 26017809;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=26017810;
 //BA.debugLineNum = 26017810;BA.debugLine="ToastMessageShow(\"Task deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Task deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=26017813;
 //BA.debugLineNum = 26017813;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}