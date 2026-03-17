package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class all_active_recall_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (all_active_recall) ","all_active_recall",5,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","activity_create", _firsttime);}
RemoteObject _chosendeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _subdeckname = RemoteObject.createImmutable("");
RemoteObject _subcards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _newcard = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"Layout5\")";
Debug.ShouldStop(33554432);
all_active_recall.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout5")),all_active_recall.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="cards.Initialize";
Debug.ShouldStop(134217728);
all_active_recall.mostCurrent._cards.runVoidMethod ("Initialize");
 BA.debugLineNum = 29;BA.debugLine="RndSeed(DateTime.Now) 'seeding randomizer";
Debug.ShouldStop(268435456);
all_active_recall.mostCurrent.__c.runVoidMethod ("RndSeed",(Object)(all_active_recall.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));
 BA.debugLineNum = 32;BA.debugLine="Dim chosendeck As Map = Main.deck.Get(Main.select";
Debug.ShouldStop(-2147483648);
_chosendeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_chosendeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), all_active_recall.mostCurrent._main._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((all_active_recall.mostCurrent._main._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("chosendeck", _chosendeck);Debug.locals.put("chosendeck", _chosendeck);
 BA.debugLineNum = 33;BA.debugLine="For Each subdeckname As String In chosendeck.Keys";
Debug.ShouldStop(1);
{
final RemoteObject group5 = _chosendeck.runMethod(false,"Keys");
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_subdeckname = BA.ObjectToString(group5.runMethod(false,"Get",index5));Debug.locals.put("subdeckname", _subdeckname);
Debug.locals.put("subdeckname", _subdeckname);
 BA.debugLineNum = 34;BA.debugLine="Dim subcards As List = chosendeck.Get(subdecknam";
Debug.ShouldStop(2);
_subcards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_subcards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _chosendeck.runMethod(false,"Get",(Object)((_subdeckname))));Debug.locals.put("subcards", _subcards);Debug.locals.put("subcards", _subcards);
 BA.debugLineNum = 35;BA.debugLine="For Each card As Map In subcards";
Debug.ShouldStop(4);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group7 = _subcards;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group7.runMethod(false,"Get",index7));Debug.locals.put("card", _card);
Debug.locals.put("card", _card);
 BA.debugLineNum = 36;BA.debugLine="Dim newcard As Map";
Debug.ShouldStop(8);
_newcard = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("newcard", _newcard);
 BA.debugLineNum = 37;BA.debugLine="newcard.Initialize";
Debug.ShouldStop(16);
_newcard.runVoidMethod ("Initialize");
 BA.debugLineNum = 38;BA.debugLine="newcard.Put(\"Q\", card.Get(\"Q\"))";
Debug.ShouldStop(32);
_newcard.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Q"))),(Object)(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Q"))))));
 BA.debugLineNum = 39;BA.debugLine="newcard.Put(\"A\", card.Get(\"A\"))";
Debug.ShouldStop(64);
_newcard.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("A"))),(Object)(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("A"))))));
 BA.debugLineNum = 40;BA.debugLine="newcard.Put(\"subdeck\", subdeckname) 'get subdec";
Debug.ShouldStop(128);
_newcard.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("subdeck"))),(Object)((_subdeckname)));
 BA.debugLineNum = 41;BA.debugLine="cards.Add(newcard)";
Debug.ShouldStop(256);
all_active_recall.mostCurrent._cards.runVoidMethod ("Add",(Object)((_newcard.getObject())));
 }
}Debug.locals.put("card", _card);
;
 }
}Debug.locals.put("subdeckname", _subdeckname);
;
 BA.debugLineNum = 45;BA.debugLine="ShuffleCards(cards)";
Debug.ShouldStop(4096);
_shufflecards(all_active_recall.mostCurrent._cards);
 BA.debugLineNum = 46;BA.debugLine="currentindex = 0";
Debug.ShouldStop(8192);
all_active_recall._currentindex = BA.numberCast(int.class, 0);
 BA.debugLineNum = 48;BA.debugLine="Showcard";
Debug.ShouldStop(32768);
_showcard();
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Pause (all_active_recall) ","all_active_recall",5,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,74);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 74;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Resume (all_active_recall) ","all_active_recall",5,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,70);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","activity_resume");}
 BA.debugLineNum = 70;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backbtn_Click (all_active_recall) ","all_active_recall",5,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,92);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","backbtn_click");}
 BA.debugLineNum = 92;BA.debugLine="Private Sub backbtn_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 94;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(536870912);
all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 BA.debugLineNum = 95;BA.debugLine="If currentindex = 0 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",all_active_recall._currentindex,BA.numberCast(double.class, 0))) { 
 }else {
 BA.debugLineNum = 98;BA.debugLine="currentindex = currentindex-1";
Debug.ShouldStop(2);
all_active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {all_active_recall._currentindex,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 99;BA.debugLine="Showcard";
Debug.ShouldStop(4);
_showcard();
 };
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _goback_click() throws Exception{
try {
		Debug.PushSubsStack("goback_Click (all_active_recall) ","all_active_recall",5,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,116);
if (RapidSub.canDelegate("goback_click")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","goback_click");}
 BA.debugLineNum = 116;BA.debugLine="Private Sub goback_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="Activity.finish";
Debug.ShouldStop(1048576);
all_active_recall.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _nextbtn_click() throws Exception{
try {
		Debug.PushSubsStack("nextbtn_Click (all_active_recall) ","all_active_recall",5,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,103);
if (RapidSub.canDelegate("nextbtn_click")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","nextbtn_click");}
 BA.debugLineNum = 103;BA.debugLine="Private Sub nextbtn_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 105;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(256);
all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 BA.debugLineNum = 106;BA.debugLine="currentindex = currentindex +1";
Debug.ShouldStop(512);
all_active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {all_active_recall._currentindex,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 107;BA.debugLine="If currentindex >= cards.Size Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("g",all_active_recall._currentindex,BA.numberCast(double.class, all_active_recall.mostCurrent._cards.runMethod(true,"getSize")))) { 
 BA.debugLineNum = 108;BA.debugLine="MsgboxAsync(\"Decks Finished\", \"Active Recall\")";
Debug.ShouldStop(2048);
all_active_recall.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Decks Finished")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Active Recall"))),all_active_recall.processBA);
 BA.debugLineNum = 109;BA.debugLine="Activity.finish";
Debug.ShouldStop(4096);
all_active_recall.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 110;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 113;BA.debugLine="Showcard";
Debug.ShouldStop(65536);
_showcard();
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("showAnswerbtn_Click (all_active_recall) ","all_active_recall",5,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,79);
if (RapidSub.canDelegate("showanswerbtn_click")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","showanswerbtn_click");}
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 79;BA.debugLine="Private Sub showAnswerbtn_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 81;BA.debugLine="Dim card As Map = cards.Get(currentindex)";
Debug.ShouldStop(65536);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), all_active_recall.mostCurrent._cards.runMethod(false,"Get",(Object)(all_active_recall._currentindex)));Debug.locals.put("card", _card);Debug.locals.put("card", _card);
 BA.debugLineNum = 82;BA.debugLine="If showAnswerbtn.Text = \"Show Answer\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"getText"),BA.ObjectToString("Show Answer"))) { 
 BA.debugLineNum = 83;BA.debugLine="Answer.Text = card.Get(\"A\")";
Debug.ShouldStop(262144);
all_active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("A"))))));
 BA.debugLineNum = 84;BA.debugLine="showAnswerbtn.Text = \"Hide Answer\"";
Debug.ShouldStop(524288);
all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Hide Answer"));
 }else {
 BA.debugLineNum = 87;BA.debugLine="Answer.Text = \"\"";
Debug.ShouldStop(4194304);
all_active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 88;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(8388608);
all_active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 };
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
public static RemoteObject  _showcard() throws Exception{
try {
		Debug.PushSubsStack("Showcard (all_active_recall) ","all_active_recall",5,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,62);
if (RapidSub.canDelegate("showcard")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","showcard");}
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 62;BA.debugLine="Sub Showcard";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="Dim card As Map = cards.Get(currentindex)";
Debug.ShouldStop(-2147483648);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), all_active_recall.mostCurrent._cards.runMethod(false,"Get",(Object)(all_active_recall._currentindex)));Debug.locals.put("card", _card);Debug.locals.put("card", _card);
 BA.debugLineNum = 65;BA.debugLine="Question.Text = card.Get(\"Q\")";
Debug.ShouldStop(1);
all_active_recall.mostCurrent._question.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Q"))))));
 BA.debugLineNum = 66;BA.debugLine="Answer.Text = \"\"";
Debug.ShouldStop(2);
all_active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 67;BA.debugLine="DeckName_Label.Text = card.Get(\"subdeck\")";
Debug.ShouldStop(4);
all_active_recall.mostCurrent._deckname_label.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("subdeck"))))));
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
public static RemoteObject  _shufflecards(RemoteObject _cardlist) throws Exception{
try {
		Debug.PushSubsStack("ShuffleCards (all_active_recall) ","all_active_recall",5,all_active_recall.mostCurrent.activityBA,all_active_recall.mostCurrent,51);
if (RapidSub.canDelegate("shufflecards")) { return b4a.example.all_active_recall.remoteMe.runUserSub(false, "all_active_recall","shufflecards", _cardlist);}
int _i = 0;
RemoteObject _j = RemoteObject.createImmutable(0);
RemoteObject _temp = RemoteObject.declareNull("Object");
Debug.locals.put("cardList", _cardlist);
 BA.debugLineNum = 51;BA.debugLine="Sub ShuffleCards(cardList As List)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 53;BA.debugLine="For i = cardList.Size-1 To 1 Step -1";
Debug.ShouldStop(1048576);
{
final int step1 = -1;
final int limit1 = 1;
_i = RemoteObject.solve(new RemoteObject[] {_cardlist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 54;BA.debugLine="Dim j As Int = Rnd(0, i+1)";
Debug.ShouldStop(2097152);
_j = all_active_recall.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("j", _j);Debug.locals.put("j", _j);
 BA.debugLineNum = 56;BA.debugLine="Dim temp As Object = cardList.Get(i)";
Debug.ShouldStop(8388608);
_temp = _cardlist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("temp", _temp);Debug.locals.put("temp", _temp);
 BA.debugLineNum = 57;BA.debugLine="cardList.Set(i, cardList.Get(j))";
Debug.ShouldStop(16777216);
_cardlist.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, _i)),(Object)(_cardlist.runMethod(false,"Get",(Object)(_j))));
 BA.debugLineNum = 58;BA.debugLine="cardList.Set(j, temp)";
Debug.ShouldStop(33554432);
_cardlist.runVoidMethod ("Set",(Object)(_j),(Object)(_temp));
 }
}Debug.locals.put("i", _i);
;
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
}