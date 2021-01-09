
f = open('data', 'r')
data = []

for line in f:
    data.append(line.split(", "))

nvoice = []
symbols =[]

for element in data:
    nvoice.append(element[0])
    element.pop(0)
    symbols.append(element)


def methodBorda():
    A =0
    B =0
    C =0

    for element1 in symbols:
        for element2 in element1:
            if('A'==element2 or 'A\n'==element2):
                A += element1.index(element2)
            elif('B'==element2 or 'B\n'==element2):
                B += element1.index(element2)
            elif('C'==element2 or 'C\n'==element2):
                C += element1.index(element2)
    result = [A, B, C]

    print(' A  B  C', result)
    print('_________________________________________________________________________________________________')

def methodKonderse():


    checks = [['A', 'B'], ['A', 'C'], ['B', 'C']]
    result =[]
    for element1 in checks:
        number1 =0
        number2 =0
        for element2, element3 in zip(symbols ,nvoice):
            if(element1[0]+'\n'== element2[2] or element1[0]== element2[2]  ):
                number1 +=int(element3)
            elif(element1[0] == element2[1] and (element1[1]+'\n'!=element2[2] and element1[1]!=element2[2]) ):
                number1 += int(element3)
            if (element1[1] + '\n' == element2[2] or element1[1] == element2[2]) :
                number2 += int(element3)
            elif (element1[1] == element2[1] and( element1[0] + '\n' != element2[2] and element1[0]  != element2[2])):
                number2 += int(element3)
        temparr = []
        temparr.append(number1)
        temparr.append(number2)
        result.append(temparr)

    A = 0
    B = 0
    C = 0
    for text, element in zip(checks,result):
        print(text, element)

        if(text[element.index(max(element))]=='A'):
            A +=1
        elif(text[element.index(max(element))]=='B'):
            B +=1
        else:
            C +=1

    print('_________________________________________________________________________________________________')
    print(' A,B,C\n',A,B,C)
    print('_________________________________________________________________________________________________')
methodBorda()
methodKonderse()
