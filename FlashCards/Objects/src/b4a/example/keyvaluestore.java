package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class keyvaluestore extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.keyvaluestore");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.keyvaluestore.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.sql.SQL _sql1 = null;
public anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.card_module _card_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.active_recall _active_recall = null;
public String  _initialize(b4a.example.keyvaluestore __ref,anywheresoftware.b4a.BA _ba,String _dir,String _filename) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_dir,_filename}));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Public Sub Initialize (Dir As String, FileName As";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="If sql1.IsInitialized Then sql1.Close";
if (__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .IsInitialized()) { 
__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .Close();};
RDebugUtils.currentLine=7733253;
 //BA.debugLineNum = 7733253;BA.debugLine="sql1.Initialize(Dir, FileName, True)";
__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .Initialize(_dir,_filename,__c.True);
RDebugUtils.currentLine=7733255;
 //BA.debugLineNum = 7733255;BA.debugLine="CreateTable";
__ref._createtable /*String*/ (null);
RDebugUtils.currentLine=7733256;
 //BA.debugLineNum = 7733256;BA.debugLine="End Sub";
return "";
}
public boolean  _containskey(b4a.example.keyvaluestore __ref,String _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "containskey", true))
	 {return ((Boolean) Debug.delegate(ba, "containskey", new Object[] {_key}));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Public Sub ContainsKey(Key As String) As Boolean";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="Return sql1.ExecQuerySingleResult2(\"SELECT count(";
if (true) return (double)(Double.parseDouble(__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecQuerySingleResult2("SELECT count(key) FROM main WHERE key = ?",new String[]{_key})))>0;
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="End Sub";
return false;
}
public Object  _get(b4a.example.keyvaluestore __ref,String _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "get", true))
	 {return ((Object) Debug.delegate(ba, "get", new Object[] {_key}));}
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
Object _result = null;
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Public Sub Get(Key As String) As Object";
RDebugUtils.currentLine=7864321;
 //BA.debugLineNum = 7864321;BA.debugLine="Dim rs As ResultSet = sql1.ExecQuery2(\"SELECT val";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery2("SELECT value FROM main WHERE key = ?",new String[]{_key})));
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="Dim result As Object = Null";
_result = __c.Null;
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="If rs.NextRow Then";
if (_rs.NextRow()) { 
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="result = ser.ConvertBytesToObject(rs.GetBlob2(0)";
_result = __ref._ser /*anywheresoftware.b4a.randomaccessfile.B4XSerializator*/ .ConvertBytesToObject(_rs.GetBlob2((int) (0)));
 };
RDebugUtils.currentLine=7864326;
 //BA.debugLineNum = 7864326;BA.debugLine="rs.Close";
_rs.Close();
RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=7864328;
 //BA.debugLineNum = 7864328;BA.debugLine="End Sub";
return null;
}
public String  _put(b4a.example.keyvaluestore __ref,String _key,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "put", true))
	 {return ((String) Debug.delegate(ba, "put", new Object[] {_key,_value}));}
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Public Sub Put(Key As String, Value As Object)";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="sql1.ExecNonQuery2(\"INSERT OR REPLACE INTO main V";
__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("INSERT OR REPLACE INTO main VALUES(?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_key),(Object)(__ref._ser /*anywheresoftware.b4a.randomaccessfile.B4XSerializator*/ .ConvertObjectToBytes(_value))}));
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Private sql1 As SQL";
_sql1 = new anywheresoftware.b4a.sql.SQL();
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="Private ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
RDebugUtils.currentLine=7667715;
 //BA.debugLineNum = 7667715;BA.debugLine="End Sub";
return "";
}
public String  _close(b4a.example.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "close", true))
	 {return ((String) Debug.delegate(ba, "close", null));}
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Public Sub Close";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="sql1.Close";
__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .Close();
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="End Sub";
return "";
}
public String  _createtable(b4a.example.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "createtable", true))
	 {return ((String) Debug.delegate(ba, "createtable", null));}
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Private Sub CreateTable";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="sql1.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS mai";
__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("CREATE TABLE IF NOT EXISTS main(key TEXT PRIMARY KEY, value NONE)");
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="End Sub";
return "";
}
public String  _deleteall(b4a.example.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "deleteall", true))
	 {return ((String) Debug.delegate(ba, "deleteall", null));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Public Sub DeleteAll";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="sql1.ExecNonQuery(\"DROP TABLE main\")";
__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("DROP TABLE main");
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="CreateTable";
__ref._createtable /*String*/ (null);
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _getbitmap(b4a.example.keyvaluestore __ref,String _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "getbitmap", true))
	 {return ((anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) Debug.delegate(ba, "getbitmap", new Object[] {_key}));}
byte[] _b = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Public Sub GetBitmap(Key As String) As B4XBitmap";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="Dim b() As Byte = Get(Key)";
_b = (byte[])(__ref._get /*Object*/ (null,_key));
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="If b = Null Then Return Null";
if (_b== null) { 
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(__c.Null));};
RDebugUtils.currentLine=8192003;
 //BA.debugLineNum = 8192003;BA.debugLine="Dim in As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="in.InitializeFromBytesArray(b, 0, b.Length)";
_in.InitializeFromBytesArray(_b,(int) (0),_b.length);
RDebugUtils.currentLine=8192008;
 //BA.debugLineNum = 8192008;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=8192010;
 //BA.debugLineNum = 8192010;BA.debugLine="bmp.Initialize2(in)";
_bmp.Initialize2((java.io.InputStream)(_in.getObject()));
RDebugUtils.currentLine=8192011;
 //BA.debugLineNum = 8192011;BA.debugLine="in.Close";
_in.Close();
RDebugUtils.currentLine=8192012;
 //BA.debugLineNum = 8192012;BA.debugLine="Return bmp";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=8192013;
 //BA.debugLineNum = 8192013;BA.debugLine="End Sub";
return null;
}
public Object  _getdefault(b4a.example.keyvaluestore __ref,String _key,Object _defaultvalue) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "getdefault", true))
	 {return ((Object) Debug.delegate(ba, "getdefault", new Object[] {_key,_defaultvalue}));}
Object _res = null;
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Public Sub GetDefault(Key As String, DefaultValue";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="Dim res As Object = Get(Key)";
_res = __ref._get /*Object*/ (null,_key);
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="If res = Null Then Return DefaultValue";
if (_res== null) { 
if (true) return _defaultvalue;};
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _getmapasync(b4a.example.keyvaluestore __ref,anywheresoftware.b4a.objects.collections.List _keys) throws Exception{
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "getmapasync", true))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "getmapasync", new Object[] {_keys}));}
ResumableSub_GetMapAsync rsub = new ResumableSub_GetMapAsync(this,__ref,_keys);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_GetMapAsync extends BA.ResumableSub {
public ResumableSub_GetMapAsync(b4a.example.keyvaluestore parent,b4a.example.keyvaluestore __ref,anywheresoftware.b4a.objects.collections.List _keys) {
this.parent = parent;
this.__ref = __ref;
this._keys = _keys;
this.__ref = parent;
}
b4a.example.keyvaluestore __ref;
b4a.example.keyvaluestore parent;
anywheresoftware.b4a.objects.collections.List _keys;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
Object _senderfilter = null;
boolean _success = false;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
anywheresoftware.b4a.randomaccessfile.B4XSerializator _myser = null;
Object _newobject = null;
int step4;
int limit4;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="keyvaluestore";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="sb.Append(\"SELECT key, value FROM main WHERE \")";
_sb.Append("SELECT key, value FROM main WHERE ");
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="For i = 0 To Keys.Size - 1";
if (true) break;

case 1:
//for
this.state = 10;
step4 = 1;
limit4 = (int) (_keys.getSize()-1);
_i = (int) (0) ;
this.state = 25;
if (true) break;

case 25:
//C
this.state = 10;
if ((step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4)) this.state = 3;
if (true) break;

case 26:
//C
this.state = 25;
_i = ((int)(0 + _i + step4)) ;
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=7929861;
 //BA.debugLineNum = 7929861;BA.debugLine="If i > 0 Then sb.Append(\" OR \")";
if (true) break;

case 4:
//if
this.state = 9;
if (_i>0) { 
this.state = 6;
;}if (true) break;

case 6:
//C
this.state = 9;
_sb.Append(" OR ");
if (true) break;

case 9:
//C
this.state = 26;
;
RDebugUtils.currentLine=7929862;
 //BA.debugLineNum = 7929862;BA.debugLine="sb.Append(\" key = ? \")";
_sb.Append(" key = ? ");
 if (true) break;
if (true) break;

case 10:
//C
this.state = 11;
;
RDebugUtils.currentLine=7929864;
 //BA.debugLineNum = 7929864;BA.debugLine="Dim SenderFilter As Object = sql1.ExecQueryAsync(";
_senderfilter = __ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecQueryAsync(ba,"SQL",_sb.ToString(),_keys);
RDebugUtils.currentLine=7929865;
 //BA.debugLineNum = 7929865;BA.debugLine="Wait For (SenderFilter) SQL_QueryComplete (Succes";
parent.__c.WaitFor("sql_querycomplete", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "keyvaluestore", "getmapasync"), _senderfilter);
this.state = 27;
return;
case 27:
//C
this.state = 11;
_success = (Boolean) result[1];
_rs = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) result[2];
;
RDebugUtils.currentLine=7929866;
 //BA.debugLineNum = 7929866;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=7929867;
 //BA.debugLineNum = 7929867;BA.debugLine="m.Initialize";
_m.Initialize();
RDebugUtils.currentLine=7929868;
 //BA.debugLineNum = 7929868;BA.debugLine="If Success Then";
if (true) break;

case 11:
//if
this.state = 24;
if (_success) { 
this.state = 13;
}else {
this.state = 23;
}if (true) break;

case 13:
//C
this.state = 14;
RDebugUtils.currentLine=7929869;
 //BA.debugLineNum = 7929869;BA.debugLine="Do While rs.NextRow";
if (true) break;

case 14:
//do while
this.state = 21;
while (_rs.NextRow()) {
this.state = 16;
if (true) break;
}
if (true) break;

case 16:
//C
this.state = 17;
RDebugUtils.currentLine=7929870;
 //BA.debugLineNum = 7929870;BA.debugLine="Dim myser As B4XSerializator";
_myser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
RDebugUtils.currentLine=7929871;
 //BA.debugLineNum = 7929871;BA.debugLine="myser.ConvertBytesToObjectAsync(rs.GetBlob2(1),";
_myser.ConvertBytesToObjectAsync(ba,_rs.GetBlob2((int) (1)),"myser");
RDebugUtils.currentLine=7929872;
 //BA.debugLineNum = 7929872;BA.debugLine="Wait For (myser) myser_BytesToObject (Success A";
parent.__c.WaitFor("myser_bytestoobject", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "keyvaluestore", "getmapasync"), (Object)(_myser));
this.state = 28;
return;
case 28:
//C
this.state = 17;
_success = (Boolean) result[1];
_newobject = (Object) result[2];
;
RDebugUtils.currentLine=7929873;
 //BA.debugLineNum = 7929873;BA.debugLine="If Success Then";
if (true) break;

case 17:
//if
this.state = 20;
if (_success) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
RDebugUtils.currentLine=7929874;
 //BA.debugLineNum = 7929874;BA.debugLine="m.Put(rs.GetString2(0), NewObject)";
_m.Put((Object)(_rs.GetString2((int) (0))),_newobject);
 if (true) break;

case 20:
//C
this.state = 14;
;
 if (true) break;

case 21:
//C
this.state = 24;
;
RDebugUtils.currentLine=7929877;
 //BA.debugLineNum = 7929877;BA.debugLine="rs.Close";
_rs.Close();
 if (true) break;

case 23:
//C
this.state = 24;
RDebugUtils.currentLine=7929879;
 //BA.debugLineNum = 7929879;BA.debugLine="Log(LastException)";
parent.__c.LogImpl("97929879",BA.ObjectToString(parent.__c.LastException(parent.getActivityBA())),0);
 if (true) break;

case 24:
//C
this.state = -1;
;
RDebugUtils.currentLine=7929881;
 //BA.debugLineNum = 7929881;BA.debugLine="Return m";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_m));return;};
RDebugUtils.currentLine=7929882;
 //BA.debugLineNum = 7929882;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.objects.collections.List  _listkeys(b4a.example.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "listkeys", true))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "listkeys", null));}
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _c = null;
anywheresoftware.b4a.objects.collections.List _res = null;
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Public Sub ListKeys As List";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="Dim c As ResultSet = sql1.ExecQuery(\"SELECT key F";
_c = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_c = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecQuery("SELECT key FROM main")));
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="Do While c.NextRow";
while (_c.NextRow()) {
RDebugUtils.currentLine=8323077;
 //BA.debugLineNum = 8323077;BA.debugLine="res.Add(c.GetString2(0))";
_res.Add((Object)(_c.GetString2((int) (0))));
 }
;
RDebugUtils.currentLine=8323079;
 //BA.debugLineNum = 8323079;BA.debugLine="c.Close";
_c.Close();
RDebugUtils.currentLine=8323080;
 //BA.debugLineNum = 8323080;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=8323081;
 //BA.debugLineNum = 8323081;BA.debugLine="End Sub";
return null;
}
public String  _putbitmap(b4a.example.keyvaluestore __ref,String _key,anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "putbitmap", true))
	 {return ((String) Debug.delegate(ba, "putbitmap", new Object[] {_key,_value}));}
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Public Sub PutBitmap(Key As String, Value As B4XBi";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="out.InitializeToBytesArray(0)";
_out.InitializeToBytesArray((int) (0));
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="Value.WriteToStream(out, 100, \"PNG\")";
_value.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=8126468;
 //BA.debugLineNum = 8126468;BA.debugLine="Put(Key, out.ToBytesArray)";
__ref._put /*String*/ (null,_key,(Object)(_out.ToBytesArray()));
RDebugUtils.currentLine=8126469;
 //BA.debugLineNum = 8126469;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=8126470;
 //BA.debugLineNum = 8126470;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _putmapasync(b4a.example.keyvaluestore __ref,anywheresoftware.b4a.objects.collections.Map _map) throws Exception{
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "putmapasync", true))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "putmapasync", new Object[] {_map}));}
ResumableSub_PutMapAsync rsub = new ResumableSub_PutMapAsync(this,__ref,_map);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_PutMapAsync extends BA.ResumableSub {
public ResumableSub_PutMapAsync(b4a.example.keyvaluestore parent,b4a.example.keyvaluestore __ref,anywheresoftware.b4a.objects.collections.Map _map) {
this.parent = parent;
this.__ref = __ref;
this._map = _map;
this.__ref = parent;
}
b4a.example.keyvaluestore __ref;
b4a.example.keyvaluestore parent;
anywheresoftware.b4a.objects.collections.Map _map;
String _key = "";
anywheresoftware.b4a.randomaccessfile.B4XSerializator _myser = null;
boolean _success = false;
byte[] _bytes = null;
Object _senderfilter = null;
anywheresoftware.b4a.BA.IterableList group1;
int index1;
int groupLen1;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="keyvaluestore";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="For Each key As String In Map.Keys";
if (true) break;

case 1:
//for
this.state = 10;
group1 = _map.Keys();
index1 = 0;
groupLen1 = group1.getSize();
this.state = 11;
if (true) break;

case 11:
//C
this.state = 10;
if (index1 < groupLen1) {
this.state = 3;
_key = BA.ObjectToString(group1.Get(index1));}
if (true) break;

case 12:
//C
this.state = 11;
index1++;
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="Dim myser As B4XSerializator";
_myser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
RDebugUtils.currentLine=7995395;
 //BA.debugLineNum = 7995395;BA.debugLine="myser.ConvertObjectToBytesAsync(Map.Get(key), \"m";
_myser.ConvertObjectToBytesAsync(ba,_map.Get((Object)(_key)),"myser");
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="Wait For (myser) myser_ObjectToBytes (Success As";
parent.__c.WaitFor("myser_objecttobytes", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "keyvaluestore", "putmapasync"), (Object)(_myser));
this.state = 13;
return;
case 13:
//C
this.state = 4;
_success = (Boolean) result[1];
_bytes = (byte[]) result[2];
;
RDebugUtils.currentLine=7995397;
 //BA.debugLineNum = 7995397;BA.debugLine="If Success Then";
if (true) break;

case 4:
//if
this.state = 9;
if (_success) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="sql1.AddNonQueryToBatch(\"INSERT OR REPLACE INTO";
__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .AddNonQueryToBatch("INSERT OR REPLACE INTO main VALUES(?, ?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_key),(Object)(_bytes)}));
 if (true) break;

case 8:
//C
this.state = 9;
RDebugUtils.currentLine=7995400;
 //BA.debugLineNum = 7995400;BA.debugLine="Log(\"Failed to serialize object: \" & Map.Get(ke";
parent.__c.LogImpl("97995400","Failed to serialize object: "+BA.ObjectToString(_map.Get((Object)(_key))),0);
 if (true) break;

case 9:
//C
this.state = 12;
;
 if (true) break;
if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=7995403;
 //BA.debugLineNum = 7995403;BA.debugLine="Dim SenderFilter As Object = sql1.ExecNonQueryBat";
_senderfilter = __ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQueryBatch(ba,"SQL");
RDebugUtils.currentLine=7995404;
 //BA.debugLineNum = 7995404;BA.debugLine="Wait For (SenderFilter) SQL_NonQueryComplete (Suc";
parent.__c.WaitFor("sql_nonquerycomplete", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "keyvaluestore", "putmapasync"), _senderfilter);
this.state = 14;
return;
case 14:
//C
this.state = -1;
_success = (Boolean) result[1];
;
RDebugUtils.currentLine=7995405;
 //BA.debugLineNum = 7995405;BA.debugLine="Return Success";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_success));return;};
RDebugUtils.currentLine=7995406;
 //BA.debugLineNum = 7995406;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _remove(b4a.example.keyvaluestore __ref,String _key) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "remove", true))
	 {return ((String) Debug.delegate(ba, "remove", new Object[] {_key}));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Public Sub Remove(Key As String)";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="sql1.ExecNonQuery2(\"DELETE FROM main WHERE key =";
__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery2("DELETE FROM main WHERE key = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_key)}));
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="End Sub";
return "";
}
public String  _vacuum(b4a.example.keyvaluestore __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="keyvaluestore";
if (Debug.shouldDelegate(ba, "vacuum", true))
	 {return ((String) Debug.delegate(ba, "vacuum", null));}
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Public Sub Vacuum";
RDebugUtils.currentLine=8650757;
 //BA.debugLineNum = 8650757;BA.debugLine="sql1.ExecNonQuery(\"VACUUM\")";
__ref._sql1 /*anywheresoftware.b4a.sql.SQL*/ .ExecNonQuery("VACUUM");
RDebugUtils.currentLine=8650759;
 //BA.debugLineNum = 8650759;BA.debugLine="End Sub";
return "";
}
}