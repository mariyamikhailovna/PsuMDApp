package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class musicservice_subs_0 {


public static RemoteObject  _copytracksifneeded() throws Exception{
try {
		Debug.PushSubsStack("CopyTracksIfNeeded (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,47);
if (RapidSub.canDelegate("copytracksifneeded")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","copytracksifneeded");}
int _i = 0;
RemoteObject _trackname = RemoteObject.createImmutable("");
RemoteObject _filename = RemoteObject.createImmutable("");
 BA.debugLineNum = 47;BA.debugLine="Sub CopyTracksIfNeeded";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="If File.Exists(File.DirInternal, \"tracks\") = Fals";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",musicservice.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(musicservice.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("tracks"))),musicservice.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 50;BA.debugLine="File.MakeDir(File.DirInternal, \"tracks\")";
Debug.ShouldStop(131072);
musicservice.mostCurrent.__c.getField(false,"File").runVoidMethod ("MakeDir",(Object)(musicservice.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("tracks")));
 };
 BA.debugLineNum = 54;BA.debugLine="For i = 0 To musicPlaylist.Size - 1";
Debug.ShouldStop(2097152);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {musicservice._musicplaylist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 55;BA.debugLine="Dim trackName As String = musicPlaylist.Get(i)";
Debug.ShouldStop(4194304);
_trackname = BA.ObjectToString(musicservice._musicplaylist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("trackName", _trackname);Debug.locals.put("trackName", _trackname);
 BA.debugLineNum = 56;BA.debugLine="Dim fileName As String = trackName.SubString(tra";
Debug.ShouldStop(8388608);
_filename = _trackname.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_trackname.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("/"))),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("fileName", _filename);Debug.locals.put("fileName", _filename);
 BA.debugLineNum = 57;BA.debugLine="If File.Exists(File.DirInternal & \"/tracks\", fil";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",musicservice.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(RemoteObject.concat(musicservice.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"),RemoteObject.createImmutable("/tracks"))),(Object)(_filename)),musicservice.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 58;BA.debugLine="File.Copy(File.DirAssets, trackName, File.DirIn";
Debug.ShouldStop(33554432);
musicservice.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(musicservice.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_trackname),(Object)(RemoteObject.concat(musicservice.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"),RemoteObject.createImmutable("/tracks"))),(Object)(_filename));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _nextsong() throws Exception{
try {
		Debug.PushSubsStack("nextSong (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,104);
if (RapidSub.canDelegate("nextsong")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","nextsong");}
 BA.debugLineNum = 104;BA.debugLine="Sub nextSong";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="currentSong = currentSong + 1";
Debug.ShouldStop(256);
musicservice._currentsong = RemoteObject.solve(new RemoteObject[] {musicservice._currentsong,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 106;BA.debugLine="If currentSong >= musicPlaylist.Size Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("g",musicservice._currentsong,BA.numberCast(double.class, musicservice._musicplaylist.runMethod(true,"getSize")))) { 
 BA.debugLineNum = 107;BA.debugLine="currentSong = 0";
Debug.ShouldStop(1024);
musicservice._currentsong = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 109;BA.debugLine="playSong";
Debug.ShouldStop(4096);
_playsong();
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pausetoggle() throws Exception{
try {
		Debug.PushSubsStack("pauseToggle (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,71);
if (RapidSub.canDelegate("pausetoggle")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","pausetoggle");}
 BA.debugLineNum = 71;BA.debugLine="Sub pauseToggle";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="If mediaPlayer.IsPlaying Then";
Debug.ShouldStop(128);
if (musicservice._mediaplayer.runMethod(true,"IsPlaying").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 73;BA.debugLine="mediaPlayer.Pause";
Debug.ShouldStop(256);
musicservice._mediaplayer.runVoidMethod ("Pause");
 }else {
 BA.debugLineNum = 75;BA.debugLine="mediaPlayer.Play";
Debug.ShouldStop(1024);
musicservice._mediaplayer.runVoidMethod ("Play");
 };
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _playsong() throws Exception{
try {
		Debug.PushSubsStack("playSong (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,84);
if (RapidSub.canDelegate("playsong")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","playsong");}
RemoteObject _trackname = RemoteObject.createImmutable("");
RemoteObject _filename = RemoteObject.createImmutable("");
 BA.debugLineNum = 84;BA.debugLine="Sub playSong";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="If mediaPlayer.IsInitialized Then";
Debug.ShouldStop(1048576);
if (musicservice._mediaplayer.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 86;BA.debugLine="mediaPlayer.Stop";
Debug.ShouldStop(2097152);
musicservice._mediaplayer.runVoidMethod ("Stop");
 };
 BA.debugLineNum = 88;BA.debugLine="Dim trackName As String = musicPlaylist.Get(curre";
Debug.ShouldStop(8388608);
_trackname = BA.ObjectToString(musicservice._musicplaylist.runMethod(false,"Get",(Object)(musicservice._currentsong)));Debug.locals.put("trackName", _trackname);Debug.locals.put("trackName", _trackname);
 BA.debugLineNum = 89;BA.debugLine="Dim fileName As String = trackName.SubString(trac";
Debug.ShouldStop(16777216);
_filename = _trackname.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_trackname.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable("/"))),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("fileName", _filename);Debug.locals.put("fileName", _filename);
 BA.debugLineNum = 91;BA.debugLine="mediaPlayer.Load(File.DirInternal & \"/tracks\", fi";
Debug.ShouldStop(67108864);
musicservice._mediaplayer.runVoidMethod ("Load",(Object)(RemoteObject.concat(musicservice.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"),RemoteObject.createImmutable("/tracks"))),(Object)(_filename));
 BA.debugLineNum = 92;BA.debugLine="mediaPlayer.Play";
Debug.ShouldStop(134217728);
musicservice._mediaplayer.runVoidMethod ("Play");
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _prevsong() throws Exception{
try {
		Debug.PushSubsStack("prevSong (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,112);
if (RapidSub.canDelegate("prevsong")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","prevsong");}
 BA.debugLineNum = 112;BA.debugLine="Sub prevSong";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="currentSong = currentSong - 1";
Debug.ShouldStop(65536);
musicservice._currentsong = RemoteObject.solve(new RemoteObject[] {musicservice._currentsong,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 114;BA.debugLine="If currentSong < 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("<",musicservice._currentsong,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 115;BA.debugLine="currentSong = musicPlaylist.Size - 1";
Debug.ShouldStop(262144);
musicservice._currentsong = RemoteObject.solve(new RemoteObject[] {musicservice._musicplaylist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1);
 };
 BA.debugLineNum = 117;BA.debugLine="playSong";
Debug.ShouldStop(1048576);
_playsong();
 BA.debugLineNum = 118;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Dim mediaPlayer As MediaPlayer";
musicservice._mediaplayer = RemoteObject.createNew ("anywheresoftware.b4a.objects.MediaPlayerWrapper");
 //BA.debugLineNum = 8;BA.debugLine="Dim musicPlaylist As List";
musicservice._musicplaylist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 9;BA.debugLine="Dim currentSong As Int";
musicservice._currentsong = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 10;BA.debugLine="Dim songTimer As Timer";
musicservice._songtimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,13);
if (RapidSub.canDelegate("service_create")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","service_create");}
 BA.debugLineNum = 13;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="mediaPlayer.Initialize";
Debug.ShouldStop(8192);
musicservice._mediaplayer.runVoidMethod ("Initialize");
 BA.debugLineNum = 15;BA.debugLine="musicPlaylist.Initialize";
Debug.ShouldStop(16384);
musicservice._musicplaylist.runVoidMethod ("Initialize");
 BA.debugLineNum = 17;BA.debugLine="musicPlaylist.Add(\"tracks/intro.mp3\")";
Debug.ShouldStop(65536);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/intro.mp3"))));
 BA.debugLineNum = 18;BA.debugLine="musicPlaylist.Add(\"tracks/taiyaki.mp3\")";
Debug.ShouldStop(131072);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/taiyaki.mp3"))));
 BA.debugLineNum = 19;BA.debugLine="musicPlaylist.Add(\"tracks/feel special.mp3\")";
Debug.ShouldStop(262144);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/feel special.mp3"))));
 BA.debugLineNum = 20;BA.debugLine="musicPlaylist.Add(\"tracks/union.mp3\")";
Debug.ShouldStop(524288);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/union.mp3"))));
 BA.debugLineNum = 21;BA.debugLine="musicPlaylist.Add(\"tracks/two in the morning.mp3\"";
Debug.ShouldStop(1048576);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/two in the morning.mp3"))));
 BA.debugLineNum = 22;BA.debugLine="musicPlaylist.Add(\"tracks/happily ever after.mp3\"";
Debug.ShouldStop(2097152);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/happily ever after.mp3"))));
 BA.debugLineNum = 23;BA.debugLine="musicPlaylist.Add(\"tracks/cookie.mp3\")";
Debug.ShouldStop(4194304);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/cookie.mp3"))));
 BA.debugLineNum = 24;BA.debugLine="musicPlaylist.Add(\"tracks/comfy vibes.mp3\")";
Debug.ShouldStop(8388608);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/comfy vibes.mp3"))));
 BA.debugLineNum = 25;BA.debugLine="musicPlaylist.Add(\"tracks/dango.mp3\")";
Debug.ShouldStop(16777216);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/dango.mp3"))));
 BA.debugLineNum = 26;BA.debugLine="musicPlaylist.Add(\"tracks/iced caramel macchiato.";
Debug.ShouldStop(33554432);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/iced caramel macchiato.mp3"))));
 BA.debugLineNum = 27;BA.debugLine="musicPlaylist.Add(\"tracks/in dreamland.mp3\")";
Debug.ShouldStop(67108864);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/in dreamland.mp3"))));
 BA.debugLineNum = 28;BA.debugLine="musicPlaylist.Add(\"tracks/space aquarium.mp3\")";
Debug.ShouldStop(134217728);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/space aquarium.mp3"))));
 BA.debugLineNum = 29;BA.debugLine="musicPlaylist.Add(\"tracks/sunshine & butterflies.";
Debug.ShouldStop(268435456);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/sunshine & butterflies.mp3"))));
 BA.debugLineNum = 30;BA.debugLine="musicPlaylist.Add(\"tracks/soda pop.mp3\")";
Debug.ShouldStop(536870912);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/soda pop.mp3"))));
 BA.debugLineNum = 31;BA.debugLine="musicPlaylist.Add(\"tracks/matcha latte.mp3\")";
Debug.ShouldStop(1073741824);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/matcha latte.mp3"))));
 BA.debugLineNum = 32;BA.debugLine="musicPlaylist.Add(\"tracks/midnight.mp3\")";
Debug.ShouldStop(-2147483648);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/midnight.mp3"))));
 BA.debugLineNum = 33;BA.debugLine="musicPlaylist.Add(\"tracks/rose water.mp3\")";
Debug.ShouldStop(1);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/rose water.mp3"))));
 BA.debugLineNum = 34;BA.debugLine="musicPlaylist.Add(\"tracks/hot.mp3\")";
Debug.ShouldStop(2);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/hot.mp3"))));
 BA.debugLineNum = 35;BA.debugLine="musicPlaylist.Add(\"tracks/on the top.mp3\")";
Debug.ShouldStop(4);
musicservice._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("tracks/on the top.mp3"))));
 BA.debugLineNum = 38;BA.debugLine="CopyTracksIfNeeded";
Debug.ShouldStop(32);
_copytracksifneeded();
 BA.debugLineNum = 40;BA.debugLine="currentSong = 0";
Debug.ShouldStop(128);
musicservice._currentsong = BA.numberCast(int.class, 0);
 BA.debugLineNum = 41;BA.debugLine="playSong";
Debug.ShouldStop(256);
_playsong();
 BA.debugLineNum = 43;BA.debugLine="songTimer.Initialize(\"songTimer\", 500)";
Debug.ShouldStop(1024);
musicservice._songtimer.runVoidMethod ("Initialize",musicservice.processBA,(Object)(BA.ObjectToString("songTimer")),(Object)(BA.numberCast(long.class, 500)));
 BA.debugLineNum = 44;BA.debugLine="songTimer.Enabled = True";
Debug.ShouldStop(2048);
musicservice._songtimer.runMethod(true,"setEnabled",musicservice.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,67);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","service_destroy");}
 BA.debugLineNum = 67;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(4);
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,63);
if (RapidSub.canDelegate("service_start")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 63;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="Service.StopAutomaticForeground 'Call this when t";
Debug.ShouldStop(-2147483648);
musicservice.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setsong(RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("setSong (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,79);
if (RapidSub.canDelegate("setsong")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","setsong", _index);}
Debug.locals.put("index", _index);
 BA.debugLineNum = 79;BA.debugLine="Sub setSong(index As Int)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="currentSong = index";
Debug.ShouldStop(32768);
musicservice._currentsong = _index;
 BA.debugLineNum = 81;BA.debugLine="playSong";
Debug.ShouldStop(65536);
_playsong();
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _songtimer_tick() throws Exception{
try {
		Debug.PushSubsStack("songTimer_Tick (musicservice) ","musicservice",10,musicservice.processBA,musicservice.mostCurrent,95);
if (RapidSub.canDelegate("songtimer_tick")) { return b4a.example.musicservice.remoteMe.runUserSub(false, "musicservice","songtimer_tick");}
 BA.debugLineNum = 95;BA.debugLine="Sub songTimer_Tick";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="If mediaPlayer.IsInitialized Then";
Debug.ShouldStop(-2147483648);
if (musicservice._mediaplayer.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 97;BA.debugLine="If mediaPlayer.IsPlaying = False And mediaPlayer";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",musicservice._mediaplayer.runMethod(true,"IsPlaying"),musicservice.mostCurrent.__c.getField(true,"False")) && RemoteObject.solveBoolean(">",musicservice._mediaplayer.runMethod(true,"getDuration"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 98;BA.debugLine="If mediaPlayer.Position >= mediaPlayer.Duration";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("g",musicservice._mediaplayer.runMethod(true,"getPosition"),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {musicservice._mediaplayer.runMethod(true,"getDuration"),RemoteObject.createImmutable(100)}, "-",1, 1)))) { 
 BA.debugLineNum = 99;BA.debugLine="nextSong";
Debug.ShouldStop(4);
_nextsong();
 };
 };
 };
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}