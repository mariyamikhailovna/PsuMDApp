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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.objects.Timer _songtimer = null;
public anywheresoftware.b4a.objects.MediaPlayerWrapper _mediaplayer = null;
public anywheresoftware.b4a.objects.collections.List _musicplaylist = null;
public static int _currentsong = 0;
public anywheresoftware.b4a.objects.SeekBarWrapper _seekbar1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _songtitle = null;
public anywheresoftware.b4a.objects.ButtonWrapper _pausebtn = null;
public anywheresoftware.b4a.objects.LabelWrapper _songruntime = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listview1 = null;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _i = 0;
String _title = "";
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="mediaPlayer.Initialize";
mostCurrent._mediaplayer.Initialize();
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="musicPlaylist.Initialize";
mostCurrent._musicplaylist.Initialize();
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="musicPlaylist.Add(\"timed tune.mp3\")";
mostCurrent._musicplaylist.Add((Object)("timed tune.mp3"));
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="musicPlaylist.Add(\"hammer & sickle.mp3\")";
mostCurrent._musicplaylist.Add((Object)("hammer & sickle.mp3"));
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="musicPlaylist.Add(\"all too well.mp3\")";
mostCurrent._musicplaylist.Add((Object)("all too well.mp3"));
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="musicPlaylist.Add(\"lover, you should've come over";
mostCurrent._musicplaylist.Add((Object)("lover, you should've come over.mp3"));
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="musicPlaylist.Add(\"bawat piyesa.mp3\")";
mostCurrent._musicplaylist.Add((Object)("bawat piyesa.mp3"));
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="musicPlaylist.Add(\"take a chance with me.mp3\")";
mostCurrent._musicplaylist.Add((Object)("take a chance with me.mp3"));
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="musicPlaylist.Add(\"girls never die.mp3\")";
mostCurrent._musicplaylist.Add((Object)("girls never die.mp3"));
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="musicPlaylist.Add(\"magnetic.mp3\")";
mostCurrent._musicplaylist.Add((Object)("magnetic.mp3"));
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="musicPlaylist.Add(\"supersonic.mp3\")";
mostCurrent._musicplaylist.Add((Object)("supersonic.mp3"));
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="musicPlaylist.Add(\"we're finally landing.mp3\")";
mostCurrent._musicplaylist.Add((Object)("we're finally landing.mp3"));
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="musicPlaylist.Add(\"gumball drift.mp3\")";
mostCurrent._musicplaylist.Add((Object)("gumball drift.mp3"));
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="For i = 0 To musicPlaylist.Size - 1";
{
final int step15 = 1;
final int limit15 = (int) (mostCurrent._musicplaylist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="Dim title As String = musicPlaylist.Get(i)";
_title = BA.ObjectToString(mostCurrent._musicplaylist.Get(_i));
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="title = title.SubString2(0, title.Length - 4)";
_title = _title.substring((int) (0),(int) (_title.length()-4));
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="ListView1.AddSingleLine((i + 1) & \" \" & title)";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence(BA.NumberToString((_i+1))+" "+_title));
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor = Col";
mostCurrent._listview1.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 }
};
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="currentSong = 0";
_currentsong = (int) (0);
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="songTimer.Initialize(\"songTimer\", 500)";
_songtimer.Initialize(processBA,"songTimer",(long) (500));
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="songTimer.Enabled = True";
_songtimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="End Sub";
return "";
}
public static String  _playsong() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "playsong", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "playsong", null));}
String _title = "";
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub playSong";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="mediaPlayer.Load(File.DirAssets, musicPlaylist.Ge";
mostCurrent._mediaplayer.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),BA.ObjectToString(mostCurrent._musicplaylist.Get(_currentsong)));
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="mediaPlayer.Play";
mostCurrent._mediaplayer.Play();
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="Dim title As String";
_title = "";
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="title = musicPlaylist.Get(currentSong)";
_title = BA.ObjectToString(mostCurrent._musicplaylist.Get(_currentsong));
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="songTitle.Text = title.SubString2(0, title.Length";
mostCurrent._songtitle.setText(BA.ObjectToCharSequence(_title.substring((int) (0),(int) (_title.length()-4))));
RDebugUtils.currentLine=196616;
 //BA.debugLineNum = 196616;BA.debugLine="SeekBar1.Max = mediaPlayer.Duration";
mostCurrent._seekbar1.setMax(mostCurrent._mediaplayer.getDuration());
RDebugUtils.currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="SeekBar1.Value = 0";
mostCurrent._seekbar1.setValue((int) (0));
RDebugUtils.currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="End Sub";
return "";
}
public static String  _formatsongdur(int _ms) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "formatsongdur", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "formatsongdur", new Object[] {_ms}));}
int _seconds = 0;
int _minutes = 0;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub formatSongDur(ms As Int) As String";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Dim seconds As Int = ms / 1000";
_seconds = (int) (_ms/(double)1000);
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Dim minutes As Int = seconds / 60";
_minutes = (int) (_seconds/(double)60);
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="seconds = seconds Mod 60";
_seconds = (int) (_seconds%60);
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="Return NumberFormat(minutes, 2, 0) & \":\" & Number";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_minutes,(int) (2),(int) (0))+":"+anywheresoftware.b4a.keywords.Common.NumberFormat(_seconds,(int) (2),(int) (0));
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="End Sub";
return "";
}
public static String  _listview1_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listview1_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "listview1_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="currentSong = Position";
_currentsong = _position;
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="End Sub";
return "";
}
public static String  _nextbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "nextbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "nextbtn_click", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub nextBtn_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="currentSong = currentSong + 1";
_currentsong = (int) (_currentsong+1);
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="If currentSong >= musicPlaylist.Size Then";
if (_currentsong>=mostCurrent._musicplaylist.getSize()) { 
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="currentSong = 0";
_currentsong = (int) (0);
 };
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="End Sub";
return "";
}
public static String  _pausebtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pausebtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pausebtn_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub pauseBtn_Click";
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="If mediaPlayer.IsPlaying Then";
if (mostCurrent._mediaplayer.IsPlaying()) { 
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="mediaPlayer.Pause";
mostCurrent._mediaplayer.Pause();
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="pauseBtn.Text = \"▶\"";
mostCurrent._pausebtn.setText(BA.ObjectToCharSequence("▶"));
 }else {
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="mediaPlayer.Play";
mostCurrent._mediaplayer.Play();
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="pauseBtn.Text = \"❚❚\"";
mostCurrent._pausebtn.setText(BA.ObjectToCharSequence("❚❚"));
 };
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="End Sub";
return "";
}
public static String  _prevbtn_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "prevbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "prevbtn_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub prevBtn_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="currentSong = currentSong - 1";
_currentsong = (int) (_currentsong-1);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="If currentSong < 0 Then";
if (_currentsong<0) { 
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="currentSong = musicPlaylist.Size - 1";
_currentsong = (int) (mostCurrent._musicplaylist.getSize()-1);
 };
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="End Sub";
return "";
}
public static String  _seekbar1_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "seekbar1_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "seekbar1_valuechanged", new Object[] {_value,_userchanged}));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub SeekBar1_ValueChanged (Value As Int, UserChang";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="If UserChanged Then";
if (_userchanged) { 
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="mediaPlayer.Position = Value";
mostCurrent._mediaplayer.setPosition(_value);
 };
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="End Sub";
return "";
}
public static String  _songtimer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "songtimer_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "songtimer_tick", null));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub songTimer_Tick";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="If mediaPlayer.IsPlaying Then";
if (mostCurrent._mediaplayer.IsPlaying()) { 
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="SeekBar1.Value = mediaPlayer.Position";
mostCurrent._seekbar1.setValue(mostCurrent._mediaplayer.getPosition());
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="songRuntime.Text = formatSongDur(mediaPlayer.Pos";
mostCurrent._songruntime.setText(BA.ObjectToCharSequence(_formatsongdur(mostCurrent._mediaplayer.getPosition())+" / "+_formatsongdur(mostCurrent._mediaplayer.getDuration())));
 }else 
{RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Else If mediaPlayer.Position >= mediaPlayer.Durat";
if (mostCurrent._mediaplayer.getPosition()>=mostCurrent._mediaplayer.getDuration()) { 
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="nextBtn_Click";
_nextbtn_click();
 }}
;
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="End Sub";
return "";
}
}