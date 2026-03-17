B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.4
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Addbtn As Button
	Private addpanel2 As Panel
	Dim alldecks As Map = Main.deck
	Dim selecteddeck As String = Main.selecteddeck
	Private LVSubdecks As ListView
	Private decknamelabel As Label
	Private addpanel As Panel
	Private et1 As EditText
	Private AR_confirmationpanel As Panel
	Private confirmlabel As Label
	Dim number_of_cards As Int = 0
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("Layout2")
	
	Dim radius As Int = Addbtn.Width/2
	Dim cd As ColorDrawable
	cd.Initialize(Colors.Gray, radius)
	Addbtn.Background = cd
	
	
	
	
	decknamelabel.Text = selecteddeck
	LVSubdecks.SingleLineLayout.Label.textColor = Colors.black
	
	Dim tappeddeck As Map = alldecks.Get(selecteddeck)
	
	For Each deckName As String In tappeddeck.keys
		
		LVSubdecks.AddSingleLine(deckName)
	Next
	
	
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub Addbtn_Click
	If addpanel2.Visible = False Then
		addpanel2.Visible = True
	Else
		addpanel2.Visible = False
	End If
	
End Sub

Private Sub addcard_Click
	StartActivity(AddCard)
End Sub

Private Sub addsub_Click
	addpanel.Visible = True
End Sub

Private Sub cancel_Click
	addpanel.Visible = False
	et1.Text = ""
End Sub

Private Sub create_Click
	Dim tappeddeck As Map = alldecks.Get(selecteddeck)
	Dim flashcards As List
	flashcards.initialize
	
	If et1.Text = "" Then
		MsgboxAsync("Sub-Deck must have a name", "Error")
	Else
		addpanel.Visible = False
		LVSubdecks.AddSingleLine(et1.Text)
		tappeddeck.Put(et1.Text, flashcards)
		et1.Text = ""
	End If

End Sub

Private Sub goback_Click
	Activity.Finish
End Sub

Private Sub activerecall_Click
	number_of_cards = 0
	Dim chosendeck As Map = alldecks.Get(selecteddeck)
	For Each deckName As String In chosendeck.keys
		Dim flashacards As List = chosendeck.Get(deckName)
		number_of_cards = number_of_cards + flashacards.size
	Next
	AR_confirmationpanel.Visible = True
	confirmlabel.Text = "You got " & number_of_cards & " cards"
End Sub

Private Sub startArbtn_Click
End Sub

Private Sub cancelconfirmation_Click
	AR_confirmationpanel.Visible = False
End Sub