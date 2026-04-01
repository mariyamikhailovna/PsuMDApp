package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class flashcardactivity_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,38);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","activity_create", _firsttime);}
RemoteObject _radius = RemoteObject.createImmutable(0);
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 42;BA.debugLine="If Starter.darkMode = False Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",flashcardactivity.mostCurrent._starter._darkmode /*RemoteObject*/ ,flashcardactivity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"FlashCardLayout\")";
Debug.ShouldStop(1024);
flashcardactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("FlashCardLayout")),flashcardactivity.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"FlashCardLayoutDark\")";
Debug.ShouldStop(4096);
flashcardactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("FlashCardLayoutDark")),flashcardactivity.mostCurrent.activityBA);
 };
 BA.debugLineNum = 49;BA.debugLine="Dim radius As Int = Addbtn.Width/2";
Debug.ShouldStop(65536);
_radius = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {flashcardactivity.mostCurrent._addbtn.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("radius", _radius);Debug.locals.put("radius", _radius);
 BA.debugLineNum = 50;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(131072);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 51;BA.debugLine="cd.Initialize(Colors.Gray, radius)";
Debug.ShouldStop(262144);
_cd.runVoidMethod ("Initialize",(Object)(flashcardactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray")),(Object)(_radius));
 BA.debugLineNum = 52;BA.debugLine="Addbtn.Background = cd";
Debug.ShouldStop(524288);
flashcardactivity.mostCurrent._addbtn.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 55;BA.debugLine="LVdecks.SingleLineLayout.Label.textcolor = Colors";
Debug.ShouldStop(4194304);
flashcardactivity.mostCurrent._lvdecks.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",flashcardactivity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 57;BA.debugLine="kvs = Starter.deckKvs";
Debug.ShouldStop(16777216);
flashcardactivity._kvs = flashcardactivity.mostCurrent._starter._deckkvs /*RemoteObject*/ ;
 BA.debugLineNum = 58;BA.debugLine="deck = Starter.deck";
Debug.ShouldStop(33554432);
flashcardactivity._deck = flashcardactivity.mostCurrent._starter._deck /*RemoteObject*/ ;
 BA.debugLineNum = 63;BA.debugLine="refreshbtn_Click";
Debug.ShouldStop(1073741824);
_refreshbtn_click();
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,72);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 72;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Resume (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,68);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","activity_resume");}
 BA.debugLineNum = 68;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addbtn_click() throws Exception{
try {
		Debug.PushSubsStack("Addbtn_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,80);
if (RapidSub.canDelegate("addbtn_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","addbtn_click");}
 BA.debugLineNum = 80;BA.debugLine="Private Sub Addbtn_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 82;BA.debugLine="If addpanel.Visible = True Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",flashcardactivity.mostCurrent._addpanel.runMethod(true,"getVisible"),flashcardactivity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 83;BA.debugLine="addpanel.Visible = False";
Debug.ShouldStop(262144);
flashcardactivity.mostCurrent._addpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 85;BA.debugLine="addpanel.Visible = True";
Debug.ShouldStop(1048576);
flashcardactivity.mostCurrent._addpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addcards_click() throws Exception{
try {
		Debug.PushSubsStack("addcards_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,151);
if (RapidSub.canDelegate("addcards_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","addcards_click");}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 151;BA.debugLine="Private Sub addcards_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="Dim tappeddeck As Map = deck.Get(item_longclick)";
Debug.ShouldStop(8388608);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), flashcardactivity._deck.runMethod(false,"Get",(Object)((flashcardactivity._item_longclick))));Debug.locals.put("tappeddeck", _tappeddeck);Debug.locals.put("tappeddeck", _tappeddeck);
 BA.debugLineNum = 153;BA.debugLine="If tappeddeck.Size = 0 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_tappeddeck.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 154;BA.debugLine="MsgboxAsync(\"Create A Sub-Deck first\", \"Error\")";
Debug.ShouldStop(33554432);
flashcardactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Create A Sub-Deck first")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),flashcardactivity.processBA);
 BA.debugLineNum = 155;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 157;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(268435456);
flashcardactivity.mostCurrent._decksettingpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 158;BA.debugLine="StartActivity(Add_card_module)";
Debug.ShouldStop(536870912);
flashcardactivity.mostCurrent.__c.runVoidMethod ("StartActivity",flashcardactivity.processBA,(Object)((flashcardactivity.mostCurrent._add_card_module.getObject())));
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _browse_cards_click() throws Exception{
try {
		Debug.PushSubsStack("browse_cards_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,176);
if (RapidSub.canDelegate("browse_cards_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","browse_cards_click");}
 BA.debugLineNum = 176;BA.debugLine="Private Sub browse_cards_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 177;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(65536);
flashcardactivity.mostCurrent._decksettingpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 178;BA.debugLine="StartActivity(deck_all_cards)";
Debug.ShouldStop(131072);
flashcardactivity.mostCurrent.__c.runVoidMethod ("StartActivity",flashcardactivity.processBA,(Object)((flashcardactivity.mostCurrent._deck_all_cards.getObject())));
 BA.debugLineNum = 179;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cancel_click() throws Exception{
try {
		Debug.PushSubsStack("cancel_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,88);
if (RapidSub.canDelegate("cancel_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","cancel_click");}
 BA.debugLineNum = 88;BA.debugLine="Private Sub cancel_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 90;BA.debugLine="addpanel.Visible = False";
Debug.ShouldStop(33554432);
flashcardactivity.mostCurrent._addpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 92;BA.debugLine="et1.Text = \"\"";
Debug.ShouldStop(134217728);
flashcardactivity.mostCurrent._et1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cancelbtn_click() throws Exception{
try {
		Debug.PushSubsStack("cancelbtn_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,181);
if (RapidSub.canDelegate("cancelbtn_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","cancelbtn_click");}
 BA.debugLineNum = 181;BA.debugLine="Private Sub cancelbtn_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 182;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(2097152);
flashcardactivity.mostCurrent._decksettingpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _canceldelete_click() throws Exception{
try {
		Debug.PushSubsStack("canceldelete_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,244);
if (RapidSub.canDelegate("canceldelete_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","canceldelete_click");}
 BA.debugLineNum = 244;BA.debugLine="Private Sub canceldelete_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 245;BA.debugLine="deleteconfirmation.Visible = False";
Debug.ShouldStop(1048576);
flashcardactivity.mostCurrent._deleteconfirmation.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 246;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cancelnew_click() throws Exception{
try {
		Debug.PushSubsStack("cancelnew_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,206);
if (RapidSub.canDelegate("cancelnew_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","cancelnew_click");}
 BA.debugLineNum = 206;BA.debugLine="Private Sub cancelnew_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 207;BA.debugLine="newdeckname.text = False";
Debug.ShouldStop(16384);
flashcardactivity.mostCurrent._newdeckname.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(flashcardactivity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 208;BA.debugLine="renamepanel.Visible = False";
Debug.ShouldStop(32768);
flashcardactivity.mostCurrent._renamepanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 209;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cancelnewsubdeck_click() throws Exception{
try {
		Debug.PushSubsStack("cancelnewsubdeck_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,232);
if (RapidSub.canDelegate("cancelnewsubdeck_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","cancelnewsubdeck_click");}
 BA.debugLineNum = 232;BA.debugLine="Private Sub cancelnewsubdeck_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 233;BA.debugLine="newsubdecket.Text = \"\"";
Debug.ShouldStop(256);
flashcardactivity.mostCurrent._newsubdecket.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 234;BA.debugLine="newsubdeckpanel.Visible = False";
Debug.ShouldStop(512);
flashcardactivity.mostCurrent._newsubdeckpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 235;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _confirmdelete_click() throws Exception{
try {
		Debug.PushSubsStack("confirmdelete_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,237);
if (RapidSub.canDelegate("confirmdelete_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","confirmdelete_click");}
 BA.debugLineNum = 237;BA.debugLine="Private Sub confirmdelete_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 238;BA.debugLine="deck.Remove(item_longclick)";
Debug.ShouldStop(8192);
flashcardactivity._deck.runVoidMethod ("Remove",(Object)((flashcardactivity._item_longclick)));
 BA.debugLineNum = 239;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(16384);
flashcardactivity.mostCurrent._decksettingpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 240;BA.debugLine="deleteconfirmation.Visible = False";
Debug.ShouldStop(32768);
flashcardactivity.mostCurrent._deleteconfirmation.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 241;BA.debugLine="refreshbtn_Click";
Debug.ShouldStop(65536);
_refreshbtn_click();
 BA.debugLineNum = 242;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _confirmnew_click() throws Exception{
try {
		Debug.PushSubsStack("confirmnew_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,185);
if (RapidSub.canDelegate("confirmnew_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","confirmnew_click");}
RemoteObject _getsubdeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _names = RemoteObject.createImmutable("");
 BA.debugLineNum = 185;BA.debugLine="Private Sub confirmnew_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="Dim getsubdeck As Map";
Debug.ShouldStop(33554432);
_getsubdeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("getsubdeck", _getsubdeck);
 BA.debugLineNum = 187;BA.debugLine="If newdeckname.Text = \"\" Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",flashcardactivity.mostCurrent._newdeckname.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 188;BA.debugLine="MsgboxAsync(\"New Name must have a name\", \"Error\"";
Debug.ShouldStop(134217728);
flashcardactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("New Name must have a name")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),flashcardactivity.processBA);
 BA.debugLineNum = 189;BA.debugLine="Return";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 191;BA.debugLine="For Each names As String In deck.keys";
Debug.ShouldStop(1073741824);
{
final RemoteObject group6 = flashcardactivity._deck.runMethod(false,"Keys");
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_names = BA.ObjectToString(group6.runMethod(false,"Get",index6));Debug.locals.put("names", _names);
Debug.locals.put("names", _names);
 BA.debugLineNum = 192;BA.debugLine="getsubdeck = deck.Get(item_longclick)";
Debug.ShouldStop(-2147483648);
_getsubdeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), flashcardactivity._deck.runMethod(false,"Get",(Object)((flashcardactivity._item_longclick))));Debug.locals.put("getsubdeck", _getsubdeck);
 BA.debugLineNum = 193;BA.debugLine="If newdeckname.Text = names Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",flashcardactivity.mostCurrent._newdeckname.runMethod(true,"getText"),_names)) { 
 BA.debugLineNum = 194;BA.debugLine="MsgboxAsync(\"Deck Name Already Exist\", \"Error\")";
Debug.ShouldStop(2);
flashcardactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Deck Name Already Exist")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),flashcardactivity.processBA);
 BA.debugLineNum = 195;BA.debugLine="Return";
Debug.ShouldStop(4);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("names", _names);
;
 BA.debugLineNum = 198;BA.debugLine="deck.Remove(item_longclick)";
Debug.ShouldStop(32);
flashcardactivity._deck.runVoidMethod ("Remove",(Object)((flashcardactivity._item_longclick)));
 BA.debugLineNum = 199;BA.debugLine="deck.Put(newdeckname.Text, getsubdeck)";
Debug.ShouldStop(64);
flashcardactivity._deck.runVoidMethod ("Put",(Object)((flashcardactivity.mostCurrent._newdeckname.runMethod(true,"getText"))),(Object)((_getsubdeck.getObject())));
 BA.debugLineNum = 200;BA.debugLine="newdeckname.text = \"\"";
Debug.ShouldStop(128);
flashcardactivity.mostCurrent._newdeckname.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 201;BA.debugLine="SaveDecks";
Debug.ShouldStop(256);
_savedecks();
 BA.debugLineNum = 202;BA.debugLine="refreshbtn_Click";
Debug.ShouldStop(512);
_refreshbtn_click();
 BA.debugLineNum = 203;BA.debugLine="renamepanel.Visible = False";
Debug.ShouldStop(1024);
flashcardactivity.mostCurrent._renamepanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 204;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _create_click() throws Exception{
try {
		Debug.PushSubsStack("create_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,96);
if (RapidSub.canDelegate("create_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","create_click");}
RemoteObject _newsubdeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _names = RemoteObject.createImmutable("");
 BA.debugLineNum = 96;BA.debugLine="Private Sub create_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 99;BA.debugLine="Dim newsubdeck As Map";
Debug.ShouldStop(4);
_newsubdeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("newsubdeck", _newsubdeck);
 BA.debugLineNum = 101;BA.debugLine="newsubdeck.initialize";
Debug.ShouldStop(16);
_newsubdeck.runVoidMethod ("Initialize");
 BA.debugLineNum = 104;BA.debugLine="For Each names As String In deck.Keys";
Debug.ShouldStop(128);
{
final RemoteObject group3 = flashcardactivity._deck.runMethod(false,"Keys");
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_names = BA.ObjectToString(group3.runMethod(false,"Get",index3));Debug.locals.put("names", _names);
Debug.locals.put("names", _names);
 BA.debugLineNum = 105;BA.debugLine="If et1.Text = names Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",flashcardactivity.mostCurrent._et1.runMethod(true,"getText"),_names)) { 
 BA.debugLineNum = 106;BA.debugLine="MsgboxAsync(\"Deck Already Exist\", \"Error\")";
Debug.ShouldStop(512);
flashcardactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Deck Already Exist")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),flashcardactivity.processBA);
 BA.debugLineNum = 107;BA.debugLine="Return";
Debug.ShouldStop(1024);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("names", _names);
;
 BA.debugLineNum = 112;BA.debugLine="If et1.Text = \"\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",flashcardactivity.mostCurrent._et1.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 113;BA.debugLine="MsgboxAsync(\"Deck must have a name\", \"Error\")";
Debug.ShouldStop(65536);
flashcardactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Deck must have a name")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),flashcardactivity.processBA);
 }else {
 BA.debugLineNum = 116;BA.debugLine="addpanel.Visible = False";
Debug.ShouldStop(524288);
flashcardactivity.mostCurrent._addpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 117;BA.debugLine="LVdecks.AddSingleLine(et1.Text)";
Debug.ShouldStop(1048576);
flashcardactivity.mostCurrent._lvdecks.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(flashcardactivity.mostCurrent._et1.runMethod(true,"getText"))));
 BA.debugLineNum = 120;BA.debugLine="deck.Put(et1.Text, newsubdeck)";
Debug.ShouldStop(8388608);
flashcardactivity._deck.runVoidMethod ("Put",(Object)((flashcardactivity.mostCurrent._et1.runMethod(true,"getText"))),(Object)((_newsubdeck.getObject())));
 BA.debugLineNum = 121;BA.debugLine="SaveDecks";
Debug.ShouldStop(16777216);
_savedecks();
 BA.debugLineNum = 123;BA.debugLine="et1.Text = \"\"";
Debug.ShouldStop(67108864);
flashcardactivity.mostCurrent._et1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
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
public static RemoteObject  _create_subdeck_click() throws Exception{
try {
		Debug.PushSubsStack("create_subdeck_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,171);
if (RapidSub.canDelegate("create_subdeck_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","create_subdeck_click");}
 BA.debugLineNum = 171;BA.debugLine="Private Sub create_subdeck_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 172;BA.debugLine="newsubdeckpanel.Visible = True";
Debug.ShouldStop(2048);
flashcardactivity.mostCurrent._newsubdeckpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 173;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(4096);
flashcardactivity.mostCurrent._decksettingpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createnewsubdeck_click() throws Exception{
try {
		Debug.PushSubsStack("createnewsubdeck_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,211);
if (RapidSub.canDelegate("createnewsubdeck_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","createnewsubdeck_click");}
RemoteObject _createdeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _flashcard = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _subdeck = RemoteObject.createImmutable("");
 BA.debugLineNum = 211;BA.debugLine="Private Sub createnewsubdeck_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 212;BA.debugLine="If newsubdecket.Text = \"\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",flashcardactivity.mostCurrent._newsubdecket.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 213;BA.debugLine="MsgboxAsync(\"New Sub Deck must have a name\", \"Er";
Debug.ShouldStop(1048576);
flashcardactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("New Sub Deck must have a name")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),flashcardactivity.processBA);
 BA.debugLineNum = 214;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 216;BA.debugLine="Dim createdeck As Map = deck.Get(item_longclick)";
Debug.ShouldStop(8388608);
_createdeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_createdeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), flashcardactivity._deck.runMethod(false,"Get",(Object)((flashcardactivity._item_longclick))));Debug.locals.put("createdeck", _createdeck);Debug.locals.put("createdeck", _createdeck);
 BA.debugLineNum = 217;BA.debugLine="Dim flashcard As List";
Debug.ShouldStop(16777216);
_flashcard = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("flashcard", _flashcard);
 BA.debugLineNum = 218;BA.debugLine="flashcard.Initialize";
Debug.ShouldStop(33554432);
_flashcard.runVoidMethod ("Initialize");
 BA.debugLineNum = 219;BA.debugLine="For Each subdeck As String In createdeck.Keys";
Debug.ShouldStop(67108864);
{
final RemoteObject group8 = _createdeck.runMethod(false,"Keys");
final int groupLen8 = group8.runMethod(true,"getSize").<Integer>get()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_subdeck = BA.ObjectToString(group8.runMethod(false,"Get",index8));Debug.locals.put("subdeck", _subdeck);
Debug.locals.put("subdeck", _subdeck);
 BA.debugLineNum = 220;BA.debugLine="If newsubdecket.Text = subdeck Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",flashcardactivity.mostCurrent._newsubdecket.runMethod(true,"getText"),_subdeck)) { 
 BA.debugLineNum = 221;BA.debugLine="MsgboxAsync(\"Subdeck Already Exist\", \"Error\")";
Debug.ShouldStop(268435456);
flashcardactivity.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Subdeck Already Exist")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),flashcardactivity.processBA);
 BA.debugLineNum = 222;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("subdeck", _subdeck);
;
 BA.debugLineNum = 225;BA.debugLine="createdeck.Put(newsubdecket.Text, flashcard)";
Debug.ShouldStop(1);
_createdeck.runVoidMethod ("Put",(Object)((flashcardactivity.mostCurrent._newsubdecket.runMethod(true,"getText"))),(Object)((_flashcard.getObject())));
 BA.debugLineNum = 226;BA.debugLine="SaveDecks";
Debug.ShouldStop(2);
_savedecks();
 BA.debugLineNum = 227;BA.debugLine="newsubdecket.Text = \"\"";
Debug.ShouldStop(4);
flashcardactivity.mostCurrent._newsubdecket.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 228;BA.debugLine="newsubdeckpanel.Visible = False";
Debug.ShouldStop(8);
flashcardactivity.mostCurrent._newsubdeckpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 229;BA.debugLine="StartActivity(Subdeck_Module)";
Debug.ShouldStop(16);
flashcardactivity.mostCurrent.__c.runVoidMethod ("StartActivity",flashcardactivity.processBA,(Object)((flashcardactivity.mostCurrent._subdeck_module.getObject())));
 BA.debugLineNum = 230;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _delete_deck_click() throws Exception{
try {
		Debug.PushSubsStack("delete_deck_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,166);
if (RapidSub.canDelegate("delete_deck_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","delete_deck_click");}
 BA.debugLineNum = 166;BA.debugLine="Private Sub delete_deck_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 167;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(64);
flashcardactivity.mostCurrent._decksettingpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 168;BA.debugLine="deleteconfirmation.Visible = True";
Debug.ShouldStop(128);
flashcardactivity.mostCurrent._deleteconfirmation.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 169;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="Private LVdecks As ListView";
flashcardactivity.mostCurrent._lvdecks = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Addbtn As Button";
flashcardactivity.mostCurrent._addbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private addpanel As Panel";
flashcardactivity.mostCurrent._addpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private et1 As EditText";
flashcardactivity.mostCurrent._et1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private decknamelabel As Label";
flashcardactivity.mostCurrent._decknamelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private decksettingpanel As Panel";
flashcardactivity.mostCurrent._decksettingpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private renamepanel As Panel";
flashcardactivity.mostCurrent._renamepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private newdeckname As EditText";
flashcardactivity.mostCurrent._newdeckname = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private newsubdeckpanel As Panel";
flashcardactivity.mostCurrent._newsubdeckpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private newsubdecket As EditText";
flashcardactivity.mostCurrent._newsubdecket = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private deleteconfirmation As Panel";
flashcardactivity.mostCurrent._deleteconfirmation = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lvdecks_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("LVdecks_ItemClick (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,136);
if (RapidSub.canDelegate("lvdecks_itemclick")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","lvdecks_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 136;BA.debugLine="Private Sub LVdecks_ItemClick (Position As Int, Va";
Debug.ShouldStop(128);
 BA.debugLineNum = 138;BA.debugLine="selecteddeck = Value";
Debug.ShouldStop(512);
flashcardactivity._selecteddeck = BA.ObjectToString(_value);
 BA.debugLineNum = 139;BA.debugLine="StartActivity(Subdeck_Module)";
Debug.ShouldStop(1024);
flashcardactivity.mostCurrent.__c.runVoidMethod ("StartActivity",flashcardactivity.processBA,(Object)((flashcardactivity.mostCurrent._subdeck_module.getObject())));
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lvdecks_itemlongclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("LVdecks_ItemLongClick (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,142);
if (RapidSub.canDelegate("lvdecks_itemlongclick")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","lvdecks_itemlongclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 142;BA.debugLine="Private Sub LVdecks_ItemLongClick (Position As Int";
Debug.ShouldStop(8192);
 BA.debugLineNum = 144;BA.debugLine="decksettingpanel.Visible = True";
Debug.ShouldStop(32768);
flashcardactivity.mostCurrent._decksettingpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 145;BA.debugLine="item_longclick = Value";
Debug.ShouldStop(65536);
flashcardactivity._item_longclick = BA.ObjectToString(_value);
 BA.debugLineNum = 146;BA.debugLine="selecteddeck = Value";
Debug.ShouldStop(131072);
flashcardactivity._selecteddeck = BA.ObjectToString(_value);
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI";
flashcardactivity._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 13;BA.debugLine="Dim deck As Map 'to access deck created";
flashcardactivity._deck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 14;BA.debugLine="Dim selecteddeck As String 'selected subdeck as s";
flashcardactivity._selecteddeck = RemoteObject.createImmutable("");
 //BA.debugLineNum = 15;BA.debugLine="Dim item_longclick As String";
flashcardactivity._item_longclick = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim kvs As KeyValueStore";
flashcardactivity._kvs = RemoteObject.createNew ("b4a.example3.keyvaluestore");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _refreshbtn_click() throws Exception{
try {
		Debug.PushSubsStack("refreshbtn_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,128);
if (RapidSub.canDelegate("refreshbtn_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","refreshbtn_click");}
RemoteObject _deckname = RemoteObject.createImmutable("");
 BA.debugLineNum = 128;BA.debugLine="Private Sub refreshbtn_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 130;BA.debugLine="LVdecks.clear";
Debug.ShouldStop(2);
flashcardactivity.mostCurrent._lvdecks.runVoidMethod ("Clear");
 BA.debugLineNum = 131;BA.debugLine="For Each deckName As String In deck.keys";
Debug.ShouldStop(4);
{
final RemoteObject group2 = flashcardactivity._deck.runMethod(false,"Keys");
final int groupLen2 = group2.runMethod(true,"getSize").<Integer>get()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_deckname = BA.ObjectToString(group2.runMethod(false,"Get",index2));Debug.locals.put("deckName", _deckname);
Debug.locals.put("deckName", _deckname);
 BA.debugLineNum = 132;BA.debugLine="LVdecks.AddSingleLine(deckName)";
Debug.ShouldStop(8);
flashcardactivity.mostCurrent._lvdecks.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(_deckname)));
 }
}Debug.locals.put("deckName", _deckname);
;
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rename_deck_click() throws Exception{
try {
		Debug.PushSubsStack("rename_deck_Click (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,161);
if (RapidSub.canDelegate("rename_deck_click")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","rename_deck_click");}
 BA.debugLineNum = 161;BA.debugLine="Private Sub rename_deck_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 162;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(2);
flashcardactivity.mostCurrent._decksettingpanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 163;BA.debugLine="renamepanel.Visible = True";
Debug.ShouldStop(4);
flashcardactivity.mostCurrent._renamepanel.runMethod(true,"setVisible",flashcardactivity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 164;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("SaveDecks (flashcardactivity) ","flashcardactivity",21,flashcardactivity.mostCurrent.activityBA,flashcardactivity.mostCurrent,76);
if (RapidSub.canDelegate("savedecks")) { return b4a.example.flashcardactivity.remoteMe.runUserSub(false, "flashcardactivity","savedecks");}
 BA.debugLineNum = 76;BA.debugLine="Sub SaveDecks";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="kvs.Put(\"deck_data\", deck)";
Debug.ShouldStop(4096);
flashcardactivity._kvs.runVoidMethod ("_put",(Object)(BA.ObjectToString("deck_data")),(Object)((flashcardactivity._deck.getObject())));
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}