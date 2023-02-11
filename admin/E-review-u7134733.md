## Code Review

Reviewed by: Benjamin Pope, u7134733

Reviewing code written by: Shafin Kamal u7124035

Component: IQStars.checkColourOrder()

### Comments 

####What are the best features?
There is a very consistent style through the entire program, this makes it extremely easy to read as a coder and a computer.
The best feature of the program is its ability to be used in multiple functions. A few small lines changing the increment
value at the start of the method turns this into something more polymorphic. This separates the code into smaller
chunks and eliminates need for repetitions of the code.\
This also reduces problems when debugging programs that are reliant on the checkColourOrder() method. The 
checkWizardPlacement() and checkPiecePlacement() methods both use checkColourOrder() to ensure the gameString is
formatted correctly; by separating the helper method here, it can reassure that any bugs/errors that we may be
experiencing are coming from either the checkWizardPlacement() or checkPiecePlacement() methods.

####Is the code well documented?
Great effort has been taken to ensure that all major blocks-of-code within the program have corresponding comments.
This has also been extended to the declarations of new variables. In the large switch statement towards the end of the
program, comments have also been added to justify (and remind) how the pieces are to be arranged.

####Is the program decomposition (Class and method structure) appropriate?
In terms of where this program sits within the IQStars class, it has been put close to the top (Just beneath
the checkPiecePlacement()) method. I think this is appropriate as this helper method is used other programs. However, it is 
still sandwiched between some unrelated code. The checkWizardPlacement() method is the other method that currently
implements checkColourOrder() — both the checkWizardPlacement() and checkPiecePlacement() methods' primary implementation 
is the isGameStateStringWellFormed() method — it would make more sense to have them grouped
together (with checkColourOrder() as an earlier method).\
Looking at the structure of the program itself, there is definitely more appropriate processes that  could be used. This 
program functions brilliantly, however the long conditionals and switch statements do make it harder to debug, as there is
a larger possibility of mistyping. A method similar to that seen in Lab08 (CropRotation.canFollow()), could be used to ensure 
the correct ROYGBIP order, also utilising a 'for' loop to run through an array that stores the first char of each pieceString.

####Does it follow Java code conventions and is the style consistent?
The style is very consistent, however there are a few small tweaks that could be made to keep it more
orthodox. Due to the long conditionals, there are the occasional run-on-lines that could be condensed using some different
structuring, as suggested above. A few small adjustments could be made to reduce code blocks and run on lines(e.g lines 332-334 with a for loop).


####If you suspect an error, give the situation where it would arise.
Having studied this code, I do not suspect any errors.
