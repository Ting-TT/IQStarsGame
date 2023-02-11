## Code Review

Reviewed by: Ting Tang, u7228238

Reviewing code written by: Benjamin Pope, u7134733

Component: code for task 3: isGameStringWellFormed(String gameString)
    https://gitlab.cecs.anu.edu.au/u7124035/comp1110-ass2-tue15g/-/blob/master/src/comp1110/ass2/IQStars.java#L31-106    

### Comments 

- The best features are the logics and structure of this code. While reading the code, it is really clear to see 
  the way of approaching Ben used to solve this task. His code checks this task's requirements step by step, and 
  for different cases of the input, he used a switch statement to discuss them separately.
  
- The code is well-documented. The comments were written appropriately, as each comment expresses which condition it is
  checking clearly. At the same time, no unnecessary comments was implemented.

- The program decomposition is appropriate. It has the correct method structure.

- Names for the variables follow Java code conventions correctly, and the meaning/use of each variable is clearly 
  expressed by its name. The style of the code is consistent throughout the method.
  
- There is no error in the code. The code is working correctly to meet the requirements for task 3.
  However, I do have some suggestions to simplify the code and hence improve the code quality.
  1) When it verifies the character which expresses the colour of the piece/wizard, if this character is not contained
     by the array "validPieceColours", then we can "return false" here instead of continuing checking other characters 
     and "return false" at the end.
  2) The part which checks the validity of the row and column of a piece/wizard is same for pieces and wizards, so
     we can give them a same name like "columnInt" instead of "wizardColInt" and "pieceColInt", and we can write the 
     code for checking validity of a column number once instead of repeating it twice (for example, line 66-70 & 
     line 95-99 are similar), same for the validity of a row number.
  3) To initiate a boolean variable with a false value, we can simply state the variable's name without stating it is
     false, since the default value for a boolean variable is false. For example, we can write "boolean pieceLocOk;" 
     instead of writing "boolean pieceLocOk = false;".
     