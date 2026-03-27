package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class musicservice extends android.app.Service{
	public static class musicservice_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (musicservice) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, musicservice.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static musicservice mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return musicservice.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.example", "b4a.example.musicservice");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.musicservice", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (musicservice) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			if (ServiceHelper.StarterHelper.runWaitForLayouts() == false) {
                BA.LogInfo("stopping spontaneous created service");
                stopSelf();
            }
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (musicservice) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (musicservice) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }

	public void onTimeout(int startId) {
        BA.LogInfo("** Service (musicservice) Timeout **");
        anywheresoftware.b4a.objects.collections.Map params = new anywheresoftware.b4a.objects.collections.Map();
        params.Initialize();
        params.Put("StartId", startId);
        processBA.raiseEvent(null, "service_timeout", params);
            
    }
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (false) {
            BA.LogInfo("** Service (musicservice) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (musicservice) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.MediaPlayerWrapper _mediaplayer = null;
public static anywheresoftware.b4a.objects.collections.List _musicplaylist = null;
public static int _currentsong = 0;
public static anywheresoftware.b4a.objects.Timer _songtimer = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.editnote _editnote = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.todoactivity _todoactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public static String  _nextsong() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "nextsong", false))
	 {return ((String) Debug.delegate(processBA, "nextsong", null));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Sub nextSong";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="currentSong = currentSong + 1";
_currentsong = (int) (_currentsong+1);
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="If currentSong >= musicPlaylist.Size Then";
if (_currentsong>=_musicplaylist.getSize()) { 
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="currentSong = 0";
_currentsong = (int) (0);
 };
RDebugUtils.currentLine=8388613;
 //BA.debugLineNum = 8388613;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=8388614;
 //BA.debugLineNum = 8388614;BA.debugLine="End Sub";
return "";
}
public static String  _playsong() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "playsong", false))
	 {return ((String) Debug.delegate(processBA, "playsong", null));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Sub playSong";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="If mediaPlayer.IsInitialized Then";
if (_mediaplayer.IsInitialized()) { 
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="mediaPlayer.Stop";
_mediaplayer.Stop();
 };
RDebugUtils.currentLine=8257540;
 //BA.debugLineNum = 8257540;BA.debugLine="mediaPlayer.Load(File.DirAssets, musicPlaylist.Ge";
_mediaplayer.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),BA.ObjectToString(_musicplaylist.Get(_currentsong)));
RDebugUtils.currentLine=8257541;
 //BA.debugLineNum = 8257541;BA.debugLine="mediaPlayer.Play";
_mediaplayer.Play();
RDebugUtils.currentLine=8257542;
 //BA.debugLineNum = 8257542;BA.debugLine="End Sub";
return "";
}
public static String  _pausetoggle() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "pausetoggle", false))
	 {return ((String) Debug.delegate(processBA, "pausetoggle", null));}
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Sub pauseToggle";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="If mediaPlayer.IsPlaying Then";
if (_mediaplayer.IsPlaying()) { 
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="mediaPlayer.Pause";
_mediaplayer.Pause();
 }else {
RDebugUtils.currentLine=8519684;
 //BA.debugLineNum = 8519684;BA.debugLine="mediaPlayer.Play";
_mediaplayer.Play();
 };
RDebugUtils.currentLine=8519686;
 //BA.debugLineNum = 8519686;BA.debugLine="End Sub";
return "";
}
public static String  _prevsong() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "prevsong", false))
	 {return ((String) Debug.delegate(processBA, "prevsong", null));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Sub prevSong";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="currentSong = currentSong - 1";
_currentsong = (int) (_currentsong-1);
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="If currentSong < 0 Then";
if (_currentsong<0) { 
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="currentSong = musicPlaylist.Size - 1";
_currentsong = (int) (_musicplaylist.getSize()-1);
 };
RDebugUtils.currentLine=8454149;
 //BA.debugLineNum = 8454149;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=8454150;
 //BA.debugLineNum = 8454150;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="mediaPlayer.Initialize";
_mediaplayer.Initialize();
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="musicPlaylist.Initialize";
_musicplaylist.Initialize();
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="musicPlaylist.Add(\"tracks/intro.mp3\")";
_musicplaylist.Add((Object)("tracks/intro.mp3"));
RDebugUtils.currentLine=8060933;
 //BA.debugLineNum = 8060933;BA.debugLine="musicPlaylist.Add(\"tracks/taiyaki.mp3\")";
_musicplaylist.Add((Object)("tracks/taiyaki.mp3"));
RDebugUtils.currentLine=8060934;
 //BA.debugLineNum = 8060934;BA.debugLine="musicPlaylist.Add(\"tracks/feel special.mp3\")";
_musicplaylist.Add((Object)("tracks/feel special.mp3"));
RDebugUtils.currentLine=8060935;
 //BA.debugLineNum = 8060935;BA.debugLine="musicPlaylist.Add(\"tracks/union.mp3\")";
_musicplaylist.Add((Object)("tracks/union.mp3"));
RDebugUtils.currentLine=8060936;
 //BA.debugLineNum = 8060936;BA.debugLine="musicPlaylist.Add(\"tracks/two in the morning.mp3\"";
_musicplaylist.Add((Object)("tracks/two in the morning.mp3"));
RDebugUtils.currentLine=8060937;
 //BA.debugLineNum = 8060937;BA.debugLine="musicPlaylist.Add(\"tracks/happily ever after.mp3\"";
_musicplaylist.Add((Object)("tracks/happily ever after.mp3"));
RDebugUtils.currentLine=8060938;
 //BA.debugLineNum = 8060938;BA.debugLine="musicPlaylist.Add(\"tracks/cookie.mp3\")";
_musicplaylist.Add((Object)("tracks/cookie.mp3"));
RDebugUtils.currentLine=8060939;
 //BA.debugLineNum = 8060939;BA.debugLine="musicPlaylist.Add(\"tracks/comfy vibes.mp3\")";
_musicplaylist.Add((Object)("tracks/comfy vibes.mp3"));
RDebugUtils.currentLine=8060940;
 //BA.debugLineNum = 8060940;BA.debugLine="musicPlaylist.Add(\"tracks/dango.mp3\")";
_musicplaylist.Add((Object)("tracks/dango.mp3"));
RDebugUtils.currentLine=8060941;
 //BA.debugLineNum = 8060941;BA.debugLine="musicPlaylist.Add(\"tracks/iced caramel macchiato.";
_musicplaylist.Add((Object)("tracks/iced caramel macchiato.mp3"));
RDebugUtils.currentLine=8060942;
 //BA.debugLineNum = 8060942;BA.debugLine="musicPlaylist.Add(\"tracks/in dreamland.mp3\")";
_musicplaylist.Add((Object)("tracks/in dreamland.mp3"));
RDebugUtils.currentLine=8060943;
 //BA.debugLineNum = 8060943;BA.debugLine="musicPlaylist.Add(\"tracks/space aquarium.mp3\")";
_musicplaylist.Add((Object)("tracks/space aquarium.mp3"));
RDebugUtils.currentLine=8060944;
 //BA.debugLineNum = 8060944;BA.debugLine="musicPlaylist.Add(\"tracks/sunshine & butterflies.";
_musicplaylist.Add((Object)("tracks/sunshine & butterflies.mp3"));
RDebugUtils.currentLine=8060945;
 //BA.debugLineNum = 8060945;BA.debugLine="musicPlaylist.Add(\"tracks/soda pop.mp3\")";
_musicplaylist.Add((Object)("tracks/soda pop.mp3"));
RDebugUtils.currentLine=8060946;
 //BA.debugLineNum = 8060946;BA.debugLine="musicPlaylist.Add(\"tracks/matcha latte.mp3\")";
_musicplaylist.Add((Object)("tracks/matcha latte.mp3"));
RDebugUtils.currentLine=8060947;
 //BA.debugLineNum = 8060947;BA.debugLine="musicPlaylist.Add(\"tracks/midnight.mp3\")";
_musicplaylist.Add((Object)("tracks/midnight.mp3"));
RDebugUtils.currentLine=8060948;
 //BA.debugLineNum = 8060948;BA.debugLine="musicPlaylist.Add(\"tracks/rose water.mp3\")";
_musicplaylist.Add((Object)("tracks/rose water.mp3"));
RDebugUtils.currentLine=8060949;
 //BA.debugLineNum = 8060949;BA.debugLine="musicPlaylist.Add(\"tracks/hot.mp3\")";
_musicplaylist.Add((Object)("tracks/hot.mp3"));
RDebugUtils.currentLine=8060950;
 //BA.debugLineNum = 8060950;BA.debugLine="musicPlaylist.Add(\"tracks/on the top.mp3\")";
_musicplaylist.Add((Object)("tracks/on the top.mp3"));
RDebugUtils.currentLine=8060952;
 //BA.debugLineNum = 8060952;BA.debugLine="currentSong = 0";
_currentsong = (int) (0);
RDebugUtils.currentLine=8060953;
 //BA.debugLineNum = 8060953;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=8060955;
 //BA.debugLineNum = 8060955;BA.debugLine="songTimer.Initialize(\"songTimer\", 500)";
_songtimer.Initialize(processBA,"songTimer",(long) (500));
RDebugUtils.currentLine=8060956;
 //BA.debugLineNum = 8060956;BA.debugLine="songTimer.Enabled = True";
_songtimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8060957;
 //BA.debugLineNum = 8060957;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Service.StopAutomaticForeground 'Call this when t";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="End Sub";
return "";
}
public static String  _setsong(int _index) throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "setsong", false))
	 {return ((String) Debug.delegate(processBA, "setsong", new Object[] {_index}));}
RDebugUtils.currentLine=10944512;
 //BA.debugLineNum = 10944512;BA.debugLine="Sub setSong(index As Int)";
RDebugUtils.currentLine=10944513;
 //BA.debugLineNum = 10944513;BA.debugLine="currentSong = index";
_currentsong = _index;
RDebugUtils.currentLine=10944514;
 //BA.debugLineNum = 10944514;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=10944515;
 //BA.debugLineNum = 10944515;BA.debugLine="End Sub";
return "";
}
public static String  _songtimer_tick() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "songtimer_tick", false))
	 {return ((String) Debug.delegate(processBA, "songtimer_tick", null));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Sub songTimer_Tick";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="If mediaPlayer.IsPlaying = False Then";
if (_mediaplayer.IsPlaying()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="nextSong";
_nextsong();
 };
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="End Sub";
return "";
}
}