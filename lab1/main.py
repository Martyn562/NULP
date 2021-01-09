

with open('matrix22', 'r') as fmatrix:
    matrix = [[int(num) for num in line.split(',')] for line in fmatrix]

print('___________________________________________________________')
print('Matrix of values')
print(matrix)
print('___________________________________________________________')
print('Wald"s criterion'+'\n'+'___________________________________________________________'+'\n'+'Max and min values from row')

minValues = []
maxValues = []

for x in matrix:
 minValues.append(min(x))
 maxValues.append(max(x))


print(minValues)

print('Max from min')

print(max(minValues))
print('___________________________________________________________')

print('Maximax criterion')
print('___________________________________________________________'+'\n'+ 'Max values')
print(maxValues)
print('Max from max')
print(max(maxValues))

print('___________________________________________________________')
koef = 0.7
print("Hurwitz's criterion %(koef)s"%{"koef":"{:.1f}".format(koef)})
print('___________________________________________________________')

hurwitz = []
iterator = 0

for x, y in zip(minValues, maxValues):
    hurwitz.append(koef*x +(1-koef)*y)
    print "K(%(iterator)d) = %(hurwitz)d" % {"iterator": iterator, "hurwitz":hurwitz[iterator]}
    iterator +=1
print("K(opt) = %(max)d"%{"max":max(hurwitz)})
print('___________________________________________________________')
print('Laplace criterion')
print('___________________________________________________________')
lmatrix = []
for x in matrix:
    lmatrix.append((sum(x)+0.0)/len(x))
print(lmatrix)
print('Max value')
print(lmatrix[lmatrix.index(max(lmatrix))])
print('___________________________________________________________')
print('Bayesian Laplace criterion')
print('___________________________________________________________')
print('Probabilities')

qn = [.5, .35, .15]
print("q1 = %(q0)s q2 = %(q1)s q3 = %(q2)s"%{"q0":"{:.2f}".format(qn[0]),"q1":"{:.2f}".format(qn[1]),"q2":"{:.2f}".format(qn[2])})

blmatrix = []
maxbl = []
for x in matrix :
    blmatrix.append([(i+ .0) * y for i, y in zip(x,qn)])
    maxbl.append(sum([(i+ .0) * y for i, y in zip(x,qn)]))

print(blmatrix)
print('Max values ')
print(maxbl)
print("Max with max %(max)s"%{"max":max(maxbl)})
print('___________________________________________________________')
