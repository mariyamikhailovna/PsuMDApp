package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,34);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
int _i = 0;
RemoteObject _title = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(4);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 37;BA.debugLine="mediaPlayer.Initialize";
Debug.ShouldStop(16);
main.mostCurrent._mediaplayer.runVoidMethod ("Initialize");
 BA.debugLineNum = 38;BA.debugLine="musicPlaylist.Initialize";
Debug.ShouldStop(32);
main.mostCurrent._musicplaylist.runVoidMethod ("Initialize");
 BA.debugLineNum = 40;BA.debugLine="musicPlaylist.Add(\"timed tune.mp3\")";
Debug.ShouldStop(128);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("timed tune.mp3"))));
 BA.debugLineNum = 41;BA.debugLine="musicPlaylist.Add(\"hammer & sickle.mp3\")";
Debug.ShouldStop(256);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("hammer & sickle.mp3"))));
 BA.debugLineNum = 42;BA.debugLine="musicPlaylist.Add(\"all too well.mp3\")";
Debug.ShouldStop(512);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("all too well.mp3"))));
 BA.debugLineNum = 43;BA.debugLine="musicPlaylist.Add(\"lover, you should've come over";
Debug.ShouldStop(1024);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("lover, you should've come over.mp3"))));
 BA.debugLineNum = 44;BA.debugLine="musicPlaylist.Add(\"bawat piyesa.mp3\")";
Debug.ShouldStop(2048);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("bawat piyesa.mp3"))));
 BA.debugLineNum = 45;BA.debugLine="musicPlaylist.Add(\"take a chance with me.mp3\")";
Debug.ShouldStop(4096);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("take a chance with me.mp3"))));
 BA.debugLineNum = 46;BA.debugLine="musicPlaylist.Add(\"girls never die.mp3\")";
Debug.ShouldStop(8192);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("girls never die.mp3"))));
 BA.debugLineNum = 47;BA.debugLine="musicPlaylist.Add(\"magnetic.mp3\")";
Debug.ShouldStop(16384);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("magnetic.mp3"))));
 BA.debugLineNum = 48;BA.debugLine="musicPlaylist.Add(\"supersonic.mp3\")";
Debug.ShouldStop(32768);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("supersonic.mp3"))));
 BA.debugLineNum = 49;BA.debugLine="musicPlaylist.Add(\"we're finally landing.mp3\")";
Debug.ShouldStop(65536);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("we're finally landing.mp3"))));
 BA.debugLineNum = 50;BA.debugLine="musicPlaylist.Add(\"gumball drift.mp3\")";
Debug.ShouldStop(131072);
main.mostCurrent._musicplaylist.runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("gumball drift.mp3"))));
 BA.debugLineNum = 52;BA.debugLine="For i = 0 To musicPlaylist.Size - 1";
Debug.ShouldStop(524288);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._musicplaylist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 53;BA.debugLine="Dim title As String = musicPlaylist.Get(i)";
Debug.ShouldStop(1048576);
_title = BA.ObjectToString(main.mostCurrent._musicplaylist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 BA.debugLineNum = 54;BA.debugLine="title = title.SubString2(0, title.Length - 4)";
Debug.ShouldStop(2097152);
_title = _title.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_title.runMethod(true,"length"),RemoteObject.createImmutable(4)}, "-",1, 1)));Debug.locals.put("title", _title);
 BA.debugLineNum = 55;BA.debugLine="ListView1.AddSingleLine((i + 1) & \" \" & title)";
Debug.ShouldStop(4194304);
main.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)),RemoteObject.createImmutable(" "),_title))));
 BA.debugLineNum = 56;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor = Col";
Debug.ShouldStop(8388608);
main.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 59;BA.debugLine="currentSong = 0";
Debug.ShouldStop(67108864);
main._currentsong = BA.numberCast(int.class, 0);
 BA.debugLineNum = 60;BA.debugLine="playSong";
Debug.ShouldStop(134217728);
_playsong();
 BA.debugLineNum = 62;BA.debugLine="songTimer.Initialize(\"songTimer\", 500)";
Debug.ShouldStop(536870912);
main._songtimer.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("songTimer")),(Object)(BA.numberCast(long.class, 500)));
 BA.debugLineNum = 63;BA.debugLine="songTimer.Enabled = True";
Debug.ShouldStop(1073741824);
main._songtimer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _formatsongdur(RemoteObject _ms) throws Exception{
try {
		Debug.PushSubsStack("formatSongDur (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,88);
if (RapidSub.canDelegate("formatsongdur")) { return b4a.example.main.remoteMe.runUserSub(false, "main","formatsongdur", _ms);}
RemoteObject _seconds = RemoteObject.createImmutable(0);
RemoteObject _minutes = RemoteObject.createImmutable(0);
Debug.locals.put("ms", _ms);
 BA.debugLineNum = 88;BA.debugLine="Sub formatSongDur(ms As Int) As String";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="Dim seconds As Int = ms / 1000";
Debug.ShouldStop(16777216);
_seconds = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ms,RemoteObject.createImmutable(1000)}, "/",0, 0));Debug.locals.put("seconds", _seconds);Debug.locals.put("seconds", _seconds);
 BA.debugLineNum = 90;BA.debugLine="Dim minutes As Int = seconds / 60";
Debug.ShouldStop(33554432);
_minutes = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_seconds,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("minutes", _minutes);Debug.locals.put("minutes", _minutes);
 BA.debugLineNum = 91;BA.debugLine="seconds = seconds Mod 60";
Debug.ShouldStop(67108864);
_seconds = RemoteObject.solve(new RemoteObject[] {_seconds,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("seconds", _seconds);
 BA.debugLineNum = 93;BA.debugLine="Return NumberFormat(minutes, 2, 0) & \":\" & Number";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.concat(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _minutes)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(":"),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _seconds)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Dim mediaPlayer As MediaPlayer";
main.mostCurrent._mediaplayer = RemoteObject.createNew ("anywheresoftware.b4a.objects.MediaPlayerWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Dim musicPlaylist As List";
main.mostCurrent._musicplaylist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 26;BA.debugLine="Dim currentSong As Int";
main._currentsong = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 27;BA.debugLine="Private SeekBar1 As SeekBar";
main.mostCurrent._seekbar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private songTitle As Label";
main.mostCurrent._songtitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private pauseBtn As Button";
main.mostCurrent._pausebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private songRuntime As Label";
main.mostCurrent._songruntime = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private ListView1 As ListView";
main.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _listview1_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListView1_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,131);
if (RapidSub.canDelegate("listview1_itemclick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","listview1_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 131;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="currentSong = Position";
Debug.ShouldStop(8);
main._currentsong = _position;
 BA.debugLineNum = 133;BA.debugLine="playSong";
Debug.ShouldStop(16);
_playsong();
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _nextbtn_click() throws Exception{
try {
		Debug.PushSubsStack("nextBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,102);
if (RapidSub.canDelegate("nextbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","nextbtn_click");}
 BA.debugLineNum = 102;BA.debugLine="Sub nextBtn_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="currentSong = currentSong + 1";
Debug.ShouldStop(64);
main._currentsong = RemoteObject.solve(new RemoteObject[] {main._currentsong,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 105;BA.debugLine="If currentSong >= musicPlaylist.Size Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("g",main._currentsong,BA.numberCast(double.class, main.mostCurrent._musicplaylist.runMethod(true,"getSize")))) { 
 BA.debugLineNum = 106;BA.debugLine="currentSong = 0";
Debug.ShouldStop(512);
main._currentsong = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 108;BA.debugLine="playSong";
Debug.ShouldStop(2048);
_playsong();
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pausebtn_click() throws Exception{
try {
		Debug.PushSubsStack("pauseBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,120);
if (RapidSub.canDelegate("pausebtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","pausebtn_click");}
 BA.debugLineNum = 120;BA.debugLine="Private Sub pauseBtn_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 122;BA.debugLine="If mediaPlayer.IsPlaying Then";
Debug.ShouldStop(33554432);
if (main.mostCurrent._mediaplayer.runMethod(true,"IsPlaying").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 123;BA.debugLine="mediaPlayer.Pause";
Debug.ShouldStop(67108864);
main.mostCurrent._mediaplayer.runVoidMethod ("Pause");
 BA.debugLineNum = 124;BA.debugLine="pauseBtn.Text = \"▶\"";
Debug.ShouldStop(134217728);
main.mostCurrent._pausebtn.runMethod(true,"setText",BA.ObjectToCharSequence("▶"));
 }else {
 BA.debugLineNum = 126;BA.debugLine="mediaPlayer.Play";
Debug.ShouldStop(536870912);
main.mostCurrent._mediaplayer.runVoidMethod ("Play");
 BA.debugLineNum = 127;BA.debugLine="pauseBtn.Text = \"❚❚\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._pausebtn.runMethod(true,"setText",BA.ObjectToCharSequence("❚❚"));
 };
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("playSong (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,66);
if (RapidSub.canDelegate("playsong")) { return b4a.example.main.remoteMe.runUserSub(false, "main","playsong");}
RemoteObject _title = RemoteObject.createImmutable("");
 BA.debugLineNum = 66;BA.debugLine="Sub playSong";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="mediaPlayer.Load(File.DirAssets, musicPlaylist.Ge";
Debug.ShouldStop(4);
main.mostCurrent._mediaplayer.runVoidMethod ("Load",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString(main.mostCurrent._musicplaylist.runMethod(false,"Get",(Object)(main._currentsong)))));
 BA.debugLineNum = 68;BA.debugLine="mediaPlayer.Play";
Debug.ShouldStop(8);
main.mostCurrent._mediaplayer.runVoidMethod ("Play");
 BA.debugLineNum = 70;BA.debugLine="Dim title As String";
Debug.ShouldStop(32);
_title = RemoteObject.createImmutable("");Debug.locals.put("title", _title);
 BA.debugLineNum = 71;BA.debugLine="title = musicPlaylist.Get(currentSong)";
Debug.ShouldStop(64);
_title = BA.ObjectToString(main.mostCurrent._musicplaylist.runMethod(false,"Get",(Object)(main._currentsong)));Debug.locals.put("title", _title);
 BA.debugLineNum = 72;BA.debugLine="songTitle.Text = title.SubString2(0, title.Length";
Debug.ShouldStop(128);
main.mostCurrent._songtitle.runMethod(true,"setText",BA.ObjectToCharSequence(_title.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_title.runMethod(true,"length"),RemoteObject.createImmutable(4)}, "-",1, 1)))));
 BA.debugLineNum = 74;BA.debugLine="SeekBar1.Max = mediaPlayer.Duration";
Debug.ShouldStop(512);
main.mostCurrent._seekbar1.runMethod(true,"setMax",main.mostCurrent._mediaplayer.runMethod(true,"getDuration"));
 BA.debugLineNum = 75;BA.debugLine="SeekBar1.Value = 0";
Debug.ShouldStop(1024);
main.mostCurrent._seekbar1.runMethod(true,"setValue",BA.numberCast(int.class, 0));
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
public static RemoteObject  _prevbtn_click() throws Exception{
try {
		Debug.PushSubsStack("prevBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("prevbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","prevbtn_click");}
 BA.debugLineNum = 111;BA.debugLine="Private Sub prevBtn_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="currentSong = currentSong - 1";
Debug.ShouldStop(32768);
main._currentsong = RemoteObject.solve(new RemoteObject[] {main._currentsong,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 114;BA.debugLine="If currentSong < 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("<",main._currentsong,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 115;BA.debugLine="currentSong = musicPlaylist.Size - 1";
Debug.ShouldStop(262144);
main._currentsong = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._musicplaylist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1);
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

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Dim songTimer As Timer";
main._songtimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _seekbar1_valuechanged(RemoteObject _value,RemoteObject _userchanged) throws Exception{
try {
		Debug.PushSubsStack("SeekBar1_ValueChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,96);
if (RapidSub.canDelegate("seekbar1_valuechanged")) { return b4a.example.main.remoteMe.runUserSub(false, "main","seekbar1_valuechanged", _value, _userchanged);}
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 96;BA.debugLine="Sub SeekBar1_ValueChanged (Value As Int, UserChang";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="If UserChanged Then";
Debug.ShouldStop(1);
if (_userchanged.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 98;BA.debugLine="mediaPlayer.Position = Value";
Debug.ShouldStop(2);
main.mostCurrent._mediaplayer.runMethod(true,"setPosition",_value);
 };
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("songTimer_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,79);
if (RapidSub.canDelegate("songtimer_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","songtimer_tick");}
 BA.debugLineNum = 79;BA.debugLine="Sub songTimer_Tick";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="If mediaPlayer.IsPlaying Then";
Debug.ShouldStop(32768);
if (main.mostCurrent._mediaplayer.runMethod(true,"IsPlaying").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 81;BA.debugLine="SeekBar1.Value = mediaPlayer.Position";
Debug.ShouldStop(65536);
main.mostCurrent._seekbar1.runMethod(true,"setValue",main.mostCurrent._mediaplayer.runMethod(true,"getPosition"));
 BA.debugLineNum = 82;BA.debugLine="songRuntime.Text = formatSongDur(mediaPlayer.Pos";
Debug.ShouldStop(131072);
main.mostCurrent._songruntime.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_formatsongdur(main.mostCurrent._mediaplayer.runMethod(true,"getPosition")),RemoteObject.createImmutable(" / "),_formatsongdur(main.mostCurrent._mediaplayer.runMethod(true,"getDuration")))));
 }else 
{ BA.debugLineNum = 83;BA.debugLine="Else If mediaPlayer.Position >= mediaPlayer.Durat";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("g",main.mostCurrent._mediaplayer.runMethod(true,"getPosition"),BA.numberCast(double.class, main.mostCurrent._mediaplayer.runMethod(true,"getDuration")))) { 
 BA.debugLineNum = 84;BA.debugLine="nextBtn_Click";
Debug.ShouldStop(524288);
_nextbtn_click();
 }}
;
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}