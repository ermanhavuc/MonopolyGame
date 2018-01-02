import re
from urllib import urlopen, urlretrieve
import textract
from wordcloud import WordCloud
import operator
import math

html = urlopen("http://mimoza.marmara.edu.tr/~cigdem.erdem/research.html")
html_doc = html.read()

match = re.findall(b'\"(.*?\.pdf)\"', html_doc)

articles = []
articleNames = []

for i in range(len(match)):  # len(match)
    articleNames.append(match[i].rsplit('/', 1)[1])
    #url = "http://mimoza.marmara.edu.tr/~cigdem.erdem/" + match[i]
    #urlretrieve(url, articleNames[i])
    articles.append(textract.process(articleNames[i]))

stopwords = open("stop_words", "r").read().split()

totalTermNumber = {}
articleNumber = {}
wordFlag = {}

for article in articles:

    splittedText = re.findall(r"[\w']+", article)

    cleanText = []

    for word in splittedText:

        if not word.isdigit() and not len(word) < 2:
            word = word.lower()
            if word not in stopwords:
                cleanText.append(word)

    for word in cleanText:

        if word in totalTermNumber:
            totalTermNumber[word] += 1
            if wordFlag[word] == 1:
                if word in articleNumber:
                    articleNumber[word] += 1
                else:
                    articleNumber[word] = 1
                wordFlag[word] = 0

        else:
            totalTermNumber[word] = 1
            articleNumber[word] = 1
            wordFlag[word] = 0

    for word in wordFlag:
        wordFlag[word] = 1

sortedTFList = sorted(totalTermNumber.items(), key=operator.itemgetter(1), reverse=True)

# tfidfdict

with open("tf_list.csv", "wb") as file:
    for i in range(53):
        file.write(sortedTFList[i][0] + ',' + str(sortedTFList[i][1]))
        file.write('\n')


def makeImage(text,flag):
    wc = WordCloud(background_color="white", max_words=50, max_font_size=50, width=480, height=270).generate_from_frequencies(text)
    image = wc.to_image()
    if flag == 1:
        image.save("tf_WordCloud.pdf")
    else:
        image.save("tfidf_WordCloud.pdf")


makeImage(totalTermNumber, 1)

tfidf = {}

for word in articleNumber:
    tfidf[word] = totalTermNumber[word] * math.log(len(articles) / articleNumber[word])

sortedTFIDFList = sorted(tfidf.items(), key=operator.itemgetter(1), reverse=True)

with open("tfidf_list.csv", "wb") as file:
    for i in range(53):
        file.write(sortedTFIDFList[i][0] + ',' + str(sortedTFIDFList[i][1]))
        file.write('\n')

makeImage(tfidf, 2)
