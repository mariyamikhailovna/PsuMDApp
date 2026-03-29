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
	Private xui As XUI
	Dim helpPage As Int = 0
	Public format24h As Boolean = False
	Public kvs As KeyValueStore
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private titleLbl As Label
	Private descriptionLbl As Label
	Private backBtn As Button
	Private nextBtn As Button
	Private helpimage As ImageView
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
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 1
			titleLbl.Text = "Calendar"
			descriptionLbl.Text = "The calendar comes in three views to match however you like to plan. The Schedule view lets you see all your upcoming days at a glance, with major events and to-do items laid out on a timeline. The Day view shows you the full timeline for a single day, where you can add events, tasks, or birthdays, and color-coded backgrounds make each type of entry easy to tell apart. The Month view presents the classic calendar layout, complete with a month and year spinner to jump around quickly, a sneak peek of events on each day's cell, and neighboring dates filling in the empty cells so the grid always looks complete."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 2
			titleLbl.Text = "Clock"
			descriptionLbl.Text = "The clock keeps you on time and on task all in one place. A format button lets you switch between clock displays to whatever you prefer. It also comes with a built-in Pomodoro timer to help you stay focused and productive, and if the default durations don't work for you, you can freely adjust them to fit your own rhythm."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 3
			titleLbl.Text = "Corkboard"
			descriptionLbl.Text = "The corkboard gives you a creative space to pin your thoughts and ideas. You can place sticky notes in a variety of colors to keep things visually organized and easy to tell apart. Images from your gallery can be attached right onto the board for extra context or inspiration. And when words and notes aren't enough, you can open up a drawable canvas with a selection of colored pens and sketch, doodle, or diagram anything you have in mind."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 4
			titleLbl.Text = "Flashcards"
			descriptionLbl.Text = "The flashcard feature organizes your cards into decks and subdecks, and you have the freedom to add, rename, or delete any of them — with a confirmation before anything gets deleted for good. Cards are automatically shuffled so every session feels fresh. A progress bar and percentage track how far you've made it through a deck, and when you're ready to dive back in, two buttons have you covered — restart the entire deck from scratch, or continue right where you left off."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 5
			titleLbl.Text = "Music Player"
			descriptionLbl.Text = "The music player plays the music on startup, meaning the app greets you with songs! Filled with chill, lo-fi tracks, you have the freedom to choose what track you want to play--either through the previous/next song buttons, or through the list of songs below where you can click on whatever chooses your fancy. There's a segment of the song that you want to listen to again or you want to zoom through a certain bit of a song? The seek bar presents itself to you where you can navigate within the music."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 6
			titleLbl.Text = "Notepad"
			descriptionLbl.Text = "The notepad keeps all your notes in one tidy list that's easy to browse through. A search bar lets you quickly find any note by its title or tags, so nothing ever gets lost in the pile. Adding a new note is simple — just give it a title, attach some tags to keep things organized, and write away to your heart's content."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 7
			titleLbl.Text = "To-do List"
			descriptionLbl.Text = "The to-do list enables you to create lists with titles and, especially, tasks you want or are obligated to do. You are able to keep a lot of lists that you can easily navigate through the left side of your screen. The task section is a checklist of your tasks that you input, and once achieved, you can tick it off the list. The to-do list will also show you your progress in the list."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 8
			titleLbl.Text = "Themes"
			descriptionLbl.Text = "read title. does what it's supposed to do."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 9
			titleLbl.Text = "Lamp"
			descriptionLbl.Text = "read title. does what it's supposed to do."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
		Case 10
			titleLbl.Text = "Navigation"
			descriptionLbl.Text = "read title. does what it's supposed to do."
			helpimage.Bitmap = xui.LoadBitmapResize(File.DirAssets, "bob.png", helpimage.Width, helpimage.Height, True)
	End Select
    
	' Disable buttons at limits
	backBtn.Enabled = (page > 0)
	nextBtn.Enabled = (page < 7)
End Sub

Sub nextBtn_Click
	If helpPage < 7 Then
		showHelpPage(helpPage + 1)
	End If
End Sub

Sub backBtn_Click
	If helpPage > 0 Then
		showHelpPage(helpPage - 1)
	End If
End Sub

Sub closeHelp_Click
	Activity.Finish
End Sub
