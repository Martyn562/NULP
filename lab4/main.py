import numpy as np
f = open('data', 'r')
data = []

for line in f:
    data.append(line.replace('\n','').split(", "))

ratings =[]
result =[]
names = [ 'Opel',  'Fiat','Porshe','Shkoda','VW']

print("№   Paramether importance   Opel   Fiat    Porshe  Shkoda VW")

for element in data:
    for i in range(8):
        print(element[i],'     ', end=" ")
    print()

for element in data:
    element.pop(0)
    element.pop(0)
    ratings.append(element)

ratings = np.array(ratings)
ratings = ratings.astype(float)
ratings = ratings.transpose()

for element in ratings:
    result.append(sum(element))

print('         Sum       ', end=" ")
for element in result:
    print(element,'     ', end=" ")

index = result.index(max(result))

print("\nThe best decision is :%(maxvalue)f it is  %(name)s " % {"maxvalue": max(result), "name":names[index-1]})
