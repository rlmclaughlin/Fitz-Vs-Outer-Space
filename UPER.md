<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
    
    I will need to create a game that keeps track of multiple states, features a coherent objective, and abides
to a set of rules. I intend to use a GUI, so my problem will also require attention to a visual element. Along
the way, testing will play a crucial role, as well as OOD practices. These could act as a guide for the upcoming 
methods I need to build and how to properly organize it. 

My game shall feature a Cat as the main character. This cat will need to avoid various objects along the way. 
If the cat makes contact with the objects, then it will lose a point from a "lives" field. I will also keep 
a score that keeps track of how many objects were avoided. The goal will be to get as many points as possible,
before all of the characters lives are exhausted. Additional features will likely come to mind once the coding process
begins. 

It's important that I make something interesting but not too complicated considering there's only a week, and
I have no previous experience with a GUI. 

Another part of the problem that is worth consideration is that I will need some type of way
to create my characters and the setting.

This problem will require Java, Maven, JUnit, and a GUI. 



<h2>
    2. Planning the Solution
</h2>

For the visual aspect of the game, I intend to mainly utilize AWT. I understand that it's a heavy weight 
component, however, after conducting exhaustive research, AWT's syntax feels the most comfortable and 
realistic. I find the various methods built within the classes to be entirely intuitive and easy to remember. 
I need something that I can intuit quickly due to the limited time available. 

For the first day or two, I don't even plan on touching the capstone project. Instead, i'm going to invest
all of my time studying and mastering awt. I want to ensure that I have a strong understanding of it before
I begin. My goal for those first two days is to make a very simplified mock version of the capstone game, so
I can see if my objective is realistic. 

I intend to build out a diagram that maps each step of the way and will illustrate how I intend to knock out each 
class, one by one. My initial plan is to pursue this from a TDD approach, however, if this becomes an obstacle 
on the road to completion, i intend to abort early into the process. 

******You'll find the diagrams that are mentioned above in the ______ folder. 

<h2>
    3. Executing the Plan
</h2>
    I began my plan by spending two days practicing AWT and swing. I built a mock project that simply consisted 
of a square and flat line to represent the surface. I then proceeded to emulate the gravitational effect
on jumps, collision detection, key stroke acknowledgement, and basic implementation of graphics with awt. 

Once I gained a comfort with AWT, I started my project two days later. I was able to make progress at a decent pace
due to the immense time I spent practicing awt. Creating my frame, implementing my objects and creating the
jump effect were all quite easy considering I had just practiced this concepts. 

The biggest challenge was unexpected. The challenge was creating the moving effect that propells the game
forward. I had a lot of issues getting my moonSurface frames to fluidly adjust. The first problem was that there
were gaps in the frames, which exposed a huge white hole. Once I solved that, I needed to match up the surface
edges of my moon picture, so that it would keep a fluidity when one frame ended and another began. This was
as simple as adjusting my picture in pixel art, implementing it, and finding the right balance through trial and error. 

The final part of my game consisted of adding state to the mix, and an instructions section. I found 
the addition of state to be fairly straight forward. However, I did have a minor bug with the score at one point. 
Each time I jumped over an object, it would accumulate the points for the entire duration of the jump. I ended
up writing a function that awarded the point after it checked if the cat had fully crossed the obstacle, if so,
one point was given. This ended up solving that problem. 

The last part of my journey was/has been refactoring and improving my code. admittedly, AWT has made my code appear "long winded",
but to its credit, the syntax was very easy to comprehend and utilize. While it's a heavyweight component, 
it makes up for its shortcomings in readability. I'm glad I ended up choosing it to complete my project. 

<h2>
    4. Reflection / Refactor
</h2>
    The vast majority of my final commits have been refactoring attempts. There is still room for improvement,
but the functionality is there, so i'm slightly timid to make any drastic revisions. 

Of the revisions that I have made, there were three main targets that were adjusted:

1) Code that was no longer being used, due to earlier refactoring. 
2) Cleaning up conditionals and fixing "first-iteration-code" into something more coherent.
3) Adjusting variables that were "final". 

I had a lot of code that needed to be deleted, due to essentially lingering after adjusting earlier iterations 
of code that had later become obsolete. I cleaned all of this useless code after the presentation and
none of it currently remains. 

Cleaning up my switch statements were a crucial part of refactoring. Admittedly, they were something
of a mess at first. I was simply trying to get my code to work in the short time I had available. Once I 
was successful at attaining that objective, I was too timid to make any major adjustments before the 
presentation. Following the presentation, I refactored one of the switch statements into a simiple
if statement. It was much more coherent and easier to read, once finished. I also have a giant switch
statement that is responsible for the game controls. I cleaned up the log in parts of that statement too. 
by using the && operators, I was able to delete some pointless lines of code. 

Finally, I had several variables that needed to be updated to final. This is something I routinely wait
to do until the very end of a project. This was swimmingly easy to accomplish. 

In retrospect, i'm really proud of what I accomplished in a week. I spent everyday, from anywhere between 12-14
hours working on this project in some form. Whether it was planning, creating pixel art, learning awt, or
actually coding, I optimized all of my time wisely and ensured i'd have a full spectrum project. 

I'm most proud of the originality of my game. While many people elect to create games that already exist,
I wanted to create something that was unique and original. All of the art was drawn and created by me, the 
concept and features were all ideas that I developed, and plan of execution was in my own custom style. 

While my code is a bit heavy due to awt, I have no regrets and think I was able to produce a solid
product in less than a week. Having no Java experience, prior to Tekcamp, I think it's really incredible what 
I was able to do with only 4 weeks of knowledge. It was a ton of fun and I fully intend to continue
building games and awt, even as we progress forward. 