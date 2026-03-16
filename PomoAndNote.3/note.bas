B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.4
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private xui As XUI
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private addBtn As Button
	Private noteClv As CustomListView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("notepadLayout")

End Sub

Sub Activity_Resume
	RefreshList
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub noteClv_ItemClick (Index As Int, Value As Object)
	' Value is the MyNote object we stored earlier
	Dim selectedNote As MyNote = Value
    
	' Tell the EditActivity which note we want to open
	editnote.ActiveNote = selectedNote
    
	StartActivity(editnote)
End Sub

Sub noteClv_ItemLongClick (Index As Int, Value As Object)
	Dim n As MyNote = Value
    
	' Ask for confirmation
	Msgbox2Async("Are you sure you want to delete '" & n.Title & "'?", "Delete Note", "No", "", "Yes", Null, False)
	Wait For Msgbox_Result (res As Int)
	If res = DialogResponse.NEGATIVE Then
		' 1. Remove from the KeyValueStore
		Main.kvs.Remove("N_" & n.noteID)
        
		' 2. Refresh the list so it disappears
		RefreshList
        
		ToastMessageShow("Note deleted", False)
	End If
End Sub

Sub RefreshList
	noteClv.Clear
	' Loop through all keys in KVS that start with "N_"
	Dim keys As List = Main.kvs.ListKeys
	For Each k As String In keys
		If k.StartsWith("N_") Then
			Dim n As MyNote = Main.kvs.Get(k)
			' Add to list (Title and Tags shown in the list)
			noteClv.AddTextItem(n.Title & CRLF & n.Tags, n)
		End If
	Next
End Sub

Sub addBtn_Click
	' Open the screen to write a new note
	StartActivity(editnote)
End Sub

Sub noteCvl_ItemClick (Index As Int, Value As Object)
	' Value is the MyNote object we stored.
	' You could use this to open an existing note to edit it.
End Sub

