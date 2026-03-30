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
public b4a.example.themeactivity _themeactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.schedule_module _schedule_module = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.card_module _card_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.todoactivity _todoactivity = null;
public static String  _copytracksifneeded() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "copytracksifneeded", false))
	 {return ((String) Debug.delegate(processBA, "copytracksifneeded", null));}
int _i = 0;
String _trackname = "";
String _filename = "";
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Sub CopyTracksIfNeeded";
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="If File.Exists(File.DirInternal, \"tracks\") = Fals";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"tracks")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="File.MakeDir(File.DirInternal, \"tracks\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"tracks");
 };
RDebugUtils.currentLine=8060935;
 //BA.debugLineNum = 8060935;BA.debugLine="For i = 0 To musicPlaylist.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_musicplaylist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=8060936;
 //BA.debugLineNum = 8060936;BA.debugLine="Dim trackName As String = musicPlaylist.Get(i)";
_trackname = BA.ObjectToString(_musicplaylist.Get(_i));
RDebugUtils.currentLine=8060937;
 //BA.debugLineNum = 8060937;BA.debugLine="Dim fileName As String = trackName.SubString(tra";
_filename = _trackname.substring((int) (_trackname.lastIndexOf("/")+1));
RDebugUtils.currentLine=8060938;
 //BA.debugLineNum = 8060938;BA.debugLine="If File.Exists(File.DirInternal & \"/tracks\", fil";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal()+"/tracks",_filename)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=8060939;
 //BA.debugLineNum = 8060939;BA.debugLine="File.Copy(File.DirAssets, trackName, File.DirIn";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_trackname,anywheresoftware.b4a.keywords.Common.File.getDirInternal()+"/tracks",_filename);
 };
 }
};
RDebugUtils.currentLine=8060942;
 //BA.debugLineNum = 8060942;BA.debugLine="End Sub";
return "";
}
public static String  _nextsong() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "nextsong", false))
	 {return ((String) Debug.delegate(processBA, "nextsong", null));}
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Sub nextSong";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="currentSong = currentSong + 1";
_currentsong = (int) (_currentsong+1);
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="If currentSong >= musicPlaylist.Size Then";
if (_currentsong>=_musicplaylist.getSize()) { 
RDebugUtils.currentLine=8519683;
 //BA.debugLineNum = 8519683;BA.debugLine="currentSong = 0";
_currentsong = (int) (0);
 };
RDebugUtils.currentLine=8519685;
 //BA.debugLineNum = 8519685;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=8519686;
 //BA.debugLineNum = 8519686;BA.debugLine="End Sub";
return "";
}
public static String  _playsong() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "playsong", false))
	 {return ((String) Debug.delegate(processBA, "playsong", null));}
String _trackname = "";
String _filename = "";
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Sub playSong";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="If mediaPlayer.IsInitialized Then";
if (_mediaplayer.IsInitialized()) { 
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="mediaPlayer.Stop";
_mediaplayer.Stop();
 };
RDebugUtils.currentLine=8388612;
 //BA.debugLineNum = 8388612;BA.debugLine="Dim trackName As String = musicPlaylist.Get(curre";
_trackname = BA.ObjectToString(_musicplaylist.Get(_currentsong));
RDebugUtils.currentLine=8388613;
 //BA.debugLineNum = 8388613;BA.debugLine="Dim fileName As String = trackName.SubString(trac";
_filename = _trackname.substring((int) (_trackname.lastIndexOf("/")+1));
RDebugUtils.currentLine=8388615;
 //BA.debugLineNum = 8388615;BA.debugLine="mediaPlayer.Load(File.DirInternal & \"/tracks\", fi";
_mediaplayer.Load(anywheresoftware.b4a.keywords.Common.File.getDirInternal()+"/tracks",_filename);
RDebugUtils.currentLine=8388616;
 //BA.debugLineNum = 8388616;BA.debugLine="mediaPlayer.Play";
_mediaplayer.Play();
RDebugUtils.currentLine=8388617;
 //BA.debugLineNum = 8388617;BA.debugLine="End Sub";
return "";
}
public static String  _pausemusic() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "pausemusic", false))
	 {return ((String) Debug.delegate(processBA, "pausemusic", null));}
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Sub pauseMusic";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="If mediaPlayer.IsPlaying Then";
if (_mediaplayer.IsPlaying()) { 
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="mediaPlayer.Pause";
_mediaplayer.Pause();
 };
RDebugUtils.currentLine=8650756;
 //BA.debugLineNum = 8650756;BA.debugLine="End Sub";
return "";
}
public static String  _pausetoggle() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "pausetoggle", false))
	 {return ((String) Debug.delegate(processBA, "pausetoggle", null));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Sub pauseToggle";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="If mediaPlayer.IsPlaying Then";
if (_mediaplayer.IsPlaying()) { 
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="mediaPlayer.Pause";
_mediaplayer.Pause();
 }else {
RDebugUtils.currentLine=8257540;
 //BA.debugLineNum = 8257540;BA.debugLine="mediaPlayer.Play";
_mediaplayer.Play();
 };
RDebugUtils.currentLine=8257542;
 //BA.debugLineNum = 8257542;BA.debugLine="End Sub";
return "";
}
public static String  _prevsong() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "prevsong", false))
	 {return ((String) Debug.delegate(processBA, "prevsong", null));}
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Sub prevSong";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="currentSong = currentSong - 1";
_currentsong = (int) (_currentsong-1);
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="If currentSong < 0 Then";
if (_currentsong<0) { 
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="currentSong = musicPlaylist.Size - 1";
_currentsong = (int) (_musicplaylist.getSize()-1);
 };
RDebugUtils.currentLine=8585221;
 //BA.debugLineNum = 8585221;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=8585222;
 //BA.debugLineNum = 8585222;BA.debugLine="End Sub";
return "";
}
public static String  _resumemusic() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "resumemusic", false))
	 {return ((String) Debug.delegate(processBA, "resumemusic", null));}
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Sub resumeMusic";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="If mediaPlayer.IsInitialized Then";
if (_mediaplayer.IsInitialized()) { 
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="mediaPlayer.Play";
_mediaplayer.Play();
 };
RDebugUtils.currentLine=8716292;
 //BA.debugLineNum = 8716292;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="mediaPlayer.Initialize";
_mediaplayer.Initialize();
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="musicPlaylist.Initialize";
_musicplaylist.Initialize();
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="musicPlaylist.Add(\"tracks/intro.mp3\")";
_musicplaylist.Add((Object)("tracks/intro.mp3"));
RDebugUtils.currentLine=7995397;
 //BA.debugLineNum = 7995397;BA.debugLine="musicPlaylist.Add(\"tracks/taiyaki.mp3\")";
_musicplaylist.Add((Object)("tracks/taiyaki.mp3"));
RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="musicPlaylist.Add(\"tracks/feel special.mp3\")";
_musicplaylist.Add((Object)("tracks/feel special.mp3"));
RDebugUtils.currentLine=7995399;
 //BA.debugLineNum = 7995399;BA.debugLine="musicPlaylist.Add(\"tracks/union.mp3\")";
_musicplaylist.Add((Object)("tracks/union.mp3"));
RDebugUtils.currentLine=7995400;
 //BA.debugLineNum = 7995400;BA.debugLine="musicPlaylist.Add(\"tracks/two in the morning.mp3\"";
_musicplaylist.Add((Object)("tracks/two in the morning.mp3"));
RDebugUtils.currentLine=7995401;
 //BA.debugLineNum = 7995401;BA.debugLine="musicPlaylist.Add(\"tracks/happily ever after.mp3\"";
_musicplaylist.Add((Object)("tracks/happily ever after.mp3"));
RDebugUtils.currentLine=7995402;
 //BA.debugLineNum = 7995402;BA.debugLine="musicPlaylist.Add(\"tracks/cookie.mp3\")";
_musicplaylist.Add((Object)("tracks/cookie.mp3"));
RDebugUtils.currentLine=7995403;
 //BA.debugLineNum = 7995403;BA.debugLine="musicPlaylist.Add(\"tracks/comfy vibes.mp3\")";
_musicplaylist.Add((Object)("tracks/comfy vibes.mp3"));
RDebugUtils.currentLine=7995404;
 //BA.debugLineNum = 7995404;BA.debugLine="musicPlaylist.Add(\"tracks/dango.mp3\")";
_musicplaylist.Add((Object)("tracks/dango.mp3"));
RDebugUtils.currentLine=7995405;
 //BA.debugLineNum = 7995405;BA.debugLine="musicPlaylist.Add(\"tracks/iced caramel macchiato.";
_musicplaylist.Add((Object)("tracks/iced caramel macchiato.mp3"));
RDebugUtils.currentLine=7995406;
 //BA.debugLineNum = 7995406;BA.debugLine="musicPlaylist.Add(\"tracks/in dreamland.mp3\")";
_musicplaylist.Add((Object)("tracks/in dreamland.mp3"));
RDebugUtils.currentLine=7995407;
 //BA.debugLineNum = 7995407;BA.debugLine="musicPlaylist.Add(\"tracks/space aquarium.mp3\")";
_musicplaylist.Add((Object)("tracks/space aquarium.mp3"));
RDebugUtils.currentLine=7995408;
 //BA.debugLineNum = 7995408;BA.debugLine="musicPlaylist.Add(\"tracks/sunshine & butterflies.";
_musicplaylist.Add((Object)("tracks/sunshine & butterflies.mp3"));
RDebugUtils.currentLine=7995409;
 //BA.debugLineNum = 7995409;BA.debugLine="musicPlaylist.Add(\"tracks/soda pop.mp3\")";
_musicplaylist.Add((Object)("tracks/soda pop.mp3"));
RDebugUtils.currentLine=7995410;
 //BA.debugLineNum = 7995410;BA.debugLine="musicPlaylist.Add(\"tracks/matcha latte.mp3\")";
_musicplaylist.Add((Object)("tracks/matcha latte.mp3"));
RDebugUtils.currentLine=7995411;
 //BA.debugLineNum = 7995411;BA.debugLine="musicPlaylist.Add(\"tracks/midnight.mp3\")";
_musicplaylist.Add((Object)("tracks/midnight.mp3"));
RDebugUtils.currentLine=7995412;
 //BA.debugLineNum = 7995412;BA.debugLine="musicPlaylist.Add(\"tracks/rose water.mp3\")";
_musicplaylist.Add((Object)("tracks/rose water.mp3"));
RDebugUtils.currentLine=7995413;
 //BA.debugLineNum = 7995413;BA.debugLine="musicPlaylist.Add(\"tracks/hot.mp3\")";
_musicplaylist.Add((Object)("tracks/hot.mp3"));
RDebugUtils.currentLine=7995414;
 //BA.debugLineNum = 7995414;BA.debugLine="musicPlaylist.Add(\"tracks/on the top.mp3\")";
_musicplaylist.Add((Object)("tracks/on the top.mp3"));
RDebugUtils.currentLine=7995417;
 //BA.debugLineNum = 7995417;BA.debugLine="CopyTracksIfNeeded";
_copytracksifneeded();
RDebugUtils.currentLine=7995419;
 //BA.debugLineNum = 7995419;BA.debugLine="currentSong = 0";
_currentsong = (int) (0);
RDebugUtils.currentLine=7995420;
 //BA.debugLineNum = 7995420;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=7995422;
 //BA.debugLineNum = 7995422;BA.debugLine="songTimer.Initialize(\"songTimer\", 500)";
_songtimer.Initialize(processBA,"songTimer",(long) (500));
RDebugUtils.currentLine=7995423;
 //BA.debugLineNum = 7995423;BA.debugLine="songTimer.Enabled = True";
_songtimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7995424;
 //BA.debugLineNum = 7995424;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Sub setSong(index As Int)";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="currentSong = index";
_currentsong = _index;
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="playSong";
_playsong();
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="End Sub";
return "";
}
public static String  _songtimer_tick() throws Exception{
RDebugUtils.currentModule="musicservice";
if (Debug.shouldDelegate(processBA, "songtimer_tick", false))
	 {return ((String) Debug.delegate(processBA, "songtimer_tick", null));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Sub songTimer_Tick";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="If mediaPlayer.IsInitialized Then";
if (_mediaplayer.IsInitialized()) { 
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="If mediaPlayer.IsPlaying = False And mediaPlayer";
if (_mediaplayer.IsPlaying()==anywheresoftware.b4a.keywords.Common.False && _mediaplayer.getDuration()>0) { 
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="If mediaPlayer.Position >= mediaPlayer.Duration";
if (_mediaplayer.getPosition()>=_mediaplayer.getDuration()-100) { 
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="nextSong";
_nextsong();
 };
 };
 };
RDebugUtils.currentLine=8454152;
 //BA.debugLineNum = 8454152;BA.debugLine="End Sub";
return "";
}
}