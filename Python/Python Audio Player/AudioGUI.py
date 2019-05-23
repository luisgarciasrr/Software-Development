from tkinter import *
from Audio2 import Audio2
from AudioAD import AudioAD


class AudioGUI:

    # Atributos
    frame = Tk()
    audioad = Audio2()
    audioad2 = AudioAD()
    

    # Constructor
    def __init__(this):

        # 1. Definicion y creacion de los atributos
        # JFrame
        this.frame.title("Audio Player")
        this.frame.geometry("500x500")

        # JLabels
        this.lbSong = Label(this.frame, text="Cancion a reproducir:")
        this.lbRepro = Label(this.frame, text="Reproduciendo: ")

        # JTextFields
        this.tfSong = Entry(this.frame, width=20)

        # JButtons
        this.bPlay = Button(this.frame, text="Play", command=this.bPlayEvent)
        this.bStop = Button(this.frame, text="Show Songs", command=this.bStopEvent)
        this.taDatos = Text(this.frame, width=40, height=10)
        
        # 2. Colocar los atributos en un Layout
        this.lbSong.grid(row=0, column=0)
        this.tfSong.grid(row=0, column=1)

        this.bPlay.grid(row=1, column=0)
        this.bStop.grid(row=1, column=1)
        this.taDatos.grid(row=2, column=0)
        
        
        # 3. Hacer visible al frame
        this.frame.mainloop()
        
    def addLabel(this,respuesta):
        this.lbRepro.config(text="Reproduciendo: "+respuesta)
        
    def bPlayEvent(this):
        song = this.tfSong.get()
        respuesta = this.audioad.reproducir(song)
        this.addLabel(respuesta)

    
        
    def bStopEvent(this):
        datos = this.audioad2.lista()
        this.taDatos.insert(END,datos)

# main()
audio = AudioGUI()
