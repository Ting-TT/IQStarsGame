## Code Review

Reviewed by: Shafin Kamal, u7124035

Reviewing code written by: Ting Tang u7228238

Component: isGameStateValid (includes helper method fullPiece)

### Comments 

### Best Features
- Good use of for loops to iterate through the star strings. Makes it more efficient and readable.
- I like how you methodically check each criteria of validity in a code block. i.e. you're not checking multiple things at once which could lead to confusion for a new person reading your code.

### Well-Documented
- Good commenting on majority of your code. Having good documentation is always great to have as it allows others to read your code.
- most complex statements are commented and there are also comments before the for loops which is helpful.
- I would recommend implementing javadocs for documenting helper methods.

### Code Decomposition
- Good to see the use of helper methods which is useful for code cleanliness, isolating individual problems and good code structure. This also shows that you have taken into consideration the importance of code decomposition by taking complex ideas and concepts and breaking them down into simpler blocks of code, thereby achieving your goal/task.
- You have structured your code nicely and is appropriately ordered in the order of its use and when it is being called.
  
### Java Code Conventions
- Variables and methods are appropriately named where the first letter of the first word is lower case, and the first letter of all subsequent words are uppercase.
- This is consistently seen throughout ALL variables and methods which is good practice.
  
### Suggestions
- You use "Integer.parseInt(String.valueOf(gameString.charAt..." on multiple occasions. This is quite long and could be complex for a reader to comprehend. I would recommend introducing a variable with a short name that you can call whenever you want to write "Integer.parseInt(String.valueOf(gameString.charAt...".
- in the fullPiece helper method, there is lots of code duplication from line 911 - 1087 with the repetition of if statements.
    While there are slight variations from each line, I would recommend spending some time and see if you can recognise a pattern forming within each if-statement and develop some sort of calculation/formula that you could apply into a for loop. This could save you lots of lines and make this helper method alot more short and succinct.
- Your fullPiece helper method currently gets the strings of all stars into an array of String. Is it is possible to modify this method so the same could be done for wizards? Having this form of variation may prove to be useful in later tasks.
  
- Overall, great code. It is clearly commented and well-documented for a new reader to navigate through your code without getting confused. I have recommended some suggestions in possibly optimising your code in some ways. Thanks!


