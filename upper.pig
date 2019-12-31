REGISTER '/var/app/kritter/pig/pig-0.12.0/pig-udf-upper.jar'    
stu_data = LOAD 'hdfs://localhost:9000/pigsample' USING PigStorage(',') as (name:chararray,age:int,gpa:float);
B = FOREACH stu_data GENERATE TextUpper(name);                                                                
dump B;
