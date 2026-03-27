B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=13.4
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: True
	
#End Region

Sub Process_Globals
	Dim mediaPlayer As MediaPlayer
	Dim musicPlaylist As List
	Dim currentSong As Int
	Dim songTimer As Timer
End Sub

Sub Service_Create
	mediaPlayer.Initialize
	musicPlaylist.Initialize
    
	musicPlaylist.Add("tracks/intro.mp3")
	musicPlaylist.Add("tracks/taiyaki.mp3")
	musicPlaylist.Add("tracks/feel special.mp3")
	musicPlaylist.Add("tracks/union.mp3")
	musicPlaylist.Add("tracks/two in the morning.mp3")
	musicPlaylist.Add("tracks/happily ever after.mp3")
	musicPlaylist.Add("tracks/cookie.mp3")
	musicPlaylist.Add("tracks/comfy vibes.mp3")
	musicPlaylist.Add("tracks/dango.mp3")
	musicPlaylist.Add("tracks/iced caramel macchiato.mp3")
	musicPlaylist.Add("tracks/in dreamland.mp3")
	musicPlaylist.Add("tracks/space aquarium.mp3")
	musicPlaylist.Add("tracks/sunshine & butterflies.mp3")
	musicPlaylist.Add("tracks/soda pop.mp3")
	musicPlaylist.Add("tracks/matcha latte.mp3")
	musicPlaylist.Add("tracks/midnight.mp3")
	musicPlaylist.Add("tracks/rose water.mp3")
	musicPlaylist.Add("tracks/hot.mp3")
	musicPlaylist.Add("tracks/on the top.mp3")
	
	currentSong = 0
	playSong
    
	songTimer.Initialize("songTimer", 500)
	songTimer.Enabled = True
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 'Call this when the background task completes (if there is one)
End Sub

Sub Service_Destroy

End Sub

Sub setSong(index As Int)
	currentSong = index
	playSong
End Sub

Sub playSong
	If mediaPlayer.IsInitialized Then
		mediaPlayer.Stop
	End If
	mediaPlayer.Load(File.DirAssets, musicPlaylist.Get(currentSong))
	mediaPlayer.Play
End Sub

Sub songTimer_Tick
	If mediaPlayer.IsPlaying = False Then
		nextSong
	End If
End Sub

Sub nextSong
	currentSong = currentSong + 1
	If currentSong >= musicPlaylist.Size Then
		currentSong = 0
	End If
	playSong
End Sub

Sub prevSong
	currentSong = currentSong - 1
	If currentSong < 0 Then
		currentSong = musicPlaylist.Size - 1
	End If
	playSong
End Sub

Sub pauseToggle
	If mediaPlayer.IsPlaying Then
		mediaPlayer.Pause
	Else
		mediaPlayer.Play
	End If
End Sub

