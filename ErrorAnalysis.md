# ErrorAnalysis
## Intro to Computer Science - 360-420-DW - 03
## Arthur Ayestas Hilgert 1736055

## Distributions of Model Accuracy

The test set is shuffled before its generation.  Thus, it will return different test values every test run.  There are 444 benign data points and 237 malignant data points.  If we were to assume that a program randomly assigned its results.  Its accuracy would be 50%.  If a program would assume all values to be benign, it would have a 65.19% accuracy rate.  This is a sensible lower bound for accuracy rates of program predicitons.


## Analysis of different error types

A false positive is a return value positive (malignant), when the patient should actually be assigned a negative value (benign).  A false positive is a return value negative (benign), when the patient should actually be assigned a positive value (malignant).  Accuracy is total correct returns divided by total data points (or chances).  Recall is true positive returns divided by the value of total actual positive data points.  Precision is true positive returns divided by the total number of predicted positive values (predicted malignant).  A sensible lower bound for recall rates is 0%.  In this situation a program would predict false for all points.  A more sensible lower bound would be 50%, if all preicted returns were assigned a random value.  A sensible lower bound for a precision rate is about 69.6% for a randomly assigning predictor (this would be the total number of actual correct values divided by half the data).  

##Results 

average accuracy: 96.94634146341504
standard deviation: 1.0884949434860383
average accuracy: 95.75328525336334
standard deviation: 6.4420899329074635
average accuracy: 95.51598980084623
standard deviation: 4.813927919791907 

These results are significantly above the baseline values.

![Final Results](Results.jpg)
