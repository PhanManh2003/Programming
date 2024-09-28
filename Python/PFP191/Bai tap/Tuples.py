#create a tuple.
def tuples1(): 
    #Create an empty tuple 
    x = ()
    print(x)
    #Create an empty tuple with tuple() function built-in Python
    tuplex = tuple()
    print(tuplex)

#create a tuple with different data types.
def tuples2():
    tuplex = ("tuple", False, 3.2, 1)
    print(tuplex)

#create a tuple of numbers and print one item.
def tuples3():
    #Create a tuple with numbers
    tuplex = 5, 10, 15, 20, 25
    print(tuplex)
    #Create a tuple of one item
    tuplex = 5,
    print(tuplex)

#unpack a tuple into several variables
def tuples4():
    #create a tuple
    tuplex = 4, 8, 3 
    print(tuplex)
    n1, n2, n3 = tuplex
    #unpack a tuple in variables
    print(n1 + n2 + n3) 

#add an item to a tuple.
def tuples5():
    #create a tuple
    tuplex = (4, 6, 2, 8, 3, 1) 
    print(tuplex)
    #tuples are immutable, so you can not add new elements
    #using merge of tuples with the + operator you can add an element and it will create a new tuple
    tuplex = tuplex + (9,)
    print(tuplex)
    #adding items in a specific index
    tuplex = tuplex[:5] + (15, 20, 25) + tuplex[:5]
    print(tuplex)
    #converting the tuple to list
    listx = list(tuplex) 
    #use different ways to add items in list
    listx.append(30)
    tuplex = tuple(listx)
    print(tuplex)

#convert a tuple to a string.
def tuples6():
    tup = ('p', 'f', 'p', '1', '9', '1', 'f', 'p', 't')
    str =  ''.join(tup)
    print(str)

#get the 4th element from the last element of a tuple.
def tuples7():
    #Get an item of the tuple
    tuplex = ('p', 'f', 'p', '1', '9', '1', 'f', 'p', 't')
    print(tuplex)
    #Get item (4th element)of the tuple by index
    item = tuplex[3]
    print(item)
    #Get item (4th element from last)by index negative
    item1 = tuplex[-4]
    print(item1)

#find repeated items in a tuple.
def tuples8():
    #create a tuple
    tuplex = 2, 4, 5, 6, 2, 3, 4, 4, 7 
    print(tuplex)
    #return the number of times it appears in the tuple.
    count = tuplex.count(4)
    print(count)

#check whether an element exists within a tuple.
def tuples9():
    tuplex = ('p', 'f', 'p', '1', '9', '1', 'f', 'p', 't')
    print("f" in tuplex)
    print(5 in tuplex)

#convert a list to a tuple.
def tuples10():
    #Convert list to tuple
    listx = [5, 10, 7, 4, 15, 3]
    print(listx)
    #use the tuple() function built-in Python, passing as parameter the list
    tuplex = tuple(listx)
    print(tuplex)

#remove an item from a tuple.
def tuples11():
    #create a tuple
    tuplex = ('p', 'f', 'p', '1', '9', '1', 'f', 'p', 't')
    print(tuplex)
    #tuples are immutable, so you can not remove elements
    #using merge of tuples with the + operator you can remove an item and it will create a new tuple
    tuplex = tuplex[:2] + tuplex[3:]
    print(tuplex)
    #converting the tuple to list
    listx = list(tuplex) 
    #use different ways to remove an item of the list
    listx.remove("f") 
    #converting the tuple to list
    tuplex = tuple(listx)
    print(tuplex)

#slice a tuple.
def tuples12():
    #create a tuple
    tuplex = (2, 4, 3, 5, 4, 6, 7, 8, 6, 1)
    #used tuple[start:stop] the start index is inclusive and the stop index
    _slice = tuplex[3:5]
    #is exclusive
    print(_slice)
    #if the start index isn't defined, is taken from the beg inning of the tuple
    _slice = tuplex[:6]
    print(_slice)
    #if the end index isn't defined, is taken until the end of the tuple
    _slice = tuplex[5:]
    print(_slice)
    #if neither is defined, returns the full tuple
    _slice = tuplex[:]
    print(_slice)
    #The indexes can be defined with negative values
    _slice = tuplex[-8:-4]
    print(_slice)
    #create another tuple
    tuplex = tuple("HELLO WORLD")
    print(tuplex)
    #step specify an increment between the elements to cut of the tuple
    #tuple[start:stop:step]
    _slice = tuplex[2:9:2]
    print(_slice)
    #returns a tuple with a jump every 3 items
    _slice = tuplex[::4]
    print(_slice)
    #when step is negative the jump is made back
    _slice = tuplex[9:2:-4]
    print(_slice)

#find the index of an item in a tuple.
def tuples13():
    #create a tuple
    tuplex = tuple("index tuple")
    print(tuplex)
    #get index of the first item whose value is passed as parameter
    index = tuplex.index("p")
    print(index)
    #define the index from which you want to search
    index = tuplex.index("p", 5)
    print(index)
    #define the segment of the tuple to be searched
    index = tuplex.index("e", 3, 6)
    print(index)

#find the length of a tuple.
def tuples14():
    #create a tuple
    tuplex = tuple("PFP192FPT")
    print(tuplex)
    #use the len() function to known the length of tuple
    print(len(tuplex))

#convert a tuple to a dictionary.
def tuples15():
    #create a tuple
    tuplex = ((2, "w"),(3, "r"))
    print(dict((y, x) for x, y in tuplex))

#reverse a tuple.
def tuples16():
    #create a tuple
    x = ("PFP192FPT")
    # Reversed the tuple
    y = reversed(x)
    print(tuple(y))
    #create another tuple
    x = (5, 10, 15, 20)
    # Reversed the tuple
    y = reversed(x)
    print(tuple(y))

#convert a list of tuples into a dictionary.
def tuples17():
    #create a list
    l = [("x", 1), ("x", 2), ("x", 3), ("y", 1), ("y", 2), ("z", 1)]
    d = {}
    for a, b in l:
        d.setdefault(a, []).append(b)
    print (d)