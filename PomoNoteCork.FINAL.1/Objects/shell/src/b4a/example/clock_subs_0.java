package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class clock_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,38);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"clockLayout\")";
Debug.ShouldStop(64);
clock.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("clockLayout")),clock.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(128);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 41;BA.debugLine="timerCount.Initialize(\"tmr\", 1000)";
Debug.ShouldStop(256);
clock._timercount.runVoidMethod ("Initialize",clock.processBA,(Object)(BA.ObjectToString("tmr")),(Object)(BA.numberCast(long.class, 1000)));
 };
 BA.debugLineNum = 44;BA.debugLine="timerCount.Enabled = False";
Debug.ShouldStop(2048);
clock._timercount.runMethod(true,"setEnabled",clock.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 45;BA.debugLine="updateLbl";
Debug.ShouldStop(4096);
_updatelbl();
 BA.debugLineNum = 46;BA.debugLine="pomoCounter.Text = counter";
Debug.ShouldStop(8192);
clock.mostCurrent._pomocounter.runMethod(true,"setText",BA.ObjectToCharSequence(clock._counter));
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Pause (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,53);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Resume (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,49);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","activity_resume");}
 BA.debugLineNum = 49;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
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
public static RemoteObject  _closel_click() throws Exception{
try {
		Debug.PushSubsStack("closeL_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,212);
if (RapidSub.canDelegate("closel_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","closel_click");}
 BA.debugLineNum = 212;BA.debugLine="Private Sub closeL_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 213;BA.debugLine="settingsPnl.Visible = False";
Debug.ShouldStop(1048576);
clock.mostCurrent._settingspnl.runMethod(true,"setVisible",clock.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _exitbtn_click() throws Exception{
try {
		Debug.PushSubsStack("exitBtn_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,57);
if (RapidSub.canDelegate("exitbtn_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","exitbtn_click");}
 BA.debugLineNum = 57;BA.debugLine="Private Sub exitBtn_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="Activity.Finish";
Debug.ShouldStop(33554432);
clock.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _formatbtn_click() throws Exception{
try {
		Debug.PushSubsStack("formatBtn_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,61);
if (RapidSub.canDelegate("formatbtn_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","formatbtn_click");}
 BA.debugLineNum = 61;BA.debugLine="Private Sub formatBtn_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="Main.format24h = Not(Main.format24h)";
Debug.ShouldStop(1073741824);
clock.mostCurrent._main._format24h /*RemoteObject*/  = clock.mostCurrent.__c.runMethod(true,"Not",(Object)(clock.mostCurrent._main._format24h /*RemoteObject*/ ));
 BA.debugLineNum = 65;BA.debugLine="If Main.format24h Then";
Debug.ShouldStop(1);
if (clock.mostCurrent._main._format24h /*RemoteObject*/ .<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 66;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
Debug.ShouldStop(2);
clock.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 }else {
 BA.debugLineNum = 68;BA.debugLine="DateTime.TimeFormat = \"hh:mm a\"";
Debug.ShouldStop(8);
clock.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("hh:mm a"));
 };
 BA.debugLineNum = 70;BA.debugLine="CallSub(Main, \"timerClock_Tick\")";
Debug.ShouldStop(32);
clock.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",clock.processBA,(Object)((clock.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("timerClock_Tick")));
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private pomotimerLbl As Label";
clock.mostCurrent._pomotimerlbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private playBtn As Button";
clock.mostCurrent._playbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private pomoCounter As Label";
clock.mostCurrent._pomocounter = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private settingsBtn As Button";
clock.mostCurrent._settingsbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private settingsPnl As B4XView";
clock.mostCurrent._settingspnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pomoTxt As EditText";
clock.mostCurrent._pomotxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private shortTxt As EditText";
clock.mostCurrent._shorttxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private longTxt As EditText";
clock.mostCurrent._longtxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Dim timerState As Int = 0";
clock._timerstate = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 28;BA.debugLine="Dim counter As Int = 0";
clock._counter = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 29;BA.debugLine="Dim pomoDef As Int = 300";
clock._pomodef = BA.numberCast(int.class, 300);
 //BA.debugLineNum = 30;BA.debugLine="Dim shortDef As Int = 180";
clock._shortdef = BA.numberCast(int.class, 180);
 //BA.debugLineNum = 31;BA.debugLine="Dim longDef As Int = 600";
clock._longdef = BA.numberCast(int.class, 600);
 //BA.debugLineNum = 32;BA.debugLine="Dim centerLeft As Int = 100dip";
clock._centerleft = clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)));
 //BA.debugLineNum = 33;BA.debugLine="Dim centerTop As Int = 225dip";
clock._centertop = clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 225)));
 //BA.debugLineNum = 34;BA.debugLine="Dim playing As Boolean = False";
clock._playing = clock.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _longbtn_click() throws Exception{
try {
		Debug.PushSubsStack("longBtn_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,200);
if (RapidSub.canDelegate("longbtn_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","longbtn_click");}
 BA.debugLineNum = 200;BA.debugLine="Private Sub longBtn_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 201;BA.debugLine="timerStop";
Debug.ShouldStop(256);
_timerstop();
 BA.debugLineNum = 202;BA.debugLine="secondsRemain = longDef";
Debug.ShouldStop(512);
clock._secondsremain = clock._longdef;
 BA.debugLineNum = 203;BA.debugLine="timerState = 1";
Debug.ShouldStop(1024);
clock._timerstate = BA.numberCast(int.class, 1);
 BA.debugLineNum = 204;BA.debugLine="updateLbl";
Debug.ShouldStop(2048);
_updatelbl();
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _playbtn_click() throws Exception{
try {
		Debug.PushSubsStack("playBtn_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,74);
if (RapidSub.canDelegate("playbtn_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","playbtn_click");}
 BA.debugLineNum = 74;BA.debugLine="Private Sub playBtn_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="If secondsRemain > 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",clock._secondsremain,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 76;BA.debugLine="timerCount.Enabled = True";
Debug.ShouldStop(2048);
clock._timercount.runMethod(true,"setEnabled",clock.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 78;BA.debugLine="If playing = True Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",clock._playing,clock.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 79;BA.debugLine="timerCount.Enabled = False";
Debug.ShouldStop(16384);
clock._timercount.runMethod(true,"setEnabled",clock.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 80;BA.debugLine="playing = False";
Debug.ShouldStop(32768);
clock._playing = clock.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 81;BA.debugLine="playBtn.Text = \"Start\"";
Debug.ShouldStop(65536);
clock.mostCurrent._playbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Start"));
 }else {
 BA.debugLineNum = 83;BA.debugLine="timerCount.Enabled = True";
Debug.ShouldStop(262144);
clock._timercount.runMethod(true,"setEnabled",clock.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 84;BA.debugLine="playing = True";
Debug.ShouldStop(524288);
clock._playing = clock.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 85;BA.debugLine="playBtn.Text = \"Pause\"";
Debug.ShouldStop(1048576);
clock.mostCurrent._playbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Pause"));
 };
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pomobtn_click() throws Exception{
try {
		Debug.PushSubsStack("pomoBtn_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,186);
if (RapidSub.canDelegate("pomobtn_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","pomobtn_click");}
 BA.debugLineNum = 186;BA.debugLine="Private Sub pomoBtn_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 187;BA.debugLine="timerStop";
Debug.ShouldStop(67108864);
_timerstop();
 BA.debugLineNum = 188;BA.debugLine="secondsRemain = pomoDef";
Debug.ShouldStop(134217728);
clock._secondsremain = clock._pomodef;
 BA.debugLineNum = 189;BA.debugLine="timerState = 0";
Debug.ShouldStop(268435456);
clock._timerstate = BA.numberCast(int.class, 0);
 BA.debugLineNum = 190;BA.debugLine="updateLbl";
Debug.ShouldStop(536870912);
_updatelbl();
 BA.debugLineNum = 191;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
 //BA.debugLineNum = 9;BA.debugLine="Private timerCount As Timer";
clock._timercount = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
clock._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 11;BA.debugLine="Private secondsRemain As Int = 5";
clock._secondsremain = BA.numberCast(int.class, 5);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _savebtn_click() throws Exception{
try {
		Debug.PushSubsStack("saveBtn_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,216);
if (RapidSub.canDelegate("savebtn_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","savebtn_click");}
 BA.debugLineNum = 216;BA.debugLine="Private Sub saveBtn_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 218;BA.debugLine="If IsNumber(pomoTxt.Text) Then pomoDef = pomoTxt.";
Debug.ShouldStop(33554432);
if (clock.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(clock.mostCurrent._pomotxt.runMethod(true,"getText"))).<Boolean>get().booleanValue()) { 
clock._pomodef = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, clock.mostCurrent._pomotxt.runMethod(true,"getText")),RemoteObject.createImmutable(60)}, "*",0, 0));};
 BA.debugLineNum = 219;BA.debugLine="If IsNumber(shortTxt.Text) Then shortDef = shortT";
Debug.ShouldStop(67108864);
if (clock.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(clock.mostCurrent._shorttxt.runMethod(true,"getText"))).<Boolean>get().booleanValue()) { 
clock._shortdef = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, clock.mostCurrent._shorttxt.runMethod(true,"getText")),RemoteObject.createImmutable(60)}, "*",0, 0));};
 BA.debugLineNum = 220;BA.debugLine="If IsNumber(longTxt.Text) Then longDef = longTxt.";
Debug.ShouldStop(134217728);
if (clock.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(clock.mostCurrent._longtxt.runMethod(true,"getText"))).<Boolean>get().booleanValue()) { 
clock._longdef = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, clock.mostCurrent._longtxt.runMethod(true,"getText")),RemoteObject.createImmutable(60)}, "*",0, 0));};
 BA.debugLineNum = 222;BA.debugLine="If timerState = 0 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",clock._timerstate,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 223;BA.debugLine="secondsRemain = pomoDef";
Debug.ShouldStop(1073741824);
clock._secondsremain = clock._pomodef;
 }else {
 BA.debugLineNum = 226;BA.debugLine="If counter Mod 4 = 0 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {clock._counter,RemoteObject.createImmutable(4)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 227;BA.debugLine="secondsRemain = longDef";
Debug.ShouldStop(4);
clock._secondsremain = clock._longdef;
 }else {
 BA.debugLineNum = 229;BA.debugLine="secondsRemain = shortDef";
Debug.ShouldStop(16);
clock._secondsremain = clock._shortdef;
 };
 };
 BA.debugLineNum = 232;BA.debugLine="updateLbl";
Debug.ShouldStop(128);
_updatelbl();
 BA.debugLineNum = 233;BA.debugLine="settingsPnl.Visible = False";
Debug.ShouldStop(256);
clock.mostCurrent._settingspnl.runMethod(true,"setVisible",clock.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 234;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _settingsbtn_click() throws Exception{
try {
		Debug.PushSubsStack("settingsBtn_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,207);
if (RapidSub.canDelegate("settingsbtn_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","settingsbtn_click");}
 BA.debugLineNum = 207;BA.debugLine="Private Sub settingsBtn_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 208;BA.debugLine="settingsWindow(250dip, 180dip)";
Debug.ShouldStop(32768);
_settingswindow(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))),clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 180))));
 BA.debugLineNum = 209;BA.debugLine="settingsPnl.Visible = True";
Debug.ShouldStop(65536);
clock.mostCurrent._settingspnl.runMethod(true,"setVisible",clock.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _settingswindow(RemoteObject _pw,RemoteObject _ph) throws Exception{
try {
		Debug.PushSubsStack("settingsWindow (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,125);
if (RapidSub.canDelegate("settingswindow")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","settingswindow", _pw, _ph);}
RemoteObject _lblp = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lbls = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lbll = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _closel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _savebtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("pW", _pw);
Debug.locals.put("pH", _ph);
 BA.debugLineNum = 125;BA.debugLine="Private Sub settingsWindow(pW As Int, pH As Int)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="settingsPnl = xui.CreatePanel(\"settingsPnl\")";
Debug.ShouldStop(536870912);
clock.mostCurrent._settingspnl = clock._xui.runMethod(false,"CreatePanel",clock.processBA,(Object)(RemoteObject.createImmutable("settingsPnl")));
 BA.debugLineNum = 127;BA.debugLine="Activity.AddView(settingsPnl, centerLeft, centerT";
Debug.ShouldStop(1073741824);
clock.mostCurrent._activity.runVoidMethod ("AddView",(Object)((clock.mostCurrent._settingspnl.getObject())),(Object)(clock._centerleft),(Object)(clock._centertop),(Object)(_pw),(Object)(_ph));
 BA.debugLineNum = 128;BA.debugLine="settingsPnl.Color = xui.Color_RGB(50, 50, 50)";
Debug.ShouldStop(-2147483648);
clock.mostCurrent._settingspnl.runMethod(true,"setColor",clock._xui.runMethod(true,"Color_RGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 129;BA.debugLine="settingsPnl.SetColorAndBorder(xui.Color_White, 2d";
Debug.ShouldStop(1);
clock.mostCurrent._settingspnl.runVoidMethod ("SetColorAndBorder",(Object)(clock._xui.getField(true,"Color_White")),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(clock._xui.getField(true,"Color_Black")),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 130;BA.debugLine="settingsPnl.Enabled = False";
Debug.ShouldStop(2);
clock.mostCurrent._settingspnl.runMethod(true,"setEnabled",clock.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 131;BA.debugLine="settingsPnl.Visible = False";
Debug.ShouldStop(4);
clock.mostCurrent._settingspnl.runMethod(true,"setVisible",clock.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 133;BA.debugLine="pomoTxt.Initialize(\"pomoTxt\")";
Debug.ShouldStop(16);
clock.mostCurrent._pomotxt.runVoidMethod ("Initialize",clock.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("pomoTxt")));
 BA.debugLineNum = 134;BA.debugLine="pomoTxt.Hint = \"Pomo\"";
Debug.ShouldStop(32);
clock.mostCurrent._pomotxt.runMethod(true,"setHint",BA.ObjectToString("Pomo"));
 BA.debugLineNum = 135;BA.debugLine="pomoTxt.InputType = pomoTxt.INPUT_TYPE_NUMBERS";
Debug.ShouldStop(64);
clock.mostCurrent._pomotxt.runMethod(true,"setInputType",clock.mostCurrent._pomotxt.getField(true,"INPUT_TYPE_NUMBERS"));
 BA.debugLineNum = 136;BA.debugLine="pomoTxt.Text = pomoDef / 60";
Debug.ShouldStop(128);
clock.mostCurrent._pomotxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {clock._pomodef,RemoteObject.createImmutable(60)}, "/",0, 0)));
 BA.debugLineNum = 137;BA.debugLine="pomoTxt.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(256);
clock.mostCurrent._pomotxt.runMethod(true,"setGravity",clock.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 138;BA.debugLine="settingsPnl.AddView(pomoTxt, 10dip, 40dip, 70dip,";
Debug.ShouldStop(512);
clock.mostCurrent._settingspnl.runVoidMethod ("AddView",(Object)((clock.mostCurrent._pomotxt.getObject())),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 140;BA.debugLine="shortTxt.Initialize(\"shortTxt\")";
Debug.ShouldStop(2048);
clock.mostCurrent._shorttxt.runVoidMethod ("Initialize",clock.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("shortTxt")));
 BA.debugLineNum = 141;BA.debugLine="shortTxt.Hint = \"Short\"";
Debug.ShouldStop(4096);
clock.mostCurrent._shorttxt.runMethod(true,"setHint",BA.ObjectToString("Short"));
 BA.debugLineNum = 142;BA.debugLine="shortTxt.InputType = shortTxt.INPUT_TYPE_NUMBERS";
Debug.ShouldStop(8192);
clock.mostCurrent._shorttxt.runMethod(true,"setInputType",clock.mostCurrent._shorttxt.getField(true,"INPUT_TYPE_NUMBERS"));
 BA.debugLineNum = 143;BA.debugLine="shortTxt.Text = shortDef / 60";
Debug.ShouldStop(16384);
clock.mostCurrent._shorttxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {clock._shortdef,RemoteObject.createImmutable(60)}, "/",0, 0)));
 BA.debugLineNum = 144;BA.debugLine="shortTxt.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(32768);
clock.mostCurrent._shorttxt.runMethod(true,"setGravity",clock.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 145;BA.debugLine="settingsPnl.AddView(shortTxt, 90dip, 40dip, 70dip";
Debug.ShouldStop(65536);
clock.mostCurrent._settingspnl.runVoidMethod ("AddView",(Object)((clock.mostCurrent._shorttxt.getObject())),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 147;BA.debugLine="longTxt.Initialize(\"longTxt\")";
Debug.ShouldStop(262144);
clock.mostCurrent._longtxt.runVoidMethod ("Initialize",clock.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("longTxt")));
 BA.debugLineNum = 148;BA.debugLine="longTxt.Hint = \"Long\"";
Debug.ShouldStop(524288);
clock.mostCurrent._longtxt.runMethod(true,"setHint",BA.ObjectToString("Long"));
 BA.debugLineNum = 149;BA.debugLine="longTxt.InputType = longTxt.INPUT_TYPE_NUMBERS";
Debug.ShouldStop(1048576);
clock.mostCurrent._longtxt.runMethod(true,"setInputType",clock.mostCurrent._longtxt.getField(true,"INPUT_TYPE_NUMBERS"));
 BA.debugLineNum = 150;BA.debugLine="longTxt.Text = longDef / 60";
Debug.ShouldStop(2097152);
clock.mostCurrent._longtxt.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.solve(new RemoteObject[] {clock._longdef,RemoteObject.createImmutable(60)}, "/",0, 0)));
 BA.debugLineNum = 151;BA.debugLine="longTxt.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(4194304);
clock.mostCurrent._longtxt.runMethod(true,"setGravity",clock.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 152;BA.debugLine="settingsPnl.AddView(longTxt, 170dip, 40dip, 70dip";
Debug.ShouldStop(8388608);
clock.mostCurrent._settingspnl.runVoidMethod ("AddView",(Object)((clock.mostCurrent._longtxt.getObject())),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 170)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 154;BA.debugLine="Dim lblP, lblS, lblL As Label";
Debug.ShouldStop(33554432);
_lblp = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblP", _lblp);
_lbls = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblS", _lbls);
_lbll = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lblL", _lbll);
 BA.debugLineNum = 156;BA.debugLine="lblP.Initialize(\"\")";
Debug.ShouldStop(134217728);
_lblp.runVoidMethod ("Initialize",clock.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 157;BA.debugLine="lblP.Text = \"Pomo\"";
Debug.ShouldStop(268435456);
_lblp.runMethod(true,"setText",BA.ObjectToCharSequence("Pomo"));
 BA.debugLineNum = 158;BA.debugLine="lblP.TextSize = 12";
Debug.ShouldStop(536870912);
_lblp.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 159;BA.debugLine="lblP.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(1073741824);
_lblp.runMethod(true,"setGravity",clock.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 160;BA.debugLine="settingsPnl.AddView(lblP, 10dip, 80dip, 70dip, 20";
Debug.ShouldStop(-2147483648);
clock.mostCurrent._settingspnl.runVoidMethod ("AddView",(Object)((_lblp.getObject())),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 162;BA.debugLine="lblS.Initialize(\"\")";
Debug.ShouldStop(2);
_lbls.runVoidMethod ("Initialize",clock.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 163;BA.debugLine="lblS.Text = \"Short\"";
Debug.ShouldStop(4);
_lbls.runMethod(true,"setText",BA.ObjectToCharSequence("Short"));
 BA.debugLineNum = 164;BA.debugLine="lblS.TextSize = 12";
Debug.ShouldStop(8);
_lbls.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 165;BA.debugLine="lblS.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(16);
_lbls.runMethod(true,"setGravity",clock.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 166;BA.debugLine="settingsPnl.AddView(lblS, 90dip, 80dip, 70dip, 20";
Debug.ShouldStop(32);
clock.mostCurrent._settingspnl.runVoidMethod ("AddView",(Object)((_lbls.getObject())),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 90)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 168;BA.debugLine="lblL.Initialize(\"\")";
Debug.ShouldStop(128);
_lbll.runVoidMethod ("Initialize",clock.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 169;BA.debugLine="lblL.Text = \"Long\"";
Debug.ShouldStop(256);
_lbll.runMethod(true,"setText",BA.ObjectToCharSequence("Long"));
 BA.debugLineNum = 170;BA.debugLine="lblL.TextSize = 12";
Debug.ShouldStop(512);
_lbll.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 171;BA.debugLine="lblL.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(1024);
_lbll.runMethod(true,"setGravity",clock.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 172;BA.debugLine="settingsPnl.AddView(lblL, 170dip, 80dip, 70dip, 2";
Debug.ShouldStop(2048);
clock.mostCurrent._settingspnl.runVoidMethod ("AddView",(Object)((_lbll.getObject())),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 170)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 174;BA.debugLine="Dim closeL As Label";
Debug.ShouldStop(8192);
_closel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("closeL", _closel);
 BA.debugLineNum = 175;BA.debugLine="closeL.Initialize(\"closeL\")";
Debug.ShouldStop(16384);
_closel.runVoidMethod ("Initialize",clock.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("closeL")));
 BA.debugLineNum = 176;BA.debugLine="settingsPnl.AddView(closeL, 10dip, 10dip, 20dip,";
Debug.ShouldStop(32768);
clock.mostCurrent._settingspnl.runVoidMethod ("AddView",(Object)((_closel.getObject())),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 177;BA.debugLine="closeL.Text = \"X\"";
Debug.ShouldStop(65536);
_closel.runMethod(true,"setText",BA.ObjectToCharSequence("X"));
 BA.debugLineNum = 179;BA.debugLine="Dim saveBtn As Button";
Debug.ShouldStop(262144);
_savebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("saveBtn", _savebtn);
 BA.debugLineNum = 180;BA.debugLine="saveBtn.Initialize(\"saveBtn\")";
Debug.ShouldStop(524288);
_savebtn.runVoidMethod ("Initialize",clock.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("saveBtn")));
 BA.debugLineNum = 181;BA.debugLine="saveBtn.Text = \"Save Settings\"";
Debug.ShouldStop(1048576);
_savebtn.runMethod(true,"setText",BA.ObjectToCharSequence("Save Settings"));
 BA.debugLineNum = 182;BA.debugLine="settingsPnl.AddView(saveBtn, 10dip, 130dip, 230di";
Debug.ShouldStop(2097152);
clock.mostCurrent._settingspnl.runVoidMethod ("AddView",(Object)((_savebtn.getObject())),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 130)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 230)))),(Object)(clock.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _shortbtn_click() throws Exception{
try {
		Debug.PushSubsStack("shortBtn_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,193);
if (RapidSub.canDelegate("shortbtn_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","shortbtn_click");}
 BA.debugLineNum = 193;BA.debugLine="Private Sub shortBtn_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="timerStop";
Debug.ShouldStop(2);
_timerstop();
 BA.debugLineNum = 195;BA.debugLine="secondsRemain = shortDef";
Debug.ShouldStop(4);
clock._secondsremain = clock._shortdef;
 BA.debugLineNum = 196;BA.debugLine="timerState = 1";
Debug.ShouldStop(8);
clock._timerstate = BA.numberCast(int.class, 1);
 BA.debugLineNum = 197;BA.debugLine="updateLbl";
Debug.ShouldStop(16);
_updatelbl();
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _skipbtn_click() throws Exception{
try {
		Debug.PushSubsStack("skipBtn_Click (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,236);
if (RapidSub.canDelegate("skipbtn_click")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","skipbtn_click");}
 BA.debugLineNum = 236;BA.debugLine="Private Sub skipBtn_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 237;BA.debugLine="If timerState = 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",clock._timerstate,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 238;BA.debugLine="counter = counter + 1";
Debug.ShouldStop(8192);
clock._counter = RemoteObject.solve(new RemoteObject[] {clock._counter,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 240;BA.debugLine="If counter Mod 4 = 0 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {clock._counter,RemoteObject.createImmutable(4)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 241;BA.debugLine="secondsRemain = longDef";
Debug.ShouldStop(65536);
clock._secondsremain = clock._longdef;
 }else {
 BA.debugLineNum = 243;BA.debugLine="secondsRemain = shortDef";
Debug.ShouldStop(262144);
clock._secondsremain = clock._shortdef;
 };
 BA.debugLineNum = 245;BA.debugLine="timerState = 1";
Debug.ShouldStop(1048576);
clock._timerstate = BA.numberCast(int.class, 1);
 }else 
{ BA.debugLineNum = 247;BA.debugLine="Else If timerState = 1 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",clock._timerstate,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 248;BA.debugLine="secondsRemain = pomoDef";
Debug.ShouldStop(8388608);
clock._secondsremain = clock._pomodef;
 BA.debugLineNum = 249;BA.debugLine="timerState = 0";
Debug.ShouldStop(16777216);
clock._timerstate = BA.numberCast(int.class, 0);
 }}
;
 BA.debugLineNum = 252;BA.debugLine="updateLbl";
Debug.ShouldStop(134217728);
_updatelbl();
 BA.debugLineNum = 253;BA.debugLine="timerCount.Enabled = False";
Debug.ShouldStop(268435456);
clock._timercount.runMethod(true,"setEnabled",clock.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 254;BA.debugLine="playing = False";
Debug.ShouldStop(536870912);
clock._playing = clock.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 255;BA.debugLine="playBtn.Text = \"Start\"";
Debug.ShouldStop(1073741824);
clock.mostCurrent._playbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Start"));
 BA.debugLineNum = 256;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timerstop() throws Exception{
try {
		Debug.PushSubsStack("timerStop (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,258);
if (RapidSub.canDelegate("timerstop")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","timerstop");}
 BA.debugLineNum = 258;BA.debugLine="Private Sub timerStop";
Debug.ShouldStop(2);
 BA.debugLineNum = 259;BA.debugLine="timerCount.Enabled = False";
Debug.ShouldStop(4);
clock._timercount.runMethod(true,"setEnabled",clock.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 260;BA.debugLine="playing = False";
Debug.ShouldStop(8);
clock._playing = clock.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 261;BA.debugLine="playBtn.Text = \"Start\"";
Debug.ShouldStop(16);
clock.mostCurrent._playbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Start"));
 BA.debugLineNum = 262;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tmr_tick() throws Exception{
try {
		Debug.PushSubsStack("tmr_Tick (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,90);
if (RapidSub.canDelegate("tmr_tick")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","tmr_tick");}
 BA.debugLineNum = 90;BA.debugLine="Sub tmr_Tick";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="If secondsRemain > 0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",clock._secondsremain,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 92;BA.debugLine="secondsRemain = secondsRemain - 1";
Debug.ShouldStop(134217728);
clock._secondsremain = RemoteObject.solve(new RemoteObject[] {clock._secondsremain,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 93;BA.debugLine="updateLbl";
Debug.ShouldStop(268435456);
_updatelbl();
 }else {
 BA.debugLineNum = 95;BA.debugLine="timerCount.Enabled = False";
Debug.ShouldStop(1073741824);
clock._timercount.runMethod(true,"setEnabled",clock.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 96;BA.debugLine="playBtn.Enabled = True";
Debug.ShouldStop(-2147483648);
clock.mostCurrent._playbtn.runMethod(true,"setEnabled",clock.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 99;BA.debugLine="If timerState = 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",clock._timerstate,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 100;BA.debugLine="counter = counter + 1";
Debug.ShouldStop(8);
clock._counter = RemoteObject.solve(new RemoteObject[] {clock._counter,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 102;BA.debugLine="If counter Mod 4 = 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {clock._counter,RemoteObject.createImmutable(4)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 103;BA.debugLine="secondsRemain = longDef";
Debug.ShouldStop(64);
clock._secondsremain = clock._longdef;
 }else {
 BA.debugLineNum = 105;BA.debugLine="secondsRemain = shortDef";
Debug.ShouldStop(256);
clock._secondsremain = clock._shortdef;
 };
 BA.debugLineNum = 107;BA.debugLine="timerState = 1";
Debug.ShouldStop(1024);
clock._timerstate = BA.numberCast(int.class, 1);
 }else 
{ BA.debugLineNum = 109;BA.debugLine="Else If timerState = 1 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",clock._timerstate,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 110;BA.debugLine="secondsRemain = pomoDef";
Debug.ShouldStop(8192);
clock._secondsremain = clock._pomodef;
 BA.debugLineNum = 111;BA.debugLine="timerState = 0";
Debug.ShouldStop(16384);
clock._timerstate = BA.numberCast(int.class, 0);
 }}
;
 BA.debugLineNum = 114;BA.debugLine="updateLbl";
Debug.ShouldStop(131072);
_updatelbl();
 };
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
public static RemoteObject  _updatelbl() throws Exception{
try {
		Debug.PushSubsStack("updateLbl (clock) ","clock",2,clock.mostCurrent.activityBA,clock.mostCurrent,118);
if (RapidSub.canDelegate("updatelbl")) { return b4a.example.clock.remoteMe.runUserSub(false, "clock","updatelbl");}
RemoteObject _mins = RemoteObject.createImmutable(0);
RemoteObject _secs = RemoteObject.createImmutable(0);
 BA.debugLineNum = 118;BA.debugLine="Sub updateLbl";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 119;BA.debugLine="Dim mins As Int = secondsRemain / 60";
Debug.ShouldStop(4194304);
_mins = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {clock._secondsremain,RemoteObject.createImmutable(60)}, "/",0, 0));Debug.locals.put("mins", _mins);Debug.locals.put("mins", _mins);
 BA.debugLineNum = 120;BA.debugLine="Dim secs As Int = secondsRemain Mod 60";
Debug.ShouldStop(8388608);
_secs = RemoteObject.solve(new RemoteObject[] {clock._secondsremain,RemoteObject.createImmutable(60)}, "%",0, 1);Debug.locals.put("secs", _secs);Debug.locals.put("secs", _secs);
 BA.debugLineNum = 121;BA.debugLine="pomotimerLbl.Text = $\"$02.0{mins}:$02.0{secs}\"$";
Debug.ShouldStop(16777216);
clock.mostCurrent._pomotimerlbl.runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable(""),clock.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("02.0")),(Object)((_mins))),RemoteObject.createImmutable(":"),clock.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("02.0")),(Object)((_secs))),RemoteObject.createImmutable("")))));
 BA.debugLineNum = 122;BA.debugLine="pomoCounter.Text = counter";
Debug.ShouldStop(33554432);
clock.mostCurrent._pomocounter.runMethod(true,"setText",BA.ObjectToCharSequence(clock._counter));
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}