import glob

class AudioAD:
    lis = ''
    
    def lista(self):
        self.lis = ''
        path = ''
        files = [f for f in glob.glob(path + "*.wav", recursive=True)]
        for f in files:
            self.lis = self.lis + f + "\n"

        return self.lis
