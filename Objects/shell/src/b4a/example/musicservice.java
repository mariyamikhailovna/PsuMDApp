
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class musicservice implements IRemote{
	public static musicservice mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public musicservice() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("musicservice"), "b4a.example.musicservice");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("b4a.example.musicservice");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, musicservice.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _mediaplayer = RemoteObject.declareNull("anywheresoftware.b4a.objects.MediaPlayerWrapper");
public static RemoteObject _musicplaylist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _currentsong = RemoteObject.createImmutable(0);
public static RemoteObject _songtimer = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.mainactivity _mainactivity = null;
public static b4a.example.navactivity _navactivity = null;
public static b4a.example.helpactivity _helpactivity = null;
public static b4a.example.clockactivity _clockactivity = null;
public static b4a.example.noteactivity _noteactivity = null;
public static b4a.example.editnote _editnote = null;
public static b4a.example.corkactivity _corkactivity = null;
public static b4a.example.todoactivity _todoactivity = null;
public static b4a.example.musicactivity _musicactivity = null;
  public Object[] GetGlobals() {
		return new Object[] {"clockActivity",Debug.moduleToString(b4a.example.clockactivity.class),"corkActivity",Debug.moduleToString(b4a.example.corkactivity.class),"currentSong",musicservice._currentsong,"editnote",Debug.moduleToString(b4a.example.editnote.class),"helpActivity",Debug.moduleToString(b4a.example.helpactivity.class),"Main",Debug.moduleToString(b4a.example.main.class),"MainActivity",Debug.moduleToString(b4a.example.mainactivity.class),"mediaPlayer",musicservice._mediaplayer,"musicActivity",Debug.moduleToString(b4a.example.musicactivity.class),"musicPlaylist",musicservice._musicplaylist,"navActivity",Debug.moduleToString(b4a.example.navactivity.class),"noteActivity",Debug.moduleToString(b4a.example.noteactivity.class),"Service",musicservice.mostCurrent._service,"songTimer",musicservice._songtimer,"Starter",Debug.moduleToString(b4a.example.starter.class),"todoActivity",Debug.moduleToString(b4a.example.todoactivity.class)};
}
}