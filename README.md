# COMP55 Project

I will work on the implementation of dynamically loading information into the game pertaining to the boss.
Currently the game has a boss level, where there lies a single line of enemies and a boss that moves left to right constantly. I would like to give the player an option to input the number of enemies there exists in the boss level, the ability to increase player bullet speed, as well as the option of loading your own image onto the boss! This will allow the player to customize their game and increase the difficult of the boss level. Along with this implementation, I would like to remove bad code/fix bugs that are present in the current code.

PSEUDOCODE
----------
For File Reading Class(used for FILE I/O):
Create scanner/variables needed
run Scan Function()
	*Scan Line
	Store Input into bulletSpeed variable
	If bulletSpeed is larger/smaller than min/max
		set value to valid input
	Endif
	*Scan Line
	Store Input into enemyLines variable
	If number of enemy lines is larger/smaller than min/max
		set value to valid input
	Endif
	*Scan Line
	Store input into bossImage
EndFunction
Create getFunctions to retrieve variables

For Game Class:
Create fileReader object/variables needed
inputScannerInformation Function()
	set bulletSpeed to scanner.getBulletSpeed()
	set enemyLines to scanner.getEnemyLines()
	set bossImage to scanner.getBossImage()
EndFunction
Add variables to parameters used to create enemy/player as needed

STEPS
-----
1) Open assets/fileIO/customizeGame.txt
2) Enter the desired customization under each description (enter numbers in lines 2,4,6,8)
3) To change boss photo:
	*find 128x128 png/gif/jpg photo(must be 128x128!)
	*download photo and move this file to assets/sprites folder
	*in line 10 of customizeGame.txt(under the description of boss image), enter the name of your photo! If incorrectly entered name, program will fail to load picture!
**AVAILABLE SPRITES ALREADY DOWNLOADED INTO FOLDER**
boss.gif
Creeper-icon.png
	