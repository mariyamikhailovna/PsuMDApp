package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class active_recall_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","activity_create", _firsttime);}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"AARLAyout\")";
Debug.ShouldStop(-2147483648);
active_recall.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("AARLAyout")),active_recall.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="Dim tappeddeck As Map = FlashcardActivity.deck.Ge";
Debug.ShouldStop(4);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), active_recall.mostCurrent._flashcardactivity._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((active_recall.mostCurrent._flashcardactivity._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappeddeck", _tappeddeck);Debug.locals.put("tappeddeck", _tappeddeck);
 BA.debugLineNum = 37;BA.debugLine="cards = tappeddeck.Get(Subdeck_Module.selectedsub";
Debug.ShouldStop(16);
active_recall.mostCurrent._cards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _tappeddeck.runMethod(false,"Get",(Object)((active_recall.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ))));
 BA.debugLineNum = 39;BA.debugLine="currentindex = 0";
Debug.ShouldStop(64);
active_recall._currentindex = BA.numberCast(int.class, 0);
 BA.debugLineNum = 40;BA.debugLine="DeckName_Label.text = Subdeck_Module.selectedsubd";
Debug.ShouldStop(128);
active_recall.mostCurrent._deckname_label.runMethod(true,"setText",BA.ObjectToCharSequence(active_recall.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ));
 BA.debugLineNum = 42;BA.debugLine="ShuffleCards(cards)";
Debug.ShouldStop(512);
_shufflecards(active_recall.mostCurrent._cards);
 BA.debugLineNum = 43;BA.debugLine="ShowProgress";
Debug.ShouldStop(1024);
_showprogress();
 BA.debugLineNum = 45;BA.debugLine="ShowCard";
Debug.ShouldStop(4096);
_showcard();
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
		Debug.PushSubsStack("Activity_Pause (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,82);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Resume (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,78);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","activity_resume");}
 BA.debugLineNum = 78;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backbtn_Click (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,128);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","backbtn_click");}
 BA.debugLineNum = 128;BA.debugLine="Private Sub backbtn_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 130;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(2);
active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 BA.debugLineNum = 131;BA.debugLine="currentindex = currentindex -1";
Debug.ShouldStop(4);
active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {active_recall._currentindex,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 132;BA.debugLine="If currentindex < 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("<",active_recall._currentindex,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 133;BA.debugLine="currentindex = cards.Size -1";
Debug.ShouldStop(16);
active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {active_recall.mostCurrent._cards.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1);
 };
 BA.debugLineNum = 136;BA.debugLine="ShowCard";
Debug.ShouldStop(128);
_showcard();
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
 //BA.debugLineNum = 23;BA.debugLine="Private pb As ProgressBar";
active_recall.mostCurrent._pb = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private Progress As Label";
active_recall.mostCurrent._progress = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private nextbtn As Button";
active_recall.mostCurrent._nextbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _goback_click() throws Exception{
try {
		Debug.PushSubsStack("goback_Click (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,123);
if (RapidSub.canDelegate("goback_click")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","goback_click");}
 BA.debugLineNum = 123;BA.debugLine="Private Sub goback_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 125;BA.debugLine="Activity.finish";
Debug.ShouldStop(268435456);
active_recall.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("nextbtn_Click (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,106);
if (RapidSub.canDelegate("nextbtn_click")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","nextbtn_click");}
 BA.debugLineNum = 106;BA.debugLine="Private Sub nextbtn_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 107;BA.debugLine="nextbtn.Visible = False";
Debug.ShouldStop(1024);
active_recall.mostCurrent._nextbtn.runMethod(true,"setVisible",active_recall.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 109;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(4096);
active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 BA.debugLineNum = 110;BA.debugLine="currentindex = currentindex +1";
Debug.ShouldStop(8192);
active_recall._currentindex = RemoteObject.solve(new RemoteObject[] {active_recall._currentindex,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 112;BA.debugLine="If currentindex >= cards.Size Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("g",active_recall._currentindex,BA.numberCast(double.class, active_recall.mostCurrent._cards.runMethod(true,"getSize")))) { 
 BA.debugLineNum = 113;BA.debugLine="ShuffleCards(cards)";
Debug.ShouldStop(65536);
_shufflecards(active_recall.mostCurrent._cards);
 BA.debugLineNum = 114;BA.debugLine="praise = True";
Debug.ShouldStop(131072);
active_recall._praise = active_recall.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 115;BA.debugLine="MsgboxAsync(\"You've finished your subdeck\", \"Con";
Debug.ShouldStop(262144);
active_recall.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("You've finished your subdeck")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Congratulations"))),active_recall.processBA);
 BA.debugLineNum = 116;BA.debugLine="Activity.finish";
Debug.ShouldStop(524288);
active_recall.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 117;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 119;BA.debugLine="ShowCard";
Debug.ShouldStop(4194304);
_showcard();
 BA.debugLineNum = 120;BA.debugLine="ShowProgress";
Debug.ShouldStop(8388608);
_showprogress();
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
active_recall._praise = active_recall.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showanswerbtn_click() throws Exception{
try {
		Debug.PushSubsStack("showAnswerbtn_Click (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,87);
if (RapidSub.canDelegate("showanswerbtn_click")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","showanswerbtn_click");}
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 87;BA.debugLine="Private Sub showAnswerbtn_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 90;BA.debugLine="Dim card As Map = cards.Get(currentindex)";
Debug.ShouldStop(33554432);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), active_recall.mostCurrent._cards.runMethod(false,"Get",(Object)(active_recall._currentindex)));Debug.locals.put("card", _card);Debug.locals.put("card", _card);
 BA.debugLineNum = 92;BA.debugLine="If showAnswerbtn.Text = \"Show Answer\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",active_recall.mostCurrent._showanswerbtn.runMethod(true,"getText"),BA.ObjectToString("Show Answer"))) { 
 BA.debugLineNum = 94;BA.debugLine="Answer.Text = card.Get(\"A\")";
Debug.ShouldStop(536870912);
active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("A"))))));
 BA.debugLineNum = 95;BA.debugLine="showAnswerbtn.Text = \"Hide Answer\"";
Debug.ShouldStop(1073741824);
active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Hide Answer"));
 }else {
 BA.debugLineNum = 98;BA.debugLine="Answer.Text = \"\"";
Debug.ShouldStop(2);
active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 99;BA.debugLine="showAnswerbtn.Text = \"Show Answer\"";
Debug.ShouldStop(4);
active_recall.mostCurrent._showanswerbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Show Answer"));
 };
 BA.debugLineNum = 103;BA.debugLine="nextbtn.Visible = True";
Debug.ShouldStop(64);
active_recall.mostCurrent._nextbtn.runMethod(true,"setVisible",active_recall.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _showcard() throws Exception{
try {
		Debug.PushSubsStack("ShowCard (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,68);
if (RapidSub.canDelegate("showcard")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","showcard");}
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 68;BA.debugLine="Sub ShowCard";
Debug.ShouldStop(8);
 BA.debugLineNum = 71;BA.debugLine="Dim card As Map = cards.Get(currentindex)";
Debug.ShouldStop(64);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), active_recall.mostCurrent._cards.runMethod(false,"Get",(Object)(active_recall._currentindex)));Debug.locals.put("card", _card);Debug.locals.put("card", _card);
 BA.debugLineNum = 73;BA.debugLine="Question.Text = card.Get(\"Q\")";
Debug.ShouldStop(256);
active_recall.mostCurrent._question.runMethod(true,"setText",BA.ObjectToCharSequence(_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Q"))))));
 BA.debugLineNum = 74;BA.debugLine="Answer.Text = \"\"";
Debug.ShouldStop(512);
active_recall.mostCurrent._answer.runMethod(true,"setText",BA.ObjectToCharSequence(""));
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
public static RemoteObject  _showprogress() throws Exception{
try {
		Debug.PushSubsStack("ShowProgress (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,49);
if (RapidSub.canDelegate("showprogress")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","showprogress");}
RemoteObject _totalsession = RemoteObject.createImmutable(0);
RemoteObject _studied = RemoteObject.createImmutable(0);
RemoteObject _percent = RemoteObject.createImmutable(0);
 BA.debugLineNum = 49;BA.debugLine="Sub ShowProgress";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Dim totalsession As Int = cards.Size";
Debug.ShouldStop(131072);
_totalsession = active_recall.mostCurrent._cards.runMethod(true,"getSize");Debug.locals.put("totalsession", _totalsession);Debug.locals.put("totalsession", _totalsession);
 BA.debugLineNum = 51;BA.debugLine="Dim studied As Int = currentindex";
Debug.ShouldStop(262144);
_studied = active_recall._currentindex;Debug.locals.put("studied", _studied);Debug.locals.put("studied", _studied);
 BA.debugLineNum = 52;BA.debugLine="Dim percent As Int = (studied * 100)/ totalsessio";
Debug.ShouldStop(524288);
_percent = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_studied,RemoteObject.createImmutable(100)}, "*",0, 1)),_totalsession}, "/",0, 0));Debug.locals.put("percent", _percent);Debug.locals.put("percent", _percent);
 BA.debugLineNum = 53;BA.debugLine="pb.Progress = percent";
Debug.ShouldStop(1048576);
active_recall.mostCurrent._pb.runMethod(true,"setProgress",_percent);
 BA.debugLineNum = 54;BA.debugLine="Progress.Text = studied & \"/\" & totalsession & \"";
Debug.ShouldStop(2097152);
active_recall.mostCurrent._progress.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_studied,RemoteObject.createImmutable("/"),_totalsession,RemoteObject.createImmutable(" "),_percent,RemoteObject.createImmutable("%"))));
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
public static RemoteObject  _shufflecards(RemoteObject _cardlist) throws Exception{
try {
		Debug.PushSubsStack("ShuffleCards (active_recall) ","active_recall",15,active_recall.mostCurrent.activityBA,active_recall.mostCurrent,57);
if (RapidSub.canDelegate("shufflecards")) { return b4a.example.active_recall.remoteMe.runUserSub(false, "active_recall","shufflecards", _cardlist);}
int _i = 0;
RemoteObject _j = RemoteObject.createImmutable(0);
RemoteObject _temp = RemoteObject.declareNull("Object");
Debug.locals.put("cardList", _cardlist);
 BA.debugLineNum = 57;BA.debugLine="Sub ShuffleCards(cardList As List)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="For i = cardList.Size-1 To 1 Step -1";
Debug.ShouldStop(67108864);
{
final int step1 = -1;
final int limit1 = 1;
_i = RemoteObject.solve(new RemoteObject[] {_cardlist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 60;BA.debugLine="Dim j As Int = Rnd(0, i+1)";
Debug.ShouldStop(134217728);
_j = active_recall.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)));Debug.locals.put("j", _j);Debug.locals.put("j", _j);
 BA.debugLineNum = 62;BA.debugLine="Dim temp As Object = cardList.Get(i)";
Debug.ShouldStop(536870912);
_temp = _cardlist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)));Debug.locals.put("temp", _temp);Debug.locals.put("temp", _temp);
 BA.debugLineNum = 63;BA.debugLine="cardList.Set(i, cardList.Get(j))";
Debug.ShouldStop(1073741824);
_cardlist.runVoidMethod ("Set",(Object)(BA.numberCast(int.class, _i)),(Object)(_cardlist.runMethod(false,"Get",(Object)(_j))));
 BA.debugLineNum = 64;BA.debugLine="cardList.Set(j, temp)";
Debug.ShouldStop(-2147483648);
_cardlist.runVoidMethod ("Set",(Object)(_j),(Object)(_temp));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}