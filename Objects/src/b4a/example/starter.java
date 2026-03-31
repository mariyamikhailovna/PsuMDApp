package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.example", "b4a.example.starter");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
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
                    BA.LogInfo("** Service (starter) Create **");
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
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
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
        BA.LogInfo("** Service (starter) Timeout **");
        anywheresoftware.b4a.objects.collections.Map params = new anywheresoftware.b4a.objects.collections.Map();
        params.Initialize();
        params.Put("StartId", startId);
        processBA.raiseEvent(null, "service_timeout", params);
            
    }
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
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
public static boolean _darkmode = false;
public static int _themenumber = 0;
public static b4a.example3.keyvaluestore _noteskvs = null;
public static b4a.example3.keyvaluestore _prefkvs = null;
public static b4a.example3.keyvaluestore _calkvs = null;
public static anywheresoftware.b4a.objects.collections.Map _calendarmap = null;
public static b4a.example3.keyvaluestore _deckkvs = null;
public static b4a.example3.keyvaluestore _taskkvs = null;
public static anywheresoftware.b4a.objects.collections.Map _deck = null;
public static boolean _finishedinit = false;
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
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.todoactivity _todoactivity = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "application_error", false))
	 {return ((Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace}));}
RDebugUtils.currentLine=23330816;
 //BA.debugLineNum = 23330816;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=23330817;
 //BA.debugLineNum = 23330817;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=23330818;
 //BA.debugLineNum = 23330818;BA.debugLine="End Sub";
return false;
}
public static String  _copytracksifneeded() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "copytracksifneeded", false))
	 {return ((String) Debug.delegate(processBA, "copytracksifneeded", null));}
anywheresoftware.b4a.objects.collections.List _playlist = null;
int _i = 0;
String _trackname = "";
String _filename = "";
RDebugUtils.currentLine=26411008;
 //BA.debugLineNum = 26411008;BA.debugLine="Sub CopyTracksIfNeeded";
RDebugUtils.currentLine=26411009;
 //BA.debugLineNum = 26411009;BA.debugLine="Dim playlist As List";
_playlist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=26411010;
 //BA.debugLineNum = 26411010;BA.debugLine="playlist.Initialize";
_playlist.Initialize();
RDebugUtils.currentLine=26411011;
 //BA.debugLineNum = 26411011;BA.debugLine="playlist.Add(\"tracks/intro.mp3\")";
_playlist.Add((Object)("tracks/intro.mp3"));
RDebugUtils.currentLine=26411012;
 //BA.debugLineNum = 26411012;BA.debugLine="playlist.Add(\"tracks/taiyaki.mp3\")";
_playlist.Add((Object)("tracks/taiyaki.mp3"));
RDebugUtils.currentLine=26411013;
 //BA.debugLineNum = 26411013;BA.debugLine="playlist.Add(\"tracks/feel special.mp3\")";
_playlist.Add((Object)("tracks/feel special.mp3"));
RDebugUtils.currentLine=26411014;
 //BA.debugLineNum = 26411014;BA.debugLine="playlist.Add(\"tracks/union.mp3\")";
_playlist.Add((Object)("tracks/union.mp3"));
RDebugUtils.currentLine=26411015;
 //BA.debugLineNum = 26411015;BA.debugLine="playlist.Add(\"tracks/two in the morning.mp3\")";
_playlist.Add((Object)("tracks/two in the morning.mp3"));
RDebugUtils.currentLine=26411016;
 //BA.debugLineNum = 26411016;BA.debugLine="playlist.Add(\"tracks/happily ever after.mp3\")";
_playlist.Add((Object)("tracks/happily ever after.mp3"));
RDebugUtils.currentLine=26411017;
 //BA.debugLineNum = 26411017;BA.debugLine="playlist.Add(\"tracks/cookie.mp3\")";
_playlist.Add((Object)("tracks/cookie.mp3"));
RDebugUtils.currentLine=26411018;
 //BA.debugLineNum = 26411018;BA.debugLine="playlist.Add(\"tracks/comfy vibes.mp3\")";
_playlist.Add((Object)("tracks/comfy vibes.mp3"));
RDebugUtils.currentLine=26411019;
 //BA.debugLineNum = 26411019;BA.debugLine="playlist.Add(\"tracks/dango.mp3\")";
_playlist.Add((Object)("tracks/dango.mp3"));
RDebugUtils.currentLine=26411020;
 //BA.debugLineNum = 26411020;BA.debugLine="playlist.Add(\"tracks/iced caramel macchiato.mp3\")";
_playlist.Add((Object)("tracks/iced caramel macchiato.mp3"));
RDebugUtils.currentLine=26411021;
 //BA.debugLineNum = 26411021;BA.debugLine="playlist.Add(\"tracks/in dreamland.mp3\")";
_playlist.Add((Object)("tracks/in dreamland.mp3"));
RDebugUtils.currentLine=26411022;
 //BA.debugLineNum = 26411022;BA.debugLine="playlist.Add(\"tracks/space aquarium.mp3\")";
_playlist.Add((Object)("tracks/space aquarium.mp3"));
RDebugUtils.currentLine=26411023;
 //BA.debugLineNum = 26411023;BA.debugLine="playlist.Add(\"tracks/sunshine & butterflies.mp3\")";
_playlist.Add((Object)("tracks/sunshine & butterflies.mp3"));
RDebugUtils.currentLine=26411024;
 //BA.debugLineNum = 26411024;BA.debugLine="playlist.Add(\"tracks/soda pop.mp3\")";
_playlist.Add((Object)("tracks/soda pop.mp3"));
RDebugUtils.currentLine=26411025;
 //BA.debugLineNum = 26411025;BA.debugLine="playlist.Add(\"tracks/matcha latte.mp3\")";
_playlist.Add((Object)("tracks/matcha latte.mp3"));
RDebugUtils.currentLine=26411026;
 //BA.debugLineNum = 26411026;BA.debugLine="playlist.Add(\"tracks/midnight.mp3\")";
_playlist.Add((Object)("tracks/midnight.mp3"));
RDebugUtils.currentLine=26411027;
 //BA.debugLineNum = 26411027;BA.debugLine="playlist.Add(\"tracks/rose water.mp3\")";
_playlist.Add((Object)("tracks/rose water.mp3"));
RDebugUtils.currentLine=26411028;
 //BA.debugLineNum = 26411028;BA.debugLine="playlist.Add(\"tracks/hot.mp3\")";
_playlist.Add((Object)("tracks/hot.mp3"));
RDebugUtils.currentLine=26411029;
 //BA.debugLineNum = 26411029;BA.debugLine="playlist.Add(\"tracks/on the top.mp3\")";
_playlist.Add((Object)("tracks/on the top.mp3"));
RDebugUtils.currentLine=26411031;
 //BA.debugLineNum = 26411031;BA.debugLine="If File.Exists(File.DirInternal, \"tracks\") = Fals";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"tracks")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=26411032;
 //BA.debugLineNum = 26411032;BA.debugLine="File.MakeDir(File.DirInternal, \"tracks\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"tracks");
 };
RDebugUtils.currentLine=26411034;
 //BA.debugLineNum = 26411034;BA.debugLine="For i = 0 To playlist.Size - 1";
{
final int step25 = 1;
final int limit25 = (int) (_playlist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit25 ;_i = _i + step25 ) {
RDebugUtils.currentLine=26411035;
 //BA.debugLineNum = 26411035;BA.debugLine="Dim trackName As String = playlist.Get(i)";
_trackname = BA.ObjectToString(_playlist.Get(_i));
RDebugUtils.currentLine=26411036;
 //BA.debugLineNum = 26411036;BA.debugLine="Dim fileName As String = trackName.SubString(tra";
_filename = _trackname.substring((int) (_trackname.lastIndexOf("/")+1));
RDebugUtils.currentLine=26411037;
 //BA.debugLineNum = 26411037;BA.debugLine="If File.Exists(File.DirInternal & \"/tracks\", fil";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal()+"/tracks",_filename)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=26411038;
 //BA.debugLineNum = 26411038;BA.debugLine="File.Copy(File.DirAssets, trackName, File.DirIn";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_trackname,anywheresoftware.b4a.keywords.Common.File.getDirInternal()+"/tracks",_filename);
 };
 }
};
RDebugUtils.currentLine=26411041;
 //BA.debugLineNum = 26411041;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=23134208;
 //BA.debugLineNum = 23134208;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=23134209;
 //BA.debugLineNum = 23134209;BA.debugLine="prefKvs.Initialize(File.DirInternal, \"prefData\")";
_prefkvs._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"prefData");
RDebugUtils.currentLine=23134211;
 //BA.debugLineNum = 23134211;BA.debugLine="If prefKvs.ContainsKey(\"darkMode\") Then";
if (_prefkvs._containskey("darkMode")) { 
RDebugUtils.currentLine=23134212;
 //BA.debugLineNum = 23134212;BA.debugLine="darkMode = prefKvs.Get(\"darkMode\")";
_darkmode = BA.ObjectToBoolean(_prefkvs._get("darkMode"));
 };
RDebugUtils.currentLine=23134215;
 //BA.debugLineNum = 23134215;BA.debugLine="If prefKvs.ContainsKey(\"themeNumber\") Then";
if (_prefkvs._containskey("themeNumber")) { 
RDebugUtils.currentLine=23134216;
 //BA.debugLineNum = 23134216;BA.debugLine="themeNumber = prefKvs.Get(\"themeNumber\")";
_themenumber = (int)(BA.ObjectToNumber(_prefkvs._get("themeNumber")));
 };
RDebugUtils.currentLine=23134219;
 //BA.debugLineNum = 23134219;BA.debugLine="calKvs.Initialize(File.DirInternal, \"mydata\")";
_calkvs._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"mydata");
RDebugUtils.currentLine=23134220;
 //BA.debugLineNum = 23134220;BA.debugLine="If calKvs.ContainsKey(\"CalendarKVS\") Then";
if (_calkvs._containskey("CalendarKVS")) { 
RDebugUtils.currentLine=23134221;
 //BA.debugLineNum = 23134221;BA.debugLine="calendarMap = calKvs.Get(\"CalendarKVS\")";
_calendarmap = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_calkvs._get("CalendarKVS")));
 }else {
RDebugUtils.currentLine=23134223;
 //BA.debugLineNum = 23134223;BA.debugLine="calendarMap.Initialize";
_calendarmap.Initialize();
 };
RDebugUtils.currentLine=23134226;
 //BA.debugLineNum = 23134226;BA.debugLine="deckKvs.Initialize(File.DirInternal, \"mydata\")";
_deckkvs._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"mydata");
RDebugUtils.currentLine=23134227;
 //BA.debugLineNum = 23134227;BA.debugLine="If deckKvs.ContainsKey(\"deck_data\") Then";
if (_deckkvs._containskey("deck_data")) { 
RDebugUtils.currentLine=23134228;
 //BA.debugLineNum = 23134228;BA.debugLine="deck = deckKvs.Get(\"deck_data\")";
_deck = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_deckkvs._get("deck_data")));
 }else {
RDebugUtils.currentLine=23134230;
 //BA.debugLineNum = 23134230;BA.debugLine="deck.Initialize";
_deck.Initialize();
 };
RDebugUtils.currentLine=23134233;
 //BA.debugLineNum = 23134233;BA.debugLine="taskKvs.Initialize(File.DirInternal, \"todoListDat";
_taskkvs._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"todoListData");
RDebugUtils.currentLine=23134234;
 //BA.debugLineNum = 23134234;BA.debugLine="notesKvs.Initialize(File.DirInternal, \"notes_data";
_noteskvs._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"notes_data");
RDebugUtils.currentLine=23134236;
 //BA.debugLineNum = 23134236;BA.debugLine="CopyTracksIfNeeded";
_copytracksifneeded();
RDebugUtils.currentLine=23134238;
 //BA.debugLineNum = 23134238;BA.debugLine="finishedInit = True";
_finishedinit = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=23134239;
 //BA.debugLineNum = 23134239;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=23396352;
 //BA.debugLineNum = 23396352;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=23396354;
 //BA.debugLineNum = 23396354;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
RDebugUtils.currentLine=23199744;
 //BA.debugLineNum = 23199744;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=23199745;
 //BA.debugLineNum = 23199745;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=23199746;
 //BA.debugLineNum = 23199746;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_taskremoved", false))
	 {return ((String) Debug.delegate(processBA, "service_taskremoved", null));}
RDebugUtils.currentLine=23265280;
 //BA.debugLineNum = 23265280;BA.debugLine="Sub Service_TaskRemoved";
RDebugUtils.currentLine=23265282;
 //BA.debugLineNum = 23265282;BA.debugLine="End Sub";
return "";
}
}