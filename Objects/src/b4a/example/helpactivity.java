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
public anywheresoftware.b4a.objects.LabelWrapper _titlelbl = null;
public anywheresoftware.b4a.objects.LabelWrapper _descriptionlbl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _backbtn = null;
public anywheresoftware.b4a.objects.ButtonWrapper _nextbtn = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _helpimage = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _iconbutton1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _iconbutton2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _iconbutton3 = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.todoactivity _todoactivity = null;
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
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Activity.LoadLayout(\"helpAct\")";
mostCurrent._activity.LoadLayout("helpAct",mostCurrent.activityBA);
 }else {
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="Activity.LoadLayout(\"helpActDark\")";
mostCurrent._activity.LoadLayout("helpActDark",mostCurrent.activityBA);
 };
RDebugUtils.currentLine=3342343;
 //BA.debugLineNum = 3342343;BA.debugLine="showHelpPage(0)";
_showhelppage((int) (0));
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="End Sub";
return "";
}
public static String  _showhelppage(int _page) throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showhelppage", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showhelppage", new Object[] {_page}));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub showHelpPage(page As Int)";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="helpPage = page";
_helppage = _page;
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="Select page";
switch (_page) {
case 0: {
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="titleLbl.Text = \"Welcome\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Welcome"));
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="descriptionLbl.Text = \"This app is tailor-made";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("This app is tailor-made for students—or anyone who wants to learn. It has all the features you'll need in order to learn effectively!"));
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"wreath.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"star.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538954;
 //BA.debugLineNum = 3538954;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"star.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"star.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dwreath.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538958;
 //BA.debugLineNum = 3538958;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dstar.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538959;
 //BA.debugLineNum = 3538959;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dstar.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538960;
 //BA.debugLineNum = 3538960;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dstar.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 1: {
RDebugUtils.currentLine=3538963;
 //BA.debugLineNum = 3538963;BA.debugLine="titleLbl.Text = \"Calendar\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Calendar"));
RDebugUtils.currentLine=3538964;
 //BA.debugLineNum = 3538964;BA.debugLine="descriptionLbl.Text = \"The calendar comes in th";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("The calendar comes in three views to match however you like to plan. The Schedule view lets you see all your upcoming days at a glance, with major events and to-do items laid out on a timeline. The Day view shows you the full timeline for a single day, where you can add events, tasks, or birthdays, and color-coded backgrounds make each type of entry easy to tell apart. The Month view presents the classic calendar layout, complete with a month and year spinner to jump around quickly, a sneak peek of events on each day's cell, and neighboring dates filling in the empty cells so the grid always looks complete."));
RDebugUtils.currentLine=3538965;
 //BA.debugLineNum = 3538965;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3538966;
 //BA.debugLineNum = 3538966;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"calendarui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538967;
 //BA.debugLineNum = 3538967;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1249.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538968;
 //BA.debugLineNum = 3538968;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1248.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538969;
 //BA.debugLineNum = 3538969;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1247.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3538971;
 //BA.debugLineNum = 3538971;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dcalendarui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538972;
 //BA.debugLineNum = 3538972;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1252.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538973;
 //BA.debugLineNum = 3538973;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1251.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538974;
 //BA.debugLineNum = 3538974;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1250.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 2: {
RDebugUtils.currentLine=3538977;
 //BA.debugLineNum = 3538977;BA.debugLine="titleLbl.Text = \"Clock\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Clock"));
RDebugUtils.currentLine=3538978;
 //BA.debugLineNum = 3538978;BA.debugLine="descriptionLbl.Text = \"The clock keeps you on t";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("The clock keeps you on time and on task all in one place. A format button lets you switch between clock displays to whatever you prefer. It also comes with a built-in Pomodoro timer to help you stay focused and productive, and if the default durations don't work for you, you can freely adjust them to fit your own rhythm."));
RDebugUtils.currentLine=3538979;
 //BA.debugLineNum = 3538979;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3538980;
 //BA.debugLineNum = 3538980;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"clockui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538981;
 //BA.debugLineNum = 3538981;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1255.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538982;
 //BA.debugLineNum = 3538982;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1254.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538983;
 //BA.debugLineNum = 3538983;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1253.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3538985;
 //BA.debugLineNum = 3538985;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dclockui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538986;
 //BA.debugLineNum = 3538986;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1258.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538987;
 //BA.debugLineNum = 3538987;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1257.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538988;
 //BA.debugLineNum = 3538988;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1256.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 3: {
RDebugUtils.currentLine=3538991;
 //BA.debugLineNum = 3538991;BA.debugLine="titleLbl.Text = \"Corkboard\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Corkboard"));
RDebugUtils.currentLine=3538992;
 //BA.debugLineNum = 3538992;BA.debugLine="descriptionLbl.Text = \"The corkboard gives you";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("The corkboard gives you a creative space to pin your thoughts and ideas. You can place sticky notes in a variety of colors to keep things visually organized and easy to tell apart. Images from your gallery can be attached right onto the board for extra context or inspiration. And when words and notes aren't enough, you can open up a drawable canvas with a selection of colored pens and sketch, doodle, or diagram anything you have in mind."));
RDebugUtils.currentLine=3538993;
 //BA.debugLineNum = 3538993;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3538994;
 //BA.debugLineNum = 3538994;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"corkboardui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538995;
 //BA.debugLineNum = 3538995;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1261.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538996;
 //BA.debugLineNum = 3538996;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1260.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3538997;
 //BA.debugLineNum = 3538997;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1259.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3538999;
 //BA.debugLineNum = 3538999;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dcorkboardui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539000;
 //BA.debugLineNum = 3539000;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1264.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539001;
 //BA.debugLineNum = 3539001;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1263.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539002;
 //BA.debugLineNum = 3539002;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1262.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 4: {
RDebugUtils.currentLine=3539005;
 //BA.debugLineNum = 3539005;BA.debugLine="titleLbl.Text = \"Flashcards\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Flashcards"));
RDebugUtils.currentLine=3539006;
 //BA.debugLineNum = 3539006;BA.debugLine="descriptionLbl.Text = \"The flashcard feature or";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("The flashcard feature organizes your cards into decks and subdecks, and you have the freedom to add, rename, or delete any of them — with a confirmation before anything gets deleted for good. Cards are automatically shuffled so every session feels fresh. A progress bar and percentage track how far you've made it through a deck, and when you're ready to dive back in, two buttons have you covered — restart the entire deck from scratch, or continue right where you left off."));
RDebugUtils.currentLine=3539007;
 //BA.debugLineNum = 3539007;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3539008;
 //BA.debugLineNum = 3539008;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"flashcardsui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539009;
 //BA.debugLineNum = 3539009;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1267.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539010;
 //BA.debugLineNum = 3539010;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1266.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539011;
 //BA.debugLineNum = 3539011;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1265.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3539013;
 //BA.debugLineNum = 3539013;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dflashcardui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539014;
 //BA.debugLineNum = 3539014;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1270.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539015;
 //BA.debugLineNum = 3539015;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1269.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539016;
 //BA.debugLineNum = 3539016;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1268.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 5: {
RDebugUtils.currentLine=3539019;
 //BA.debugLineNum = 3539019;BA.debugLine="titleLbl.Text = \"Music Player\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Music Player"));
RDebugUtils.currentLine=3539020;
 //BA.debugLineNum = 3539020;BA.debugLine="descriptionLbl.Text = \"The music player plays t";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("The music player plays the music on startup, meaning the app greets you with songs! Filled with chill, lo-fi tracks, you have the freedom to choose what track you want to play--either through the previous/next song buttons, or through the list of songs below where you can click on whatever chooses your fancy. There's a segment of the song that you want to listen to again or you want to zoom through a certain bit of a song? The seek bar presents itself to you where you can navigate within the music."));
RDebugUtils.currentLine=3539021;
 //BA.debugLineNum = 3539021;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3539022;
 //BA.debugLineNum = 3539022;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"musicplayerui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539023;
 //BA.debugLineNum = 3539023;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1273.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539024;
 //BA.debugLineNum = 3539024;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1272.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539025;
 //BA.debugLineNum = 3539025;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1271.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3539027;
 //BA.debugLineNum = 3539027;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dmusicplayerui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539028;
 //BA.debugLineNum = 3539028;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1276.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539029;
 //BA.debugLineNum = 3539029;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1275.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539030;
 //BA.debugLineNum = 3539030;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1274.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 6: {
RDebugUtils.currentLine=3539033;
 //BA.debugLineNum = 3539033;BA.debugLine="titleLbl.Text = \"Notepad\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Notepad"));
RDebugUtils.currentLine=3539034;
 //BA.debugLineNum = 3539034;BA.debugLine="descriptionLbl.Text = \"The notepad keeps all yo";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("The notepad keeps all your notes in one tidy list that's easy to browse through. A search bar lets you quickly find any note by its title or tags, so nothing ever gets lost in the pile. Adding a new note is simple — just give it a title, attach some tags to keep things organized, and write away to your heart's content."));
RDebugUtils.currentLine=3539035;
 //BA.debugLineNum = 3539035;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3539036;
 //BA.debugLineNum = 3539036;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"notepadui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539037;
 //BA.debugLineNum = 3539037;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1279.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539038;
 //BA.debugLineNum = 3539038;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1278.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539039;
 //BA.debugLineNum = 3539039;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1277.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3539041;
 //BA.debugLineNum = 3539041;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dnotepadui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539042;
 //BA.debugLineNum = 3539042;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1282.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539043;
 //BA.debugLineNum = 3539043;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1281.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539044;
 //BA.debugLineNum = 3539044;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1283.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 7: {
RDebugUtils.currentLine=3539047;
 //BA.debugLineNum = 3539047;BA.debugLine="titleLbl.Text = \"To-do List\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("To-do List"));
RDebugUtils.currentLine=3539048;
 //BA.debugLineNum = 3539048;BA.debugLine="descriptionLbl.Text = \"The to-do list enables y";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("The to-do list enables you to create lists with titles and, especially, tasks you want or are obligated to do. You are able to keep a lot of lists that you can easily navigate through the left side of your screen. The task section is a checklist of your tasks that you input, and once achieved, you can tick it off the list. The to-do list will also show you your progress in the list."));
RDebugUtils.currentLine=3539049;
 //BA.debugLineNum = 3539049;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3539050;
 //BA.debugLineNum = 3539050;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"todoui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539051;
 //BA.debugLineNum = 3539051;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1285.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539052;
 //BA.debugLineNum = 3539052;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1284.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539053;
 //BA.debugLineNum = 3539053;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1283.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3539055;
 //BA.debugLineNum = 3539055;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dtodoui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539056;
 //BA.debugLineNum = 3539056;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1288.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539057;
 //BA.debugLineNum = 3539057;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1287.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539058;
 //BA.debugLineNum = 3539058;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1286.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 8: {
RDebugUtils.currentLine=3539061;
 //BA.debugLineNum = 3539061;BA.debugLine="titleLbl.Text = \"Themes\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Themes"));
RDebugUtils.currentLine=3539062;
 //BA.debugLineNum = 3539062;BA.debugLine="descriptionLbl.Text = \"Themes let you put your";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("Themes let you put your own fun twist on the app. Choose from a range of styles and color schemes to dress up your experience, making the space you study and plan in feel a little more like yours."));
RDebugUtils.currentLine=3539063;
 //BA.debugLineNum = 3539063;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3539064;
 //BA.debugLineNum = 3539064;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"themesui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539065;
 //BA.debugLineNum = 3539065;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1291.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539066;
 //BA.debugLineNum = 3539066;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1290.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539067;
 //BA.debugLineNum = 3539067;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1289.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3539069;
 //BA.debugLineNum = 3539069;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dthemesui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539070;
 //BA.debugLineNum = 3539070;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1294.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539071;
 //BA.debugLineNum = 3539071;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1293.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539072;
 //BA.debugLineNum = 3539072;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1292.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 9: {
RDebugUtils.currentLine=3539075;
 //BA.debugLineNum = 3539075;BA.debugLine="titleLbl.Text = \"Lamp\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Lamp"));
RDebugUtils.currentLine=3539076;
 //BA.debugLineNum = 3539076;BA.debugLine="descriptionLbl.Text = \"The lamp gives you contr";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("The lamp gives you control over how the app looks in any lighting. Switch effortlessly between light mode for bright environments and dark mode for low-light settings, so your eyes stay comfortable no matter when or where you're working."));
RDebugUtils.currentLine=3539077;
 //BA.debugLineNum = 3539077;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3539078;
 //BA.debugLineNum = 3539078;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"lampui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539079;
 //BA.debugLineNum = 3539079;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1297.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539080;
 //BA.debugLineNum = 3539080;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1296.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539081;
 //BA.debugLineNum = 3539081;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1295.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3539083;
 //BA.debugLineNum = 3539083;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dlampui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539084;
 //BA.debugLineNum = 3539084;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1298.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539085;
 //BA.debugLineNum = 3539085;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1299.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539086;
 //BA.debugLineNum = 3539086;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"IMG_1300.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
case 10: {
RDebugUtils.currentLine=3539089;
 //BA.debugLineNum = 3539089;BA.debugLine="titleLbl.Text = \"Navigation\"";
mostCurrent._titlelbl.setText(BA.ObjectToCharSequence("Navigation"));
RDebugUtils.currentLine=3539090;
 //BA.debugLineNum = 3539090;BA.debugLine="descriptionLbl.Text = \"Navigation is your home";
mostCurrent._descriptionlbl.setText(BA.ObjectToCharSequence("Navigation is your home base for getting around the app. All of the app's features are laid out in one accessible spot, with clearly labeled and easy-to-read buttons so you can jump to wherever you need to be without any hassle."));
RDebugUtils.currentLine=3539091;
 //BA.debugLineNum = 3539091;BA.debugLine="If Starter.darkMode = False Then";
if (mostCurrent._starter._darkmode /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3539092;
 //BA.debugLineNum = 3539092;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"navigationui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539093;
 //BA.debugLineNum = 3539093;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"star.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539094;
 //BA.debugLineNum = 3539094;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Navbtn.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539095;
 //BA.debugLineNum = 3539095;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"star.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 }else {
RDebugUtils.currentLine=3539097;
 //BA.debugLineNum = 3539097;BA.debugLine="helpimage.Bitmap = xui.LoadBitmapResize(File.D";
mostCurrent._helpimage.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dnavigationui.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539098;
 //BA.debugLineNum = 3539098;BA.debugLine="iconButton1.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton1.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dstar.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539099;
 //BA.debugLineNum = 3539099;BA.debugLine="iconButton2.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton2.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Navbtn.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3539100;
 //BA.debugLineNum = 3539100;BA.debugLine="iconButton3.Bitmap = xui.LoadBitmapResize(File";
mostCurrent._iconbutton3.setBitmap((android.graphics.Bitmap)(_xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"dstar.png",mostCurrent._helpimage.getWidth(),mostCurrent._helpimage.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 break; }
}
;
RDebugUtils.currentLine=3539105;
 //BA.debugLineNum = 3539105;BA.debugLine="backBtn.Enabled = (page > 0)";
mostCurrent._backbtn.setEnabled((_page>0));
RDebugUtils.currentLine=3539106;
 //BA.debugLineNum = 3539106;BA.debugLine="nextBtn.Enabled = (page < 10)";
mostCurrent._nextbtn.setEnabled((_page<10));
RDebugUtils.currentLine=3539107;
 //BA.debugLineNum = 3539107;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="helpactivity";
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="End Sub";
return "";
}
public static String  _backbtn_click() throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backbtn_click", null));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub backBtn_Click";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="If helpPage > 0 Then";
if (_helppage>0) { 
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="showHelpPage(helpPage - 1)";
_showhelppage((int) (_helppage-1));
 };
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="End Sub";
return "";
}
public static String  _closehelp_click() throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closehelp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "closehelp_click", null));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub closeHelp_Click";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="End Sub";
return "";
}
public static String  _nextbtn_click() throws Exception{
RDebugUtils.currentModule="helpactivity";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nextbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nextbtn_click", null));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub nextBtn_Click";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="If helpPage < 10 Then";
if (_helppage<10) { 
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="showHelpPage(helpPage + 1)";
_showhelppage((int) (_helppage+1));
 };
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="End Sub";
return "";
}
}