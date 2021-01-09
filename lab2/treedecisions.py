with open('data', 'r') as f:
    l = [[int(num) for num in line.split(',')] for line in f]

i =0
for element in l:
        l[i][2] = element[2]/100
        l[i][4] = element[4]/100
        i+=1;

resultMaxMin = []
result = []
def calculate( data =[[]]):
    for element in data :
        temparray =[]
        temparray.append(element[0]+element[1]*element[5])
        temparray.append(element[0]+element[3]*element[5])
        resultMaxMin.append(temparray)
        result.append(temparray[0]*element[2]+temparray[1]*element[4])

calculate(l)

def printresult(text ,data):
    print(text)
    for element in data:
        print(element)
    print()
text1 =' M1     D1   P1   D2    P2   Y'
text2 =' Max    Min'
text3 ='Profites'
text4 ='Max Profit\n'

printresult(text1,l)
printresult(text2, resultMaxMin)
printresult(text3, result)
print(text4,max(result))

