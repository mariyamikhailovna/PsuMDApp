package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,47);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _radius = RemoteObject.createImmutable(0);
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 50;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(131072);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 53;BA.debugLine="Dim radius As Int = Addbtn.Width/2";
Debug.ShouldStop(1048576);
_radius = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._addbtn.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("radius", _radius);Debug.locals.put("radius", _radius);
 BA.debugLineNum = 54;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(2097152);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 55;BA.debugLine="cd.Initialize(Colors.Gray, radius)";
Debug.ShouldStop(4194304);
_cd.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray")),(Object)(_radius));
 BA.debugLineNum = 56;BA.debugLine="Addbtn.Background = cd";
Debug.ShouldStop(8388608);
main.mostCurrent._addbtn.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 59;BA.debugLine="LVdecks.SingleLineLayout.Label.textcolor = Colors";
Debug.ShouldStop(67108864);
main.mostCurrent._lvdecks.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 82;BA.debugLine="kvs.Initialize(File.DirInternal, \"mydata\")";
Debug.ShouldStop(131072);
main._kvs.runClassMethod (b4a.example.keyvaluestore.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("mydata")));
 BA.debugLineNum = 83;BA.debugLine="If  kvs.ContainsKey(\"deck_data\") Then";
Debug.ShouldStop(262144);
if (main._kvs.runClassMethod (b4a.example.keyvaluestore.class, "_containskey" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("deck_data"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 84;BA.debugLine="deck = kvs.Get(\"deck_data\")";
Debug.ShouldStop(524288);
main._deck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), main._kvs.runClassMethod (b4a.example.keyvaluestore.class, "_get" /*RemoteObject*/ ,(Object)(RemoteObject.createImmutable("deck_data"))));
 }else {
 BA.debugLineNum = 86;BA.debugLine="deck.Initialize";
Debug.ShouldStop(2097152);
main._deck.runVoidMethod ("Initialize");
 };
 BA.debugLineNum = 92;BA.debugLine="refreshbtn_Click";
Debug.ShouldStop(134217728);
_refreshbtn_click();
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,101);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 101;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,97);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 97;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1);
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Addbtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,109);
if (RapidSub.canDelegate("addbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","addbtn_click");}
 BA.debugLineNum = 109;BA.debugLine="Private Sub Addbtn_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 111;BA.debugLine="If addpanel.Visible = True Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",main.mostCurrent._addpanel.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 112;BA.debugLine="addpanel.Visible = False";
Debug.ShouldStop(32768);
main.mostCurrent._addpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 114;BA.debugLine="addpanel.Visible = True";
Debug.ShouldStop(131072);
main.mostCurrent._addpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("addcards_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,180);
if (RapidSub.canDelegate("addcards_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","addcards_click");}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 180;BA.debugLine="Private Sub addcards_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 181;BA.debugLine="Dim tappeddeck As Map = deck.Get(item_longclick)";
Debug.ShouldStop(1048576);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), main._deck.runMethod(false,"Get",(Object)((main._item_longclick))));Debug.locals.put("tappeddeck", _tappeddeck);Debug.locals.put("tappeddeck", _tappeddeck);
 BA.debugLineNum = 182;BA.debugLine="If tappeddeck.Size = 0 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_tappeddeck.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 183;BA.debugLine="MsgboxAsync(\"Create A Sub-Deck first\", \"Error\")";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Create A Sub-Deck first")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),main.processBA);
 BA.debugLineNum = 184;BA.debugLine="Return";
Debug.ShouldStop(8388608);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 186;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(33554432);
main.mostCurrent._decksettingpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 187;BA.debugLine="StartActivity(Add_Card_Module)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._add_card_module.getObject())));
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("browse_cards_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,205);
if (RapidSub.canDelegate("browse_cards_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","browse_cards_click");}
 BA.debugLineNum = 205;BA.debugLine="Private Sub browse_cards_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 206;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(8192);
main.mostCurrent._decksettingpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 207;BA.debugLine="StartActivity(DECK_ALL_CARDS)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._deck_all_cards.getObject())));
 BA.debugLineNum = 208;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("cancel_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,117);
if (RapidSub.canDelegate("cancel_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","cancel_click");}
 BA.debugLineNum = 117;BA.debugLine="Private Sub cancel_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 119;BA.debugLine="addpanel.Visible = False";
Debug.ShouldStop(4194304);
main.mostCurrent._addpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 121;BA.debugLine="et1.Text = \"\"";
Debug.ShouldStop(16777216);
main.mostCurrent._et1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("cancelbtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,210);
if (RapidSub.canDelegate("cancelbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","cancelbtn_click");}
 BA.debugLineNum = 210;BA.debugLine="Private Sub cancelbtn_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 211;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(262144);
main.mostCurrent._decksettingpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 212;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("canceldelete_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,273);
if (RapidSub.canDelegate("canceldelete_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","canceldelete_click");}
 BA.debugLineNum = 273;BA.debugLine="Private Sub canceldelete_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 274;BA.debugLine="deleteconfirmation.Visible = False";
Debug.ShouldStop(131072);
main.mostCurrent._deleteconfirmation.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 275;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("cancelnew_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,235);
if (RapidSub.canDelegate("cancelnew_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","cancelnew_click");}
 BA.debugLineNum = 235;BA.debugLine="Private Sub cancelnew_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 236;BA.debugLine="newdeckname.text = False";
Debug.ShouldStop(2048);
main.mostCurrent._newdeckname.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 237;BA.debugLine="renamepanel.Visible = False";
Debug.ShouldStop(4096);
main.mostCurrent._renamepanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 238;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("cancelnewsubdeck_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,261);
if (RapidSub.canDelegate("cancelnewsubdeck_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","cancelnewsubdeck_click");}
 BA.debugLineNum = 261;BA.debugLine="Private Sub cancelnewsubdeck_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 262;BA.debugLine="newsubdecket.Text = \"\"";
Debug.ShouldStop(32);
main.mostCurrent._newsubdecket.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 263;BA.debugLine="newsubdeckpanel.Visible = False";
Debug.ShouldStop(64);
main.mostCurrent._newsubdeckpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 264;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("confirmdelete_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,266);
if (RapidSub.canDelegate("confirmdelete_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","confirmdelete_click");}
 BA.debugLineNum = 266;BA.debugLine="Private Sub confirmdelete_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 267;BA.debugLine="deck.Remove(item_longclick)";
Debug.ShouldStop(1024);
main._deck.runVoidMethod ("Remove",(Object)((main._item_longclick)));
 BA.debugLineNum = 268;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(2048);
main.mostCurrent._decksettingpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 269;BA.debugLine="deleteconfirmation.Visible = false";
Debug.ShouldStop(4096);
main.mostCurrent._deleteconfirmation.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 270;BA.debugLine="refreshbtn_Click";
Debug.ShouldStop(8192);
_refreshbtn_click();
 BA.debugLineNum = 271;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("confirmnew_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,214);
if (RapidSub.canDelegate("confirmnew_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","confirmnew_click");}
RemoteObject _getsubdeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _names = RemoteObject.createImmutable("");
 BA.debugLineNum = 214;BA.debugLine="Private Sub confirmnew_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 215;BA.debugLine="Dim getsubdeck As Map";
Debug.ShouldStop(4194304);
_getsubdeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("getsubdeck", _getsubdeck);
 BA.debugLineNum = 216;BA.debugLine="If newdeckname.Text = \"\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",main.mostCurrent._newdeckname.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 217;BA.debugLine="MsgboxAsync(\"New Name must have a name\", \"Error\"";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("New Name must have a name")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),main.processBA);
 BA.debugLineNum = 218;BA.debugLine="Return";
Debug.ShouldStop(33554432);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 220;BA.debugLine="For Each names As String In deck.keys";
Debug.ShouldStop(134217728);
{
final RemoteObject group6 = main._deck.runMethod(false,"Keys");
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_names = BA.ObjectToString(group6.runMethod(false,"Get",index6));Debug.locals.put("names", _names);
Debug.locals.put("names", _names);
 BA.debugLineNum = 221;BA.debugLine="getsubdeck = deck.Get(item_longclick)";
Debug.ShouldStop(268435456);
_getsubdeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), main._deck.runMethod(false,"Get",(Object)((main._item_longclick))));Debug.locals.put("getsubdeck", _getsubdeck);
 BA.debugLineNum = 222;BA.debugLine="If newdeckname.Text = names Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",main.mostCurrent._newdeckname.runMethod(true,"getText"),_names)) { 
 BA.debugLineNum = 223;BA.debugLine="MsgboxAsync(\"Deck Name Already Exist\", \"Error\")";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Deck Name Already Exist")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),main.processBA);
 BA.debugLineNum = 224;BA.debugLine="Return";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("names", _names);
;
 BA.debugLineNum = 227;BA.debugLine="deck.Remove(item_longclick)";
Debug.ShouldStop(4);
main._deck.runVoidMethod ("Remove",(Object)((main._item_longclick)));
 BA.debugLineNum = 228;BA.debugLine="deck.Put(newdeckname.Text, getsubdeck)";
Debug.ShouldStop(8);
main._deck.runVoidMethod ("Put",(Object)((main.mostCurrent._newdeckname.runMethod(true,"getText"))),(Object)((_getsubdeck.getObject())));
 BA.debugLineNum = 229;BA.debugLine="newdeckname.text = \"\"";
Debug.ShouldStop(16);
main.mostCurrent._newdeckname.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 230;BA.debugLine="SaveDecks";
Debug.ShouldStop(32);
_savedecks();
 BA.debugLineNum = 231;BA.debugLine="refreshbtn_Click";
Debug.ShouldStop(64);
_refreshbtn_click();
 BA.debugLineNum = 232;BA.debugLine="renamepanel.Visible = False";
Debug.ShouldStop(128);
main.mostCurrent._renamepanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("create_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,125);
if (RapidSub.canDelegate("create_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","create_click");}
RemoteObject _newsubdeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _names = RemoteObject.createImmutable("");
 BA.debugLineNum = 125;BA.debugLine="Private Sub create_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 128;BA.debugLine="Dim newsubdeck As Map";
Debug.ShouldStop(-2147483648);
_newsubdeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("newsubdeck", _newsubdeck);
 BA.debugLineNum = 130;BA.debugLine="newsubdeck.initialize";
Debug.ShouldStop(2);
_newsubdeck.runVoidMethod ("Initialize");
 BA.debugLineNum = 133;BA.debugLine="For Each names As String In deck.Keys";
Debug.ShouldStop(16);
{
final RemoteObject group3 = main._deck.runMethod(false,"Keys");
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_names = BA.ObjectToString(group3.runMethod(false,"Get",index3));Debug.locals.put("names", _names);
Debug.locals.put("names", _names);
 BA.debugLineNum = 134;BA.debugLine="If et1.Text = names Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",main.mostCurrent._et1.runMethod(true,"getText"),_names)) { 
 BA.debugLineNum = 135;BA.debugLine="MsgboxAsync(\"Deck Already Exist\", \"Error\")";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Deck Already Exist")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),main.processBA);
 BA.debugLineNum = 136;BA.debugLine="Return";
Debug.ShouldStop(128);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("names", _names);
;
 BA.debugLineNum = 141;BA.debugLine="If et1.Text = \"\" Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",main.mostCurrent._et1.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 142;BA.debugLine="MsgboxAsync(\"Deck must have a name\", \"Error\")";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Deck must have a name")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),main.processBA);
 }else {
 BA.debugLineNum = 145;BA.debugLine="addpanel.Visible = False";
Debug.ShouldStop(65536);
main.mostCurrent._addpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 146;BA.debugLine="LVdecks.AddSingleLine(et1.Text)";
Debug.ShouldStop(131072);
main.mostCurrent._lvdecks.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(main.mostCurrent._et1.runMethod(true,"getText"))));
 BA.debugLineNum = 149;BA.debugLine="deck.Put(et1.Text, newsubdeck)";
Debug.ShouldStop(1048576);
main._deck.runVoidMethod ("Put",(Object)((main.mostCurrent._et1.runMethod(true,"getText"))),(Object)((_newsubdeck.getObject())));
 BA.debugLineNum = 150;BA.debugLine="SaveDecks";
Debug.ShouldStop(2097152);
_savedecks();
 BA.debugLineNum = 152;BA.debugLine="et1.Text = \"\"";
Debug.ShouldStop(8388608);
main.mostCurrent._et1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("create_subdeck_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,200);
if (RapidSub.canDelegate("create_subdeck_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","create_subdeck_click");}
 BA.debugLineNum = 200;BA.debugLine="Private Sub create_subdeck_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 201;BA.debugLine="newsubdeckpanel.Visible = True";
Debug.ShouldStop(256);
main.mostCurrent._newsubdeckpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 202;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(512);
main.mostCurrent._decksettingpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 203;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("createnewsubdeck_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,240);
if (RapidSub.canDelegate("createnewsubdeck_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","createnewsubdeck_click");}
RemoteObject _createdeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _flashcard = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _subdeck = RemoteObject.createImmutable("");
 BA.debugLineNum = 240;BA.debugLine="Private Sub createnewsubdeck_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 241;BA.debugLine="If newsubdecket.Text = \"\" Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",main.mostCurrent._newsubdecket.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 242;BA.debugLine="MsgboxAsync(\"New Sub Deck must have a name\", \"Er";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("New Sub Deck must have a name")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),main.processBA);
 BA.debugLineNum = 243;BA.debugLine="Return";
Debug.ShouldStop(262144);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 245;BA.debugLine="Dim createdeck As Map = deck.Get(item_longclick)";
Debug.ShouldStop(1048576);
_createdeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_createdeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), main._deck.runMethod(false,"Get",(Object)((main._item_longclick))));Debug.locals.put("createdeck", _createdeck);Debug.locals.put("createdeck", _createdeck);
 BA.debugLineNum = 246;BA.debugLine="Dim flashcard As List";
Debug.ShouldStop(2097152);
_flashcard = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("flashcard", _flashcard);
 BA.debugLineNum = 247;BA.debugLine="flashcard.Initialize";
Debug.ShouldStop(4194304);
_flashcard.runVoidMethod ("Initialize");
 BA.debugLineNum = 248;BA.debugLine="For Each subdeck As String In createdeck.Keys";
Debug.ShouldStop(8388608);
{
final RemoteObject group8 = _createdeck.runMethod(false,"Keys");
final int groupLen8 = group8.runMethod(true,"getSize").<Integer>get()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_subdeck = BA.ObjectToString(group8.runMethod(false,"Get",index8));Debug.locals.put("subdeck", _subdeck);
Debug.locals.put("subdeck", _subdeck);
 BA.debugLineNum = 249;BA.debugLine="If newsubdecket.Text = subdeck Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",main.mostCurrent._newsubdecket.runMethod(true,"getText"),_subdeck)) { 
 BA.debugLineNum = 250;BA.debugLine="MsgboxAsync(\"Subdeck Already Exist\", \"Error\")";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Subdeck Already Exist")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),main.processBA);
 BA.debugLineNum = 251;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("subdeck", _subdeck);
;
 BA.debugLineNum = 254;BA.debugLine="createdeck.Put(newsubdecket.Text, flashcard)";
Debug.ShouldStop(536870912);
_createdeck.runVoidMethod ("Put",(Object)((main.mostCurrent._newsubdecket.runMethod(true,"getText"))),(Object)((_flashcard.getObject())));
 BA.debugLineNum = 255;BA.debugLine="SaveDecks";
Debug.ShouldStop(1073741824);
_savedecks();
 BA.debugLineNum = 256;BA.debugLine="newsubdecket.Text = \"\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._newsubdecket.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 257;BA.debugLine="newsubdeckpanel.Visible = False";
Debug.ShouldStop(1);
main.mostCurrent._newsubdeckpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 258;BA.debugLine="StartActivity(Subdeck_Module)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._subdeck_module.getObject())));
 BA.debugLineNum = 259;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("delete_deck_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,195);
if (RapidSub.canDelegate("delete_deck_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","delete_deck_click");}
 BA.debugLineNum = 195;BA.debugLine="Private Sub delete_deck_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 196;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(8);
main.mostCurrent._decksettingpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 197;BA.debugLine="deleteconfirmation.Visible = True";
Debug.ShouldStop(16);
main.mostCurrent._deleteconfirmation.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 31;BA.debugLine="Private LVdecks As ListView";
main.mostCurrent._lvdecks = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private Addbtn As Button";
main.mostCurrent._addbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private addpanel As Panel";
main.mostCurrent._addpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private et1 As EditText";
main.mostCurrent._et1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private decknamelabel As Label";
main.mostCurrent._decknamelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private decksettingpanel As Panel";
main.mostCurrent._decksettingpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private renamepanel As Panel";
main.mostCurrent._renamepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private newdeckname As EditText";
main.mostCurrent._newdeckname = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private newsubdeckpanel As Panel";
main.mostCurrent._newsubdeckpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private newsubdecket As EditText";
main.mostCurrent._newsubdecket = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private deleteconfirmation As Panel";
main.mostCurrent._deleteconfirmation = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lvdecks_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("LVdecks_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,165);
if (RapidSub.canDelegate("lvdecks_itemclick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","lvdecks_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 165;BA.debugLine="Private Sub LVdecks_ItemClick (Position As Int, Va";
Debug.ShouldStop(16);
 BA.debugLineNum = 167;BA.debugLine="selecteddeck = Value";
Debug.ShouldStop(64);
main._selecteddeck = BA.ObjectToString(_value);
 BA.debugLineNum = 168;BA.debugLine="StartActivity(Subdeck_Module)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._subdeck_module.getObject())));
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
public static RemoteObject  _lvdecks_itemlongclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("LVdecks_ItemLongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,171);
if (RapidSub.canDelegate("lvdecks_itemlongclick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","lvdecks_itemlongclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 171;BA.debugLine="Private Sub LVdecks_ItemLongClick (Position As Int";
Debug.ShouldStop(1024);
 BA.debugLineNum = 173;BA.debugLine="decksettingpanel.Visible = True";
Debug.ShouldStop(4096);
main.mostCurrent._decksettingpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 174;BA.debugLine="item_longclick = Value";
Debug.ShouldStop(8192);
main._item_longclick = BA.ObjectToString(_value);
 BA.debugLineNum = 175;BA.debugLine="selecteddeck = Value";
Debug.ShouldStop(16384);
main._selecteddeck = BA.ObjectToString(_value);
 BA.debugLineNum = 176;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
subdeck_module_subs_0._process_globals();
card_module_subs_0._process_globals();
all_active_recall_subs_0._process_globals();
add_card_module2_subs_0._process_globals();
deck_all_cards_subs_0._process_globals();
add_card_module_subs_0._process_globals();
active_recall_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
subdeck_module.myClass = BA.getDeviceClass ("b4a.example.subdeck_module");
card_module.myClass = BA.getDeviceClass ("b4a.example.card_module");
all_active_recall.myClass = BA.getDeviceClass ("b4a.example.all_active_recall");
add_card_module2.myClass = BA.getDeviceClass ("b4a.example.add_card_module2");
deck_all_cards.myClass = BA.getDeviceClass ("b4a.example.deck_all_cards");
add_card_module.myClass = BA.getDeviceClass ("b4a.example.add_card_module");
active_recall.myClass = BA.getDeviceClass ("b4a.example.active_recall");
keyvaluestore.myClass = BA.getDeviceClass ("b4a.example.keyvaluestore");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 22;BA.debugLine="Dim deck As Map 'to access deck created";
main._deck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 23;BA.debugLine="Dim selecteddeck As String 'selected subdeck as s";
main._selecteddeck = RemoteObject.createImmutable("");
 //BA.debugLineNum = 24;BA.debugLine="Dim item_longclick As String";
main._item_longclick = RemoteObject.createImmutable("");
 //BA.debugLineNum = 25;BA.debugLine="Dim kvs As KeyValueStore";
main._kvs = RemoteObject.createNew ("b4a.example.keyvaluestore");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _refreshbtn_click() throws Exception{
try {
		Debug.PushSubsStack("refreshbtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,157);
if (RapidSub.canDelegate("refreshbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","refreshbtn_click");}
RemoteObject _deckname = RemoteObject.createImmutable("");
 BA.debugLineNum = 157;BA.debugLine="Private Sub refreshbtn_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 159;BA.debugLine="LVdecks.clear";
Debug.ShouldStop(1073741824);
main.mostCurrent._lvdecks.runVoidMethod ("Clear");
 BA.debugLineNum = 160;BA.debugLine="For Each deckName As String In deck.keys";
Debug.ShouldStop(-2147483648);
{
final RemoteObject group2 = main._deck.runMethod(false,"Keys");
final int groupLen2 = group2.runMethod(true,"getSize").<Integer>get()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_deckname = BA.ObjectToString(group2.runMethod(false,"Get",index2));Debug.locals.put("deckName", _deckname);
Debug.locals.put("deckName", _deckname);
 BA.debugLineNum = 161;BA.debugLine="LVdecks.AddSingleLine(deckName)";
Debug.ShouldStop(1);
main.mostCurrent._lvdecks.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(_deckname)));
 }
}Debug.locals.put("deckName", _deckname);
;
 BA.debugLineNum = 163;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("rename_deck_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,190);
if (RapidSub.canDelegate("rename_deck_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","rename_deck_click");}
 BA.debugLineNum = 190;BA.debugLine="Private Sub rename_deck_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 191;BA.debugLine="decksettingpanel.Visible = False";
Debug.ShouldStop(1073741824);
main.mostCurrent._decksettingpanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 192;BA.debugLine="renamepanel.Visible = True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._renamepanel.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 193;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("SaveDecks (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,105);
if (RapidSub.canDelegate("savedecks")) { return b4a.example.main.remoteMe.runUserSub(false, "main","savedecks");}
 BA.debugLineNum = 105;BA.debugLine="Sub SaveDecks";
Debug.ShouldStop(256);
 BA.debugLineNum = 106;BA.debugLine="kvs.Put(\"deck_data\", deck)";
Debug.ShouldStop(512);
main._kvs.runClassMethod (b4a.example.keyvaluestore.class, "_put" /*RemoteObject*/ ,(Object)(BA.ObjectToString("deck_data")),(Object)((main._deck.getObject())));
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
}