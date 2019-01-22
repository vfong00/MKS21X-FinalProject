# MKS21X-FinalProject

## So like, what is this thing?
An attempt to make a roguelike game. <br/>
Here is a Wikipedia article that explains one: https://en.wikipedia.org/wiki/Roguelike <br/>
TL;DR? Dungeon-maze game. <br/>
This game features:
- A menu, with the most impressive of all logos
- Random terrain generation of dungeons
- Scary monsters with somewhat scary-looking sprites
- Cool items dispersed everywhere
- A nameable player that you will surely love
- Levels! Progressing monsters! It goes forever! (or until you die or get tired or something)
- The communist hammer and sickle.

## But like, how do you even start the game?
#### Windows
lol

#### OS X/Linux
Download this repo <br/>
With your terminal, go to the folder where you put this repo. <br/>
Copy and paste the following lines, and enter: <br/>
chmod +x compile.sh  <br/>
./compile.sh  <br/>
Start slaying

## Ok and like, how do you play?
** MENU ** <br/>
Move up/down options with W/S, respectively <br/>
Space to select option in the menu <br/>
'q' to go back (if you didn't choose play)

** IN GAME ** <br/>
WASD to move <br/>
'p' to generate new dungeon   <br/>
'q' to quit  <br/>
To attack/collect, simply walk over what you want to interact with.

## Anything else?
Try to find the easter egg!

## devlog- moody
### 01-05-19
Day one of serious coding. Very little was done with the Lanterna library. Rather,
I focused on working on the underlying data structure. The code Vincent wrote used
the upper layer terminal graphics to handle logic was more of a proof of concept
so today was spent revamping Entity-Maze interactions at a lower level.

This involved me making the Tileable interface, which applies to anything that can
"exist". This was made as a workaround to the original plan of using a null object
to denote empty spaces. Lanterna stops execution if a null is attempted to print to
terminal.

I also moved a bunch of stuff into their own specific directory, while making setting
the class path a pain, it's a one time task typing it in and keeps the class logic
much more cohesive.

The next big step was to create one instance of the maze, and linking all the Entities
to this one instance of maze. Now asking a Player to move somewhere will update the
internal Player fields _and_ it's location in the map.

Air was also created. This is necessary because we had originally defined for
collision to work with other Entities, so all the empty spaces need _something_
not an Entity to move onto.

The majority of the work today is to ease up development later down the line.

edit: yeah the branch is called terrainGeneration but the refactoring was more
pressing in my opinion. I'll do the dungeon generation tomorrow :P

edit 2: quick idea, instead of having the player do nothing to collided entities
in the form of walls, have the player deal damage to all impacted entities and give
walls either impossibly high health or a regeneration factor (or not and make the
environment destructible)

~moody

## devlog- moody
### 01-06-19
Terrain generation! I used a seperate data structure to handle the generation, and
copied over the output of that into the maze, rather than having the maze serve both
purposes at once.

## devlog- moody
### 01-07-19
Ported into screen, moved relevant generationFunctions into MazeGeneration

## devlog- moody
### 01-08-19
big dead lmao

## devlog- moody
### 01-09-19
Vincent worked on monsters, funny bug where monsters would not die, but become
moving Air tiles.

## devlog- moody
### 01-10-19
There were some issues in the branch screenPort where the terrainGeneration would
print onto the terminal, but the underlying data structure of terrainGeneration
would intermix with the proper terrain. This led to me making a new brach to work
ground up, from the point where terrain generation last worked, and immediately start
moving that work into Screen. After that was sorted out, I began moving around
functions into their respective objects.

## devlog- moody
### 01-19-19
A lot of the recent work was on Vincent, so today is my serious jump into what
Vincent left me. <br/>
Blessed be the CS gods for such a great partner <3  <br/>
I've been putting some time into the Menu, and tried a bunch of implementations
because the inital Lanterna idea did not work at all. After four or five attempts,
(jcurses, cliche, system scanner, etc), I sat down and seriously redid the lanterna
implementation. It worked! w and s increments and decrements the option value with
then gets modded and shifted to match the option location.

I've also been working on procedural item and entity placement, as evident by the
PlacerFactory object.

## devlog- moody
### 01-20-19
Vincent put some good time into making the individual monsters better, so today
was on the PlacerFactory object. It randomly picks Air's in the game and spawns
monsters there. It also stores all the instances of monsters and makes mass actions
much easier to facilitate. I structured it so PlacerFactory can work on any
Tileable.

## devlog- moody
### 01-21-19
Last day coding grind. I worked on the final cherry on top aspect of the project,
the PlacerFactory. This automates placing monsters, armor, weapons, health items,
and the Stair. PlacerFactory also has an array with all the Monsters, to mass call
nextMove() on them. I gave the XP field a use, to scale player damage and act as the
final score. No AI. That's beyond the scope of this project and the time constraints.
Finally I made the death screen, a simple message with the score.

## devlog - Vincent
### 01-04-19
+ made extremely basic files (Nethack game file, Entity abstract class, Player)
+ found way to place interactive 'walls' within terminal
We are looking to integrate the underlying maze array and the terminal in some way.
Moody's working to create maze generation, and a better way than a crude Object[][].
I will be out until Sunday, as I have an all-day event to be at on Saturday.

### 01-06-19
- slept in, didn't do coding
+ discussed with Moody -- we decided to stick with dynamic updating, where the objects update their terminal position (as opposed to going through the maze array every time)
Also struggling a little with git branching; some of my files were missing for no apparent reason

### 01-07-19
- was big dead from studying for test; did no work besides that done in class (which wasn't much, because of the headache I had)

### 01-08-19
+ made Monster class, with movement
+ made an engage function, that lets player deal with monster
+ in Nethack, made a monster list, akin to calling a set of patches in Netlogo

One thing that isn't that great is the current implementation of attacking. Because of it, there are HP functions in Tileable, which doesn't fit with the purpose of the interface. Moody is thinking of a way to make it better.

### 01-09-19
- tried to make print function work, to no success (keeps disappearing)
+ fixed a bug where Monster wouldn't completely disappear after death (would roam as an air tile)

### 01-10-19
+ created collectible abstract class, and a working example (a weapon)
+ created terminal printing of player actions (such as collecting collectibles, fighting monsters)

### 01-11-19 and 01-12-19
I was on a trip on Saturday, and I spent most of Sunday recovering.

### 01-13-19
+ made status bar at bottom
+ added random hitting
+ added defense attributes
+ added armor collectible

### 01-14-19
+ did not commit, but started research into textCharacters and terminal things

### 01-15-19
+ switched out char fields for TextCharacters
+ made walls a little more snazzy

### 01-16-18
+ wrote a stairs class, that transports you to a newly generated level
+ cleaned up code with helper functions
+ wrote in xp levels and floor level counter, which is now seen in game
+ made the golden shield look like a shield (but not gold). also made other characters cooler

### 01-20-18
I haven't been doing much the past few days, as Moody's been working on his menu.
The project is pretty much what we expected it to be? A big, expansive thing that I totally
did not see coming?

I wrote javadocs, the readme, and an easter egg. That was fun.
