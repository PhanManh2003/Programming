# json string contains object -> object : loads()
# object -> json string contains object : dumps()

import json
# 1. Json string -> dict
import json

jsonString = '{"a":54, "b": {"c":87, "d": 97}}'
aDict = json.loads(jsonString)
print(aDict)
print(aDict['a'])
print(aDict['b']['d'])
print(type(aDict))

# 2. Json string -> list

jsonStr = '[[{"a":1, "b":2}], [{"c":3, "d":4}]]'
aList = json.loads(jsonStr)
print(aList[0][0]['a'])
print(type(aList))

# 3. Dict -> Json string
myDict = {'a': 'apple', 'b': 'banana', 'c': 'cherry'}
jsonStr = json.dumps(myDict)
print(type(jsonStr))
print(jsonStr)

# 4. List -> Json string
aList = [{'a': 1, 'b': 2}, {'c': 3, 'd': 4}]
jsonStr = json.dumps(aList)
print(jsonStr)

