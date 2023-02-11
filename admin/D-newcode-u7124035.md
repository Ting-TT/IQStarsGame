# New Code for Deliverable D2D

## u7124035 Shafin Kamal

For Deliverable D2D, I contributed the following new statements of original code:

- I altered code in the [checkPiecePlacement(String gameStateString)](https://gitlab.cecs.anu.edu.au/u7124035/comp1110-ass2-tue15g/-/blob/master/src/comp1110/ass2/IQStars.java#L358-411) function
- I had a problem with checking if there were repeats of a colour when dealing with star pieces (which is not allowed).
I initially used the switch expression but changed this to simple if-else expressions and now the problem is gone.

- The test I implemented is [CheckColourOrderTest](https://gitlab.cecs.anu.edu.au/u7124035/comp1110-ass2-tue15g/-/blob/master/tests/comp1110/ass2/CheckColourOrderTest.java)

Please note that while there are over 10 lines, some lines just consist of 'else' or a curly bracket.