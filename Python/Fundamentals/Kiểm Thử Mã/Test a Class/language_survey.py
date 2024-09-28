from survey import AnonymousSurvey

question = "What is your favorite language?"
my_survey = AnonymousSurvey(question) # my_survey là 1 thực thể (1 object) của lớp AnonymousSurvey
my_survey.show_question()
print("Enter 'q' at any time to quit.\n")
while True:
    response = input("Language: ")
    if response == 'q':
        break
    my_survey.store_response(response)

print("Thank you!")
my_survey.show_results()