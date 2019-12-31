A = LOAD 'sample.txt' AS (line:chararray);
words = FOREACH A GENERATE FLATTEN(TOKENIZE(line,',')) AS word;
grouped = GROUP words by word;
wordcount = FOREACH grouped GENERATE group,COUNT(words);
dump wordcount; 
STORE wordcount INTO 'wordcount_output';
