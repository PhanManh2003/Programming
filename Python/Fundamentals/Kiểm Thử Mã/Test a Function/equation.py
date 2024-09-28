def root_finder(a, b):
    if a:
        return -b / a
    elif b:
        return "Vô nghiệm"
    else:
        return "Vô số nghiệm."


if __name__ == "__main__":
    print(root_finder(0, 10))
