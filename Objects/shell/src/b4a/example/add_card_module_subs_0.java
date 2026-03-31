package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class add_card_module_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (add_card_module) ","add_card_module",10,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","activity_create", _firsttime);}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _subdeckname = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 26;BA.debugLine="If Starter.darkMode = False Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",add_card_module.mostCurrent._starter._darkmode /*RemoteObject*/ ,add_card_module.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"ACMLayout\")";
Debug.ShouldStop(67108864);
add_card_module.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ACMLayout")),add_card_module.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"ACMLayoutDark\")";
Debug.ShouldStop(268435456);
add_card_module.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ACMLayoutDark")),add_card_module.mostCurrent.activityBA);
 };
 BA.debugLineNum = 33;BA.debugLine="Dim tappeddeck As Map =  FlashcardActivity.deck.G";
Debug.ShouldStop(1);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), add_card_module.mostCurrent._flashcardactivity._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((add_card_module.mostCurrent._flashcardactivity._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappeddeck", _tappeddeck);Debug.locals.put("tappeddeck", _tappeddeck);
 BA.debugLineNum = 36;BA.debugLine="For Each subdeckName As String In tappeddeck.keys";
Debug.ShouldStop(8);
{
final RemoteObject group7 = _tappeddeck.runMethod(false,"Keys");
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_subdeckname = BA.ObjectToString(group7.runMethod(false,"Get",index7));Debug.locals.put("subdeckName", _subdeckname);
Debug.locals.put("subdeckName", _subdeckname);
 BA.debugLineNum = 37;BA.debugLine="spsubdecks.Add(subdeckName)";
Debug.ShouldStop(16);
add_card_module.mostCurrent._spsubdecks.runVoidMethod ("Add",(Object)(_subdeckname));
 }
}Debug.locals.put("subdeckName", _subdeckname);
;
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
		Debug.PushSubsStack("Activity_Pause (add_card_module) ","add_card_module",10,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,46);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_Resume (add_card_module) ","add_card_module",10,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,42);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","activity_resume");}
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backbtn_Click (add_card_module) ","add_card_module",10,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,91);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","backbtn_click");}
 BA.debugLineNum = 91;BA.debugLine="Private Sub backbtn_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 93;BA.debugLine="Activity.Finish";
Debug.ShouldStop(268435456);
add_card_module.mostCurrent._activity.runVoidMethod ("Finish");
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
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private QuestionET As EditText";
add_card_module.mostCurrent._questionet = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private AnswerET As EditText";
add_card_module.mostCurrent._answeret = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private spsubdecks As Spinner";
add_card_module.mostCurrent._spsubdecks = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _savecard_click() throws Exception{
try {
		Debug.PushSubsStack("SaveCard_Click (add_card_module) ","add_card_module",10,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,54);
if (RapidSub.canDelegate("savecard_click")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","savecard_click");}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _chosensubdeck = RemoteObject.createImmutable("");
RemoteObject _flashcards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 54;BA.debugLine="Private Sub SaveCard_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 58;BA.debugLine="Dim tappeddeck As Map = FlashcardActivity.deck.Ge";
Debug.ShouldStop(33554432);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), add_card_module.mostCurrent._flashcardactivity._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((add_card_module.mostCurrent._flashcardactivity._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappeddeck", _tappeddeck);Debug.locals.put("tappeddeck", _tappeddeck);
 BA.debugLineNum = 61;BA.debugLine="If QuestionET.Text = \"\" Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",add_card_module.mostCurrent._questionet.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 62;BA.debugLine="MsgboxAsync(\"Enter the Question!\", \"Error\")";
Debug.ShouldStop(536870912);
add_card_module.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Enter the Question!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),add_card_module.processBA);
 }else 
{ BA.debugLineNum = 63;BA.debugLine="Else if AnswerET.Text = \"\" Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",add_card_module.mostCurrent._answeret.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 64;BA.debugLine="MsgboxAsync(\"Enter the Answer!\", \"Error\")";
Debug.ShouldStop(-2147483648);
add_card_module.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Enter the Answer!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),add_card_module.processBA);
 }else {
 BA.debugLineNum = 68;BA.debugLine="Dim chosensubdeck As String = spsubdecks.Selecte";
Debug.ShouldStop(8);
_chosensubdeck = add_card_module.mostCurrent._spsubdecks.runMethod(true,"getSelectedItem");Debug.locals.put("chosensubdeck", _chosensubdeck);Debug.locals.put("chosensubdeck", _chosensubdeck);
 BA.debugLineNum = 71;BA.debugLine="Dim flashcards As List = tappeddeck.Get(chosensu";
Debug.ShouldStop(64);
_flashcards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_flashcards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _tappeddeck.runMethod(false,"Get",(Object)((_chosensubdeck))));Debug.locals.put("flashcards", _flashcards);Debug.locals.put("flashcards", _flashcards);
 BA.debugLineNum = 74;BA.debugLine="Dim cards As Map";
Debug.ShouldStop(512);
_cards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("cards", _cards);
 BA.debugLineNum = 75;BA.debugLine="cards.initialize";
Debug.ShouldStop(1024);
_cards.runVoidMethod ("Initialize");
 BA.debugLineNum = 76;BA.debugLine="cards.Put(\"Q\", QuestionET.Text)";
Debug.ShouldStop(2048);
_cards.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Q"))),(Object)((add_card_module.mostCurrent._questionet.runMethod(true,"getText"))));
 BA.debugLineNum = 77;BA.debugLine="cards.Put(\"A\", AnswerET.Text)";
Debug.ShouldStop(4096);
_cards.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("A"))),(Object)((add_card_module.mostCurrent._answeret.runMethod(true,"getText"))));
 BA.debugLineNum = 80;BA.debugLine="flashcards.Add(cards)";
Debug.ShouldStop(32768);
_flashcards.runVoidMethod ("Add",(Object)((_cards.getObject())));
 BA.debugLineNum = 81;BA.debugLine="QuestionET.Text = \"\"";
Debug.ShouldStop(65536);
add_card_module.mostCurrent._questionet.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 82;BA.debugLine="AnswerET.Text = \"\"";
Debug.ShouldStop(131072);
add_card_module.mostCurrent._answeret.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 84;BA.debugLine="SaveDecks";
Debug.ShouldStop(524288);
_savedecks();
 BA.debugLineNum = 86;BA.debugLine="MsgboxAsync(\"Card is Successfully Saved\", \"Card";
Debug.ShouldStop(2097152);
add_card_module.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Card is Successfully Saved")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Card Saved!"))),add_card_module.processBA);
 }}
;
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savedecks() throws Exception{
try {
		Debug.PushSubsStack("SaveDecks (add_card_module) ","add_card_module",10,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,49);
if (RapidSub.canDelegate("savedecks")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","savedecks");}
 BA.debugLineNum = 49;BA.debugLine="Sub SaveDecks";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="FlashcardActivity.kvs.Put(\"deck_data\", FlashcardA";
Debug.ShouldStop(131072);
add_card_module.mostCurrent._flashcardactivity._kvs /*RemoteObject*/ .runVoidMethod ("_put",(Object)(BA.ObjectToString("deck_data")),(Object)((add_card_module.mostCurrent._flashcardactivity._deck /*RemoteObject*/ .getObject())));
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
}