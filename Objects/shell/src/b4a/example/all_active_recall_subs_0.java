package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class all_active_recall_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","activity_create", _firsttime);}
RemoteObject _chosendeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _subdeckname = RemoteObject.createImmutable("");
RemoteObject _subcards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _newcard = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="If Starter.darkMode = False Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",all_active_recall.mostCurrent._starter._darkmode /*RemoteObject*/ ,all_active_recall.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"AARLayout\")";
Debug.ShouldStop(268435456);
all_active_recall.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("AARLayout")),all_active_recall.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"AARLayoutDark\")";
Debug.ShouldStop(1073741824);
all_active_recall.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("AARLayoutDark")),all_active_recall.mostCurrent.activityBA);
 };
 BA.debugLineNum = 34;BA.debugLine="cards.Initialize";
Debug.ShouldStop(2);
all_active_recall.mostCurrent._cards.runVoidMethod ("Initialize");
 BA.debugLineNum = 35;BA.debugLine="RndSeed(DateTime.Now) 'seeding randomizer";
Debug.ShouldStop(4);
all_active_recall.mostCurrent.__c.runVoidMethod ("RndSeed",(Object)(all_active_recall.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));
 BA.debugLineNum = 38;BA.debugLine="Dim chosendeck As Map = FlashcardActivity.deck.Ge";
Debug.ShouldStop(32);
_chosendeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_chosendeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), all_active_recall.mostCurrent._flashcardactivity._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((all_active_recall.mostCurrent._flashcardactivity._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("chosendeck", _chosendeck);Debug.locals.put("chosendeck", _chosendeck);
 BA.debugLineNum = 39;BA.debugLine="For Each subdeckname As String In chosendeck.Keys";
Debug.ShouldStop(64);
{
final RemoteObject group9 = _chosendeck.runMethod(false,"Keys");
final int groupLen9 = group9.runMethod(true,"getSize").<Integer>get()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_subdeckname = BA.ObjectToString(group9.runMethod(false,"Get",index9));Debug.locals.put("subdeckname", _subdeckname);
Debug.locals.put("subdeckname", _subdeckname);
 BA.debugLineNum = 40;BA.debugLine="Dim subcards As List = chosendeck.Get(subdecknam";
Debug.ShouldStop(128);
_subcards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_subcards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _chosendeck.runMethod(false,"Get",(Object)((_subdeckname))));Debug.locals.put("subcards", _subcards);Debug.locals.put("subcards", _subcards);
 BA.debugLineNum = 41;BA.debugLine="For Each card As Map In subcards";
Debug.ShouldStop(256);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group11 = _subcards;
final int groupLen11 = group11.runMethod(true,"getSize").<Integer>get()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group11.runMethod(false,"Get",index11));Debug.locals.put("card", _card);
Debug.locals.put("card", _card);
 BA.debugLineNum = 42;BA.debugLine="Dim newcard As Map";
Debug.ShouldStop(512);
_newcard = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("newcard", _newcard);
 BA.debugLineNum = 43;BA.debugLine="newcard.Initialize";
Debug.ShouldStop(1024);
_newcard.runVoidMethod ("Initialize");
 BA.debugLineNum = 44;BA.debugLine="newcard.Put(\"Q\", card.Get(\"Q\"))";
Debug.ShouldStop(2048);
_newcard.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Q"))),(Object)(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Q"))))));
 BA.debugLineNum = 45;BA.debugLine="newcard.Put(\"A\", card.Get(\"A\"))";
Debug.ShouldStop(4096);
_newcard.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("A"))),(Object)(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("A"))))));
 BA.debugLineNum = 46;BA.debugLine="newcard.Put(\"subdeck\", subdeckname) 'get subdec";
Debug.ShouldStop(8192);
_newcard.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("subdeck"))),(Object)((_subdeckname)));
 BA.debugLineNum = 47;BA.debugLine="cards.Add(newcard)";
Debug.ShouldStop(16384);
all_active_recall.mostCurrent._cards.runVoidMethod ("Add",(Object)((_newcard.getObject())));
 }
}Debug.locals.put("card", _card);
;
 }
}Debug.locals.put("subdeckname", _subdeckname);
;
 BA.debugLineNum = 51;BA.debugLine="ShuffleCards(cards)";
Debug.ShouldStop(262144);
_shufflecards(all_active_recall.mostCurrent._cards);
 BA.debugLineNum = 52;BA.debugLine="currentindex = 0";
Debug.ShouldStop(524288);
all_active_recall._currentindex = BA.numberCast(int.class, 0);
 BA.debugLineNum = 54;BA.debugLine="Showcard";
Debug.ShouldStop(2097152);
_showcard();
 BA.debugLineNum = 55;BA.debugLine="ShowProgress";
Debug.ShouldStop(4194304);
_showprogress();
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,89);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 89;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 91;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,85);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","activity_resume");}
 BA.debugLineNum = 85;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backbtn_Click (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,108);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","backbtn_click");}
 BA.debugLineNum = 108;BA.debugLine="Private Sub backbtn_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 110;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(8192);
all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 BA.debugLineNum = 111;BA.debugLine="If currentindex = 0 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",all_active_recall._currentindex,BA.numberCast(double.class, 0))) { 
 }else {
 BA.debugLineNum = 114;BA.debugLine="currentindex = currentindex-1";
Debug.ShouldStop(131072);
all_active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {all_active_recall._currentindex,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 115;BA.debugLine="Showcard";
Debug.ShouldStop(262144);
_showcard();
 };
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
 //BA.debugLineNum = 15;BA.debugLine="Dim cards As List";
all_active_recall.mostCurrent._cards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 16;BA.debugLine="Dim currentindex As Int";
all_active_recall._currentindex = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 17;BA.debugLine="Private Question As Label";
all_active_recall.mostCurrent._question = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private Answer As Label";
all_active_recall.mostCurrent._answer = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private DeckName_Label As Label";
all_active_recall.mostCurrent._deckname_label = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private showAnswerbtn As Button";
all_active_recall.mostCurrent._showanswerbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private pb As ProgressBar";
all_active_recall.mostCurrent._pb = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private Progress As Label";
all_active_recall.mostCurrent._progress = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private nextbtn As Button";
all_active_recall.mostCurrent._nextbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _goback_click() throws Exception{
try {
		Debug.PushSubsStack("goback_Click (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,135);
if (RapidSub.canDelegate("goback_click")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","goback_click");}
 BA.debugLineNum = 135;BA.debugLine="Private Sub goback_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 136;BA.debugLine="Activity.finish";
Debug.ShouldStop(128);
all_active_recall.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("nextbtn_Click (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,119);
if (RapidSub.canDelegate("nextbtn_click")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","nextbtn_click");}
 BA.debugLineNum = 119;BA.debugLine="Private Sub nextbtn_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 121;BA.debugLine="nextbtn.Visible = False";
Debug.ShouldStop(16777216);
all_active_recall.mostCurrent._nextbtn.runMethod(true,"setVisible",all_active_recall.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 122;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(33554432);
all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 BA.debugLineNum = 123;BA.debugLine="currentindex = currentindex +1";
Debug.ShouldStop(67108864);
all_active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {all_active_recall._currentindex,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 124;BA.debugLine="If currentindex >= cards.Size Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("g",all_active_recall._currentindex,BA.numberCast(double.class, all_active_recall.mostCurrent._cards.runMethod(true,"getSize")))) { 
 BA.debugLineNum = 125;BA.debugLine="MsgboxAsync(\"Decks Finished\", \"Active Recall\")";
Debug.ShouldStop(268435456);
all_active_recall.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Decks Finished")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Active Recall"))),all_active_recall.processBA);
 BA.debugLineNum = 126;BA.debugLine="praise = True";
Debug.ShouldStop(536870912);
all_active_recall._praise = all_active_recall.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 127;BA.debugLine="Activity.finish";
Debug.ShouldStop(1073741824);
all_active_recall.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 128;BA.debugLine="Return";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 131;BA.debugLine="Showcard";
Debug.ShouldStop(4);
_showcard();
 BA.debugLineNum = 132;BA.debugLine="ShowProgress";
Debug.ShouldStop(8);
_showprogress();
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim praise As Boolean = False";
all_active_recall._praise = all_active_recall.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showanswerbtn_click() throws Exception{
try {
		Debug.PushSubsStack("showAnswerbtn_Click (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,94);
if (RapidSub.canDelegate("showanswerbtn_click")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","showanswerbtn_click");}
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 94;BA.debugLine="Private Sub showAnswerbtn_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 96;BA.debugLine="Dim card As Map = cards.Get(currentindex)";
Debug.ShouldStop(-2147483648);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), all_active_recall.mostCurrent._cards.runMethod(false,"Get",(Object)(all_active_recall._currentindex)));Debug.locals.put("card", _card);Debug.locals.put("card", _card);
 BA.debugLineNum = 97;BA.debugLine="If showAnswerbtn.Text = \"Show Answer\" Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"getText"),BA.ObjectToString("Show Answer"))) { 
 BA.debugLineNum = 98;BA.debugLine="Answer.Text = card.Get(\"A\")";
Debug.ShouldStop(2);
all_active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("A"))))));
 BA.debugLineNum = 99;BA.debugLine="showAnswerbtn.Text = \"Hide Answer\"";
Debug.ShouldStop(4);
all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Hide Answer"));
 }else {
 BA.debugLineNum = 102;BA.debugLine="Answer.Text = \"\"";
Debug.ShouldStop(32);
all_active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 103;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(64);
all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 };
 BA.debugLineNum = 105;BA.debugLine="nextbtn.Visible = True";
Debug.ShouldStop(256);
all_active_recall.mostCurrent._nextbtn.runMethod(true,"setVisible",all_active_recall.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Showcard (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,77);
if (RapidSub.canDelegate("showcard")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","showcard");}
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 77;BA.debugLine="Sub Showcard";
Debug.ShouldStop(4096);
 BA.debugLineNum = 79;BA.debugLine="Dim card As Map = cards.Get(currentindex)";
Debug.ShouldStop(16384);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), all_active_recall.mostCurrent._cards.runMethod(false,"Get",(Object)(all_active_recall._currentindex)));Debug.locals.put("card", _card);Debug.locals.put("card", _card);
 BA.debugLineNum = 80;BA.debugLine="Question.Text = card.Get(\"Q\")";
Debug.ShouldStop(32768);
all_active_recall.mostCurrent._question.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Q"))))));
 BA.debugLineNum = 81;BA.debugLine="Answer.Text = \"\"";
Debug.ShouldStop(65536);
all_active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 82;BA.debugLine="DeckName_Label.Text = card.Get(\"subdeck\")";
Debug.ShouldStop(131072);
all_active_recall.mostCurrent._deckname_label.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("subdeck"))))));
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showprogress() throws Exception{
try {
		Debug.PushSubsStack("ShowProgress (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,58);
if (RapidSub.canDelegate("showprogress")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","showprogress");}
RemoteObject _totalsession = RemoteObject.createImmutable(0);
RemoteObject _studied = RemoteObject.createImmutable(0);
RemoteObject _percent = RemoteObject.createImmutable(0);
 BA.debugLineNum = 58;BA.debugLine="Sub ShowProgress";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="Dim totalsession As Int = cards.Size";
Debug.ShouldStop(67108864);
_totalsession = all_active_recall.mostCurrent._cards.runMethod(true,"getSize");Debug.locals.put("totalsession", _totalsession);Debug.locals.put("totalsession", _totalsession);
 BA.debugLineNum = 60;BA.debugLine="Dim studied As Int = currentindex";
Debug.ShouldStop(134217728);
_studied = all_active_recall._currentindex;Debug.locals.put("studied", _studied);Debug.locals.put("studied", _studied);
 BA.debugLineNum = 61;BA.debugLine="Dim percent As Int = (studied * 100)/ totalsessio";
Debug.ShouldStop(268435456);
_percent = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_studied,RemoteObject.createImmutable(100)}, "*",0, 1)),_totalsession}, "/",0, 0));Debug.locals.put("percent", _percent);Debug.locals.put("percent", _percent);
 BA.debugLineNum = 62;BA.debugLine="pb.Progress = percent";
Debug.ShouldStop(536870912);
all_active_recall.mostCurrent._pb.runMethod(true,"setProgress",_percent);
 BA.debugLineNum = 63;BA.debugLine="Progress.Text = studied & \"/\" & totalsession & \"";
Debug.ShouldStop(1073741824);
all_active_recall.mostCurrent._progress.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_studied,RemoteObject.createImmutable("/"),_totalsession,RemoteObject.createImmutable(" "),_percent,RemoteObject.createImmutable("%"))));
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
public static RemoteObject  _shufflecards(RemoteObject _cardlist) throws Exception{
try {
		Debug.PushSubsStack("ShuffleCards (all_active_recall) ","all_active_recall",15,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,66);
if (RapidSub.canDelegate("shufflecards")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","shufflecards", _cardlist);}
int _i = 0;
RemoteObject _j = RemoteObject.createImmutable(0);
RemoteObject _temp = RemoteObject.declareNull("Object");
Debug.locals.put("cardList", _cardlist);
 BA.debugLineNum = 66;BA.debugLine="Sub ShuffleCards(cardList As List)";
Debug.ShouldStop(2);
 BA.debugLineNum = 68;BA.debugLine="For i = cardList.Size-1 To 1 Step -1";
Debug.ShouldStop(8);
{
final int step1 = -1;
final int limit1 = 1;
_i = RemoteObject.solve(new RemoteObject[] {_cardlist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 69;BA.debugLine="Dim j As Int = Rnd(0, i+1)";
Debug.ShouldStop(16);
_j = all_active_recall.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("j", _j);Debug.locals.put("j", _j);
 BA.debugLineNum = 71;BA.debugLine="Dim temp As Object = cardList.Get(i)";
Debug.ShouldStop(64);
_temp = _cardlist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("temp", _temp);Debug.locals.put("temp", _temp);
 BA.debugLineNum = 72;BA.debugLine="cardList.Set(i, cardList.Get(j))";
Debug.ShouldStop(128);
_cardlist.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, _i)),(Object)(_cardlist.runMethod(false,"Get",(Object)(_j))));
 BA.debugLineNum = 73;BA.debugLine="cardList.Set(j, temp)";
Debug.ShouldStop(256);
_cardlist.runVoidMethod ("Set",(Object)(_j),(Object)(_temp));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}