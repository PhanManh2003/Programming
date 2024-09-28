import unittest
from survey import AnonymousSurvey


class TestAnonymousSurvey(unittest.TestCase):
    def test_store_single_response(self):
        """Test that a single response is stored properly."""
        question = "What is your favorite languege?"
        my_survey = AnonymousSurvey(question)

        my_survey.store_response('English')
        self.assertIn('English', my_survey.responses)

    def test_store_three_response(self):
        """Test that three responses are stored properly."""
        question = "What is your favorite languege?"
        my_survey = AnonymousSurvey(question)

        responses = ['English', 'Spainish', 'Vietnamese']
        for response in responses:
            my_survey.store_response(response)
        for response in responses:
            self.assertIn(response, my_survey.responses)


if __name__ == '__main__':
    unittest.main()


# Sử dụng setUp() method để tránh lặp code
# When you include a setUp() method in a TestCase class, Python will run the setUp() method before
# running each method starting with 'test'
# Any objects created in the setUp() method are then available in each test method you write.
class TestAnonymousSurvey(unittest.TestCase):
    def setUp(self):
        """Create a survey and a set of responses to use in all test methods"""
        question = "What is your favorite language?"
        self.my_survey = AnonymousSurvey(question)
        self.responses = ['English', 'Spanish', 'Vietnamese']

    def test_store_single_response(self):
        """Test that a single response is stored properly."""
        self.my_survey.store_response(self.responses[0])
        self.assertIn(self.responses[0], self.my_survey.responses)

    def test_store_three_response(self):
        """Test that three responses are stored properly."""
        for response in self.responses:
            self.my_survey.store_response(response)
        for response in self.responses:
            self.assertIn(response, self.my_survey.responses)


if __name__ == '__main__':
    unittest.main()
