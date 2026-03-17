package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class card_module_subs_0 {


public static RemoteObject  _activerecall_click() throws Exception{
try {
		Debug.PushSubsStack("activerecall_Click (card_module) ","card_module",3,card_module.mostCurrent.activityBA,card_module.mostCurrent,121);
if (RapidSub.canDelegate("activerecall_click")) { return b4a.example.card_module.remoteMe.runUserSub(false, "card_module","activerecall_click");}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _subdeckcards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _number_of_cards = RemoteObject.createImmutable(0);
 BA.debugLineNum = 121;BA.debugLine="Private Sub activerecall_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 123;BA.debugLine="Dim tappedDeck As Map = Main.deck.Get(Main.select";
Debug.ShouldStop(67108864);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), card_module.mostCurrent._main._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((card_module.mostCurrent._main._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappedDeck", _tappeddeck);Debug.locals.put("tappedDeck", _tappeddeck);
 BA.debugLineNum = 124;BA.debugLine="Dim subdeckcards As List = tappedDeck.Get(Subdeck";
Debug.ShouldStop(134217728);
_subdeckcards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_subdeckcards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _tappeddeck.runMethod(false,"Get",(Object)((card_module.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ))));Debug.locals.put("subdeckcards", _subdeckcards);Debug.locals.put("subdeckcards", _subdeckcards);
 BA.debugLineNum = 125;BA.debugLine="Dim number_of_cards As Int = subdeckcards.size";
Debug.ShouldStop(268435456);
_number_of_cards = _subdeckcards.runMethod(true,"getSize");Debug.locals.put("number_of_cards", _number_of_cards);Debug.locals.put("number_of_cards", _number_of_cards);
 BA.debugLineNum = 127;BA.debugLine="If number_of_cards = 0 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_number_of_cards,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 128;BA.debugLine="MsgboxAsync(\"No cards available\", \"Error\")";
Debug.ShouldStop(-2147483648);
card_module.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("No cards available")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),card_module.processBA);
 BA.debugLineNum = 129;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 131;BA.debugLine="StartActivity(ACTIVE_RECALL)";
Debug.ShouldStop(4);
card_module.mostCurrent.__c.runVoidMethod ("StartActivity",card_module.processBA,(Object)((card_module.mostCurrent._active_recall.getObject())));
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (card_module) ","card_module",3,card_module.mostCurrent.activityBA,card_module.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.card_module.remoteMe.runUserSub(false, "card_module","activity_create", _firsttime);}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _subdeckcards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"Layout4\")";
Debug.ShouldStop(16777216);
card_module.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout4")),card_module.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="subdecklabel.Text = Subdeck_Module.selectedsubdec";
Debug.ShouldStop(67108864);
card_module.mostCurrent._subdecklabel.runMethod(true,"setText",BA.ObjectToCharSequence(card_module.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ));
 BA.debugLineNum = 29;BA.debugLine="Dim tappedDeck As Map = Main.deck.Get(Main.select";
Debug.ShouldStop(268435456);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), card_module.mostCurrent._main._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((card_module.mostCurrent._main._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappedDeck", _tappeddeck);Debug.locals.put("tappedDeck", _tappeddeck);
 BA.debugLineNum = 30;BA.debugLine="Dim subdeckcards As List = tappedDeck.Get(Subdeck";
Debug.ShouldStop(536870912);
_subdeckcards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_subdeckcards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _tappeddeck.runMethod(false,"Get",(Object)((card_module.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ))));Debug.locals.put("subdeckcards", _subdeckcards);Debug.locals.put("subdeckcards", _subdeckcards);
 BA.debugLineNum = 33;BA.debugLine="ShowSubdeckCards(subdeckcards)";
Debug.ShouldStop(1);
_showsubdeckcards(_subdeckcards);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Pause (card_module) ","card_module",3,card_module.mostCurrent.activityBA,card_module.mostCurrent,110);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.card_module.remoteMe.runUserSub(false, "card_module","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 110;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 112;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (card_module) ","card_module",3,card_module.mostCurrent.activityBA,card_module.mostCurrent,103);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.card_module.remoteMe.runUserSub(false, "card_module","activity_resume");}
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _subdeckcards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 103;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 105;BA.debugLine="Dim tappedDeck As Map = Main.deck.Get(Main.select";
Debug.ShouldStop(256);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), card_module.mostCurrent._main._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((card_module.mostCurrent._main._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappedDeck", _tappeddeck);Debug.locals.put("tappedDeck", _tappeddeck);
 BA.debugLineNum = 106;BA.debugLine="Dim subdeckcards As List = tappedDeck.Get(Subdeck";
Debug.ShouldStop(512);
_subdeckcards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_subdeckcards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _tappeddeck.runMethod(false,"Get",(Object)((card_module.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ))));Debug.locals.put("subdeckcards", _subdeckcards);Debug.locals.put("subdeckcards", _subdeckcards);
 BA.debugLineNum = 107;BA.debugLine="ShowSubdeckCards(subdeckcards)";
Debug.ShouldStop(1024);
_showsubdeckcards(_subdeckcards);
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("addbtn_Click (card_module) ","card_module",3,card_module.mostCurrent.activityBA,card_module.mostCurrent,134);
if (RapidSub.canDelegate("addbtn_click")) { return b4a.example.card_module.remoteMe.runUserSub(false, "card_module","addbtn_click");}
 BA.debugLineNum = 134;BA.debugLine="Private Sub addbtn_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 136;BA.debugLine="subdeck = Subdeck_Module.selectedsubdeck";
Debug.ShouldStop(128);
card_module._subdeck = card_module.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ;
 BA.debugLineNum = 137;BA.debugLine="StartActivity(Add_Card_Module2)";
Debug.ShouldStop(256);
card_module.mostCurrent.__c.runVoidMethod ("StartActivity",card_module.processBA,(Object)((card_module.mostCurrent._add_card_module2.getObject())));
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
public static RemoteObject  _backbtn_click() throws Exception{
try {
		Debug.PushSubsStack("backbtn_Click (card_module) ","card_module",3,card_module.mostCurrent.activityBA,card_module.mostCurrent,116);
if (RapidSub.canDelegate("backbtn_click")) { return b4a.example.card_module.remoteMe.runUserSub(false, "card_module","backbtn_click");}
 BA.debugLineNum = 116;BA.debugLine="Private Sub backbtn_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 118;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2097152);
card_module.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deletebtn_click() throws Exception{
try {
		Debug.PushSubsStack("deletebtn_click (card_module) ","card_module",3,card_module.mostCurrent.activityBA,card_module.mostCurrent,92);
if (RapidSub.canDelegate("deletebtn_click")) { return b4a.example.card_module.remoteMe.runUserSub(false, "card_module","deletebtn_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _cards = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 92;BA.debugLine="Sub deletebtn_click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 94;BA.debugLine="Dim b As Button = Sender";
Debug.ShouldStop(536870912);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), card_module.mostCurrent.__c.runMethod(false,"Sender",card_module.mostCurrent.activityBA));Debug.locals.put("b", _b);Debug.locals.put("b", _b);
 BA.debugLineNum = 95;BA.debugLine="Dim index As Int = b.Tag";
Debug.ShouldStop(1073741824);
_index = BA.numberCast(int.class, _b.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 96;BA.debugLine="Dim tappedDeck As Map = Main.deck.Get(Main.select";
Debug.ShouldStop(-2147483648);
_tappeddeck = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_tappeddeck = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), card_module.mostCurrent._main._deck /*RemoteObject*/ .runMethod(false,"Get",(Object)((card_module.mostCurrent._main._selecteddeck /*RemoteObject*/ ))));Debug.locals.put("tappedDeck", _tappeddeck);Debug.locals.put("tappedDeck", _tappeddeck);
 BA.debugLineNum = 97;BA.debugLine="Dim cards As List = tappedDeck.Get(Subdeck_Module";
Debug.ShouldStop(1);
_cards = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_cards = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _tappeddeck.runMethod(false,"Get",(Object)((card_module.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ))));Debug.locals.put("cards", _cards);Debug.locals.put("cards", _cards);
 BA.debugLineNum = 99;BA.debugLine="cards.RemoveAt(index)";
Debug.ShouldStop(4);
_cards.runVoidMethod ("RemoveAt",(Object)(_index));
 BA.debugLineNum = 100;BA.debugLine="ShowSubdeckCards(cards)";
Debug.ShouldStop(8);
_showsubdeckcards(_cards);
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
public static RemoteObject  _editbtn_click() throws Exception{
try {
		Debug.PushSubsStack("editbtn_Click (card_module) ","card_module",3,card_module.mostCurrent.activityBA,card_module.mostCurrent,80);
if (RapidSub.canDelegate("editbtn_click")) { return b4a.example.card_module.remoteMe.runUserSub(false, "card_module","editbtn_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _index = RemoteObject.createImmutable(0);
 BA.debugLineNum = 80;BA.debugLine="Sub editbtn_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 82;BA.debugLine="subdeck = Subdeck_Module.selectedsubdeck";
Debug.ShouldStop(131072);
card_module._subdeck = card_module.mostCurrent._subdeck_module._selectedsubdeck /*RemoteObject*/ ;
 BA.debugLineNum = 83;BA.debugLine="Dim b As Button = Sender";
Debug.ShouldStop(262144);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
_b = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ButtonWrapper"), card_module.mostCurrent.__c.runMethod(false,"Sender",card_module.mostCurrent.activityBA));Debug.locals.put("b", _b);Debug.locals.put("b", _b);
 BA.debugLineNum = 84;BA.debugLine="Dim index As Int = b.Tag";
Debug.ShouldStop(524288);
_index = BA.numberCast(int.class, _b.runMethod(false,"getTag"));Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 85;BA.debugLine="editindex = index";
Debug.ShouldStop(1048576);
card_module._editindex = _index;
 BA.debugLineNum = 86;BA.debugLine="isEdit = True";
Debug.ShouldStop(2097152);
card_module._isedit = card_module.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 88;BA.debugLine="StartActivity(Add_Card_Module2)";
Debug.ShouldStop(8388608);
card_module.mostCurrent.__c.runVoidMethod ("StartActivity",card_module.processBA,(Object)((card_module.mostCurrent._add_card_module2.getObject())));
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private subdecklabel As Label";
card_module.mostCurrent._subdecklabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private ScrollView1 As ScrollView";
card_module.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim subdeck As String";
card_module._subdeck = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="Dim isEdit As Boolean";
card_module._isedit = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 11;BA.debugLine="Dim editindex As Int";
card_module._editindex = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showsubdeckcards(RemoteObject _cardslist) throws Exception{
try {
		Debug.PushSubsStack("ShowSubdeckCards (card_module) ","card_module",3,card_module.mostCurrent.activityBA,card_module.mostCurrent,37);
if (RapidSub.canDelegate("showsubdeckcards")) { return b4a.example.card_module.remoteMe.runUserSub(false, "card_module","showsubdeckcards", _cardslist);}
RemoteObject _toppos = RemoteObject.createImmutable(0);
RemoteObject _cardheight = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _card = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _btnwidth = RemoteObject.createImmutable(0);
RemoteObject _editbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _deletebtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("cardsList", _cardslist);
 BA.debugLineNum = 37;BA.debugLine="Sub ShowSubdeckCards(cardsList As List)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="ScrollView1.Panel.RemoveAllViews";
Debug.ShouldStop(64);
card_module.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 41;BA.debugLine="Dim topPos As Int = 0";
Debug.ShouldStop(256);
_toppos = BA.numberCast(int.class, 0);Debug.locals.put("topPos", _toppos);Debug.locals.put("topPos", _toppos);
 BA.debugLineNum = 42;BA.debugLine="Dim cardHeight As Int = 150dip 'height";
Debug.ShouldStop(512);
_cardheight = card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 150)));Debug.locals.put("cardHeight", _cardheight);Debug.locals.put("cardHeight", _cardheight);
 BA.debugLineNum = 44;BA.debugLine="For i = 0 To cardsList.Size -1";
Debug.ShouldStop(2048);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_cardslist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 45;BA.debugLine="Dim card As Map = cardsList.Get(i)";
Debug.ShouldStop(4096);
_card = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_card = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _cardslist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("card", _card);Debug.locals.put("card", _card);
 BA.debugLineNum = 46;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(8192);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 47;BA.debugLine="p.Initialize(\"\")";
Debug.ShouldStop(16384);
_p.runVoidMethod ("Initialize",card_module.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 48;BA.debugLine="p.Color = Colors.White";
Debug.ShouldStop(32768);
_p.runVoidMethod ("setColor",card_module.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 49;BA.debugLine="ScrollView1.Panel.AddView(p, 10dip, topPos, Scrol";
Debug.ShouldStop(65536);
card_module.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_toppos),(Object)(RemoteObject.solve(new RemoteObject[] {card_module.mostCurrent._scrollview1.runMethod(true,"getWidth"),card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(_cardheight));
 BA.debugLineNum = 51;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(262144);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 52;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(524288);
_lbl.runVoidMethod ("Initialize",card_module.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 53;BA.debugLine="lbl.Text = \"Q: \" & card.Get(\"Q\") & CRLF & \"A: \"";
Debug.ShouldStop(1048576);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Q: "),_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Q")))),card_module.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("A: "),_card.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("A")))))));
 BA.debugLineNum = 54;BA.debugLine="lbl.TextColor = Colors.black";
Debug.ShouldStop(2097152);
_lbl.runMethod(true,"setTextColor",card_module.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 55;BA.debugLine="lbl.TextSize = 12";
Debug.ShouldStop(4194304);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 56;BA.debugLine="lbl.SingleLine = False";
Debug.ShouldStop(8388608);
_lbl.runVoidMethod ("setSingleLine",card_module.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 58;BA.debugLine="p.AddView(lbl, 10dip, 10dip, ScrollView1.Width -";
Debug.ShouldStop(33554432);
_p.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {card_module.mostCurrent._scrollview1.runMethod(true,"getWidth"),card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 59;BA.debugLine="topPos = topPos + lbl.height + 10dip";
Debug.ShouldStop(67108864);
_toppos = RemoteObject.solve(new RemoteObject[] {_toppos,_lbl.runMethod(true,"getHeight"),card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1);Debug.locals.put("topPos", _toppos);
 BA.debugLineNum = 61;BA.debugLine="Dim btnwidth As Int = 100dip";
Debug.ShouldStop(268435456);
_btnwidth = card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)));Debug.locals.put("btnwidth", _btnwidth);Debug.locals.put("btnwidth", _btnwidth);
 BA.debugLineNum = 63;BA.debugLine="Dim editbtn As Button";
Debug.ShouldStop(1073741824);
_editbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("editbtn", _editbtn);
 BA.debugLineNum = 64;BA.debugLine="editbtn.Initialize(\"Editbtn\") 'btn name";
Debug.ShouldStop(-2147483648);
_editbtn.runVoidMethod ("Initialize",card_module.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Editbtn")));
 BA.debugLineNum = 65;BA.debugLine="editbtn.Tag = i 'tag/index";
Debug.ShouldStop(1);
_editbtn.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 66;BA.debugLine="editbtn.Text = \"Edit\" 'button text display";
Debug.ShouldStop(2);
_editbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Edit"));
 BA.debugLineNum = 67;BA.debugLine="p.AddView(editbtn, 10dip, 115dip, btnwidth, 40di";
Debug.ShouldStop(4);
_p.runVoidMethod ("AddView",(Object)((_editbtn.getObject())),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 115)))),(Object)(_btnwidth),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 69;BA.debugLine="Dim deletebtn As Button";
Debug.ShouldStop(16);
_deletebtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("deletebtn", _deletebtn);
 BA.debugLineNum = 70;BA.debugLine="deletebtn.Initialize(\"Deletebtn\")";
Debug.ShouldStop(32);
_deletebtn.runVoidMethod ("Initialize",card_module.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Deletebtn")));
 BA.debugLineNum = 71;BA.debugLine="deletebtn.Tag = i";
Debug.ShouldStop(64);
_deletebtn.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 72;BA.debugLine="deletebtn.Text = \"Delete\"";
Debug.ShouldStop(128);
_deletebtn.runMethod(true,"setText",BA.ObjectToCharSequence("Delete"));
 BA.debugLineNum = 73;BA.debugLine="p.AddView(deletebtn, 200dip, 115dip, btnwidth, 4";
Debug.ShouldStop(256);
_p.runVoidMethod ("AddView",(Object)((_deletebtn.getObject())),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 115)))),(Object)(_btnwidth),(Object)(card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 74;BA.debugLine="topPos = topPos + cardHeight + 10dip";
Debug.ShouldStop(512);
_toppos = RemoteObject.solve(new RemoteObject[] {_toppos,_cardheight,card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++",2, 1);Debug.locals.put("topPos", _toppos);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 76;BA.debugLine="ScrollView1.Panel.Height = topPos + 10dip";
Debug.ShouldStop(2048);
card_module.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_toppos,card_module.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 1));
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}