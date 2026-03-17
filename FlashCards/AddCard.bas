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

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private QuestionET As EditText
	Private AnswerET As EditText
	Private spsubdecks As Spinner
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("Layout3")
	
	Dim tappeddeck As Map =  Main.deck.Get(Main.selecteddeck)
	
	For Each subdeckName As String In tappeddeck.keys
		spsubdecks.Add(subdeckName)
	Next
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub SaveCard_Click
	
	Dim tappeddeck As Map = Main.deck.Get(Main.selecteddeck)
	If QuestionET.Text = "" Then
		MsgboxAsync("Enter the Question!", "Error")
	Else if AnswerET.Text = "" Then
		MsgboxAsync("Enter the Answer!", "Error")
		
	Else
		Dim chosensubdeck As String = spsubdecks.SelectedItem
	
		Dim flashcards As List = tappeddeck.Get(chosensubdeck)
	
		Dim cards As Map
		cards.initialize
		cards.Put("Q", QuestionET.Text)
		cards.Put("A", AnswerET.Text)
	
		flashcards.Add(cards)
		QuestionET.Text = ""
		AnswerET.Text = ""
	End If
	
End Sub