package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",23,starter.processBA,starter.mostCurrent,38);
if (RapidSub.canDelegate("application_error")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 38;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="Return True";
Debug.ShouldStop(64);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public darkMode As Boolean = False";
starter._darkmode = starter.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 10;BA.debugLine="Public themeNumber As Int = 0";
starter._themenumber = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",23,starter.processBA,starter.mostCurrent,13);
if (RapidSub.canDelegate("service_create")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","service_create");}
RemoteObject _kvs = RemoteObject.declareNull("b4a.example3.keyvaluestore");
 BA.debugLineNum = 13;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="Dim kvs As KeyValueStore";
Debug.ShouldStop(8192);
_kvs = RemoteObject.createNew ("b4a.example3.keyvaluestore");Debug.locals.put("kvs", _kvs);
 BA.debugLineNum = 15;BA.debugLine="kvs.Initialize(File.DirInternal, \"prefData\")";
Debug.ShouldStop(16384);
_kvs.runVoidMethod ("_initialize",starter.processBA,(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("prefData")));
 BA.debugLineNum = 17;BA.debugLine="If kvs.ContainsKey(\"darkMode\") Then";
Debug.ShouldStop(65536);
if (_kvs.runMethod(true,"_containskey",(Object)(RemoteObject.createImmutable("darkMode"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 18;BA.debugLine="darkMode = kvs.Get(\"darkMode\")";
Debug.ShouldStop(131072);
starter._darkmode = BA.ObjectToBoolean(_kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("darkMode"))));
 };
 BA.debugLineNum = 21;BA.debugLine="If kvs.ContainsKey(\"themeNumber\") Then";
Debug.ShouldStop(1048576);
if (_kvs.runMethod(true,"_containskey",(Object)(RemoteObject.createImmutable("themeNumber"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 22;BA.debugLine="themeNumber = kvs.Get(\"themeNumber\")";
Debug.ShouldStop(2097152);
starter._themenumber = BA.numberCast(int.class, _kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("themeNumber"))));
 };
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",23,starter.processBA,starter.mostCurrent,42);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","service_destroy");}
 BA.debugLineNum = 42;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(512);
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
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",23,starter.processBA,starter.mostCurrent,29);
if (RapidSub.canDelegate("service_start")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 29;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
Debug.ShouldStop(536870912);
starter.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (starter) ","starter",23,starter.processBA,starter.mostCurrent,33);
if (RapidSub.canDelegate("service_taskremoved")) { return b4a.example.starter.remoteMe.runUserSub(false, "starter","service_taskremoved");}
 BA.debugLineNum = 33;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}