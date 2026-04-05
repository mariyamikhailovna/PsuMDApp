package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xgifview extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.b4xgifview");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.b4xgifview.class).invoke(this, new Object[] {null});
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
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
public anywheresoftware.b4j.object.JavaObject _gifdrawable = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.themeactivity _themeactivity = null;
public b4a.example.mainactivity _mainactivity = null;
public b4a.example.helpactivity _helpactivity = null;
public b4a.example.musiccodemodule _musiccodemodule = null;
public b4a.example.todoactivity _todoactivity = null;
public b4a.example.calendaractivity _calendaractivity = null;
public b4a.example.card_module _card_module = null;
public b4a.example.subdeck_module _subdeck_module = null;
public b4a.example.day_module _day_module = null;
public b4a.example.active_recall _active_recall = null;
public b4a.example.add_card_module _add_card_module = null;
public b4a.example.add_card_module2 _add_card_module2 = null;
public b4a.example.add_events_module _add_events_module = null;
public b4a.example.all_active_recall _all_active_recall = null;
public b4a.example.clockactivity _clockactivity = null;
public b4a.example.corkactivity _corkactivity = null;
public b4a.example.deck_all_cards _deck_all_cards = null;
public b4a.example.editnote _editnote = null;
public b4a.example.flashcardactivity _flashcardactivity = null;
public b4a.example.musicactivity _musicactivity = null;
public b4a.example.musicservice _musicservice = null;
public b4a.example.navactivity _navactivity = null;
public b4a.example.noteactivity _noteactivity = null;
public b4a.example.schedule_module _schedule_module = null;
public String  _setgif(b4a.example.b4xgifview __ref,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xgifview";
if (Debug.shouldDelegate(ba, "setgif", true))
	 {return ((String) Debug.delegate(ba, "setgif", new Object[] {_dir,_filename}));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Public Sub SetGif(Dir As String, FileName As Strin";
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="If Dir = File.DirAssets Then";
if ((_dir).equals(__c.File.getDirAssets())) { 
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="SetGif2(File.ReadBytes(Dir, FileName))";
__ref._setgif2 /*String*/ (null,__c.File.ReadBytes(_dir,_filename));
 }else {
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="SetBitmap(File.Combine(Dir, FileName))";
__ref._setbitmap /*String*/ (null,(Object)(__c.File.Combine(_dir,_filename)));
 };
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(b4a.example.b4xgifview __ref,double _width,double _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xgifview";
if (Debug.shouldDelegate(ba, "base_resize", true))
	 {return ((String) Debug.delegate(ba, "base_resize", new Object[] {_width,_height}));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Public Sub Base_Resize (Width As Double, Height As";
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="iv.SetLayoutAnimated(0, 0, 0, Width, Height)";
__ref._iv /*anywheresoftware.b4a.objects.ImageViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
RDebugUtils.currentLine=1900555;
 //BA.debugLineNum = 1900555;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.b4xgifview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xgifview";
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="Public Tag As Object";
_tag = new Object();
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="Private iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1441802;
 //BA.debugLineNum = 1441802;BA.debugLine="Public GifDrawable As JavaObject";
_gifdrawable = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=1441806;
 //BA.debugLineNum = 1441806;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(b4a.example.b4xgifview __ref,Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xgifview";
if (Debug.shouldDelegate(ba, "designercreateview", true))
	 {return ((String) Debug.delegate(ba, "designercreateview", new Object[] {_base,_lbl,_props}));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="mBase = Base";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Tag = mBase.Tag";
__ref._tag /*Object*/  = __ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getTag();
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="mBase.Tag = Me";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setTag(this);
RDebugUtils.currentLine=1572878;
 //BA.debugLineNum = 1572878;BA.debugLine="iv.Initialize(\"\")";
__ref._iv /*anywheresoftware.b4a.objects.ImageViewWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="mBase.AddView(iv, 0, 0, mBase.Width, mBase.Height";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .AddView((android.view.View)(__ref._iv /*anywheresoftware.b4a.objects.ImageViewWrapper*/ .getObject()),(int) (0),(int) (0),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=1572881;
 //BA.debugLineNum = 1572881;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.example.b4xgifview __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="b4xgifview";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname}));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="mCallBack = Callback";
__ref._mcallback /*Object*/  = _callback;
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="End Sub";
return "";
}
public String  _resizebasedonimage(b4a.example.b4xgifview __ref,anywheresoftware.b4a.objects.B4XViewWrapper _xiv,float _bmpratio) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xgifview";
if (Debug.shouldDelegate(ba, "resizebasedonimage", true))
	 {return ((String) Debug.delegate(ba, "resizebasedonimage", new Object[] {_xiv,_bmpratio}));}
float _viewratio = 0f;
int _height = 0;
int _width = 0;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Private Sub ResizeBasedOnImage(xiv As B4XView, Bmp";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Dim viewRatio As Float = mBase.Width / mBase.Heig";
_viewratio = (float) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()/(double)__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="Dim Height, Width As Int";
_height = 0;
_width = 0;
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="If viewRatio > BmpRatio Then";
if (_viewratio>_bmpratio) { 
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="Height = mBase.Height";
_height = __ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight();
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="Width = mBase.Height * BmpRatio";
_width = (int) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()*_bmpratio);
 }else {
RDebugUtils.currentLine=1835015;
 //BA.debugLineNum = 1835015;BA.debugLine="Width = mBase.Width";
_width = __ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth();
RDebugUtils.currentLine=1835016;
 //BA.debugLineNum = 1835016;BA.debugLine="Height = mBase.Width / BmpRatio";
_height = (int) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()/(double)_bmpratio);
 };
RDebugUtils.currentLine=1835018;
 //BA.debugLineNum = 1835018;BA.debugLine="xiv.SetLayoutAnimated(0, mBase.Width / 2 - Width";
_xiv.SetLayoutAnimated((int) (0),(int) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()/(double)2-_width/(double)2),(int) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()/(double)2-_height/(double)2),_width,_height);
RDebugUtils.currentLine=1835019;
 //BA.debugLineNum = 1835019;BA.debugLine="End Sub";
return "";
}
public String  _setbitmap(b4a.example.b4xgifview __ref,Object _obj) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xgifview";
if (Debug.shouldDelegate(ba, "setbitmap", true))
	 {return ((String) Debug.delegate(ba, "setbitmap", new Object[] {_obj}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
int _w = 0;
int _h = 0;
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Private Sub SetBitmap(obj As Object)";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Dim GifDrawable As JavaObject";
_gifdrawable = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="GifDrawable.InitializeNewInstance(\"pl.droidsonroi";
__ref._gifdrawable /*anywheresoftware.b4j.object.JavaObject*/ .InitializeNewInstance("pl.droidsonroids.gif.GifDrawable",new Object[]{_obj});
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="iv.Background = GifDrawable";
__ref._iv /*anywheresoftware.b4a.objects.ImageViewWrapper*/ .setBackground((android.graphics.drawable.Drawable)(__ref._gifdrawable /*anywheresoftware.b4j.object.JavaObject*/ .getObject()));
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="Dim jo As JavaObject = GifDrawable";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = __ref._gifdrawable /*anywheresoftware.b4j.object.JavaObject*/ ;
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="Dim w As Int = jo.RunMethod(\"getIntrinsicWidth\",";
_w = (int)(BA.ObjectToNumber(_jo.RunMethod("getIntrinsicWidth",(Object[])(__c.Null))));
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="Dim h As Int = jo.RunMethod(\"getIntrinsicHeight\",";
_h = (int)(BA.ObjectToNumber(_jo.RunMethod("getIntrinsicHeight",(Object[])(__c.Null))));
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="ResizeBasedOnImage(iv, w / h)";
__ref._resizebasedonimage /*String*/ (null,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__ref._iv /*anywheresoftware.b4a.objects.ImageViewWrapper*/ .getObject())),(float) (_w/(double)_h));
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="End Sub";
return "";
}
public String  _setgif2(b4a.example.b4xgifview __ref,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xgifview";
if (Debug.shouldDelegate(ba, "setgif2", true))
	 {return ((String) Debug.delegate(ba, "setgif2", new Object[] {_data}));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Public Sub SetGif2 (Data() As Byte)";
RDebugUtils.currentLine=1703950;
 //BA.debugLineNum = 1703950;BA.debugLine="SetBitmap(Data)";
__ref._setbitmap /*String*/ (null,(Object)(_data));
RDebugUtils.currentLine=1703952;
 //BA.debugLineNum = 1703952;BA.debugLine="End Sub";
return "";
}
}