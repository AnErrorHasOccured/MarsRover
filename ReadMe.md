
# Mars Rover in Scala ↑ x

This is my mars rover challange in scala.
below a simple summary of how it work.

It compose by a terrain, obstacles and a spaceship. Something like that:

```
_________________________
|   |   |   |   |   |   |
|   |   |   |   |   | X |
|___|___|___|___|___|___|
|   |   |   |   |   |   |
|   |   | ↑ |   |   | X |
|___|___|___|___|___|___|
|   |   |   |   |   |   |
|   |   |   |   |   | X |
|___|___|___|___|___|___|

```

The spaceship has the purpose to don't impact with the obstacles. if it done that the game end.

Some features:

* If spaceship reachs the border of terrain it can move with pacman rule.
* We can pass as argument the terrain lenght, terrain height and the number of obstacles
* To move the spaceship enter (r -> right, l -> left, u -> up, d - > down). If the position match
with the move the spaceship will moves else will set the position.

***IMPORTANT!***
**I Know that the code can be write better, as ever! you can suggest me how via PullRequest. You can refactor parts of code or Implement new features.**
**That's all folks :)**