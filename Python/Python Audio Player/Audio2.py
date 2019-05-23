import winsound

class Audio2:
    song = ""
    
    def reproducir(self,song2):
        self.song = song2
        print(self.song)

        winsound.PlaySound(self.song, winsound.SND_ASYNC)
        
        return self.song
