package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class add_card_module_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (add_card_module) ","add_card_module",16,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","activity_create", _firsttime);}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _subdeckname = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"ACMLayout\")";
Debug.ShouldStop(134217728);
add_card_module.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ACMLayout")),add_card_module.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="Dim tappeddeck As Map =  FlashcardActivity.deck.G";
Debug.ShouldStop(1073741824);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), add_card_module.mostCurrent._flashcardactivity._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((add_card_module.mostCurrent._flashcardactivity._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappeddeck", _tappeddeck);Debug.locals.put("tappeddeck", _tappeddeck);
 BA.debugLineNum = 34;BA.debugLine="For Each subdeckName As String In tappeddeck.keys";
Debug.ShouldStop(2);
{
final RemoteObject group3 = _tappeddeck.runMethod(false,"Keys");
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_subdeckname = BA.ObjectToString(group3.runMethod(false,"Get",index3));Debug.locals.put("subdeckName", _subdeckname);
Debug.locals.put("subdeckName", _subdeckname);
 BA.debugLineNum = 35;BA.debugLine="spsubdecks.Add(subdeckName)";
Debug.ShouldStop(4);
add_card_module.mostCurrent._spsubdecks.runVoidMethod ("Add",(Object)(_subdeckname));
 }
}Debug.locals.put("subdeckName", _subdeckname);
;
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Pause (add_card_module) ","add_card_module",16,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,44);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Activity_Resume (add_card_module) ","add_card_module",16,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,40);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","activity_resume");}
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("backbtn_Click (add_card_module) ","add_card_module",16,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,89);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","backbtn_click");}
 BA.debugLineNum = 89;BA.debugLine="Private Sub backbtn_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 91;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
add_card_module.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("SaveCard_Click (add_card_module) ","add_card_module",16,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,52);
if (RapidSub.canDelegate("savecard_click")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","savecard_click");}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _chosensubdeck = RemoteObject.createImmutable("");
RemoteObject _flashcards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 52;BA.debugLine="Private Sub SaveCard_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 56;BA.debugLine="Dim tappeddeck As Map = FlashcardActivity.deck.Ge";
Debug.ShouldStop(8388608);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), add_card_module.mostCurrent._flashcardactivity._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((add_card_module.mostCurrent._flashcardactivity._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappeddeck", _tappeddeck);Debug.locals.put("tappeddeck", _tappeddeck);
 BA.debugLineNum = 59;BA.debugLine="If QuestionET.Text = \"\" Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",add_card_module.mostCurrent._questionet.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 60;BA.debugLine="MsgboxAsync(\"Enter the Question!\", \"Error\")";
Debug.ShouldStop(134217728);
add_card_module.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Enter the Question!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),add_card_module.processBA);
 }else 
{ BA.debugLineNum = 61;BA.debugLine="Else if AnswerET.Text = \"\" Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",add_card_module.mostCurrent._answeret.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 62;BA.debugLine="MsgboxAsync(\"Enter the Answer!\", \"Error\")";
Debug.ShouldStop(536870912);
add_card_module.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Enter the Answer!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),add_card_module.processBA);
 }else {
 BA.debugLineNum = 66;BA.debugLine="Dim chosensubdeck As String = spsubdecks.Selecte";
Debug.ShouldStop(2);
_chosensubdeck = add_card_module.mostCurrent._spsubdecks.runMethod(true,"getSelectedItem");Debug.locals.put("chosensubdeck", _chosensubdeck);Debug.locals.put("chosensubdeck", _chosensubdeck);
 BA.debugLineNum = 69;BA.debugLine="Dim flashcards As List = tappeddeck.Get(chosensu";
Debug.ShouldStop(16);
_flashcards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_flashcards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _tappeddeck.runMethod(false,"Get",(Object)((_chosensubdeck))));Debug.locals.put("flashcards", _flashcards);Debug.locals.put("flashcards", _flashcards);
 BA.debugLineNum = 72;BA.debugLine="Dim cards As Map";
Debug.ShouldStop(128);
_cards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("cards", _cards);
 BA.debugLineNum = 73;BA.debugLine="cards.initialize";
Debug.ShouldStop(256);
_cards.runVoidMethod ("Initialize");
 BA.debugLineNum = 74;BA.debugLine="cards.Put(\"Q\", QuestionET.Text)";
Debug.ShouldStop(512);
_cards.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Q"))),(Object)((add_card_module.mostCurrent._questionet.runMethod(true,"getText"))));
 BA.debugLineNum = 75;BA.debugLine="cards.Put(\"A\", AnswerET.Text)";
Debug.ShouldStop(1024);
_cards.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("A"))),(Object)((add_card_module.mostCurrent._answeret.runMethod(true,"getText"))));
 BA.debugLineNum = 78;BA.debugLine="flashcards.Add(cards)";
Debug.ShouldStop(8192);
_flashcards.runVoidMethod ("Add",(Object)((_cards.getObject())));
 BA.debugLineNum = 79;BA.debugLine="QuestionET.Text = \"\"";
Debug.ShouldStop(16384);
add_card_module.mostCurrent._questionet.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 80;BA.debugLine="AnswerET.Text = \"\"";
Debug.ShouldStop(32768);
add_card_module.mostCurrent._answeret.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 82;BA.debugLine="SaveDecks";
Debug.ShouldStop(131072);
_savedecks();
 BA.debugLineNum = 84;BA.debugLine="MsgboxAsync(\"Card is Successfully Saved\", \"Card";
Debug.ShouldStop(524288);
add_card_module.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Card is Successfully Saved")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Card Saved!"))),add_card_module.processBA);
 }}
;
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
public static RemoteObject  _savedecks() throws Exception{
try {
		Debug.PushSubsStack("SaveDecks (add_card_module) ","add_card_module",16,add_card_module.mostCurrent.activityBA,add_card_module.mostCurrent,47);
if (RapidSub.canDelegate("savedecks")) { return b4a.example.add_card_module.remoteMe.runUserSub(false, "add_card_module","savedecks");}
 BA.debugLineNum = 47;BA.debugLine="Sub SaveDecks";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="FlashcardActivity.kvs.Put(\"deck_data\", FlashcardA";
Debug.ShouldStop(32768);
add_card_module.mostCurrent._flashcardactivity._kvs /*RemoteObject*/ .runVoidMethod ("_put",(Object)(BA.ObjectToString("deck_data")),(Object)((add_card_module.mostCurrent._flashcardactivity._deck /*RemoteObject*/ .getObject())));
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
}