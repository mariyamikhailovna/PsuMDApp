package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(2);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 35;BA.debugLine="kvs.Initialize(File.DirInternal, \"notes_data\")";
Debug.ShouldStop(4);
main._kvs.runClassMethod (b4a.example.keyvaluestore.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("notes_data")));
 BA.debugLineNum = 36;BA.debugLine="timerClock.Initialize(\"timerClock\", 1000)";
Debug.ShouldStop(8);
main._timerclock.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("timerClock")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 37;BA.debugLine="timerClock.Enabled = True";
Debug.ShouldStop(16);
main._timerclock.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(64);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,54);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 54;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,46);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="If format24h Then";
Debug.ShouldStop(16384);
if (main._format24h.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 48;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
Debug.ShouldStop(32768);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 }else {
 BA.debugLineNum = 50;BA.debugLine="DateTime.TimeFormat = \"hh:mm a\"";
Debug.ShouldStop(131072);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("hh:mm a"));
 };
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clockbtn_click() throws Exception{
try {
		Debug.PushSubsStack("clockBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,58);
if (RapidSub.canDelegate("clockbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","clockbtn_click");}
 BA.debugLineNum = 58;BA.debugLine="Private Sub clockBtn_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="StartActivity(clock)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._clock.getObject())));
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _corkbtn_click() throws Exception{
try {
		Debug.PushSubsStack("corkBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,66);
if (RapidSub.canDelegate("corkbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","corkbtn_click");}
 BA.debugLineNum = 66;BA.debugLine="Private Sub corkBtn_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="StartActivity(cork)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._cork.getObject())));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private clockBtn As Button";
main.mostCurrent._clockbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _notebtn_click() throws Exception{
try {
		Debug.PushSubsStack("noteBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,62);
if (RapidSub.canDelegate("notebtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","notebtn_click");}
 BA.debugLineNum = 62;BA.debugLine="Private Sub noteBtn_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="StartActivity(note)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._note.getObject())));
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

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
clock_subs_0._process_globals();
note_subs_0._process_globals();
cork_subs_0._process_globals();
editnote_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
clock.myClass = BA.getDeviceClass ("b4a.example.clock");
note.myClass = BA.getDeviceClass ("b4a.example.note");
cork.myClass = BA.getDeviceClass ("b4a.example.cork");
editnote.myClass = BA.getDeviceClass ("b4a.example.editnote");
keyvaluestore.myClass = BA.getDeviceClass ("b4a.example.keyvaluestore");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Private timerClock As Timer";
main._timerclock = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 20;BA.debugLine="Public format24h As Boolean = False";
main._format24h = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 21;BA.debugLine="Type MyNote (Title As String, Tags As String, Con";
;
 //BA.debugLineNum = 22;BA.debugLine="Public kvs As KeyValueStore";
main._kvs = RemoteObject.createNew ("b4a.example.keyvaluestore");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _timerclock_tick() throws Exception{
try {
		Debug.PushSubsStack("timerClock_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,42);
if (RapidSub.canDelegate("timerclock_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","timerclock_tick");}
 BA.debugLineNum = 42;BA.debugLine="Sub timerClock_Tick";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="clockBtn.Text = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(1024);
main.mostCurrent._clockbtn.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}