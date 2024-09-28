class OTo:
    tieu_thu = 50

    def __init__(self, hang_xe, mau_xe, bien_so):
        self.hang_xe = hang_xe
        self.mau_xe = mau_xe
        self.bien_so = bien_so

    def run(self):
        print(f"{self.hang_xe} dang chay")

    def stop(self):
        print(f"{self.hang_xe} da dung")

    def pip(self):
        print(f"bien so: {self.bien_so} dang bam coi.")


class OToTai(OTo):
    def keo_xe(self):
        self.run()  # phương thức chứa phương thức
        print(f"{self.bien_so} dang keo xe.")


x = OToTai('Audi', 'Q7', '29A3223')
x.keo_xe()
