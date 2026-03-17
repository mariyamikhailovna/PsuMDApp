package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class active_recall_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (active_recall) ","active_recall",6,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","activity_create", _firsttime);}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"Layout5\")";
Debug.ShouldStop(134217728);
active_recall.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout5")),active_recall.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="Dim tappeddeck As Map = Main.deck.Get(Main.select";
Debug.ShouldStop(1073741824);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), active_recall.mostCurrent._main._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((active_recall.mostCurrent._main._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappeddeck", _tappeddeck);Debug.locals.put("tappeddeck", _tappeddeck);
 BA.debugLineNum = 33;BA.debugLine="cards = tappeddeck.Get(Subdeck_Module.selectedsub";
Debug.ShouldStop(1);
active_recall.mostCurrent._cards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _tappeddeck.runMethod(false,"Get",(Object)((active_recall.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ))));
 BA.debugLineNum = 35;BA.debugLine="currentindex = 0";
Debug.ShouldStop(4);
active_recall._currentindex = BA.numberCast(int.class, 0);
 BA.debugLineNum = 36;BA.debugLine="DeckName_Label.text = Subdeck_Module.selectedsubd";
Debug.ShouldStop(8);
active_recall.mostCurrent._deckname_label.runMethod(true,"setText",BA.ObjectToCharSequence(active_recall.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ));
 BA.debugLineNum = 39;BA.debugLine="ShowCard";
Debug.ShouldStop(64);
_showcard();
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("Activity_Pause (active_recall) ","active_recall",6,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,57);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (active_recall) ","active_recall",6,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,53);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","activity_resume");}
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backbtn_Click (active_recall) ","active_recall",6,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,97);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","backbtn_click");}
 BA.debugLineNum = 97;BA.debugLine="Private Sub backbtn_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 99;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(4);
active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 BA.debugLineNum = 100;BA.debugLine="currentindex = currentindex -1";
Debug.ShouldStop(8);
active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {active_recall._currentindex,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 101;BA.debugLine="If currentindex < 0 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("<",active_recall._currentindex,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 102;BA.debugLine="currentindex = cards.Size -1";
Debug.ShouldStop(32);
active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {active_recall.mostCurrent._cards.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1);
 };
 BA.debugLineNum = 105;BA.debugLine="ShowCard";
Debug.ShouldStop(256);
_showcard();
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
 //BA.debugLineNum = 16;BA.debugLine="Private DeckName_Label As Label";
active_recall.mostCurrent._deckname_label = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Question As Label";
active_recall.mostCurrent._question = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private Answer As Label";
active_recall.mostCurrent._answer = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim cards As List";
active_recall.mostCurrent._cards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 21;BA.debugLine="Dim currentindex As Int 'to find the current inde";
active_recall._currentindex = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="Private showAnswerbtn As Button";
active_recall.mostCurrent._showanswerbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _goback_click() throws Exception{
try {
		Debug.PushSubsStack("goback_Click (active_recall) ","active_recall",6,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,92);
if (RapidSub.canDelegate("goback_click")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","goback_click");}
 BA.debugLineNum = 92;BA.debugLine="Private Sub goback_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 94;BA.debugLine="Activity.finish";
Debug.ShouldStop(536870912);
active_recall.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("nextbtn_Click (active_recall) ","active_recall",6,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,81);
if (RapidSub.canDelegate("nextbtn_click")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","nextbtn_click");}
 BA.debugLineNum = 81;BA.debugLine="Private Sub nextbtn_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 83;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(262144);
active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 BA.debugLineNum = 84;BA.debugLine="currentindex = currentindex +1";
Debug.ShouldStop(524288);
active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {active_recall._currentindex,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 86;BA.debugLine="If currentindex >= cards.Size Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("g",active_recall._currentindex,BA.numberCast(double.class, active_recall.mostCurrent._cards.runMethod(true,"getSize")))) { 
 BA.debugLineNum = 87;BA.debugLine="currentindex = 0";
Debug.ShouldStop(4194304);
active_recall._currentindex = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 89;BA.debugLine="ShowCard";
Debug.ShouldStop(16777216);
_showcard();
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showanswerbtn_click() throws Exception{
try {
		Debug.PushSubsStack("showAnswerbtn_Click (active_recall) ","active_recall",6,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,62);
if (RapidSub.canDelegate("showanswerbtn_click")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","showanswerbtn_click");}
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 62;BA.debugLine="Private Sub showAnswerbtn_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 65;BA.debugLine="Dim card As Map = cards.Get(currentindex)";
Debug.ShouldStop(1);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), active_recall.mostCurrent._cards.runMethod(false,"Get",(Object)(active_recall._currentindex)));Debug.locals.put("card", _card);Debug.locals.put("card", _card);
 BA.debugLineNum = 67;BA.debugLine="If showAnswerbtn.Text = \"Show Answer\" Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",active_recall.mostCurrent._showanswerbtn.runMethod(true,"getText"),BA.ObjectToString("Show Answer"))) { 
 BA.debugLineNum = 69;BA.debugLine="Answer.Text = card.Get(\"A\")";
Debug.ShouldStop(16);
active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("A"))))));
 BA.debugLineNum = 70;BA.debugLine="showAnswerbtn.Text = \"Hide Answer\"";
Debug.ShouldStop(32);
active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Hide Answer"));
 }else {
 BA.debugLineNum = 73;BA.debugLine="Answer.Text = \"\"";
Debug.ShouldStop(256);
active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 74;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(512);
active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 };
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showcard() throws Exception{
try {
		Debug.PushSubsStack("ShowCard (active_recall) ","active_recall",6,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,43);
if (RapidSub.canDelegate("showcard")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","showcard");}
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 43;BA.debugLine="Sub ShowCard";
Debug.ShouldStop(1024);
 BA.debugLineNum = 46;BA.debugLine="Dim card As Map = cards.Get(currentindex)";
Debug.ShouldStop(8192);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), active_recall.mostCurrent._cards.runMethod(false,"Get",(Object)(active_recall._currentindex)));Debug.locals.put("card", _card);Debug.locals.put("card", _card);
 BA.debugLineNum = 48;BA.debugLine="Question.Text = card.Get(\"Q\")";
Debug.ShouldStop(32768);
active_recall.mostCurrent._question.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Q"))))));
 BA.debugLineNum = 49;BA.debugLine="Answer.Text = \"\"";
Debug.ShouldStop(65536);
active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}