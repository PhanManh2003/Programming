text = "Helloi"
print(text[:1])
print(text[:-1])

print(text[:])  # in nguyên văn

print(text[::1])  # in nguyên văn từng kí tự, index mỗi kí tự hơn kém nhau 1
print(text[::-1])  # in nguyên văn từng kí tự, index mỗi kí tự hơn kém nhau 1 nhưng ngược lại

print(text[::2])  # in nguyên văn từng kí tự, index mỗi kí tự hơn kém nhau 2
print(text[::-2])  # in nguyên văn từng kí tự, index mỗi kí tự hơn kém nhau 2 nhưng ngược lại


def longest_common_subsequence(X, Y):
    m = len(X)
    n = len(Y)
    L = [[None] * (n + 1) for i in range(m + 1)]
    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 or j == 0:
                L[i][j] = 0
            elif X[i - 1] == Y[j - 1]:
                L[i][j] = L[i - 1][j - 1] + 1
            else:
                L[i][j] = max(L[i - 1][j], L[i][j - 1])
    return L[m][n]


def similarity_score(string1, string2):
    return longest_common_subsequence(string1, string2) / max(len(string1), len(string2))


input_string1 = "Cong hoa xa hoi chu nghia Viet Nam"
input_string2 = "Cong hoax a hoich u nghiaV ietN am"
score = similarity_score(input_string1, input_string2)
print("Similarity Score: {:.2f}".format(score))
