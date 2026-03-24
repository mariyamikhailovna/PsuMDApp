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

public class helpactivity extends Activity implements B4AActivity{
	public static helpactivity mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.helpactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (helpactivity).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.helpactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.helpactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (helpactivity) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (helpactivity) Resume **");
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
		return helpactivity.class;
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
            BA.LogInfo("** Activity (helpactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (helpactivity) Pause event (activity is not paused). **");
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
            helpactivity mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (helpactivity) Resume **");
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
public static int _helppage = 0;
public static boolean _format24h = false;
public static b4a.example3.keyvaluestore _kvs = null;
public anywheresoftware.b4a.objects.LabelWrapper _titlelbl = null;
public anywheresoftware.b4a.objects.LabelWrapper _descriptionlbl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _backbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nextbtn = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _helpimage = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.corkactivity _corkactivity = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Activity.LoadLayout(\"helpAct\")";
mostCurrent._activity.LoadLayout("helpAct",mostCurrent.activityBA);
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="showHelpPage(0)";
_showhelppage((int) (0));
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="End Sub";
return "";
}
public static String  _showhelppage(int _page) throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showhelppage", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showhelppage", new Object[] {_page}));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub showHelpPage(page As Int)";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="helpPage = page";
_helppage = _page;
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="Select page";
switch (_page) {
case 0: {
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="titleLbl.Text = \"Welcome\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Welcome"));
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="descriptionLbl.Text = \"This app is tailor-made";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("This app is tailor-made for students—or anyone who wants to learn. It has all the features you'll need in order to learn effectively!"));
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"rei.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=2752521;
 //BA.debugLineNum = 2752521;BA.debugLine="titleLbl.Text = \"Clock\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Clock"));
RDebugUtils.currentLine=2752522;
 //BA.debugLineNum = 2752522;BA.debugLine="descriptionLbl.Text = \"This is the pomodoro fea";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("This is the pomodoro feature, explanation goes here yada yada"));
RDebugUtils.currentLine=2752523;
 //BA.debugLineNum = 2752523;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"psulogo.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 break; }
case 2: {
RDebugUtils.currentLine=2752525;
 //BA.debugLineNum = 2752525;BA.debugLine="titleLbl.Text = \"Notetaking\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Notetaking"));
RDebugUtils.currentLine=2752526;
 //BA.debugLineNum = 2752526;BA.debugLine="descriptionLbl.Text = \"We take notes here, and";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("We take notes here, and we save em."));
RDebugUtils.currentLine=2752527;
 //BA.debugLineNum = 2752527;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dumbass.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 break; }
case 3: {
RDebugUtils.currentLine=2752529;
 //BA.debugLineNum = 2752529;BA.debugLine="titleLbl.Text = \"Minions\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Minions"));
RDebugUtils.currentLine=2752530;
 //BA.debugLineNum = 2752530;BA.debugLine="descriptionLbl.Text = \"Can we just praise Bob?";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("Can we just praise Bob? I love the guy"));
RDebugUtils.currentLine=2752531;
 //BA.debugLineNum = 2752531;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.Di";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"bob.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 break; }
}
;
RDebugUtils.currentLine=2752535;
 //BA.debugLineNum = 2752535;BA.debugLine="backBtn.Enabled = (page > 0)";
mostCurrent._backbtn.setEnabled((_page>0));
RDebugUtils.currentLine=2752536;
 //BA.debugLineNum = 2752536;BA.debugLine="nextBtn.Enabled = (page < 3)";
mostCurrent._nextbtn.setEnabled((_page<3));
RDebugUtils.currentLine=2752537;
 //BA.debugLineNum = 2752537;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="helpactivity";
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub backBtn_Click";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="If helpPage > 0 Then";
if (_helppage>0) { 
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="showHelpPage(helpPage - 1)";
_showhelppage((int) (_helppage-1));
 };
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="End Sub";
return "";
}
public static String  _closedashi_click() throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closedashi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "closedashi_click", null));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub closedaShi_Click";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="End Sub";
return "";
}
public static String  _nextbtn_click() throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nextbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nextbtn_click", null));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub nextBtn_Click";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="If helpPage < 3 Then";
if (_helppage<3) { 
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="showHelpPage(helpPage + 1)";
_showhelppage((int) (_helppage+1));
 };
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="End Sub";
return "";
}
}