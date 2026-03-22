B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.4
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim helpPage As Int = 0
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private titleLbl As Label
	Private descriptionLbl As Label
	Private backBtn As Button
	Private nextBtn As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("helpAct")
	showHelpPage(0)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub showHelpPage(page As Int)
	helpPage = page
    
	Select page
		Case 0
			titleLbl.Text = "Welcome"
			descriptionLbl.Text = "This app is tailor-made for students—or anyone who wants to learn. It has all the features you'll need in order to learn effectively!"
        
		Case 1
			titleLbl.Text = "Clock"
			descriptionLbl.Text = "This is the pomodoro feature, explanation goes here yada yada"
        
		Case 2
			titleLbl.Text = "Notetaking"
			descriptionLbl.Text = "We take notes here, and we save em."
        
		Case 3
			titleLbl.Text = "Minions"
			descriptionLbl.Text = "Can we just praise Bob? I love the guy"
	End Select
    
	' Disable buttons at limits
	backBtn.Enabled = (page > 0)
	nextBtn.Enabled = (page < 3)
End Sub

Sub nextBtn_Click
	If helpPage < 3 Then
		showHelpPage(helpPage + 1)
	End If
End Sub

Sub backBtn_Click
	If helpPage > 0 Then
		showHelpPage(helpPage - 1)
	End If
End Sub

Sub closedaShi_Click
	Activity.Finish
End Sub