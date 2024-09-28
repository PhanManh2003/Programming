# Q1 (2.5 marks). Write a program that performs the following tasks:
# 1.	Create a new empty text file named ‘sales.txt’
import os
from datetime import datetime

print("Q1")
filename = 'sales.txt'

if os.path.exists(filename):  # Check if the file already exists
    print(f"File '{filename}' already exists.")
else:

    with open(filename, 'w') as f:  # Create a new empty file
        print(f"Created {filename}")
        f.close()

# 2.	Create File with a DateTime
now = datetime.now()  # Get the current datetime

timestamp1 = now.strftime('%d-%m-%Y')
timestamp2 = now.strftime('%d-%m-%Y-%H-%M-%S')  # Format the datetime as a string to use in the filename
dir_path = "C:\\Exercises\\"
filename = f'created {timestamp1}.txt'  # Define the filename with the timestamp

if os.path.exists(filename):  # Check if the file already exists
    print(f"File '{timestamp1}' already exists.")
else:
    # Create a new empty file
    with open(filename, 'w') as f:
        print(f"Created {timestamp1}.txt")
        print(f"Created {timestamp2}.txt")
        print(f"Created {dir_path}{timestamp2}.txt")
        f.close()
# 3.	Create a file with Permission.

# Define the file permissions (in octal notation)
filemode = 0o644  # rw-r--r--
filename = 'sample.txt'
# Check if the file already exists
if os.path.exists(filename):
    print(f"File '{filename}' already exists.")
else:
    # Create a new empty file with specific permissions
    with open(filename, 'w') as f:
        os.chmod(filename, filemode)  # Change file permissions
        print(f"File '{filename}' has been created with permissions {oct(filemode)}.")
        f.close()

# Q2 (2.5 marks). Write a program that performs the following tasks:
# 1.	Write to a new file
print("\nQ2")
filename = 'new.txt'
with open(filename, 'w') as f:
    f.write("Done writing\n")
    f.write("This is new content\n")
    f.close()

# 2. Writing To An Existing File
filename = 'sales.txt'
with open(filename, 'w') as f:
    f.write("This is new content\n")
    f.write("Opening file again..\n")
    f.write("This is overwritten content\n")
    f.close()

# 3. Write a list of lines to a file
filename = 'list.txt'
information = []
while True:
    input_str = input("Enter information (or press Enter to stop): ")
    if input_str == '':
        break
    information.append(input_str)

with open(filename, 'w') as f:
    for item in information:
        f.write(item + '\n')
    f.close()
with open(filename, 'r') as f:
    a = f.readlines()
    for line in a:
        print(line.rstrip())
    f.close()

# Q3. (2.5 marks). Write a program that performs the following tasks:
# 1.	Seek the Beginning of the File
print("\nQ3")
with open('question3.txt', 'w+') as f:
    f.write('My First Line\n')
    f.write('My Second Line')
    # move pointer to the beginning
    f.seek(0)
    # read file
    print(f.read())

# 2.	Seeking The End of File
print()
with open('question3.txt', 'r+') as f:
    # Moving the file handle to the end of the file
    f.seek(0, 2)

    # Inserting new content to the end of the file
    f.write("\nThis content is added to the end of the file")

    # moving to the beginning again read the whole file
    f.seek(0)
    print(f.read())

# 3.	Seek From The Current Position
print()
with open('question3.txt', 'rb') as f:
    f.seek(3)
    print(f.read(5).decode('utf-8'))
    f.seek(10, 1)
    print(f.read(6).decode('utf-8'))

# 4.	Seek backward With Negative Offset
print()
with open('question3.txt', 'rb') as f:
    print(f.read(8).decode('utf-8'))
    f.seek(-5, 1)
    print(f.read(10).decode("utf-8"))

# 5.	Use tell() Function To Get File Handle Position
print()
with open('question3.txt', "r+") as f:
    # Moving the file handle to the end of the file
    f.seek(0, 2)

    # getting the file handle position
    print('file handle at:', f.tell())

    # writing new content
    f.write("\nDemonstrating tell")

    # getting the file handle position
    print('file handle at:', f.tell())

    # move to the beginning
    f.seek(0)
    # getting the file handle position
    print('file handle at:', f.tell())

    # read entire file
    print('***Printing File Content***')
    print(f.read())
    print('***Done***')

    # getting the file handle position
    print('file handle at:', f.tell())

# Q4. (2.5 marks). Write a program that performs the following tasks:
# 1.	Rename a file after checking whether it exists
old_name = 'details.txt'
new_name = 'new_details.txt'

if os.path.isfile(new_name):
    print("The file already exists")
else:
    # Rename the file
    with open('details.txt', 'w') as f:
        f.close()
    os.rename(old_name, new_name)
