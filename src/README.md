#paragraph-parsing

You are provided with short paragraphs (no more than 5,000 characters) of text
from Wikipedia, about well known places, persons, animals, flowers etc. For each
paragraph, there is a set of five questions, which can be answered by reading the
paragraph. Answers are of entirely factual nature, e.g. date, number, name, etc.
and will be exact substrings of the paragraph. Answers could either be one word,
group of words, or a complete sentence. You are also provided with the answers to
each of these questions, though they are jumbled up, separated by semicolon, and
provided in no specific order. Your task is to identify, which answer corresponds to
which question.

#Input Format

The first line contains a short paragraph of text from Wikipedia.
Lines 2 to 6 contain a total of 5 questions.
Line 7 contains all the five answers, which are jumbled up.

#Output Format

Five lines - the first line should contain the answer to the first question, second line
should contain the answer to the second question, and so on and so forth.
The answer should be entirely confined to one of the possible answers, listed in
the last line of the input i.e. Line 7

#Installing
Import the project as maven java project in IDE

Plugins added : lombok, JUnit

#Main Class 
src/main/java/ParsingMain.java

#JUNIT
src/main/test/paragraph-parsing/src/test/java/service/ParseServiceImplTest.java

#Input File 
src/main/resources/input.txt



