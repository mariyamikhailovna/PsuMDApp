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
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.musicactivity _musicactivity = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.collections.List _savedlists = null;
String _title = "";
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=6946819;
 //BA.debugLineNum = 6946819;BA.debugLine="If Starter.darkMode Then";
if (mostCurrent._starter._darkmode /*boolean*/ ) { 
RDebugUtils.currentLine=6946820;
 //BA.debugLineNum = 6946820;BA.debugLine="Activity.LoadLayout(\"todolistLayoutDark.bal\")";
mostCurrent._activity.LoadLayout("todolistLayoutDark.bal",mostCurrent.activityBA);
 }else {
RDebugUtils.currentLine=6946822;
 //BA.debugLineNum = 6946822;BA.debugLine="Activity.LoadLayout(\"todoListLayout.bal\")";
mostCurrent._activity.LoadLayout("todoListLayout.bal",mostCurrent.activityBA);
 };
RDebugUtils.currentLine=6946825;
 //BA.debugLineNum = 6946825;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=6946826;
 //BA.debugLineNum = 6946826;BA.debugLine="addTitleTextArea.Background = Null";
mostCurrent._addtitletextarea.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=6946828;
 //BA.debugLineNum = 6946828;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=6946829;
 //BA.debugLineNum = 6946829;BA.debugLine="tasksList.GetBase.Visible = False";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6946831;
 //BA.debugLineNum = 6946831;BA.debugLine="kvs.Initialize(File.DirInternal, \"todoListData\")";
_kvs._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"todoListData");
RDebugUtils.currentLine=6946833;
 //BA.debugLineNum = 6946833;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
RDebugUtils.currentLine=6946834;
 //BA.debugLineNum = 6946834;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=6946835;
 //BA.debugLineNum = 6946835;BA.debugLine="For Each title As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group13 = _savedlists;
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_title = BA.ObjectToString(group13.Get(index13));
RDebugUtils.currentLine=6946836;
 //BA.debugLineNum = 6946836;BA.debugLine="listsList.AddTextItem(title, title)";
mostCurrent._listslist._addtextitem((Object)(_title),(Object)(_title));
 }
};
 };
RDebugUtils.currentLine=6946840;
 //BA.debugLineNum = 6946840;BA.debugLine="End Sub";
return "";
}
public static String  _newaddtaskbtn() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "newaddtaskbtn", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "newaddtaskbtn", null));}
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Sub newAddTaskBtn";
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="addTaskBtnPNL.Initialize(\"addTaskBtnPNL\")";
mostCurrent._addtaskbtnpnl.Initialize(mostCurrent.activityBA,"addTaskBtnPNL");
RDebugUtils.currentLine=7143427;
 //BA.debugLineNum = 7143427;BA.debugLine="addTaskBtnPNL.SetLayout(0, 0, 350dip, 50dip)";
mostCurrent._addtaskbtnpnl.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (350)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=7143428;
 //BA.debugLineNum = 7143428;BA.debugLine="addTaskBtnPNL.Color = Colors.ARGB(255, 250, 250,";
mostCurrent._addtaskbtnpnl.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (250),(int) (250),(int) (250)));
RDebugUtils.currentLine=7143430;
 //BA.debugLineNum = 7143430;BA.debugLine="addTaskBtn.Initialize(\"addTaskBtn\")";
mostCurrent._addtaskbtn.Initialize(mostCurrent.activityBA,"addTaskBtn");
RDebugUtils.currentLine=7143431;
 //BA.debugLineNum = 7143431;BA.debugLine="addTaskBtn.Text = \"+ add a task \"";
mostCurrent._addtaskbtn.setText(BA.ObjectToCharSequence("+ add a task "));
RDebugUtils.currentLine=7143432;
 //BA.debugLineNum = 7143432;BA.debugLine="addTaskBtnPNL.AddView(addTaskBtn, -10dip, 0, 300d";
mostCurrent._addtaskbtnpnl.AddView((android.view.View)(mostCurrent._addtaskbtn.getObject()),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=7143434;
 //BA.debugLineNum = 7143434;BA.debugLine="tasksList.Add(addTaskBtnPNL, \"\")";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskbtnpnl.getObject())),(Object)(""));
RDebugUtils.currentLine=7143436;
 //BA.debugLineNum = 7143436;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="todoactivity";
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="End Sub";
return "";
}
public static String  _addtaskbtn_click() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addtaskbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addtaskbtn_click", null));}
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Sub addTaskBtn_Click";
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="addTaskBtn.Enabled = False";
mostCurrent._addtaskbtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7536643;
 //BA.debugLineNum = 7536643;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
mostCurrent._taskslist._removeat((int) (mostCurrent._taskslist._getsize()-1));
RDebugUtils.currentLine=7536645;
 //BA.debugLineNum = 7536645;BA.debugLine="addTaskPanel.Initialize(\"addTaskPanel\")";
mostCurrent._addtaskpanel.Initialize(mostCurrent.activityBA,"addTaskPanel");
RDebugUtils.currentLine=7536646;
 //BA.debugLineNum = 7536646;BA.debugLine="addTaskPanel.SetLayout(10dip, 0, 200dip, 100dip)";
mostCurrent._addtaskpanel.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=7536647;
 //BA.debugLineNum = 7536647;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 247, 247, 2";
mostCurrent._addtaskpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (247),(int) (247),(int) (247)));
RDebugUtils.currentLine=7536649;
 //BA.debugLineNum = 7536649;BA.debugLine="addTaskTextArea.Initialize(\"addTodoText\")";
mostCurrent._addtasktextarea.Initialize(mostCurrent.activityBA,"addTodoText");
RDebugUtils.currentLine=7536650;
 //BA.debugLineNum = 7536650;BA.debugLine="addTaskTextArea.Hint = \"Add a task...\"";
mostCurrent._addtasktextarea.setHint("Add a task...");
RDebugUtils.currentLine=7536651;
 //BA.debugLineNum = 7536651;BA.debugLine="addTaskTextArea.Tag = Null";
mostCurrent._addtasktextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=7536653;
 //BA.debugLineNum = 7536653;BA.debugLine="enterTaskBtn.Initialize(\"enterTaskBtn\")";
mostCurrent._entertaskbtn.Initialize(mostCurrent.activityBA,"enterTaskBtn");
RDebugUtils.currentLine=7536654;
 //BA.debugLineNum = 7536654;BA.debugLine="enterTaskBtn.Text = \"Enter task\"";
mostCurrent._entertaskbtn.setText(BA.ObjectToCharSequence("Enter task"));
RDebugUtils.currentLine=7536656;
 //BA.debugLineNum = 7536656;BA.debugLine="addTaskPanel.AddView(addTaskTextArea, 0, 0, 280di";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._addtasktextarea.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=7536657;
 //BA.debugLineNum = 7536657;BA.debugLine="addTaskPanel.AddView(enterTaskBtn, 0, 50dip, 280d";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._entertaskbtn.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=7536659;
 //BA.debugLineNum = 7536659;BA.debugLine="tasksList.Add(addTaskPanel, addTaskPanel)";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskpanel.getObject())),(Object)(mostCurrent._addtaskpanel.getObject()));
RDebugUtils.currentLine=7536661;
 //BA.debugLineNum = 7536661;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7274496;
 //BA.debugLineNum = 7274496;BA.debugLine="Sub addTitleTextArea_EnterPressed";
RDebugUtils.currentLine=7274499;
 //BA.debugLineNum = 7274499;BA.debugLine="If addTitleTextArea.Tag <> Null And addTitleTextA";
if (mostCurrent._addtitletextarea.getTag()!= null && mostCurrent._addtitletextarea.getTag() instanceof java.util.List) { 
RDebugUtils.currentLine=7274500;
 //BA.debugLineNum = 7274500;BA.debugLine="Dim ctx As List = addTitleTextArea.Tag";
_ctx = new anywheresoftware.b4a.objects.collections.List();
_ctx = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(mostCurrent._addtitletextarea.getTag()));
RDebugUtils.currentLine=7274501;
 //BA.debugLineNum = 7274501;BA.debugLine="Dim oldIndex As Int = ctx.Get(0)";
_oldindex = (int)(BA.ObjectToNumber(_ctx.Get((int) (0))));
RDebugUtils.currentLine=7274502;
 //BA.debugLineNum = 7274502;BA.debugLine="Dim oldTitle As String = ctx.Get(1)";
_oldtitle = BA.ObjectToString(_ctx.Get((int) (1)));
RDebugUtils.currentLine=7274503;
 //BA.debugLineNum = 7274503;BA.debugLine="Dim newTitle As String = addTitleTextArea.Text.T";
_newtitle = mostCurrent._addtitletextarea.getText().trim();
RDebugUtils.currentLine=7274505;
 //BA.debugLineNum = 7274505;BA.debugLine="If newTitle = \"\" Or newTitle = oldTitle Then";
if ((_newtitle).equals("") || (_newtitle).equals(_oldtitle)) { 
RDebugUtils.currentLine=7274506;
 //BA.debugLineNum = 7274506;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=7274507;
 //BA.debugLineNum = 7274507;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
RDebugUtils.currentLine=7274508;
 //BA.debugLineNum = 7274508;BA.debugLine="addTitleTextArea.Enabled = False";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7274509;
 //BA.debugLineNum = 7274509;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=7274513;
 //BA.debugLineNum = 7274513;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=7274514;
 //BA.debugLineNum = 7274514;BA.debugLine="For Each existingTitle As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group13 = _savedlists;
final int groupLen13 = group13.getSize()
;int index13 = 0;
;
for (; index13 < groupLen13;index13++){
_existingtitle = BA.ObjectToString(group13.Get(index13));
RDebugUtils.currentLine=7274515;
 //BA.debugLineNum = 7274515;BA.debugLine="If existingTitle = newTitle Then";
if ((_existingtitle).equals(_newtitle)) { 
RDebugUtils.currentLine=7274516;
 //BA.debugLineNum = 7274516;BA.debugLine="MsgboxAsync(\"A list with that name already exi";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("A list with that name already exists."),BA.ObjectToCharSequence("Duplicate title"),processBA);
RDebugUtils.currentLine=7274517;
 //BA.debugLineNum = 7274517;BA.debugLine="Return";
if (true) return "";
 };
 }
};
RDebugUtils.currentLine=7274522;
 //BA.debugLineNum = 7274522;BA.debugLine="savedLists.Set(oldIndex, newTitle)";
_savedlists.Set(_oldindex,(Object)(_newtitle));
RDebugUtils.currentLine=7274523;
 //BA.debugLineNum = 7274523;BA.debugLine="kvs.Put(\"lists\", savedLists)";
_kvs._put("lists",(Object)(_savedlists.getObject()));
RDebugUtils.currentLine=7274526;
 //BA.debugLineNum = 7274526;BA.debugLine="Dim oldKey As String = \"list_\" & oldTitle";
_oldkey = "list_"+_oldtitle;
RDebugUtils.currentLine=7274527;
 //BA.debugLineNum = 7274527;BA.debugLine="Dim newKey As String = \"list_\" & newTitle";
_newkey = "list_"+_newtitle;
RDebugUtils.currentLine=7274528;
 //BA.debugLineNum = 7274528;BA.debugLine="If kvs.ContainsKey(oldKey) Then";
if (_kvs._containskey(_oldkey)) { 
RDebugUtils.currentLine=7274529;
 //BA.debugLineNum = 7274529;BA.debugLine="Dim savedTasks As List = kvs.Get(oldKey)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_oldkey)));
RDebugUtils.currentLine=7274530;
 //BA.debugLineNum = 7274530;BA.debugLine="For Each task As String In savedTasks";
{
final anywheresoftware.b4a.BA.IterableList group25 = _savedtasks;
final int groupLen25 = group25.getSize()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_task = BA.ObjectToString(group25.Get(index25));
RDebugUtils.currentLine=7274531;
 //BA.debugLineNum = 7274531;BA.debugLine="Dim oldCK As String = \"checked_\" & oldTitle &";
_oldck = "checked_"+_oldtitle+"_"+_task;
RDebugUtils.currentLine=7274532;
 //BA.debugLineNum = 7274532;BA.debugLine="Dim newCK As String = \"checked_\" & newTitle &";
_newck = "checked_"+_newtitle+"_"+_task;
RDebugUtils.currentLine=7274533;
 //BA.debugLineNum = 7274533;BA.debugLine="If kvs.ContainsKey(oldCK) Then";
if (_kvs._containskey(_oldck)) { 
RDebugUtils.currentLine=7274534;
 //BA.debugLineNum = 7274534;BA.debugLine="kvs.Put(newCK, kvs.Get(oldCK))";
_kvs._put(_newck,_kvs._get(_oldck));
RDebugUtils.currentLine=7274535;
 //BA.debugLineNum = 7274535;BA.debugLine="kvs.Remove(oldCK)";
_kvs._remove(_oldck);
 };
 }
};
RDebugUtils.currentLine=7274538;
 //BA.debugLineNum = 7274538;BA.debugLine="kvs.Put(newKey, savedTasks)";
_kvs._put(_newkey,(Object)(_savedtasks.getObject()));
RDebugUtils.currentLine=7274539;
 //BA.debugLineNum = 7274539;BA.debugLine="kvs.Remove(oldKey)";
_kvs._remove(_oldkey);
 };
RDebugUtils.currentLine=7274543;
 //BA.debugLineNum = 7274543;BA.debugLine="If currentList = oldTitle Then";
if ((mostCurrent._currentlist).equals(_oldtitle)) { 
RDebugUtils.currentLine=7274544;
 //BA.debugLineNum = 7274544;BA.debugLine="currentList = newTitle";
mostCurrent._currentlist = _newtitle;
 };
RDebugUtils.currentLine=7274548;
 //BA.debugLineNum = 7274548;BA.debugLine="listsList.Clear";
mostCurrent._listslist._clear();
RDebugUtils.currentLine=7274549;
 //BA.debugLineNum = 7274549;BA.debugLine="Dim savedLists2 As List = kvs.Get(\"lists\")";
_savedlists2 = new anywheresoftware.b4a.objects.collections.List();
_savedlists2 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=7274550;
 //BA.debugLineNum = 7274550;BA.debugLine="For Each t As String In savedLists2";
{
final anywheresoftware.b4a.BA.IterableList group41 = _savedlists2;
final int groupLen41 = group41.getSize()
;int index41 = 0;
;
for (; index41 < groupLen41;index41++){
_t = BA.ObjectToString(group41.Get(index41));
RDebugUtils.currentLine=7274551;
 //BA.debugLineNum = 7274551;BA.debugLine="listsList.AddTextItem(t, t)";
mostCurrent._listslist._addtextitem((Object)(_t),(Object)(_t));
 }
};
RDebugUtils.currentLine=7274554;
 //BA.debugLineNum = 7274554;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=7274555;
 //BA.debugLineNum = 7274555;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
RDebugUtils.currentLine=7274556;
 //BA.debugLineNum = 7274556;BA.debugLine="addTitleTextArea.Enabled = False";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7274557;
 //BA.debugLineNum = 7274557;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7274558;
 //BA.debugLineNum = 7274558;BA.debugLine="isAddingList = False";
_isaddinglist = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=7274559;
 //BA.debugLineNum = 7274559;BA.debugLine="ToastMessageShow(\"List renamed\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("List renamed"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7274560;
 //BA.debugLineNum = 7274560;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=7274564;
 //BA.debugLineNum = 7274564;BA.debugLine="Dim title As String = addTitleTextArea.Text";
_title = mostCurrent._addtitletextarea.getText();
RDebugUtils.currentLine=7274566;
 //BA.debugLineNum = 7274566;BA.debugLine="Dim savedLists As List";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7274567;
 //BA.debugLineNum = 7274567;BA.debugLine="savedLists.Initialize";
_savedlists.Initialize();
RDebugUtils.currentLine=7274569;
 //BA.debugLineNum = 7274569;BA.debugLine="If title = \"\" Then";
if ((_title).equals("")) { 
RDebugUtils.currentLine=7274570;
 //BA.debugLineNum = 7274570;BA.debugLine="title = \"Untitled\" & untitledNo";
_title = "Untitled"+BA.NumberToString(_untitledno);
RDebugUtils.currentLine=7274572;
 //BA.debugLineNum = 7274572;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
RDebugUtils.currentLine=7274573;
 //BA.debugLineNum = 7274573;BA.debugLine="savedLists = kvs.Get(\"lists\")";
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=7274574;
 //BA.debugLineNum = 7274574;BA.debugLine="For Each existingTitle As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group59 = _savedlists;
final int groupLen59 = group59.getSize()
;int index59 = 0;
;
for (; index59 < groupLen59;index59++){
_existingtitle = BA.ObjectToString(group59.Get(index59));
RDebugUtils.currentLine=7274575;
 //BA.debugLineNum = 7274575;BA.debugLine="If title = existingTitle Then";
if ((_title).equals(_existingtitle)) { 
RDebugUtils.currentLine=7274576;
 //BA.debugLineNum = 7274576;BA.debugLine="untitledNo = untitledNo + 1";
_untitledno = (int) (_untitledno+1);
RDebugUtils.currentLine=7274577;
 //BA.debugLineNum = 7274577;BA.debugLine="title = \"Untitled\" & untitledNo";
_title = "Untitled"+BA.NumberToString(_untitledno);
 };
 }
};
 };
RDebugUtils.currentLine=7274582;
 //BA.debugLineNum = 7274582;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=7274585;
 //BA.debugLineNum = 7274585;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
RDebugUtils.currentLine=7274586;
 //BA.debugLineNum = 7274586;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
RDebugUtils.currentLine=7274587;
 //BA.debugLineNum = 7274587;BA.debugLine="For Each existingTitle As String In savedLists";
{
final anywheresoftware.b4a.BA.IterableList group70 = _savedlists;
final int groupLen70 = group70.getSize()
;int index70 = 0;
;
for (; index70 < groupLen70;index70++){
_existingtitle = BA.ObjectToString(group70.Get(index70));
RDebugUtils.currentLine=7274588;
 //BA.debugLineNum = 7274588;BA.debugLine="If existingTitle = title Then";
if ((_existingtitle).equals(_title)) { 
RDebugUtils.currentLine=7274589;
 //BA.debugLineNum = 7274589;BA.debugLine="MsgboxAsync(\"List already exists.\", \"Duplicate";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("List already exists."),BA.ObjectToCharSequence("Duplicate title"),processBA);
RDebugUtils.currentLine=7274590;
 //BA.debugLineNum = 7274590;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7274591;
 //BA.debugLineNum = 7274591;BA.debugLine="addTitleTextArea.Text = \"\"";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=7274592;
 //BA.debugLineNum = 7274592;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 };
RDebugUtils.currentLine=7274597;
 //BA.debugLineNum = 7274597;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
if (_kvs._containskey("lists")) { 
RDebugUtils.currentLine=7274598;
 //BA.debugLineNum = 7274598;BA.debugLine="savedLists = kvs.Get(\"lists\")";
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get("lists")));
 };
RDebugUtils.currentLine=7274601;
 //BA.debugLineNum = 7274601;BA.debugLine="savedLists.Add(title)";
_savedlists.Add((Object)(_title));
RDebugUtils.currentLine=7274602;
 //BA.debugLineNum = 7274602;BA.debugLine="kvs.Put(\"lists\", savedLists)";
_kvs._put("lists",(Object)(_savedlists.getObject()));
RDebugUtils.currentLine=7274604;
 //BA.debugLineNum = 7274604;BA.debugLine="listsList.AddTextItem(title, title)";
mostCurrent._listslist._addtextitem((Object)(_title),(Object)(_title));
RDebugUtils.currentLine=7274606;
 //BA.debugLineNum = 7274606;BA.debugLine="currentList = title";
mostCurrent._currentlist = _title;
RDebugUtils.currentLine=7274607;
 //BA.debugLineNum = 7274607;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
RDebugUtils.currentLine=7274608;
 //BA.debugLineNum = 7274608;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7274609;
 //BA.debugLineNum = 7274609;BA.debugLine="addTitleTextArea.Enabled = False";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7274611;
 //BA.debugLineNum = 7274611;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
RDebugUtils.currentLine=7274612;
 //BA.debugLineNum = 7274612;BA.debugLine="tasksList.GetBase.Visible = True";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7274613;
 //BA.debugLineNum = 7274613;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=7274615;
 //BA.debugLineNum = 7274615;BA.debugLine="newListBtn.Enabled = True";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7274616;
 //BA.debugLineNum = 7274616;BA.debugLine="isAddingList = False";
_isaddinglist = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=7274617;
 //BA.debugLineNum = 7274617;BA.debugLine="progressNumber.Text = \"0 / 0 tasks done!\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence("0 / 0 tasks done!"));
RDebugUtils.currentLine=7274618;
 //BA.debugLineNum = 7274618;BA.debugLine="progressPercent.Text = \"0%\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence("0%"));
RDebugUtils.currentLine=7274619;
 //BA.debugLineNum = 7274619;BA.debugLine="progressBar.Progress = 0";
mostCurrent._progressbar.setProgress((int) (0));
RDebugUtils.currentLine=7274621;
 //BA.debugLineNum = 7274621;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Sub enterTaskBtn_Click";
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="Dim newTask As String = addTaskTextArea.Text.Trim";
_newtask = mostCurrent._addtasktextarea.getText().trim();
RDebugUtils.currentLine=7602179;
 //BA.debugLineNum = 7602179;BA.debugLine="If newTask = \"\" Then";
if ((_newtask).equals("")) { 
RDebugUtils.currentLine=7602180;
 //BA.debugLineNum = 7602180;BA.debugLine="MsgboxAsync(\"Please enter a task.\", \"No task ent";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Please enter a task."),BA.ObjectToCharSequence("No task entered"),processBA);
RDebugUtils.currentLine=7602181;
 //BA.debugLineNum = 7602181;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=7602185;
 //BA.debugLineNum = 7602185;BA.debugLine="If addTaskTextArea.Tag <> Null Then";
if (mostCurrent._addtasktextarea.getTag()!= null) { 
RDebugUtils.currentLine=7602186;
 //BA.debugLineNum = 7602186;BA.debugLine="Dim ctx As List = addTaskTextArea.Tag";
_ctx = new anywheresoftware.b4a.objects.collections.List();
_ctx = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(mostCurrent._addtasktextarea.getTag()));
RDebugUtils.currentLine=7602187;
 //BA.debugLineNum = 7602187;BA.debugLine="Dim oldTask As String = ctx.Get(1)";
_oldtask = BA.ObjectToString(_ctx.Get((int) (1)));
RDebugUtils.currentLine=7602189;
 //BA.debugLineNum = 7602189;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
RDebugUtils.currentLine=7602190;
 //BA.debugLineNum = 7602190;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
RDebugUtils.currentLine=7602191;
 //BA.debugLineNum = 7602191;BA.debugLine="Dim taskIndex As Int = savedTasks.IndexOf(oldTas";
_taskindex = _savedtasks.IndexOf((Object)(_oldtask));
RDebugUtils.currentLine=7602192;
 //BA.debugLineNum = 7602192;BA.debugLine="If taskIndex >= 0 Then";
if (_taskindex>=0) { 
RDebugUtils.currentLine=7602193;
 //BA.debugLineNum = 7602193;BA.debugLine="savedTasks.Set(taskIndex, newTask)";
_savedtasks.Set(_taskindex,(Object)(_newtask));
RDebugUtils.currentLine=7602194;
 //BA.debugLineNum = 7602194;BA.debugLine="kvs.Put(key, savedTasks)";
_kvs._put(_key,(Object)(_savedtasks.getObject()));
 };
RDebugUtils.currentLine=7602198;
 //BA.debugLineNum = 7602198;BA.debugLine="Dim oldCK As String = \"checked_\" & currentList &";
_oldck = "checked_"+mostCurrent._currentlist+"_"+_oldtask;
RDebugUtils.currentLine=7602199;
 //BA.debugLineNum = 7602199;BA.debugLine="Dim newCK As String = \"checked_\" & currentList &";
_newck = "checked_"+mostCurrent._currentlist+"_"+_newtask;
RDebugUtils.currentLine=7602200;
 //BA.debugLineNum = 7602200;BA.debugLine="If kvs.ContainsKey(oldCK) Then";
if (_kvs._containskey(_oldck)) { 
RDebugUtils.currentLine=7602201;
 //BA.debugLineNum = 7602201;BA.debugLine="kvs.Put(newCK, kvs.Get(oldCK))";
_kvs._put(_newck,_kvs._get(_oldck));
RDebugUtils.currentLine=7602202;
 //BA.debugLineNum = 7602202;BA.debugLine="kvs.Remove(oldCK)";
_kvs._remove(_oldck);
 };
RDebugUtils.currentLine=7602205;
 //BA.debugLineNum = 7602205;BA.debugLine="addTaskTextArea.Tag = Null";
mostCurrent._addtasktextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=7602208;
 //BA.debugLineNum = 7602208;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
RDebugUtils.currentLine=7602209;
 //BA.debugLineNum = 7602209;BA.debugLine="Dim savedTasks2 As List = kvs.Get(key)";
_savedtasks2 = new anywheresoftware.b4a.objects.collections.List();
_savedtasks2 = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
RDebugUtils.currentLine=7602210;
 //BA.debugLineNum = 7602210;BA.debugLine="For Each t As String In savedTasks2";
{
final anywheresoftware.b4a.BA.IterableList group25 = _savedtasks2;
final int groupLen25 = group25.getSize()
;int index25 = 0;
;
for (; index25 < groupLen25;index25++){
_t = BA.ObjectToString(group25.Get(index25));
RDebugUtils.currentLine=7602211;
 //BA.debugLineNum = 7602211;BA.debugLine="tasksListUI(t)";
_taskslistui(_t);
 }
};
RDebugUtils.currentLine=7602213;
 //BA.debugLineNum = 7602213;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=7602214;
 //BA.debugLineNum = 7602214;BA.debugLine="addTaskBtn.Enabled = True";
mostCurrent._addtaskbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7602215;
 //BA.debugLineNum = 7602215;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=7602216;
 //BA.debugLineNum = 7602216;BA.debugLine="ToastMessageShow(\"Task renamed\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Task renamed"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7602217;
 //BA.debugLineNum = 7602217;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=7602221;
 //BA.debugLineNum = 7602221;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
mostCurrent._taskslist._removeat((int) (mostCurrent._taskslist._getsize()-1));
RDebugUtils.currentLine=7602223;
 //BA.debugLineNum = 7602223;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
RDebugUtils.currentLine=7602224;
 //BA.debugLineNum = 7602224;BA.debugLine="Dim savedTasks As List";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7602225;
 //BA.debugLineNum = 7602225;BA.debugLine="If kvs.ContainsKey(key) Then";
if (_kvs._containskey(_key)) { 
RDebugUtils.currentLine=7602226;
 //BA.debugLineNum = 7602226;BA.debugLine="savedTasks = kvs.Get(key)";
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
 }else {
RDebugUtils.currentLine=7602228;
 //BA.debugLineNum = 7602228;BA.debugLine="savedTasks.Initialize";
_savedtasks.Initialize();
 };
RDebugUtils.currentLine=7602230;
 //BA.debugLineNum = 7602230;BA.debugLine="savedTasks.Add(newTask)";
_savedtasks.Add((Object)(_newtask));
RDebugUtils.currentLine=7602231;
 //BA.debugLineNum = 7602231;BA.debugLine="kvs.Put(key, savedTasks)";
_kvs._put(_key,(Object)(_savedtasks.getObject()));
RDebugUtils.currentLine=7602233;
 //BA.debugLineNum = 7602233;BA.debugLine="tasksListUI(newTask)";
_taskslistui(_newtask);
RDebugUtils.currentLine=7602234;
 //BA.debugLineNum = 7602234;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=7602235;
 //BA.debugLineNum = 7602235;BA.debugLine="addTaskBtn.Enabled = True";
mostCurrent._addtaskbtn.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7602236;
 //BA.debugLineNum = 7602236;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=7602238;
 //BA.debugLineNum = 7602238;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Sub tasksListUI(newTask As String)";
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="Dim taskPNL As Panel";
_taskpnl = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="taskPNL.Initialize(\"taskPNL\")";
_taskpnl.Initialize(mostCurrent.activityBA,"taskPNL");
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="taskPNL.SetLayout(0, 0, 100%x, 60dip)";
_taskpnl.SetLayout((int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=7864326;
 //BA.debugLineNum = 7864326;BA.debugLine="Dim taskCheckbox As CheckBox";
_taskcheckbox = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="taskCheckbox.Initialize(\"taskCheckbox\")";
_taskcheckbox.Initialize(mostCurrent.activityBA,"taskCheckbox");
RDebugUtils.currentLine=7864328;
 //BA.debugLineNum = 7864328;BA.debugLine="taskPNL.AddView(taskCheckbox, 10dip, 15dip, 40dip";
_taskpnl.AddView((android.view.View)(_taskcheckbox.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=7864330;
 //BA.debugLineNum = 7864330;BA.debugLine="Dim taskLBL As Label";
_tasklbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=7864331;
 //BA.debugLineNum = 7864331;BA.debugLine="taskLBL.Initialize(\"taskLBL\")";
_tasklbl.Initialize(mostCurrent.activityBA,"taskLBL");
RDebugUtils.currentLine=7864332;
 //BA.debugLineNum = 7864332;BA.debugLine="taskLBL.Text = newTask";
_tasklbl.setText(BA.ObjectToCharSequence(_newtask));
RDebugUtils.currentLine=7864333;
 //BA.debugLineNum = 7864333;BA.debugLine="taskLBL.TextColor = Colors.Black";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=7864334;
 //BA.debugLineNum = 7864334;BA.debugLine="taskPNL.AddView(taskLBL, 60dip, 25dip, 80%x, 40di";
_taskpnl.AddView((android.view.View)(_tasklbl.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=7864336;
 //BA.debugLineNum = 7864336;BA.debugLine="Dim divider As Panel";
_divider = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=7864337;
 //BA.debugLineNum = 7864337;BA.debugLine="divider.Initialize(\"line\")";
_divider.Initialize(mostCurrent.activityBA,"line");
RDebugUtils.currentLine=7864338;
 //BA.debugLineNum = 7864338;BA.debugLine="divider.Color = Colors.ARGB(255, 60, 60, 60)";
_divider.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (60),(int) (60),(int) (60)));
RDebugUtils.currentLine=7864339;
 //BA.debugLineNum = 7864339;BA.debugLine="taskPNL.AddView(divider, 0, 59dip, 100%x, 1dip)";
_taskpnl.AddView((android.view.View)(_divider.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (59)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
RDebugUtils.currentLine=7864341;
 //BA.debugLineNum = 7864341;BA.debugLine="taskCheckbox.Tag = taskLBL";
_taskcheckbox.setTag((Object)(_tasklbl.getObject()));
RDebugUtils.currentLine=7864344;
 //BA.debugLineNum = 7864344;BA.debugLine="Dim checkedKey As String = \"checked_\" & currentLi";
_checkedkey = "checked_"+mostCurrent._currentlist+"_"+_newtask;
RDebugUtils.currentLine=7864345;
 //BA.debugLineNum = 7864345;BA.debugLine="If kvs.ContainsKey(checkedKey) Then";
if (_kvs._containskey(_checkedkey)) { 
RDebugUtils.currentLine=7864346;
 //BA.debugLineNum = 7864346;BA.debugLine="Dim isChecked As Boolean = kvs.Get(checkedKey)";
_ischecked = BA.ObjectToBoolean(_kvs._get(_checkedkey));
RDebugUtils.currentLine=7864347;
 //BA.debugLineNum = 7864347;BA.debugLine="taskCheckbox.Checked = isChecked";
_taskcheckbox.setChecked(_ischecked);
RDebugUtils.currentLine=7864348;
 //BA.debugLineNum = 7864348;BA.debugLine="If isChecked Then";
if (_ischecked) { 
RDebugUtils.currentLine=7864349;
 //BA.debugLineNum = 7864349;BA.debugLine="taskLBL.TextColor = Colors.ARGB(50, 0, 0, 0)";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
 };
 };
RDebugUtils.currentLine=7864353;
 //BA.debugLineNum = 7864353;BA.debugLine="tasksList.Add(taskPNL, newTask)";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_taskpnl.getObject())),(Object)(_newtask));
RDebugUtils.currentLine=7864355;
 //BA.debugLineNum = 7864355;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Sub updateProgress";
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="If currentList = \"\" Then";
if ((mostCurrent._currentlist).equals("")) { 
RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="progressNumber.Text = \"\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=7929863;
 //BA.debugLineNum = 7929863;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
RDebugUtils.currentLine=7929864;
 //BA.debugLineNum = 7929864;BA.debugLine="If kvs.ContainsKey(key) = False Then";
if (_kvs._containskey(_key)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=7929865;
 //BA.debugLineNum = 7929865;BA.debugLine="progressNumber.Text = \"0 / 0 tasks done!\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence("0 / 0 tasks done!"));
RDebugUtils.currentLine=7929866;
 //BA.debugLineNum = 7929866;BA.debugLine="progressPercent.Text = \"0%\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence("0%"));
RDebugUtils.currentLine=7929867;
 //BA.debugLineNum = 7929867;BA.debugLine="progressBar.Progress = 0";
mostCurrent._progressbar.setProgress((int) (0));
RDebugUtils.currentLine=7929868;
 //BA.debugLineNum = 7929868;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=7929872;
 //BA.debugLineNum = 7929872;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
RDebugUtils.currentLine=7929873;
 //BA.debugLineNum = 7929873;BA.debugLine="Dim totalTasks As Int = savedTasks.Size";
_totaltasks = _savedtasks.getSize();
RDebugUtils.currentLine=7929874;
 //BA.debugLineNum = 7929874;BA.debugLine="Dim doneTasks As Int = 0";
_donetasks = (int) (0);
RDebugUtils.currentLine=7929875;
 //BA.debugLineNum = 7929875;BA.debugLine="Dim percentageTasks As Int = 0";
_percentagetasks = (int) (0);
RDebugUtils.currentLine=7929877;
 //BA.debugLineNum = 7929877;BA.debugLine="For Each task As String In savedTasks";
{
final anywheresoftware.b4a.BA.IterableList group16 = _savedtasks;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_task = BA.ObjectToString(group16.Get(index16));
RDebugUtils.currentLine=7929878;
 //BA.debugLineNum = 7929878;BA.debugLine="Dim checkedKey As String = \"checked_\" & currentL";
_checkedkey = "checked_"+mostCurrent._currentlist+"_"+_task;
RDebugUtils.currentLine=7929879;
 //BA.debugLineNum = 7929879;BA.debugLine="If kvs.ContainsKey(checkedKey) Then";
if (_kvs._containskey(_checkedkey)) { 
RDebugUtils.currentLine=7929880;
 //BA.debugLineNum = 7929880;BA.debugLine="If kvs.Get(checkedKey) = True Then";
if ((_kvs._get(_checkedkey)).equals((Object)(anywheresoftware.b4a.keywords.Common.True))) { 
RDebugUtils.currentLine=7929881;
 //BA.debugLineNum = 7929881;BA.debugLine="doneTasks = doneTasks + 1";
_donetasks = (int) (_donetasks+1);
 };
 };
 }
};
RDebugUtils.currentLine=7929886;
 //BA.debugLineNum = 7929886;BA.debugLine="percentageTasks = (doneTasks / totalTasks) * 100";
_percentagetasks = (int) ((_donetasks/(double)_totaltasks)*100);
RDebugUtils.currentLine=7929888;
 //BA.debugLineNum = 7929888;BA.debugLine="progressNumber.Text = doneTasks & \" / \" & totalTa";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence(BA.NumberToString(_donetasks)+" / "+BA.NumberToString(_totaltasks)+" tasks done!"));
RDebugUtils.currentLine=7929889;
 //BA.debugLineNum = 7929889;BA.debugLine="progressPercent.Text = percentageTasks & \"%\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence(BA.NumberToString(_percentagetasks)+"%"));
RDebugUtils.currentLine=7929890;
 //BA.debugLineNum = 7929890;BA.debugLine="progressBar.Progress = percentageTasks";
mostCurrent._progressbar.setProgress(_percentagetasks);
RDebugUtils.currentLine=7929892;
 //BA.debugLineNum = 7929892;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Sub listsList_ItemClick(Index As Int, Value As Obj";
RDebugUtils.currentLine=7340034;
 //BA.debugLineNum = 7340034;BA.debugLine="If isAddingList Then Return";
if (_isaddinglist) { 
if (true) return "";};
RDebugUtils.currentLine=7340036;
 //BA.debugLineNum = 7340036;BA.debugLine="Dim listPNL As B4XView = listsList.GetPanel(Index";
_listpnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_listpnl = mostCurrent._listslist._getpanel(_index);
RDebugUtils.currentLine=7340037;
 //BA.debugLineNum = 7340037;BA.debugLine="Dim listLBL As Label = listPNL.GetView(0)";
_listlbl = new anywheresoftware.b4a.objects.LabelWrapper();
_listlbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_listpnl.GetView((int) (0)).getObject()));
RDebugUtils.currentLine=7340039;
 //BA.debugLineNum = 7340039;BA.debugLine="currentList = listLBL.Text";
mostCurrent._currentlist = _listlbl.getText();
RDebugUtils.currentLine=7340040;
 //BA.debugLineNum = 7340040;BA.debugLine="addTitleTextArea.Text = currentList";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(mostCurrent._currentlist));
RDebugUtils.currentLine=7340041;
 //BA.debugLineNum = 7340041;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7340043;
 //BA.debugLineNum = 7340043;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
RDebugUtils.currentLine=7340045;
 //BA.debugLineNum = 7340045;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+mostCurrent._currentlist;
RDebugUtils.currentLine=7340047;
 //BA.debugLineNum = 7340047;BA.debugLine="If kvs.ContainsKey(key) Then";
if (_kvs._containskey(_key)) { 
RDebugUtils.currentLine=7340048;
 //BA.debugLineNum = 7340048;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_kvs._get(_key)));
RDebugUtils.currentLine=7340049;
 //BA.debugLineNum = 7340049;BA.debugLine="For Each task As String In savedTasks";
{
final anywheresoftware.b4a.BA.IterableList group11 = _savedtasks;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_task = BA.ObjectToString(group11.Get(index11));
RDebugUtils.currentLine=7340050;
 //BA.debugLineNum = 7340050;BA.debugLine="tasksListUI(task)";
_taskslistui(_task);
 }
};
 };
RDebugUtils.currentLine=7340054;
 //BA.debugLineNum = 7340054;BA.debugLine="tasksList.GetBase.Visible = True";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7340055;
 //BA.debugLineNum = 7340055;BA.debugLine="newAddTaskBtn";
_newaddtaskbtn();
RDebugUtils.currentLine=7340056;
 //BA.debugLineNum = 7340056;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=7340058;
 //BA.debugLineNum = 7340058;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="Msgbox2Async(\"Delete or rename this list?\", Value";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Delete or rename this list?"),BA.ObjectToCharSequence(_value),"Rename","","Delete",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7405571;
 //BA.debugLineNum = 7405571;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "todoactivity", "listslist_itemlongclick"), null);
this.state = 22;
return;
case 22:
//C
this.state = 1;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=7405573;
 //BA.debugLineNum = 7405573;BA.debugLine="If res = DialogResponse.POSITIVE Then ' Rename";
if (true) break;

case 1:
//if
this.state = 21;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}else 
{RDebugUtils.currentLine=7405576;
 //BA.debugLineNum = 7405576;BA.debugLine="Else If res = DialogResponse.NEGATIVE Then ' Dele";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 5;
}}
if (true) break;

case 3:
//C
this.state = 21;
RDebugUtils.currentLine=7405574;
 //BA.debugLineNum = 7405574;BA.debugLine="showRenameListPanel(Index, Value)";
_showrenamelistpanel(_index,BA.ObjectToString(_value));
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=7405578;
 //BA.debugLineNum = 7405578;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete th";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Are you sure you want to delete the list \""+BA.ObjectToString(_value)+"\"?"),BA.ObjectToCharSequence("Confirmation"),"No","","Yes",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7405579;
 //BA.debugLineNum = 7405579;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "todoactivity", "listslist_itemlongclick"), null);
this.state = 23;
return;
case 23:
//C
this.state = 6;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=7405580;
 //BA.debugLineNum = 7405580;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
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
RDebugUtils.currentLine=7405581;
 //BA.debugLineNum = 7405581;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
_savedlists = new anywheresoftware.b4a.objects.collections.List();
_savedlists = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent._kvs._get("lists")));
RDebugUtils.currentLine=7405582;
 //BA.debugLineNum = 7405582;BA.debugLine="savedLists.RemoveAt(Index)";
_savedlists.RemoveAt(_index);
RDebugUtils.currentLine=7405583;
 //BA.debugLineNum = 7405583;BA.debugLine="kvs.Put(\"lists\", savedLists)";
parent._kvs._put("lists",(Object)(_savedlists.getObject()));
RDebugUtils.currentLine=7405584;
 //BA.debugLineNum = 7405584;BA.debugLine="listsList.RemoveAt(Index)";
parent.mostCurrent._listslist._removeat(_index);
 if (true) break;

case 9:
//C
this.state = 10;
;
RDebugUtils.currentLine=7405588;
 //BA.debugLineNum = 7405588;BA.debugLine="Dim key As String = \"list_\" & Value";
_key = "list_"+BA.ObjectToString(_value);
RDebugUtils.currentLine=7405589;
 //BA.debugLineNum = 7405589;BA.debugLine="If kvs.ContainsKey(key) Then";
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
RDebugUtils.currentLine=7405590;
 //BA.debugLineNum = 7405590;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent._kvs._get(_key)));
RDebugUtils.currentLine=7405591;
 //BA.debugLineNum = 7405591;BA.debugLine="For Each task As String In savedTasks";
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
RDebugUtils.currentLine=7405592;
 //BA.debugLineNum = 7405592;BA.debugLine="kvs.Remove(\"checked_\" & Value & \"_\" & task)";
parent._kvs._remove("checked_"+BA.ObjectToString(_value)+"_"+_task);
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
;
RDebugUtils.currentLine=7405594;
 //BA.debugLineNum = 7405594;BA.debugLine="kvs.Remove(key)";
parent._kvs._remove(_key);
 if (true) break;
;
RDebugUtils.currentLine=7405598;
 //BA.debugLineNum = 7405598;BA.debugLine="If currentList = Value Then";

case 17:
//if
this.state = 20;
if ((parent.mostCurrent._currentlist).equals(BA.ObjectToString(_value))) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
RDebugUtils.currentLine=7405599;
 //BA.debugLineNum = 7405599;BA.debugLine="currentList = \"\"";
parent.mostCurrent._currentlist = "";
RDebugUtils.currentLine=7405600;
 //BA.debugLineNum = 7405600;BA.debugLine="tasksList.Clear";
parent.mostCurrent._taskslist._clear();
RDebugUtils.currentLine=7405601;
 //BA.debugLineNum = 7405601;BA.debugLine="tasksList.GetBase.Visible = False";
parent.mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7405602;
 //BA.debugLineNum = 7405602;BA.debugLine="addTitleTextArea.Text = \"\"";
parent.mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=7405603;
 //BA.debugLineNum = 7405603;BA.debugLine="addTitleTextArea.Visible = False";
parent.mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 20:
//C
this.state = 21;
;
RDebugUtils.currentLine=7405606;
 //BA.debugLineNum = 7405606;BA.debugLine="ToastMessageShow(\"List deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("List deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 21:
//C
this.state = -1;
;
RDebugUtils.currentLine=7405609;
 //BA.debugLineNum = 7405609;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub showRenameListPanel(Index As Int, oldTitle As";
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="addTitleTextArea.Text = oldTitle";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(_oldtitle));
RDebugUtils.currentLine=7471107;
 //BA.debugLineNum = 7471107;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7471108;
 //BA.debugLineNum = 7471108;BA.debugLine="addTitleTextArea.Enabled = True";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7471109;
 //BA.debugLineNum = 7471109;BA.debugLine="addTitleTextArea.RequestFocus";
mostCurrent._addtitletextarea.RequestFocus();
RDebugUtils.currentLine=7471111;
 //BA.debugLineNum = 7471111;BA.debugLine="Dim ctx As List";
_ctx = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7471112;
 //BA.debugLineNum = 7471112;BA.debugLine="ctx.Initialize";
_ctx.Initialize();
RDebugUtils.currentLine=7471113;
 //BA.debugLineNum = 7471113;BA.debugLine="ctx.Add(Index)";
_ctx.Add((Object)(_index));
RDebugUtils.currentLine=7471114;
 //BA.debugLineNum = 7471114;BA.debugLine="ctx.Add(oldTitle)";
_ctx.Add((Object)(_oldtitle));
RDebugUtils.currentLine=7471115;
 //BA.debugLineNum = 7471115;BA.debugLine="addTitleTextArea.Tag = ctx";
mostCurrent._addtitletextarea.setTag((Object)(_ctx.getObject()));
RDebugUtils.currentLine=7471117;
 //BA.debugLineNum = 7471117;BA.debugLine="End Sub";
return "";
}
public static String  _newlistbtn_click() throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "newlistbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "newlistbtn_click", null));}
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Sub newListBtn_Click";
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="tasksList.Clear";
mostCurrent._taskslist._clear();
RDebugUtils.currentLine=7208963;
 //BA.debugLineNum = 7208963;BA.debugLine="isAddingList = True";
_isaddinglist = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=7208965;
 //BA.debugLineNum = 7208965;BA.debugLine="progressNumber.Text = \"\"";
mostCurrent._progressnumber.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=7208966;
 //BA.debugLineNum = 7208966;BA.debugLine="progressPercent.Text = \"\"";
mostCurrent._progresspercent.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=7208967;
 //BA.debugLineNum = 7208967;BA.debugLine="progressBar.Progress = 0";
mostCurrent._progressbar.setProgress((int) (0));
RDebugUtils.currentLine=7208969;
 //BA.debugLineNum = 7208969;BA.debugLine="addTitleTextArea.Visible = True";
mostCurrent._addtitletextarea.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7208970;
 //BA.debugLineNum = 7208970;BA.debugLine="addTitleTextArea.Enabled = True";
mostCurrent._addtitletextarea.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7208971;
 //BA.debugLineNum = 7208971;BA.debugLine="addTitleTextArea.Background = Null";
mostCurrent._addtitletextarea.setBackground((android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=7208972;
 //BA.debugLineNum = 7208972;BA.debugLine="addTitleTextArea.Text = \"\"";
mostCurrent._addtitletextarea.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=7208973;
 //BA.debugLineNum = 7208973;BA.debugLine="addTitleTextArea.Hint = \"+ add a title...\"";
mostCurrent._addtitletextarea.setHint("+ add a title...");
RDebugUtils.currentLine=7208974;
 //BA.debugLineNum = 7208974;BA.debugLine="addTitleTextArea.RequestFocus";
mostCurrent._addtitletextarea.RequestFocus();
RDebugUtils.currentLine=7208975;
 //BA.debugLineNum = 7208975;BA.debugLine="addTitleTextArea.Tag = Null";
mostCurrent._addtitletextarea.setTag(anywheresoftware.b4a.keywords.Common.Null);
RDebugUtils.currentLine=7208977;
 //BA.debugLineNum = 7208977;BA.debugLine="newListBtn.Enabled = False";
mostCurrent._newlistbtn.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7208979;
 //BA.debugLineNum = 7208979;BA.debugLine="tasksList.GetBase.Visible = True";
mostCurrent._taskslist._getbase().setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7208980;
 //BA.debugLineNum = 7208980;BA.debugLine="addTaskBtn.Visible = True";
mostCurrent._addtaskbtn.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7208982;
 //BA.debugLineNum = 7208982;BA.debugLine="End Sub";
return "";
}
public static String  _showrenametaskpanel(int _index,String _oldtask) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showrenametaskpanel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showrenametaskpanel", new Object[] {_index,_oldtask}));}
anywheresoftware.b4a.objects.collections.List _ctx = null;
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Sub showRenameTaskPanel(Index As Int, oldTask As S";
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1) ' remove \"";
mostCurrent._taskslist._removeat((int) (mostCurrent._taskslist._getsize()-1));
RDebugUtils.currentLine=7733252;
 //BA.debugLineNum = 7733252;BA.debugLine="addTaskPanel.Initialize(\"addTaskPanel\")";
mostCurrent._addtaskpanel.Initialize(mostCurrent.activityBA,"addTaskPanel");
RDebugUtils.currentLine=7733253;
 //BA.debugLineNum = 7733253;BA.debugLine="addTaskPanel.SetLayout(10dip, 0, 200dip, 100dip)";
mostCurrent._addtaskpanel.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=7733254;
 //BA.debugLineNum = 7733254;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 247, 247, 2";
mostCurrent._addtaskpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (247),(int) (247),(int) (247)));
RDebugUtils.currentLine=7733256;
 //BA.debugLineNum = 7733256;BA.debugLine="addTaskTextArea.Initialize(\"addTodoText\")";
mostCurrent._addtasktextarea.Initialize(mostCurrent.activityBA,"addTodoText");
RDebugUtils.currentLine=7733257;
 //BA.debugLineNum = 7733257;BA.debugLine="addTaskTextArea.Text = oldTask";
mostCurrent._addtasktextarea.setText(BA.ObjectToCharSequence(_oldtask));
RDebugUtils.currentLine=7733258;
 //BA.debugLineNum = 7733258;BA.debugLine="Dim ctx As List";
_ctx = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7733259;
 //BA.debugLineNum = 7733259;BA.debugLine="ctx.Initialize";
_ctx.Initialize();
RDebugUtils.currentLine=7733260;
 //BA.debugLineNum = 7733260;BA.debugLine="ctx.Add(Index)";
_ctx.Add((Object)(_index));
RDebugUtils.currentLine=7733261;
 //BA.debugLineNum = 7733261;BA.debugLine="ctx.Add(oldTask)";
_ctx.Add((Object)(_oldtask));
RDebugUtils.currentLine=7733262;
 //BA.debugLineNum = 7733262;BA.debugLine="addTaskTextArea.Tag = ctx";
mostCurrent._addtasktextarea.setTag((Object)(_ctx.getObject()));
RDebugUtils.currentLine=7733264;
 //BA.debugLineNum = 7733264;BA.debugLine="enterTaskBtn.Initialize(\"enterTaskBtn\")";
mostCurrent._entertaskbtn.Initialize(mostCurrent.activityBA,"enterTaskBtn");
RDebugUtils.currentLine=7733265;
 //BA.debugLineNum = 7733265;BA.debugLine="enterTaskBtn.Text = \"Rename task\"";
mostCurrent._entertaskbtn.setText(BA.ObjectToCharSequence("Rename task"));
RDebugUtils.currentLine=7733267;
 //BA.debugLineNum = 7733267;BA.debugLine="addTaskPanel.AddView(addTaskTextArea, 0, 0, 280di";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._addtasktextarea.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=7733268;
 //BA.debugLineNum = 7733268;BA.debugLine="addTaskPanel.AddView(enterTaskBtn, 0, 50dip, 280d";
mostCurrent._addtaskpanel.AddView((android.view.View)(mostCurrent._entertaskbtn.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=7733270;
 //BA.debugLineNum = 7733270;BA.debugLine="tasksList.Add(addTaskPanel, addTaskPanel)";
mostCurrent._taskslist._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._addtaskpanel.getObject())),(Object)(mostCurrent._addtaskpanel.getObject()));
RDebugUtils.currentLine=7733272;
 //BA.debugLineNum = 7733272;BA.debugLine="End Sub";
return "";
}
public static String  _taskcheckbox_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="todoactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "taskcheckbox_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "taskcheckbox_checkedchange", new Object[] {_checked}));}
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _taskcheckbox = null;
anywheresoftware.b4a.objects.LabelWrapper _tasklbl = null;
String _key = "";
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Sub taskCheckbox_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="Dim taskCheckbox As CheckBox = Sender";
_taskcheckbox = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
_taskcheckbox = (anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper(), (android.widget.CheckBox)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=7798787;
 //BA.debugLineNum = 7798787;BA.debugLine="Dim taskLBL As Label = taskCheckbox.Tag";
_tasklbl = new anywheresoftware.b4a.objects.LabelWrapper();
_tasklbl = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(_taskcheckbox.getTag()));
RDebugUtils.currentLine=7798789;
 //BA.debugLineNum = 7798789;BA.debugLine="If Checked Then";
if (_checked) { 
RDebugUtils.currentLine=7798790;
 //BA.debugLineNum = 7798790;BA.debugLine="taskLBL.TextColor = Colors.ARGB(50, 0, 0, 0)";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)));
 }else {
RDebugUtils.currentLine=7798792;
 //BA.debugLineNum = 7798792;BA.debugLine="taskLBL.TextColor = Colors.Black";
_tasklbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
RDebugUtils.currentLine=7798795;
 //BA.debugLineNum = 7798795;BA.debugLine="Dim key As String = \"checked_\" & currentList & \"_";
_key = "checked_"+mostCurrent._currentlist+"_"+_tasklbl.getText();
RDebugUtils.currentLine=7798796;
 //BA.debugLineNum = 7798796;BA.debugLine="kvs.Put(key, Checked)";
_kvs._put(_key,(Object)(_checked));
RDebugUtils.currentLine=7798798;
 //BA.debugLineNum = 7798798;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=7798800;
 //BA.debugLineNum = 7798800;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="If Value = \"\" Then Return";
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
RDebugUtils.currentLine=7667716;
 //BA.debugLineNum = 7667716;BA.debugLine="Msgbox2Async(\"Delete or rename this task?\", Value";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Delete or rename this task?"),BA.ObjectToCharSequence(_value),"Rename","","Delete",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7667717;
 //BA.debugLineNum = 7667717;BA.debugLine="Wait For Msgbox_Result (res As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "todoactivity", "taskslist_itemlongclick"), null);
this.state = 13;
return;
case 13:
//C
this.state = 7;
_res = (Integer) result[0];
;
RDebugUtils.currentLine=7667719;
 //BA.debugLineNum = 7667719;BA.debugLine="If res = DialogResponse.POSITIVE Then ' Rename";
if (true) break;

case 7:
//if
this.state = 12;
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 9;
}else 
{RDebugUtils.currentLine=7667722;
 //BA.debugLineNum = 7667722;BA.debugLine="Else If res = DialogResponse.NEGATIVE Then ' Dele";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.NEGATIVE) { 
this.state = 11;
}}
if (true) break;

case 9:
//C
this.state = 12;
RDebugUtils.currentLine=7667720;
 //BA.debugLineNum = 7667720;BA.debugLine="showRenameTaskPanel(Index, Value)";
_showrenametaskpanel(_index,BA.ObjectToString(_value));
 if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=7667723;
 //BA.debugLineNum = 7667723;BA.debugLine="Dim key As String = \"list_\" & currentList";
_key = "list_"+parent.mostCurrent._currentlist;
RDebugUtils.currentLine=7667724;
 //BA.debugLineNum = 7667724;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
_savedtasks = new anywheresoftware.b4a.objects.collections.List();
_savedtasks = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(parent._kvs._get(_key)));
RDebugUtils.currentLine=7667725;
 //BA.debugLineNum = 7667725;BA.debugLine="savedTasks.RemoveAt(Index)";
_savedtasks.RemoveAt(_index);
RDebugUtils.currentLine=7667726;
 //BA.debugLineNum = 7667726;BA.debugLine="kvs.Put(key, savedTasks)";
parent._kvs._put(_key,(Object)(_savedtasks.getObject()));
RDebugUtils.currentLine=7667727;
 //BA.debugLineNum = 7667727;BA.debugLine="kvs.Remove(\"checked_\" & currentList & \"_\" & Valu";
parent._kvs._remove("checked_"+parent.mostCurrent._currentlist+"_"+BA.ObjectToString(_value));
RDebugUtils.currentLine=7667728;
 //BA.debugLineNum = 7667728;BA.debugLine="tasksList.RemoveAt(Index)";
parent.mostCurrent._taskslist._removeat(_index);
RDebugUtils.currentLine=7667729;
 //BA.debugLineNum = 7667729;BA.debugLine="updateProgress";
_updateprogress();
RDebugUtils.currentLine=7667730;
 //BA.debugLineNum = 7667730;BA.debugLine="ToastMessageShow(\"Task deleted\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Task deleted"),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=7667733;
 //BA.debugLineNum = 7667733;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}