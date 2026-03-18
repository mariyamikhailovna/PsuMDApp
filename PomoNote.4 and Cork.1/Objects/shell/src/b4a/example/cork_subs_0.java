package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class cork_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (cork) ","cork",4,cork.mostCurrent.activityBA,cork.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"corkboardLayout\")";
Debug.ShouldStop(33554432);
cork.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("corkboardLayout")),cork.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Pause (cork) ","cork",4,cork.mostCurrent.activityBA,cork.mostCurrent,34);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Resume (cork) ","cork",4,cork.mostCurrent.activityBA,cork.mostCurrent,30);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","activity_resume");}
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
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
public static RemoteObject  _addstickynote(RemoteObject _text,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("AddStickyNote (cork) ","cork",4,cork.mostCurrent.activityBA,cork.mostCurrent,45);
if (RapidSub.canDelegate("addstickynote")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","addstickynote", _text, _x, _y);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _draghandle = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("Text", _text);
Debug.locals.put("x", _x);
Debug.locals.put("y", _y);
 BA.debugLineNum = 45;BA.debugLine="Sub AddStickyNote(Text As String, x As Int, y As I";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(8192);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 47;BA.debugLine="p.Initialize(\"\")";
Debug.ShouldStop(16384);
_p.runVoidMethod ("Initialize",cork.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 48;BA.debugLine="p.Color = Colors.RGB(255, 192, 203)";
Debug.ShouldStop(32768);
_p.runVoidMethod ("setColor",cork.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 192)),(Object)(BA.numberCast(int.class, 203))));
 BA.debugLineNum = 50;BA.debugLine="Dim dragHandle As Panel";
Debug.ShouldStop(131072);
_draghandle = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("dragHandle", _draghandle);
 BA.debugLineNum = 51;BA.debugLine="dragHandle.Initialize(\"Sticky\")";
Debug.ShouldStop(262144);
_draghandle.runVoidMethod ("Initialize",cork.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Sticky")));
 BA.debugLineNum = 52;BA.debugLine="dragHandle.Color = Colors.RGB(170, 51, 106)";
Debug.ShouldStop(524288);
_draghandle.runVoidMethod ("setColor",cork.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 170)),(Object)(BA.numberCast(int.class, 51)),(Object)(BA.numberCast(int.class, 106))));
 BA.debugLineNum = 53;BA.debugLine="p.AddView(dragHandle, 0, 0, 100dip, 20dip)";
Debug.ShouldStop(1048576);
_p.runVoidMethod ("AddView",(Object)((_draghandle.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 55;BA.debugLine="stickyTxt.Initialize(\"stickyTxt\")";
Debug.ShouldStop(4194304);
cork.mostCurrent._stickytxt.runVoidMethod ("Initialize",cork.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("stickyTxt")));
 BA.debugLineNum = 56;BA.debugLine="stickyTxt.Text = Text";
Debug.ShouldStop(8388608);
cork.mostCurrent._stickytxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_text));
 BA.debugLineNum = 57;BA.debugLine="stickyTxt.TextSize = 9";
Debug.ShouldStop(16777216);
cork.mostCurrent._stickytxt.runMethod(true,"setTextSize",BA.numberCast(float.class, 9));
 BA.debugLineNum = 58;BA.debugLine="stickyTxt.Background = Null";
Debug.ShouldStop(33554432);
cork.mostCurrent._stickytxt.runMethod(false,"setBackground",(cork.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 59;BA.debugLine="stickyTxt.Gravity = Gravity.TOP";
Debug.ShouldStop(67108864);
cork.mostCurrent._stickytxt.runMethod(true,"setGravity",cork.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"));
 BA.debugLineNum = 61;BA.debugLine="p.AddView(stickyTxt, 5dip, 15dip, 90dip, 70dip)";
Debug.ShouldStop(268435456);
_p.runVoidMethod ("AddView",(Object)((cork.mostCurrent._stickytxt.getObject())),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))));
 BA.debugLineNum = 63;BA.debugLine="boardPnl.AddView(p, x, y, 100dip, 100dip)";
Debug.ShouldStop(1073741824);
cork.mostCurrent._boardpnl.runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(_x),(Object)(_y),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private LastX, LastY As Float";
cork._lastx = RemoteObject.createImmutable(0f);
cork._lasty = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 16;BA.debugLine="Private boardPnl As Panel";
cork.mostCurrent._boardpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private addPnl As Panel";
cork.mostCurrent._addpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private canvaBtn As Button";
cork.mostCurrent._canvabtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private imgBtn As Button";
cork.mostCurrent._imgbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private stickyBtn As Button";
cork.mostCurrent._stickybtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private stringBtn As Button";
cork.mostCurrent._stringbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private stickyTxt As  EditText";
cork.mostCurrent._stickytxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sticky_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("Sticky_Touch (cork) ","cork",4,cork.mostCurrent.activityBA,cork.mostCurrent,67);
if (RapidSub.canDelegate("sticky_touch")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","sticky_touch", _action, _x, _y);}
RemoteObject _handle = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _wholenote = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 67;BA.debugLine="Sub Sticky_Touch (Action As Int, X As Float, Y As";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Dim handle As B4XView = Sender";
Debug.ShouldStop(8);
_handle = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_handle = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), cork.mostCurrent.__c.runMethod(false,"Sender",cork.mostCurrent.activityBA));Debug.locals.put("handle", _handle);Debug.locals.put("handle", _handle);
 BA.debugLineNum = 69;BA.debugLine="Dim wholeNote As B4XView = handle.Parent";
Debug.ShouldStop(16);
_wholenote = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_wholenote = _handle.runMethod(false,"getParent");Debug.locals.put("wholeNote", _wholenote);Debug.locals.put("wholeNote", _wholenote);
 BA.debugLineNum = 71;BA.debugLine="Select Action";
Debug.ShouldStop(64);
switch (BA.switchObjectToInt(_action,BA.numberCast(int.class, 0),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 73;BA.debugLine="LastX = X";
Debug.ShouldStop(256);
cork._lastx = _x;
 BA.debugLineNum = 74;BA.debugLine="LastY = Y";
Debug.ShouldStop(512);
cork._lasty = _y;
 BA.debugLineNum = 75;BA.debugLine="wholeNote.BringToFront";
Debug.ShouldStop(1024);
_wholenote.runVoidMethod ("BringToFront");
 break; }
case 1: {
 BA.debugLineNum = 77;BA.debugLine="wholeNote.Left = wholeNote.Left + X - LastX";
Debug.ShouldStop(4096);
_wholenote.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_wholenote.runMethod(true,"getLeft"),_x,cork._lastx}, "+-",2, 0)));
 BA.debugLineNum = 78;BA.debugLine="wholeNote.Top = wholeNote.Top + Y - LastY";
Debug.ShouldStop(8192);
_wholenote.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_wholenote.runMethod(true,"getTop"),_y,cork._lasty}, "+-",2, 0)));
 break; }
}
;
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _stickybtn_click() throws Exception{
try {
		Debug.PushSubsStack("stickyBtn_Click (cork) ","cork",4,cork.mostCurrent.activityBA,cork.mostCurrent,82);
if (RapidSub.canDelegate("stickybtn_click")) { return b4a.example.cork.remoteMe.runUserSub(false, "cork","stickybtn_click");}
RemoteObject _randomx = RemoteObject.createImmutable(0);
RemoteObject _randomy = RemoteObject.createImmutable(0);
 BA.debugLineNum = 82;BA.debugLine="Private Sub stickyBtn_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="Dim randomX As Int = Rnd(20dip, 150dip)";
Debug.ShouldStop(524288);
_randomx = cork.mostCurrent.__c.runMethod(true,"Rnd",(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));Debug.locals.put("randomX", _randomx);Debug.locals.put("randomX", _randomx);
 BA.debugLineNum = 85;BA.debugLine="Dim randomY As Int = Rnd(20dip, 150dip)";
Debug.ShouldStop(1048576);
_randomy = cork.mostCurrent.__c.runMethod(true,"Rnd",(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(cork.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)))));Debug.locals.put("randomY", _randomy);Debug.locals.put("randomY", _randomy);
 BA.debugLineNum = 86;BA.debugLine="AddStickyNote(\"\", randomX, randomY)";
Debug.ShouldStop(2097152);
_addstickynote(BA.ObjectToString(""),_randomx,_randomy);
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}