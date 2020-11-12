from pip._vendor.distlib.compat import raw_input

a = 1.0
b = 1.5
h = 0.5
e = 0.001

array_x =[]
array_y = []

xmax = 0
ymax = 0
iterator = a -h
while 2*h >e:
     while iterator<b :
          iterator = round(iterator +h,4)
          array_x.append(iterator)
          array_y.append(1+2*iterator+0.5*pow(iterator,2)-pow(iterator,6)/6)
          #array_y.append(-pow(iterator,2)+5)

     ymax = max(array_y)
     xmax = array_x[array_y.index(ymax)]
     array_y =[]
     array_x =[]
     if xmax== a:
          b= xmax + h
     elif  xmax== b:
          a = xmax -h
     else:
          b = xmax + h
          a = xmax - h
     h /=10
     iterator = a -h

print(xmax)
print(ymax)
raw_input('Press <ENTER> to continue')