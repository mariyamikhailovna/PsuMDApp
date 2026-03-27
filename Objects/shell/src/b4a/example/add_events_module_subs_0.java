package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class add_events_module_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"AEMLayout\")";
Debug.ShouldStop(268435456);
add_events_module.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("AEMLayout")),add_events_module.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="timelbl.Text = currentDate";
Debug.ShouldStop(536870912);
add_events_module.mostCurrent._timelbl.runMethod(true,"setText",BA.ObjectToCharSequence(add_events_module._currentdate));
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Pause (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,46);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="eventrb.Checked = False";
Debug.ShouldStop(16384);
add_events_module.mostCurrent._eventrb.runMethodAndSync(true,"setChecked",add_events_module.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 48;BA.debugLine="taskrb.Checked = False";
Debug.ShouldStop(32768);
add_events_module.mostCurrent._taskrb.runMethodAndSync(true,"setChecked",add_events_module.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 49;BA.debugLine="birthdayrb.Checked = False";
Debug.ShouldStop(65536);
add_events_module.mostCurrent._birthdayrb.runMethodAndSync(true,"setChecked",add_events_module.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 50;BA.debugLine="ooorb.Checked = False";
Debug.ShouldStop(131072);
add_events_module.mostCurrent._ooorb.runMethodAndSync(true,"setChecked",add_events_module.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Activity_Resume (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,34);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","activity_resume");}
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="If eventtype = \"Event\" Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",add_events_module._eventtype,BA.ObjectToString("Event"))) { 
 BA.debugLineNum = 36;BA.debugLine="eventrb.Checked = True";
Debug.ShouldStop(8);
add_events_module.mostCurrent._eventrb.runMethodAndSync(true,"setChecked",add_events_module.mostCurrent.__c.getField(true,"True"));
 }else 
{ BA.debugLineNum = 37;BA.debugLine="Else if eventtype = \"Task\" Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",add_events_module._eventtype,BA.ObjectToString("Task"))) { 
 BA.debugLineNum = 38;BA.debugLine="taskrb.Checked = True";
Debug.ShouldStop(32);
add_events_module.mostCurrent._taskrb.runMethodAndSync(true,"setChecked",add_events_module.mostCurrent.__c.getField(true,"True"));
 }else 
{ BA.debugLineNum = 39;BA.debugLine="Else if eventtype = \"Birthday\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",add_events_module._eventtype,BA.ObjectToString("Birthday"))) { 
 BA.debugLineNum = 40;BA.debugLine="birthdayrb.Checked = True";
Debug.ShouldStop(128);
add_events_module.mostCurrent._birthdayrb.runMethodAndSync(true,"setChecked",add_events_module.mostCurrent.__c.getField(true,"True"));
 }else 
{ BA.debugLineNum = 41;BA.debugLine="Else if eventtype = \"OOO\" Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",add_events_module._eventtype,BA.ObjectToString("OOO"))) { 
 BA.debugLineNum = 42;BA.debugLine="ooorb.Checked = True";
Debug.ShouldStop(512);
add_events_module.mostCurrent._ooorb.runMethodAndSync(true,"setChecked",add_events_module.mostCurrent.__c.getField(true,"True"));
 }}}}
;
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
public static RemoteObject  _birthdayrb_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("birthdayrb_CheckedChange (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,110);
if (RapidSub.canDelegate("birthdayrb_checkedchange")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","birthdayrb_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 110;BA.debugLine="Private Sub birthdayrb_CheckedChange(Checked As Bo";
Debug.ShouldStop(8192);
 BA.debugLineNum = 111;BA.debugLine="eventtype = \"Birthday\"";
Debug.ShouldStop(16384);
add_events_module._eventtype = BA.ObjectToString("Birthday");
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _eventrb_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("eventrb_CheckedChange (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,114);
if (RapidSub.canDelegate("eventrb_checkedchange")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","eventrb_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 114;BA.debugLine="Private Sub eventrb_CheckedChange(Checked As Boole";
Debug.ShouldStop(131072);
 BA.debugLineNum = 115;BA.debugLine="eventtype = \"Event\"";
Debug.ShouldStop(262144);
add_events_module._eventtype = BA.ObjectToString("Event");
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private taskrb As RadioButton";
add_events_module.mostCurrent._taskrb = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private eventrb As RadioButton";
add_events_module.mostCurrent._eventrb = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private birthdayrb As RadioButton";
add_events_module.mostCurrent._birthdayrb = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private ooorb As RadioButton";
add_events_module.mostCurrent._ooorb = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private timelbl As Label";
add_events_module.mostCurrent._timelbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private title_et As EditText";
add_events_module.mostCurrent._title_et = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private description_et As EditText";
add_events_module.mostCurrent._description_et = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _mapinitializer() throws Exception{
try {
		Debug.PushSubsStack("MapInitializer (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,62);
if (RapidSub.canDelegate("mapinitializer")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","mapinitializer");}
RemoteObject _eventmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _allevents = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _timeline = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 62;BA.debugLine="Sub MapInitializer As Map";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="Dim eventmap As Map";
Debug.ShouldStop(1073741824);
_eventmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("eventmap", _eventmap);
 BA.debugLineNum = 65;BA.debugLine="eventmap.Initialize";
Debug.ShouldStop(1);
_eventmap.runVoidMethod ("Initialize");
 BA.debugLineNum = 66;BA.debugLine="Dim allevents As List";
Debug.ShouldStop(2);
_allevents = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("allevents", _allevents);
 BA.debugLineNum = 67;BA.debugLine="allevents.initialize";
Debug.ShouldStop(4);
_allevents.runVoidMethod ("Initialize");
 BA.debugLineNum = 69;BA.debugLine="Dim timeline As List";
Debug.ShouldStop(16);
_timeline = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("timeline", _timeline);
 BA.debugLineNum = 70;BA.debugLine="timeline.initialize";
Debug.ShouldStop(32);
_timeline.runVoidMethod ("Initialize");
 BA.debugLineNum = 72;BA.debugLine="eventmap.Put(\"AllEvents\", allevents)";
Debug.ShouldStop(128);
_eventmap.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("AllEvents"))),(Object)((_allevents.getObject())));
 BA.debugLineNum = 73;BA.debugLine="eventmap.Put(\"Timeline\", timeline)";
Debug.ShouldStop(256);
_eventmap.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Timeline"))),(Object)((_timeline.getObject())));
 BA.debugLineNum = 75;BA.debugLine="CalendarActivity.CalendarMap.Put(day_module.curre";
Debug.ShouldStop(1024);
add_events_module.mostCurrent._calendaractivity._calendarmap /*RemoteObject*/ .runVoidMethod ("Put",(Object)((add_events_module.mostCurrent._day_module._currentdate /*RemoteObject*/ )),(Object)((_eventmap.getObject())));
 BA.debugLineNum = 77;BA.debugLine="Return eventmap";
Debug.ShouldStop(4096);
if (true) return _eventmap;
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ooorb_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("ooorb_CheckedChange (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,106);
if (RapidSub.canDelegate("ooorb_checkedchange")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","ooorb_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 106;BA.debugLine="Private Sub ooorb_CheckedChange(Checked As Boolean";
Debug.ShouldStop(512);
 BA.debugLineNum = 107;BA.debugLine="eventtype = \"OOO\"";
Debug.ShouldStop(1024);
add_events_module._eventtype = BA.ObjectToString("OOO");
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim eventtype As String";
add_events_module._eventtype = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="Dim currentDate As String";
add_events_module._currentdate = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _save_btn_click() throws Exception{
try {
		Debug.PushSubsStack("save_btn_Click (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,80);
if (RapidSub.canDelegate("save_btn_click")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","save_btn_click");}
RemoteObject _eventmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _getallevents = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _putevent = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 80;BA.debugLine="Private Sub save_btn_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="Dim eventmap As Map";
Debug.ShouldStop(65536);
_eventmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("eventmap", _eventmap);
 BA.debugLineNum = 82;BA.debugLine="If title_et.text = \"\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",add_events_module.mostCurrent._title_et.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 83;BA.debugLine="MsgboxAsync(\"Enter The Event Title\", \"Error\")";
Debug.ShouldStop(262144);
add_events_module.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Enter The Event Title")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),add_events_module.processBA);
 BA.debugLineNum = 84;BA.debugLine="Return";
Debug.ShouldStop(524288);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 87;BA.debugLine="If CalendarActivity.CalendarMap.ContainsKey(day_m";
Debug.ShouldStop(4194304);
if (add_events_module.mostCurrent._calendaractivity._calendarmap /*RemoteObject*/ .runMethod(true,"ContainsKey",(Object)((add_events_module.mostCurrent._day_module._currentdate /*RemoteObject*/ ))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 88;BA.debugLine="eventmap = CalendarActivity.CalendarMap.Get(day_";
Debug.ShouldStop(8388608);
_eventmap = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), add_events_module.mostCurrent._calendaractivity._calendarmap /*RemoteObject*/ .runMethod(false,"Get",(Object)((add_events_module.mostCurrent._day_module._currentdate /*RemoteObject*/ ))));Debug.locals.put("eventmap", _eventmap);
 }else {
 BA.debugLineNum = 90;BA.debugLine="eventmap = MapInitializer";
Debug.ShouldStop(33554432);
_eventmap = _mapinitializer();Debug.locals.put("eventmap", _eventmap);
 };
 BA.debugLineNum = 93;BA.debugLine="Dim getAllevents As List = eventmap.Get(\"AllEvent";
Debug.ShouldStop(268435456);
_getallevents = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_getallevents = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _eventmap.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("AllEvents")))));Debug.locals.put("getAllevents", _getallevents);Debug.locals.put("getAllevents", _getallevents);
 BA.debugLineNum = 94;BA.debugLine="Dim putevent As Map";
Debug.ShouldStop(536870912);
_putevent = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("putevent", _putevent);
 BA.debugLineNum = 95;BA.debugLine="putevent.Initialize";
Debug.ShouldStop(1073741824);
_putevent.runVoidMethod ("Initialize");
 BA.debugLineNum = 96;BA.debugLine="putevent.Put(\"Title\", title_et.Text)";
Debug.ShouldStop(-2147483648);
_putevent.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Title"))),(Object)((add_events_module.mostCurrent._title_et.runMethod(true,"getText"))));
 BA.debugLineNum = 97;BA.debugLine="putevent.Put(\"Description\", description_et.Text)";
Debug.ShouldStop(1);
_putevent.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Description"))),(Object)((add_events_module.mostCurrent._description_et.runMethod(true,"getText"))));
 BA.debugLineNum = 98;BA.debugLine="putevent.Put(\"Tags\", eventtype)";
Debug.ShouldStop(2);
_putevent.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Tags"))),(Object)((add_events_module._eventtype)));
 BA.debugLineNum = 100;BA.debugLine="getAllevents.Add(putevent)";
Debug.ShouldStop(8);
_getallevents.runVoidMethod ("Add",(Object)((_putevent.getObject())));
 BA.debugLineNum = 101;BA.debugLine="SaveCalendar";
Debug.ShouldStop(16);
_savecalendar();
 BA.debugLineNum = 102;BA.debugLine="day_module.addeventsfeedback = True";
Debug.ShouldStop(32);
add_events_module.mostCurrent._day_module._addeventsfeedback /*RemoteObject*/  = add_events_module.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 103;BA.debugLine="Activity.finish";
Debug.ShouldStop(64);
add_events_module.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savecalendar() throws Exception{
try {
		Debug.PushSubsStack("SaveCalendar (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,58);
if (RapidSub.canDelegate("savecalendar")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","savecalendar");}
 BA.debugLineNum = 58;BA.debugLine="Sub SaveCalendar";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="CalendarActivity.kvs.put(\"CalendarKVS\", CalendarA";
Debug.ShouldStop(67108864);
add_events_module.mostCurrent._calendaractivity._kvs /*RemoteObject*/ .runVoidMethod ("_put",(Object)(BA.ObjectToString("CalendarKVS")),(Object)((add_events_module.mostCurrent._calendaractivity._calendarmap /*RemoteObject*/ .getObject())));
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
public static RemoteObject  _taskrb_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("taskrb_CheckedChange (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,118);
if (RapidSub.canDelegate("taskrb_checkedchange")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","taskrb_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 118;BA.debugLine="Private Sub taskrb_CheckedChange(Checked As Boolea";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 119;BA.debugLine="eventtype = \"Task\"";
Debug.ShouldStop(4194304);
add_events_module._eventtype = BA.ObjectToString("Task");
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _x_btn_click() throws Exception{
try {
		Debug.PushSubsStack("x_btn_Click (add_events_module) ","add_events_module",14,add_events_module.mostCurrent.activityBA,add_events_module.mostCurrent,54);
if (RapidSub.canDelegate("x_btn_click")) { return b4a.example.add_events_module.remoteMe.runUserSub(false, "add_events_module","x_btn_click");}
 BA.debugLineNum = 54;BA.debugLine="Private Sub x_btn_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4194304);
add_events_module.mostCurrent._activity.runVoidMethod ("Finish");
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
}