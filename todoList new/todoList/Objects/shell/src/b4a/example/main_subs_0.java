package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,41);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _savedlists = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _title = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"todoListLayout.bal\")";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("todoListLayout.bal")),main.mostCurrent.activityBA);
 BA.debugLineNum = 45;BA.debugLine="newAddTaskBtn";
Debug.ShouldStop(4096);
_newaddtaskbtn();
 BA.debugLineNum = 46;BA.debugLine="tasksList.GetBase.Visible = False";
Debug.ShouldStop(8192);
main.mostCurrent._taskslist.runMethod(false,"_getbase").runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 48;BA.debugLine="kvs.Initialize(File.DirInternal, \"todoListData\")";
Debug.ShouldStop(32768);
main._kvs.runVoidMethod ("_initialize",main.processBA,(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("todoListData")));
 BA.debugLineNum = 50;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
Debug.ShouldStop(131072);
if (main._kvs.runMethod(true,"_containskey",(Object)(RemoteObject.createImmutable("lists"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 51;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
Debug.ShouldStop(262144);
_savedlists = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedlists = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), main._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists", _savedlists);Debug.locals.put("savedLists", _savedlists);
 BA.debugLineNum = 52;BA.debugLine="For Each title As String In savedLists";
Debug.ShouldStop(524288);
{
final RemoteObject group7 = _savedlists;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_title = BA.ObjectToString(group7.runMethod(false,"Get",index7));Debug.locals.put("title", _title);
Debug.locals.put("title", _title);
 BA.debugLineNum = 53;BA.debugLine="listsList.AddTextItem(title, listsList.Size + 1";
Debug.ShouldStop(1048576);
main.mostCurrent._listslist.runVoidMethod ("_addtextitem",(Object)((_title)),(Object)((RemoteObject.solve(new RemoteObject[] {main.mostCurrent._listslist.runMethod(true,"_getsize"),RemoteObject.createImmutable(1)}, "+",1, 1))));
 }
}Debug.locals.put("title", _title);
;
 };
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,63);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,59);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtaskbtn_click() throws Exception{
try {
		Debug.PushSubsStack("addTaskBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,168);
if (RapidSub.canDelegate("addtaskbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","addtaskbtn_click");}
 BA.debugLineNum = 168;BA.debugLine="Sub addTaskBtn_Click 'adding tasks in";
Debug.ShouldStop(128);
 BA.debugLineNum = 170;BA.debugLine="addTaskBtn.Enabled = False";
Debug.ShouldStop(512);
main.mostCurrent._addtaskbtn.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 171;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
Debug.ShouldStop(1024);
main.mostCurrent._taskslist.runVoidMethod ("_removeat",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._taskslist.runMethod(true,"_getsize"),RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 173;BA.debugLine="addTaskPanel.Initialize(\"addTaskPanel\")";
Debug.ShouldStop(4096);
main.mostCurrent._addtaskpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTaskPanel")));
 BA.debugLineNum = 174;BA.debugLine="addTaskPanel.SetLayout(10dip, 0, 200dip, 100dip)";
Debug.ShouldStop(8192);
main.mostCurrent._addtaskpanel.runVoidMethod ("SetLayout",(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 175;BA.debugLine="addTaskPanel.Color = Colors.ARGB(255, 247, 247, 2";
Debug.ShouldStop(16384);
main.mostCurrent._addtaskpanel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 247)),(Object)(BA.numberCast(int.class, 247)),(Object)(BA.numberCast(int.class, 247))));
 BA.debugLineNum = 177;BA.debugLine="addTaskTextArea.Initialize(\"addTodoText\")";
Debug.ShouldStop(65536);
main.mostCurrent._addtasktextarea.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTodoText")));
 BA.debugLineNum = 178;BA.debugLine="addTaskTextArea.Hint = \"Add a task...\"";
Debug.ShouldStop(131072);
main.mostCurrent._addtasktextarea.runMethod(true,"setHint",BA.ObjectToString("Add a task..."));
 BA.debugLineNum = 180;BA.debugLine="enterTaskBtn.Initialize(\"enterTaskBtn\")";
Debug.ShouldStop(524288);
main.mostCurrent._entertaskbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("enterTaskBtn")));
 BA.debugLineNum = 181;BA.debugLine="enterTaskBtn.Text = \"Enter task\"";
Debug.ShouldStop(1048576);
main.mostCurrent._entertaskbtn.runMethod(true,"setText",BA.ObjectToCharSequence("Enter task"));
 BA.debugLineNum = 183;BA.debugLine="addTaskPanel.AddView(addTaskTextArea, 0, 0, 280di";
Debug.ShouldStop(4194304);
main.mostCurrent._addtaskpanel.runVoidMethod ("AddView",(Object)((main.mostCurrent._addtasktextarea.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 280)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))));
 BA.debugLineNum = 184;BA.debugLine="addTaskPanel.AddView(enterTaskBtn, 0, 50dip, 280d";
Debug.ShouldStop(8388608);
main.mostCurrent._addtaskpanel.runVoidMethod ("AddView",(Object)((main.mostCurrent._entertaskbtn.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 280)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 186;BA.debugLine="tasksList.Add(addTaskPanel, addTaskPanel)";
Debug.ShouldStop(33554432);
main.mostCurrent._taskslist.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), main.mostCurrent._addtaskpanel.getObject()),(Object)((main.mostCurrent._addtaskpanel.getObject())));
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
public static RemoteObject  _addtitletextarea_enterpressed() throws Exception{
try {
		Debug.PushSubsStack("addTitleTextArea_EnterPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,98);
if (RapidSub.canDelegate("addtitletextarea_enterpressed")) { return b4a.example.main.remoteMe.runUserSub(false, "main","addtitletextarea_enterpressed");}
RemoteObject _title = RemoteObject.createImmutable("");
RemoteObject _savedlists = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _index = RemoteObject.createImmutable(0);
 BA.debugLineNum = 98;BA.debugLine="Sub addTitleTextArea_EnterPressed 'after entering";
Debug.ShouldStop(2);
 BA.debugLineNum = 100;BA.debugLine="Dim title As String = addTitleTextArea.Text";
Debug.ShouldStop(8);
_title = main.mostCurrent._addtitletextarea.runMethod(true,"getText");Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 BA.debugLineNum = 102;BA.debugLine="If title = \"\" Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_title,BA.ObjectToString(""))) { 
 BA.debugLineNum = 103;BA.debugLine="MsgboxAsync(\"Add a title.\", \"List Untitled\")";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Add a title.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("List Untitled"))),main.processBA);
 BA.debugLineNum = 104;BA.debugLine="addTitleTextArea.RequestFocus";
Debug.ShouldStop(128);
main.mostCurrent._addtitletextarea.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 105;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 108;BA.debugLine="Dim savedLists As List";
Debug.ShouldStop(2048);
_savedlists = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("savedLists", _savedlists);
 BA.debugLineNum = 109;BA.debugLine="savedLists.Initialize";
Debug.ShouldStop(4096);
_savedlists.runVoidMethod ("Initialize");
 BA.debugLineNum = 111;BA.debugLine="If kvs.ContainsKey(\"lists\") Then";
Debug.ShouldStop(16384);
if (main._kvs.runMethod(true,"_containskey",(Object)(RemoteObject.createImmutable("lists"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 112;BA.debugLine="savedLists = kvs.Get(\"lists\")";
Debug.ShouldStop(32768);
_savedlists = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), main._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists", _savedlists);
 };
 BA.debugLineNum = 115;BA.debugLine="savedLists.Add(title)";
Debug.ShouldStop(262144);
_savedlists.runVoidMethod ("Add",(Object)((_title)));
 BA.debugLineNum = 116;BA.debugLine="kvs.Put(\"lists\", savedLists)";
Debug.ShouldStop(524288);
main._kvs.runVoidMethod ("_put",(Object)(BA.ObjectToString("lists")),(Object)((_savedlists.getObject())));
 BA.debugLineNum = 118;BA.debugLine="Dim index As Int = listsList.Size + 1";
Debug.ShouldStop(2097152);
_index = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._listslist.runMethod(true,"_getsize"),RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 119;BA.debugLine="listsList.AddTextItem(title, index)";
Debug.ShouldStop(4194304);
main.mostCurrent._listslist.runVoidMethod ("_addtextitem",(Object)((_title)),(Object)((_index)));
 BA.debugLineNum = 121;BA.debugLine="addTitleTextArea.Text = \"\"";
Debug.ShouldStop(16777216);
main.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 122;BA.debugLine="addTitleTextArea.Enabled = False";
Debug.ShouldStop(33554432);
main.mostCurrent._addtitletextarea.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 123;BA.debugLine="addTitleTextArea.Visible = False";
Debug.ShouldStop(67108864);
main.mostCurrent._addtitletextarea.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 124;BA.debugLine="newListBtn.Enabled = True";
Debug.ShouldStop(134217728);
main.mostCurrent._newlistbtn.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _entertaskbtn_click() throws Exception{
try {
		Debug.PushSubsStack("enterTaskBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,190);
if (RapidSub.canDelegate("entertaskbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","entertaskbtn_click");}
RemoteObject _newtask = RemoteObject.createImmutable("");
RemoteObject _key = RemoteObject.createImmutable("");
RemoteObject _savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 190;BA.debugLine="Sub enterTaskBtn_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 192;BA.debugLine="Dim newTask As String = addTaskTextArea.Text.Trim";
Debug.ShouldStop(-2147483648);
_newtask = main.mostCurrent._addtasktextarea.runMethod(true,"getText").runMethod(true,"trim");Debug.locals.put("newTask", _newtask);Debug.locals.put("newTask", _newtask);
 BA.debugLineNum = 193;BA.debugLine="If newTask = \"\" Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_newtask,BA.ObjectToString(""))) { 
 BA.debugLineNum = 194;BA.debugLine="MsgboxAsync(\"Please enter a task.\", \"No task ent";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Please enter a task.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("No task entered"))),main.processBA);
 BA.debugLineNum = 195;BA.debugLine="Return";
Debug.ShouldStop(4);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 198;BA.debugLine="tasksList.RemoveAt(tasksList.Size - 1)";
Debug.ShouldStop(32);
main.mostCurrent._taskslist.runVoidMethod ("_removeat",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._taskslist.runMethod(true,"_getsize"),RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 200;BA.debugLine="Dim key As String = \"list_\" & currentList";
Debug.ShouldStop(128);
_key = RemoteObject.concat(RemoteObject.createImmutable("list_"),main.mostCurrent._currentlist);Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 201;BA.debugLine="Dim savedTasks As List";
Debug.ShouldStop(256);
_savedtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("savedTasks", _savedtasks);
 BA.debugLineNum = 202;BA.debugLine="If kvs.ContainsKey(key) Then";
Debug.ShouldStop(512);
if (main._kvs.runMethod(true,"_containskey",(Object)(_key)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 203;BA.debugLine="savedTasks = kvs.Get(key)";
Debug.ShouldStop(1024);
_savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), main._kvs.runMethod(false,"_get",(Object)(_key)));Debug.locals.put("savedTasks", _savedtasks);
 }else {
 BA.debugLineNum = 205;BA.debugLine="savedTasks.Initialize";
Debug.ShouldStop(4096);
_savedtasks.runVoidMethod ("Initialize");
 };
 BA.debugLineNum = 207;BA.debugLine="savedTasks.Add(newTask)";
Debug.ShouldStop(16384);
_savedtasks.runVoidMethod ("Add",(Object)((_newtask)));
 BA.debugLineNum = 208;BA.debugLine="kvs.Put(key, savedTasks)";
Debug.ShouldStop(32768);
main._kvs.runVoidMethod ("_put",(Object)(_key),(Object)((_savedtasks.getObject())));
 BA.debugLineNum = 210;BA.debugLine="tasksListUI(newTask)";
Debug.ShouldStop(131072);
_taskslistui(_newtask);
 BA.debugLineNum = 212;BA.debugLine="newAddTaskBtn";
Debug.ShouldStop(524288);
_newaddtaskbtn();
 BA.debugLineNum = 213;BA.debugLine="addTaskBtn.Enabled = True";
Debug.ShouldStop(1048576);
main.mostCurrent._addtaskbtn.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 215;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private addTitleTextArea As EditText 'et to enter";
main.mostCurrent._addtitletextarea = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private listsList As CustomListView 'list of the";
main.mostCurrent._listslist = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 28;BA.debugLine="Private newListBtn As Button 'btn to add a new li";
main.mostCurrent._newlistbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private tasksList As CustomListView 'list of the";
main.mostCurrent._taskslist = RemoteObject.createNew ("b4a.example3.customlistview");
 //BA.debugLineNum = 31;BA.debugLine="Dim addTaskBtnPNL As Panel 'panel for addTaskBtn";
main.mostCurrent._addtaskbtnpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Dim addTaskBtn As Button 'button for adding tasks";
main.mostCurrent._addtaskbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private currentList As String = \"\" 'for displayin";
main.mostCurrent._currentlist = BA.ObjectToString("");
 //BA.debugLineNum = 36;BA.debugLine="Dim addTaskPanel As Panel";
main.mostCurrent._addtaskpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Dim addTaskTextArea As EditText";
main.mostCurrent._addtasktextarea = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Dim enterTaskBtn As Button 'button for entering t";
main.mostCurrent._entertaskbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _listslist_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("listsList_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,128);
if (RapidSub.canDelegate("listslist_itemclick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","listslist_itemclick", _index, _value);}
RemoteObject _listpnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _listlbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _key = RemoteObject.createImmutable("");
RemoteObject _savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _task = RemoteObject.createImmutable("");
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 128;BA.debugLine="Sub listsList_ItemClick(Index As Int, Value As Obj";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 130;BA.debugLine="Dim listPNL As B4XView = listsList.GetPanel(Index";
Debug.ShouldStop(2);
_listpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_listpnl = main.mostCurrent._listslist.runMethod(false,"_getpanel",(Object)(_index));Debug.locals.put("listPNL", _listpnl);Debug.locals.put("listPNL", _listpnl);
 BA.debugLineNum = 131;BA.debugLine="Dim listLBL As Label = listPNL.GetView(0)";
Debug.ShouldStop(4);
_listlbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_listlbl = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _listpnl.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).getObject());Debug.locals.put("listLBL", _listlbl);Debug.locals.put("listLBL", _listlbl);
 BA.debugLineNum = 133;BA.debugLine="currentList = listLBL.Text";
Debug.ShouldStop(16);
main.mostCurrent._currentlist = _listlbl.runMethod(true,"getText");
 BA.debugLineNum = 134;BA.debugLine="addTitleTextArea.Text = currentList";
Debug.ShouldStop(32);
main.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._currentlist));
 BA.debugLineNum = 135;BA.debugLine="addTitleTextArea.Visible = True";
Debug.ShouldStop(64);
main.mostCurrent._addtitletextarea.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 137;BA.debugLine="tasksList.Clear";
Debug.ShouldStop(256);
main.mostCurrent._taskslist.runVoidMethod ("_clear");
 BA.debugLineNum = 139;BA.debugLine="Dim key As String = \"list_\" & currentList";
Debug.ShouldStop(1024);
_key = RemoteObject.concat(RemoteObject.createImmutable("list_"),main.mostCurrent._currentlist);Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 141;BA.debugLine="If kvs.ContainsKey(key) Then";
Debug.ShouldStop(4096);
if (main._kvs.runMethod(true,"_containskey",(Object)(_key)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 142;BA.debugLine="Dim savedTasks As List = kvs.Get(key)";
Debug.ShouldStop(8192);
_savedtasks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedtasks = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), main._kvs.runMethod(false,"_get",(Object)(_key)));Debug.locals.put("savedTasks", _savedtasks);Debug.locals.put("savedTasks", _savedtasks);
 BA.debugLineNum = 143;BA.debugLine="For Each task As String In savedTasks";
Debug.ShouldStop(16384);
{
final RemoteObject group10 = _savedtasks;
final int groupLen10 = group10.runMethod(true,"getSize").<Integer>get()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_task = BA.ObjectToString(group10.runMethod(false,"Get",index10));Debug.locals.put("task", _task);
Debug.locals.put("task", _task);
 BA.debugLineNum = 144;BA.debugLine="tasksListUI(task)";
Debug.ShouldStop(32768);
_taskslistui(_task);
 }
}Debug.locals.put("task", _task);
;
 };
 BA.debugLineNum = 148;BA.debugLine="tasksList.GetBase.Visible = True";
Debug.ShouldStop(524288);
main.mostCurrent._taskslist.runMethod(false,"_getbase").runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 149;BA.debugLine="newAddTaskBtn";
Debug.ShouldStop(1048576);
_newaddtaskbtn();
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _listslist_itemlongclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("listsList_ItemLongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,153);
if (RapidSub.canDelegate("listslist_itemlongclick")) { b4a.example.main.remoteMe.runUserSub(false, "main","listslist_itemlongclick", _index, _value); return;}
ResumableSub_listsList_ItemLongClick rsub = new ResumableSub_listsList_ItemLongClick(null,_index,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_listsList_ItemLongClick extends BA.ResumableSub {
public ResumableSub_listsList_ItemLongClick(b4a.example.main parent,RemoteObject _index,RemoteObject _value) {
this.parent = parent;
this._index = _index;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _index;
RemoteObject _value;
RemoteObject _res = RemoteObject.createImmutable(0);
RemoteObject _savedlists = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("listsList_ItemLongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,153);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 155;BA.debugLine="Msgbox2Async(\"Are you sure you want to delete the";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Are you sure you want to delete the list \""),_value,RemoteObject.createImmutable("\"?")))),(Object)(BA.ObjectToCharSequence("Delete List")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Yes")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 156;BA.debugLine="Wait For Msgbox_Result (res As Int)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "listslist_itemlongclick"), null);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_res = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("res", _res);
;
 BA.debugLineNum = 157;BA.debugLine="If res = DialogResponse.NEGATIVE Then";
Debug.ShouldStop(268435456);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 159;BA.debugLine="Dim savedLists As List = kvs.Get(\"lists\")";
Debug.ShouldStop(1073741824);
_savedlists = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_savedlists = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), parent._kvs.runMethod(false,"_get",(Object)(RemoteObject.createImmutable("lists"))));Debug.locals.put("savedLists", _savedlists);Debug.locals.put("savedLists", _savedlists);
 BA.debugLineNum = 160;BA.debugLine="savedLists.RemoveAt(Index)";
Debug.ShouldStop(-2147483648);
_savedlists.runVoidMethod ("RemoveAt",(Object)(_index));
 BA.debugLineNum = 161;BA.debugLine="kvs.Put(\"lists\", savedLists)";
Debug.ShouldStop(1);
parent._kvs.runVoidMethod ("_put",(Object)(BA.ObjectToString("lists")),(Object)((_savedlists.getObject())));
 BA.debugLineNum = 162;BA.debugLine="listsList.RemoveAt(Index)";
Debug.ShouldStop(2);
parent.mostCurrent._listslist.runVoidMethod ("_removeat",(Object)(_index));
 BA.debugLineNum = 164;BA.debugLine="ToastMessageShow(\"Category deleted\", False)";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Category deleted")),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 166;BA.debugLine="End Sub";
Debug.ShouldStop(32);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _msgbox_result(RemoteObject _res) throws Exception{
}
public static RemoteObject  _newaddtaskbtn() throws Exception{
try {
		Debug.PushSubsStack("newAddTaskBtn (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("newaddtaskbtn")) { return b4a.example.main.remoteMe.runUserSub(false, "main","newaddtaskbtn");}
 BA.debugLineNum = 67;BA.debugLine="Sub newAddTaskBtn 'for making the add task button";
Debug.ShouldStop(4);
 BA.debugLineNum = 69;BA.debugLine="addTaskBtnPNL.Initialize(\"addTaskBtnPNL\")";
Debug.ShouldStop(16);
main.mostCurrent._addtaskbtnpnl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTaskBtnPNL")));
 BA.debugLineNum = 70;BA.debugLine="addTaskBtnPNL.SetLayout(0, 0, 350dip, 50dip)";
Debug.ShouldStop(32);
main.mostCurrent._addtaskbtnpnl.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 350)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 71;BA.debugLine="addTaskBtnPNL.Color = Colors.ARGB(255, 250, 250,";
Debug.ShouldStop(64);
main.mostCurrent._addtaskbtnpnl.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(int.class, 250)),(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 73;BA.debugLine="addTaskBtn.Initialize(\"addTaskBtn\")";
Debug.ShouldStop(256);
main.mostCurrent._addtaskbtn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addTaskBtn")));
 BA.debugLineNum = 75;BA.debugLine="addTaskBtn.Text = \"+ add a task \"";
Debug.ShouldStop(1024);
main.mostCurrent._addtaskbtn.runMethod(true,"setText",BA.ObjectToCharSequence("+ add a task "));
 BA.debugLineNum = 76;BA.debugLine="addTaskBtnPNL.AddView(addTaskBtn, -10dip, 0, 300d";
Debug.ShouldStop(2048);
main.mostCurrent._addtaskbtnpnl.runVoidMethod ("AddView",(Object)((main.mostCurrent._addtaskbtn.getObject())),(Object)(BA.numberCast(int.class, -(double) (0 + main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))).<Integer>get().intValue()))),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 78;BA.debugLine="tasksList.Add(addTaskBtnPNL, \"\")";
Debug.ShouldStop(8192);
main.mostCurrent._taskslist.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), main.mostCurrent._addtaskbtnpnl.getObject()),(Object)((RemoteObject.createImmutable(""))));
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
public static RemoteObject  _newlistbtn_click() throws Exception{
try {
		Debug.PushSubsStack("newListBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,82);
if (RapidSub.canDelegate("newlistbtn_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","newlistbtn_click");}
 BA.debugLineNum = 82;BA.debugLine="Sub newListBtn_Click 'for making a new list";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="addTitleTextArea.Visible = True";
Debug.ShouldStop(524288);
main.mostCurrent._addtitletextarea.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 85;BA.debugLine="addTitleTextArea.Enabled = True";
Debug.ShouldStop(1048576);
main.mostCurrent._addtitletextarea.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 86;BA.debugLine="addTitleTextArea.Background = Null";
Debug.ShouldStop(2097152);
main.mostCurrent._addtitletextarea.runMethod(false,"setBackground",(main.mostCurrent.__c.getField(false,"Null")));
 BA.debugLineNum = 87;BA.debugLine="addTitleTextArea.Text = \"\"";
Debug.ShouldStop(4194304);
main.mostCurrent._addtitletextarea.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 88;BA.debugLine="addTitleTextArea.Hint = \"+ add a title...\"";
Debug.ShouldStop(8388608);
main.mostCurrent._addtitletextarea.runMethod(true,"setHint",BA.ObjectToString("+ add a title..."));
 BA.debugLineNum = 89;BA.debugLine="addTitleTextArea.RequestFocus";
Debug.ShouldStop(16777216);
main.mostCurrent._addtitletextarea.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 91;BA.debugLine="newListBtn.Enabled = False";
Debug.ShouldStop(67108864);
main.mostCurrent._newlistbtn.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 93;BA.debugLine="tasksList.GetBase.Visible = True";
Debug.ShouldStop(268435456);
main.mostCurrent._taskslist.runMethod(false,"_getbase").runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 94;BA.debugLine="addTaskBtn.Visible = True";
Debug.ShouldStop(536870912);
main.mostCurrent._addtaskbtn.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
keyvaluestore.myClass = BA.getDeviceClass ("b4a.example.keyvaluestore");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 20;BA.debugLine="Public kvs As KeyValueStore";
main._kvs = RemoteObject.createNew ("b4a.example3.keyvaluestore");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _taskcheckbox_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("taskCheckbox_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,217);
if (RapidSub.canDelegate("taskcheckbox_checkedchange")) { return b4a.example.main.remoteMe.runUserSub(false, "main","taskcheckbox_checkedchange", _checked);}
RemoteObject _taskcheckbox = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _tasklbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 217;BA.debugLine="Sub taskCheckbox_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 219;BA.debugLine="Dim taskCheckbox As CheckBox = Sender";
Debug.ShouldStop(67108864);
_taskcheckbox = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
_taskcheckbox = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("taskCheckbox", _taskcheckbox);Debug.locals.put("taskCheckbox", _taskcheckbox);
 BA.debugLineNum = 220;BA.debugLine="Dim taskLBL As Label = taskCheckbox.Tag";
Debug.ShouldStop(134217728);
_tasklbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_tasklbl = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), _taskcheckbox.runMethod(false,"getTag"));Debug.locals.put("taskLBL", _tasklbl);Debug.locals.put("taskLBL", _tasklbl);
 BA.debugLineNum = 222;BA.debugLine="If Checked Then";
Debug.ShouldStop(536870912);
if (_checked.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 223;BA.debugLine="taskLBL.TextColor = Colors.ARGB(50, 0, 0, 0)";
Debug.ShouldStop(1073741824);
_tasklbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 }else {
 BA.debugLineNum = 225;BA.debugLine="taskLBL.TextColor = Colors.Black";
Debug.ShouldStop(1);
_tasklbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 };
 BA.debugLineNum = 228;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _taskslistui(RemoteObject _newtask) throws Exception{
try {
		Debug.PushSubsStack("tasksListUI (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,230);
if (RapidSub.canDelegate("taskslistui")) { return b4a.example.main.remoteMe.runUserSub(false, "main","taskslistui", _newtask);}
RemoteObject _taskpnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _taskcheckbox = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _tasklbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _divider = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("newTask", _newtask);
 BA.debugLineNum = 230;BA.debugLine="Sub tasksListUI(newTask As String)'sub for task li";
Debug.ShouldStop(32);
 BA.debugLineNum = 232;BA.debugLine="Dim taskPNL As Panel 'panel for the tasks";
Debug.ShouldStop(128);
_taskpnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("taskPNL", _taskpnl);
 BA.debugLineNum = 233;BA.debugLine="taskPNL.Initialize(\"taskPNL\")";
Debug.ShouldStop(256);
_taskpnl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("taskPNL")));
 BA.debugLineNum = 234;BA.debugLine="taskPNL.SetLayout(0, 0, 100%x, 60dip)";
Debug.ShouldStop(512);
_taskpnl.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))));
 BA.debugLineNum = 236;BA.debugLine="Dim taskCheckbox As CheckBox 'checkbox";
Debug.ShouldStop(2048);
_taskcheckbox = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("taskCheckbox", _taskcheckbox);
 BA.debugLineNum = 237;BA.debugLine="taskCheckbox.Initialize(\"taskCheckbox\")";
Debug.ShouldStop(4096);
_taskcheckbox.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("taskCheckbox")));
 BA.debugLineNum = 238;BA.debugLine="taskPNL.AddView(taskCheckbox, 10dip, 15dip, 40dip";
Debug.ShouldStop(8192);
_taskpnl.runVoidMethod ("AddView",(Object)((_taskcheckbox.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 240;BA.debugLine="Dim taskLBL As Label";
Debug.ShouldStop(32768);
_tasklbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("taskLBL", _tasklbl);
 BA.debugLineNum = 241;BA.debugLine="taskLBL.Initialize(\"taskLBL\")";
Debug.ShouldStop(65536);
_tasklbl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("taskLBL")));
 BA.debugLineNum = 242;BA.debugLine="taskLBL.Text = newTask";
Debug.ShouldStop(131072);
_tasklbl.runMethod(true,"setText",BA.ObjectToCharSequence(_newtask));
 BA.debugLineNum = 243;BA.debugLine="taskLBL.TextColor = Colors.Black";
Debug.ShouldStop(262144);
_tasklbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 244;BA.debugLine="taskPNL.AddView(taskLBL, 60dip, 25dip, 80%x, 40di";
Debug.ShouldStop(524288);
_taskpnl.runVoidMethod ("AddView",(Object)((_tasklbl.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 246;BA.debugLine="Dim divider As Panel";
Debug.ShouldStop(2097152);
_divider = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("divider", _divider);
 BA.debugLineNum = 247;BA.debugLine="divider.Initialize(\"line\")";
Debug.ShouldStop(4194304);
_divider.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("line")));
 BA.debugLineNum = 248;BA.debugLine="divider.Color = Colors.ARGB(255, 60, 60, 60)";
Debug.ShouldStop(8388608);
_divider.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 60)),(Object)(BA.numberCast(int.class, 60)),(Object)(BA.numberCast(int.class, 60))));
 BA.debugLineNum = 249;BA.debugLine="taskPNL.AddView(divider, 0, 59dip, 100%x, 1dip)";
Debug.ShouldStop(16777216);
_taskpnl.runVoidMethod ("AddView",(Object)((_divider.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 59)))),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 251;BA.debugLine="taskCheckbox.Tag = taskLBL";
Debug.ShouldStop(67108864);
_taskcheckbox.runMethod(false,"setTag",(_tasklbl.getObject()));
 BA.debugLineNum = 252;BA.debugLine="tasksList.Add(taskPNL, newTask)";
Debug.ShouldStop(134217728);
main.mostCurrent._taskslist.runVoidMethod ("_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _taskpnl.getObject()),(Object)((_newtask)));
 BA.debugLineNum = 254;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}